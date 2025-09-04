package com.example.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.backend.security.JwtUtil;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationRepository repo;
    private final JwtUtil jwtUtil; // 추가
    private final List<SseEmitter> emitters = new ArrayList<>();

    public ReservationController(ReservationRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    // 예약 목록 조회
    @GetMapping
    public List<Reservation> getAll() {
        return repo.findAll();
    }

    // 예약하기
    @PostMapping
    public ResponseEntity<?> reserve(@RequestBody Reservation request) {
        if (repo.existsBySeatNo(request.getSeatNo())) {
            return ResponseEntity.badRequest().body("이미 예약된 좌석입니다.");
        }
        Reservation saved = repo.save(request);
        notifyClients(saved);
        return ResponseEntity.ok(saved);
    }

    // SSE: 실시간 알림
    //접속한 사용자를 추가하고, 접속해제시 사용자를 제거하는 작업
    //접속된 사용자는 
    @GetMapping("/subscribe")
    public SseEmitter subscribe(@RequestParam String token) {
        try {
            String username = jwtUtil.validateTokenAndGetUsername(token);
            if (username == null) throw new RuntimeException("토큰 인증 실패");

            SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
            emitters.add(emitter);
            emitter.onCompletion(() -> emitters.remove(emitter));
            emitter.onTimeout(() -> emitters.remove(emitter));
            return emitter;

        } catch (Exception e) {
            throw new RuntimeException("토큰 인증 실패");
        }
    }

    //예약을 저장한 후 프론트에 등록된 reservation이름의 이벤트를 발생하게하여
    //프론트에서 addEventListener("reservation")된 함수를 처리하는 작업
    //모든 연결된 사용자에게 발송
    private void notifyClients(Reservation r) {
        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event().name("reservation").data(r));
            } catch (IOException e) {
                deadEmitters.add(emitter);
            }
        });
        emitters.removeAll(deadEmitters);
    }
}

package com.example.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationRepository repo;
    private final List<SseEmitter> emitters = new ArrayList<>();

    public ReservationController(ReservationRepository repo) {
        this.repo = repo;
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
    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

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

package com.example.demo;

import java.util.ArrayList;import java.util.List;import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    final SiteUserResposity resp;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email:"+email);
        Optional<SiteUser> ouser = resp.findByEmail(email);
       
       if (ouser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        SiteUser user = ouser.get();
        
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}

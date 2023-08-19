package org.grooveshare.playlist.security;

import lombok.RequiredArgsConstructor;
import org.grooveshare.playlist.data.models.UserEntity;
import org.grooveshare.playlist.data.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
        return AuthenticatedUser.builder()
                .user(user)
                .roles(user.getRoles())
                .build();
    }

}

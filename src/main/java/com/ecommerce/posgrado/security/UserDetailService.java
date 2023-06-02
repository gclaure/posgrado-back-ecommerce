package com.ecommerce.posgrado.security;

import com.ecommerce.posgrado.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author gclaure from CochaSoft
 * Date: 5/29/23
 * Time: 20:13
 * Project Name: posgrado
 */
@Service
public class UserDetailService implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with provided email"));

    }
}

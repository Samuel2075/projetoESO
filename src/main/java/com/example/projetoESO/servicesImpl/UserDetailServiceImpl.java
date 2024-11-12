package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.auth.UserAuthenticated;
import com.example.projetoESO.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(UserAuthenticated::new).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}

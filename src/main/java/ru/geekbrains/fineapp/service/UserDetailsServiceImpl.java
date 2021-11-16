package ru.geekbrains.fineapp.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.fineapp.entity.User;
import ru.geekbrains.fineapp.repository.RoleRepository;
import ru.geekbrains.fineapp.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> mayBeUser = userRepository.findByEmail(username);
        if (mayBeUser.isEmpty()) {
            throw new UsernameNotFoundException("User doesn't exist");
        }

        User user = mayBeUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .toList()
        );
    }
}

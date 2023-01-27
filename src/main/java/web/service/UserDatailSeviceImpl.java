package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.dao_services.UserServiceImp;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserServiceImp userService;
    private final PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(UserServiceImp userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findUserByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}

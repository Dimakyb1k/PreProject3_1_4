package ru.kata.spring.boot_security.demo.init;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class DBInitializer {
    private final UserService userService;
    private final UserRepository userRepository;

    private final RoleRepository roleService;
    public DBInitializer(UserService userService,
                         UserRepository userRepository, RoleRepository roleService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }
    @Transactional
    @PostConstruct
    public void initDB() {
        roleService.save(new Role(1L,"ROLE_ADMIN"));
        roleService.save(new Role(2L,"ROLE_USER"));
        userService.saveUser(new User(1L,"$2y$10$zl2x/5wTLzHO0rBJZGCg9e5NjJQogO9yNm9M7cH4EJl.6duT3Jssy","admin","admin",27,"admin",Set.of(new Role(1L))));
//        userService.saveUser(new User("user", "user@test.com", (byte) 25,
//                "user", Set.of(new Role(2L, "USER"))));
        //пaроль 111 ;)
    }
}

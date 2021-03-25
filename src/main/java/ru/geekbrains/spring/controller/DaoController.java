package ru.geekbrains.spring.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.entities.User;
import ru.geekbrains.spring.model.ProductDto;
import ru.geekbrains.spring.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@Profile("dao")
@Slf4j
@RequiredArgsConstructor
public class DaoController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderController orderController;

    @GetMapping("/app/score/get/current")
    public String current(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : score = " + user.getScore();
    }


    @GetMapping("/app/score/get/{id}")
    public Optional<User> userId(@PathVariable Long id){
        return userService.userId(id);
    }

    @GetMapping("/dao")
    public List<ProductDto> daoTestPage(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
       // return "authenticated: " + user.getUsername() + " : score = " + user.getScore();
        return orderController.getProductOrder(user.getId());
    }


}

package com.mateuslgomes.security.demo;

import com.mateuslgomes.security.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@AllArgsConstructor
public class DemoController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> sayHelloUser() {
        var user = userService.getUserAuthenticated();
        return ResponseEntity.ok("Hello " + user.firstName() + ", this is a user endpoint | You are a "
                + user.role().name() );
    }

    @GetMapping("/admin")
    public ResponseEntity<String> sayHelloAdmin() {
        var user = userService.getUserAuthenticated();
        return ResponseEntity.ok("Hello" + user.firstName() + " this is a Admin endpoint | You are a " +
                user.role().name());
    }

}

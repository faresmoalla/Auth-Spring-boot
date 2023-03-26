package tn.opengov.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.opengov.spring.entity.Role;
import tn.opengov.spring.entity.User;
import tn.opengov.spring.service.UserService;
@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
public class HomeController {
@Autowired
UserService userService;
@PostMapping("/registration")
public User createNewUser( @RequestBody User user) {
	User u;
User userExists = userService.findUserByUserName(user.getUserName());
if (userExists != null) {
u=userExists;
} else {
u=userService.saveUser(user);

}

return u; }
@GetMapping("/login")
public Principal login(Principal principal) {
     
     
    return principal;
}
}
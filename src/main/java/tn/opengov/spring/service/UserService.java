package tn.opengov.spring.service;





import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.opengov.spring.entity.Role;
import tn.opengov.spring.entity.RoleName;
import tn.opengov.spring.entity.User;
import tn.opengov.spring.repository.RoleRepository;
import tn.opengov.spring.repository.UserRepository;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private RoleRepository roleRepo;

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
public User findUserByUserName(String userName) {
return userRepository.findByUserName(userName);
}
public User saveUser(User user) {
Role e =new Role(RoleName.ADMIN);

user.setActive(true);
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

user.setRole(e);
return userRepository.save(user); }}

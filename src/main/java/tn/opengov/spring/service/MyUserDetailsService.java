package tn.opengov.spring.service;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.opengov.spring.entity.Role;
import tn.opengov.spring.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
private UserService userService;
@Override
@Transactional
public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
User user = userService.findUserByUserName(userName);
List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
return new org.springframework.security.core.userdetails.User(user.getUserName(),
user.getPassword(),user.getActive(), true, true, true, authorities); }
private List<GrantedAuthority> getUserAuthority(Role userRoles) {
Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

roles.add(new SimpleGrantedAuthority(userRoles.getRole().toString())); 
List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
return grantedAuthorities;
}
public User findbyusername(String username) {
	return userService.findUserByUserName(username);
}

}

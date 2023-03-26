package tn.opengov.spring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.opengov.spring.entity.FileDB;
import tn.opengov.spring.entity.Role;
import tn.opengov.spring.entity.RoleName;
import tn.opengov.spring.entity.User;
import tn.opengov.spring.repository.FileDBRepository;
import tn.opengov.spring.repository.UserRepository;
@Service
public class UserServiceImpl   {
	@Autowired
	UserRepository userRepo;
	@Autowired
	FileDBRepository fileRepo;


	public User inscription(User user) {
		 return userRepo.save(user);
	}


	public User updateUser(User user, Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		u.setUserName(user.getUserName());
		u.setTel(user.getTel());
		u.setRole(user.getRole());
		u.setEmail(user.getEmail());
		

		
		
		return userRepo.save(u);
		
	}

	
	public void deleteUser(Long idUser) {

		userRepo.deleteById(idUser);;
		
	}

	
	public User affichDetailUser(Long idUser) {
		return userRepo.findById(idUser).orElse(null);
	}


	public List<User> affichUser() {
		return userRepo.findAll();
	}

	public User findbyusername(String username) {
		return userRepo.findByUserName(username);
	}


	public User affcterfileauuser(Long iduser,Long idfile) {
		User u = userRepo.findById(iduser).orElse(null);
		FileDB f = fileRepo.findById(idfile).orElse(null);
		f.getUser().add(u);
		fileRepo.save(f);
		return u;
	}

}

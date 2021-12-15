package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;



@RequestMapping("/users")
@RestController

public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")

	public List<User> getAll() {
		List<User> user = userRepo.findAll();
	    return users;
	}
	
	@PostMapping("/")
	public User create(@RequestBody User user) {
	    return userRepo.save(user);
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable(value = "id") Long Id) {
	    return userRepo.findById(Id).orElseThrow(null);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable(value = "id") Long Id, @RequestBody @Valid UserDto userDetails) {

		User user = userRepo.findById(Id).orElseThrow(() -> new NotFoundException("not found"));
		User user = (new User());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepo.save(user);
	    return updatedUser;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Id) {
		User user = userRepo.findById(Id).orElseThrow(() -> new NotFoundException("not found"));
		userRepo.delete(user);

	    return ResponseEntity.ok().build();
	}
}

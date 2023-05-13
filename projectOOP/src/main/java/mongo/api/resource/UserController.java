package mongo.api.resource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import mongo.api.model.User;
import mongo.api.repository.UserRepository;
@RestController
public class UserController {
	@Autowired
	private UserRepository Repository;
	@PostMapping("/addUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
	Optional<User> optionalUser = Repository.findById(user.getid());
	if (optionalUser.isPresent()) {
	return ResponseEntity.badRequest().body("User with ID " + user.getid() + " already exists.");
	} else {
	Repository.save(user);
	return ResponseEntity.ok().body("Added User with ID: " + user.getid());
	}
	}
	@GetMapping("/findAllUsers")
	public List<User> getUser(){
	return Repository.findAll();
	}
	@GetMapping("/findAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id){
	return Repository.findById(id);
	}
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
	Optional<User> user = Repository.findById(id);
	if (user.isPresent()) {
	Repository.deleteById(id);
	return "User deleted with ID: " + id;
	} else {
	return "No User with ID: " + id;
	}
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
	boolean exists = Repository.existsById(id);
	if (!exists) {
	return ResponseEntity.badRequest().body("The user does not exist with id: " + id);
	}
	Optional<User> optionalUser = Repository.findById(id);
	User user1 = optionalUser.orElse(null);
	user1.setUsername(user.getUsername());
	user1.setPassword(user.getPassword());
	user1.setEmail(user.getEmail());
	Repository.save(user1);
	return ResponseEntity.ok("user updated with id: " + id);
	}
	
}

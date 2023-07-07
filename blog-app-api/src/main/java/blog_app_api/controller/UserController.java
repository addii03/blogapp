package blog_app_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog_app_api.helper.UserHelper;
import blog_app_api.request.UserRequest;
import blog_app_api.responce.UserResponce;
import blog_app_api.servicee.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserHelper userHelper;
	@Autowired
	UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserResponce> saveUsers(@RequestBody UserRequest userRequest) {
		return new ResponseEntity<UserResponce>(userService.saveUsers(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserResponce> getById(@PathVariable Integer id) {
		return new ResponseEntity<UserResponce>(userService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<UserResponce> getAll()

	{
		return userService.getAll();
	}

	@DeleteMapping("/delete/{id}")

	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted", HttpStatus.OK);
	}

}

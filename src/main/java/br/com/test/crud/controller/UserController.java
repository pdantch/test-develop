package br.com.test.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.test.crud.entity.User;
import br.com.test.crud.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> save(@RequestParam("photography") MultipartFile photography,
			@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("birthday") String birthday) throws IOException {
		return ResponseEntity.ok().body(service.save(new User(null, code, name, birthday, photography.getBytes())));
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestParam("photography") MultipartFile photography,
			@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("birthday") String birthday, @PathVariable Long id) throws IOException {
		User newUser = new User(id, code, name, birthday, photography.getBytes());
		return ResponseEntity.ok().body(service.update(newUser));
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> list() {
		return ResponseEntity.ok(service.getList());
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}

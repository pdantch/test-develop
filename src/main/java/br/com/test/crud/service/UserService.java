package br.com.test.crud.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.crud.entity.User;
import br.com.test.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User save(User user) throws IOException {
		return repository.save(user);
	}

	public List<User> getList() {
		return repository.findAll();
	}

	public User update(User user) throws IOException {
		User newUser = getUserById(user.getId());
		if (newUser != null) {
			newUser.setName(user.getName());
			newUser.setCode(user.getCode());
			newUser.setBirthday(user.getBirthday());
			newUser.setPhotography(user.getPhotography());
		}
		return save(user);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public User getUserById(Long id) {
		Optional<User> userOptional = repository.findById(id);
		return userOptional.isPresent() ? userOptional.get() : null;
	}
}

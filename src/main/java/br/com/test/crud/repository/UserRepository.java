package br.com.test.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.test.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

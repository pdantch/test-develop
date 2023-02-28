package br.com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

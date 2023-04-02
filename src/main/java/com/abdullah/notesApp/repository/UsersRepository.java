package com.abdullah.notesApp.repository;

import com.abdullah.notesApp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}

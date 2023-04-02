package com.abdullah.notesApp.repository;

import com.abdullah.notesApp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username LIKE %?1%")
    List<User> findByUsername(String username);
}

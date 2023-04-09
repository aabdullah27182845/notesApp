package com.abdullah.notesApp.repository;

import com.abdullah.notesApp.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username LIKE %?1%")
    List<User> findByUsername(String username);

//    @Query("INSERT u INTO User(u.user_id, u.username, u.password, u.role) VALUES (:user_id, :username, :password, :role)")
//    @Modifying
//    @Override
//    <S extends User> S save(@Param("user_id") S entity);
}

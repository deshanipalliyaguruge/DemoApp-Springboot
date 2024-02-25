package com.desh.demoApp.repository;

import com.desh.demoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE ID=?1",nativeQuery = true)
    User getUserByUserId(String userId);

}

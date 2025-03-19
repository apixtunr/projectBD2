package com.dbproject.pixtun.alm14.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbproject.pixtun.alm14.model.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    Optional<UserData> findById(Integer id);
    Optional<UserData> findByUserNameAndPassword(String userName, String password);
}


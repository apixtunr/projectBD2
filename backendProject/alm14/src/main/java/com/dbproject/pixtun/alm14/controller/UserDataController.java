package com.dbproject.pixtun.alm14.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbproject.pixtun.alm14.model.entity.UserData;
import com.dbproject.pixtun.alm14.service.UserDataService;


@RestController
@CrossOrigin(origins = {"http://localhost:5545", "https://localhost:9090"})
public class UserDataController {
    @Autowired
    private UserDataService UserDataService;

    @GetMapping("/api/list_userData")
    public List<UserData> getAllUserData() {
        return UserDataService.getAllUserData();
    }

    @GetMapping("/api/list_userData_id")
    public UserData getUserDatasByIdRequestParam(@RequestParam("id") Integer userDataId) {
    // Lógica para obtener el usuario por su ID utilizando el servicio UserDataService
    Optional<UserData> userDataOptional = UserDataService.findById(userDataId);
    return userDataOptional.orElse(null);
}

@GetMapping("/api/list_userData_id/{id}") 
    public UserData getUserDataByIdPathVariable(@PathVariable("id") Integer userDataId) {
        Optional<UserData> userDataOptional = UserDataService.findById(userDataId);
        return userDataOptional.orElse(null);
    }

    @PostMapping("/api/create_userData")
    public UserData createUserData(@RequestBody UserData userData) {
        return UserDataService.save(userData);
    }

    @PutMapping("/api/userData/{id}")
    public UserData updateUserData(@PathVariable("id") Integer userDataId, @RequestBody UserData updatedUserData) {
        // Lógica para buscar y actualizar un usuario existente utilizando el servicio UserDataService
        Optional<UserData> userDataOptional = UserDataService.findById(userDataId);
        if (userDataOptional.isPresent()) {
            UserData userData = userDataOptional.get();
            userData.setUserName(updatedUserData.getUserName());
            userData.setPassword(updatedUserData.getPassword());
            userData.setRole(updatedUserData.getRole());
            userData.setPrivileges(updatedUserData.getPrivileges());
            userData.setUserSchema(updatedUserData.getUserSchema());
            userData.setStatus(updatedUserData.getStatus());
            return UserDataService.save(userData);
        } else {
            return null; 
        }
    }

    @DeleteMapping("/api/UserData/{id}")
    public void deleteUserData(@PathVariable("id") Integer userDataId) {
    Optional<UserData> userDataOptional = UserDataService.findById(userDataId);
    userDataOptional.ifPresent(UserDataService::delete);
}

@PostMapping("/api/userData/login")
    public UserData login(@RequestBody UserData UserData) {
        return UserDataService.login(UserData);
    }
}

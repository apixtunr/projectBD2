package com.dbproject.pixtun.alm14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbproject.pixtun.alm14.model.entity.UserData;
import com.dbproject.pixtun.alm14.model.repository.UserDataRepository;


@Service
public class UserDataService {
    private final UserDataRepository UserDataRepository;

    public UserDataService(UserDataRepository UserDataRepository)
    {
        this.UserDataRepository=UserDataRepository;
    }
    public List<UserData> getAllUserData()
    {
        return (List<UserData>) UserDataRepository.findAll();
    }
    public Optional<UserData> findById(Integer par_id) {
        return UserDataRepository.findById(par_id);
    }
    public UserData save(UserData par_usuario) {
        return UserDataRepository.save(par_usuario);
    }
    public void delete(UserData par_usuario) {
         UserDataRepository.delete(par_usuario);
        }

        public UserData login(UserData UserData){
            Optional<UserData> listUserData = UserDataRepository.findByUserNameAndPassword(UserData.getUserName(),UserData.getPassword());
            UserData UserDataReturn = null;
    
            if(!listUserData.isEmpty()){
                UserDataReturn = listUserData.get();
            }
            return UserDataReturn;
        }
}

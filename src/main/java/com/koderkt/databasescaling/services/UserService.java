package com.koderkt.databasescaling.services;


import com.koderkt.databasescaling.models.User;
import com.koderkt.databasescaling.repositories.UserReadRepository;
import com.koderkt.databasescaling.repositories.UserWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserWriteRepository writeRepository;

    @Autowired
    private UserReadRepository readRepository;

    public User createUser(User user) {
        return writeRepository.saveData(user);
    }

    public User getUserByName(String name) {
        return readRepository.getData(name);
    }
}

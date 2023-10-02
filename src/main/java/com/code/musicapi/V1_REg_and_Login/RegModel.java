package com.code.musicapi.V1_REg_and_Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegModel {
    @Autowired
    RegRepo rp;

    public String Register(RegEntity re) {
        Optional<RegEntity> existingUser = rp.findByEmail(re.getEmail());

        if (existingUser.isPresent()) {
            return "Email is already registered";
        }

        rp.save(re);
        return "Registration Done Successfully";
    }
    public String login(LoginEntity loginEntity) {
        Optional<RegEntity> user = rp.findByEmail(loginEntity.getEmail());

        if (user.isPresent()) {
            RegEntity regEntity = user.get();
            if (regEntity.getPassword().equals(loginEntity.getPassword())) {
                return "Login Successful";
            } else {
                return "Invalid credentials";
            }
        } else {
            return "User not found";
        }
    }
}
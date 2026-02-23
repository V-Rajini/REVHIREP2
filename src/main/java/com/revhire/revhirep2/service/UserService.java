package com.revhire.revhirep2.service;

import com.revhire.revhirep2.entity.User;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> getUserByEmail(String email);

    void deactivateUser(Long userId);

    void updatePassword(Long userId, String newPassword);
}
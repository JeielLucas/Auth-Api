package com.jeiel.AuthAPI.Repositories;

import com.jeiel.AuthAPI.Domains.User.UserRole;

public record UserDTO(String id, String name, String email, String password, UserRole role) {
}

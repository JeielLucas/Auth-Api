package com.jeiel.AuthAPI.Repositories;

import com.jeiel.AuthAPI.Domains.User.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}

package com.nashtech.rookies.java05.AssetManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.rookies.java05.AssetManagement.dto.UserResponseDto;
import com.nashtech.rookies.java05.AssetManagement.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAll/{location}")
    public List<UserResponseDto> getAllUserSameLocation(@PathVariable String location) {
        return userService.getAllUserSameLocation(location);
    }
}

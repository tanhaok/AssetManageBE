package com.nashtech.rookies.java05.AssetManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nashtech.rookies.java05.AssetManagement.dto.request.SignupRequest;
import com.nashtech.rookies.java05.AssetManagement.dto.response.AllUserResponse;
import com.nashtech.rookies.java05.AssetManagement.dto.response.UserDetailResponse;
import com.nashtech.rookies.java05.AssetManagement.dto.response.UserResponse;

@Service
public interface UserService {
    
	public UserResponse createUser(SignupRequest signupRequest);

    public List<UserDetailResponse> getAllUserSameLocation(String location);

    public AllUserResponse searchUser(String content, String location);
}

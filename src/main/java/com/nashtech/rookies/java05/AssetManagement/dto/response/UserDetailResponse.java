package com.nashtech.rookies.java05.AssetManagement.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nashtech.rookies.java05.AssetManagement.model.entity.Information;
import com.nashtech.rookies.java05.AssetManagement.model.entity.User;
import com.nashtech.rookies.java05.AssetManagement.model.enums.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDetailResponse {
    private String staffCode;
    private String fullName;
    private String username;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date joinedDate;
    private UserRole role;
    private String location;

    /**
     * @param staffCode   id of user
     * @param fullName    = firstName + LastName
     * @param username
     * @param dateOfBirth
     * @param gender
     * @param joinedDay
     * @param role
     * @param location
     */
    public UserDetailResponse(String staffCode, String fullName, String username, Date dateOfBirth, String gender,
            Date joinedDay, UserRole role, String location) {
        this.staffCode = staffCode;
        this.fullName = fullName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.joinedDate = joinedDay;
        this.role = role;
        this.location = location;
    }

    public static UserDetailResponse build(User user) {
        String fullName = user.getInformation().getFirstName() + " " + user.getInformation().getLastName();
        String gender = user.getInformation().isGender() ? "Male" : "Female";
        return new UserDetailResponse(user.getId(),
                fullName,
                user.getUserName(),
                user.getInformation().getDateOfBirth(),
                gender,
                user.getInformation().getJoinedDate(),
                user.getRole().getName(),
                user.getInformation().getLocation());
    }

    public static UserDetailResponse buildFromInfo(Information info) {
        String fullName = info.getFirstName() + " " + info.getLastName();

        String gender = info.isGender() ? "Male" : "Female";
        return new UserDetailResponse(info.getUser().getId(),
                fullName,
                info.getUser().getUserName(),
                info.getUser().getInformation().getDateOfBirth(),
                gender,
                info.getUser().getInformation().getJoinedDate(),
                info.getUser().getRole().getName(),
                info.getUser().getInformation().getLocation());
    }
}
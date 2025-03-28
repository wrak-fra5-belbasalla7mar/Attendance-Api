package com.wrak_fra5_belbasalla7mar.Attendance_Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private  int userId;
    private String name;
    private String department;
}

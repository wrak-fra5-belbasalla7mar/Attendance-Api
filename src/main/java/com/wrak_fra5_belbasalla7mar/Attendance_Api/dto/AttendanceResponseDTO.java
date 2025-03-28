package com.wrak_fra5_belbasalla7mar.Attendance_Api.dto;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AttendanceResponseDTO {
    private UserDTO userDTO;
    private LocalDate attendanceDate;
    private LocationStatus locationStatus;
}

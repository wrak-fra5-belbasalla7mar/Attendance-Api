package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceId {
    private int userId;
    private LocalDate attendance_date;

}

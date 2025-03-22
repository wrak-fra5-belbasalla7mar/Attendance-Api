package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {
    @EmbeddedId
    private AttendanceId id;
    private LocalTime arrival;
    private LocalTime departure;

    @Enumerated(EnumType.STRING)
    private LocationStatus location;


}

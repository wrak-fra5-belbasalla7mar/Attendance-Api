package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {
private int userId;
private LocalDate attendance_date;
private LocalTime arrival ;
private LocalTime departure;

@Enumerated(EnumType.STRING)
private LocationStatus location;


}

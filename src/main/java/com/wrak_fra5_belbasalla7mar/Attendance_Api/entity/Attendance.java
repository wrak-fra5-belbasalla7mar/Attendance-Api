package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "attendance")
public class Attendance {
    @EmbeddedId
    private AttendanceId id;
    @Column(name = "arrival")
    private LocalTime arrival;
    @Column(name = "departure")
    private LocalTime departure;
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private LocationStatus location;
    public Attendance(int userId,LocalDate attendance_date){
        this.id=new AttendanceId(userId,attendance_date);
    }
}

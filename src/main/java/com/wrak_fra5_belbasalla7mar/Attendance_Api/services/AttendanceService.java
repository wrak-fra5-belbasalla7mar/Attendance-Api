package com.wrak_fra5_belbasalla7mar.Attendance_Api.services;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.AttendanceId;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    public AttendanceService(AttendanceRepository attendanceRepository){
        this.attendanceRepository = attendanceRepository;
    }
    public Attendance setDailyStatus(int userId, LocationStatus locationStatus){
        Attendance attendance = attendanceRepository.findById(new AttendanceId(userId,LocalDate.now()))
                .orElse(new Attendance(userId,LocalDate.now()));
        attendance.setLocation(locationStatus);
        return attendanceRepository.save(attendance);
    }
}

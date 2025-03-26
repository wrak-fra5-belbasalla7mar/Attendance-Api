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
    public void setDailyStatus(int userId, LocationStatus locationStatus){
        AttendanceId attendanceId = new AttendanceId(userId, LocalDate.now());
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElse(new Attendance(userId,LocalDate.now()));
        attendance.setLocation(locationStatus);
        attendanceRepository.save(attendance);
    }
    //funtion get status for the day
    public Attendance getDailyStatus(int userId){
        AttendanceId attendanceId = new AttendanceId(userId, LocalDate.now());
        return attendanceRepository.findById(attendanceId)
                .orElseGet(()->{
                    Attendance attendance= new Attendance(userId,LocalDate.now());
                    attendance.setLocation(LocationStatus.Absent);
                    return attendance;
                });
    }


    //function get status for week

}

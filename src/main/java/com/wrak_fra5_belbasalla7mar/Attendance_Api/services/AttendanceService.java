package com.wrak_fra5_belbasalla7mar.Attendance_Api.services;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.AttendanceId;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public Attendance getDailyStatus(int userId){
        AttendanceId attendanceId = new AttendanceId(userId, LocalDate.now());
        return attendanceRepository.findById(attendanceId)
                .orElseGet(()->{
                    Attendance attendance= new Attendance(userId,LocalDate.now());
                    attendance.setLocation(LocationStatus.Absent);
                    return attendance;
                });
    }
    public List<Attendance> getWeeklyAttendance(int userId){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        return attendanceRepository.findAttendanceBetweenDates(userId,startDate,endDate);

    }


}

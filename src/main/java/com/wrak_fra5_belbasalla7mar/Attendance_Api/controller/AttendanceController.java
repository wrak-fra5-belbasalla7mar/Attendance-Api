package com.wrak_fra5_belbasalla7mar.Attendance_Api.controller;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.services.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }
    @PostMapping
    public ResponseEntity<String>setAttendance(@RequestParam int userId,
                                               @RequestParam LocationStatus locationStatus){
        attendanceService.setDailyStatus(userId,locationStatus);
        return ResponseEntity.ok("Attendance recorded successfully!");
    }
}

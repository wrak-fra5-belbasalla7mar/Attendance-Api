package com.wrak_fra5_belbasalla7mar.Attendance_Api.controller;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.services.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }
    @PostMapping("/set-status")
    public ResponseEntity<String>setAttendance(@RequestParam int userId,
                                               @RequestParam LocationStatus locationStatus){
        attendanceService.setDailyStatus(userId,locationStatus);
        return ResponseEntity.ok("Attendance recorded successfully!");
    }
    @GetMapping("/daily-status")
    public ResponseEntity<Attendance>getDailyStatus(@RequestParam int userId){
        Attendance attendance = attendanceService.getDailyStatus(userId);
        return ResponseEntity.ok(attendance);
    }
}

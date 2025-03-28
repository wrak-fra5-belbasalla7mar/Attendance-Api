package com.wrak_fra5_belbasalla7mar.Attendance_Api.services;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.dto.AttendanceResponseDTO;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.dto.UserDTO;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.AttendanceId;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.LocationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final WebClient webClient = WebClient.create("http://localhost:8081/employee");
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
    public AttendanceResponseDTO getDailyStatus(int userId){
        AttendanceId attendanceId = new AttendanceId(userId, LocalDate.now());
        Attendance attendance= attendanceRepository.findById(attendanceId)
                .orElse(new Attendance(userId,LocalDate.now()));
        attendance.setLocation(LocationStatus.Absent);
        UserDTO user = fetchUserDetails(userId);
        List<Attendance> attendanceList = new ArrayList<>();
        attendanceList.add(attendance);
        return new AttendanceResponseDTO(user,attendanceList);
    }
    public AttendanceResponseDTO getWeeklyAttendance(int userId){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        List<Attendance> attendanceList = attendanceRepository.findAttendanceBetweenDates(userId,startDate,endDate);
        UserDTO user = fetchUserDetails(userId);
        return new AttendanceResponseDTO(user,attendanceList);
    }
    private UserDTO fetchUserDetails(int userId){
        return webClient.get()
                .uri("/find?id="+userId)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block();
    }


}

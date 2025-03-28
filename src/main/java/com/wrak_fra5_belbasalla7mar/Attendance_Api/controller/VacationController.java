package com.wrak_fra5_belbasalla7mar.Attendance_Api.controller;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.VacationRequest;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.services.VacationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }
    @PostMapping("/request")
    public ResponseEntity<String> requestVacation(@RequestParam int userId,
                                                  @RequestParam LocalDate startDate,
                                                  @RequestParam LocalDate endDate) {
         vacationService.requestVacation(userId,startDate,endDate);
         return ResponseEntity.ok("request is submitted successfully");
    }
    @PostMapping("/approve-vacation")
    public ResponseEntity<String> approveVacation(@RequestParam int requestId){
        vacationService.approveVacation(requestId);
        return ResponseEntity.ok("request is approved successfully");
    }
    @PostMapping("/reject-vacation")
    public ResponseEntity<String> rejectVacation(@RequestParam int requestId){
        vacationService.rejectVacation(requestId);
        return ResponseEntity.ok("request is rejected successfully");
    }



}

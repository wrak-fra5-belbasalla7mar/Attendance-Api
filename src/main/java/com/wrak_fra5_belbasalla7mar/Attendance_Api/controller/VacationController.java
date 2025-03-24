package com.wrak_fra5_belbasalla7mar.Attendance_Api.controller;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.services.VacationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacation")
public class VacationController {
    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }
}

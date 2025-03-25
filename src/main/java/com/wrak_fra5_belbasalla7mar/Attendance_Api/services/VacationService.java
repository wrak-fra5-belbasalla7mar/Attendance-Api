package com.wrak_fra5_belbasalla7mar.Attendance_Api.services;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationService {
    private final VacationRepository vacationRepository;
    @Autowired
    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }



}

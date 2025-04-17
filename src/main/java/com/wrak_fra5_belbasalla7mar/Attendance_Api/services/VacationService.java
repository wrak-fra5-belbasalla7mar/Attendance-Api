package com.wrak_fra5_belbasalla7mar.Attendance_Api.services;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.VacationRequest;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.VacationStatus;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationService {
    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }
    public void requestVacation(int userId, LocalDate startDate,LocalDate endDate){
        VacationRequest vacationRequest = new VacationRequest(userId,startDate,endDate,VacationStatus.PENDING);
        vacationRepository.save(vacationRequest);
    }
    public VacationRequest approveVacation(int requestId) {
        VacationRequest vacationRequest = vacationRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Vacation request not found"));
        vacationRequest.setVacationStatus(VacationStatus.APPROVED);
        return vacationRepository.save(vacationRequest);
    }
    public VacationRequest rejectVacation(int requestId) {
        VacationRequest vacationRequest = vacationRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Vacation request not found"));
        vacationRequest.setVacationStatus(VacationStatus.REJECTED);
        return vacationRepository.save(vacationRequest);
    }

    public List<VacationRequest> getAllVacations(){
        return vacationRepository.findAll();
    }

    public List<VacationRequest> getAllByUserId(int id){
        return vacationRepository.findAllByUserId(id);
    }






}

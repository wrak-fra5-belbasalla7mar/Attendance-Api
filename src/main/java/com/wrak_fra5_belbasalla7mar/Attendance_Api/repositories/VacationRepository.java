package com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.VacationRequest;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.VacationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<VacationRequest,Integer> {
    List<VacationRequest> findByUserId(int userId);
}

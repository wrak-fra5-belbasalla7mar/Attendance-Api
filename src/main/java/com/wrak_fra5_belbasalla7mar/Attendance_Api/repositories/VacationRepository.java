package com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends JpaRepository<VacationRequest,Integer> {

}

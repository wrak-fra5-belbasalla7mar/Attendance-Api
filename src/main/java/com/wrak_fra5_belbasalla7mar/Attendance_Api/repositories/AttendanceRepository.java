package com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
    Optional<Attendance>findByUserIdDate(int userid, LocalDate date);
    List<Attendance> findUserIdAndDateBetween(int userId,LocalDate startDate, LocalDate endDate );
}

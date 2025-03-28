package com.wrak_fra5_belbasalla7mar.Attendance_Api.repositories;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.Attendance;
import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
    @Query("SELECT a FROM Attendance a WHERE a.id.userId = :userId AND a.id.attendanceDate BETWEEN :startDate AND :endDate")    List<Attendance> findAttendanceBetweenDates(
            @Param("userId") int userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}

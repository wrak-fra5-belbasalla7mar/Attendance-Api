package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.VacationStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vacationrequest")
@Data
public class VacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int teamId;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private VacationStatus statusType;
}

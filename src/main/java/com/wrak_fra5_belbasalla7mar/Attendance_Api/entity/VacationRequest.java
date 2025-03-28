package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import com.wrak_fra5_belbasalla7mar.Attendance_Api.entity.enums.VacationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vacationrequest")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private int requestId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "vacation_status")
    private VacationStatus vacationStatus;

    public VacationRequest(int userId, LocalDate startDate, LocalDate endDate, VacationStatus vacationStatus) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationStatus = vacationStatus;
    }
}

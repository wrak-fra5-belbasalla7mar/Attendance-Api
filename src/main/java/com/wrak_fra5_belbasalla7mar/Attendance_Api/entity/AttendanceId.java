package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class AttendanceId implements Serializable {
    @Column(name = "userId")
    private int userId;
    @Column(name = "attendance_date")
    private LocalDate attendance_date;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(LocalDate attendance_date) {
        this.attendance_date = attendance_date;
    }

    public AttendanceId(int userId,LocalDate attendance_date){
        this.userId=userId;
        this.attendance_date=attendance_date;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceId that = (AttendanceId) o;
        return userId==that.userId && Objects.equals(attendance_date, that.attendance_date);
    }
    @Override
    public int hashCode(){
        return Objects.hash(userId,attendance_date);
    }
}

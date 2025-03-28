package com.wrak_fra5_belbasalla7mar.Attendance_Api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Data
@NoArgsConstructor
@Embeddable
public class AttendanceId implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public AttendanceId(int userId,LocalDate attendance_date){
        this.userId=userId;
        this.attendanceDate =attendance_date;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceId that = (AttendanceId) o;
        return userId==that.userId && Objects.equals(attendanceDate, that.attendanceDate);
    }
    @Override
    public int hashCode(){
        return Objects.hash(userId, attendanceDate);
    }
}

package rco.bai5.model;

import java.sql.Date;

public class Doctor {
    private String doctorId;
    private String fullName;
    private String specialization;
    private Date dutyDate;

    public Doctor() {
    }

    public Doctor(String doctorId, String fullName, String specialization, Date dutyDate) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialization = specialization;
        this.dutyDate = dutyDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Date getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }
}

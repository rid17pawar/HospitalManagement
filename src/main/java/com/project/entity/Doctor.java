package com.project.entity;

public class Doctor {
    private String doctorId;
    private String doctorName;

    public String getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return doctorName;
    }

    public void setName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}

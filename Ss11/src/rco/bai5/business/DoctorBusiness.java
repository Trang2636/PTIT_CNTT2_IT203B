package rco.bai5.business;
import rco.bai5.dao.DoctorDAO;
import rco.bai5.model.Doctor;

import java.util.List;

public class DoctorBusiness {
    public List<Doctor> getAllDoctors() {
        return DoctorDAO.findAll();
    }
    public boolean addDoctor(Doctor doctor) {
        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
            System.out.println("Ma bac si khong duoc de trong.");
            return false;
        }
        if (doctor.getFullName() == null || doctor.getFullName().trim().isEmpty()) {
            System.out.println("Ho ten khong duoc de trong.");
            return false;
        }
        if (doctor.getSpecialization() == null || doctor.getSpecialization().trim().isEmpty()) {
            System.out.println("Chuyen khoa khong duoc de trong.");
            return false;
        }
        if (doctor.getSpecialization().length() > 50) {
            System.out.println("Chuyen khoa qua dai.");
            return false;
        }
        return DoctorDAO.insertDoctor(doctor);
    }
    public void statisticDoctorsBySpecialization() {
        DoctorDAO.statisticBySpecialization();
    }
}
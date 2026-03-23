package com.re.business.bai5.Service;

import com.re.business.bai5.DAO.PatientDAO;
import com.re.business.bai5.Entity.Patient;

import java.util.List;

public class PatientService {
    private PatientDAO dao = new PatientDAO();

    public void showAll() {
        List<Patient> list = dao.getAll();
        for (Patient p : list) {
            System.out.printf("%-5d %-20s %-5d %-15s%n",
                    p.getId(), p.getName(), p.getAge(), p.getDepartment());
        }
    }

    public void add(Patient p) {
        dao.insert(p);
    }

    public void updateDisease(int id, String disease) {
        dao.updateDisease(id, disease);
    }

    public void discharge(int id) {
        double fee = dao.discharge(id);
        System.out.println("Tổng viện phí: " + fee);
    }
}

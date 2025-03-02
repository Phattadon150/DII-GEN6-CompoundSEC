package gui;

import manager.PatientManager;
import manager.FloorAccessManager;
import manager.CardManager;
import model.DoctorCard;
import model.Patient;

import javax.swing.*;
import java.util.List;

public class PatientSelectionGUI {
    public PatientSelectionGUI(String doctorID, PatientManager patientManager, CardManager cardManager, FloorAccessManager floorManager) {
        JFrame frame = new JFrame("Select Patient & Check Floor Access");
        frame.setSize(450, 300);
        JPanel panel = new JPanel();
        frame.add(panel);

        // 🔹 ดึงข้อมูลคนไข้ทั้งหมด
        List<Patient> patients = patientManager.getAllPatients();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Patient patient : patients) {
            model.addElement(patient.getId() + ": " + patient.getName());
        }

        JComboBox<String> patientList = new JComboBox<>(model);
        JButton selectButton = new JButton("Select Patient");
        JButton checkAccessButton = new JButton("Check Floor Access");

        JTextArea resultArea = new JTextArea(6, 35);
        resultArea.setEditable(false);

        // 🔹 เมื่อเลือกคนไข้
        selectButton.addActionListener(e -> {
            int selectedIndex = patientList.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a patient!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Patient selectedPatient = patients.get(selectedIndex);
            selectedPatient.assignDoctor(doctorID);
            resultArea.setText("Doctor " + doctorID + " selected patient " + selectedPatient.getName());
        });

        // 🔹 เมื่อเช็คห้องที่เข้าได้
        checkAccessButton.addActionListener(e -> {
            DoctorCard doctorCard = cardManager.getCard(doctorID);
            if (doctorCard == null) {
                resultArea.setText("Doctor ID not found.");
                return;
            }

            StringBuilder accessInfo = new StringBuilder("Doctor " + doctorID + " can access floors:\n");
            for (int floor = 1; floor <= 4; floor++) {
                if (floorManager.canAccess(floor, doctorCard.getRole())) {
                    accessInfo.append("- Floor ").append(floor).append("\n");
                }
            }
            resultArea.setText(accessInfo.toString());
        });

        panel.add(new JLabel("Select Patient:"));
        panel.add(patientList);
        panel.add(selectButton);
        panel.add(checkAccessButton);
        panel.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }
}

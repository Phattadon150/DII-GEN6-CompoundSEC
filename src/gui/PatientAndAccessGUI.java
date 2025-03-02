package gui;

import manager.PatientManager;
import manager.FloorAccessManager;
import manager.CardManager;
import model.DoctorCard;
import model.Patient;

import javax.swing.*;
import java.util.List;

public class PatientAndAccessGUI {
    public PatientAndAccessGUI(String doctorID, PatientManager patientManager, CardManager cardManager, FloorAccessManager floorManager) {
        JFrame frame = new JFrame("Select Patient & Check Floor Access");
        frame.setSize(500, 350);
        JPanel panel = new JPanel();
        frame.add(panel);

        // 🔹 เลือกคนไข้
        List<Patient> patients = patientManager.getAllPatients();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Patient patient : patients) {
            model.addElement(patient.getId() + ": " + patient.getName());
        }

        JComboBox<String> patientList = new JComboBox<>(model);
        JButton selectPatientButton = new JButton("Select Patient");

        // 🔹 กรอกเลขชั้น
        JLabel floorLabel = new JLabel("Enter Floor (1-4):");
        JTextField floorField = new JTextField(5);
        JButton checkAccessButton = new JButton("Check Floor Access");

        JTextArea resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);

        // 🔹 เมื่อเลือกคนไข้
        selectPatientButton.addActionListener(e -> {
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
            int floor;
            try {
                floor = Integer.parseInt(floorField.getText().trim());
                if (floor < 1 || floor > 4) {
                    JOptionPane.showMessageDialog(frame, "Invalid Floor! Please enter a number between 1-4", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Floor Number! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DoctorCard card = cardManager.getCard(doctorID);
            if (card == null) {
                resultArea.setText("❌ Access Denied! No such Doctor ID.");
            } else if (floorManager.canAccess(floor, card.getRole())) {
                resultArea.setText("✅ Access Granted! Doctor " + doctorID + " can enter Floor " + floor);
            } else {
                resultArea.setText("❌ Access Denied! Doctor " + doctorID + " cannot enter Floor " + floor);
            }
        });

        panel.add(new JLabel("Select Patient:"));
        panel.add(patientList);
        panel.add(selectPatientButton);
        panel.add(floorLabel);
        panel.add(floorField);
        panel.add(checkAccessButton);
        panel.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }
}

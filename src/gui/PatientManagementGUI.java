package gui;

import manager.PatientManager;
import model.Patient;

import javax.swing.*;
import java.awt.*;

public class PatientManagementGUI {
    private PatientManager patientManager;
    private JFrame frame;
    private JTextField patientIDField, nameField, appointmentField, symptomsField;
    private JTextArea displayArea;

    public PatientManagementGUI(PatientManager patientManager) {
        this.patientManager = patientManager;

        frame = new JFrame("Patient Management");
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // **Row 1: Patient ID**
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Patient ID:"), gbc);
        gbc.gridx = 1;
        patientIDField = new JTextField(10);
        frame.add(patientIDField, gbc);

        // **Row 2: Name**
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Patient Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(15);
        frame.add(nameField, gbc);

        // **Row 3: Appointment Time**
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(new JLabel("Appointment Time:"), gbc);
        gbc.gridx = 1;
        appointmentField = new JTextField(10);
        frame.add(appointmentField, gbc);

        // **Row 4: Symptoms**
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(new JLabel("Symptoms:"), gbc);
        gbc.gridx = 1;
        symptomsField = new JTextField(20);
        frame.add(symptomsField, gbc);

        // **Row 5: Buttons**
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addPatientButton = new JButton("Add Patient");
        JButton revokePatientButton = new JButton("Revoke Patient");
        JButton showPatientsButton = new JButton("Show Patients");

        buttonPanel.add(addPatientButton);
        buttonPanel.add(revokePatientButton);
        buttonPanel.add(showPatientsButton);
        frame.add(buttonPanel, gbc);

        // **Row 6: Display Area**
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        displayArea = new JTextArea(10, 50);
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), gbc);

        // **Button Actions**
        addPatientButton.addActionListener(e -> addPatient());
        revokePatientButton.addActionListener(e -> revokePatient());
        showPatientsButton.addActionListener(e -> showPatients());

        frame.setVisible(true);
    }

    private void addPatient() {
        String patientID = patientIDField.getText().trim();
        String name = nameField.getText().trim();
        String appointmentTime = appointmentField.getText().trim();
        String symptoms = symptomsField.getText().trim();

        if (patientID.isEmpty() || name.isEmpty() || appointmentTime.isEmpty() || symptoms.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        patientManager.addPatient(patientID, name, appointmentTime, symptoms);
        JOptionPane.showMessageDialog(frame, "Patient " + name + " added successfully!");
        showPatients(); // ✅ อัปเดต UI
    }

    private void revokePatient() {
        String patientID = patientIDField.getText().trim();

        if (!patientManager.revokePatient(patientID)) {
            JOptionPane.showMessageDialog(frame, "Patient not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Patient " + patientID + " removed successfully!");
            showPatients(); // ✅ อัปเดต UI
        }
    }

    private void showPatients() {
        StringBuilder sb = new StringBuilder("Patients List:\n");
        for (Patient p : patientManager.getAllPatients()) {
            sb.append(p.getId()).append(" - ").append(p.getName())
                    .append(", Appointment: ").append(p.getAppointmentTime())
                    .append(", Symptoms: ").append(p.getSymptoms()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}

package gui;

import model.Patient;
import javax.swing.*;
import java.awt.*;

public class PrescribeMedicationGUI {
    public PrescribeMedicationGUI(Patient patient) {
        JFrame frame = new JFrame("Prescribe Medication: " + patient.getName());
        frame.setSize(400, 250);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // **Row 1: Patient Name**
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Patient:"), gbc);
        gbc.gridx = 1;
        JTextField patientNameField = new JTextField(patient.getName(), 15);
        patientNameField.setEditable(false);
        frame.add(patientNameField, gbc);

        // **Row 2: Medication Name**
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Medication:"), gbc);
        gbc.gridx = 1;
        JTextField medicationField = new JTextField(15);
        frame.add(medicationField, gbc);

        // **Row 3: Dosage**
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(new JLabel("Dosage:"), gbc);
        gbc.gridx = 1;
        JTextField dosageField = new JTextField(15);
        frame.add(dosageField, gbc);

        // **Row 4: Save Button**
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        JButton saveButton = new JButton("Save Prescription");
        frame.add(saveButton, gbc);

        saveButton.addActionListener(e -> {
            String medication = medicationField.getText().trim();
            String dosage = dosageField.getText().trim();

            if (medication.isEmpty() || dosage.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(frame, "Prescription saved for " + patient.getName());
            frame.dispose();
        });

        frame.setVisible(true);
    }
}

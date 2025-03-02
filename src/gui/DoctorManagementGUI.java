package gui;

import manager.CardManager;
import model.Role;

import javax.swing.*;
import java.awt.*;

public class DoctorManagementGUI {
    private CardManager cardManager;
    private JFrame frame;
    private JTextField doctorIDField;
    private JComboBox<Role> roleDropdown;
    private JTextArea displayArea;

    public DoctorManagementGUI(CardManager cardManager) {
        this.cardManager = cardManager;

        frame = new JFrame("Doctor Management");
        frame.setSize(600, 350);
        frame.setLayout(new BorderLayout());

        // **Input Panel**
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Doctor ID:"));
        doctorIDField = new JTextField(10);
        inputPanel.add(doctorIDField);

        inputPanel.add(new JLabel("Role:"));
        roleDropdown = new JComboBox<>(Role.values());
        inputPanel.add(roleDropdown);

        frame.add(inputPanel, BorderLayout.NORTH);

        // **Button Panel**
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton modifyDoctorButton = new JButton("Modify Role");
        JButton revokeDoctorButton = new JButton("Revoke Doctor");
        JButton showDoctorsButton = new JButton("Show Doctors");

        buttonPanel.add(addDoctorButton);
        buttonPanel.add(modifyDoctorButton);
        buttonPanel.add(revokeDoctorButton);
        buttonPanel.add(showDoctorsButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // **Display Area**
        displayArea = new JTextArea(10, 50);
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // **Button Actions**
        addDoctorButton.addActionListener(e -> addDoctor());
        modifyDoctorButton.addActionListener(e -> modifyDoctor());
        revokeDoctorButton.addActionListener(e -> revokeDoctor());
        showDoctorsButton.addActionListener(e -> showDoctors());

        frame.setVisible(true);
    }

    private void addDoctor() {
        String doctorID = doctorIDField.getText().trim();
        Role role = (Role) roleDropdown.getSelectedItem();

        if (doctorID.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Doctor ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cardManager.issueCard(doctorID, role);
        JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " added as " + role + "!");
    }

    private void modifyDoctor() {
        String doctorID = doctorIDField.getText().trim();
        Role newRole = (Role) roleDropdown.getSelectedItem();

        if (cardManager.getCard(doctorID) == null) {
            JOptionPane.showMessageDialog(frame, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cardManager.modifyRole(doctorID, newRole);
        JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " updated to " + newRole + "!");
    }

    private void revokeDoctor() {
        String doctorID = doctorIDField.getText().trim();
        if (cardManager.getCard(doctorID) == null) {
            JOptionPane.showMessageDialog(frame, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cardManager.revokeCard(doctorID);
        JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " has been revoked!");
    }

    private void showDoctors() {
        StringBuilder sb = new StringBuilder("Current Doctors:\n");
        for (String doctorID : cardManager.getAllDoctorIDs()) {
            sb.append(doctorID).append(" - ").append(cardManager.getCard(doctorID).getRole()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}

package gui;

import manager.CardManager;
import model.Role;

import javax.swing.*;
import java.awt.*;

public class CardManagementGUI {
    private CardManager cardManager;
    private JFrame frame;
    private JTextField doctorIDField;
    private JComboBox<Role> roleDropdown;
    private JTextArea displayArea;

    public CardManagementGUI(CardManager cardManager) {
        this.cardManager = cardManager;

        frame = new JFrame("Card Management");
        frame.setSize(600, 350);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // **Row 1: Doctor ID**
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Doctor ID:"), gbc);
        gbc.gridx = 1;
        doctorIDField = new JTextField(10);
        frame.add(doctorIDField, gbc);

        // **Row 2: Role**
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Role:"), gbc);
        gbc.gridx = 1;
        roleDropdown = new JComboBox<>(Role.values());
        frame.add(roleDropdown, gbc);

        // **Row 3: Buttons**
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton modifyDoctorButton = new JButton("Modify Role");
        JButton revokeDoctorButton = new JButton("Revoke Doctor"); // ✅ ปุ่ม Revoke มาแล้ว!
        JButton showDoctorsButton = new JButton("Show Doctors");

        buttonPanel.add(addDoctorButton);
        buttonPanel.add(modifyDoctorButton);
        buttonPanel.add(revokeDoctorButton); // ✅ เพิ่มปุ่ม Revoke
        buttonPanel.add(showDoctorsButton);
        frame.add(buttonPanel, gbc);

        // **Row 4: Display Area**
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        displayArea = new JTextArea(10, 50);
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), gbc);

        // **Button Actions**
        addDoctorButton.addActionListener(e -> addDoctor());
        modifyDoctorButton.addActionListener(e -> modifyDoctor());
        revokeDoctorButton.addActionListener(e -> revokeDoctor()); // ✅ เชื่อมปุ่ม Revoke
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

    private void revokeDoctor() { // ✅ ฟังก์ชัน Revoke มาแล้ว!
        String doctorID = doctorIDField.getText().trim();
        if (!cardManager.revokeDoctor(doctorID)) {
            JOptionPane.showMessageDialog(frame, "Doctor not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " removed successfully!");
        }
    }

    private void showDoctors() {
        StringBuilder sb = new StringBuilder("Current Doctors:\n");
        for (String doctorID : cardManager.getAllDoctorIDs()) {
            sb.append(doctorID).append(" - ").append(cardManager.getCard(doctorID).getRole()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}

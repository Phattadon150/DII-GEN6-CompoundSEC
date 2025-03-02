package gui;

import manager.CardManager;
import model.Role;

import javax.swing.*;

public class AdminGUI {
    public AdminGUI(CardManager cardManager) {
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(500, 300);
        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("ID:");
        JTextField doctorIDField = new JTextField(10);
        JComboBox<Role> roleDropdown = new JComboBox<>(Role.values());

        JButton addButton = new JButton("Add ");
        JButton modifyButton = new JButton("Modify ");
        JButton revokeButton = new JButton("Revoke ");

        addButton.addActionListener(e -> {
            String doctorID = doctorIDField.getText().trim();
            Role role = (Role) roleDropdown.getSelectedItem();

            if (doctorID.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Doctor ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cardManager.getCard(doctorID) != null) {
                JOptionPane.showMessageDialog(frame, "Doctor ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cardManager.issueCard(doctorID, role);
            JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " added as " + role + "!");
        });

        modifyButton.addActionListener(e -> {
            String doctorID = doctorIDField.getText().trim();
            Role role = (Role) roleDropdown.getSelectedItem();

            if (cardManager.getCard(doctorID) == null) {
                JOptionPane.showMessageDialog(frame, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cardManager.modifyRole(doctorID, role);
            JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " role updated to " + role + "!");
        });

        revokeButton.addActionListener(e -> {
            String doctorID = doctorIDField.getText().trim();

            if (!cardManager.revokeDoctor(doctorID)) {
                JOptionPane.showMessageDialog(frame, "Doctor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Doctor " + doctorID + " has been revoked!");
            }
        });

        panel.add(label);
        panel.add(doctorIDField);
        panel.add(roleDropdown);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(revokeButton);
        frame.setVisible(true);
    }
}

package gui;

import manager.FloorAccessManager;
import manager.CardManager;
import model.DoctorCard;

import javax.swing.*;
import java.time.LocalTime;

public class AccessControlGUI {
    public AccessControlGUI(CardManager cardManager, FloorAccessManager floorManager) {
        JFrame frame = new JFrame("Access Control");
        frame.setSize(400, 250);
        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel idLabel = new JLabel("Doctor ID:");
        JTextField idField = new JTextField(10);
        JLabel floorLabel = new JLabel("Enter Floor (1-4):");
        JTextField floorField = new JTextField(5);
        JButton checkButton = new JButton("Check Access");

        JTextArea resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);

        checkButton.addActionListener(e -> {
            String doctorID = idField.getText().trim();
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
            } else if (!floorManager.isWithinAccessTime(card.getRole())) {
                LocalTime[] timeRestriction = floorManager.getRoleTimeRestriction(card.getRole());
                resultArea.setText("❌ Access Denied! Time Restriction.\nAllowed: " +
                        timeRestriction[0] + " - " + timeRestriction[1]);
            } else if (floorManager.canAccess(floor, card.getRole())) {
                resultArea.setText("✅ Access Granted! Doctor " + doctorID + " can enter Floor " + floor);
            } else {
                resultArea.setText("❌ Access Denied! Doctor " + doctorID + " cannot enter Floor " + floor);
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(floorLabel);
        panel.add(floorField);
        panel.add(checkButton);
        panel.add(new JScrollPane(resultArea));
        frame.setVisible(true);
    }
}

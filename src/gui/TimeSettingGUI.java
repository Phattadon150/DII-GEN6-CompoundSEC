package gui;

import manager.FloorAccessManager;
import model.Role;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class TimeSettingGUI {
    public TimeSettingGUI(FloorAccessManager floorManager) {
        JFrame frame = new JFrame("Set Access Time");
        frame.setSize(400, 250);
        JPanel panel = new JPanel(new GridLayout(4, 3, 5, 5));
        frame.add(panel);

        JComboBox<Role> roleDropdown = new JComboBox<>(Role.values());
        JTextField startTimeField = new JTextField("08:00");
        JTextField endTimeField = new JTextField("18:00");
        JButton setTimeButton = new JButton("Set Time");

        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        setTimeButton.addActionListener(e -> {
            Role selectedRole = (Role) roleDropdown.getSelectedItem();
            try {
                LocalTime startTime = LocalTime.parse(startTimeField.getText().trim());
                LocalTime endTime = LocalTime.parse(endTimeField.getText().trim());

                if (startTime.isAfter(endTime)) {
                    JOptionPane.showMessageDialog(frame, "Start time must be before end time!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                floorManager.setTimeRestriction(selectedRole, startTime, endTime);
                resultArea.setText("✅ Time Updated for " + selectedRole + "\nAllowed: " + startTime + " - " + endTime);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid time format! Use HH:mm", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel("Select Role:"));
        panel.add(roleDropdown);
        panel.add(new JLabel());

        panel.add(new JLabel("Start Time (HH:mm):"));
        panel.add(startTimeField);
        panel.add(new JLabel());

        panel.add(new JLabel("End Time (HH:mm):"));
        panel.add(endTimeField);
        panel.add(new JLabel());

        panel.add(setTimeButton);
        panel.add(new JScrollPane(resultArea));
        frame.setVisible(true);
    }
}

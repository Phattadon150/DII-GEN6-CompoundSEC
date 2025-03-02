package main;

import manager.PatientManager;
import manager.CardManager;
import manager.FloorAccessManager;
import gui.PatientManagementGUI;
import gui.CardManagementGUI;
import gui.AccessControlGUI;
import gui.TimeSettingGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // ✅ สร้างตัวจัดการ
        PatientManager patientManager = new PatientManager();
        CardManager cardManager = new CardManager();
        FloorAccessManager floorManager = new FloorAccessManager();

        // ✅ สร้างเมนูหลัก
        JFrame mainFrame = new JFrame("Main Menu");
        mainFrame.setSize(500, 350);
        JPanel panel = new JPanel();
        mainFrame.add(panel);

        JButton patientButton = new JButton("Open Patient Management");
        JButton cardButton = new JButton("Open Card Management");
        JButton accessButton = new JButton("Check Access With Time");
        JButton timeButton = new JButton("Set Access Time");

        patientButton.addActionListener(e -> new PatientManagementGUI(patientManager));
        cardButton.addActionListener(e -> new CardManagementGUI(cardManager));
        accessButton.addActionListener(e -> new AccessControlGUI(cardManager, floorManager));
        timeButton.addActionListener(e -> new TimeSettingGUI(floorManager));

        panel.add(patientButton);
        panel.add(cardButton);
        panel.add(accessButton);
        panel.add(timeButton);
        mainFrame.setVisible(true);
    }
}

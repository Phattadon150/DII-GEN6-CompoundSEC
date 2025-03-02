import javax.swing.*;

public class Main {
    private static CardManager cardManager = new CardManager();

    public static void main(String[] args) {
        cardManager.issueCard("D123", "Physician");

        JFrame frame = new JFrame("Patient Management System");
        frame.setSize(400, 200);
        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("Doctor ID:");
        JTextField doctorIDField = new JTextField(10);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String doctorID = doctorIDField.getText();
            if (cardManager.getCard(doctorID) != null && cardManager.getCard(doctorID).isActive()) {
                new PatientSelectionGUI(doctorID);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Doctor ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(doctorIDField);
        panel.add(loginButton);
        frame.setVisible(true);
    }
}

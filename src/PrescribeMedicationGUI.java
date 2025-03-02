import javax.swing.*;
import java.awt.*;

public class PrescribeMedicationGUI {
    public PrescribeMedicationGUI(String doctorID, Patient patient) {
        JFrame frame = new JFrame("Prescribe Medication: " + patient.getName());
        frame.setSize(400, 300);

        JLabel label = new JLabel("Prescribe for " + patient.getName());
        JTextArea notes = new JTextArea("Enter prescription notes here...");

        JButton saveButton = new JButton("Save Prescription");
        saveButton.addActionListener(e -> {
            String note = notes.getText();
            patient.addHistory("Doctor " + doctorID + " prescribed: " + note);

            AuditLog.log(doctorID, "Prescribe Medication to " + patient.getName(), true);
            JOptionPane.showMessageDialog(frame, "Prescription saved!");
            frame.dispose();
        });

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(new JScrollPane(notes), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

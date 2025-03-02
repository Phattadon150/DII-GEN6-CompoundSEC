import javax.swing.*;
import java.util.List;

public class PatientSelectionGUI {
    public PatientSelectionGUI(String doctorID) {
        JFrame frame = new JFrame("Select Patient");
        frame.setSize(400, 200);
        JPanel panel = new JPanel();
        frame.add(panel);

        List<Patient> patients = PatientManager.getAllPatients();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Patient patient : patients) {
            model.addElement(patient.getId() + ": " + patient.getName());
        }

        JComboBox<String> patientList = new JComboBox<>(model);
        JButton selectButton = new JButton("Select Patient");

        selectButton.addActionListener(e -> {
            int selectedIndex = patientList.getSelectedIndex();
            Patient selectedPatient = patients.get(selectedIndex);

            new PrescribeMedicationGUI(doctorID, selectedPatient);
            frame.dispose();
        });

        panel.add(patientList);
        panel.add(selectButton);
        frame.setVisible(true);
    }
}

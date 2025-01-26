import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaylistGUI {

    private Playlist playlist;
    private JTextArea playlistArea;

    public PlaylistGUI(Playlist playlist) {
        this.playlist = playlist;

        JFrame frame = new JFrame("Playlist Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        playlistArea = new JTextArea();
        playlistArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playlistArea);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add Song");
        panel.add(addButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(frame, "Enter Song Title:");
                String artist = JOptionPane.showInputDialog(frame, "Enter Song Artist:");
                String durationString = JOptionPane.showInputDialog(frame, "Enter Song Duration (in minutes):");

                try {
                    double duration = Double.parseDouble(durationString);
                    if (title != null && artist != null && !title.trim().isEmpty() && !artist.trim().isEmpty()) {
                        Song song = new Song(title, artist, duration);
                        playlist.addSong(song);
                        updatePlaylistDisplay();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid duration.");
                }
            }
        });

        frame.setVisible(true);
    }

    public void updatePlaylistDisplay() {
        playlistArea.setText(playlist.getPlaylistDetails());
    }
}

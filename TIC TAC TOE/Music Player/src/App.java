
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jaco.mp3.player.MP3Player;

public class App extends JFrame implements ActionListener {

    JLabel t;
    JButton t1;
    JButton t2;
    JButton t3;

    public App() {
        t = new JLabel("MY MUSIC PLAYER\n");
        t1 = new JButton("Play");
        t2 = new JButton("Pause");
        t3 = new JButton("Stop");

        add(t);
        add(t1);
        add(t2);
        add(t3);

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static final String SONG = "//home//prathviraj//Music//saluthillave.mp3";
    MP3Player mp3player = new MP3Player(new File(SONG));

    @SuppressWarnings("Unchecked")

    public void t1actionPerformed(ActionEvent evt) {
        mp3player.play();
    }

    public void t2actionPerformed(ActionEvent evt) {
        mp3player.pause();
    }

    public void t3actionPerformed(ActionEvent evt) {
        mp3player.stop();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

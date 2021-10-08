package frontEnds;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class players extends frontEndUtil {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public players() {
        prepareGUI();
    }

    public static void main(String[] args) {

        // System.out.println(tictactoeFrontEnd.BACKGROUND_COLOR);
        players players = new players();
        players.showButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("TIC TAC TOE");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(BACKGROUND_COLOR);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        statusLabel.setBackground(BACKGROUND_COLOR);
        statusLabel.setFont(fontReMachine);
        statusLabel.setForeground(TEXT_COLOR);
        headerLabel.setBackground(BACKGROUND_COLOR);
        headerLabel.setForeground(TEXT_COLOR);

        controlPanel = new JPanel();
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public void showButtonDemo() {
        statusLabel.setText("Made with Love");
        headerLabel.setText("Choose the Players");
        headerLabel.setFont(fontHelsky2);
        JButton single = new JButton("Single Player");
        single.setBackground(X_COLOR);
        single.setFont(fontNewsPaper2);
        single.setFocusable(false);

        JButton multi = new JButton("Multi Player");
        multi.setBackground(O_COLOR);
        multi.setFont(fontNewsPaper2);
        multi.setFocusable(false);

        single.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mode modeObj = new mode();
                modeObj.showButtonDemo();
            }
        });
        multi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                tictactoe f = new tictactoe(false, false);
            }
        });
        controlPanel.add(single);
        controlPanel.add(multi);
        mainFrame.setVisible(true);
    }
}

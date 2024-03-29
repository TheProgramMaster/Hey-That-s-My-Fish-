package Build;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.net.URL;
public class MainMenu extends javax.swing.JFrame implements ActionListener{
    private JButton onePlayerButton = new JButton("One Player");
    private JButton twoPlayerButton = new JButton("Two Players");
    public MainMenu() throws IOException{
        URL backgroundImageURL = new URL("https://m.media-amazon.com/images/S/aplus-media/vc/f886c95f-470b-4f1f-bf6d-3ee40f65ed93._CR0,0,970,300_PT0_SX970__.jpg");
        Image img = ImageIO.read(backgroundImageURL);
        //Found code from https://stackoverflow.com/questions/21356609/set-an-image-as-background-to-jframe
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        JLabel background = new JLabel(new ImageIcon(img));
        background.setLayout(new FlowLayout());
        JLabel label = new JLabel("Made by Gavin, Kapil, and Maria!");
        onePlayerButton.addActionListener(this);
        twoPlayerButton.addActionListener(this);
        background.add(onePlayerButton);
        background.add(twoPlayerButton);
        background.add(label);
        buttonPanel.add(background);
        //setSize(500,500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        buttonPanel.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT));
        add(buttonPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws IOException{
        MainMenu mainMenu = new MainMenu();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == onePlayerButton){
            System.out.println("You have selected to play a one-player game!");
            dispose();
        }else if(e.getSource() == twoPlayerButton){
            System.out.println("You have selected to play a two player game!");
            dispose();
            TwoPlayerGameScreen two = new TwoPlayerGameScreen();
        }
    }
}
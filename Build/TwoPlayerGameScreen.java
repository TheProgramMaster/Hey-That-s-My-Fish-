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
public class TwoPlayerGameScreen extends JFrame{
    public TwoPlayerGameScreen(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //public static void main(String[] args){
    //    TwoPlayerGameScreen newScreen = new TwoPlayerGameScreen();
    //}
}
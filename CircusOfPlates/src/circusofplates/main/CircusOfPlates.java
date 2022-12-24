/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package circusofplates.main;

import com.sun.tools.javac.Main;
import game.component.PanelGame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author AhmedAbdelwahed
 */
public class CircusOfPlates extends JFrame {

    /**
     * @param args the command line arguments
     */
    public CircusOfPlates() {
        init();
    }
    private void init()
    {
        setTitle("Circus Of Plates");
        setSize(1366,768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        PanelGame panelGame = new PanelGame();
        add(panelGame);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowOpened(WindowEvent e)
           {
               panelGame.start();  
           } 
        });
        
    }

    public static void main(String[] args) {
        // TODO code application logic here

        CircusOfPlates main = new CircusOfPlates();

        main.setVisible(true);
    }

}

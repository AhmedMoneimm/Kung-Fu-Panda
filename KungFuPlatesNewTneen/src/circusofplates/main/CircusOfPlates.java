package circusofplates.main;

import Model.component.MenuMouseInput;
import View.PanelGame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class CircusOfPlates extends JFrame {

    private MenuMouseInput mmi;
    PanelGame panelGame;
    public static CircusOfPlates main;

    public CircusOfPlates() {
        init();
    }

    private void init() {

        setTitle("Circus Of Plates");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelGame = new PanelGame();
        mmi = new MenuMouseInput(panelGame);
        this.addMouseListener(mmi);
        add(panelGame);
        PanelGame.gameState = PanelGame.gameMenu;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {

                    panelGame.start();

                } catch (LineUnavailableException ex) {
                    Logger.getLogger(CircusOfPlates.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CircusOfPlates.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(CircusOfPlates.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        // TODO code application logic here

        main = new CircusOfPlates();
        main.setVisible(true);
    }

}

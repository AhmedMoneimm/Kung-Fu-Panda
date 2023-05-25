package Model.component;

import View.PanelGame;
import View.StartMenu;
import View.ViewPlayers;
import circusofplates.main.CircusOfPlates;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class MenuMouseInput implements MouseListener {

    private String character;
    private String level;
    private final PanelGame pg;
    public static StartMenu start = new StartMenu();

    public MenuMouseInput(PanelGame pn) {
        this.pg = pn;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (PanelGame.gameState == PanelGame.gameMenu) {
            if (mx >= 500 && mx <= 600) {
                if (my >= 300 && my <= 350) {
                    start.setVisible(true);
                    start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    start.setPN(pg);
                }
            }
            if (mx >= 500 && mx <= 700) {
                if (my >= 400 && my <= 450) {
                    ViewPlayers view = new ViewPlayers();
                    view.setVisible(true);
                    view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        } else if (PanelGame.gameState == PanelGame.gameEnd) {
            if (mx >= 450 && mx <= 650) {
                if (my >= 400 && my <= 450) {
                    CircusOfPlates.main.dispose();
                    CircusOfPlates.main = new CircusOfPlates();
                    PanelGame.gameState = PanelGame.gameMenu;
                    CircusOfPlates.main.setVisible(true);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

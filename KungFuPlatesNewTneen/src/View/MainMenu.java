package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class MainMenu {

    public Rectangle playButton = new Rectangle(500, 300, 100, 50);
    public Rectangle viewHighScores = new Rectangle(500, 400, 200, 50);

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(new ImageIcon(getClass().getResource("/Model/image/Background.jpg")).getImage(), 0, 0, null);
        Font font = new Font("ariel", Font.BOLD, 100);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Dragon Warrior", 300, 200);
        Font font2 = new Font("ariel", Font.BOLD, 30);
        g.setFont(font2);
        g.drawString("Play", playButton.x + 19, playButton.y + 30);
        g.drawString("HighScores", viewHighScores.x + 19, viewHighScores.y + 30);

        g2.draw(viewHighScores);
        g2.draw(playButton);

    }

}

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class GameOver {

    public Rectangle SartAgain = new Rectangle(450, 400, 200, 50);

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(new ImageIcon(getClass().getResource("/Model/image/gameover.png")).getImage(), 400, 200, null);

        g.setColor(Color.black);
        Font font2 = new Font("ariel", Font.BOLD, 30);
        g.setFont(font2);
        g.drawString("Play Again", SartAgain.x + 19, SartAgain.y + 30);

        g2.draw(SartAgain);

    }
}

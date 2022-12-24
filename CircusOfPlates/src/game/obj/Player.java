
package game.obj;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author eyada
 */
public class Player {

    public Player() {
        this.image = new ImageIcon(getClass().getResource("/game/image/CircusOfPlates.jpg")).getImage();
        this.image_speed = new ImageIcon(getClass().getResource("/game/image/CircusOfPlates.jpg")).getImage();  
    }
    
    public static final double Player_Size = 64;
    private double x;
    private double y;
    //private float angle = 0f;
    private final Image image;
    private final Image image_speed;
              
    public  void changeLocation(double x,double y){
        this.x=x;
        this.y=y;
    }
    //public void changeAngle(float angle){vid 2 min 2:47

    public void draw(Graphics2D g2){
        AffineTransform oldTransform=g2.getTransform();
        g2.translate(x, y);
        //AffineTransform tran=new AffineTransform();
        //tran.rotate(Math.toRadians(angle+45),Player_Size/2,Player_Size/2);
        g2.drawImage(image, 0,0, null);
        g2.setTransform(oldTransform);
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
}

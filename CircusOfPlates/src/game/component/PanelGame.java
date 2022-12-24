
package game.component;

import game.obj.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author AhmedAbdelwahed
 */
public class PanelGame extends JComponent {
    
    private Graphics2D g2;
    private BufferedImage image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    //Game FPS
    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000 / FPS;
    // Game Object
    private Player player;
    private Key key;
    
    public void start()
    {
       width = getWidth();
       height = getHeight();
       image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
       g2=image.createGraphics();
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
             thread = new Thread(new Runnable() {
           @Override
           public void run() {
               while(start){
                   long startTime=System.nanoTime();
                   drawBackground();
                   drawGame();
                   render();
                   long time = System.nanoTime() - startTime;
                   System.out.println("time : " + time);
                   if(time<TARGET_TIME)
                   {
                       long sleep = (TARGET_TIME - time)/ 1000000;
                       sleep(sleep);
                       //System.out.println("sleep : "+sleep);
                   }
                   
               }
           }
       });
        initObjectGame();
        initKeyboard();
       thread.start();
    }
    
    private void initObjectGame(){
        player=new Player();
        player.changeLocation(150, 150);
    }   
    private  void initKeyboard(){
        key=new Key();
        requestFocus();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT){
                    key.setKey_left(true);
                }
                else if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    key.setKey_right(true);
                }
            }
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT){
                    key.setKey_left(false);
                }
                else if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    key.setKey_right(false);
                }
            }
                
        });
        new Thread(new Runnable(){
            public void  run(){
                //double deltax=0;
                while(start){
                    /*float angle=player.getangle();
                    if(key.isKey_left()){
                        deltax-=5;
                    }
                    else if(key.isKey_right()){
                        deltax+=5;
                    }
                    player.setX(deltax);
                    sleep(5);*/
                }
                
            }
        });
    }
    private void drawBackground(){
        g2.setColor(new Color(30,30,30));
        g2.fillRect(0, 0, width, height);
        
    }
    private void drawGame()
    {
        player.draw(g2);
    }
    private void render()
    {
        Graphics g =getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
    private void sleep (long speed)
    {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
         System.err.println(ex);
        }
    }
}

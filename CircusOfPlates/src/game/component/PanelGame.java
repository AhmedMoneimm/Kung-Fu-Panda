
package game.component;

import game.obj.Plates;
import game.obj.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

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
    private List<Plates> plates;
    
    
    public void start(){
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
                   //System.out.println("time : " + time);
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
    
    private void addPlates(){
        int location=85;
        Plates plate=new Plates();
        plate.setX(0);
        plate.setY(location);
        plates.add(plate);
        Plates plate2=new Plates();
        plate2.setX(width);
        System.out.println("width: "+width);
        plate2.setY(location);
        plates.add(plate2);
        
    }
    
    private void initObjectGame(){
        player=new Player();
        player.changeLocation(0,height-player.getHeightOfImage());
        plates=new ArrayList<>();
        new Thread(new Runnable(){
        @Override
        public void run(){
            while(start){
                addPlates();
                sleep(3000);//Speed of creating the plates
            }
        }
        }).start();
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
                while(start){
                    double deltax=player.getX();
                    double deltaWidth=player.getWidthOfImage();
                    if(key.isKey_left()){
                        if(deltax>0)
                            player.changeAllLocation(-2);//motion of player 
                    }
                    else if(key.isKey_right()){
                        if(deltax<width-deltaWidth)
                            player.changeAllLocation(2);//motion of player                   
                    }
                    for(int i=0;i<plates.size();i++){
                        Plates plate=plates.get(i); 
                        if(plate!=null){
                            plate.update();
                            if(player.checkPlates(plate)==true){
                                plates.remove(plate);
                                player.updateStack();
                            }
                            if(!plate.check(width, height)){
                                plates.remove(plate);
                                System.out.println("Removed from panel..");
                            } 
                        }
                    }
                    sleep(1);//speed of plates motion and character
                } 
            }
        }).start(); 
    }
    
   
    
    private void drawBackground(){
        g2.drawImage(new ImageIcon(getClass().getResource("/game/image/Background.jpg")).getImage(), 0, 0, null);
    }
    
    private void drawGame(){
        player.draw(g2);
        for(int i=0;i<plates.size();i++){
            Plates plate=plates.get(i);
            if(plate!=null){
                plate.draw(g2);
            }
        }
    }
    
    private void render(){
        Graphics g =getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
    
    private void sleep (long speed){
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
         System.err.println(ex);
        }
    }
}

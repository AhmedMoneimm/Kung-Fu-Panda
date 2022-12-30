/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author ahmedmoneimm
 */
public class ImgBase implements GameObject  {

    private int x,y;
    private boolean visible;
    private final BufferedImage[] spriteImg = new BufferedImage[1];
    private String path;
    
    public ImgBase(int x , int y , String path){
        this.x = x; this.y = y;
        this.path = path;
        this.visible = true;
        try {
            spriteImg[0] =  ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("ERROR, PICTURE IS NOT LOADED");
        }
    }
    
    public ImgBase(int x , int y , String path , String path2){
        this.x = x; this.y = y;
        this.visible = true;
        try {
            spriteImg[0] =  ImageIO.read(new File(path));
            spriteImg[1] =  ImageIO.read(new File(path2));
        } catch (IOException e) {
            System.out.println("ERROR, PICTURE IS NOT LOADED");
        }
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return spriteImg[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImg[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImg;
    }
}

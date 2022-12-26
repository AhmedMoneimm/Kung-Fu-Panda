/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.obj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import javax.swing.ImageIcon;

/**
 *
 * @author eyada
 */
public class Plates2 {
    
    private double x;
    private double y;
    private static final double PLATES_SIZE=40;
    private Image image;
    private int widthOfImage;
    private int heightOfImage;
    private final float speed=0.3f;
    private Area plateshape;
    
    public Plates2() {
        this.image = new ImageIcon(getClass().getResource("/game/image/Noodles.png")).getImage();
        widthOfImage=image.getWidth(null);
        heightOfImage=image.getHeight(null);
        //this.image_speed = new ImageIcon(getClass().getResource("/game/image/CircusOfPlates.jpg")).getImage();  
        Path2D p =new Path2D.Double();
        p.moveTo(0,heightOfImage);
        p.lineTo(widthOfImage,heightOfImage);
        p.lineTo(widthOfImage,0);
        p.lineTo(0,0);        
        plateshape=new Area(p);
    }

    public double getX() {
        return x;
    }

    public Image getImage() {
        return image;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidthOfImage() {
        return widthOfImage;
    }

    public void setWidthOfImage(int widthOfImage) {
        this.widthOfImage = widthOfImage;
    }

    public int getHeightOfImage() {
        return heightOfImage;
    }

    public void setHeightOfImage(int heightOfImage) {
        this.heightOfImage = heightOfImage;
    }
    
    public void changeXLocation(double x){
        this.x+=x;
    }
    
    public void changeYLocation(double y){
        this.y+=y;
    }

    public Area getPlateshape() {
        return plateshape;
    }
    
    public void update(){
        if(x<301){
            if(x>300){
              y+=speed;
            }
            else x+=speed;
        }
        else if(x>1025){
            if(x<1026)
                y+=speed;
            else 
                x-=speed;
        }
    }
    
    public void draw(Graphics2D g2){
        AffineTransform oldTransform=g2.getTransform();
        g2.translate(x, y);
        g2.drawImage(image,oldTransform,null);
        Shape shape=getShape();
        g2.setTransform(oldTransform);
        g2.setColor(Color.red);
       // g2.draw(shape);
    }
    public Area getShape(){
        AffineTransform afx=new AffineTransform();
        afx.translate(x, y);
        return new Area(afx.createTransformedShape(plateshape));
    }
    
    public boolean check(int width,int height){
        Rectangle size =getShape().getBounds();
        if(x<= -size.getWidth() || y< -size.getHeight() || x > width || y > height){
            return false;
        }else {
            return true;
        }
    }
}

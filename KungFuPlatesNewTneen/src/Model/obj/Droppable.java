package Model.obj;

import Model.Strategy.UpdateBehavior;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public abstract class Droppable {

    private Image img;
    private double x;
    private double y;
    private int widthOfImage;
    private int heightOfImage;
    private int droppableY;
    UpdateBehavior diff;

    public Droppable(String ImagePath, UpdateBehavior diff) {
        this.img = new ImageIcon(getClass().getResource(ImagePath)).getImage();
        widthOfImage = img.getWidth(null);
        heightOfImage = img.getHeight(null);
        droppableY = heightOfImage + 85;
        this.diff = diff;
    }

    public void setDroppableY(int droppableY) {
        this.droppableY = droppableY;
    }

    public int getDroppableY() {
        return this.droppableY;
    }

    public double getX() {
        return x;
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

    public void changeXLocation(double x) {
        this.x += x;
    }

    public void changeYLocation(double y) {
        this.y += y;
    }

    public void update() {
        diff.update(this);
    }

    public Image getImage() {
        return img;
    }

    public boolean check(int width, int height) {
        Rectangle size = getShape().getBounds();
        if (this.getX() <= -size.getWidth() || this.getY() < -size.getHeight() || x > width || y > height) {
            return false;
        } else {
            return true;
        }
    }

    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(this.getX(), this.getY());
        //System.out.println("Y = "+this.getY());
        g2.drawImage(this.getImage(), oldTransform, null);
        Shape shape = getShape();
        g2.setTransform(oldTransform);
    }

    public abstract Area getPlateshape();

    public abstract Area getShape();

}

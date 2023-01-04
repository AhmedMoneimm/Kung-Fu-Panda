package Model.obj;

import Model.Strategy.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class NinjaKnife extends Droppable {

    private final Area plateshape;

    public NinjaKnife(UpdateBehavior diff) {
        super("/Model/image/shuriken.png", diff);
        Path2D p = new Path2D.Double();
        p.moveTo(0, this.getHeightOfImage());
        p.lineTo(this.getWidthOfImage(), this.getHeightOfImage());
        p.lineTo(this.getWidthOfImage(), 0);
        p.lineTo(0, 0);
        plateshape = new Area(p);
    }

    @Override
    public Area getPlateshape() {
        return plateshape;
    }

    @Override
    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(this.getX(), this.getY());
        //System.out.println("Y = "+this.getY());
        g2.drawImage(this.getImage(), oldTransform, null);
        Shape shape = getShape();
        g2.setTransform(oldTransform);
        g2.setColor(Color.red);
        // g2.draw(shape);
    }

    @Override
    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(this.getX(), this.getY());
        return new Area(afx.createTransformedShape(plateshape));
    }

}

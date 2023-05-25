package Model.obj;

import Model.Strategy.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Spaghetti extends Droppable {

    private final Area plateshape;

    public Spaghetti(UpdateBehavior diff) {
        super("/Model/image/spaghetti.png", diff);
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
    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(this.getX(), this.getY());
        return new Area(afx.createTransformedShape(plateshape));
    }

}

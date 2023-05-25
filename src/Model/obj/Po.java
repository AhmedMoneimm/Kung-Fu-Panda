package Model.obj;

import View.ScoreObserver;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.LinkedList;

public class Po extends abstractPlayer {

    private Path2D p = new Path2D.Double();

    public Po(ScoreObserver l) {
        super("/Model/image/Poo.jpg", l);

        p.moveTo(this.getWidthOfImage() - 35, 5);
        p.lineTo(this.getWidthOfImage() - 35, this.getHeightOfImage() / 6);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 13, this.getHeightOfImage() / 6);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 13, 5);
        legshape = new Area(p);
        xOfLeg = this.getWidthOfImage() - 35;
        platesStack = new LinkedList<>();
    }

    @Override
    public Path2D getP() {
        return p;
    }

    @Override
    public void notifyObserver(int x) {
        this.sc.updateScore(x);
    }
}

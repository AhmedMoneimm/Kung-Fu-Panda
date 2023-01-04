package Model.obj;

import View.ScoreObserver;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.LinkedList;

public class Monkey extends abstractPlayer {

    @Override
    public Path2D getP() {
        return p;
    }
    private Path2D p = new Path2D.Double();

    public Monkey(ScoreObserver l) {
        super("/Model/image/Monkey.png", l);

        System.out.println("this.width " + this.getWidthOfImage());
        p.moveTo(this.getWidthOfImage() - 185, -2);
        p.lineTo(this.getWidthOfImage() - 185, this.getHeightOfImage() / 35);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 140, this.getHeightOfImage() / 35);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 140, -2);
        legshape = new Area(p);
        xOfLeg = this.getWidthOfImage() - 35;
        platesStack = new LinkedList<>();
    }

    @Override
    public void notifyObserver(int x) {
        this.sc.updateScore(x);
    }
}

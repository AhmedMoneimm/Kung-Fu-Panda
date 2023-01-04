package Model.obj;

import View.ScoreObserver;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.LinkedList;

public class Tiger extends abstractPlayer {

    private Path2D p = new Path2D.Double();

    public Tiger(ScoreObserver sc) {
        super("/Model/image/Tiger.png", sc);
        p.moveTo(this.getWidthOfImage() - 20, -2);
        p.lineTo(this.getWidthOfImage() - 20, this.getHeightOfImage() / 35);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 10, this.getHeightOfImage() / 35);
        p.lineTo(3 * this.getWidthOfImage() / 4 - 10, -2);
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

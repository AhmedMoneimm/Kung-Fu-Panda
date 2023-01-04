package Controller;

import Model.Strategy.*;
import Model.obj.Bomb;
import Model.obj.Droppable;
import Model.obj.NinjaKnife;
import Model.obj.Noodles;
import Model.obj.Plates;
import Model.obj.Spaghetti;
import java.util.Random;

public class DropObjectConcreteFactory implements DropObjectFactory {

    private double E = 0.15;
    private double M = 0.5;
    private double H = 0.7;
    UpdateBehavior diff;

    @Override
    public Droppable generateDroppable(float threshold) {
        Random rd = new Random(); // creating Random object
        float r = rd.nextFloat(1);
        System.out.println("threshold : " + threshold + " E : " + E + " M : " + M + " H : " + H);
        if (threshold == 0.15) {
            diff = EasyModeUpdateBehavior.getInstance();
        } else if (threshold == 0.5) {
            System.out.println("ana dakhalt !!!!!!! w b 0.5");
            diff = MedModeUpdateBehavior.getInstance();
        } else if (threshold >= 0.6) {
            System.out.println("ana dakhalt !!!!!!! w b 0.7");
            diff = HardModeUpdateBehavior.getInstance();
        } else {
            diff = EasyModeUpdateBehavior.getInstance();
        }

        if (r < threshold) {
            Droppable bad;
            if (r < threshold - (threshold / 4)) {
                bad = new Bomb(diff);
                return bad;
            } else {
                bad = new NinjaKnife(diff);
                return bad;
            }
        } else {
            float goodRegion = 1 - threshold;
            if (r <= threshold + goodRegion / 3) {
                return new Plates(diff);
            }
            if (r <= threshold + 2 * (goodRegion / 3)) {
                return new Noodles(diff);
            }

        }
        return new Spaghetti(diff);

    }
}

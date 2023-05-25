package Model.Strategy;

import Model.obj.Droppable;

public class MedModeUpdateBehavior implements UpdateBehavior {

    private final double speed = 0.4;

    @Override
    public void update(Droppable d) {
        if (d.getX() < 303) {
            if (d.getX() > 300) {
                d.setY(d.getY() + speed);//y += speed;
                d.setDroppableY((int) (d.getDroppableY() + speed));//droppableY += speed;
            } else {
                d.setX(d.getX() + speed);//x += speed;
            }
        } else if (d.getX() > 1023) {
            if (d.getX() < 1026) {
                d.setY(d.getY() + speed);//y += speed;
                d.setDroppableY((int) (d.getDroppableY() + speed));//droppableY += speed;
            } else {
                d.setX(d.getX() - speed);//x -= speed;
            }
        } else if (d.getX() > 600 && d.getX() < 700) {
            d.setY(d.getY() + speed);//y += speed;
            d.setDroppableY((int) (d.getDroppableY() + speed));//droppableY += speed;
        }
    }
    private static MedModeUpdateBehavior instance = new MedModeUpdateBehavior();

    private MedModeUpdateBehavior() {
    }

    public static MedModeUpdateBehavior getInstance() {
        return instance;
    }
}

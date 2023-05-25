package Model.Strategy;

import Model.obj.Droppable;

public class HardModeUpdateBehavior implements UpdateBehavior {

    private final double speed = 0.7;

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
    private static HardModeUpdateBehavior instance = new HardModeUpdateBehavior();

    private HardModeUpdateBehavior() {
    }

    public static HardModeUpdateBehavior getInstance() {
        return instance;
    }
}

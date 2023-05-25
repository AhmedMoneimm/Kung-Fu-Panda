package Model.Strategy;

import Model.obj.Droppable;

public class EasyModeUpdateBehavior implements UpdateBehavior {

    private final double speed = 0.3;

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
    private static EasyModeUpdateBehavior instance = new EasyModeUpdateBehavior();

    private EasyModeUpdateBehavior() {
    }

    public static EasyModeUpdateBehavior getInstance() {
        return instance;
    }
}

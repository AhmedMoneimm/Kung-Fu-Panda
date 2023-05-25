package Controller;

import Model.obj.Droppable;

public interface DropObjectFactory {

    public Droppable generateDroppable(float n);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.LinkedList;
import java.util.List;
import Objects.Character;
import Objects.ImgBase;
/**
 *
 * @author ahmedmoneimm
 */
public class GamePanel implements World {
    private final List<GameObject> constant = new LinkedList<GameObject>(); //theme
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private int  width,height;

    public GamePanel (int width,int height){
        this.width = width;
        this.height = height;
        Character clown = Character.getInstance((3*width/4) - 13, (int)(height*0.6), "pics\\Poo.jpg");
        control.add(clown);
        constant.add(new ImgBase(0,30,"pics\\BackgroundResize.jpg"));
        moving.add(new ImgBase(0,0,"pics\\Noodles.png"));
        moving.add(new ImgBase(50,0,"pics\\Dumplings.png"));
        constant.add(new ImgBase(-10,30,"pics\\Bamboo.png"));
        constant.add(new ImgBase(770,30,"pics\\Bamboo2.png"));
    }
        @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        GameObject g = moving.get(0);
        g.setY(g.getY()+1);
        GameObject o2 = moving.get(1);
        o2.setY(g.getY()+1);
        return true;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
    
}

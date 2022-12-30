/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;
import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author ahmedmoneimm
 */
public final class Character extends ImgBase {

    private static Character INSTANCE;
    private Character(int x, int y, String path) {
        super(x, y, path);
    }
    public static Character getInstance(int x, int y, String path) {
        if(INSTANCE == null) {
            INSTANCE = new Character(x,y,path);
        }
        return INSTANCE;
    }
    @Override
    public void setY(int y)
    {

    }
}

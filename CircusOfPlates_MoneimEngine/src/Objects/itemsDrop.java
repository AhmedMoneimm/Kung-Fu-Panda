/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author ahmedmoneimm
 */

public class itemsDrop extends ImgBase{
    private  ArrayList<String> shapes  = new ArrayList<String>();

    public itemsDrop(int x, int y, String path) {
        super(x, y, path);
    }

    public ArrayList<String> getShapes(){
        return shapes;
    }
}

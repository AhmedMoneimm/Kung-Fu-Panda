/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author ahmedmoneimm
 */
public class Shapes extends ImgBase{
    
    private int type;
    
    public Shapes(int x,int y, String path)
    {
        super(x,y,path);
    }
    public void setType(String Filename)
    {
        String[] key = Filename.split(",");
        if (key[1].equals("obj1"))
            this.type = 1;
        else if (key[1].equals("obj2"))
            this.type = 2;
        else if (key[1].equals("obj3"))
            this.type = 3;
        else if (key[1].equals("bomb"))
            this.type = 4;
    }
}

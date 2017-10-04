
import java.awt.*;

public class Square{
    //private declarations to hold the values of the circles
    int [] centre;
    int [] topLeft;
    int [] topRight;
    int [] bottomLeft;
    int [] bottomRight;
    int size;
    
    Color colour;
    
    /**constructor for setting the colour and dimensions of the shape.*/
    public Square(int [] centre, double scale, int r, int g, int b, int mySize){
        
        this.centre = centre;
        this.colour = new Color(r, g, b);
        this.size = (int) (scale * mySize);
        topLeft = new int [] {centre[0]-(size/2),centre[1]-(size/2)};
        topRight = new int [] {centre[0]+(size/2),centre[1]-(size/2)};
        bottomLeft = new int [] {centre[0]-(size/2),centre[1]+(size/2)};
        bottomRight = new int [] {centre[0]+(size/2),centre[1]+(size/2)};
        colour = new Color(r, g, b);
    }
    
    public void display(Graphics g){
        g.setColor(colour);
        g.fillRect(topLeft[0], topLeft[1], size, size);
        //g.setColor(Color.black);
       // g.drawString(String.valueOf(topLeft[0]) + " " + String.valueOf(topLeft[1]),topLeft[0],topLeft[1]);
    }
}

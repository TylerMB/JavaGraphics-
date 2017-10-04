
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;


public class Quilt extends JPanel {
    
    
    public static ArrayList<String> inputs = new ArrayList<String>();
    public static ArrayList<Layer> layers = new ArrayList<Layer>();
    public static ArrayList<Square> squares = new ArrayList<Square>();
    public int mySize = 0;
    public double maxScale = 0;
//    public int [] TL;
//    public int [] TR;
//    public int [] BL;
//    public int [] BR;
   
    
    public Quilt(ArrayList<Layer> l){
        this.layers = l;
        setPreferredSize(new Dimension(800,800));
    }
    
    public void drawLayer(int layNum, int [] centre){
        
        if(layNum == layers.size()){
            return;
        }
        
        if(centre[0] == -1){
            centre[0] = 400;
            centre[1] = 400;
            
            for(int i = 0; i < layers.size();i++){
                if(layers.get(i).scale > maxScale){
                    maxScale = layers.get(i).scale;
                }
            }
            mySize = (int) (400/maxScale);
        }
        
        Square s = new Square(centre, layers.get(layNum).scale,layers.get(layNum).r,layers.get(layNum).g,layers.get(layNum).b, mySize);
        squares.add(s);
        
        layNum++;
        if(layNum < layers.size()){
            
            
            drawLayer(layNum, s.topLeft);
            drawLayer(layNum, s.topRight);
            drawLayer(layNum, s.bottomLeft);
            drawLayer(layNum, s.bottomRight);
            
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i=0; i < squares.size(); i++){
            squares.get(i).display(g);
        }
    }
}

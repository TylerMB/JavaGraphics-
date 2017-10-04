
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class QuiltApp {
    
    public static ArrayList<String> inputs = new ArrayList<String>();
    public static ArrayList<Layer> layers = new ArrayList<Layer>();
    
    static int TL;
    static int TR;
    static int BL;
    static int BR;
    
    public static Layer readIn (String line) {
        Layer l = new Layer();
        String[] splitArray = line.split(" ");
        l.scale = Double.parseDouble(splitArray[0]);
        l.r = Integer.parseInt(splitArray[1]);
        l.g = Integer.parseInt(splitArray[2]);
        l.b = Integer.parseInt(splitArray[3]);
        return l;
    }
    
    
    /**creates a frame and sets the visiblity and size.*/
    public static void main (String [] args){
        
        try{
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
                layers.add(readIn(scan.nextLine()));
                //System.err.println("got the line: " + layers.get(0).scale);
            }
        }catch(Exception e){
            System.out.println("There was an input error!");
        }
        
        
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        Quilt q = new Quilt(layers);
        int [] nilCoords = {-1,-1};
        q.drawLayer(0,nilCoords);
        //frame.setSize(1000,1000);
        frame.getContentPane().add(q);
        frame.pack();
        frame.setTitle("A Patchwork Quilt");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}























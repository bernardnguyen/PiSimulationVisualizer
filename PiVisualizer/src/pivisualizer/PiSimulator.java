package pivisualizer;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class PiSimulator {
    
    double CIRCLE=0,TOTAL=0;
    double pi;
    Point2D.Double recent;
    ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();    
    
    public PiSimulator(){}
    
    public void generatePoint(){
        double x=(Math.random()*2)-1;
        double y=(Math.random()*2)-1;
        
        recent = new Point2D.Double(x,y);
        points.add(recent);
        
        if (inCircle(recent)){
            CIRCLE++;            
        } 
        TOTAL++;
        pi=4.0*CIRCLE/TOTAL;
    }
          
    public boolean inCircle(Point2D.Double point){
        return Math.sqrt(Math.pow(point.getX(), 2)+Math.pow(point.getY(),2)) < 1.0;
    }
       
       
    public Point2D.Double getRecent(){
        return recent;
    }
    
    public double getPi(){                
        return pi;
    }
    
    public ArrayList<Point2D.Double> getPoints(){
        return points;
    }

    public int getTotal(){
        return (int) TOTAL;
    }
}
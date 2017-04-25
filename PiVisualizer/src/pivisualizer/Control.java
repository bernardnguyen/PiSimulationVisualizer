package pivisualizer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Control extends Thread {
    
    boolean running = false;
    MyFrame frame;
    
    public Control(MyFrame frame){
        this.frame = frame;
    }
    
    public void toggleRunning(){
        running = !running;
    }
    
    public void run(){
        while(true){
            if(frame.getRunning()){
                frame.ps.generatePoint();
                frame.repaint();
            }
            try{Thread.sleep(1);}
            catch(InterruptedException e) {}
        }
    }    
}

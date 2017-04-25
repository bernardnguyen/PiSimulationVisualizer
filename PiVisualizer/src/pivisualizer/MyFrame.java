package pivisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MyFrame extends javax.swing.JFrame {
       
    PiSimulator ps;
    ArrayList<Point2D.Double> points;  
    boolean running=false;
    DecimalFormat df = new DecimalFormat("#.0000000000000000");
    DecimalFormat df2 = new DecimalFormat("000000000000000000");
      
    
    public MyFrame() {
        initComponents();
        setTitle("PI VISUALIZER");        
        setBounds(710,240,500,550);
        setVisible(true);
        
        Control c = new Control(this);        
        
        ps = new PiSimulator();
        points = ps.getPoints();
        repaint();               
        
        c.run();
    }      
           
    public void paint(Graphics g){        
        if (points.size()<10){            
            super.paint(g);
            drawSymbol(g);
            drawPoints(g);
        } else drawPoint(g, ps.recent);
    }
    
    public void drawSymbol(Graphics g){
        Image symbol;
        try {
            symbol=ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Pi-symbol.svg/2000px-Pi-symbol.svg.png"));
        } catch (IOException ex) {
            symbol=null;
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(symbol, 90, 160, 300, 300, rootPane);
    }
    
    public void drawPoints(Graphics g){
        for(int i=0; i<points.size(); i++){
            drawPoint(g, points.get(i));
        }
    }
    
    public void drawPoint(Graphics g, Point2D.Double point){
        if (ps.inCircle(point)){
            g.setColor(new Color(152,251,152,50));            
        } else {
            g.setColor(new Color(0,128,128));
        }
        int newX = 248 + (int) (point.getX()*200);
        int newY = 298 + (int) (point.getY()*200);
        g.fillOval(newX, newY, 4, 4);
        
        output.setText("" + df.format(ps.getPi()));
        total.setText("" + df2.format(ps.getTotal()));
        
        g.setColor(Color.black);
    }
    
    public void toggleRunning(){
        running = !running;
    }
    
    public boolean getRunning(){
        return running;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        toggleButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        output = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toggleButton.setText("Start/Stop");
        toggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Estimate Value of π:");

        output.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        output.setText("0.0000000000000000");

        total.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        total.setText("000000000000000000");

        jLabel4.setText("Total # of Points:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toggleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(output))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toggleButton)
                    .addComponent(resetButton)
                    .addComponent(jLabel2)
                    .addComponent(output))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(jLabel4))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonActionPerformed
        toggleRunning();    
    }//GEN-LAST:event_toggleButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        ps = new PiSimulator();
        points = ps.getPoints();
        output.setText("" + df.format(0.0));
        repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel output;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton toggleButton;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}

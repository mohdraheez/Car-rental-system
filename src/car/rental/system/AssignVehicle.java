/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Raheez
 */
public class AssignVehicle extends javax.swing.JFrame {

    String SID;
    Connection connection = null;
    PreparedStatement prp = null;
    ResultSet result = null;
    
    Connection connection2 = null;
    PreparedStatement prp2 = null;
    ResultSet result2 = null;
    /**
     * Creates new form AssingVehicle
     */
    public AssignVehicle() {
        initComponents();
    }
    public AssignVehicle(String user) {
        SID=user;
        initComponents();
        
        int itemCount = jComboBox1.getItemCount();

    for(int i = 0; i < itemCount; i++){
        jComboBox1.removeItemAt(0);
    }
        
       String sql = "select eid from employees where sid = '"+SID+"'";
       
       connection = Connector.ConnectDb();
        try{
            prp = connection.prepareStatement(sql);
            result = prp.executeQuery();
            
            while(result.next()){
                jComboBox1.addItem(result.getString("eid"));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NO Emp available");
        }
        
        
            itemCount = jComboBox2.getItemCount();

    for(int i = 0; i < itemCount; i++){
        jComboBox2.removeItemAt(0);
    }
        
        
        sql = "select vid from vehicles where sid = '"+SID+"'";
        
        
        try{
            prp = connection.prepareStatement(sql);
            result = prp.executeQuery();
            
            while(result.next()){
                
                String sql2 = "select vid from manages where vid='"+result.getString("vid")+"'";
                
                try{
                    prp2 = connection.prepareStatement(sql2);
                    result2 = prp2.executeQuery();
                    if(!result2.next()){
                        jComboBox2.addItem(result.getString("vid"));
                    }
                }
                
                catch(SQLException  e){
                    JOptionPane.showMessageDialog(null, "NO Vehicles available");

                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NO Vehicles available");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Ami R", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 170, -1));

        jLabel1.setFont(new java.awt.Font("Ami R", 0, 24)); // NOI18N
        jLabel1.setText("Select Employee Id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 190, 40));

        jLabel2.setFont(new java.awt.Font("Ami R", 0, 24)); // NOI18N
        jLabel2.setText("Select Vehicle Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 190, 40));

        jLabel4.setFont(new java.awt.Font("Ami R", 0, 24)); // NOI18N
        jLabel4.setText("Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 180, 40));

        jButton3.setBackground(new java.awt.Color(104, 185, 132));
        jButton3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Assign");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 164, 1110, 528));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/muscle-car-vintage-retrowave-sunset-neon-digital-art-hd-wallpaper-uhdpaper.com-450@0@f.jpg"))); // NOI18N
        jLabel3.setText("jLabel1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        shopActivity shop = new shopActivity(SID);
        shop.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date date = jDateChooser1.getDate();
        String eid =(String) jComboBox1.getSelectedItem();
        String vid = (String) jComboBox2.getSelectedItem();
        
        String newdate = DateFormat.getDateInstance().format(date);

        String sql ="insert into manages(eid,vid,startdate) values(?,?,?)";
        
        connection = Connector.ConnectDb();
        try{

            prp = connection.prepareStatement(sql);
            prp.setString(1,eid);
            prp.setString(2,vid);
            prp.setString(3,newdate);
            prp.execute();
         
                JOptionPane.showMessageDialog(null,"Success");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error"+e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AssignVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
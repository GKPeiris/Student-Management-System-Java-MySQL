
package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class mainframe extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public mainframe() {
        
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }
    
    
    public void tableload(){
        
        try {
            
            String sql = "SELECT `id` AS ID, `sname`AS Name, `sage` AS Age, `sgrade` AS Grade FROM student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void tabledata(){
        
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r,0).toString();
        String name = table1.getValueAt(r, 1).toString();
        String age = table1.getValueAt(r, 2).toString();
        String grade = table1.getValueAt(r, 3).toString();
        
        idtext.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
    }
    
    
    public void search(){
        
        String srch = searchbox.getText();
        
        try {
            
            String sql = "SELECT * FROM student WHERE sname LIKE '%"+srch+"%' OR id LIKE '%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void update(){
        
        String id = idtext.getText();
        String name = namebox.getText();
        String age =  agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try {
            
            String sql = "UPDATE `student` SET sname='"+name+"', sage='"+age+"', sgrade='"+grade+"' WHERE id='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Updated Successful..");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Update Failed..!");
        }
    }
    
    public void clear(){
        
        searchbox.setText("");
        idtext.setText("ID");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedIndex(0);
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        idtext = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setBackground(new java.awt.Color(255, 255, 255));
        searchbox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        searchbox.setForeground(new java.awt.Color(0, 0, 0));
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 70));

        jPanel4.setBackground(new java.awt.Color(204, 204, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idtext.setBackground(new java.awt.Color(255, 255, 255));
        idtext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idtext.setForeground(new java.awt.Color(0, 0, 0));
        idtext.setText("ID");
        jPanel4.add(idtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        agebox.setBackground(new java.awt.Color(255, 255, 255));
        agebox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        agebox.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 30));

        gradebox.setBackground(new java.awt.Color(255, 255, 255));
        gradebox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        gradebox.setForeground(new java.awt.Color(0, 0, 0));
        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradebox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        namebox.setBackground(new java.awt.Color(255, 255, 255));
        namebox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        namebox.setForeground(new java.awt.Color(0, 0, 0));
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 210, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, 240));

        jPanel5.setBackground(new java.awt.Color(153, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setBackground(new java.awt.Color(255, 255, 255));
        insertbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(0, 0, 0));
        insertbtn.setText("Insert");
        insertbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 30));

        deletebtn.setBackground(new java.awt.Color(255, 255, 255));
        deletebtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(0, 0, 0));
        deletebtn.setText("Delete");
        deletebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, 30));

        exitbtn.setBackground(new java.awt.Color(255, 255, 255));
        exitbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(0, 0, 0));
        exitbtn.setText("Exit");
        exitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel5.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 80, 30));

        updatebtn.setBackground(new java.awt.Color(255, 255, 255));
        updatebtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(0, 0, 0));
        updatebtn.setText("Update");
        updatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, 30));

        clearbtn.setBackground(new java.awt.Color(255, 255, 255));
        clearbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(0, 0, 0));
        clearbtn.setText("Clear");
        clearbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 80, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 330, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 580));

        table1.setBackground(new java.awt.Color(255, 255, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 450, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(853, 595));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        
        String name;
        int age;
        int grade;
        
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        
        try {
            
            String sql = "INSERT INTO student(`sname`, `sage`, `sgrade`) VALUES ('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Saved Successful..");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        
        int check = JOptionPane.showConfirmDialog(null, "Confirm Delete?");
        
        if(check == 0){
            
            String id = idtext.getText();
            
            try {
                
                String sql = "DELETE FROM student WHERE id = '"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Deleted Successful");
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Delete Failed..!");
                
            }
        }
        
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idtext;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}

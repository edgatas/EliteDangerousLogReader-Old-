
package readinelitedangerouslogs;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumnModel;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        systemFrom = new javax.swing.JComboBox<>();
        systemTo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        processInfo = new javax.swing.JLabel();
        distanceText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        travelLog = new javax.swing.JTable();
        timeFrame = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Systems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Read Log");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Database");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        systemFrom.setModel(new javax.swing.DefaultComboBoxModel());
        systemFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                systemFromItemStateChanged(evt);
            }
        });

        systemTo.setModel(new javax.swing.DefaultComboBoxModel());
        systemTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                systemToItemStateChanged(evt);
            }
        });

        jLabel1.setText("Distance Bwtween Systems");

        distanceText.setText(" ");
        distanceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceTextActionPerformed(evt);
            }
        });

        String [][] empty = new String[][]{{" "},{" "},{" "}};
        String [] columnNames = UserInterfaceData.getTravelLogHeaderNames();
        travelLog.setModel(new javax.swing.table.DefaultTableModel(empty, columnNames)
        );
        travelLog.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                travelLogMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(travelLog);

        timeFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "3 Months", "1 Month", "2 Weeks", "1 Week", "3 Days", "1 Day", "12 Hours", "3 Hours" }));
        timeFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFrameActionPerformed(evt);
            }
        });

        jLabel3.setText("Show Logs For: ");

        jButton3.setText("Save Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Systems.setText("ReadSystems");
        Systems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SystemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(systemFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(systemTo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(distanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(465, 465, 465)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(Systems)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addComponent(processInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(timeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(Systems))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(systemFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(systemTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(distanceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(processInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distanceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        processInfo.setText("Deleting Data");

        Data.traveledSystems.listClear();
        ObjectDataManipulation.DeleteFile();
        
        processInfo.setText("Data Cleared");
        
        updateEverything();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Creating new thread to not freeze the program
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        Thread testThread2 = new Thread(){
            public void run(){

                LogReader.LogReading();

                System.out.println("Reading complete");
                
                updateEverything();

                jButton1.setEnabled(true);
                jButton2.setEnabled(true);

            };
        };
        testThread2.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void timeFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFrameActionPerformed

        String date = Calculations.timeFrameToDateStamp((String)timeFrame.getSelectedItem());
        
        Data.createNewModifiedList();
        Data.mTraveledSystems.filterByTime(date);
        
        String [] columnNames = UserInterfaceData.getTravelLogHeaderNames();
        travelLog.setModel(new javax.swing.table.DefaultTableModel(Data.mTraveledSystems.getDataToLogTable(), columnNames));
        updateEverything();
    }//GEN-LAST:event_timeFrameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ObjectDataManipulation.systemDataObjectWrite();
        } catch (IOException ex) {
            LogFile.writeToLog(ex.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void systemFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_systemFromItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            String system1 = systemFrom.getSelectedItem().toString();
            String system2 = systemTo.getSelectedItem().toString();
            
            double tempDistance = miniPrograms.getDistanceBetweenSystems(system1, system2);
            
            distanceText.setText(String.valueOf(tempDistance));
        }
    }//GEN-LAST:event_systemFromItemStateChanged

    private void systemToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_systemToItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            String system1 = systemFrom.getSelectedItem().toString();
            String system2 = systemTo.getSelectedItem().toString();
            
            double tempDistance = miniPrograms.getDistanceBetweenSystems(system1, system2);
            
            distanceText.setText(String.valueOf(tempDistance));
        }
    }//GEN-LAST:event_systemToItemStateChanged

    private void SystemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SystemsActionPerformed
        try {
            URLRequest.requestAllSystems();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SystemsActionPerformed
    
    
    private void travelLogMouseClicked(java.awt.event.MouseEvent evt) {                                       
        TableColumnModel test = travelLog.getColumnModel();
        int test2 = test.getColumnIndexAtX(evt.getX());
        String test3 = travelLog.getColumnName(test2);
        System.out.println(test3);
        
        if (test3.equals(travelLog.getColumnName(0))){
            Data.mTraveledSystems.SortBySystemName();
        }
            
        if (test3.equals(travelLog.getColumnName(1))){
            Data.mTraveledSystems.SortByTimeStamp();
        }
        
        if (test3.equals(travelLog.getColumnName(2))){
            Data.mTraveledSystems.SortByDistance();
        }

        updateEverything();
    }   
    
    public static void updateEverything(){
        String headerNames[] = UserInterfaceData.getTravelLogHeaderNames();
        System.out.println("test");
        System.out.println(Data.mTraveledSystems.listLength());
        if(Data.mTraveledSystems.listLength() == 0){
            Data.createNewModifiedList();
        }
        
        if (Data.mTraveledSystems.listLength() != 0){
            travelLog.setModel(new javax.swing.table.DefaultTableModel(Data.mTraveledSystems.getDataToLogTable(), headerNames));
            systemFrom.setModel(new javax.swing.DefaultComboBoxModel<>(Data.mTraveledSystems.getSystemNames()));
            systemTo.setModel(new javax.swing.DefaultComboBoxModel<>(Data.mTraveledSystems.getSystemNames()));
        }
        else{
            travelLog.removeAll();
            systemFrom.removeAllItems();
            systemTo.removeAllItems();
        }
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LogFile.writeToLog(ex.toString());
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Systems;
    private javax.swing.JTextField distanceText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel processInfo;
    private static javax.swing.JComboBox<String> systemFrom;
    private static javax.swing.JComboBox<String> systemTo;
    private static javax.swing.JComboBox<String> timeFrame;
    private static javax.swing.JTable travelLog;
    // End of variables declaration//GEN-END:variables
}



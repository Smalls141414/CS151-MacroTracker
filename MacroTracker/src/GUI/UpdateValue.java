package GUI;
import java.awt.event.KeyEvent;

import SQLite.DatabaseManager;



public class UpdateValue extends javax.swing.JFrame {

    /**
     * Creates new form SelectDialogBox
     */
	
	private int rowID;
	private String coloumnID;
	private String goalsID;
	
    public UpdateValue(int rowID, String coloumnID, String goalsID) {
    	
    	this.rowID = rowID;
    	this.coloumnID = coloumnID;
    	this.goalsID = goalsID;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        MacroSelectedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Set");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.setText("Change Goal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22)
                .addComponent(jButton3)
                .addGap(22, 22, 22)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                	.addComponent(jButton3)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        MacroSelectedLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MacroSelectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(this.coloumnID.equals("Carbs_Ate"))
        {
        	MacroSelectedLabel.setText("Carbs");
        }
        else if(this.coloumnID.equals("Fat_Ate"))
        {
        	MacroSelectedLabel.setText("Fats");
        }
        else if(this.coloumnID.equals("Protein_Ate"))
        {
        	MacroSelectedLabel.setText("Protein");
        }
        else if(this.coloumnID.equals("Calorie_Ate"))
        {
        	MacroSelectedLabel.setText("Calorie");
        }
        jPanel2.add(MacroSelectedLabel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();
        
        if (!(Character.isDigit(c))  || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume(); // Ignore input that's not a digit, backspace, or delete
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	db.connectToDatabase();
    	db.addValue(rowID, Integer.parseInt(jTextField1.getText()), coloumnID);
        db.closeConnection();

    	this.dispose();
		UserData userData = new UserData(rowID);
		userData.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	db.connectToDatabase();
    	db.updateValue(rowID, Integer.parseInt(jTextField1.getText()), coloumnID);
        db.closeConnection();

    	this.dispose();
		UserData userData = new UserData(rowID);
		userData.setVisible(true);
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	db.connectToDatabase();
    	db.updateValue(rowID, Integer.parseInt(jTextField1.getText()), goalsID);
        db.closeConnection();

    	this.dispose();
		UserData userData = new UserData(rowID);
		userData.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MacroSelectedLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private DatabaseManager db = new DatabaseManager();

    // End of variables declaration//GEN-END:variables
}

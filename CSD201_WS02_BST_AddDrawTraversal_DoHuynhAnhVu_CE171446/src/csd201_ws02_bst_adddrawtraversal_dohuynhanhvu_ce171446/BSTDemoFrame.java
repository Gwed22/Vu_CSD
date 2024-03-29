package csd201_ws02_bst_adddrawtraversal_dohuynhanhvu_ce171446;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Do Huynh Anh Vu  -  CE171446
 */
public class BSTDemoFrame extends javax.swing.JFrame {

    BSTree tree;
    BSTPaper p;

    /**
     * Creates new form BSTDemoFrame
     */
    public BSTDemoFrame() {
        initComponents();

        //maximize the frame
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        tree = new BSTree(60, 1920);
        p = new BSTPaper(tree);
        PanelPaper.setLayout(new BorderLayout());
        PanelPaper.add(p, BorderLayout.CENTER);

        TraversalResult.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConfiguration = new javax.swing.JPanel();
        NodeValue = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        AddRan = new javax.swing.JButton();
        Pre_orderTraversal = new javax.swing.JButton();
        In_oderTraversal = new javax.swing.JButton();
        Post_orderTraversal = new javax.swing.JButton();
        TraversalResult = new javax.swing.JTextField();
        txtNodeValue = new javax.swing.JTextField();
        PanelPaper = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Binary Search Tree v1");
        setName("frmBSTDemo"); // NOI18N

        pnlConfiguration.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration"));

        NodeValue.setText("Node Value");

        Add.setText("Add Node");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        AddRan.setText("Add Randomize");
        AddRan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRanActionPerformed(evt);
            }
        });

        Pre_orderTraversal.setText("Pre-oder Travesal");
        Pre_orderTraversal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pre_orderTraversalActionPerformed(evt);
            }
        });

        In_oderTraversal.setText("In-order Traversal");
        In_oderTraversal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                In_oderTraversalActionPerformed(evt);
            }
        });

        Post_orderTraversal.setText("Post-order Traversal");
        Post_orderTraversal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Post_orderTraversalActionPerformed(evt);
            }
        });

        TraversalResult.setText("Traversal Result : none");

        javax.swing.GroupLayout pnlConfigurationLayout = new javax.swing.GroupLayout(pnlConfiguration);
        pnlConfiguration.setLayout(pnlConfigurationLayout);
        pnlConfigurationLayout.setHorizontalGroup(
            pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigurationLayout.createSequentialGroup()
                .addGroup(pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfigurationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NodeValue)
                        .addGap(18, 18, 18)
                        .addComponent(txtNodeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddRan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(Pre_orderTraversal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(In_oderTraversal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Post_orderTraversal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TraversalResult))
                .addContainerGap())
        );
        pnlConfigurationLayout.setVerticalGroup(
            pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigurationLayout.createSequentialGroup()
                .addGroup(pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NodeValue)
                        .addComponent(Add)
                        .addComponent(AddRan)
                        .addComponent(txtNodeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConfigurationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pre_orderTraversal)
                            .addComponent(In_oderTraversal)
                            .addComponent(Post_orderTraversal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TraversalResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PanelPaper.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelPaperLayout = new javax.swing.GroupLayout(PanelPaper);
        PanelPaper.setLayout(PanelPaperLayout);
        PanelPaperLayout.setHorizontalGroup(
            PanelPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPaperLayout.setVerticalGroup(
            PanelPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PanelPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Pre_orderTraversalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pre_orderTraversalActionPerformed
        tree.preOrder();
        String result = tree.getTraversalResult();
        TraversalResult.setText("Pre-oder traversal result: " + result);
    }//GEN-LAST:event_Pre_orderTraversalActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        int data = Integer.parseInt(NodeValue.getText());
        p.addNode(data);
    }//GEN-LAST:event_AddActionPerformed

    public static int ranNum(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void AddRanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRanActionPerformed
        int data = ranNum(0, 99);
        p.addNode(data);
    }//GEN-LAST:event_AddRanActionPerformed

    private void In_oderTraversalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_In_oderTraversalActionPerformed
        tree.inOrder();
        String result = tree.getTraversalResult();
        TraversalResult.setText("In-oder traversal result: " + result);
    }//GEN-LAST:event_In_oderTraversalActionPerformed

    private void Post_orderTraversalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Post_orderTraversalActionPerformed
        tree.postOrder();
        String result = tree.getTraversalResult();
        TraversalResult.setText("Post-oder traversal result: " + result);
    }//GEN-LAST:event_Post_orderTraversalActionPerformed

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
            java.util.logging.Logger.getLogger(BSTDemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BSTDemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BSTDemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BSTDemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BSTDemoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton AddRan;
    private javax.swing.JButton In_oderTraversal;
    private javax.swing.JLabel NodeValue;
    private javax.swing.JPanel PanelPaper;
    private javax.swing.JButton Post_orderTraversal;
    private javax.swing.JButton Pre_orderTraversal;
    private javax.swing.JTextField TraversalResult;
    private javax.swing.JPanel pnlConfiguration;
    private javax.swing.JTextField txtNodeValue;
    // End of variables declaration//GEN-END:variables
}

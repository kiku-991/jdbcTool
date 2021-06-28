/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view;

import com.jdbctool.model.util.ConmentMessage;
import com.jdbctool.view.util.DialogMessage;
import com.jdbctool.view.util.FileMethod;

/**
 *
 * @author
 */
public class OutputResult extends javax.swing.JFrame {

    public static boolean flg;
    DialogMessage dialog = new DialogMessage();

    /**
     * Creates new form OutputFile
     */
    public OutputResult() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        SelectedFile = new javax.swing.JButton();
        FilePath = new javax.swing.JTextField();
        Output = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("出力");

        SelectedFile.setText("ファイル選択");
        SelectedFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedFileActionPerformed(evt);
            }
        });

        Output.setText("出力");
        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(536, Short.MAX_VALUE)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SelectedFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(FilePath, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(SelectedFile, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectedFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedFileActionPerformed
        // TODO add your handling code here:

        String path = FileMethod.getDirectory(this);
        FilePath.setText(path);

    }//GEN-LAST:event_SelectedFileActionPerformed

    /**
     * 出力
     *
     * @param evt
     */
    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        String path = FilePath.getText();

        if (flg) {
            //main tableResult output
            boolean fmd = FileMethod.toCsv(path, NewJFrame.ResultTable);
            if (fmd == true) {
                DialogMessage.popDialog(ConmentMessage.OUTPUTOK, fmd);
            } else {
                DialogMessage.popDialog(ConmentMessage.OUTPUTFAIL, fmd);
            }

        } else {
            //sql tableResult output
            boolean fmd = FileMethod.toCsv(path, Query.JtableResult);
            if (fmd == true) {
                DialogMessage.popDialog(ConmentMessage.OUTPUTOK, fmd);
            } else {
                DialogMessage.popDialog(ConmentMessage.OUTPUTFAIL, fmd);
            }
        }

    }//GEN-LAST:event_OutputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilePath;
    private javax.swing.JButton Output;
    private javax.swing.JButton SelectedFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

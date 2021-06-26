/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view;

import com.jdbctool.model.ConnectionInfo;
import com.jdbctool.model.util.ConmentMessage;
import com.jdbctool.model.util.ConnectionMethod;
import com.jdbctool.model.util.TemplateReader;
import com.jdbctool.view.util.DialogMessage;
import com.jdbctool.view.util.FileMethod;
import java.io.File;
import java.util.ArrayList;

/**
 *
 */
public class EntityOutput extends javax.swing.JFrame {

    /**
     * Creates new form EntityOutput
     */
    public static boolean flg;

    public EntityOutput() {
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

        FileChoose = new javax.swing.JButton();
        Output = new javax.swing.JButton();
        path = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        FileChoose.setText("フォルダ選択");
        FileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooseActionPerformed(evt);
            }
        });

        Output.setText("出力");
        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FileChoose)
                .addGap(0, 675, Short.MAX_VALUE))
            .addComponent(path)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(FileChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 出力
     *
     * @param evt
     */
    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        TemplateReader tem = new TemplateReader();
        File file = new File("D:\\netbeansWorkspace\\AutoTool\\view\\src\\main\\resources\\dataInfo.txt");
        ConnectionInfo con = FileMethod.readFile(file);
        String db = con.getDatabaseName();
        String un = con.getUserName();
        String pwd = con.getPassword();
        String outPath = path.getText();

        if (flg) {
            //one table
            String table = NewJFrame.clcikTableName;
            tem.getColumnAndType(table, outPath, db, un, pwd);

            DialogMessage.popDialog(ConmentMessage.OUTPUTOK, flg);

        } else {
            //all table
            ArrayList<String> tableList = ConnectionMethod.getAllTableList(db, un, pwd);
            for (String tb : tableList) {
                tem.getColumnAndType(tb, outPath, db, un, pwd);
            }
            DialogMessage.popDialog(ConmentMessage.OUTPUTOK, flg);
        }
    }//GEN-LAST:event_OutputActionPerformed

    /**
     * フォルダ選択
     *
     * @param evt
     */
    private void FileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooseActionPerformed

        String chooseDir = FileMethod.getDirectory(this);
        path.setText(chooseDir);
    }//GEN-LAST:event_FileChooseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FileChoose;
    private javax.swing.JButton Output;
    private javax.swing.JTextField path;
    // End of variables declaration//GEN-END:variables
}

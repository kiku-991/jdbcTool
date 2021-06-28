/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view;

import com.jdbctool.model.ConnectionInfo;
import com.jdbctool.model.util.ConmentMessage;
import com.jdbctool.model.util.ConnectionMethod;
import com.jdbctool.view.util.DialogMessage;
import static com.jdbctool.view.util.FileMethod.readFile;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class Query extends javax.swing.JFrame {

    /**
     * Creates new form Query
     */
    ConnectionInfo con = new ConnectionInfo();

    public Query() {
        initComponents();
        load();
        this.setLocationRelativeTo(null);
        JtableResult.setRowHeight(20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        ResultOutput = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputSql = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        Return = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        RunSql = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtableResult = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        ResultOutput.setText("結果出力");
        ResultOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultOutputActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ResultOutput);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SQL検索");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SQL検索"));

        InputSql.setColumns(20);
        InputSql.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        InputSql.setRows(5);
        jScrollPane1.setViewportView(InputSql);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        Return.setIcon(new javax.swing.ImageIcon("D:\\java資料\\knob-buttons-toolbar-icons_by_itweek\\32\\Knob-Snapback-icon.png")); // NOI18N
        Return.setFocusable(false);
        Return.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Return.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        jToolBar1.add(Return);

        next.setIcon(new javax.swing.ImageIcon("D:\\java資料\\knob-buttons-toolbar-icons_by_itweek\\32\\Knob-Snapforward-icon.png")); // NOI18N
        next.setToolTipText("");
        next.setFocusable(false);
        next.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        next.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(next);
        jToolBar1.add(jSeparator1);

        RunSql.setIcon(new javax.swing.ImageIcon("D:\\java資料\\knob-buttons-toolbar-icons_by_itweek\\32\\Knob-Play-Green-icon.png")); // NOI18N
        RunSql.setFocusable(false);
        RunSql.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RunSql.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RunSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunSqlActionPerformed(evt);
            }
        });
        jToolBar1.add(RunSql);

        jToolBar1.add(ComboBox);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("出力レビュー"));

        JtableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtableResult.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(JtableResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        jMenu1.setText("ファイル(F)");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("編集(E)");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * SQL実行
     *
     * @param evt
     */
    private void RunSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunSqlActionPerformed

        String sql = InputSql.getText();
        String databaseName = con.getDatabaseName();
        String userName = con.getUserName();
        String pwd = con.getPassword();
        DefaultTableModel resu = (DefaultTableModel) JtableResult.getModel();
        //カラム名取得
        List<String> columnName = ConnectionMethod.ColumnName(databaseName, userName, pwd, sql);

        if (!columnName.isEmpty()) {
            //List to Array
            String[] array = columnName.toArray(new String[columnName.size()]);
            //列名設定
            resu.setColumnIdentifiers(array);
            //行数初期化
            resu.setRowCount(0);
            //列値
            List<List<Object>> resultValue = ConnectionMethod.getResultValue(databaseName, userName, pwd, sql);
            //列値設定

            for (List<Object> rv : resultValue) {
                String[] toArray = rv.toArray(new String[rv.size()]);
                resu.addRow(toArray);
                System.out.println(Arrays.toString(toArray));
            }

            JtableResult.setRowHeight(25);
        } else {

            DialogMessage.popDialog(ConmentMessage.RIGHTSQL, false);
        }

    }//GEN-LAST:event_RunSqlActionPerformed

    /**
     * 撤销
     *
     * @param evt
     */
    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed

        InputSql.setText("");

        DefaultTableModel model = (DefaultTableModel) JtableResult.getModel();
        //クリアテーブル
        model.setRowCount(0);
        model.setColumnCount(0);
    }//GEN-LAST:event_ReturnActionPerformed

    /**
     * 画面ロード
     */
    public void load() {
        File file = new File("D:\\netbeansWorkspace\\AutoTool\\view\\src\\main\\resources\\dataInfo.txt");
        ConnectionInfo result = readFile(file);

        ComboBox.addItem(result.getUrl());
        ComboBox.setSelectedItem(result.getUrl());
    }

    /**
     * 出力
     *
     * @param evt
     */
    private void ResultOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultOutputActionPerformed

        OutputResult out = new OutputResult();
        OutputResult.flg = false;
        out.setVisible(true);

    }//GEN-LAST:event_ResultOutputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JTextArea InputSql;
    public static javax.swing.JTable JtableResult;
    private javax.swing.JMenuItem ResultOutput;
    private javax.swing.JButton Return;
    private static javax.swing.JButton RunSql;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}

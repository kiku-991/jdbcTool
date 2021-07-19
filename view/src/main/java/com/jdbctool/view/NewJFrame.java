/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view;

import com.jdbctool.model.ConnectionInfo;
import com.jdbctool.model.util.ConmentMessage;
import com.jdbctool.model.util.ConnectionMethod;
import com.jdbctool.view.util.FileMethod;
import java.awt.Color;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author
 */
public class NewJFrame extends javax.swing.JFrame {

    public static String clcikTableName;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        //幅設定
        DataBaseTree.setRowHeight(20);
        DataBaseTree.setModel(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JtablePopupMenu = new javax.swing.JPopupMenu();
        Output = new javax.swing.JMenuItem();
        JtreePopupMenu = new javax.swing.JPopupMenu();
        EntityOutput = new javax.swing.JMenuItem();
        AllOutput = new javax.swing.JMenuItem();
        ObjectOutput = new javax.swing.JMenuItem();
        RepositoryOutput = new javax.swing.JMenuItem();
        ObjectAll = new javax.swing.JMenuItem();
        RepositoryAll = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataBaseTree = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        AddDataBase = new javax.swing.JButton();
        FileChoose = new javax.swing.JButton();
        Query = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        CreateProject = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        Output.setText("結果出力");
        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });
        JtablePopupMenu.add(Output);

        EntityOutput.setText("エンティティ出力");
        EntityOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntityOutputActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(EntityOutput);

        AllOutput.setText("エンティティ一括出力");
        AllOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllOutputActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(AllOutput);

        ObjectOutput.setText("オブジェクト生成");
        ObjectOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjectOutputActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(ObjectOutput);

        RepositoryOutput.setText("レポジトリ生成");
        RepositoryOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepositoryOutputActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(RepositoryOutput);

        ObjectAll.setText("オブジェクト一括生成");
        ObjectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjectAllActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(ObjectAll);

        RepositoryAll.setText("レポジトリ一括生成");
        RepositoryAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepositoryAllActionPerformed(evt);
            }
        });
        JtreePopupMenu.add(RepositoryAll);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KikuTool");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("データベース"));

        DataBaseTree.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        DataBaseTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        DataBaseTree.setComponentPopupMenu(JtreePopupMenu);
        DataBaseTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataBaseTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataBaseTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        AddDataBase.setIcon(new javax.swing.ImageIcon("D:\\java資料\\woofunction-icons\\woofunction-icons\\database_32.png")); // NOI18N
        AddDataBase.setFocusable(false);
        AddDataBase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddDataBase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AddDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDataBaseActionPerformed(evt);
            }
        });
        jToolBar1.add(AddDataBase);

        FileChoose.setIcon(new javax.swing.ImageIcon("D:\\java資料\\woofunction-icons\\woofunction-icons\\folder_32.png")); // NOI18N
        FileChoose.setFocusable(false);
        FileChoose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FileChoose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooseActionPerformed(evt);
            }
        });
        jToolBar1.add(FileChoose);

        Query.setIcon(new javax.swing.ImageIcon("D:\\java資料\\knob-buttons-toolbar-icons_by_itweek\\32\\Knob-Search-icon.png")); // NOI18N
        Query.setFocusable(false);
        Query.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Query.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        jToolBar1.add(Query);

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ResultTable.setComponentPopupMenu(JtablePopupMenu);
        jScrollPane2.setViewportView(ResultTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("テーブル", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("プロパティ", jPanel3);

        jMenu1.setText("ファイル(F)");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("編集(E)");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("ツール(T)");

        CreateProject.setText("プロジェクト生成");
        CreateProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProjectActionPerformed(evt);
            }
        });
        jMenu3.add(CreateProject);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("ヘルプ(H)");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDataBaseActionPerformed
        Connecte con = new Connecte();
        con.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddDataBaseActionPerformed

    private void QueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryActionPerformed

        Query qy = new Query();
        qy.setVisible(true);

    }//GEN-LAST:event_QueryActionPerformed

    private void FileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooseActionPerformed

        FileMethod file = new FileMethod();
        file.selectFile(this);
    }//GEN-LAST:event_FileChooseActionPerformed

    private void DataBaseTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataBaseTreeMouseClicked
        File file = new File("D:\\netbeansWorkspace\\AutoTool\\view\\src\\main\\resources\\dataInfo.txt");
        //ファイル読み込み
        ConnectionInfo con = FileMethod.readFile(file);
        //ユーザ名
        String un = con.getUserName();
        //パスワード
        String pwd = con.getPassword();
        //データベース名
        String db = con.getDatabaseName();
        DefaultTableModel resu = (DefaultTableModel) ResultTable.getModel();
        TreePath[] treePaths = DataBaseTree.getSelectionModel().getSelectionPaths();
        for (TreePath treePath : treePaths) {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            //選択されたNode名取得
            Object tableName = selectedElement.getUserObject();

            if (!tableName.equals(ConmentMessage.HOST) || !tableName.equals(db)) {
                clcikTableName = (String) tableName;
                String sql = ConmentMessage.SQL + clcikTableName;

                List<String> colunmName = ConnectionMethod.ColumnName(db, un, pwd, sql);
                //List to Array
                String[] array = colunmName.toArray(new String[colunmName.size()]);
                //列名設定
                resu.setColumnIdentifiers(array);
                //行数初期化
                resu.setRowCount(0);
                //列値
                List<List<Object>> resultValue = ConnectionMethod.getResultValue(db, un, pwd, sql);

                for (List<Object> rv : resultValue) {
                    String[] toArray = rv.toArray(new String[rv.size()]);
                    resu.addRow(toArray);
                    System.out.println(Arrays.toString(toArray));
                }
                //行幅設定
                DataBaseTree.setRowHeight(25);
                JTableHeader header = ResultTable.getTableHeader();
                header.setBackground(Color.red);
            }
        }

    }//GEN-LAST:event_DataBaseTreeMouseClicked

    /**
     * 結果出力
     *
     * @param evt
     */
    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        int i = 0;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_OutputActionPerformed

    /**
     * エンティティ出力
     *
     * @param evt
     */
    private void EntityOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntityOutputActionPerformed
        int i = 1;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_EntityOutputActionPerformed

    /**
     * 一括出力
     *
     * @param evt
     */
    private void AllOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllOutputActionPerformed
        int i = 4;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_AllOutputActionPerformed

    /**
     * 新規プロジェクト生成
     *
     * @param evt
     */
    private void CreateProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProjectActionPerformed

        ProjectCreate pro = new ProjectCreate();
        pro.setVisible(true);
    }//GEN-LAST:event_CreateProjectActionPerformed

    /**
     * オブジェクト生成
     *
     * @param evt
     */
    private void ObjectOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjectOutputActionPerformed
        int i = 2;
        FileMethod fm = new FileMethod();
        fm.Output(i);

    }//GEN-LAST:event_ObjectOutputActionPerformed

    /**
     * レポジトリ生成
     *
     * @param evt
     */
    private void RepositoryOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepositoryOutputActionPerformed
        int i = 3;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_RepositoryOutputActionPerformed

    /**
     * Object 一括出力
     *
     * @param evt
     */
    private void ObjectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjectAllActionPerformed
        int i = 5;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_ObjectAllActionPerformed

    /**
     * Repository　一括出力
     *
     * @param evt
     */
    private void RepositoryAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepositoryAllActionPerformed

        int i = 6;
        FileMethod fm = new FileMethod();
        fm.Output(i);
    }//GEN-LAST:event_RepositoryAllActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDataBase;
    private javax.swing.JMenuItem AllOutput;
    private javax.swing.JMenuItem CreateProject;
    public javax.swing.JTree DataBaseTree;
    private javax.swing.JMenuItem EntityOutput;
    private javax.swing.JButton FileChoose;
    private javax.swing.JPopupMenu JtablePopupMenu;
    private javax.swing.JPopupMenu JtreePopupMenu;
    private javax.swing.JMenuItem ObjectAll;
    private javax.swing.JMenuItem ObjectOutput;
    private javax.swing.JMenuItem Output;
    private javax.swing.JButton Query;
    private javax.swing.JMenuItem RepositoryAll;
    private javax.swing.JMenuItem RepositoryOutput;
    public static javax.swing.JTable ResultTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

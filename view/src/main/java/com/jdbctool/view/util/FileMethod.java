/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view.util;

import com.jdbctool.model.ConnectionInfo;
import com.jdbctool.model.util.ConmentMessage;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 */
public class FileMethod {

    DialogMessage dialog = new DialogMessage();
    public static String everything = null;

    /**
     * ファイル選択
     *
     * @param com
     */
    public void selectFile(Component com) {
        JFileChooser filechooser = new JFileChooser();

        int selected = filechooser.showOpenDialog(com);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            System.out.println(file.getPath());
        }
    }

    /**
     * フォルダ選択
     *
     * @param comp
     * @return
     */
    public String getDirectory(Component comp) {

        String path = "";

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(comp) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());

            path = chooser.getSelectedFile().toString();
        } else {
            System.out.println("No Selection ");

        }

        return path;
    }

    /**
     * テーブルデータをCSVに出力
     *
     * @param path
     * @param table
     * @return
     */
    public boolean toCsv(String path, JTable table) {

        boolean flg = false;
        try {
            File file = new File(path + "\\data.txt");
            TableModel modelo = table.getModel();
            // FileWriter csv = new FileWriter(archivo);
            PrintWriter csv = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                if (i == modelo.getColumnCount() - 1) {
                    csv.write(modelo.getColumnName(i));
                } else {

                    csv.write(modelo.getColumnName(i) + ",");
                }
            }
            csv.write("\n");
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    String data = (String) modelo.getValueAt(i, j);
                    if (data == "null") {
                        data = "";
                    }
                    if (j == modelo.getColumnCount() - 1) {
                        csv.write(data);
                    } else {
                        csv.write(data + ",");
                    }
                }
                csv.write("\n");
            }

            csv.close();
            flg = true;
        } catch (IOException ex) {
            Logger.getLogger(FileMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flg;
    }

    public void Writefile(String Server, String portNum, String DatabaseName, String UserName, String Password) throws IOException {

        String path = System.getProperty("user.dir");
        System.out.println(path);
        File file = new File(path + "\\src\\main\\resources\\dataInfo.txt");
        if (checkBeforeWritefile(file) == true) {
            FileWriter filewriter = new FileWriter(file);
            // "jdbc:postgresql://localhost:5432/soul"

            //  String url = "jdbc:postgresql://" + Server + ":" + portNum + "/" + DatabaseName;
            filewriter.write(Server + ConmentMessage.CANMA + portNum + ConmentMessage.CANMA + DatabaseName + ConmentMessage.CANMA
                    + UserName + ConmentMessage.CANMA + Password);

            filewriter.close();
        } else {

            System.out.println("上書き");
        }

    }

    public static boolean checkBeforeWritefile(File file) {
        if (file.exists() == false) {
            return true;
        } else {
            //  DialogMessage.popDialog("当ファイルが存在しているので、上書きしますか", false);
            return false;
        }

    }

//    public static void main(String... args) {
//        File file = new File("D:\\netbeansWorkspace\\AutoTool\\view\\src\\main\\resources\\dataInfo.txt");
//
//
//
//    }
    /**
     * ファイル読み込み
     *
     * @param file
     * @return
     */
    public static ConnectionInfo readFile(File file) {
        ConnectionInfo con = new ConnectionInfo();

        if (checkBeforeReadfile(file)) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();

                }
                everything = sb.toString();
                System.out.println(everything);
                br.close();
                String[] parts = everything.trim().split(",");
                con.setServer(parts[0]);
                con.setPortNunmber(parts[1]);
                con.setDatabaseName(parts[2]);
                con.setUserName(parts[3]);
                con.setPassword(parts[4]);
                //kikuのpostgres@localhost:5432
                con.setUrl(parts[2] + "の" + parts[3] + "@" + parts[0] + ":" + parts[1]);

            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("ファイルが見つからないか開けません");
        }

        return con;
    }

    private static boolean checkBeforeReadfile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canRead()) {
                return true;
            }
        }

        return false;
    }
}
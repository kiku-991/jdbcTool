/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.model.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.jdbctool.model.TableInfo;

/**
 *
 */
public class TemplateReader {

    /**
     * テーブルのタイプとカラム名取得
     *
     * @param tableName
     * @param path
     * @param databaseName
     * @param username
     * @param pwd
     * @param t
     * @return list
     */
    public List<TableInfo> getColumnAndType(String tableName, String path, String databaseName,
            String username, String pwd, int t) {

        Statement stmt = null;
        ResultSet rset = null;

        ArrayList<TableInfo> list = new ArrayList<>();

        try {

            stmt = ConnectionMethod.getDBConn(databaseName, username, pwd);

            String coulmnSql = "SELECT\n"
                    + "    a.attname as name\n"
                    + "    , format_type(a.atttypid, a.atttypmod) as type\n"
                    + "    , col_description(a.attrelid, a.attnum) as comment \n"
                    + "FROM\n"
                    + "    pg_class as c\n"
                    + "    , pg_attribute as a \n"
                    + "where\n"
                    + "    c.relname = " + "'" + tableName + "'" + "\n"
                    + "    and a.attrelid = c.oid \n"
                    + "    and a.attnum > 0";

            rset = stmt.executeQuery(coulmnSql);

            String className = getClassName(tableName);

            //SELECT結果の受け取り
            while (rset.next()) {
                TableInfo tableInfo = new TableInfo();
                String name = rset.getString(1);
                String type = rset.getString(2);
                String comment = rset.getString(3);
                //注解
                tableInfo.setComment(comment);
                //获取数据类型
                Object dtype = classCast(type);//数据类型
                tableInfo.setDataType(dtype);
                //获取字段名称
                String propertity = getPropertity(name);//属性名称
                tableInfo.setColumnName(propertity);

                list.add(tableInfo);
            }

            String pcName = getPackageName(path);
            String outputType;
            String packageName;
            String template;
            switch (t) {
                case 0:
                    outputType = "eneity";
                    packageName = pcName + "." + outputType;
                    template = readSource(packageName, tableName, className, list, t);
                    break;
                case 1:
                    outputType = "object";
                    packageName = pcName + "." + outputType;
                    template = readSource(packageName, tableName, className, list, t);
                    break;
                default:
                    outputType = "repositoy";
                    packageName = pcName + "." + outputType;
                    template = readSource(packageName, tableName, className, list, t);
                    break;
            }

            try {
                //生成java文件
                mkDirectory(path + "\\" + outputType);
                getFile(className, template, path + "\\" + outputType + "\\");
            } catch (IOException e) {
            }

        } catch (SQLException ex) {
            Logger.getLogger(TemplateReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * 生成类名
     *
     * @param tableName 表名
     * @return
     */
    private String getClassName(String tableName) {
        String newClassName = "";
        int i = tableName.indexOf("_");
        if (i < 0) {
            //アンダーバーがない場合
            newClassName = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
        } else {
            //アンダーバーがある場合
            String[] strs = tableName.split("_");
            StringBuffer sb = new StringBuffer();
            for (int m = 0; m < strs.length; m++) {
                sb.append(strs[m].substring(0, 1).toUpperCase() + strs[m].substring(1));
            }
            newClassName = sb.toString();
        }
        return newClassName;
    }

    /**
     * 生成属性java类型
     *
     * @param obj
     * @return
     */
    public static String classCast(Object obj) {
        String type = "";
        String str = (String) obj;
        switch (str) {
            case "varchar":
            case "char":
            case "text":
                type = "String";
                break;
            case "int":
            case "integer":
            case "serial":
                type = "Integer";
                break;
            case "bigint":
                type = "Long";
                break;
            case "double":
            case "float":
                type = "Double";
                break;
            case "date":
            case "datetime":
                type = "Date";
                break;
            case "timestamp":
            case "timestamp without time zone":
                type = "Timestamp";
                break;
            default:
                type = "String";
                break;
        }
        return type;
    }

    //数据库字段名字转java属性名字
    private String getPropertity(Object obj) {
        String pro = "";
        String colum = (String) obj;
        int index = colum.indexOf("_");
        //判断アンダーバーがあるかどうか
        if (index < 0) {
            //アンダーバーがない
            pro = colum.substring(0, 1).toLowerCase() + colum.substring(1);//首字母小写
        } else {
            //アンダーバーがある
            StringBuilder sb = new StringBuilder();
            String[] colums = colum.split("_");
            for (int i = 0; i < colums.length; i++) {
                if (i == 0) {
                    //拼接第一个,并将首字母小写
                    sb.append(colums[i].substring(0, 1).toLowerCase() + colums[i].substring(1));
                } else {
                    //除了第一个都将首字母大写
                    sb.append(colums[i].substring(0, 1).toUpperCase() + colums[i].substring(1));
                }
            }
            pro = sb.toString();
        }

        return pro;
    }

    /**
     * 生成包名
     */
    private String getPackageName(String path) {
        int index = path.indexOf("java\\");
        String newPackage = "";
        if (index > 0) {
            String substring = path.substring(index + 5);
            newPackage = substring.replace("\\", ".");
        }
        return newPackage;
    }

    /**
     * 生成文件
     *
     * @param fileName 文件名
     * @param info 要写入的内容
     * @throws IOException
     */
    private void getFile(String fileName, String info, String path) throws IOException {
        //生成文件
        File file = new File(path + "\\" + fileName + ".java");
        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter p_writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));
        p_writer.println(info);
        p_writer.close();
    }

    /**
     * directory作成
     *
     * @param path
     * @return
     */
    public boolean mkDirectory(String path) {

        File file = new File(path);
        if (!file.exists()) {
            return file.mkdirs();
        } else {
            return false;
        }

    }

    /**
     * テンプレート読み込み
     *
     * @param packageName
     * @param tableName
     * @param className
     * @param list
     * @param type
     * @return output
     */
    public static String readSource(String packageName, String tableName, String className, List<TableInfo> list, int type) {

        VelocityEngine ve = new VelocityEngine();
        //外部
        // ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "D:\\data");
        //内部
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.setProperty("input.encoding", "UTF-8");

        ve.setProperty("output.encoding", "UTF-8");

        ve.init();
        String vm = null;
        switch (type) {
            case 0:
                vm = "template.vm";
                break;
            case 1:
                vm = "object.vm";
                break;
            default:
                vm = "repository.vm";
                break;
        }
        Template t = ve.getTemplate(vm);
        t.setEncoding("UTF-8");
        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("dbname", tableName);
        context.put("javaClazz", className);
        context.put("list", list);

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        String output = writer.toString();

        return output;

    }

}

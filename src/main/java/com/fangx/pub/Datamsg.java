package com.efx.quality.pub;

import com.efx.quality.model.PubMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class Datamsg {

    /**
     *
     */
    public Datamsg() {
    }

    public static String filename = "c:\\bukup\\";

    //备份
    public static boolean backupDatalocal(String filen, String sjk, String sjkm, String sjkmm) {
        boolean flag = false;
        try {
            DateCon cn = new DateCon();
            cn.initcon();
            Connection conn = cn.getcon(sjk, sjkm, sjkmm);
            //System.out.println(conn);
            //System.out.println(conn!=null);
            Statement stmt = conn.createStatement();
            SimpleDateFormat sf = new SimpleDateFormat("yy-MM-dd");
            String namepath = sf.format(new Date());
            if (filen == null) {
                filename = "c:\\bukup\\" + namepath + ".bak";
            } else {
                filename = "c:\\bukup\\test.bak";
            }
            File file = new File(filename);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
//			  String sql="backup database "+sjk+" to disk='"+filename+"'";
            String sql = "mysqldump -u" + sjkm + " -p" + sjkmm + " " + sjk + " > test.dump";
            System.out.println(sql);
            Integer s = stmt.executeUpdate(sql);
            System.out.println(s);
            conn.commit();
            stmt.close();
            conn.close();
            flag = true;

        } catch (Exception e) {
            //加入进度条
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean isFile(String filename) {
        File file = new File(filename);
        return file.exists() && file.isFile();
    }


    //数据安装
    public static boolean datainstall(String path, String sjk, String sjkm, String sjkmm) {
        //System.out.println(path);
        if (isFile(path)) {
            //执行*.sql
            DateCon cn = new DateCon();
            cn.initcon();
            Connection conn = cn.getcon(sjk, sjkm, sjkmm);
            try {
                Statement stmt = conn.createStatement();
                List sqlList = readSqlFiles(path);
                for (int i = 0; i < sqlList.size(); i++) {
                    //强行断开除了自己外的所有连接
                    stmt.executeUpdate("declare @sql varchar(100) \n" +
                            "while 1=1 \n" +
                            "begin \n" +
                            "select top 1 @sql = 'kill '+cast(spid as varchar(3)) from  master..sysprocesses where spid>50 and spid <> @@spid \n" +
                            "if @@rowcount = 0 \n" +
                            "break \n" +
                            "exec(@sql) \n" +
                            "end \n");

                    stmt.executeUpdate(sqlList.get(i).toString());
                }
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
            return true;
        } else return false;
    }


    //还原
    public static boolean datahy(String path, String sjk, String sjkm, String sjkmm) {
        String sql = "";
        String tablename = "";
        if (isFile(path)) {
            if (path.indexOf("szdata") >= 0) tablename = "szdata";


            //开始还原
            try {
                DateCon cn = new DateCon();
                cn.initcon();
                Connection conn = cn.getcon(sjk, sjkm, sjkmm);
                Statement stmt = conn.createStatement();
                sql = "restore database " + tablename + " from disk = '" + path + "'" + "  WITH FILE = 1,NOUNLOAD,STATS=10,RECOVERY,REPLACE";
                stmt.executeUpdate("declare @sql varchar(100) \n" +
                        "while 1=1 \n" +
                        "begin \n" +
                        "select top 1 @sql = 'kill '+cast(spid as varchar(3)) from  master..sysprocesses where spid>50 and spid <> @@spid \n" +
                        "if @@rowcount = 0 \n" +
                        "break \n" +
                        "exec(@sql) \n" +
                        "end \n");//强行断开除了自己外的所有连接
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
                //关闭进度条
            } catch (Exception e) {
                //关闭进度条
            }
            return true;
        } else return false;
    }


    public static List readSqlFiles(String sql_path) {
        List sqlList = new ArrayList();
        File myFile = new File(sql_path);
        if (!myFile.exists()) {
            System.err.println("Can't Find :" + sql_path);
            return null;
        }
        StringBuffer temp = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));
            String str;
            while ((str = in.readLine()) != null) {
                temp.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        String[] sqls = temp.toString().split(";");
        for (String sql : sqls) {
            sqlList.add(sql);
        }
        return sqlList;
    }

    /**
     * Java代码实现MySQL数据库导出
     *
     * @param hostIP       MySQL数据库所在服务器地址IP
     * @param userName     进入数据库所需要的用户名
     * @param password     进入数据库所需要的密码
     * @param savePath     数据库导出文件保存路径
     * @param fileName     数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     * @author GaoHuanjie
     */
    public static boolean exportDatabaseTool(String sjkdz, String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), StandardCharsets.UTF_8));
            Process process = Runtime.getRuntime().exec(sjkdz + "mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
            }
            printWriter.flush();
            if (process.waitFor() == 0) {//0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Java代码实现MySQL数据库导出
     *
     * @param hostIP       MySQL数据库所在服务器地址IP
     * @param hostdk       MySQL数据库端口
     * @param userName     进入数据库所需要的用户名
     * @param password     进入数据库所需要的密码
     * @param savePath     数据库导出文件保存路径
     * @param fileName     数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @param runPath      项目路劲
     * @return 返回true表示导出成功，否则返回false。
     * @author GaoHuanjie
     */
    public static boolean exportDatabaseTool(String hostIP, String hostdk, String userName,
                                             String password, String savePath, String fileName,
                                             String databaseName, String runPath) throws InterruptedException {

        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        try {
            printWriter = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(savePath + fileName), StandardCharsets.UTF_8));

            Process process = Runtime.getRuntime().exec(runPath + "/static/care/mysqldump -h"
                    + hostIP + " -P" + hostdk + " -u" + userName + " -p" + password
                    + " --default-character-set=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(
                    process.getInputStream(), StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
            }
            printWriter.flush();
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void beifenMysql(HttpServletRequest request, HttpServletResponse response, properConfig config, String s) {
        try {
            boolean a = Datamsg.exportDatabaseToolMysql(config.getJdbcurl(), config.getJdbcdk(),
                    config.getUsername(),config.getPassword(),"c:\\backup\\","clzpsdata.sql",
                    config.getDataname(), s);
            System.out.println(a);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        File file = new File("c:\\backup\\clzpsdata.sql");
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("charset=utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=clzpsdata.sql");
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Java代码实现MySQL数据库导出
     *
     * @author GaoHuanjie
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param hostdk MySQL数据库端口
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @param runPath 项目路劲
     * @return 返回true表示导出成功，否则返回false。
     */
    public static boolean exportDatabaseToolMysql(String hostIP,String hostdk, String userName,
                                                  String password, String savePath, String fileName,
                                                  String databaseName,String runPath) throws InterruptedException {

        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        try {
            System.out.println(fileName);
            printWriter = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(savePath + fileName), "utf8"));

            Process process = Runtime.getRuntime().exec(runPath+"/static/care/mysqldump -h"
                    + hostIP + " -P" + hostdk + " -u" + userName + " -p" + password
                    + " --default-character-set=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(
                    process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(fileName+"xxxxx");
                printWriter.println(line);
            }
            printWriter.flush();
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                System.out.println(fileName+"x");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
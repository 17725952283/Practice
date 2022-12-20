package LeetCode.ywf.JavaCourseDesign;

import java.sql.*;



public class SqlUtil  {

    public static Connection getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String jdbcName = "root";
        String jdbcPassword = "123456";
        Connection con = null;
        try {
            // 加载Mysql数据驱动
            Class.forName(jdbcDriver);
            // 创建数据连接
            con = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPassword);

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        // 返回所建立的数据库连接

        return con;
    }


    public static int insert(String sql) throws  SQLException {
        // 首先要获取连接，即连接到数据库
        MyDataSource dataSource = new MyDataSource();
        Connection conn = dataSource.getConnection();
        int count = 0;
        try {
            // 创建用于执行静态sql语句的Statement对象
            Statement statement = (Statement) conn.createStatement();
            // 执行插入操作的sql语句，并返回插入数据的个数
            count = statement.executeUpdate(sql);
            // 输出插入操作的处理结果
            System.out.println("添加成功!");
            statement.close();
            conn.close(); // 关闭数据库连接
        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
        return  count;

    }


    public static int update(String sql) throws SQLException {

        // 同样先要获取连接，即连接到数据库
        MyDataSource dataSource = new MyDataSource();
        Connection conn = dataSource.getConnection();

        int count = 0;
        try {
//
            // 创建用于执行静态sql语句的Statement对象，st属局部变量
            Statement statement = (Statement) conn.createStatement();
            // 执行更新操作的sql语句，返回更新数据的个数
            count = statement.executeUpdate(sql);
            // 输出更新操作的处理结果
            System.out.println("更新成功");
            statement.close();
            // 关闭数据库连接
            conn.close();

        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
        return count;
    }

    /* 查询数据库，输出符合要求的记录的情况 */

    /**
     * @param sql
     * @param role 1:管理员 2:学生 3:教师
     * @param type
     * @return
     */
    public static Object query(String sql, String role, String type) throws SQLException {
        // 同样先要获取连接，即连接到数据库
        MyDataSource dataSource = new MyDataSource();
        Connection conn = dataSource.getConnection();
        Student student = new Student();
        Teacher teacher = new Teacher();
        Administrator administrator = new Administrator();


        try {
            // 创建用于执行静态sql语句的Statement对象，st属局部变量
            Statement statement = (Statement) conn.createStatement();
            // 执行sql查询语句，返回查询数据的结果集
            ResultSet rs = statement.executeQuery(sql);
            // 判断是否还有下一个数据

            if ("student".equals(role) && "login".equals(type)) {
                while (rs.next()) {
                    student = new Student(Long.valueOf(rs.getObject("id").toString()), rs.getObject("name").toString(), rs.getObject("className").toString(), Float.parseFloat(rs.getObject("JavaScore").toString()), Float.parseFloat(rs.getObject("MathScore").toString()), Float.parseFloat(rs.getObject("EnglishScore").toString()), rs.getObject("password").toString());
                }
                return student;
            } else if ("admin".equals(role) && "login".equals(type)) {
                while (rs.next()) {
                    administrator = new Administrator(Long.valueOf(rs.getObject("id").toString()), rs.getObject("name").toString(), rs.getObject("password").toString());
                }
                return administrator;
            } else if ("teacher".equals(role) && "login".equals(type)) {
                while (rs.next()) {
                    teacher = new Teacher(Long.valueOf(rs.getObject("id").toString().toString()), rs.getObject("name").toString(), rs.getObject("className").toString(), rs.getObject("password").toString());
                }
                return teacher;
            } else if ("admin".equals(role) && "studentList".equals(type) || "teacher".equals(role) && "studentList".equals(type) || "student".equals(role) && "selfGrades".equals(type)) {
                   System.out.println("班级\t\t学号\t\t姓名\t\tJava\t\tMath\t\tEnglish\t\t");
                while (rs.next()) {
                    System.out.format("%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t\n",
                            rs.getObject("className"),
                            rs.getObject("id"),
                            rs.getObject("name"),
                            rs.getObject("JavaScore"),
                            rs.getObject("MathScore"),
                            rs.getObject("EnglishScore")
                    );
                }
                System.out.println("--------------------------------------------");
            } else if ("admin".equals(role) && "teacherList".equals(type)) {
                if (rs!=null){
                    System.out.println("id\t\t姓名\t\t任教班级\t\t");
                }
                while (rs.next()) {
                    System.out.format("%s\t\t\t%s\t\t\t%s\n",
                            rs.getObject("id"),
                            rs.getObject("name"),
                            rs.getObject("className")
                    );
                }
                System.out.println("--------------------------------------------");
            }else if("teacher".equals(role)&&("MathScore").equals(type)||"teacher".equals(role)&&("EnglishScore").equals(type)||"teacher".equals(role)&&("JavaScore").equals(type)){
                System.out.println("班级\t\t学号\t\t姓名\t\t该科分数\t\t");
                while (rs.next()) {
                    System.out.format("%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\n",
                            rs.getObject("className"),
                            rs.getObject("id"),
                            rs.getObject("name"),
                            rs.getObject(type)) ;
                        return null;
                }
                System.out.println("无该学生");
                System.out.println("--------------------------------------------");
            }
            else if("teacher".equals(role)&&("top").equals(type)||"teacher".equals(role)&&("bottom").equals(type)){
                System.out.println("班级\t\t学号\t\t姓名\t\t");
                while (rs.next()) {
                    System.out.println("----------"+type.toUpperCase()+"--------------");
                    System.out.format("%s\t\t\t%s\t\t\t%s\t\t\n",
                            rs.getObject("className"),
                            rs.getObject("id"),
                            rs.getObject("name"));
                    //回车
                    System.out.println();


                    return null;
                }
                System.out.println("无该学生");
                System.out.println("--------------------------------------------");
            } else if("teacher".equals(role)&&("fail").equals(type)){
                System.out.println("班级\t\t学号\t\t姓名\t\t");
                while (rs.next()) {
                    System.out.format("%s\t\t\t%s\t\t\t%s\t\t\t\n",
                            rs.getObject("className"),
                            rs.getObject("id"),
                            rs.getObject("name"));

                    return null;
                }
                System.out.println("没有符合条件的学生");
                System.out.println("--------------------------------------------");
            }
            rs.close();
            statement.close();
            conn.close(); // 关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static int delete(String sql)throws SQLException {
        // 同样先要获取连接，即连接到数据库
        MyDataSource dataSource = new MyDataSource();
        Connection conn = dataSource.getConnection();
        int count = 0;
        try {
            Statement statement = (Statement) conn.createStatement();
            count = statement.executeUpdate(sql);
            System.out.println("成功删除!");
            statement.close();
            // 关闭数据库连接
            conn.close();

        } catch (SQLException e) {
            System.out.println("删除数据失败");
        }
        return count;
    }
}

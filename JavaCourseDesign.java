package LeetCode.ywf.JavaCourseDesign;

import java.sql.SQLException;
import java.util.Scanner;




public class JavaCourseDesign {


    public static void main(String[] args)  throws  SQLException{
        Scanner sca = new Scanner(System.in);

        while (true) {
            System.out.println("=小亦图书管理系统-V1.0=");
            System.out.println("1.登录");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            int option = sca.nextInt();
            if (option == 1) {
                login();
            } else if (option == 2) {

            } else {
                return;
            }
        }
    }

    public static void login() throws SQLException {
        while (true) {
            Scanner sca = new Scanner(System.in);
            System.out.println("=小亦图书管理系统-V1.0=");
            System.out.println("1.管理员登录");
            System.out.println("2.学生登录");
            System.out.println("3.教师登录");
            System.out.println("4.退出");
            System.out.println("请输入你的选择：");
            int option = sca.nextInt();
            if (option == 1) {
                System.out.println("输入你的姓名:");
                String name = sca.next();
                System.out.println("输入你的密码:");
                String password = sca.next();
                Administrator administrator = (Administrator) SqlUtil.query("select * from administrator where name = '" + name + "' and password = '" + password + "'", "admin", "login");
                if (administrator.getId() != null) {
                    System.out.println("登录成功！");
                    AdminManager.getManager(administrator);
                } else {
                    System.out.println("用户名或密码错误！");
                }
            } else if (option == 2) {
                System.out.println("输入你的id:");
                String id = sca.next();
                System.out.println("输入你的密码:");
                String password = sca.next();
                Student student = (Student) SqlUtil.query("select * from student where id = '" + id + "' and student.password = '" + password + "'", "student", "login");
                if (student.getId() != null) {
                    System.out.println("登录成功!");
                    StudentManager.getManage(student);
                } else {
                    System.out.println("用户名或密码错误！");
                }
            } else if (option == 3) {
                System.out.println("输入你的姓名:");
                String name = sca.next();
                System.out.println("输入你的密码:");
                String password = sca.next();
                Teacher teacher = (Teacher) SqlUtil.query("select * from teacher where name = '" + name + "' and password = '" + password + "'", "teacher", "login");
                if (teacher.getId() != null) {
                    System.out.println("登录成功！");
                    TeacherManager.getManager(teacher);
                } else {
                    System.out.println("用户名或密码错误！");
                }
            } else if (option == 4) {
                return;
            }
        }
    }


}

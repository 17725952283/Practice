package com.ywf.JavaCourseDesign;

import java.sql.SQLException;
import java.util.Scanner;



public class StudentManager {
    public static void getManage(Student student)throws SQLException {
        while (true) {
            Scanner sca = new Scanner(System.in);
            System.out.println("=小亦图书管理系统-V1.0=");
            System.out.println("请输入你的选择：");
            System.out.println("1.查询成绩");
            System.out.println("2.修改密码");
            System.out.println("3.退出");
            int option = sca.nextInt();
            if (option == 1) {
                SqlUtil.query("select * from student where name = '" + student.getName()+"'", "student", "selfGrades");
            } else if (option == 2) {
                System.out.println("请输入新密码：");
                String password = sca.next();
                int update = SqlUtil.update("update student set password = '" + password + "' where name = '" + student.getName() + "'");
                if (update > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
            } else if (option == 3) {
                return;
            }else {
                System.out.println("输入错误,请重新输入");
            }
        }
    }
}

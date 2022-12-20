package com.ywf.JavaCourseDesign;

import java.sql.SQLException;
import java.util.Scanner;



public class TeacherManager {
    public static void getManager(Teacher teacher) throws SQLException {
        String[] split = teacher.getClassName().split(",");

        String className = "";
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                className +=  split[i]+"班" ;
            } else {
                className +=  split[i] + "班、";
            }
        }
        while (true){
            Scanner sca = new Scanner(System.in);
            System.out.println("=小亦图书管理系统-V1.0=");
            System.out.println("请输入你的选择：");
            System.out.println("1.查看班级成员信息");
            System.out.println("2.修改成绩");
            System.out.println("3.查询某学生和某门课程各班学生的成绩");
            System.out.println("4.查询某个班级某门课程的最高分、最低分及相应学生姓名、班级和学号。");
            System.out.println("5.列表显示某个班级某门课程成绩不及格的学生");
            System.out.println("3.退出");
            int option = sca.nextInt();
            if (option == 1) {
                //你任教的班级有
                System.out.println("你任教的班级有：【"+className+"】,请问你要修改哪个班级的成员信息？(输入班级号即可)");
                String className1 = sca.next();
                if (className.contains(className1)) {
                    SqlUtil.query("select * from student where className = '" + className1+"'", "student", "selfGrades");
                } else {
                    System.out.println("输入错误");
                    continue;
                }
                //转化为studentlist
//            List<Student> studentList = (List<Student>) query;

            } else if (option == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("你任教的班级有：【"+className+"】,请问你要修改哪个班级的成员信息？(输入班级号即可)");
                String className1 = scanner.next();
                if (!className.contains(className1)) {
                    System.out.println("不是您任教的班级,无法修改!");
                    continue;
                }
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入需要修改学生课程名称（Java,高数、英语）：");
                String course = scanner.next();
                if ("Java".equals(course))
                {
                    course="JavaScore";
                }else if ("高数".equals(course))
                {
                    course="MathScore";
                }else if ("英语".equals(course))
                {
                    course="EnglishScore";
                }
                System.out.println("请输入需要修改学生课程成绩：");
                int score = scanner.nextInt();
                int update = SqlUtil.update("update student set " + course + " = " + score + " where name = '" + name + "' and className = '" + className1 + "'");
                if (update > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
            } else if (option == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入需要查询学生课程名称（Java、高数、英语）：");
                String course = scanner.next();
                if ("Java".equals(course))
                {
                    course="JavaScore";
                }else if ("高数".equals(course))
                {
                    course="MathScore";
                }else if ("英语".equals(course))
                    {
                    course="EnglishScore";
                }else {
                    System.out.println("输入错误");
                }
                SqlUtil.query("select * from student where name = '"+name+"'", "teacher",course);
            } else if (option == 4) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("你任教的班级有：【"+className+"】,请问你要查询哪个班级的成员信息？(输入班级号即可)");
                String className1 = scanner.next();
                if (!className.contains(className1)) {
                    System.out.println("输入错误");
                    continue;
                }
                System.out.println("请输入需要查询学生课程名称（Java、高数、英语）：");
                String course = scanner.next();
                if ("Java".equals(course))
                {
                    course="JavaScore";
                }else if ("高数".equals(course))
                {
                    course="MathScore";
                }else if ("英语".equals(course))
                {
                    course="EnglishScore";
                }else {
                    System.out.println("输入错误");
                }
                SqlUtil.query("select name,id,className from student where className = '"+className1+"'and "+course+"="+"(select MAX("+course+") from student where className = '"+className1+"')", "teacher","top");
                SqlUtil.query("select name,id,className from student where className = '"+className1+"'and "+course+"="+"(select MIN("+course+") from student where className = '"+className1+"')", "teacher","bottom");
            } else if (option == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("你任教的班级有：【"+className+"】,请问你要查询哪个班级的成员信息？(输入班级号即可)");
                String className1 = scanner.next();
                if (!className.contains(className1)) {
                    System.out.println("输入错误");
                    continue;
                }
                System.out.println("请输入需要查询学生课程名称（Java、高数、英语）：");
                String course = scanner.next();
                if ("Java".equals(course))
                {
                    course="JavaScore";
                }else if ("高数".equals(course))
                {
                    course="MathScore";
                }else if ("英语".equals(course))
                {
                    course="EnglishScore";
                }else {
                    System.out.println("输入错误");
                }
                SqlUtil.query("select * from student where className = '"+className1+"' and "+course+"<60", "teacher","fail");

            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}

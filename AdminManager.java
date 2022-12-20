package com.ywf.JavaCourseDesign;

import java.sql.SQLException;
import java.util.Scanner;



    public class AdminManager {
    public static void getManager(Administrator administrator) throws SQLException {
        while (true) {
            Scanner sca = new Scanner(System.in);
            System.out.println("=小亦图书管理系统-V1.0=");
            System.out.println("1.添加");
            System.out.println("2.修改");
            System.out.println("3.删除");
            System.out.println("4.查询");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            int option = sca.nextInt();
            if (option == 1) {
                System.out.println("你想添加(学生、教师)?");
                String add = sca.next();
                if ("学生".equals(add)) {
                    System.out.println("请输入学生姓名：");
                    String name = sca.next();
                    System.out.println("请输入学生密码：");
                    String password = sca.next();
                    System.out.println("请输入学生班级：");
                    String className = sca.next();
                    int update = SqlUtil.insert("insert into student(id,name,password,className) values('" + IdGenerater.nextId() + "','" + name + "','" + password + "','" + className + "')");
                    if (update > 0) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                } else if ("教师".equals(add)) {
                    System.out.println("请输入教师姓名：");
                    String name = sca.next();
                    System.out.println("请输入教师密码：");
                    String password = sca.next();
                    System.out.println("请输入教师任教班级(多个班级请用 ',' 隔开)：");
                    String className = sca.next();
                    int update = SqlUtil.insert("insert into teacher(id,name,password,className) values('" + IdGenerater.nextId() + "','" + name + "','" + password + "','" + className + "')");
                    if (update > 0) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                }
            } else if (option == 2) {
                System.out.println("你想修改(学生、教师)?");
                String add = sca.next();
                if ("学生".equals(add)) {
                    System.out.println("你想修改(学生姓名、学生密码、学生班级)?");
                    String add1 = sca.next();
                    if ("学生姓名".equals(add1)) {
                        System.out.println("请输入学生姓名：");
                        String name = sca.next();
                        System.out.println("请输入学生新姓名：");
                        String newName = sca.next();
                        int update = SqlUtil.update("update student set name = '" + newName + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    } else if ("学生密码".equals(add1)) {
                        System.out.println("请输入学生姓名：");
                        String name = sca.next();
                        System.out.println("请输入学生新密码：");
                        String newPassword = sca.next();
                        int update = SqlUtil.update("update student set password = '" + newPassword + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    } else if ("学生班级".equals(add1)) {
                        System.out.println("请输入学生姓名：");
                        String name = sca.next();
                        System.out.println("请输入学生新班级：");
                        String newClassName = sca.next();
                        int update = SqlUtil.update("update student set className = '" + newClassName + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                } else if ("教师".equals(add)) {
                    System.out.println("你想修改(教师姓名、教师密码、教师班级)?");
                    String add1 = sca.next();
                    if ("教师姓名".equals(add1)) {
                        System.out.println("请输入教师姓名：");
                        String name = sca.next();
                        System.out.println("请输入教师新姓名：");
                        String newName = sca.next();
                        int update = SqlUtil.update("update teacher set name = '" + newName + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    } else if ("教师密码".equals(add1)) {
                        System.out.println("请输入教师姓名：");
                        String name = sca.next();
                        System.out.println("请输入教师新密码：");
                        String newPassword = sca.next();
                        int update = SqlUtil.update("update teacher set password = '" + newPassword + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    } else if ("教师班级".equals(add1)) {
                        System.out.println("请输入教师姓名：");
                        String name = sca.next();
                        System.out.println("请输入教师新班级：");
                        String newClassName = sca.next();
                        int update = SqlUtil.update("update teacher set className = '" + newClassName + "' where name = '" + name + "'");
                        if (update > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                }
            } else if (option == 3) {
                System.out.println("你想删除(学生、教师)?");
                String add = sca.next();
                if ("学生".equals(add)) {
                    System.out.println("请输入学生姓名：");
                    String name = sca.next();
                    int update = SqlUtil.delete("delete from student where name = '" + name + "'");
                    if (update > 0) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                } else if ("教师".equals(add)) {
                    System.out.println("请输入教师姓名：");
                    String name = sca.next();
                    int update = SqlUtil.delete("delete from teacher where name = '" + name + "'");
                    if (update > 0) {
                        System.out.println("删除成功");
                    }

                }
            }else if (option==4)
            {
                System.out.println("你想查询(学生、教师)?");
                String search = sca.next();
                if ("学生".equals(search)) {
                    System.out.println("请输入学生姓名：");
                    String name = sca.next();

                    Object query = SqlUtil.query("select * from student where name = '" + name + "'", "admin", "studentList");
                } else if ("教师".equals(search)) {
                    System.out.println("请输入教师姓名：");
                    String name = sca.next();
                    Object query = SqlUtil.query("select * from teacher where name = '" + name + "'", "admin", "teacherList");
                }
            }else if(option==5){
                return;
            }else {
                System.out.println("输入错误,请重新输入");
            }
        }
    }
}

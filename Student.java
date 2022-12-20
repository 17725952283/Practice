package com.ywf.JavaCourseDesign;



public class Student {
    private  Long id;
    private  String name;
    private  String className;


    private String password;
    private float JavaScore;
    private float MathScore;
    private float EnglishScore;

    public Student() {

    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", JavaScore=" + JavaScore +
                ", MathScore=" + MathScore +
                ", EnglishScore=" + EnglishScore +
                ", password='" + password + '\'' +
                '}';
    }


    public Student(Long id, String name, String className, float javaScore, float mathScore, float englishScore, String password) {
        this.id = id;
        this.name = name;
        this.className = className;
        JavaScore = javaScore;
        MathScore = mathScore;
        EnglishScore = englishScore;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getJavaScore() {
        return JavaScore;
    }

    public void setJavaScore(float javaScore) {
        JavaScore = javaScore;
    }

    public float getMathScore() {
        return MathScore;
    }

    public void setMathScore(float mathScore) {
        MathScore = mathScore;
    }

    public float getEnglishScore() {
        return EnglishScore;
    }

    public void setEnglishScore(float englishScore) {
        EnglishScore = englishScore;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

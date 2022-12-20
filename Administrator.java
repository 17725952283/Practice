package com.ywf.JavaCourseDesign;



public class Administrator {
    private  Long id;
    private  String password;
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public Administrator()
    {
    }

    public Administrator(Long id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}

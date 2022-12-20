package LeetCode.ywf.JavaCourseDesign;



public class Teacher {
    private  Long id;
    private  String name;
    private  String className;
    private  String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Teacher(Long id, String name, String className, String password) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.password = password;
    }
    public Teacher() {
    }
}

public class Employee {

    private String name;
    private int age;
    private String departmentName;

    public Employee(String name, int age, String departmentName) {
        this.name = name;
        this.age = age;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

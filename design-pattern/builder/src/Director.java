import java.util.List;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        super();
        this.builder = builder;
    }

    public void construct(List<Employee> employeeList) {
        builder.makeHeader();
        builder.makeEmployeeList(employeeList);
    }
}

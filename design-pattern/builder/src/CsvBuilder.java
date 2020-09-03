import java.util.List;

public class CsvBuilder extends Builder {
    StringBuffer sb = new StringBuffer();

    @Override
    public void makeHeader() {
        sb.append("氏名,年齢,部署名¥n");
    }

    @Override
    public void makeEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            sb.append(employee.getName() + ",");
            sb.append(employee.getAge() + ",");
            sb.append(employee.getDepartmentName() + "¥n");
        }
        sb.substring(0, sb.length() - 1);
    }

    public String getResult() {
        return sb.toString();
    }
}

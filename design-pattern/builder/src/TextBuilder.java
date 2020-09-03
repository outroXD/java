import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextBuilder extends Builder {
    StringBuffer sb = new StringBuffer();

    @Override
    public void makeHeader() {
        sb.append("==================¥n");
        sb.append("従業員一覧¥n");
        sb.append("==================¥n");
    }

    @Override
    public void makeEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            sb.append("氏名：" + employee.getName() + "¥n");
            sb.append("年齢：" + employee.getAge() + "¥n");
            sb.append("部署名：" + employee.getDepartmentName() + "¥n");
            sb.append("¥n");
        }
    }

    public String getResult() {
        String fileName = "employee.txt";
        File file = new File(fileName);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}

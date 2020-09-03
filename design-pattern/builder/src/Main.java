import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        Employee yamada = new Employee("山田太郎", 30, "営業");
        employeeList.add(yamada);
        Employee tanaka = new Employee("田中花子", 29, "総務部");
        employeeList.add(tanaka);

        // CSV作成
        CsvBuilder csvBuilder = new CsvBuilder();
        Director csvDirector = new Director(csvBuilder);
        csvDirector.construct(employeeList);
        String csv = csvBuilder.getResult();
        System.out.println(csv);
        System.out.println();

        // テキストファイル作成
        TextBuilder textBuilder = new TextBuilder();
        Director textDirector = new Director(textBuilder);
        textDirector.construct(employeeList);
        String textFile = textBuilder.getResult();
        System.out.println(textFile + "を作成しました。");
    }
}

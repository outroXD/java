import java.util.List;

public abstract class Builder {
    // ヘッダー生成
    public abstract void makeHeader();

    // 一覧生成
    public abstract void makeEmployeeList(List<Employee> employeeList);

}

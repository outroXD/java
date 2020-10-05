import java.text.SimpleDateFormat;
import java.util.Date;

public interface WeekState {
    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public void setDate(Shop shop);

    public void open(Date date);

    public void close(Date date);
}

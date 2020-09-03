package greeting;

public interface Greeting {
    /**
     * 朝の挨拶を返す
     * @return
     */
    String getMornig();

    /**
     * 昼下がりの挨拶を返す
     * @return
     */
    String getAfternoon();

    /**
     * 夕方以降の挨拶を返す
     * @return
     */
    String getEvening();

    /**
     * 引数langを自分自身がサポートしているかどうかを返す
     * @param lang
     * @return
     */
    boolean isSupported(String lang);
}

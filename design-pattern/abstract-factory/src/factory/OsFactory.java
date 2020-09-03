package factory;

public abstract class OsFactory {
    // Factoryクラスの生成用メソッド
    public static OsFactory getFactory(String className) {
        OsFactory factory = null;

        try {
            factory = (OsFactory) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(className + "が見つかりません。");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factory;
    }

    // FileSystem生成用メソッド
    public abstract OsFileSystem createFileSystem();

    // DisplaySyste生成用メソッド
    public abstract OsDisplaySystem createDisplaySystem();
}
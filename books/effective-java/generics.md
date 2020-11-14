# ジェネリクス
* データの型をパラメータとして渡すことで、汎用的なメソッドなどを定義できる。
* Java1.5まではObject型で書かれていたが、それ以降は総称型が導入された。

## 具体例：Listに対するget
### バージョン1.5以前
```java
public Object get(int index)
```
* 返却値がObject型なので、実態は取り出してみるまでわからなかった。
### バージョン1.5以降
```java
public E get(int index)
```
* Eが返却されている。具体的な型名ではないが、何か1つの型であることが確定している。

## 書き方
### クラス
* クラス名の後ろで総称型を定義。
```java
class static class ClassName<T> {
    private T field;
}
```
### メソッド
* 戻り値の直前に総称型を定義。
* 総称型の具体的な型は、コンパイラが引数の型から推測するので、明示的に与える必要はない。
* 同一の総称型に複数の型を与えるとObject型として処理される。
```java
public static <T> T getValue(final T val, final T defaultValue) {
  return val == null ? defaultValue : val;
}

@Test
 public void method_test() {
   assertThat(getValue(null, "hoge")).isEqualTo("hoge");
   assertThat(getValue(null, 1)).isEqualTo(1);
   assertThat(getValue("hoge", 1)).isEqualTo("hoge"); // Object として判断されている
}
```
### コンストラクタ
* コンストラクに対しても総称型を定義できるが、クラスとは異なりメンバで総称型を使用することはできない。
```java
@Data
public static class GenericsA {
  public <T> GenericA(T args) {
    System.out.println(args);
 }
}

@Test
public void constructor_test() {
  GenericsA genericA = new GenericsA("hoge");
}
```

## 参考
* [シグネチャに、T とか、K とか書いてあると API そっ閉じしちゃうジェネリクス フォビア向けに、Java の総称型を説明してみた](http://kusamakura.hatenablog.com/entry/2017/01/10/%E3%82%B7%E3%82%B0%E3%83%8D%E3%83%81%E3%83%A3%E3%81%AB%E3%80%81T_%E3%81%A8%E3%81%8B%E3%80%81K_%E3%81%A8%E3%81%8B%E6%9B%B8%E3%81%84%E3%81%A6%E3%81%82%E3%82%8B%E3%81%A8_API_%E3%81%9D%E3%81%A3%E9%96%89)

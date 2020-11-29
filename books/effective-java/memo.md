# 2章 オブジエクトの生成と消滅
## 項目1 コンストラクタの代わりにstaticファクトリメソッドを検討する
* `サブタイプ`
  * あるプログラムに対して、型Sを型Tと見なすことができる場合、「SはTのサブタイプである」という。
  * = サブクラス、派生クラス
* `派生クラス`
  * クラスの親子関係が成り立つ場合の子側のクラスのことである。
* クラスのインスタンスを使う方法。
  * publicコンストラクタの提供。
  * publicのstaticファクトリメソッドの提供。
    * クラスのインスタンスを返却するstaticメソッド。
* publicのstaticファクトリメソッド。
  * 長所
    * 名前を持つ。
      * コンストラクタだと名前はクラス名に限定される。
      * BigInteger(int, int, Random)よりBigInteger.probablePrimeというstaticファクトリメソッドの方がわかりやすい。
    * コンストラクタと異なり、呼び出し毎に新たにオブジェクトを生成する必要がない。
      * immutableクラス、オブジェクトのキャッシュ。
      * シングルトン、インスタンス化不可にできる。
    * コンストラクタと異なり、メソッドの戻り値型の任意のサブタイプのオブジェクトを返せる。
    * 返されるオブジェクトのクラスは、入力パラメータの値に応じて呼び出し毎に変えられる。
  * 短所
    * 戻り値型のサブクラスを作れない。
    
## 項目2 多くのコンストラクタパラメータに直面したときにはビルダーを検討する
* 多くのオプションパラメータがある場合にどうするかという問題。
* `テレスコーピング・コンストラクタ・パターン`が使われてきた。
  * コンストラクタを引数で数パターン用意するやり方。
* `JavaBeansパターン`
  * setterによりセットする。パラメータの正統性を確保できない。
  * setterで内部の状態を変更できるので、クラスを不変にできない。
* `Builderパターン`
  * build()でインスタンス化する前に、パラメータ間の不整合を検知できる。
  * クラス階層
  * `共変戻り値型付け`
    * サブクラスのメソッドが、スーパークラスで宣言された戻り値型のサブタイプを返すと宣言する技法。
    * 具体例はchap2のソース。
    
## 項目3 privateのコンストラクタかenum型でシングルトン特性を強制する
* シングルトンの雛形
* staticファクトリメソッドによる実装の長所。
  * ジェネリックのシングルトンファクトリをかける。
* シリアライズ可能なシングルトンクラスの実装。
  * `implements Serializable`を実装する。
  * 全てのインスタンスフィールドを`@transient`と宣言する。
  * `readResolve`メソッドを提供する。

## 項目4 privateのコンストラクタでインスタンス化不可能を強制する
* staticなフィールド・メソッドだけで構成されるクラスは、一般的にユーティリティクラスと呼ばれる。
  * そのようなクラスは本来インスタンス化して使うものではないが、コンストラクタが使えるとインスタンス化される恐れがある。
* クラスを抽象化してインスタンス化できないことを強制する。
  * そのクラスのサブクラスは作れてしまう。
  * サブクラスはインスタンス化できてしまう。
  * 継承して使うものだとユーザーを錯覚させてしまう。
* クラスのインスタンス化をできないようにする。
  * クラスにprivateのコンストラクタを含める。
  * 全てのコンストラクタは、明示的・暗黙的にスーパークラスのコンストラクタを呼び出さなければならないので、サブクラス化することも防げる。
  
## 項目5 資源を直接結び付けるよりも依存性注入を選ぶ
* 複数のインスタンスに対するサポートを提供するユーティリティ系の実装について。
  * シングルトンや静的(static)ユーティリティは不適。
  * シングルトンクラスや静的ユーティリティクラスが内部に状態を持つと、テストしづらく、状態の切り替えが必要になった時対応できない。
  * setterで内部状態にアクセス可能にする方法も考えられるが、利用者にとってわかりづらく、スレッドセーフでもない。
* `依存性注入`
  * 新しいインスタンスを生成するときにコンストラクタに資源を渡す。
* `ファクトリ`
  * 依存性注入の応用形。
  * コンストラクタに資源ファクトリを渡す。
  * `Supplier<T>`はファクトリを表現するにに最適。
### `Supplier<T>`について。
* 引数を取らないけど、返り値は存在する挙動を定義するためのインターフェース。
* 具体例
    ```java
    // 引数なしで、型Tのインスタンスを返却する関数を実装
    Supplier<T> supplier = () -> new T();
    // 実際に呼び出す
    supplier.get();
    ```
* get()が呼ばれるまで処理が行われない為、遅延評価とも呼ばれる。

## 項目8 ファイナライザーとクリーナーを避ける
* 原則としてファイナライザの使用は避ける。
* Java9からは代替としてクリーナーが存在する。
* ファイナライザ・クリーナーの欠点
  * 即座に実行される保証がない。
    * 実行までに時間がかかる場合があるので、速度の求められる場面で使うべきではない。
    * JVMの実装により、実行までの時間は異なる。
  * ファイナライズの処理中にスローされた例外がキャッチされなかった場合、オブジェクトの状態を不正なままにしてしまう可能性がある。
    * 通常キャッチされなかった例外はスレッドを終了さセル。
   
    
# 3章 すべてのオブジェクトに共通のメソッド
## 項目10 equalsをオーバーライドするときは一般契約に従う
* Objectに所属するfinalでない全てのメソッドはオーバーライドされるように設計されていて、明示的な`一般契約`を持っている。
  * 一般契約に従うことは、それらメソッドをオーバーライドするクラスの責任。

### equalsをオーバーライドしないのが正しい場合
  * クラスのここのインスタンスがシステム上一意である。
  * クラスのインスタンス同士で論理的等価性を検査する必要がない
  * スーパークラスが既にequalsをオーバーライドしていて、スーパークラスの振る舞いがこのクラスに対して適切である。
  * クラスがprivateあるいはパッケージプライベートであり、そのequalsメソッドが呼び出されないことが確かである。

###equalsをオーバーライドするのが正しい場合
* クラスが`論理的等価性`という概念を持っていて、かつスーパークラスがequalsをオーバーライドしていないとき。
  * `値クラス`であるとき。

#### equalsメソッドをオーバーライドするときの一般契約(同値関係)
* `同値関係`とは要素の集合を、互いに等しいと思える要素を持つ部分集合に分割する演算子。
* 一般契約を破ってしまうと、他のオブジェクトがその契約を破っているオブジェクトを扱う時、どのように振舞うか分からない。
##### 同値関係の性質
* 反射的
  * オブジェクトがそれ自身と等しくなることを保証する。
* 対称的
  * いかなる2つのオブジェクトでも、それらが等しいかどうかについて合意しなければならない。
* 推移性
  * 1つ目のオブジェクトが2爪のオブジェクトと等しく、2つ目のオブジェクトが3つ目のオブジェクトと等しい場合、1つ目のオブジェクトは3つ目のオブジェクトと等しくなければならない。
  * インスタンス化可能なクラスを拡張して、equalsの契約を守ったまま値要素を追加する方法はない。
  * 継承よりコンポジションを選ぶことで、上記問題を回避できる。
* 整合的
* nullではない任意の参照値xに対して、x.equals(null)はfalseを返さなければならない。

## 項目12 toStringを常にオーバーライドする
* toStringをオーバーライドして優れた実装を提供することはデバッグに役立つ。
* 実用的なtoStringメソッドはオブジェクトに含まれる、興味がある全ての情報を含むべき。
  * 電話番号のような`値クラス`は明示するべき。
* toStringが出力する値の「意図」はコメントで明示する。

## 項目14 Comparableの実装を検討する
* equalsと比べて単純な同値比較に加えて順序比較を許している点が異なる。
* クラスがComparableを実装することで、インスタンスが自然な順序を持っていることを示せる。
  * 例：アルファベット順、数値順、年代順など
### Comparableをオーバーライドするときの一般契約
* compareToの契約を破っているクラスは比較に依存している他のクラスを機能させなくする。
1. `sgn(x.compareTo(y)) == -sgn(y.compareTo(x))`を保証する。
   * 2つのオブジェクト参照間での比較の向きを逆にした場合に上記が成り立つこと。(= 順序を逆にして比較した場合、結果の符号も逆になる)
   * 1つ目のオブジェクトが2つ目のオブジェクトより小さければ、2つ目のオブジェクトは1つ目のオブジェクトよりも大きくなければならない。
   * 1つ目のオブジェクトが2つ目のオブジェクトと等しければ、2つ目のオブジェクトは1つ目のオブジェクトと等しくなければならない。
   * 1つ目のオブジェクトが2つ目のオブジェクトより大きければ、2つ目のオブジェクトは1つ目のオブジェクトよりも小さくなければならない。
2. `(x.compareTo(y) > 0 && y.compareTo(z) > 0)なら、x.compareTo(z) > 0`
   * 推移的な関係を満たす。
3. `x.compareTo(y) == 0なら、sgn(x.compareTo(z)) == sgn(y.compareTo(z))`
   * xとyの順序が等しいなら、それぞれを他のオブジェクトzと比較したとき、同じ結果にならなければならない。
4. `x.compareTo(y) == 0 なら、x.equals(y)はtrueになるし、その逆も成立する`
   * この条件は必須ではないが、満たすことが好ましい。

* (1)〜(3)に関しての注意点
  * Comparableを実装している既存のクラスがあったとして、それを継承して新たなフィールドを追加する場合、これらの要件を満たすことはできない。
    * 軽症ではなくコンポジションを使う。
  * sgn(expression)は、expressionが負、ゼロ、正の時にそれぞれ-1, 0, 1を返す関数。
* (4)に関しての注意点
  * この契約を破っている場合、Collections、Set、Mapの一般契約に従わないかもしれないので、適切に機能しないかもしれない。
    * ソートされたコレクションはequalsの代わりにcompareToにより行われる同値検査を使っているから。


* compareToメソッドでは同値比較ではなく、順序比較される。
  * オブジエクト参照の比較には、compareToメソッドを再帰的に呼び出す。
    * compareToにおいてそれらを比較する順序は重要。意味のあるフィールドから、意味の弱いフィールドの順に比較を行う。
    
### 実装例
```java
public int compareTo(PhoneNumber pn) {
  int result = Short.compare(areaCode, pn.areaCode);
  if (result == 0) {
    result = Short.compare(prefix, pn.prefix);
    if (result == 0) {
      result = Short.compare(lineNum, pn.lineNum);
    }
  }
  return result;
}
```
Java8以降ではコンパレータ構築メソッドを使って以下のようにもかける。
```java
private static final Comparator<PhoneNumber> COMPARATOR = 
    comparingInt((PhoneNumber pn) -> pn.areaCode)
        .thenComparingInt(pn -> pn.prefix)
        .thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn) {
    return COMPARTOR.compare(this, pn);
}
```
以下のようなcompareTo, compareイディオムが書かれていることがあるが、`整数オーバーフロー`と`浮動小数点の副作用`の危険性がある。  
また推移性も満たしていない。
```java
static Compare<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return o1.hashCode() - o2.hashCode();
    }
}
```
良い例が下記。
```java
static Compare<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

static Comparator<Object> hashCodeOrder = 
    Comparator.comparingInt(o -> o.hashCode());
```
compareToメソッドの実装ないでフィールドの値を比較するときは、`>`, `<`を使わないこと。  
compareメソッドやコンパレータ構築メソッドを使用する。


# 4章 クラスとインターフェース
## 項目15 クラスとメンバーへのアクセス可能性を最小限にする
### 情報隠蔽・カプセル化
コンポーネントの外部からアクセスできる部分(公開API)を最小限にすること。  
public, protectedで宣言するもの。
### 情報隠蔽・カプセル化をする理由
コンポーネントを個別に開発・テスト・最適化・利用・理解・修正するため。  
### 情報隠蔽・カプセル化をどうやるか
1. クラス・インターフェース・メンバーのアクセス可能性を指定する。
2. 大まかなやり方は各クラスやメンバーへのアクセスを可能な限りできないようにする。
3. トップレベルのクラス
  * パッケージプライベート
    * パッケージの公開APIではないと言う解釈ができる。
  * public
4. 可変なオブジェクト(Listの要素とか)は利用者に中身を変更されてしまう恐れがあるので、定数として公開するのはNG。代わりに不変なオブジェクトに変換して公開するか、コピーを返すべき。
#### 4. 不変なオブジェクト・コピーを返す
```java
private static final Thing[] PRIVATE_VALUES = {...};
public static final List<Thing> VALUES = 
    Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
```
```java
private static final Thing[] PRIVATE_VALUES = {...};
public static final Thing[] values() {
    return PRIVATE_VALUES.clone();
}
```

## 項目16 publicのクラスでは、publicのフィールドではなく、アクセっさーメソッドを使う
### getter/setterを使う理由
* フィールドに直接アクセスするとカプセル化することで得られる恩恵を得られない。
* APIを変更せず、表現形式(=型?)を変更できない。
* 不変式の強制ができない。
* フィールド変更時の補助処理ができない。
  * バリデーション
  * フィールド間の整合性チェックなど
  
## 項目17 可変性を最小限にする
### 利点
* `不変クラス`とはそのインスタンスが変更できないクラスで、設計・実装・使用が可変クラスより容易。
* クラスを不変にできないのであれば、その可能性をできるだけ制限するべき。
  * 妥当な理由がない限りすべてのフィールドをprivate finalと宣言するべき。
* スレッドセーフ。
* インスタンスを共有できるので、オブジェクト生成コスト・メモリ消費量を抑えられる。
* `エラーアトミック性`を持つ。
  * 失敗する前の状態にオブジェクトが戻る性質。
  * 可変オブジェクトでエラーアトミック性を実現するのは手間がかかるが、不変性を持つオブジェクトはその性質上手間がかからない。
### 欠点
* 異なる値を持つような処理を不変オブジェクトを使って処理する場合、システム資源を消費する。
  * 複数処理ステップを1つの公開APIにまとめる。
  * Stringに対するStringBuilderのような、publicな可変コンパニオンクラスを提供する。
### 不変クラスの実装方法
1. オブジェクトの状態を変更するためのメソッドを提供しない。
   * setterなどのオブジェクトの内部状態を変更できるメソッドを提供しない。
2. クラスを拡張できないようにする。
   * 不注意なサブクラス・悪意のあるサブクラスが、オブジエクトの状態が変更されたかのように振舞うことで、クラスの不変な振る舞いを損なわないようにする。
   * サブクラス化を防ぐ → クラスをfinalにする。or コンストラクタをprivateにしてstaticファクトリメソッドを提供する。
3. すべてのフィールドをfinalにする。
   * そのフィールドは変更不可になり、スレッド間でのインスタンスの参照を安全に受け渡しできる。
4. すべてのフィールドをprivateにする。
   * 使用者がフィールドを参照して、可変オブジェクトの状態を変更できないようにする。
5. 可変コンポーネントに対する独占的アクセスを保証する。
   * クラスが可変オブジェクトのフィールドを持っているなら、そレを直接変更できないようにする。
   * コンストラクタ、アクセッサー、readObjectメソッド内では防御的コピーをする。
#### 3. クラスを拡張できないようにする
staticファクトリメソッドを使用する例。
```java
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    } 
}
```
## 項目18 継承よりもコンポジションを選ぶ
ここで扱うのは`実装継承`(あるクラスが他のクラスを拡張した場合の)。  
継承はコードを再利用する強力な方法だが、不適切に使われると脆いソフトウェアを作り出す。  

* 継承はカプセル化を破る。
  * スーパークラスの実装に依存する。スーパークラスの実装が変更されるとサブクラスは機能しなくなる可能性がある。
  * サブクラスがスーパークラスのメソッドをオーバーライドしていなくても、スーパークラスのシグネチャが後の変更でサブクラスのメソッドと被るかもしれない。

### コンポジション
既存クラスを拡張する代わりに、新たなクラスに既存のクラスのインスタンスを参照するprivateのフィールドを持たせる。  
```java
// 転送クラス
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;
    
    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() {
        this.s.clear();
    }
}

public class InstrumentedSet<E> extends ForwardingSet<E> {
    // Setに累計で何回addされたかを保持する。
    private int addCount = 0;
    
    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public bool add(E e) {
        addCount++;
        return super.add(e);
    }
}
```
### 継承を選ぶ場面
* 継承先のクラスが、継承を前提に作られている。
  * JavaDocに記載されているはず。
* 継承先のクラスが、パッケージ内にのみ公開されている場合です（パッケージプライベート）。
* サブクラスがスーパークラスのサブタイプである場合。
  * `is-a関係`が存在すること。
    * 「全てのBはAであるか」

## 項目19 継承のために設計および文書化する、でなければ継承を禁止する
クラスが継承できるための設計・文書化されているとはどういうことか？  

## 項目20 抽象クラスよりもインターフェースを選ぶ
* 「複数の実装を許す型」の定義には`インターフェース`と`抽象クラス`を使うことはできる。
  * インターフェースにもdefaultが導入され、メソッドの実装を提供できるようになった。
  * 抽象クラスで実装を作る場合、サブクラスとして実装しなくてはならない。
  * Javaでは単一継承のみ許可されている。
  * **「複数の実装を許す型」の実装には基本的にインターフェースを使用する。**
### インターフェースが抽象クラスより優れる点
* 利用者は複数のインターフェースを実装できる。Javaではクラスの継承は単一継承のみしか許されていないので、抽象クラスでは複数の実装を行うことができない。
* 既存のクラスが既に何かを継承していたとしても、利用者はそのクラスにインターフェースを導入できる。抽象クラスではこれはできない。
* 利用者は既存のインターフェースを組み合わせることで、新しいインターフェースを作り出せる。これを`ミックスイン`と言う。抽象クラスでもできるが、煩雑になる。
* インターフェースであれば、コンポジションを使える。
#### ミックスイン
```java
import javax.sound.sampled.AudioFileFormat;import java.applet.AudioClip;

public interface Singer {
    AudioClip sing(Song s);
}

public interface Songwriter {
    Song compose(boolean int);
}

public interface SingerSongwriter extends Singer, Songwriter {
    AudioClip sing(Song s);
    Song compose(boolean hit);
}
```

### 実装補助・骨格実装
#### 実装補助
インターフェースのメソッドをdefaultで宣言し、インターフェース内にロジックを実装する。  
骨格実装ではなく、こちらを先に考える。
#### 骨格実装
インターフェースと抽象クラスの長所を組み合わせることができる。  
実装補助を行ったインターフェースを、抽象クラスで実装する。  
インターフェースのdefault実装ではequalsなどのObjectクラスのメソッドを実装できないなどのデメリットがあるが、抽象クラスでそれをカバーできる。

## 項目21 将来のためにインターフェースを設計する
* `定数インターフェース`
  * メソッドを持っていないインターフェースで、クラスで使用する定数のみを定義したインターフェース。
  

定数インターフェースはインターフェースのアンチパターン。  
定数は実装の詳細にあたり、インターフェースを実装するというのは、その部分を公開APIにするということ。  
実装の詳細を公開APIにしてはならない。  

### 定数を外部に提供する方法
* クラスの中に定数を追加する。
  * Integer.MAX_VALUEなど。
* enum型を使う。
* インスタンス化不可能なユーティリティクラスを使う。

#### インスタンス化不可能なユーティリティクラスの例
```java
public class PhysicalConstants {
    // インスタンス化を防ぐ
    private PhysicalConstants() {}
    
    public static final double AVOGADOROS_NUMBER = 6.022_140_857e23;
}
```

## 項目23 タグ付きクラスよりもクラス階層を選ぶ
### タグ付きクラス
* 複数のクラスが1つのクラスに詰め込まれていて、可読性が悪い。
* タグ付きクラスは継承関係で書き換える。
  * ルートは抽象クラスで共通する振る舞いを定義。
  * それを継承して、サブクラスで実装。
* 複数のクラスが一つのクラス内に詰め込まれることで、分岐が増える。
### タグ付きクラスの例
```java
class Figure {
    enum Shape { RECTANGLE, CIRCLE };
    
    // タグフィールド この図形の形
    final Shape shape;
    
    // shapeがRECTANGLEである場合にこのフィールドは使われる
    double length;
    double width;
    
    // shapeがCIRCLEである場合にだけ、このフィールドは使われる
    double radius;
    
    // 円のコンストラクタ
    Figure (double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }
    
    // 長方形のコンストラクタ
    Figure (double length, double width) {  
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE -> length * length;
            case RECTANGLE -> Math.PI * (radius * radius);
            default -> new AssertionError(shape);
        }
    }
}
```
### タグ付きクラスを書き換える
```java
abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    final double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
```

## 項目24 非staticのメンバークラスよりも、staticのメンバークラスを選ぶ
* 他のクラスからアクセスからアクセスされるクラスは、普通のクラスとして定義するべき。
* 
### ネストしたクラス
* ネストしたクラスで、その内部クラスは、それを囲んでいるクラスのみから使用されるべき。
* ネストしたクラスの種類
  * staticのメンバークラス
  * 非staticのメンバークラス
  * 無名クラス
  * ローカルクラス
  * 内部クラス
#### 普通のクラス
```java
class ClassName {
}
```
#### 無名クラス
* エンクロージングクラスの特定のメソッドでしか使わない。
* ネストしたクラスの宣言部が短い。長いと、エンクロージングクラスのメソッドが読みづらいものになってしまいます。
* 一箇所でのみインスタンス化する。
```java
class ParentClass() {
    void doSomething() {}
}

ParentClass parent = new ParentClass() {
    @Override
    void doSomething() {
        // 処理を書く。
    }
}
```
#### ローカルクラス
* ネストした宣言部分のクラスが短い。
* エンクロージングクラスの特定のメソッドでしか使わない。
* そのメソッド内の複数箇所でインスタンス化する。複数箇所で使われるなら、名前付きで宣言しておく必要がおく必要がある。
```java
class OuterA {
    void doSomething() {
        class LocalClass {
        }   
    }
}
```
#### 非staticメンバークラス
* ネストした宣言部分のクラスが長い。 or エンクロージングクラスの、複数のメソッドで利用される。
* エンクロージングクラスのインスタンスにアクセスする必要がある。非staticのメンバークラスがインスタンス化されると、そのインスタンスからエンクロージングクラスのインスタンスを、自動的に参照します。場合によってはこれがメモリリークを引き起こします。その危険性を認識した上で、利用しましょう。
```java
class Outer {
    class Inner {
    }
}
```
#### staticメンバークラス
* static宣言をすることで、エンクロージングオブジェクトへの参照を保存する。よってGCされない。
  * またstatic宣言をしないと、各オブジェクトがエンクロージングオブジェクトへの参照を持ってしまうため、GCの対象にならない可能性がある。
* エンクロージングクラスのインスタンスにアクセスする必要が無い。非staticのメンバークラスのような危険性がありませんので、できるだけこちらを選びましょう。
  * メモリリークの危険性がないので。
```java
class Outer {
    static class Inner {
    }
}
```

## 項目25 ソースファイルを単一のトップレベルのクラスに限定する
* ソースファイルに対して複数のトップレベルクラスを定義できるが、利点はない。
  * 1つのクラスに対して複数の定義が可能になってしまう。
  * どの定義が使われるかはコンパイラの実装依存。

# 5章 ジェネリクス
## 項目26 原型を使わない
* 原型を使わない。
  * 原型を使うと、ジェネリクスの安全性と表現力の全てを失うので、原型は使うべきではない。
  * 実行時にClassCastExceptionが発生する恐れがある。
    * パラメータ化された型を使用すれば、コンパイル時にその誤りに気づくことができる。
### `List`と`List<Object>`の違い
* `List`は「ジェネリック型検査が行われない」一方、後者はコンパイラに対して明示的に「どんなオブジェクトでも保持できること」を伝えている。
* `List`は型安全性を失うが、`List<Object>`などのパラメータ化された型を使えば型安全性を失わない。
* 型安全性
  * 型のミスマッチがある = オブジェクトに対する不正な操作の可能性がある ことをコンパイル時に発見できること。
  
### 用語
* `型パラメータ`
  * 1つ以上の型パラメータ宣言を持つクラスやインターフェースはジェネリクスクラス・ジェネリクスインターフェースである。
  * クラス名やインターフェース名の後に`<>`で囲んで定義する。
```java
class ClassName <T> {
}

interface InterfaceName <T> {
}
``` 
* `パラメータ化された型`
  * `List<String>`のように具体的な型名で定義したもの。
* `原型`
  * `List`のような型パラメータを伴わない宣言。

## 項目27 無検査警告を取り除く
* ジェネリクスを使用してコーディングすると、`無検査警告`が出ることがある。
  * 無検査警告って何？
  * ジェネリクスは実行時に型の情報を持っていないので、型情報を使った検査を行わない。
    * 例えば型パラメータを使って配列を実装するケース
      * 配列は逆に実行時に型情報を持っており、検査したいが、ジェネリクスの仕様により情報がなく検査できない → `無検査警告`を出力。
      * キャストがチェックされない(= ジェネリクス = キャスト??)
      * 実装者がキャストチェックがなくても安全であることを保証しなくてはならない？
```java
static <E> E reduce(List<E> list, Function<E> f, E initVal) {
  E[] snapshot = (E[]) list.toArray(); // リストを内部的にロック
  E result = initVal;
  for (E e : snapshot)
    result = f.apply(result, e);
  return result;
}
```

## 項目28 配列よりもリストを選ぶ
* 歴史的経緯により、配列とジェネリクスは異なる性質を持つ。
* 2つを合わせて使うと問題が起きる。
### 配列の特徴
* `共変`
  * `Object[] objectArr = new Long[1];`では`Long[]`は`Object[]`のサブタイプとして扱われる。
* `具象化されている`
  * 配列は実行時にどんな型を格納できるか知っているので、不適切な型のオブジェクトを代入しようとすると実行時エラーが起きる。
### ジェネリクスの特徴
* `不変`
  * `List<Object> objList = new ArrayList<Long>();`では、`ArrayList<Long>`は`List<Object>`のサブタイプとして扱われない。
* `イレイジャで実装されている`
  * コンパイル時にのみ型制約を強制し、実行時に要素の型情報を破棄する。  

## 項目29 ジェネリック型を使う
* 以下のような状況ではジェネリックを利用する良い機会。
  * 利用者がメソッドからの戻り値をキャストする必要がある。
  * 利用者が実行時にキャストが失敗する可能性がある。

## 項目30 ジェネリックメソッドを使う
* 型パラメータの宣言はメソッド修飾子と返り値型の間で宣言する。
* rawタイプなメソッドの書き方は推奨されない。ジェネリクスを使ったメソッド定義が推奨される。
```java
public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> result = new HashSet<>(s2);
    result.addAll(s2);
    return result;
}
```
```java
public static Set union(Set s1, Set s2) {
    Set result = new HashSet(s1);
    result.addAll(s2);
    return result;
}
```

https://stackoverflow.com/questions/53337494/how-does-casting-this-object-to-a-generic-type-work

## 項目31 APIの柔軟性向上のために境界ワイルドカードを使う
### ユーザーから見た使いやすいAPIとは
StackというクラスがAPIとして公開され、それを利用する状況を考える。  
```java
Stack<Number> numberStack = new Stack<>();
Iterable<Integer> integers = ... ;

// IntegerはNumberのサブタイプなので、直感的にはこのように使えそうな気がしませんか？
numberStack.pushAll(integers);
```
利用者はAPIにオブジェクトを提供する場合、「より具体的な型」のオブジェクトを渡しても動くことを想定する。  
「より具体的」とはInteger型はStack型のサブクラスであるということ。  

別のケースとしては下記。  
```java
Stack<Number> numberStack = new Stack<>();
Collection<Object> objectsHolder = ... ;

// ObjectはNumberのスーパータイプなので、直感的にはこのように使えそうな気がしませんか？
numberStack.popAll(objectsHolder);
```
Number型はObject型のサブクラスなので上記のような渡し方を期待する。  
### APIに柔軟性を持たせる
#### ケース1
上記のような渡し方を実現するには、APIを次のように実装する。  
```java
public <E> void pushAll(Iterable<? extends E> src) {
    ...
}
```
利用者の「APIの引数としてオブジェクトを渡す場合、より具体的な型を渡しても動作する」という期待に答える作りにするためには、  
API側の型は「EのIterable」と考えるのではなく、「Eそのもの、またはEのサブタイプのIterable」と考える必要がある。  

パラメータがAPIにオブジェクトを提供する場合、そのパラメータはproducerであるという。
#### ケース2
```java
Stack<Number> numberStack = new Stack<>();
Collection<Object> objectsHolder = ... ;

// ObjectはNumberのスーパータイプなので、直感的にはこのように使えそうな気がしませんか？
numberStack.popAll(objectsHolder);
```
利用者は「APIからオブジェクトを受け取る側なら、より抽象的な型のオブジェクトとして受け取れるだろう」と考える。(ケース1の逆)  
API側の型は「EのCollection」ではなく、「Eそのもの、またはEのスーパータイプのCollection」とする。

パラメータがAPIからオブジエクトを受け取る場合、そのパラメータはconsumerであるという。
```java
// ポイントは、<? super E>　の部分です。ロジック部分は省略。
public <E> void popAll(Collection<? super E> dst) {
    ...
}
```
### APIをジェネリクスで使う時のポイント
#### 戻り値の型に境界ワイルドカードを使わない。


## 項目32 ジェネリクスと可変長引数を注意して組み合わせる
* 可変長パラメータがジェネリック型か、パラメータ化された型である場合、コンパイラは警告を出す。
* `ヒープ汚染`とはパラメータ化された型の変数が、その型ではないオブジェクトを参照しているとき発生する。
* `@SafeVarargs`アノテーションで警告を出さないようにできるが、型安全性を保証すること。


* Javaでは可変長パラメータを渡すと、その保持の為にジェネリック配列が生成される。
* 以下の条件を満たす場合、ジェネリック可変長引数メソッドは安全と言える。
  * 可変長パラメータ配列に何も保存していない。かつ、
  * 信頼できないコードに対してその配列(あるいは複製を)参照できるようにしていない。
* 上記条件を満たせば`@SafeVarargs`を付与して良いが。
  * オーバーライドできないメソッドに対して付与できる。
  * Java8ではstaticメソッド、finalのインスタンスメソットにのみ付与できる。
  * Java9ではprivateのインスタンスメソッドにも付与できる。
* `@SafeVarargs`以外の方法：可変長パラメータをリストで置き換える。
  *  

# インターフェースメモ
## Iterable
* `hasNext`
  * 次の要素の有無を判定。
* `next`
  * 次の要素を返却。


# 6章 enumとアノテーション
## 項目34 int定数の代わりにenumを使う
### int enumパターンを避ける
```java
public static final int APPLE_FUJI   = 0;
public static final int APPLE_PIPPIN = 1;
```
* int enumパターンは型安全性を提供しない。
* 変数名がAPPLE_で始まっているのは、名前空間を提供していないから。
* toStringなどでコンソール表示してもintの値が出力されるだけで、有用な結果を得られない。
* 定数をまとまりにして、イテレートしたりできない。
### enum型
上記のような問題点を避ける為にenum型が提供されている。  

```java
public enum Apple {FUJI, PIPPIN}
```
* enum型はシングルトンクラス。
* enum定数にデータを関連付ける為に、インスタンスフィールドを宣言して、データを受け取るコンストラクタを書いて、そのフィールドにデータを保存する。
* クラス内やパッケージ内からだけアクセスされるenumはprivateあるいはパッケージprivateとして宣言する。
* enumのフィールド内では定数だけでなく、メソッドも紐付けることができる。
* enumで宣言した型は、自動的にjava.lang.Enumを継承する。
  * Objectクラスのequals, hashCOdeが適切に実装されている。
  * Comparableを実装している。
  * Serializableを実装している。
```java
// 定義
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    
    private final double mass;
    private final double radious;
    private final double surfaceGravity;

    Planet(double mass, double radious) {
        this.mass = mass;
        this.radious = radious;
        this.surfaceGravity = G * mass / (radious * radious);
    }
}
```
### メソッドを紐付ける
```java
public enum Operation {
    PLUS {public double aplly(double x, double y) {return x + y;}}
    
    public abstract double apply(double x, double y);
}
```
* enum型で抽象applyメソc都度を宣言する。
* 定数固有クラス本体で、定数毎にその抽象メソッドを具象メソッドでオーバーライドする。
### 定数の名前を値に変換
* `valueOf(String)`
* `values`
### 戦略enumパターン
* enumに新たな要素を追加した時、switch文へ追加した要素の為の分岐を忘れたとすると、追加した要素に対して既存のメソッドが意図しない計算結果を出すかもしれない。
* enum定数を追加する毎に、switch文の処理に対応する処理(戦略)を追加することを強制するパターン。
* 下記例のように、要素の追加は同時にPayTypeの選択を含むので、上記のような懸念がない。
```java
enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    private enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };
        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
```


# 7章 ラムダとストリーム
## 項目42 無名クラスよりもラムダを選ぶ
### 関数型インターフェース
* 抽象メソッドが1つだけ定義されているインターフェースのこと。
* ただし、defaultやstaticメソッド、Objectクラスにあるpublicメソッドはカウントしない。

以下、関数型インターフェースの例.
```java
public interface GreetingInterface {
    public abstract String sayHello(String name);
}
```
インターフェースは普通ならimplementsして使用する。  
別な使い方として、ローカルクラスの省略記法で呼び出し側で実装しながらコールすることもできる。  
```java
public class Greeting {
    public static void main(String[] args) {
        String friendName = "John";
        GreetingInterface greet = new GreetingInterface() {
            @Override
            public String sayHello(String name) {
                return "Hello, " + name + "!";
            }
        };
        System.out.println(greet.sayHello(friendName)); // Hello, John!  
    }
}
```
この考え方をさらに推し進めて、関数型インターフェースの表記方法を使用することで、記述量を減らすことができる。  
関数型インターフェースの表記方法で呼び出すには、以下の条件を満たしている必要がある。
1. 抽象メソッドが1つだけ定義されているインターフェイスであること。ただしdefaultやstaticメソッド、Objectクラスにあるpublicメソッドはカウントしない。
2. 条件(1)を満たしている上で、`@FunctionalInterface`が付与されていること。(付与されていなくても条件(1)を満たしていればOK)

```java
public class Greeting {
    public static void main(String[] args) {
        String friendName = "John";
        GreetingInterface greet = name -> {
            return "Hello, " + name + "!";
        };
        System.out.println(greet.sayHello(friendName));  // Hello, John!
    }
}
``` 
* インターフェースの引数定義に引数の型は定義されているので、関数型インターフェースの表記では引数の型を記述する必要はない。
* ラムダ式も上記議論と同様で、ラムダ式も条件(1)の定義である。
  * 無名クラスをimplementsした呼び出し側のコード量が増えてしまう為、これらの記述量を減らす構文が導入された。
* 関数型インターフェースの定義にのらない型のインスタンスを作成する必要がある時だけ、関数オブジェクトとして無名クラスを使う。
* ラムダにおけるthisはエンクロージングインスタンスを、無名クラスにおけるthisは無名クラスのインスタンスを指す。

## 項目43 ラムダよりメソッド参照を選ぶ
* ラムダ式を使う場合、引数名を書く必要がある。引数名を明示的に記述した方がわかりやすい場合、ラムダ式を選ぶ。
* ラムダ式を使う場合、ロジックも呼び出し側で記述する。ロジックの記述があった方が読みやすい場合、ラムダ式を選ぶ。
* ラムダ式に書くロジックをメソッドに抽出し、そのメソッド参照を使うという選択肢もある。ドキュメントも書ける。
* 基本的にはラムダ式よりも、メソッド参照を使った方が簡潔な実装をできる。
### メソッド参照
|  メソッド参照の種類  |  例  | 同等のラムダ | 補足 |
| ---- | ---- | ---- | ---- |
|  static  |  Integer::parseInt  |  str -> Integer.parseInt(str) | static参照を使ってstrに処置を加える |
|  バウンド  |  Instant.now()::isAfter  | Instant then = Instant.now(); t -> then.isAfter(t) | |
| アンバウンド | String::toLowerCase | str -> str.LowerCase() | 引数の型から参照できるメソッドを実行する | |
| クラスコンストラクタ | TreeMap<K,V>::new | () -> new TreeMap<K,V> | |
| 配列コンストラクタ | int[]::new | len -> new int[len] | |

## 項目44 標準の関数型インターフェースを使う
* 基本メソッドをオーバーライドするテンプレートメソッドパターンは、関数オブジェクトを受け取るstaticファクトリかコンストラクタを提供する方法に変わっている。
* 推奨される？インターフェースの作り
  * 引数を関数オブジェクトで定義
    * 関数オブジェクトで定義することで、返却される値の型がわかる。
    * 引数の値を使ってどのような処理をするかは、APIの呼び出し側でラムダ式で定義する。
    * ここで引数に設定される関数オブジェエクトは標準で色々用意されているっぽい。

## 項目47 戻り値型としてStreamよりもCollectionを選ぶ
シーケンス系のオブジェクトを返却したい場合、Java8以前であればCollection, Set, List, Iterableを返却していたが、  
Java8以降では選択肢としてStreamが入ってくる。  

ストリームはIterableを拡張していないので、for-eachループを使ってループすることができない。  
これに対する対応策としては、Iterableへのキャストを行えば良い。
```java
for (String e : (Iterable<String>) stream::iterator) {
    System.out.println(e);
}
```
呼び出し側で上記のような処理を書くのは面倒なので、アダプターメソッドを介する形にすれば多少わかり易くなる。  
```java
public static <E> Iterable<E> iterableOf(Stream<E> stream) {
    return stream::iterator;
}

for (String e : iterableOf(stream2)) {
    System.out.println(e);
}
```
シーケンスを返却する公開APIを実装しているのであれば、ストリーム、for-eachのどちらにも対応できるようなコードを書くべき。  
CollectionインターフェースはIterableのサブタイプで、streamメソッドを持っているのでその両方に対応することができる。  

### Collectionを返すときの注意点
* コレクションとして返す為だけに大きなシーケンスをメモリに保存しない。
* 要素数がメモリに格納するのに十分に小さい場合、ArrayListなどのコレクションの標準的な実装で返せばOK。
* そうでない場合、メモリに収まる大きさの特別な実装が必要になる。
* 特に何らかの事情でCollectionや

## 項目48 ストリームを並列化するときは注意を払う



# 8章 メソッド
## 項目49 パラメータの正統性を検査する
* メソッドやコンストラクタが取る引数やパラメータは明確な制約があるのが普通で、そのような制約は明確に文章化されるべきである。
* そのような制約は処理の最初の方で検知されるべき。
  * エラーの検知は早い方がいい。
  * 誤ったパラメータで処理を進めることで、オブジェクトの状態を誤った状態にしたまま、処理を通してしまう可能性がある。
  * `エラーアトミック性`を破るという。
### public, protectedメソッドの検査
* `null検査`
  * `Objects.requireNoneNull`がnull検査に使える。
* リストと配列のインデックスを検査する用途に、ObjectsにcheckFromIndexSize, checkFromToIndex, checkIndexメソッドが追加されました。用途に合うなら便利。
### privateメソッドの検査
* `assert`
  * 条件が成り立つ時だけ`AssertionError`をスローする。

## 項目50 必要な場合、防御的にコピーする
* クラス内部に含まれるオブジェクトに対して、内部状態を変更するようなコードが簡単に書ける。
* コンストラクタへの変更可能なパラメータを防御的にコピーすることが重要。
  * クライアントから可変オブジェクトをパラメータとして受け取る場合、オブジェクトの内部フィールドにはそのコピーを保持するようにする。
* 可変な内部フィールドは防御的コピーを返却する。
### 防御的コピーをしない場合
* クライアントを信頼できる場合。
* コピーにコストがかかる場合。
* 不変式が崩されても、困るのは利用者だけである場合。

# Javaの型変換
## アップキャスト
* スーパークラス(親クラス)からサブクラス(子クラス)への変換。
* 子クラスは親クラスを継承しているので、親クラスの型としてインスタンスを代入することができる。

```java
Cat cat = new Cat();
Animal animal = cat;
```
## ダウンキャスト
* サブクラスからスーパークラスへの変換。
* 親クラスは子クラス特有のメソッドやフィールドを持っていないため、コンパイルエラーになる。
* ダウンキャストを行うときは、親クラスの実態(インスタンス)が子クラスから生成されていないとできない。

```java
Animal animal = new Cat();
Cat cat = animal;
```
## ジェネリクス型
* 型パラメータ部分にジェネリクスを使うと、コンパイル時に検査してエラーを出してくれるようになる。
* 型パラメータ部分はインスタンス生成時に決めることができる。

```java
public class Generic<T> {
    private T value;

    public void setValue(T val) {
        value = val;
    }

    public T getValue() {
        return value;
    }
}

Generic generic = new Generic<Integer>(); // インスタンス作成時に型を指定
```

## 非境界ワイルドカード型
* 要素の型が「何でも構わない」場合、非境界ワイルドカード型を使う。
* 非境界ワイルドカード型は型パラメータに`?`を指定する。
* 返り値に非境界ワイルドカード型が指定されている場合、返り値の型が事前にわからないため、受ける側はObject型で受ける事になる。

```java
Generic<?> generic = new Generic<Integer>();
generic.setValue(null);
Object value = generic.getValue();
```

## ジェネリクス型の継承関係
Cat, DogはAnimalの子クラスであるとする。  
List<Animals>の要素として、Cat, Dogを格納することができる。  

```java
List<Animal> animals = new ArrayList<Animal>();
animals.add(new Animal());
animals.add(new Cat());
animals.add(new Human());
```

`List<Animal>`と`List<Cat>`を考える。  
`List<Animal>`へ`List<Cat>`は代入できない。(コンパイルエラー)  
Javaではクラスに継承関係にあったとしても、別の型として扱われるから。  
これを`不変`という。  

`List<Animal>`へ`List<Cat>`は代入できることを`共変`という。  
`List<Cat>`へ`List<Animal>`を代入できることを`反変`という。  

## 共変性
ジェネリクスが共変性を持つと仮定して考える。  
`List<Cat>`が`List<Animal>`のサブタイプである場合、ジェネリクスは共変である。  

共変の定義より、以下のようなソースを書ける事になる。  
```java
List<Animal> animals = new ArrayList<Cat>();
```

`animals`より「要素を取り出す」ことを考える。  
`List<Animal>`より取得できる可能性のある型は`Animal`,`Cat`,`Dog`である。  
これらは`Animal`型へキャスト可能なので問題ない。  

`animals`へ「要素をいれる」ことを考える。  
ダウンキャストのルールより、親クラスへキャストする際、実態は`Animal`である必要がある。  
また、下記例だと`List<Animal>`の実態が`List<Cat>`の場合で、CatのリストにHumanが入る事になる。  
これは型安全を放棄している。  このようなソースを書いた時、コンパイル時エラーとしたい。
```java
List<Cat> cats = new ArrayList<Cat>();
cats.add(new Cat());
List<Animal> animals1 = cats;

List<Human> humans = new ArrayList<Human>();
humans.add(new Human());
List<Animal> animals2 = human;

Animal animal1 = animals1.get(0) // Catのインスタンスが取り出せる
Animal animal2 = animals2.get(0) // Humanのインスタンスが取り出せる
```

## 上限境界ワイルドカード型
* 要素の型に「共変性の継承関係による縛り」を加えて指定する場合、上限境界ワイルドカード型を使う。
* ジェネリクスに共変性を持たせるには`List<? extends Animal>`のように指定する。
  * 型パラメータは「Animalを親クラスに持つクラス」という意味。
* ジェネリクスに共変性を持たせるための仕組み。上限境界ワイルドカード型があれば、型安全性を保ったまま共変性を導入できる。
```java
List<? extends Animal> animals = new ArrayList<Animal>();
animals.add(new Animal()); // コンパイルエラー
animals.add(new Cat()); // コンパイルエラー
animals.add(new Human()); // コンパイルエラー
animals.add(null); // nullのみ代入可
```

## 反変性
ジェネリクスが反変性を持つと仮定する。  
反変性の定義より、以下のような操作ができる。  
```java
List<Cat> cats = new ArrayList<Animal>();
```

上記定義において、`List<Cat>`の実態は`List<Animal>`である。  
要素として、`Animal`, `Cat`を追加できる。  

一方、`List<Animal>`に追加できる要素は`Animal`,`Cat`,`Human`である。  
`List<Cat>`のサブクラスは`List<Animal>`(反変)なので、`List<Animal>`を`List<Cat>`へキャストできる。  
しかし`List<Animal>`は要素に`Human`型を持てるので、そのようなソースを書いた場合コンパイル時エラーとしたい。  

## 下限境界ワイルドカード型
* 要素の型に「反変性の継承関係による縛り」を加えて指定する場合、下限境界ワイルドカード型を使う。
* ジェネリクスに反変性を持たせるには`List<? super Animal>`のように指定する。
  * 型パラメータは「Animalをサブクラスに持つクラス」という意味。

# まとめ
### テクニック
* スコープやメモリリークに対するテクニック
  * 通常/static/非static/無名クラスの使い分け。
* 汎用性を上げるテクニック
  * ジェネリクス
### アンチパターン
* タグ付きクラス
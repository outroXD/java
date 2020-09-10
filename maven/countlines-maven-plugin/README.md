# countlines-maven-plugin
* 自作mavenプラグインを作成する。
* [参考](https://www.techscore.com/tech/Java/ApacheJakarta/Maven/8-2/)

# プロジェクトの作成

# 実装
## AbstractMojo
* この抽象クラスを実装・拡張して実装を進めていく。
* これが「プラグインそのもの」になる。

## 設定ファイル
* pom.xml内で指定して、@paramを振ったjavadocで識別して自動で渡される。
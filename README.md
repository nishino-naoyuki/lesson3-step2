# 【Level3-2】

## テーマ
既存プログラムを参考に、CRUD機能が作成できること
ページ遷移とバリデーションの仕組みが理解できること
templateへの記載ができるようになること

## 演習課題の準備（開発環境について）
* この演習では、Codespacesと呼ばれるサービスを使って開発を行います。
* ブラウザ上で動作する開発環境です、インストール不要で使う事ができます。
* レベル0で実施した[手順](/Codespacesの実行手順.md)を参照して、演習課題の準備をしましょう。

## 演習内容
Lesson(授業管理機能)を参考にArchievement(実績管理機能)の実績一覧画面を作成しましょう。

## 演習内容詳細
実績を保持する、ARCHIEVEMENTテーブルの内容を表示する、以下のような画面を作成しましょう。
![image](https://user-images.githubusercontent.com/32722128/190317690-969ed674-5dbb-4fb5-8ed1-127cfaef92bb.png)
以下の順序で実装を行ってください。

1. データベース情報を保持する、Entityクラスである`Archievement`クラスを作成してください。
2. DAOクラスである、`ArchievementDao`クラスを作成してください。
3. サービスとして、`ArchievementService`クラスを作成してください。
4. ビューのテンプレートファイルとして`~\resources\templates`配下に新たに、`archievement`ディレクトリを作成し、`index.html`ファイルを作成してください。
**なお、今回はテンプレートファイルを用意しておりますので、そちらを使ってください。**
5. コントローラーとして、`ArchievementController`クラスを作成してください。

それぞれに対応する、授業管理機能(Lesson)のファイルを参考に作成してください。

|Archievement|Lesson|
|---|---|
|ArchievementController|LessonController|gg
|ArchievementService|LessonService|
|Archievement|Lesson|
|ArchievementDao|LessonDao|
|archievement/index.html|lesson/index.html|

## ファイルの新規作成方法
1. ファイルを新規作成したい、ディレクトリの上で右クリック、`新しいファイル`を押します。  
![image](https://user-images.githubusercontent.com/32722128/190564647-9add538c-e246-4465-872f-81bb79945de7.png)

1. ファイル名を拡張子を含めて入力し、Enterキーを押します。
ファイル名とクラス名は同じにしておきましょう。  
![image](https://user-images.githubusercontent.com/32722128/190565372-daf35ef0-6698-407d-9337-71fbed4a7543.png)

## 1.Entityクラスの作成
まずはEntityクラスを作成しましょう、`Archievement.java`ファイルを作成してください。<br>
Entityクラスは1つのオブジェクトがデータベーステーブルの一行に対応するように作成します。<br>
今回作成するテーブルには、3つの列が存在します。<br>
それぞれの列に対応する、メンバ変数を作成しましょう。<br>
なおデータベースのデータ型と、JAVAの変数のデータ型は以下の対応表に沿って作成してください。<br>
|データベース|JAVA|
|---|---|
|VARCHAR|String|
|int|int|
|boolean|boolean|

メンバ変数名と、データベースのカラム名は今回は同じにしてください。<br>
Constructor(コンストラクター)と、Getter/Setter(ゲッター/セッター)を作成します。<br>
[参考：constructorについて](https://wa3.i-3-i.info/word13646.html)
[参考：Getterについて](https://wa3.i-3-i.info/word15856.html)
[参考：Setterについて](https://wa3.i-3-i.info/word15855.html)

Getter/Setter(ゲッター/セッター)の作成
1. 右クリックし、ソースアクションを選択してください。  

![image](https://user-images.githubusercontent.com/32722128/190547470-ac70fea0-a562-497d-97bf-bac8552fb610.png)

1. `Generate Getters and Setters...`を選択してください。  

![image](https://user-images.githubusercontent.com/32722128/190554561-2323c8d5-017a-4717-bbf1-59ad7297776f.png)

1. 全てにチェックを入れてOKを押してください。  
![image](https://user-images.githubusercontent.com/32722128/190555126-7889f554-ada3-4b0f-8357-8d4c19185b32.png)

1. Getter/Setter(ゲッター/セッター)が生成された事を確認してください。  
![image](https://user-images.githubusercontent.com/32722128/190563098-12b3c049-7fb6-44fd-8c64-b4d8a6905b31.png)

Constructor(コンストラクター)の作成

1. 再度、右クリックし、ソースアクションを選択してください。

1. `Generate Constructors`を選択してください。  
![image](https://user-images.githubusercontent.com/32722128/190562258-e52e2a62-89e5-48f4-bade-e9595e451ecb.png)

1. constructorの引数にする変数を指定してください。
引数0のconstructorと全てのメンバ変数が引数となるconstructorを作成して下さい。  
![image](https://user-images.githubusercontent.com/32722128/190562636-e6a0fa9f-571c-4a6a-8dd7-f62ed3ddbaaa.png)

1. constructorが作成された事を確認して下さい。  
![image](https://user-images.githubusercontent.com/32722128/190563198-9ff4a7c2-3015-4bb4-80b6-c757f7747206.png)

## 2.DAOクラスの作成

## 2-1.インターフェイスを作成(DAOクラス)
まずは、インターフェイスを作成しましょう。
`ArchievementDao.java`ファイルを作成してください。
今回は一覧画面の表示だけですので、テーブル上の全てのレコードを取得する`selectAll`メソッドを定義してください。
以下の構文で定義してください、戻り値のデータ型は`Archievement`クラスオブジェクトのリストとし、引数はなしとしてください。
```
戻り値のデータ型 メソッド名(引数1, 引数2, ....)
```  
![image](https://user-images.githubusercontent.com/32722128/190572803-88bf3d6d-a5c1-4772-8e43-d5568abf0152.png)  
この状態では、得体のしれないクラスが戻り値として指定されている状態ですので、クイックフィックス機能を使って、クラスをインポートして下さい。  

1. `クイックフィックス`をクリックしてください。  
![image](https://user-images.githubusercontent.com/32722128/190573996-ed66f67e-aae4-4d5f-a01b-3737287cede7.png)  

1. `import 'List' (java.util)`をクリックしてください。  
 ![image](https://user-images.githubusercontent.com/32722128/190574259-b272ec10-a379-43a6-8f8f-75e3405b46b4.png)  

同じように、`Archievement`クラスについてもimportを行って下さい。  
今回は以下の2つがimportされていればOKです。  
```
import java.util.List;
import com.classroom.assignment.entity.Archievement;
```
よくある間違えとして、異なるパッケージの同名のクラスをimportすることがよくあります。  
自分の目的にあったクラスがimportされている事を確認しましょう。

## 2-2.実装クラスの作成(DAOクラス)
`ArchievementDaoImpl.java`ファイルを作成してください。

1. まずはクラス名と実装を行うインタフェースを定義します。
実装クラスの名前は、`インタフェース名＋Impl`とする事が多いのでそのようにします。
```
public class ArchievementDaoImpl implements ArchievementDao { }
```
SQLを実行するために、Springで用意されている、`JdbcTemplate`クラスを使用します。<br>
このクラスを使うためには、通常、都度newを行ってクラスをインスタンスする必要があります。<br>
```
JdbcTemplate jdbcTemplate = new JdbcTemplate();
```
Springの機能であるDI(Dependency Injection=依存性注入)という仕組みと使う事で、Springが自動でインスタンスを生成して、変数に格納する事が出来ます。<br>
この機能を使うためにはconstructorに`@Autowired`というアノテーションを付与し以下のように記述します。<br>
```
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ArchievementDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
```

この際、`JdbcTemplate`クラスのimportが必要となります。
```
import org.springframework.jdbc.core.JdbcTemplate;
```

2. `selectAll`メソッドを実装して下さい。
変数`sql`に、`ARCHIEVEMENT`テーブルから全ての列(id, name, memo)を取得するSELECT文を設定して下さい。  <br>
`jdbcTemplate.queryForList(sql);`でSQLを実行し結果を取得しています。<br>
取得した、結果を拡張for文を利用して`List<Archievement>`型の変数に格納し戻り値としてください。<br>
※`LessonDaoImpl`で行っている、「曜日番号 → 曜日名 変換」の処理は必要ありません。

## 3.サービスクラスの作成

## 3-1.インターフェイスを作成(サービスクラス)
`ArchievementService.java`ファイルを作成してください。<br>
先ほどのDAOクラスと同じように、テーブル上の全てのレコードを取得する`selectAll`メソッドを定義してください。<br>
戻り値のデータ型は`Archievement`クラスオブジェクトのリストとし、引数はなしとしてください。<br>

## 3-2.実装クラスの作成(サービスクラス)
`ArchievementServiceImpl.java`ファイルを作成してください。  <br>
DIを使って、`ArchievementDao`クラスを注入してください。  
```
  private final ArchievementDao dao;

  @Autowired
  public ArchievementServiceImpl(ArchievementDao dao) {
    this.dao = dao;
  }
```
先ほど実装した、`ArchievementDao`クラスの`selectAll`メソッドを呼び出し、`List<Archievement>`型の変数を取得し、取得した変数を返却してください。

## 4.ビューのテンプレートファイルの作成
なお、今回はテンプレートファイルを用意しておりますので、そちらを使ってください。<br>
`~\resources\templates\archievement`配下に、`index.html`ファイルが存在する事を確認してください。

## 5. コントローラーの作成
`ArchievementController.java`ファイルを作成してください。<br>
DIを使って、`ArchievementService`クラスを注入してください。  
```
  private final ArchievementService archievementService;

  @Autowired
  public ArchievementController(ArchievementService archievementService) {
    this.archievementService = archievementService;
  }
```

パス`/archievement`にGETリクエストがあった場合にリクエストを処理される`index`メソッドを作成してください。<br>
`ArchievementService`クラスの`selectAll`メソッドを使用して、実績一覧を取得し、`model`オブジェクトの`archievementList`属性に値を設定し、
戻り値に先ほど存在を確認した、ビューのテンプレートファイル、`archievement/index`を設定してください。

## 課題の提出
* 課題の提出は[課題提出の操作](/課題の提出手順.md)のコミット・プッシュ・プルリクエストを実施しましょう。


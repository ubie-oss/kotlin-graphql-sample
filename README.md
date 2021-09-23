# kotlin-graphql-sample

![](https://github.com/ubie-inc/kotlin-graphql-sample/actions/workflows/build.yml/badge.svg)

これはUbieが開発しているKotlin+SpringBoot+GraphQLのサンプル実装です。

## DB

![E-R図](https://raw.githubusercontent.com/wiki/ubie-inc/kotlin-graphql-sample/images/er.png)

## 環境構築

### Docker

`docker-compose`を利用して`Docker`を立ち上げています。それぞれインストールして下さい。 https://docs.docker.com/compose/install/

### Editor

どのようなEditorを使っても構いませんが、Ubieでは主にIntellij Ultimateを利用しています。

## 起動方法

以下のコマンドを実行します。

```
./docker-compose up
```

起動した状態で http://localhost:8090/graphiql にアクセスすると、GraphiQLにアクセス出来ます。

## localでSpring Boot Appを起動する場合

`docker-compose-middleware.yml`でデータベースを起動して、IntelliJ上でKotlinGraphQLSampleApplicationを実行してください。

```
docker-compose -f docker-compose-middleware.yml up
```

## テスト

### テストの実行

```
docker exec -it sample-app ./gradlew test
```

上記コマンドにより、テストが実行され、レポートが`build/reports/tests/test/index.html`として出力されます。

### コードカバレッジの測定

```
docker exec -it sample-app ./gradlew jacocoTestReport
```

テストを実行した後に上記コマンドにより、コードカバレッジの測定が実行され、レポートが`build/reports/jacoco/test/html/index.html`として出力されます。

### 静的解析ツールの実行

```
./gradlew ktlintCheck
```

上記コマンドにより、Kotlinコードのスタイルチェック等の静的解析が実行されます。
レポートが`build/reports/ktlint`に、`ktlint-main.txt`と`ktlint-test.txt`というファイルで出力されます。

また、コード整形を下記のコマンドで実行できます。

```
./gradlew ktlintFormat
```

### コーディングスタイル

https://github.com/ubie-inc/kotlin-coding-style

## Contribution

このプロジェクトはUbieの環境と同期させるため、Ubieの環境と大きく離れてしまう修正は取り込む事が出来ません。

しかし、パッケージ変更を含まない修正であればどんどん取り込みますので、Pull Requestお待ちしております。

もし、どうすればいいかわからないという場合は、一旦issueを挙げてもらえると良いです。日本語か英語どちらでも構いません。

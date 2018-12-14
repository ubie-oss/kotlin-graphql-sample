# kotlin-graphql-sample

[![CircleCI](https://circleci.com/gh/ubie-inc/kotlin-graphql-sample.svg?style=svg)](https://circleci.com/gh/ubie-inc/kotlin-graphql-sample)

これはUbieが開発しているKotlin+SpringBoot+GraphQLのサンプル実装です。

## 環境構築

### Docker

`docker-compose`を利用して`Docker`を立ち上げています。それぞれインストールして下さい。 https://docs.docker.com/compose/install/

### Editor

どのようなEditorを使っても構いませんが、Ubieでは主にIntellij Ultimateを利用しています。

## 起動方法

以下のコマンドを実行します。

```
docker-compose up
```

起動した状態で http://localhost:8090/graphiql にアクセスすると、GraphiQLにアクセス出来ます。

## テスト

### テストの実行

```
docker exec -it -app ./gradlew test
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


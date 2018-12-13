# kotlin-graphql-sample

これはUbieが開発しているKotlin+SpringBoot+GraphQLのサンプル実装です。

## 開発中のアプリケーション起動

```
docker-compose up
```

起動した状態で http://localhost:9099/graphiql にアクセスすると、GraphiQLにアクセス出来ます。

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

### コーディングスタイル

https://github.com/ubie-inc/kotlin-coding-style


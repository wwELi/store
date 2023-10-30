## 学习JAVA 代码练习

#### flyway 使用

- 安装flyway
> brew install flyway

- build.gradle 增加 plugin (目前使用8.0.0 其他版本会报错找不到数据库) 和flyway配置
> id 'org.flywaydb.flyway' version '8.0.0'
> flyway {
>    url = 'jdbc:mysql://localhost:3306/mall'
>    user = 'ww'
>    password = 'root'
> }

- 在 src/main/resources/db/migration 下增加sql

- 执行命令
> ./gradlew flywayMigrate
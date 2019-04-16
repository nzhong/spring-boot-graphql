# SPRINGBOOT + GRAPHQL QUICKSTART

This repo contains several simple sub-folders, <b>s1</b>, <b>s2</b>, ...
Each one is built on top of the previous one, and add just a little bit of code:

-   <b>s1</b>: minimal spring-boot application
-   <b>s2</b>: minimal spring-boot + graphql
-   <b>s3</b>: s2 + MySQL integration

# s1

The is just the absolute minimal spring-boot application, on port 8080. One java file, <i>Application.java</i>

```
> mvn clean package
> java -jar target/spring-boot-graphql-1.0-SNAPSHOT.jar
```

then load in your browser, http://127.0.0.1:8080
you should see the 'Whitelabel Error Page', which means it's working

# s2

On top of s1, we added three dependencies to pom.xml: 'graphql-spring-boot-starter', 'graphiql-spring-boot-starter', and 'graphql-java-tools'.

At a bare minimal, we also added these 3 source files:

-   src/main/resources/graphql/root.graphqls
-   model/Person.java
-   Query.java

```
> mvn clean package
> java -jar target/spring-boot-graphql-1.0-SNAPSHOT.jar
```

then load in your browser, http://127.0.0.1:8080/graphiql
you should see a nice graphQL UI, you could put in the following (on the left side panel):

```
{
  persons {
    id
    firstName
    lastName
  }
}
```

and press the [PLAY] icon/button. You should see some results!

Alternatively, you could also try the following curl command:

```
curl -H "Content-Type: application/json" -X POST -d '{
"query": "{ persons { id firstName lastName } }"
}' http://127.0.0.1:8080/graphql
```

and you should see the same result.

# s3

To run s3, you will need an instance of running MySQL. On a Mac, the easiest way (if you have docker), is something like this:

```
$ docker run --name test \
  -e MYSQL_ROOT_PASSWORD=changeit \
  -p 3306:3306 \
  -v /Users/ningzhong/dev/docker/test:/var/lib/mysql \
  -d mysql:5.7

$ docker exec -it test /bin/bash

root@ea18dedc09f0:/# mysql -u root -p
Enter password: (changeit)

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> create database test;
Query OK, 1 row affected (0.01 sec)

mysql> use test;
Database changed

mysql> CREATE TABLE `person` (
  `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name`     varchar(64) NOT NULL DEFAULT '',
  `last_name`      varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='person';

mysql> INSERT INTO `person`(`first_name`,`last_name`)  VALUES ('Henry','Tudor');
mysql> INSERT INTO `person`(`first_name`,`last_name`)  VALUES ('Arthur','Tudor');
```

What's important, is that we have a MySQL instance running

-   on port 3306
-   username/password: root/changeit
-   database/schema name within MySQL: test
-   a TABLE `person` is created with three columns: `id`, `first_name`, and `last_name`
-   and two rows of seed data inserted.

With the above database setup, we can now proceed with the java side:

src/main/resources/application.properties

```
mysql.url = jdbc:mysql://127.0.0.1:3306/test?useSSL=false&characterEncoding=UTF-8
mysql.username = root
mysql.password = changeit
```

Query.java

```
    @Autowired
    PersonRepository personRepo;

    public Iterable<Person> persons() {
        return personRepo.findAll();
    }
```

and dataProvider/model, dataProvider/repo, dataProvider/DataProviderMySQL.java

As usual,

```
> mvn clean package
> java -jar target/spring-boot-graphql-1.0-SNAPSHOT.jar
```

Now if we repeat the testings in s2, we should see the two rows of seed data from MySQL.

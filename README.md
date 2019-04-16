# SPRINGBOOT + GRAPHQL QUICKSTART

This repo contains several simple sub-folders, <b>s1</b>, <b>s2</b>, ...
Each one is built on top of the previous one, and add just a little bit of code:

-   <b>s1</b>: minimal spring-boot application
-   <b>s2</b>: minimal spring-boot + graphql

# s1

The is just the absolute minimal spring-boot application, on port 8080. One java file, <i>Application.java</i>

```
> mvn clean package
> java -jar target/spring-boot-graphql-1.0-SNAPSHOT.jar
```

then load in your browser, http://127.0.0.1:8080
you should see the 'Whitelabel Error Page', which means it's working

# s2

On top of s11, we added three dependencies to pom.xml: 'graphql-spring-boot-starter', 'graphiql-spring-boot-starter', and 'graphql-java-tools'.

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

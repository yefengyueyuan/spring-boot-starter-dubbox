spring-boot-starter-dubbox
===================================


Spring Boot with dubbo support. Dubbo is an RPC framework.

Support jdk version 1.6 or 1.6+

(please import googlestyle-java.xml if you want to modify the code)

### How to publish dubbo

* add Dependencies:

```xml
    <dependency>
        <groupId>com.euond</groupId>
        <artifactId>spring-boot-starter-dubbox</artifactId>
        <version>3.0.1-SNAPSHOT</version>
    </dependency>
```
* add dubbo configuration in application.properties, demo:

```properties
server:
  port: 7001
spring:
  http:
    encoding:
      charset: UTF-8
      enabled: true
  dubbo:
    appname: spring-boot-starter-dubbo-test
    protocol: dubbo
    registry: zookeeper://120.0.0.1:2181
    port: 20801
    version: 1.0.0
    dubbox-rest:
      server: tomcat
      port: 8889
```

* then add `@EnableDubboConfiguration` on Spring Boot Application, indicates that dubbo is enabled.(web or non-web application can use dubbo provider)

```java
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderLauncher {
  //...
}
```

* code your dubbo service, add `@Service`(import com.alibaba.dubbo.config.annotation.Service) on your service class, and interfaceClass is the interface which will be published.

```java
@Service(interfaceClass = IHelloService.class)
public class HelloServiceImpl implements IHelloService {
  //...
}

@Service(interfaceClass = AnotherUserRestService.class,protocol="rest")
@Component
public class AnotherUserRestServiceImpl implements AnotherUserRestService {

	@Override
	public String getString(Long id) {
		// TODO Auto-generated method stub
		return "Holle,Word";
	}

	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "Holle,Word";
	}

}
```

* start Spring Boot.


### How to consume Dubbo

* add Dependencies:

```xml
    <dependency>
        <groupId>com.euond</groupId>
        <artifactId>spring-boot-starter-dubbox</artifactId>
        <version>3.0.1-SNAPSHOT</version>
    </dependency>
```

* add dubbo configuration in application.properties, demo:

```properties
server:
  port: 7001
spring:
  http:
    encoding:
      charset: UTF-8
      enabled: true
  dubbo:
    appname: spring-boot-starter-dubbo-test
    protocol: dubbo
    registry: zookeeper://120.0.0.1:2181
    port: 20801
    version: 1.0.0
    dubbox-rest:
      server: tomcat
      port: 8889
      
```

* then add `@EnableDubboConfiguration` on Spring Boot Application

```java
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerLauncher {
  //...
}
```

* injection interface by the `@DubboConsumer` annotation.

```java
@Component
public class HelloConsumer {
  @DubboConsumer
  private IHelloService iHelloService;

}
```

### Reference


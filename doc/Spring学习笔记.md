# Spring 学习笔记

## Module 介绍

Spring-Transaction-Annotaion：以注解方式配置的声明式事务

Spring-Transaction-XML：以XML方式配置的声明式事务

## Spring 事务控制

### 事务控制分类

* 编程式事务（略）

* 声明式事务
  * 以XML方式配置的声明式事务
  * 以注解方式配置的声明式事务

### 以XML方式配置的声明式事务

pom.xml需要引入：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

Springboot 引入 事务控制配置文件（applicationContext-db.xml）

ApplicationContextConfig.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 8:01
 */
@SpringBootApplication
@MapperScan(basePackages = "top.simba1949.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
```

applicationContext.xml 和 applicationContext-db.xml融合到一个spring容器中

applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="applicationContext-db.xml"></import>
</beans>
```

applicationContext-db.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:property-placeholder location="jdbc.properties"/>
    
    <aop:config>
        <aop:pointcut id="aopPoincut" expression="execution(* top.simba1949.service.impl.*.*(..))"></aop:pointcut>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="aopPoincut"></aop:advisor>
    </aop:config>
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <!--tx:method表示哪些方法需要开启事务，propagation表示必须要求，
                isolation表示事物隔离级别,rollback-for表示发生异常回滚
            -->
            <tx:method name="add*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="save*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="insert*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="update*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="modify*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="delete*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>

            <tx:method name="query*" read-only="true"></tx:method>
            <tx:method name="select*" read-only="true"></tx:method>
            <tx:method name="find*" read-only="true"></tx:method>
        </tx:attributes>
    </tx:advice>
    <!--事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>

    <!--mybatis的基本配置-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--数据源配置-->
        <property name="dataSource" ref="dataSource"></property>
        <!--告诉spring，mybatis配置文件位置-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <!--告诉spring，mybatisMpapper配置文件位置-->
        <property name="mapperLocations">
            <array>
                <value>classpath*:top/simba1949/mapper/*Mapper.xml</value>
            </array>
        </property>
        <!--给包取别名-->
        <property name="typeAliasesPackage" value="top.simba1949.common"></property>
    </bean>
    <!--mapper扫描配置-->
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定dao接口的路径-->
        <property name="basePackage" value="top.simba1949.mapper"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>
</beans>
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

</configuration>
```

jdbc.properties

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
jdbc.username=root
jdbc.password=19491001
```

### 以注解方式配置的声明式事务

application.properteis

```properties
server.port=8083

#mysql设置
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=19491001

#表示打印出sql语句
logging.level.com.shyroke.mapper=debug

#mybatis配置
mybatis.mapper-locations=classpath*:top/simba1949/mapper/*Mapper.xml
mybatis.type-aliases-package=top.simba1949.common
```

Application.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 8:01
 * @MapperScan(basePackages = "top.simba1949.mapper")扫描mapper包
 */
@SpringBootApplication
@MapperScan(basePackages = "top.simba1949.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
```

CountryServiceImpl.java

 @Transactional(rollbackFor = Exception.class)即可开启注解

```java
package top.simba1949.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.simba1949.common.CountryCommon;
import top.simba1949.mapper.CountryMapper;
import top.simba1949.service.CountryService;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/24 23:22
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(CountryCommon countryCommon) {
        int i = countryMapper.insert(countryCommon);
        return i;
    }
}
```

###  @Transactional 注解详解

```java
@Transactional(
    propagation = Propagation.REQUIRED,
    isolation = Isolation.DEFAULT,
    timeout = -1,
    readOnly = false,
    rollbackFor = Exception.class,
    noRollbackFor = Exception.class
)
```

|                             属性                             | 含义                                                         | 默认值                                                       |
| :----------------------------------------------------------: | :----------------------------------------------------------- | ------------------------------------------------------------ |
|                propagation,定义事务的生命周期                | REQUIRED:方法A调用式没有事务新建一个事务，当方法A调用另一个方法B时，方法B将使用相同的事务；如果方法B发生异常需要回滚的时候，整个事务数据回滚 | REQUIRED                                                     |
|                                                              | REQUIRED_NEW：方法A和方法B，在方法调用的时候无论是否有事务都开启一个新事务；这样如果方法B有异常不会导致方法A的数据回滚 |                                                              |
|                                                              | NESTED：和REQUIRED_NEW类似，但是支持JDBC，不支持JPA和Hibernate |                                                              |
|                                                              | NOT_SUPPORTED：强制方法不在事务中执行，若有事务，在方法调用结束阶段事务将被挂起 |                                                              |
|                                                              | NEVER：强制方法不在事务中执行，若有事务则抛出异常            |                                                              |
|                                                              | MANDATORY：强制方法在事务中执行，若无事务则抛出异常          |                                                              |
| isolation：（隔离）决定了事务的完整性，处理在多事务对相同数据的处理机制 | READ_UNCOMMITTED：对于在A事务里修改了一条记录但是没有提交事务，在B事务可以读取到修改后的记录。可导致脏读，可不重复读以及幻读 | DEFAULT（使用当前数据库默认的级别，oracle、sql server默认为READ_COMMITTED，mysql默认REPEATABLE_READ） |
|                                                              | READ_COMMITTED：只有当事务A里修改了一条记录且提交事务之后，B事务才可以读取到提交后的记录；阻止脏读，但是可导致不可重复读和幻读 |                                                              |
|                                                              | REPEATABLE_READ：不仅能实现READ_COMMITTED的功能，而且还能阻止当A事务读取了一条记录，B事务将不允许修改这条记录；阻止了脏读，不可重复读，但是可导致幻读 |                                                              |
|                                                              | SERIALIZABLE：此级别下事务是顺序执行的，可以避免上述级别的缺陷，但是开销比较大 |                                                              |
|                           timeout                            | timeout事务过期时间，默认为当前数据库的事务过期时间          |                                                              |
|                           readonly                           | 指定当前事务是否是只读事务                                   | false                                                        |
|                         rollbackfor                          | 指定哪个或者哪些异常可以引起事务回滚                         | Throwable的子类                                              |
|                        noRollbackfor                         | 指定哪个或者哪些异常不可以引起事务回滚                       | Throwable的子类                                              |


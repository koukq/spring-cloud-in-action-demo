# spring-cloud-in-action-demo
Spring cloud demo.

## 工程目录
├─common：共用基础包<br/>
│    ├─common-jpa-base：JPA基础包<br/>
│    ├─common-spring：Spring相关基础包<br/>
│    └─common-util:工具包<br/>
├─eureka-server:注册中心<br/>
├─user-service：用户服务<br/>
│   ├─user-service-api：用户服务API包，供调用者集成使用<br/>
│   └─user-service-provider：用户服务提供者<br/>
└─hr-system：hr系统<br/>

## demo运行

1. 先导入根目录下的data.sql，然后修改user-service-provider下的application.yml中的spring.datasource.username和spring.datasource.password属性;
2. 运行eureka-server下的com.kou.eureka.EurekaApplication;
3. 启动user-service-provider下的com.kou.user.service.UserServiceProviderApplication;
4. 启动hr-system下的com.kou.hr.system.HrSystemApplication;
5. 访问http://127.0.0.1:8890/swagger-ui.html，进行在线接口文档访问;

## 调用顺序
 hr-system -> user-service-api -> user-service-provider
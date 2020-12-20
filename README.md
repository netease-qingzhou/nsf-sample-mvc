当不加Agent代理时, 需要手动创建 RestTemplate
```java
RestTemplate template = new RestTemplate();
```

当加了Agent代理时
```java
-javaagent:[agent_path]/springboot-agent.jar=nsf-stock-mvc
-Dnsf.grpc.timeout=100000
-Dnsf.dns.timeout=50000
-Dnsf.log.level=debug
```
可以被Agent代理增强注入
```java
@Autowired
RestTemplate template;
```

nsf.xml文件放在 agent jar包同级目录 [agent_path] 下.

```yaml
nsf:
  type: http
  boot: com.netease.mvc.NsfSampleMvcConfigApplication
  #  基本信息
  application:
    name: nsf-sample-mvc
    version: 0.0.1
    desc: this is service description
    zone: regionF
    projectCode: project1
    envCode: prod
    projectEnv: prod

  # agent配置
  server:
    enable: true # 是否启用NSF Server控制中心, 默认关闭
    skey: 123
    address: grpc://nsf-server.qa-yl.service.163.org:8980

  #  注册中心
  registry:
    enable: true # 是否启用eureka注册发现服务, 默认关闭
    address: http://nsf-registry.qa-yl.service.163.org/eureka/

  # 方法配置
  manager:
    patterns:
      - className: com.netease.mvc.controller.HyMvcServiceImpl

  # 应用监控
  metrics:
    enable: true # 是否启用hystrix的metrics应用监控

  # 服务鉴权配置
  authority:
    devMode: true
    #是否开启外部访问免鉴权
    enable: false
    #认证中心地址
    server: http://platform-service-auth.qa-yl.service.163.org
    #访问重试次数(仅403状态会重试，默认为 3 )
    retry: 3
    accessKey: 0f40b0a9a9a746ceaed6a75c0e98602a
    secretKey: 3a29f24088c44d308f22cbdfb81e514b
```

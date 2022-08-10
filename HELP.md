# Getting Started
### 本地组件访问地址
* [sentinel-dashboard](http://localhost:8080/)
* [Nacos](http://localhost:8848/nacos/)
* [JFrog](http://localhost:8082/)
* [rocketmq-console](http://localhost:15673/)
* [rabbitmq-console](http://localhost:15672/)
* [swagger-ui](http://localhost:8077/swagger/index.html)
- rocketmq的端口是9876 且rocketmq对java_home有强制性要求
- redis的端口是6379
- 后续新增组件可通过lsof -i:端口号 查看端口占用情况
- 由于本地安装的是JDK18 版本太高 所以启动控制台的命令为：java --add-opens java.base/java.lang=ALL-UNNAMED -jar xxx.jar
- rocketmq控制台在JDK18的环境下起不来，因为java 8及以前的版本是默认包含jaxb-api包的，但是升级后的版本就需要手动来导入这个包了

### 分布式事务
- 同步调用的情况下，使用seata的全局事务处理
- 使用消息队列异步调用的情况下，存在两种情况 \
1、消费者消费消息失败，这种情况下一般消息会进入死信队列，待消费者修复完成，再把死信队列的消息消费掉，这里一般都需要人工介入 \
2、生产者本地事务失败需回滚，使用rocketmq的半消息解决

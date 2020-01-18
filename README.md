# ahza_health_mixfront
A Java based health care system

## 项目描述
+ 采用前后端不分离设计
+ 技术栈：Spring Boot + MySQL, Spring Data JPA, Maven / Thymeleaf + Bootstrap

## 目录结构
```
./  
├── src/   
|   ├── main/  
|   |   ├── java/com/zweirm/ahza_health_mixfront/  
|   |   |   ├── aspect/  
|   |   |   ├── controller/  
|   |   |   ├── domain/  
|   |   |   ├── repository/  
|   |   |   ├── service/  
|   |   |   ├── utils/
|   |   |   ├── AhzaHealthMixfrontApplication.java  
|   |   |   └── ServletInitiializer.java  
|   |   └── Resources/  
|   |       ├── static/  
|   |       |   ├── css/  
|   |       |   ├── fonts/  
|   |       |   ├── img/  
|   |       |   └── js/  
|   |       ├── templates/  
|   |       └── application.yml  
|   └── test/  
└── pom.xml
```

## 主要功能
+ 登录注册  
+ 仪表盘  
  按用户在“健康数据”模块中输入的当日健康相关数值生成仪表盘，帮助用户了解自身数据与推荐数据直接的差别  
+ 健康数据  
  通过连续表单来录入当日健康相关数据  
+ 基因数据  
  连接第三方（微基因）API，获取特点基因位点信息，进行提示与推荐  

## 搭建须知
导入目录后，手动创建名为`ahza_health`的数据库，修改`application.yml`中相关配置后再启动项目

## 在线演示URL
https://health.ahza.xin/  
**注意：注册测试账户时请不要使用自己的常用密码，以免发生意外。**

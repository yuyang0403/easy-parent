# parent 项目介绍

## 版本管理

父级目录parent用于所有依赖的版本号需要在这里进行管理

## 项目结构

easy-parent

--easy-applications:所有业务服务

----easy-customer-service:具体的业务服务，例如客户服务,处理具体业务

----easy-adapter-server:第三方适配服务，用于接收第三方请求，不同第三方的不同请求规则写在这里，具体业务不处理

----easy-interface-server：所有需要调用的第三方接口在这里

----easy-task-server：定时服务，不处理具体业务，
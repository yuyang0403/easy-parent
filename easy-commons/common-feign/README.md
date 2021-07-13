# Feign使用规范
## 1.Feign如何定义？
1.创建在对应服务包名下，例如客户服务：
    com.yuyang.easy.feign.customer
        Customer***Feign
2.注解使用：
    @FeignClient(value="${server.name.customer}",path = "${server.context-path.customer}",fallback = CustomerBusinessFeignFallBack.class)
    value:配置在common的配置文件中，这个名称不要重复
    path:取这个服务的Context-path
    fallback:feign的FallBack,在当前feign中创建内部类即可
    

# spring 注解
    
    BeanPostProcessor , 在spring 给接口去添加实现
    
    ApplicationContextAware , 属性注入
    
    
    EnableConfigurationProperties
    ConfigurationProperties
    
    
    AutoConfigureAfter , 在 value 类初始化之后 在初始化当前类

    ConditionalOnWebApplication 

    ConditionalOnMissingBean 如果没有这个Bean 在注入
        Conditional 参数 OnBeanCondition


    ConditionalOnExpression  spring EL表达式的值 true | false



# spring  ${} 使用

    ${} 可以取 多个配置里面只 ， jdbc.properties 或者多配置文件
    可以给定默认值 ${user.name:root}
    
    不仅可以从配置读， 还可以读 System.setProperties 和环境变量;


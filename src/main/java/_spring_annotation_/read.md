
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


    Configuration(proxyBeanMethods = false)  Full 模式 Lite 模式
        lite模式下，直接返回新实例对象。
        该模式下，配置类会被CGLIB增强(生成代理对象)，放进IoC容器内的是代理
        该模式下，对于内部类是没有限制的：可以是Full模式或者Lite模式
        该模式下，配置类内部可以通过方法调用来处理依赖，并且能够保证是同一个实例，都指向IoC内的那个单例
        该模式下，@Bean方法不能被private/final等进行修饰（很简单，因为方法需要被复写嘛，所以不能私有和final。
        defualt/protected/public都可以哦）
        ，否则启动报错（其实IDEA编译器在编译器就提示可以提示你了）

    EnableConfigurationProperties
        如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，
        那么在IOC容器中是获取不到properties 配置文件转化的bean。
        说白了 @EnableConfigurationProperties 相当于把使用 @ConfigurationProperties 的类进行了一次注入。


    @ConditionalOnJava Java的版本匹配特定值或者一个范围值
    @ConditionalOnProperty 指定的配置属性要有一个明确的值
    @ConditionalOnResource Classpath里有指定的资源
    @ConditionalOnWebApplication 这是一个Web应用程序
    @ConditionalOnNotWebApplication 这不是一个Web应用程序

    声明Bean的注解:
    @Component : 组件,没有明确的角色
    @Service : 在业务逻辑层(service层)使用
    @Repository : 在数据访问层(dao层)使用.
    @Controller : 在展现层(MVC--SpringMVC)使用

    注入Bean的注解:
    @Aautowired : Spring提供的注解.
    @Inject : JSR-330提供的注解
    @Resource : JSR-250提供的注解
    @Primary 注入时优先使用此注解下的实现类，对应org.springframework.beans.factory.NoUniqueBeanDefinitionException异常

    @WiselyConfiguration : 组合注解 可以替代 @Configuration和@ComponentScan
    @Bean(initMethod="aa",destroyMethod="bb")--> 指定 aa和bb方法在构造之后.Bean销毁之前执行.
    

    @PostConstruct : 在构造函数执行完之后执行
    @PreDestroy : 在 Bean 销毁之前执行
    @ActiveProfiles : 用来声明活动的 profile
    @profile: 为不同环境下使用不同的配置提供了支持
    @Profile("dev") .......对方法名为 dev-xxxx的方法提供实例化Bean

    @Value ("我爱你") --> 普通字符串注入
    @Value ("#{systemProperties['os.name']}") -->注入操作系统属性
    @Value ("#{ T (java.lang.Math).random() * 100.0 }") --> 注入表达式结果
    @Value ("#{demoService.another}") --> 注入其他Bean属性
    @Value ( "classpath:com/wisely/highlight_spring4/ch2/el/test.txt" ) --> 注入文件资源
    @Value ("http://www.baidu.com")-->注入网址资源
    @Value ("${book.name}" ) --> 注入配置文件 注意: 使用的是$ 而不是 #



# spring  ${} 使用

    ${} 可以取 多个配置里面只 ， jdbc.properties 或者多配置文件
    可以给定默认值 ${user.name:root}
    
    不仅可以从配置读， 还可以读 System.setProperties 和环境变量;


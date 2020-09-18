

# spring 笔记

> bean 生命周期
    
    spring bean 实例化

    将值与属性注入到bean 对应属性 （填充属性）
    如果bean实现了BeanNameAware接口    将bean的ID传递给setBean-Name()方法
    如果bean实现了BeanFactoryAware接口     调用setBeanFactory()方法，将BeanFactory容器实例传入
    如果bean实现了ApplicationContextAware接口      Spring将调用setApplicationContext()方法，将bean所在的应用上下文的引用传入进来
    
    如果bean实现了BeanPostProcessor接口        Spring将调用它们的post-ProcessBeforeInitialization()方法 // 前置处理器
    如果bean实现了InitializingBean接口     Spring将调用它们的after-PropertiesSet()方法
    如果bean实现了BeanPostProcessor接口    Spring将调用它们的post-ProcessAfterInitialization()方法 // 后置处理器

    就绪
    使用
    卸载（销毁）
    
    实例化
    配置bean注入   
    
    使用 
    
    
    
    
> bean 作用域

    单例
    原型（多例）
    会话 （每个会话）
    请求 （每个请求）
    
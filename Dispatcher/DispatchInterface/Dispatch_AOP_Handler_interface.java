package Dispatcher.DispatchInterface;

public interface Dispatch_AOP_Handler_interface {
    /*
        处理aop的事件。
        这里也只是简单地将aop中的保存的类通过jdk的动态代理然后再将其返给ioc容器
        在这里ioc容器中的key与aop中的key相对于同一个Object来说是一样的。
     */
    public void AOP_Handler();
}

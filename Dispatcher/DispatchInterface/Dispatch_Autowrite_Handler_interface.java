package Dispatcher.DispatchInterface;

public interface Dispatch_Autowrite_Handler_interface {
    /*
        处理正常的自动注入事件
        通常只是针对于Autowrite
        后面可以处理更多的注入事件如自定义的注释事件，都可以通过这个接口来自定义
     */
    public void Handle_Autowrite();
}

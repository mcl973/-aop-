package Dispatcher.DispatchInterface;

public interface DispatchInstance {
    /*
        service、MAutowrite、before、looparound、after。
        对于这里是需要的创建型的实例的。
        包含service和MAutowrite是需要创建在ioc容器中的
        包含before、looparound、after是需要创建在aop的容器中的。

        重要的是在进行向aop里添加新的数据时需要注意的是这个类需要被Service注释。
        这个是保证aop能够被正常使用的保证。
     */
    void Instance();
}

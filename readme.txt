一个独立的java的aop框架，支持自主编程增强函数。同时提供ioc和aop的功能选型。ioc为必备，aop为附加
Service_Paragrame、Enhance_Functions、AutowritePackets、StartRun。
其中Service_Paragrame包含了接口包和接口实现包。
Service_Paragrame是处理正常的业务程序，需要自己添加相应的实现方式。
Enhance_Functions是一个包含了前置、后置、环绕的增强包。其中BseInterface和每一个子包中的接口不需要改动。
需要改动的是每一个子包中的实现类。
每一个子包中都有一个实现类的样例。读者可以按照这个修改。
AutowritePackets是一个包含了自动注入的包，里面的每一个类都会有自动注入。这里是需要读者将需要自动注入的类添加到这里来。
包里面也给出了一个样例。
最后需要改动的就是main方法。main方法里也有了一个具体的样例。
对于dispatcher，有两个构造函数：
1.带参数，修改是否为aop模式。0为不修改，1为修改
2.不带参数模式，默认为0，即不是aop模式.

、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、
更新
添加了自定义注解的功能。
只是实现了class、method、field的自定义注解的部分，函数参数的注解没有写，希望后续可以添加。
并且在自定义注解中目前只支持String value() default "";这一个函数，其他的函数还没有支持。
有读者可以的话欢迎来添加行的功能。
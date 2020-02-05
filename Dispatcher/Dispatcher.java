/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dispatcher
 * Author:   Administrator
 * Date:     2020/02/05 15:59
 * Description: dispather的启动和初始化类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Dispatcher;

/**
 * 〈一句话功能简述〉<br> 
 * 〈dispather的启动和初始化类〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Dispatcher extends Dispatcher_Parent{

    public Dispatcher(){
        init();
    }
    //带选择的模式，0为ioc，1为ioc+aop
    public Dispatcher(int aop_or_ioc){
        Aop_or_Ioc = aop_or_ioc;
        init();
    }
    void init(){
        new Dispatch_Instance().Instance();
        if (Aop_or_Ioc == 1)
            new Dispath_AOP_Handler().AOP_Handler();
        new Dispatch_Autowrite_Handler().Handle_Autowrite();
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dispath_AOP_Handler
 * Author:   Administrator
 * Date:     2020/02/05 14:42
 * Description: 处理aop的事件
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Dispatcher;

import Dispatcher.DispatchInterface.Dispatch_AOP_Handler_interface;
import Dispatcher.Dispatcher_Parent;
import JDK_Automatic.JAutomatic;
import JDK_Automatic.Mcl_Invocation_Handler;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈处理aop的事件〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Dispath_AOP_Handler extends Dispatcher_Parent implements Dispatch_AOP_Handler_interface {
    @Override
    public void AOP_Handler() {
        //其原理其实就是在这里讲ioc中的内容替换掉，使用同一个key
        //如在ioc中的key是name，name就是用同样的那么将其替换掉，但是value是代理过的。
        if (Aop_or_Ioc == 1) {
            JAutomatic jAutomatic = new JAutomatic();
            for (Map.Entry<String, Object> entry : aopmap.entrySet()) {
                Object o = entry.getValue();
                String key = entry.getKey();
                Mcl_Invocation_Handler mcl_invocation_handler = new Mcl_Invocation_Handler(o);
                Object newInstance = jAutomatic.createNewInstance(o, mcl_invocation_handler);
                iocmap.put(key, newInstance);
            }
        }
    }
}

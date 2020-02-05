/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dispatch_Autowrite_Handler
 * Author:   Administrator
 * Date:     2020/02/05 14:36
 * Description: 处理自动注入的事件
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Dispatcher;

import Annotation_Aop_Ioc.MAutowrite;
import Dispatcher.DispatchInterface.Dispatch_Autowrite_Handler_interface;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈处理自动注入的事件〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Dispatch_Autowrite_Handler extends Dispatcher_Parent implements Dispatch_Autowrite_Handler_interface {

    @Override
    public void Handle_Autowrite() {
        for(Map.Entry<String,Object> entry:iocmap.entrySet()){
            //获取ioc中每一个实例
            Object object = entry.getValue();
            Class clazz = object.getClass();
            //获取所有的属性
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(MAutowrite.class)){
                    //找到没一个注释
                    MAutowrite mAutowrite = (MAutowrite) declaredField.getAnnotation(MAutowrite.class);
                    try {
                        //通过获取keyget到具体的类。
                        Object object1 = iocmap.get(mAutowrite.value());
                        declaredField.setAccessible(true);
                        //加紧此实例注入到属性中去。
                        declaredField.set(object,object1);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

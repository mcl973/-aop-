/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dispatch_Instance
 * Author:   Administrator
 * Date:     2020/02/05 14:08
 * Description: 实例化
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Dispatcher;

import Annotation_Aop_Ioc.*;
import Dispatcher.DispatchInterface.DispatchInstance;
import JDK_Automatic.FindEnhanceFunction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实例化〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Dispatch_Instance extends Dispatcher_Parent implements DispatchInstance {
    private FindEnhanceFunction fef = new FindEnhanceFunction();
    @Override
    public void Instance() {
        for (String filename : filesname) {
            String fn = filename.replace(".class","");
            try {
                Class clazz = Class.forName(fn);
                /*
                    针对于类上面的注释的实现
                 */
                Annotation[] annotations = clazz.getAnnotations();
                if (annotations.length!=0) {
                    try {
                        Object object = clazz.newInstance();
                        for (Annotation annotation : annotations) {
                            //如果不是默认的Service注解，那就一定是自定义注解
                            if (annotation instanceof Service) {
                                Service service = (Service) clazz.getAnnotation(Service.class);

                                iocmap.put(service.value(), object);
                                //如果开启了aop的模式那么就进行增强
                                if (Aop_or_Ioc == 1) {
                                    if (iscreateaop(clazz)) {
                                        aopmap.put(service.value(), object);
                                    }
                                }
                            } else { //开始自定义注解
                                String value = fef.getValue(clazz);
                                iocmap.put(value, object);
                                //如果开启了aop的模式那么就进行增强
                                if (Aop_or_Ioc == 1) {
                                    if (iscreateaop(clazz)) {
                                        aopmap.put(value, object);
                                    }
                                }
                            }
                        }
                    }catch (Exception e){
                        continue;
                    }
                }
                if (iscreateioc(clazz)){
                    Object object = clazz.newInstance();
                    String iockey = object.getClass().getName();
                    iocmap.put(iockey,object);
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    /*
        检查是否需要创建一个新的ioc进入ioc容器中
     */
    public boolean iscreateioc(Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //如果遍历到有属性有着这个注释那么就将其放置到icomap中去。
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length!=0)
                return true;
        }
        return false;
    }
    /*
        检查这个类是否需要被aop增强
     */
    public boolean iscreateaop(Class clazz){
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //遍历每一个方法如果包含其中一种注解那么就对这个类做aop处理。
            //这么做的是防止有的Service没有编写需要被增强的注释。
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length!=0)
                return true;
        }
        return false;
    }
}

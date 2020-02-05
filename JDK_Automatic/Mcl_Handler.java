/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Mcl_Handler
 * Author:   Administrator
 * Date:     2020/02/05 14:51
 * Description: 处理handler的父类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package JDK_Automatic;

import Annotation_Aop_Ioc.after;
import Annotation_Aop_Ioc.before;
import Annotation_Aop_Ioc.looparound;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈处理handler的父类〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Mcl_Handler {
    public Object object;
    Mcl_Handler(Object object){
        this.object = object;
    }

    //通过代理类和原始类的对比得出原始类中的需要被增强的函数
    public Method getOriginMethod(Method method1){
        int k = 0;
        Class clazz = this.object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(method1.getName())) {
                Parameter[] parameters = method.getParameters();
                Parameter[] parameters1 = method1.getParameters();
                if (parameters.length == parameters1.length) {

                    for (int i = 0; i < parameters.length; i++) {
                        if (parameters[i].getType() != parameters1[i].getType())
                            k = 1;
                    }
                    if (k == 1)
                        continue;
                    if (method.getReturnType() != method1.getReturnType()) {
                        continue;
                    }
                }else continue;
                return method;
            }
        }
        return null;
    }
}

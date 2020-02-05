/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoopAround_test1
 * Author:   Administrator
 * Date:     2020/02/05 16:27
 * Description: looparound测试1
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Enhance_Functions.LoopAround;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈looparound测试1〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class LoopAround_test1 implements LoopAround{

    @Override
    public void excute(Method method, Object object, Object[] args) {
        try {
            before(method);
            Object o = method.invoke(object,args);
            after(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public void before(Method method){
        System.out.println(method.getName()+"   "+method.getReturnType()+"  "+method.getModifiers());
    }
    public void after(Object object){
        if (object!=null) {
            Class clazz = object.getClass();
            System.out.println(clazz.getName());
        }else System.out.println("函数执行完返回了一个null");
    }
}

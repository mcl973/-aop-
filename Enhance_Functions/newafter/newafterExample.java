/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: newafterExample
 * Author:   Administrator
 * Date:     2020/02/06 13:00
 * Description: 自定义注解案例
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Enhance_Functions.newafter;

import Enhance_Functions.BseInterface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义注解案例〉
 *
 * @author 毛从雷
 * @create 2020/02/06
 * @since 1.0.0
 */
public class newafterExample implements BseInterface {
    @Override
    public void excute(Method method, Object object, Object[] args) {
        try {
            method.invoke(object,args);
            newafter();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void newafter(){
        System.out.println("this is new after Enhance Method");
    }
}

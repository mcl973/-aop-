/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Before_Example
 * Author:   Administrator
 * Date:     2020/02/05 15:03
 * Description: before的使用例子
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Enhance_Functions.Before;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈before的使用例子〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Before_Example implements Before{
    @Override
    public void excute(Method method, Object object, Object [] args){
        before();
        try {
            method.invoke(object,args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void before(){
        System.out.println("this is before");
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoopAround_Example
 * Author:   Administrator
 * Date:     2020/02/05 15:04
 * Description: looparound的使用的例子
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Enhance_Functions.LoopAround;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈looparound的使用的例子〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class LoopAround_Example implements LoopAround{

    @Override
    public void excute(Method method,Object object,Object [] args){
        try {
            before();
            method.invoke(object,args);
            after();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void after(){
        System.out.println("this is before");
    }
    public void before(){
        System.out.println("this is before");
    }
}

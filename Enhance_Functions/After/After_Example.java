/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: After_Example
 * Author:   Administrator
 * Date:     2020/02/05 15:02
 * Description: after的使用例子
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Enhance_Functions.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈after的使用例子〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class After_Example implements After{
    @Override
    public void excute(Method method, Object object, Object [] args){
        try {
            method.invoke(object,args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        after();
    }
    public void after(){
        System.out.println("this is after");
    }
}

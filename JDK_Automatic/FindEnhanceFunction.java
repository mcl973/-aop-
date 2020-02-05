/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindEnhanceFunction
 * Author:   Administrator
 * Date:     2020/02/05 15:30
 * Description: 找到增强的方法
 * History:
 * <author>          <time>          <version>          <desc>
 */
package JDK_Automatic;

import Annotation_Aop_Ioc.after;
import Annotation_Aop_Ioc.before;
import Annotation_Aop_Ioc.looparound;
import Enhance_Functions.After.After;
import Enhance_Functions.Before.Before;
import Enhance_Functions.BseInterface;
import Enhance_Functions.LoopAround.LoopAround;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈找到增强的方法〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class FindEnhanceFunction {
    public LoopAround getlooparound(Method method){
        /*
           这里就需要选择出是哪一个增强类了
           通过looparound中的value可以得到
         */
        looparound la = method.getAnnotation(looparound.class);
        //得到增强方法的类全限定名
        String value = la.value();
        return (LoopAround) getMyAnnotation(value);
    }

    public After getafter(Method method){
        /*
           这里就需要选择出是哪一个增强类了
           通过looparound中的value可以得到
         */
        after la = method.getAnnotation(after.class);
        //得到增强方法的类全限定名
        String value = la.value();
        return (After) getMyAnnotation(value);
    }

    public Before getbefore(Method method){
        /*
           这里就需要选择出是哪一个增强类了
           通过looparound中的value可以得到
         */
        before la = method.getAnnotation(before.class);
        //得到增强方法的类全限定名
        String value = la.value();
        return (Before) getMyAnnotation(value);
    }

    public Object getMyAnnotation(String value){
        /*
            通过value查找具体的类
         */
        Object around = null;
        try {
            Class clazz = Class.forName(value);
            around = clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return around;
    }
}

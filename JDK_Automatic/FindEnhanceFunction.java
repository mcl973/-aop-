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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

    private Annotation getExterAnnotation(Annotation[] annotations){
        if (annotations.length != 0) {
            for (Annotation annotation : annotations) {
                Class annclazz = annotation.getClass();
                Method[] methods = annclazz.getMethods();
                for (Method method1 : methods) {
                    if (method1.getName().equals("value")) {
                        return annotation;
                    }
                }
            }
        }
        return null;
    }

    public Annotation getExterAnnotation2(Annotation[] annotations){
        return getExterAnnotation(annotations);
    }

    /*
        得到函数上的注解
     */
    public Annotation getExterFunctionAnnotation(Method method) {
        Annotation[] annotations = method.getAnnotations();
        return getExterAnnotation(annotations);
    }

    /*
        得到类属性上的注解
     */
    public Annotation getExterFieldAnnotation(Field field) {
        Annotation[] annotations = field.getAnnotations();
        return getExterAnnotation(annotations);
    }

    /*
        得到类上的注解
     */
    public Annotation getExterClassAnnotation(Class clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        return getExterAnnotation(annotations);
    }

    /*
        得到自定义注解中的value函数中的值
     */
    public String getAnnotationValue(Annotation getmethod){
        assert getmethod != null;
        Class<? extends Annotation> aClass = getmethod.getClass();
        Method[] methods = aClass.getMethods();
        Method method1 = null;
        for (Method method : methods) {
            if (method.getName().equals("value")) {
                method1 = method;
                break;
            }
        }
        if (method1!=null) {
            String name = null;
            try {
                name = (String)method1.invoke(getmethod, null);
                return name;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /*
        对外开放的函数
     */
    public Object getEnhanceObject(String value){
        return getMyAnnotation(value);
    }

    /*
        快速的获取到注释中的value函数中的值
     */
    public String getValue(Class clazz){
        Annotation exterClassAnnotation = getExterClassAnnotation(clazz);
        return getAnnotationValue(exterClassAnnotation);
    }

    public String getValue(Method method){
        Annotation exterFunctionAnnotation = getExterFunctionAnnotation(method);
        return getAnnotationValue(exterFunctionAnnotation);
    }

    public String getValue(Field field){
        Annotation exterFieldAnnotation = getExterFieldAnnotation(field);
        return getAnnotationValue(exterFieldAnnotation);
    }

    private Object getMyAnnotation(String value){
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

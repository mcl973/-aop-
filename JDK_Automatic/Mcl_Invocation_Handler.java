/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Mcl_Invocation_Handler
 * Author:   Administrator
 * Date:     2020/02/05 14:50
 * Description: 具体的处理函数的handler
 * History:
 * <author>          <time>          <version>          <desc>
 */
package JDK_Automatic;

import Annotation_Aop_Ioc.after;
import Annotation_Aop_Ioc.before;
import Annotation_Aop_Ioc.looparound;

import Enhance_Functions.BseInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈具体的处理函数的handler，可以处理自定义添加的增强函数〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Mcl_Invocation_Handler extends Mcl_Handler implements InvocationHandler {
    FindEnhanceFunction fef = new FindEnhanceFunction();
    public Mcl_Invocation_Handler(Object object){
        super(object);
    }
    //得到此时这个aop的状态
    /*
        在这里可以通过使用注释中的value方法提取出需要增强的方法
     */
    public BseInterface getaopstate(Method method1){
        Method method = getOriginMethod(method1);
        if (method!=null) {
            if (method.isAnnotationPresent(looparound.class)) {
                return fef.getlooparound(method);
            }else if (method.isAnnotationPresent(after.class)){
                return fef.getafter(method);
            } else if (method.isAnnotationPresent(before.class)) {
                return fef.getbefore(method);
            }
        }
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        BseInterface bseInterface = getaopstate(method);
        bseInterface.excute(method,this.object,args);
        return null;
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: JAutomatic
 * Author:   Administrator
 * Date:     2020/02/05 14:46
 * Description: jdk
 * History:
 * <author>          <time>          <version>          <desc>
 */
package JDK_Automatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈jdk的动态代理〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class JAutomatic {
    public Object createNewInstance(Object object, InvocationHandler handler){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handler);
    }
}

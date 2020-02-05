/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: looparound
 * Author:   Administrator
 * Date:     2020/02/04 9:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Annotation_Aop_Ioc;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 毛从雷
 * @create 2020/02/04
 * @since 1.0.0
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface looparound {
    String value() default "";
}

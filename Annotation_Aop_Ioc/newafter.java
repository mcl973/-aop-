/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: newafter
 * Author:   Administrator
 * Date:     2020/02/06 12:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Annotation_Aop_Ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 毛从雷
 * @create 2020/02/06
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface newafter {
    String value() default "";
}

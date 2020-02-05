/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MAutowrite
 * Author:   Administrator
 * Date:     2020/02/04 9:29
 * Description: 自动注入
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
 * 〈自动注入〉
 *
 * @author 毛从雷
 * @create 2020/02/04
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MAutowrite {
    String value()default "";
}

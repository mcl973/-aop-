/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AutowriteTest
 * Author:   Administrator
 * Date:     2020/02/05 15:57
 * Description: 自动注入测试
 * History:
 * <author>          <time>          <version>          <desc>
 */
package AutowritePackets;

import Annotation_Aop_Ioc.MAutowrite;
import Service_Paragrame.ServiceInterface.ServiceInterfaceTest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动注入测试〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class AutowriteTest {
    @MAutowrite("ServiceInterfaceTestImpl")
    public static  ServiceInterfaceTest serviceInterfaceTest;
}

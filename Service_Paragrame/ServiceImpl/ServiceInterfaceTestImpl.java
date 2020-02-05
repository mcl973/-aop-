/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ServiceInterfaceTestImpl
 * Author:   Administrator
 * Date:     2020/02/05 15:54
 * Description: 接口的实现类测试
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Service_Paragrame.ServiceImpl;

import Annotation_Aop_Ioc.Service;
import Annotation_Aop_Ioc.before;
import Annotation_Aop_Ioc.looparound;
import Service_Paragrame.ServiceInterface.ServiceInterfaceTest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈接口的实现类测试〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
@Service("ServiceInterfaceTestImpl")
public class ServiceInterfaceTestImpl implements ServiceInterfaceTest {
    @Override
    @looparound("Enhance_Functions.LoopAround.LoopAround_test1")
    public void query(String name) {
        System.out.println("你的名字："+name);
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RunTest
 * Author:   Administrator
 * Date:     2020/02/05 15:58
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package StartRun;

import AutowritePackets.AutowriteTest;
import Dispatcher.Dispatcher;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试类〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class RunTest {
    public static void main(String[] args) {
        new Dispatcher(1);
        AutowriteTest.serviceInterfaceTest.query("毛从雷");
    }
}

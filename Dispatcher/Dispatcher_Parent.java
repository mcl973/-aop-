/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dispatcher_Parent
 * Author:   Administrator
 * Date:     2020/02/05 14:02
 * Description: 管控所有ioc和aop容器的父类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package Dispatcher;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管控所有ioc和aop容器的父类〉
 *
 * @author 毛从雷
 * @create 2020/02/05
 * @since 1.0.0
 */
public class Dispatcher_Parent {
    protected static Map<String ,Object> iocmap = new HashMap<>();
    protected static Map<String ,Object> aopmap = new HashMap<>();
    protected static List<String> filesname = new ArrayList<>();
    protected static int Aop_or_Ioc = 0;

    public Dispatcher_Parent(){
        if (filesname.size()==0)
            ScannerClassFile("");
    }
    public void ScannerClassFile(String path){
        URL resource = this.getClass().getClassLoader().getResource(path.replaceAll("\\.", "/"));
        if (resource==null)
            return;
        String filename = resource.getFile();
        File file = new File(filename);
        if (file.isDirectory()){
            String[] filenames = file.list();
            if (filenames!=null) {
                for (String s : filenames) {
                    File file1 = new File(filename +"\\"+ s);
                    if (file1.isDirectory()) {
                        if (path.equals(""))
                            ScannerClassFile(s);
                        else
                            ScannerClassFile(path + "." + s);
                    } else {
                        if (path.equals(""))
                            filesname.add(s);
                        else
                            filesname.add(path + "." + s);
                    }
                }
            }
        }
    }
}

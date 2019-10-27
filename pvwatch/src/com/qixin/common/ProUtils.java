package com.qixin.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.apache.log4j.Logger;

/**
 * 读取配置文件工具类
 * @author xqq
 *
 */
public class ProUtils {
	
    private static final Logger logger = Logger.getLogger(ProUtils.class);
    private static Properties props;
    static{
        loadProps();
    }

    private synchronized static  void loadProps(){
        logger.info("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
      //　<!--第一种，通过类加载器进行获取properties文件流-->
            in = ProUtils.class.getClassLoader().getResourceAsStream("httpConfig.properties");
     // <!--第二种，通过类进行获取properties文件流-->
            //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("config.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("config.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

}

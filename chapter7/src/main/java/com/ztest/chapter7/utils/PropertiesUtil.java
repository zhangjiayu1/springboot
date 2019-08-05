package com.ztest.chapter7.utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/02
 * \* Time: 09:57
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description: Java Mail(chapter 7)
 * \
 */
public class PropertiesUtil {
    private final ResourceBundle resource;
    private final String fileName;

    /**
     * 构造函数实例化部分对象，获取文件资源对象
     *
     * @Param fileName
     */
    public PropertiesUtil(String fileName){
        this.fileName = fileName;
        Locale locale = new Locale("zh","CN");
        this.resource = ResourceBundle.getBundle(this.fileName,locale);
    }

    /**
     * 根据传入的key获取对象的值
     *
     * @Param key properties文件对应的key
     * @return String 解析后的对应key的值
     */
    public String getValue(String key){
        String message = this.resource.getString(key);
        return message;
    }

    /**
     * 获取properties文件内的所有key值
     *
     * @return
     */
    public Enumeration<String> getKeys(){
        return resource.getKeys();
    }
}

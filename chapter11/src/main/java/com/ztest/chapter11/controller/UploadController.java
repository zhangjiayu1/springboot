package com.ztest.chapter11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/07
 * \* Time: 10:21
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 11 上传方法
 * \
 */
@RestController
public class UploadController {

    private final static Logger logger = LoggerFactory.getLogger(UploadController.class);
    /**
     * 初始化上传文件界面，跳转到index.jsp
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录error错误日志");
        return "index";
    }

    /**
     * 提取上传方法为公共方法
     * @param uploadDir
     * @param file
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception{
        //文件名后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    /**
     * 上传单个文件
     * @param request
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public @ResponseBody String upload(HttpServletRequest request,MultipartFile file){
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir,file);
        }catch (Exception e){
            //打印错误信息
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }

    /**
     * 上传多个文件
     * @param request 请求对象
     * @param file 上传文件集合
     * @return
     */
    @PostMapping(value = "/uploads")
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file){
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i = 0;i < file.length;i++){
                if(!file[i].isEmpty()){
                    //调用上传方法
                    executeUpload(uploadDir,file[i]);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

}

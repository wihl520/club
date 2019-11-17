package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Tips;
import com.gzqf.clubapi.service.ApiTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping(value = "tip")
public class ApiTipsController {
    @Autowired
    private ApiTipsService apiTipsService;

    @RequestMapping(value = "getTipsList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTipsList(Long id){
        List<Tips> list = apiTipsService.getTipsList(id);
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "getTip",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTip(Long id){
        Tips tip = apiTipsService.getTip(id);
        return JSON.toJSONString(tip);
    }

    /**
     * 用流的方式返回图片
     */
    @RequestMapping("/picShow")
    public void picShow(String fileName,HttpServletResponse response){
        InputStream inputStream=null;
        try {
            //添加contentType 告诉浏览器返回的数据类型
            //获取文件后缀
            int index=fileName.lastIndexOf(".");
            String suffix=fileName.substring(index+1);
            if("jpg".equals(suffix)){
                response.setContentType("image/jpeg");
            }else if("png".equals(suffix)){
                response.setContentType("image/png");
            }
            File file=new File("d:/img/"+fileName);
            inputStream=new FileInputStream(file);
            OutputStream outputStream=response.getOutputStream();
            byte[] buff=new byte[512];
            int k=0;//每次读完后返回读了多个字节
            while ((k=inputStream.read(buff))>0){
                outputStream.write(buff,0,k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

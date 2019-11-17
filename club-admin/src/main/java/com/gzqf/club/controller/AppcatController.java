package com.gzqf.club.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.impl.AppcatServiceImpl;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/appcat")
public class AppcatController extends BaseController<AppcatServiceImpl,Appcat> {

    @RequestMapping(value = "/list")
    public String toAppcatList(HttpServletRequest request, Appcat appcat, String names, Page page, Model model, @ModelAttribute("message") String message){
//        String name = null;
//        if(StringUtils.isNotEmpty(names)){
//            request.setCharacterEncoding("utf-8");
//            name = new String(names.getBytes("iso-8859-1"), "utf-8");
//            appcat.setName(name);
//        }
        appcat.setPage(page);
        Result result = Service.pageList(appcat);
        model.addAttribute("list",((PageResult<Appcat>)result.getData()).getList());
        //使用自定义标签库，显示分页
        model.addAttribute("page",(PageResult<Appcat>)result.getData());
        model.addAttribute("message",message);
        return "/appcat/list";
    }

    //跳转到新增页面
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String toForm(Long id, Model model, @ModelAttribute("errorMessage")String errorMessage, @ModelAttribute("appcat") Appcat appcat1){
        //带有ID的跳转为修改操作，需进行数据回显
        if(appcat1 != null){
            model.addAttribute("appcat",appcat1);
        }
        if(id != null && id.longValue() > 0){
            Appcat appcat = Service.getById(id);
            model.addAttribute("appcat",appcat);
        }
        model.addAttribute("errorMessage",errorMessage);
        return "/appcat/form";
    }

    //器材分类的编辑(含新增及添加功能)
    @RequestMapping("/edit")
    public String edit(Appcat appcat, Model model, RedirectAttributes redirectAttributes){
        Result result = null;
        //依据参数是否有ID判断是新增还是修改
        if(appcat.getId() != null && appcat.getId().longValue() > 0){
            result = Service.update(appcat);
        }
        //ID存在，为编辑修改
        else{
            result = Service.save(appcat);
        }
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message",result.getMessage());
            return "redirect:/appcat/list";
        }
        redirectAttributes.addFlashAttribute("errorMessage",result.getMessage());
        return "redirect:/appcat/form";
    }

    //仅能删除无子节点的数据
    @RequestMapping(value = "/delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        Result result = Service.delete(id);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message","删除数据成功！");
        }else{
            redirectAttributes.addFlashAttribute("failMessage",result.getMessage());
        }
        return "redirect:/appcat/list";
    }

    @RequestMapping("/toAddSubNode")
    public String toAddSubNode(Long id,RedirectAttributes redirectAttributes){

        Appcat parent = Service.getById(id);
        Appcat appcat = new Appcat();
        appcat.setParent(parent);
        redirectAttributes.addFlashAttribute("appcat",appcat);
        return "redirect:/appcat/form";
    }

//    ztree使用的数据
    @RequestMapping(value = "/treeData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String treeData(Long id){
        if(id == null ){
            id = 0L;
        }
        List<Appcat> list = Service.queryChildrenAppcat(id);
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/upload",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String upload(MultipartFile dropFile) throws IOException {
        String fileName = dropFile.getOriginalFilename();
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        fileName = UUID.randomUUID().toString().replaceAll("-","")+suffix;
        //文件存储在本地盘
        dropFile.transferTo(new File("d:/imgs/"+fileName));
        System.out.println("*********");
        System.out.println(fileName);
        Map data=new HashMap();
        data.put("errno",0);
        data.put("path",fileName);
        data.put("data",new String[]{"/appcat/picShow?fileName="+fileName});
        return JSON.toJSONString(data);
    }

    /**
     * 用流的方式返回图片
     */
    @RequestMapping("/picShow")
    public void picShow(String fileName, HttpServletResponse response){
        InputStream inputStream=null;
        try {
            //添加contentType 告诉浏览器返回的数据类型
            //获取文件后缀
            int index=fileName.lastIndexOf(".");
            String suffix=fileName.substring(index);
            if("jpg".equals(suffix)){
                response.setContentType("image/jpeg");
            }else if("png".equals(suffix)){
                response.setContentType("image/png");
            }
            File file=new File("d:/imgs/"+fileName);
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

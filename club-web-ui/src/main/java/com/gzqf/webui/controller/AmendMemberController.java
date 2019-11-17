package com.gzqf.webui.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.webui.service.LoginService;
import com.gzqf.webui.service.WebUIAmemtMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class AmendMemberController  {

    private  static  final  String REMEBER_UserDto = "userDto";
    private  static  final  String REMEBER_Member = "member";
    @Autowired
    private WebUIAmemtMemberService webUIAmemtMemberService;

    @Autowired
    private LoginService loginService;

    //跳转到个人中心页
    @RequestMapping("/membertopersonalcenter")
    public  String membertopersonalcenter(HttpServletRequest req, HttpServletResponse resp){
        //判断是否登录
        UserDto<Member> userDto = (UserDto<Member>) req.getSession().getAttribute("userDto");

        if (userDto==null){
            req.getSession().setAttribute("message","用户你还没登录，请先登录！！！");
            return "redirect:/membertologin";
        }
        else{
            //取出账号密码登录
            Member member = (Member)req.getSession().getAttribute("member");
            UserDto adminlogin = loginService.adminlogin(member);
            member = (Member) adminlogin.getData();
            req.getSession().setAttribute("member",member);
            return "/member/personalcenter";
        }
    }

    /*跳转到修改密码页面*/
    @RequestMapping(value = "/amendpassword")
    public String amendpassword(){

        return "/member/amendpassword";
    }

    //修改用户信息
    @RequestMapping(value = "/amemdmember")
    public String AmemdMember(Member member,String sex1, HttpServletRequest req,HttpServletResponse resp){
      //获取到session中用户id
        Member membersession =(Member) req.getSession().getAttribute("member");
        member.setId(membersession.getId());
        //修改
        UserDto<Member> userDto = webUIAmemtMemberService.amemt(member,sex1);
        req.getSession().setAttribute(REMEBER_UserDto,userDto);
        req.getSession().setAttribute("updatamessage",userDto.getMessage());
        member = userDto.getData();
        req.getSession().setAttribute(REMEBER_Member,member);
        //重定向
        return "/member/personalcenter";
    }
    //修改用户密码
    @RequestMapping(value = "/amemdmemberpassword")
    public String amemdmemberpassword(String password, String newpassword, String repassword, HttpSession session){
        //新密码确认是否一样
        if(!StringUtils.equals(newpassword,repassword)){
            session.setAttribute("passwordmasasge","新密码与确认密码不一致，请重新输入！！！");
            return "/member/amendpassword";
        }
        else {
            Member member = (Member) session.getAttribute("member");
            Long id = member.getId();
            UserDto<Member> userDto =webUIAmemtMemberService.amemdmemberpassword(id,password,newpassword);
             //原密码不正确
              if (UserDto.FAIL_STATUS==userDto.getStatus()){
                  session.setAttribute("passwordmasasge","原密码不正确，请重新输入！！！");
                  return "/member/amendpassword";
              }
              else{
                  session.setAttribute("message",userDto.getMessage());
                  //修改成功跳转到注销重新登录
                  return "redirect:/LogoutUser";
              }

        }


    }

    /**
     * MultipartFile 的属性file代表了上传那个表单域的name
     * @param file
     * @return
     */
    @RequestMapping(value = "/memberupload",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String upload(MultipartFile dropFile, HttpServletResponse response ,HttpServletRequest req)throws Exception{
        //response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");//指定返回数据的类型是json
        //查看文件夹是否存在，不存在就创建
        //获取原来的文件名
        String filename=dropFile.getOriginalFilename();
        int index=filename.lastIndexOf(".");
        String suffix=filename.substring(index);
        filename= UUID.randomUUID().toString().replaceAll("-","")+suffix;
        //文件存放路径
        String filePath = req.getSession().getServletContext().getRealPath("/static/upload/"+filename);
        //使用放到对应文件夹下面
//        String filePath = "E:/java1804-3/Club/club-web-ui/memberimage/"+fileName;

        File file = new File(filePath);
        if (file.exists()){
            file.mkdirs();
        }
        dropFile.transferTo(file);

        Map data=new HashMap();
        data.put("errno",0);
        data.put("path",filename);
        data.put("data",new String[]{"/memberpicShow?filename="+filename});/*调用使用流的返回方法*/
        return JSON.toJSONString(data);
    }
    /*

    *用流的方式返回图片
    * */
    @RequestMapping("/memberpicShow")
    public  void picShow(String filename,HttpServletResponse response,HttpServletRequest req){
        InputStream inputStream = null;
        try {
            //添加contentType 告诉浏览器返回的数据类型
            //获取文件后缀
            int index = filename.lastIndexOf(".");
            String suffix = filename.substring(index + 1);
            if ("jps".equals(suffix)){
                response.setContentType("image/jpeg");
            }
            else if("png".equals(suffix)){
                response.setContentType("image/png");
            }
            else if("gif".equals(suffix)){
                response.setContentType("image/gif");
            }
//          String filePath = req.getSession().getServletContext().getRealPath("/static/member/pic/"+fileName);
            //文件存放路径
            String filePath = req.getSession().getServletContext().getRealPath("/static/upload/"+filename);
            File file = new File(filePath);
            inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[512];
            int k = 0;//每次读完后返回读了多个字节
            while((k=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

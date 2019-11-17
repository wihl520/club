<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--时间的转换--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="/WEB-INF/views/member/include/topmembercenter.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/views/member/include/headermember.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/member/include/bannermember.jsp"></jsp:include>
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx" style="color:#ff6700;font-weight:bold;">会员中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/memberpay" >会员续费</a></li>
                    <li><a href="#">健身保险</a></li>
                    <li><a href="#">会员订单</a></li>
                    <li><a href="#">教练评价</a></li>
                </ul>
            </div>
            <div class="ddzx" style="color:#ff6700;font-weight:bold;">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/amendpassword">修改密码</a></li>
                    <li><a href="#">休课业务</a></li>
                    <li><a href="#">我的评论</a></li>
                    <li><a href="#">消息通知</a></li>
                    <li><a href="#">新闻中心</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="left-form">


                <div class="grzlbt ml40">我的资料</div>

                <div class="user-infoPic">

                    <div class="filePic">
                        <input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
                        <%--<img class="am-circle am-img-thumbnail" src="/static/personal/images/getAvatar.do.jpg" alt="头像">--%>
                        <c:choose>
                            <c:when test="${member.pic eq '' }">
                                <img class="am-circle am-img-thumbnail" src="/static/member/pic/getAvatar.do.jpg" alt="头像">
                            </c:when>
                            <c:otherwise>
                                <img class="am-circle am-img-thumbnail" src="/static/upload/${member.pic}" alt="头像">
                            </c:otherwise>
                        </c:choose>


                    </div>
                    <p class="am-form-help">头像</p>
                    <div class="info-m">
                        <div>
                            <b>
                                用户名： <i>${member.name}</i>
                            </b>
                        </div>
                        <div class="vip">
                            <span></span><a href="#">会员专享</a>
                        </div>
                    </div>
                    <div class="filePic" style="position: relative;left: 250px;">
                        <div>
                            <b>
                                用户等级:<i>${member.level}级</i>
                            </b>
                            <br><br><br>
                            <b>
                                会员天数:<i>${member.memberDay}天</i>
                            </b>
                        </div>
                    </div>
                    <div class="filePic" style="position: relative;left: 250px;">
                        <div>

                            <b>
                                健身教练:<i>${member.coachId}</i>
                            </b>
                            <br><br><br>
                            <b>
                                注册时间:<i>
                                <fmt:formatDate value="${member.created}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                            </b>
                            </i>
                        </div>
                    </div>
                    <div class="filePic" style="position: relative;left: 250px;">
                        <div>
                            </b>
                            <b>
                                是否休课:<i>正常</i>
                            </b>
                            <br><br><br>
                            <b>身份:
                                <c:choose>
                                <c:when test="${member.isCoach eq (0)}">
                                <i>初级会员</i>
                                </c:when>
                                <c:otherwise>
                                <i>健身教练</i>
                                </c:otherwise>
                                </c:choose>
                        </div>
                    </div>
                </div>
                <form action="/amemdmemberpassword" method="post" class="am-form am-form-horizontal" >
                    <div style="color: red;text-align: center;">
                        ${passwordmasasge}
                    </div>
                    <div class="am-form-group">
                        <label for="user-email" class="am-form-label">原密码</label>
                        <div class="am-form-content">
                            <input id="user-name1" placeholder="请输入原密码" type="password"  name="password" >
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="user-email" class="am-form-label">新密码</label>
                        <div class="am-form-content">
                            <input id="user-name2" placeholder="请输入新密码" type="password"  name="newpassword"  >
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="user-email" class="am-form-label">确认密码</label>
                        <div class="am-form-content">
                            <input id="user-email" placeholder="请确认密码" type="password" name="repassword"  >
                        </div>
                    </div>


                    <div style="text-align: center;" >
                        <button type="submit">确认修改</button>
                    </div>
                    <%--</div>--%>
                    <%--</div>--%>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->

<jsp:include page="/WEB-INF/views/member/include/footer.jsp"></jsp:include>
<script type="text/javascript" src="/static/plugins/dropzone/min/dropzone.min.js"></script>
<script type="text/javascript">
    $(function () {

    });
    //加载dropzone
    // 默认的 Dropzone 参数
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 5, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"
    };

    var opts={
        //id指的放我们 上传控件的那个div的id
        id: "#pic1upload",
        //上传的路径
        url: "/memberupload",
        paramName: "dropFile",//指的是上传到后台，用来获取这个上传文件的表单名,要一致
        init: function () {
            //这是当上传完成后回调这个函数
            this.on("success", function (file, data) {
                // $("#pic").val(data.fileName);
                $("#pic").val(data.path);
            });
        }
    }
    // 关闭 Dropzone 的自动发现功能
    Dropzone.autoDiscover = false;
    // 继承
    //$.extend(）jquery内部的函数，将后面的（opts）覆盖到前面的(defaultDropzoneOpts)
    $.extend(defaultDropzoneOpts, opts);

    //创建一个上传控件
    new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
</script>
</body>
</html>

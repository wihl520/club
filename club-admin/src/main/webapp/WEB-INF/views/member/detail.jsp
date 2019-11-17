<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="box-body">
    <div class="row">
        <div class="form-group">
            <label class="col-sm-4 control-label">用户名:</label>

            <div class="col-sm-8">
                ${member.name}
            </div>
        </div><br>
        <div class="form-group">
            <label class="col-sm-4 control-label">性别:</label>

            <div class="col-sm-8">
                ${member.sex}
            </div>
        </div><br>
        <div class="form-group">
            <label class="col-sm-4 control-label">邮箱:</label>

            <div class="col-sm-8">
                ${member.email}
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">用户等级:</label>

            <div class="col-sm-8">
                ${member.level}
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">手机号:</label>

            <div class="col-sm-8">
                ${member.phone}
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">注册日期:</label>

            <div class="col-sm-8">
                <fmt:formatDate value="${member.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">更改日期:</label>

            <div class="col-sm-8">
                <fmt:formatDate value="${member.updated}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">教练编号:</label>

            <div class="col-sm-8">
                ${member.coachId}
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">头像地址:</label>

            <div class="col-sm-8">
                ${member.pic}
            </div>
        </div><br>
        <div class="form-group">
            <label  class="col-sm-4 control-label">用户地址:</label>

            <div class="col-sm-8">
                ${member.address}
            </div>
        </div><br> <div class="form-group">
            <label  class="col-sm-4 control-label">会员天数:</label>

            <div class="col-sm-8">
                ${member.memberDay}
            </div>
        </div><br> <div class="form-group">
            <label  class="col-sm-4 control-label">年龄:</label>

            <div class="col-sm-8">
                ${member.age}
            </div>
        </div><br> <div class="form-group">
            <label  class="col-sm-4 control-label">计划文本:</label>

            <div class="col-sm-8">
                ${member.plan}
            </div>
        </div><br> <div class="form-group">
            <label  class="col-sm-4 control-label">锻炼部位:</label>

            <div class="col-sm-8">
                ${member.wantBuild}
            </div>
        </div><br> <div class="form-group">
            <label  class="col-sm-4 control-label">是否是教练:</label>

            <div class="col-sm-8">
                ${member.isCoach}
            </div>
        </div><br>

    </div>

</div>
</body>
</html>

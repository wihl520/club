<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>
<link href="/static/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/static/plugins/adminLTE/plugins/iCheck/all.css">

<link href="/static/plugins/dropzone/min/dropzone.min.css" rel="stylesheet" type="text/css">
<link href="/static/plugins/wangEditor/wangEditor.min.css" rel="stylesheet" type="text/css">



<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <jsp:include page="/WEB-INF/views/includes/nav.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/includes/side.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                器材管理
            </h1>
            <%--修改失败提示消息--%>
            <c:if test="${not empty errorMessage }">
                <div class="alert alert-danger alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${errorMessage}
                </div>
            </c:if>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">器材(分类)编辑</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="/appliance/edit" method="post" id="form">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="pid">所属类别</label>
                                    <%--隐藏父ID为后台交互提供参数，通过js赋值--%>
                                    <input type="hidden" class="form-control" value="${applianceAdmin.parent.id}" name="parent.id" id="pid" placeholder="所属类别ID">
                                    <input type="text" readonly="readonly" class="form-control" value="${applianceAdmin.parent.name}" name="parent.name" id="pname" placeholder="所属类别" data-toggle="modal" data-target="#modal-info">
                                </div>

                                <div class="form-group">
                                    <label for="name">器材名称</label>
                                    <input type="hidden" name="id" value="${applianceAdmin.id}">
                                    <input type="text" maxlength="10" minlength="2" required  value="${applianceAdmin.kitName}"  class="form-control" id="name" name="kitName" placeholder="器材名称">
                                </div>

                                <div class="form-group">
                                    <label for="startDay">投入使用日期(格式：2018-1-1)</label>
                                    <input type="text" class="form-control dateISO"  required value="<fmt:formatDate value='${applianceAdmin.startDay}' pattern='yyyy-MM-dd' />" id="startDay" name="startDay" placeholder="投入使用日期">
                                </div>
                                <div class="form-group">
                                    <label for="total">使用天数</label>
                                    <input type="text" class="form-control" minlength="2" required value="${applianceAdmin.total}" id="total" name="total" placeholder="使用天数">
                                </div>
                                <div class="form-group">
                                    <label>器材状态</label><br>
                                    <label>
                                        <div class="iradio_minimal-blue" aria-checked="false" aria-disabled="false" style="position: relative;" >
                                            <input type="radio" name="flag" class="minimal"  value="1"  style="position: absolute; opacity: 0;" ${applianceAdmin.flag == 1?'checked':''}>

                                            <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                        </div>
                                            良好
                                    </label>
                                    <label>
                                        <div class="iradio_minimal-blue" aria-checked="false" aria-disabled="false" style="position: relative;">
                                            <input type="radio" name="flag" value="0" class="minimal" ${applianceAdmin.flag == 0?'checked':''} style="position: absolute; opacity: 0;">
                                            <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                        </div>
                                        损坏
                                    </label>
                                </div>
                                <%--使用dropzone上传图片--%>
                                <div class="form-group">
                                    <label for="kitPic">器材图片</label>
                                    <input type="text" readonly="readonly"   value="${applianceAdmin.kitPic}"  class="form-control" id="kitPic" name="kitPic" placeholder="器材图片">
                                    <div class="dropzone" id="picupload"></div>
                                </div>
                                <%--使用wangEditor--%>
                                <%--<div class="form-group">
                                    <label for="mode">使用方式</label>
                                    <input type="hidden" class="form-control" id="mode" name="mode">
                                    <div id="editor" >${appcat.mode}</div>
                                </div>
                                <div class="form-group">
                                    <label for="play">锻炼要点</label>
                                    <input type="hidden" class="form-control" id="play" name="play">
                                    <div id="editorPlay" >${appcat.play}</div>
                                </div>

                                <div class="form-group">
                                    <label for="video">视屏</label>
                                    <input type="text" class="form-control" value="${appcat.video}" id="video" name="video" placeholder="视屏">
                                </div>--%>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button id="btnSubmit" type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->

                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/WEB-INF/views/includes/copyRight.jsp"></jsp:include>


    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <%--<div class="control-sidebar-bg"></div>--%>
</div>

</div>
<div class="modal modal-info fade in" id="modal-info" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title">父节点数据</h4>
            </div>
            <div class="modal-body">
                <%--<ul id='myTree' class='ztree'>--%>
                <ul id="category-tree" class="ztree"></ul>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">取消</button>
                <button onclick="getData()" type="button" class="btn btn-outline">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

<%--前端验证框架--%>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<%--将信息中文化--%>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="/static/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="/static/plugins/dropzone/min/dropzone.min.js"></script>
<script type="text/javascript" src="/static/plugins/wangEditor/wangEditor.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="/static/plugins/adminLTE/plugins/iCheck/icheck.min.js"></script>



<script type="text/javascript">
    $(function () {
        $("#form").validate();

        //加载ztree
        var setting = {
            view: {
                //是否允许多选 不允许多选
                selectedMulti: false
            },
            //异步
            async: {
                enable: true,
                url: "/appcat/treeData",
                autoParam: ['id']
            }
        };
        $.fn.zTree.init($("#category-tree"), setting);

        //在初始化完成后初始化wangeditor
        /*initWangEditor1();
        initWangEditor2();*/

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })

    });
    //选择节点数据参数方法
    function getData() {
        //获取到ztree对象 把控件所在的ul 那个id传进去
        var zTree = $.fn.zTree.getZTreeObj("category-tree");
        //获取到选中的节点
        var nodes = zTree.getSelectedNodes();//因为ztree允许多选，所以getSelectedNodes返回一个json对象数组
        if(nodes.length==0){
            alert("请选择一条数据");
            return;
        }
        var name=nodes[0].name;
        var id=nodes[0].id;

        $("#pid").val(id);
        $("#pname").val(name);
        $("#modal-info").modal("hide");//将model隐藏，这是bootstrap自带的方法
    }

    //dropzone的配置文件
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
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
        id: "#picupload",
        //上传的路径
        url: "/appcat/upload",
        //指的是上传到后台，用来获取这个上传文件的表单名
        paramName: "dropFile",
        init: function () {
            //这是当上传完成后回调这个函数
            this.on("success", function (file, data) {
                // $("#pic").val(data.fileName);
                $("#kitPic").val("http://localhost:8080"+data.data);
            });
        }
    };
    // 关闭 Dropzone 的自动发现功能
    Dropzone.autoDiscover = false;
    // 继承
    //$.extend(）jquery内部的函数，将后面的（opts）覆盖到前面的(defaultDropzoneOpts)
    $.extend(defaultDropzoneOpts, opts);
    //创建一个上传控件
    new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
</script>

<script type="text/javascript">
    function checkPhone(str){
        var re = /^1\d{10}$/;
        if(re.test(str)){
            return true;
        }else{
            return false;
        }
    };

    //富文本编辑器的初始化
   /* function initWangEditor1() {
        //加载wangEditor框架
        var E = window.wangEditor;
        //使用构造器创建一个editor，传入ID
        var editor = new E('#editor');
        // 上传图片业务处理地址
        editor.customConfig.uploadImgServer = '/appcat/upload';
        //上传图片的时候，用表单域的名称，参数名
        editor.customConfig.uploadFileName = 'dropFile';
        editor.create();
        $("#btnSubmit").bind("click", function() {
            //获取富文本编辑器中的数据
            var modeHtml = editor.txt.html();
            //将参数赋值给隐藏键，以便提交至数据库中存储
            $("#mode").val(modeHtml);
        });
    }*/

    /*function initWangEditor2() {
        //加载wangEditor框架
        var E = window.wangEditor;
        //同上创建第二个
        var editorPlay = new E('#editorPlay');
        editorPlay.customConfig.uploadImgServer = '/appcat/upload';
        editorPlay.customConfig.uploadFileName = 'dropFile';
        editorPlay.create();

        $("#btnSubmit").bind("click", function() {
            //获取富文本编辑器中的数据
            var playHtml = editor.txt.html();
            //将参数赋值给隐藏键，以便提交至数据库中存储
            $("#play").val(playHtml);
        });
    }*/
</script>


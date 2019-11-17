<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <%--<section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/plugin/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>--%>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>器械的信息</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="#"><i class="fa fa-circle-o"></i>器械列表</a></li>
                    <%--<li><a href="/user/form"><i class="fa fa-circle-o"></i> 用户编辑</a></li>--%>
                </ul>
            </li>

           <%-- <li class=" treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>分类信息</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>--%>
                </a>
                <ul class="treeview-menu">
                  <%--  <li ><a href="/category/list"><i class="fa fa-circle-o"></i> 分类列表</a></li>
                    <li ><a href="/category/treeTable"><i class="fa fa-circle-o"></i> 树表</a></li>
                    <li ><a href="/category/form"><i class="fa fa-circle-o"></i> 分类新增</a></li>
                    <li><a href="/content/list"><i class="fa fa-circle-o"></i> 内容列表</a></li>
                    <li><a href="/content/form"><i class="fa fa-circle-o"></i> 内容新增</a></li>--%>
                </ul>
            </li>

            <%--<li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>--%>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/plugins/adminLTE/dist/img/susu.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.userName}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主菜单</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>用户信息</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>

                <ul class="treeview-menu">
                    <li class="active"><a href="/member/list"><i class="fa fa-users"></i>用户列表</a></li>
                    <li><a href="/member/from"><i class="fa fa-user-plus"></i>新增用户</a></li>
                    <li><a href="/member/from"><i class="fa fa-edit"></i>用户编辑</a></li>
                </ul>
            </li>

            <li class=" treeview">
                <a href="#">
                    <i class="fa fa-comments-o"></i> <span>评论管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="#"><i class="fa fa-commenting-o"></i>评论列表</a></li>
                    <li><a href="#"><i class="fa fa-pencil"></i>新增评论</a></li>
                </ul>
            </li>

            <li class=" treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>会员期限</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="/deadline/list"><i class="fa fa-circle-o"></i>会员期限列表</a></li>
                </ul>
            </li>
            <li class=" treeview">
                <a href="#">
                    <i class="fa fa-money"></i> <span>缴费管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="/list"><i class="fa fa-circle-o"></i>缴费列表</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-steam"></i> <span>器材管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li ><a href="/appcat/list"><i class="fa fa-circle-o"></i> 器材分类列表</a></li>
                  <%--  <li ><a href="/category/treeTable"><i class="fa fa-circle-o"></i> 树表</a></li>--%>
                    <li ><a href="/appcat/form"><i class="fa fa-circle-o"></i> 器材分类新增</a></li>

                    <li><a href="/appliance/list"><i class="fa fa-circle-o"></i> 器材列表</a></li>
                    <li><a href="/appliance/form"><i class="fa fa-circle-o"></i> 新增器材</a></li>
                </ul>
            </li>
            <%--<li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>--%>
            <li class=" treeview">
                <a href="#">
                    <i class="fa  fa-newspaper-o"></i> <span>新闻管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="/newspush/list"><i class="fa  fa-reorder"></i>新闻列表</a></li>
                    <li><a href="/newspush/form"><i class="fa fa-paint-brush"></i> 新闻编辑</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="topbar-main">
  <div class="container">
    <!-- LOGO -->
    <div class="topbar-left">
      <a href="index.html" class="logo"> 
        <img alt="logo" src='<c:url value="/images/logo.jpg"/>' width="50"> 
        <span>
          TRƯỜNG ĐẠI HỌC KHOA HỌC TỰ NHIÊN - TRUNG TÂM TIN HỌC
        </span>
      </a>
    </div>
    <!-- End Logo container-->
    <div class="menu-extras">
      <ul class="nav navbar-nav pull-right">
        <li class="nav-item dropdown notification-list"><a class="nav-link dropdown-toggle arrow-none waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
          aria-haspopup="false" aria-expanded="false"> <img src="<c:url value='/images/de.jpg' />" alt="user " class="img-circle">
        </a>
          <div class="dropdown-menu dropdown-menu-right dropdown-arrow profile-dropdown " aria-labelledby="Preview">
            <!-- item-->
            <div class="dropdown-item noti-title">
              <h5 class="text-overflow">
                <small>Welcome ! ${pageContext.request.userPrincipal.name}</small>
              </h5>
            </div>
            <!-- item-->
            <a href="javascript:void(0);" class="dropdown-item notify-item"> <i class="zmdi zmdi-account-circle"></i> <span>Profile</span>
            </a>
            <!-- item-->
            <a href="javascript:void(0);" class="dropdown-item notify-item"> <i class="zmdi zmdi-settings"></i> <span>Settings</span>
            </a>
            <!-- item-->
            <a href="javascript:void(0);" class="dropdown-item notify-item"> <i class="zmdi zmdi-lock-open"></i> <span>Lock Screen</span>
            </a>
            <!-- item-->
            <form class="form-group" action="<c:url value="/logout.html" />" method="post">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            	   <button class="dropdown-item notify-item" type="submit"><i class="zmdi zmdi-power"></i> Logout</button>
            </form>          
          </div></li>
      </ul>
    </div>
    <!-- end menu-extras -->
    <div class="clearfix"></div>

  </div>
  <!-- end container -->
</div>
<!-- end topbar-main -->

<div class="navbar-custom">
  <div class="container">
    <div id="navigation">
      <!-- Navigation Menu-->
      <ul class="navigation-menu">
        <li><a href="index.html"><i class="zmdi zmdi-view-dashboard"></i> <span> Dashboard </span> </a></li>
        <li class="has-submenu"><a href="#"><i class="zmdi zmdi-album"></i> <span> Quản lý danh mục </span> </a>
          <ul class="submenu">
            <li><a href="icons-materialdesign.html">Danh sách người dùng</a></li>
            <li><a href="icons-ionicons.html">Danh sách nhân viên</a></li>
            <li><a href="icons-fontawesome.html">Danh sách dự án</a></li>
            <li><a href="${pageContext.request.contextPath}/sample/list.html">Danh sách phòng ban</a></li>
          </ul></li>
      </ul>
      <!-- End navigation menu  -->
    </div>
  </div>
</div>
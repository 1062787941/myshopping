<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网上购物系统管理中心</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="${pageContext.request.contextPath }/css/admin/main.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/css/public.css" rel="stylesheet" type="text/css" />
  	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    
  </head>

  <body>
  	<div id="admin_msg">${msg }<div>
    <form method="post" action="${pageContext.request.contextPath }/admin/adminLogin.action" target="_parent" name='theForm' id="adminFrom" onsubmit="return validate()">
        <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
            <tr>
                <td style="padding-left: 50px">
                    <table>
                        <tr>
                            <td>管理员姓名：</td>
                            <td>
                                <input type="text" name="username" />
                            </td>
                        </tr>
                        <tr>
                            <td>管理员密码：</td>
                            <td>
                                 <input type="password" name="password" />
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td><td><input type="submit" value="进入管理中心" class="button" /></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <input type="hidden" name="act" value="signin" />
    </form>
    
    <script>
    
    </script>
  </body>
</html>

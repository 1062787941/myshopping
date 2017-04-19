<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>网上购物系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

  <body>
    <form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent" name='theForm' onsubmit="return validate()">
    <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
    <tr>
    <td style="padding-left: 50px">
    <table>
    <tr>
    <td>管理员姓名：</td>
    <td>
        <input type="text" name="username" /></td>
    </tr>
    <tr>
    <td>管理员密码：</td>
    <td><input type="password" name="password" /></td>
    </tr>
    <tr><td>&nbsp;</td><td><input type="submit" value="进入管理中心" class="button" /></td></tr>
    </table>
    </td>
    </tr>
    </table>
    <input type="hidden" name="act" value="signin" />
    </form>
    <script language="JavaScript">
    <!--
    document.forms['theForm'].elements['username'].focus();

    /**
    * 检查表单输入的内容
    */
    function validate()
    {
    var validator = new Validator('theForm');
    validator.required('username', user_name_empty);
    //validator.required('password', password_empty);
    if (document.forms['theForm'].elements['captcha'])
    {
    validator.required('captcha', captcha_empty);
    }
    return validator.passed();
    }

    //-->
    </script>
  </body>
</html>

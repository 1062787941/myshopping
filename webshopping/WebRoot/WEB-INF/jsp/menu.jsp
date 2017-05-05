<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		<c:choose>
  		 <c:when test="${null == session_user}">
  		 	<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/user/login.jsp">登录
				</a>|
			</li>
			<li id="headerRegister" class="headerRegister" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/user/regist.jsp">注册</a>
			</li>
  		 </c:when>
  		 <c:otherwise>
  		 	<li id="headerLogin" class="headerLogin" style="display: list-item;">
					${session_user.name}
					|</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
				|</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${ pageContext.request.contextPath }/user/quit.action">退出</a>|
				</li>
  		 </c:otherwise>
	</c:choose>
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index.action">首页</a> |</li>
		
		<!-- 显示一级目录导航条 -->
		<c:forEach var="category" items="${categoryList}" begin="0" end="6">
			<li>
				<a href="${pageContext.request.contextPath }/product/findByCid.action?cid=${category.cid}&page=1">
					${category.cname}
				</a>  |
			</li>
		</c:forEach>
	</ul>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<img src="${pageContext.request.contextPath}/image/title.png" alt="网上商城" />
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>

		<%@ include file="../menu.jsp"%>

	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
			<!-- 左侧的以及目录二级 -->
				<c:forEach var="c" items="${categoryList }">
					<dl>
						<dt>
							<a
								href="${pageContext.request.contextPath}/product/findByCid.action?cid=${c.cid }&page=1">
									${c.cname }
							</a>
						</dt>
							<c:forEach var="cs" items="${c.categorySeconds}">
								<dd>
									<a
										href="${ pageContext.request.contextPath }
											/product/findByCsid.action?csid=${cs.csid}&page=1">
											${cs.csname}
									</a>
								</dd>
							</c:forEach>
						</dl>
				</c:forEach>
			</div>
		</div>
		
		
		<div class="span18 last">

			<form id="productForm" action="" method="get">
				<div id="result" class="result table clearfix">
					<ul>
					<!-- 显示商品图片 -->
						<c:forEach var="p" items="${pageBeanByCid.list}">
							<li>
								<a
									href="${ pageContext.request.contextPath }/product/findByPid.action?pid=${p.pid }">
									<img
										src="${pageContext.request.contextPath}/${p.image}"
										width="170" height="170" style="display: inline-block;" />

										<span style='color:green'>${p.pname}
									</span> 
									<span class="price">
										 商城价： ￥${ p.shop_price}
									</span>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				
				<!-- 页数 -->
				<div class="pagination">
					<span>第${pageBeanByCid.page }/${ pageBeanByCid.totalPage}页</span>
					<c:if test="${cid != null}">
						 <c:if test="${pageBeanByCid.page != 1}">
							<a class="firstPage"
								href="${ pageContext.request.contextPath }
								/product/findByCid.action?cid=${cid }&page=1" >
								&nbsp;
							</a>
							<a class="previousPage"
								href="${ pageContext.request.contextPath }
								/product/findByCid.action?cid=${cid }&page=${pageBeanByCid.page-1}">
								&nbsp;
							</a>
						</c:if>
						
						<!-- 点击一级显示页数 1 2 3 4 -->
						<c:forEach var="i" begin="1" end="${ pageBeanByCid.totalPage}">
							<c:choose>
							   <c:when test="${pageBeanByCid.page != i}">
							   		<a
										href="${ pageContext.request.contextPath }
											/product/findByCid.action?cid=${cid }&page=${i}">${i}
									</a>
							   </c:when>
							   <c:otherwise>
							   		<span class="currentPage">${i}</span>
							   </c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pageBeanByCid.page != pageBeanByCid.totalPage}">
								<a class="nextPage"
									href="${ pageContext.request.contextPath }
										/product/findByCid.action?cid=${ cid}&page=${ pageBeanByCid.page+1}"> 
										&nbsp;
								</a>
								<a class="lastPage"
									href="${ pageContext.request.contextPath }/product/
										findByCid.action?cid=${cid }&page=${ pageBeanByCid.totalPage}">
										&nbsp;
								</a>
						</c:if>
					</c:if>
					
					<!-- 二级目录的展示 -->
					<c:if test="${csid != null }">
					
						<!-- 上一页 首页 -->
						<c:if test="${pageBeanByCid.page != 1}">
							<a
								href="${ pageContext.request.contextPath }
									/product/findByCsid.action?csid=${csid }&page=1"
								class="firstPage">&nbsp;</a>
							<a
								href="${ pageContext.request.contextPath }
								/product/findByCsid.action?csid=${csid }&page=${pageBeanByCid.page-1 }"
								class="previousPage">&nbsp;
							</a>
						</c:if>
						
						<!-- 点击二级显示页数 1 2 3 4 -->
						<c:forEach var="i" begin="1" end="${pageBeanByCid.totalPage}">
							<c:choose>
								<c:when test="${pageBeanByCid.page != i }">
									<a href="${ pageContext.request.contextPath }
										/product/findByCsid.action?csid=${csid }&page=${i}">${i }>
									</a>
								</c:when>
								<c:otherwise>
									<span class="currentPage">${i}</span>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pageBeanByCid.page != pageBeanByCid.totalPage}">
							<a class="nextPage"
								href="${ pageContext.request.contextPath }
									/product/findByCsid.action?csid=${csid}&page=${ pageBeanByCid.page+1}"> 
									&nbsp;
							</a>
							<a class="lastPage"
								href="${ pageContext.request.contextPath }/product/
									findByCsid.action?csid=${csid }&page=${ pageBeanByCid.totalPage}">
									&nbsp;
							</a>
						</c:if>
						
					</c:if>
					
				<%-- 	<s:if test="csid != null">
					

						

						<s:if test="pageBean.page != pageBean.totalPage">
							<a class="nextPage"
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
							<a class="lastPage"
								href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
						</s:if>
					</s:if> --%>
					
				</div>
			</form>
		</div>
	</div>
	
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>诚聘英才</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>官网</a> |</li>
				<li><a>论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>
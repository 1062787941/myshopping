<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>显示KaptchaServlet生成的验证码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        //点击切换验证码
        function changeVerifyCode(){
            $("#yzmImg").attr("src","Kaptcha.jpg?"+Math.floor(Math.random()*100));
        }
        
        //提交
        function doSubmit() {
            var verifyCodeValue = $("#verifyCode").val();
            if(verifyCodeValue.replace(/\s/g,"") == "") {
                alert("请输入验证码");
            }else {
                //提交前先异步检查验证码是否输入正确
                var verifyUrl = "${pageContext.request.contextPath}/servlet/VerifyServlet?verifyCode="+verifyCodeValue;
                $.ajax({
                    type:"GET",
                    url:verifyUrl,
                    success:function(returnData){
                        if(returnData!="Y") {
                            alert("请输入正确的验证码！");
                        }else {
                            //验证码正确，进行提交操作
                            alert("验证码输入正确，提交表单");
                        }
                    },
                    error:function(e){
                        alert(e);
                    }
                });
            }
        }
    </script>
  </head>
  
  <body>
       <form>
        <table>
            <tr>
                <td>    
                        请输入验证码：
                </td>
                <td>
                    <input type="text" name="verifyCode" id="verifyCode">
                    <img src="${pageContext.request.contextPath}/Kaptcha.jpg" onclick="changeVerifyCode()" id="yzmImg" style="cursor: pointer;">
                    <a href="javascript:void(0)" onclick="changeVerifyCode()">看不清，换一张</a>
                </td>
            </tr>
            <tr>
                <td>    
                    &nbsp;
                </td>
                <td>
                    <input type="button" value="提交" onclick="doSubmit()">
                </td>
            </tr>
        </table>
    </form>    
  </body>
</html>
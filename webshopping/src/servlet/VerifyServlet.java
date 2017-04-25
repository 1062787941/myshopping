package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charaset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = null;
        try {
            //响应数据
            String resultData;
            //获取传过来的验证码
            String verifyCode = request.getParameter("verifyCode");
            System.out.println("verifyCode----"+verifyCode);
            if(verifyCode=="") {
                resultData = "N";
            }else {
                //获取kaptcha生成存放在session中的验证码
                String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                //比较输入的验证码和实际生成的验证码是否相同
                if(kaptchaValue == null || kaptchaValue == ""||!verifyCode.equalsIgnoreCase(kaptchaValue)) {
                    resultData = "N";
                }else {
                    resultData = "Y";
                }
            }
            out = response.getWriter();
            out.write(resultData);
            out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(out != null) {
                out.close();
            }
        }
    }
}
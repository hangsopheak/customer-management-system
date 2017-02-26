package com.rupp.sopheak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
    
    // Analyze the servlet exception       
    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
    
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
    
    if (servletName == null){
       servletName = "Unknown";
    }
    String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
    if (requestUri == null){
       requestUri = "Unknown";
    }

    // Set response content type
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    String title = "Error/Exception Information";
    out.println(
      "<html>\n" +
      "<head><title>" + title + "</title></head>\n" +
      "<body bgcolor=\"#f0f0f0\">\n");

    if (throwable == null && statusCode == null){
       out.println("<h2>Error information is missing</h2>");
       out.println("Please return to the <a href=\"" + 
         response.encodeURL("http://localhost:8080/servlet") + 
         "\">Home Page</a>.");
    } else if(statusCode != 500){
        out.write("<h3>Error Details</h3>");
        out.write("<strong>Status Code</strong>:"+statusCode+"<br>");
        out.write("<strong>Requested URI</strong>:"+requestUri);
    
    } else {
        out.println("<h2>The status code : " + statusCode + "</h2>");
       out.println("<h2>Error information</h2>");
       out.println("Servlet Name : " + servletName + "</br></br>");
       out.println("Exception Type : " + throwable.getClass( ).getName( ) + "</br></br>");
       out.println("The request URI: " + requestUri + "<br><br>");
       out.println("The exception message: " +  throwable.getMessage( ));
    }
    out.write("<br><br>");
    out.write("<a href=\"index.jsp\">Home Page</a>");
    out.write("</body></html>");
    
    out.println("</body>");
    out.println("</html>");

}
}

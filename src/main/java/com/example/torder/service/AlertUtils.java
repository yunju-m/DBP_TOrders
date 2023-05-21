package com.example.torder.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class AlertUtils {
    // 컨트롤 --> 경고창 띄우기 위해 사용
    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
    }

    public static void alert(HttpServletResponse response) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        // out.println("<script>alert('" + alertText + "');</script> ");
        out.flush();
    }

    public static void alertAndMovePage(HttpServletResponse response, String nextPage)
            throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("location.href='" + nextPage + "';</script> ");
        out.flush();
    }

    public static void alertAndBackPage(HttpServletResponse response) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        // out.println("<script>alert('" + alertText + "'); history.go(-1);</script>");
        out.println("<script>history.go(-1);</script>");
        out.flush();
    }
}

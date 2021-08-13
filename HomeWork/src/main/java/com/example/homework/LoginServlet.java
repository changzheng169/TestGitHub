package com.example.homework;
/*
 sql脚本:
 drop table if exists t_usr;
 create table t_user(
        userNo     int primary key auto_increment,
        username  varchar(255),
        password  varchar(255)
 );
 insert into t_user(username,password) values('李刚','123456');
 insert into t_user(username,password) values('王明','987654');
 insert into t_user(username,password) values('李辉','753951');
 */

import org.json.JSONObject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        boolean flag = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
            PrintWriter writer = response.getWriter();
            if (flag ==true) {
                writer.write("登陆成功！");
                writer.write("返回数据库中原本信息：");
                JSONObject jsonObject=resultSetToJson(rs,username,password);
                String str=jsonObject.toString();
                writer.write(str);
            } else {
                writer.write("登陆失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
    public JSONObject resultSetToJson(ResultSet rs,String username,String password) throws SQLException {
        JSONObject jsonObject=new JSONObject();
        int userNo=rs.getInt("userNo");
        jsonObject.put("userNo",userNo);
        jsonObject.put("username",username);
        jsonObject.put("password",password);
        return jsonObject;
    }
}

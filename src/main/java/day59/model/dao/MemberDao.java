package day59.model.dao;

import day59.model.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class MemberDao {
    private Connection conn;
    public MemberDao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0109", "root", "1234");
        }
        catch (Exception e) {System.out.println(e);}
    }
    public boolean signup(MemberDto memberDto) {
        try {
            String sql = "insert into member (mid,mpwd,mname,mphone) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());
            int count = ps.executeUpdate();
            if (count == 1) {return true;}
        } catch (Exception e) { System.out.println(e);}
        return false;
    }

    public boolean login(String mid, String mpwd) {
        try {
            String sql = "select * from member where mid=? and mpwd=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,mid);
            ps.setString(2,mpwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {return true;}
        } catch (Exception e) {System.out.println(e);}
    return false;
    }
}

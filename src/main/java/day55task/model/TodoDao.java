package day55task.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDao {
    private Connection conn;
    private static TodoDao instance = new TodoDao();
    private TodoDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0102","root","1234");
        } catch (Exception e){ System.out.println(e);}
    };
    public static TodoDao getInstance(){return instance;}


    public boolean regist(TodoDto todoDto) {
        try {
            String sql = "insert into todo (content , status) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,todoDto.getContent());
            ps.setBoolean(2,todoDto.isStatus());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {System.out.println(e);}
        return false;
    }

    public ArrayList<TodoDto> print() {
        ArrayList<TodoDto> list = new ArrayList<TodoDto>();
        try {
            String sql = "select * from todo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TodoDto todoDto = new TodoDto(
                        rs.getInt("no"),
                        rs.getString("content"),
                        rs.getBoolean("status")
                );
                list.add(todoDto);
            }
        } catch (Exception e) {System.out.println(e);}
        return list;
    }

    public boolean update(int no) {
        try {
            String sql = "update todo set status = !status where no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,no);
            int count = ps.executeUpdate();
            if (count==1){return true;}
        } catch (Exception e) { System.out.println(e);}
        return false;
    }

    public boolean delete(int no) {
        try {
            String sql = "delete from todo where no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,no);
            int count = ps.executeUpdate();
            if (count == 1) {return true;}
        } catch (Exception e){ System.out.println(e);}
        return false;
    }
}

package day58task.student.model.dao;

import day58task.student.model.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class StudentDao {
    private Connection conn;
    private StudentDao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0107", "root", "1234");
        }
        catch (Exception e) {System.out.println(e);}
    }

    public boolean regist(StudentDto studentDto) {
        try{
            String sql = "insert into student (sname , skor , smath , seng) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,studentDto.getSname());
            ps.setInt(2,studentDto.getSkor());
            ps.setInt(3,studentDto.getSmath());
            ps.setInt(4,studentDto.getSeng());
            ps.executeUpdate();
            return true;
        } catch (Exception e) { System.out.println(e);}
        return false;
    }

    public ArrayList<StudentDto> printAll() {
        ArrayList<StudentDto> list = new ArrayList<>();
        try {
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                StudentDto studentDto = new StudentDto(
                        rs.getInt("sno"),
                        rs.getString("sname"),
                        rs.getInt("skor"),
                        rs.getInt("smath"),
                        rs.getInt("seng")
                );
                list.add(studentDto);
            }
        } catch (Exception e){ System.out.println(e);}
        return list;
    }

    public boolean update(StudentDto studentDto) {
        try {
            String sql = "update student set (skor , smath , seng) set (?,?,?) where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,studentDto.getSkor());
            ps.setInt(2,studentDto.getSmath());
            ps.setInt(3,studentDto.getSeng());
            ps.setInt(4,studentDto.getSno());
            ps.executeUpdate();
            return true;
        } catch (Exception e){ System.out.println(e);}
        return false;
    }

    public boolean delete(int sno) {
        try {
            String sql = "delete from student where sno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,sno);
            ps.executeUpdate();
            return true;
        } catch (Exception e) { System.out.println(e);}
        return false;
    }
}

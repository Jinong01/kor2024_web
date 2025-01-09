package day57task.model.Dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class StudentDao {
    private Connection conn;
    private StudentDao () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0102", "root", "1234");
        } catch (Exception e) {System.out.println(e);}
    };




}

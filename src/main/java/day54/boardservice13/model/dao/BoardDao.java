package day54.boardservice13.model.dao;

import day54.boardservice13.model.dto.BoardDto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
    private Connection conn;
    private static BoardDao instance = new BoardDao();
    private BoardDao(){
        // ======== DB 연동 ========
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0102","root","1234");
        } catch (Exception e){ System.out.println(e);}
    }
    public static BoardDao getInstance(){return instance;}

    // 1. 게시물 쓰기
    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board (btitle , bcontent, bwriter, bpwd) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBtitle());
            ps.setString(2, boardDto.getBcontent());
            ps.setString(3, boardDto.getBwriter());
            ps.setString(4, boardDto.getBpwd());
            ps.executeUpdate();
            return true;
        }
        catch (Exception e){ System.out.println(e); return false;}
    }

    // 2. 게시물 전체 조회
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BoardDto boardDto = new BoardDto(
                        rs.getInt("bno"),
                        rs.getString("btitle"),
                        rs.getString("bcontent"),
                        rs.getString("bdate"),
                        rs.getString("bwriter"),
                        null);
                list.add(boardDto);
            }
        } catch (Exception e){ System.out.println(e);}
        return list;
    }

    // 3. 게시물 개별 조회
    public BoardDto findId(int bno) {
        BoardDto boardDto = new BoardDto();
        try{
            String sql = "select * from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        boardDto.setBno(rs.getInt("bno"));
                        boardDto.setBtitle(rs.getString("btitle"));
                        boardDto.setBcontent(rs.getString("bcontent"));
                        boardDto.setBdate(rs.getString("bdate"));
                        boardDto.setBwriter(rs.getString("bwriter"));
                        boardDto.setBpwd(null);
                    }
        } catch (Exception e){ System.out.println(e);}
        return boardDto;
    }

    // 4. 게시물 수정
    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set btitle = ? , bcontent = ?  where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBtitle());
            ps.setString(2, boardDto.getBcontent());
            ps.setInt(3,boardDto.getBno());
            ps.executeUpdate();
            return true;
        } catch (Exception e){ System.out.println(e); return  false;}
    }

    // 5. 게시물 삭제
    public boolean delete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ps.executeUpdate();
            return true;
        } catch (Exception e) { System.out.println(e); return false;}
    }
}

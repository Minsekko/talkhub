package org.innovibe.talkhub.model.dao;

import org.innovibe.talkhub.model.vo.User;
import org.innovibe.talkhub.util.ConnectionFactory;

import java.sql.*;

/*
       user 테이블에 관련된 DB 작업을 처리하게 될거임.
 */
public class UserDAO {
    //1. 데이터 등록
    //insert into users values (?, ?, ?, ?, ?, now());
    public boolean create(String id, String password, String nickname, String gender, int birth) {
        boolean result = false;
        try {
            Connection conn = ConnectionFactory.open();
            PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?,now())");

            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println("UserDao.creat:" + e.toString());
        }
        return result;
    }

    //id로 유저정보 찾기
    // select* from user where id=?
    public User findById(String specficId) {
        User one = null;

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from users where id=?");
            ps.setString(1, specficId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  //rs.next 수행결과가 true 이면 아래 구문 수행
                one = new User();
                one.setId(rs.getString("id"));
                one.setPassword(rs.getString("password"));
                one.setNickname(rs.getString("nickname"));
                one.setGender(rs.getString("gender"));
                one.setBirth(rs.getInt("birth"));
                one.setCreateAt(rs.getDate("created_at"));
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("UserDAO.findByID" + e.toString());
        }

        return one;
    }

    public User findBynickname(String specficnickname) {
        User one = null;

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from users where nickname=?");
            ps.setString(1, specficnickname);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  //rs.next 수행결과가 true 이면 아래 구문 수행
                one = new User();
                one.setId(rs.getString("id"));
                one.setPassword(rs.getString("password"));
                one.setNickname(rs.getString("nickname"));
                one.setGender(rs.getString("gender"));
                one.setBirth(rs.getInt("birth"));
                one.setCreateAt(rs.getDate("created_at"));
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("UserDAO.findByNickname" + e.toString());
        }

        return one;
    }
}

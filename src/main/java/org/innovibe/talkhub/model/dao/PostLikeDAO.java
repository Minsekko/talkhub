package org.innovibe.talkhub.model.dao;

import org.innovibe.talkhub.model.vo.PostLike;
import org.innovibe.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostLikeDAO {
    public boolean create(PostLike one) {
        boolean result = false;
        try (Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("insert into post_likes values(null,?,?,now())");
            ps.setString(1, one.getUserId());
            ps.setInt(2, one.getPostId());

            int r = ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println("PostLikeDAO.create" + e.toString());
        }
        return result;
    }

    public List<PostLike> findByUserId(String userId) {
        List<PostLike> PostLikeList = new ArrayList<>();

        try (Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("select * from post_likes where user_id =? order by create_at desc");
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostLike one = new PostLike();
                one.setPostId(rs.getInt("post_id"));
                one.setUserId(rs.getString("user_id"));
                one.setCreateAt(rs.getDate("create_at"));
                one.setId(rs.getInt("id"));
                PostLikeList.add(one);
            }
        } catch (Exception e) {
            System.out.println("errorfindByUserId" + e);
        }
        return PostLikeList;
    }

}

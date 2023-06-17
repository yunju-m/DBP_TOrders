package com.example.torder.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.example.torder.controller.MatchingForm;
import com.example.torder.domain.Content;

public class JdbcContentRepository implements ContentRepository {
    private final DataSource dataSource;

    public JdbcContentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /* 받은 category_id 이용해서 게시글 정보 가져오기 */
    @Override
    public Content getContentInfo(MatchingForm matchingForm) {
        String sql = "select * from contents where PK_content_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println(Integer.valueOf(matchingForm.getContentid()).getClass().getName());
            pstmt.setInt(1, Integer.valueOf(matchingForm.getContentid()));
            rs = pstmt.executeQuery();
            Content content = new Content();
            if (rs.next()) {
                content.setPK_content_id(rs.getInt("PK_content_id"));
                content.setCategory_id(rs.getInt("category_id"));
                content.setTitle(rs.getString("title"));
                content.setBody(rs.getString("body"));
                content.setLocation(rs.getString("location"));
                content.setEnd_time(rs.getString("end_time"));
                content.setContent_state(rs.getBoolean("content_state"));
                System.out.println(rs.getInt("PK_content_id"));
                System.out.println(rs.getString("title"));
                System.out.println("나는 게시글 저장 jdbc이당!!!");
            }
            return content;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}

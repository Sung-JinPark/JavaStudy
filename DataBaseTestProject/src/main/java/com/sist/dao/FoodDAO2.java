package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.vo.FoodVO;
import oracle.jdbc.OracleTypes;

public class FoodDAO2 {
    private Connection conn;
    private CallableStatement cs;
    private static FoodDAO2 dao;
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public FoodDAO2() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static FoodDAO2 newInstance() {
        if (dao == null) dao = new FoodDAO2();
        return dao;
    }

    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, "hr", "happy");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void disConnection() {
        try {
            if (cs != null) cs.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 리스트
    public List<FoodVO> foodListData(int page) {
        List<FoodVO> list = new ArrayList<>();
        try {
            getConnection();
            String sql = "{CALL foodListData(?,?,?)}";
            cs = conn.prepareCall(sql);

            int rowSize = 12;
            int start = (rowSize * page) - (rowSize - 1);
            int end = rowSize * page;

            cs.setInt(1, start);
            cs.setInt(2, end);
            cs.registerOutParameter(3, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(3);
            while (rs.next()) {
                FoodVO vo = new FoodVO();
                vo.setFno(rs.getInt("fno"));
                vo.setName(rs.getString("name"));
                vo.setPoster(rs.getString("poster"));
                list.add(vo);
            }
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
        return list;
    }

    // 총 페이지
    public int foodTotalPage() {
        int total = 0;
        try {
            getConnection();
            String sql = "{CALL foodTotalPage(?)}";
            cs = conn.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();
            total = cs.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
        return total;
    }

    // 상세보기
    public FoodVO foodDetailData(int fno) {
        FoodVO vo = new FoodVO();
        try {
            getConnection();
            String sql = "{CALL foodDetailData(?,?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, fno);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);
            if (rs.next()) {
                vo.setFno(rs.getInt("fno"));
                vo.setName(rs.getString("name"));
                vo.setPoster(rs.getString("poster"));
                vo.setScore(rs.getDouble("score"));
                vo.setAddress(rs.getString("address"));
                vo.setPhone(rs.getString("phone"));
                vo.setType(rs.getString("type"));
                vo.setTime(rs.getString("time"));
                vo.setParking(rs.getString("parking"));
                vo.setPrice(rs.getString("price"));
                vo.setTheme(rs.getString("theme"));
                vo.setContent(rs.getString("content"));
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
        return vo;
    }
}

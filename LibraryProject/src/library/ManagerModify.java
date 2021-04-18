package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerModify {
    public static List<Manager> findAll(){
        List<Manager> nhanvienInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from nhan_vien";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Manager std = new Manager(resultSet.getString("ma_nhan_vien"), resultSet.getString("ho_ten"), resultSet.getString("gioi_tinh"), resultSet.getString("so_dien_thoai"), resultSet.getString("email"), resultSet.getString("mat_khau"));
                nhanvienInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return nhanvienInfoList;
    }
    public static void update(Manager nhanvienlogin){
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "update nhan_vien set ho_ten = ?,so_dien_thoai = ?,email = ?,mat_khau = ? where ma_nhan_vien = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,nhanvienlogin.getHo_ten());
            statement.setString(2,nhanvienlogin.getSo_dien_thoai());
            statement.setString(3,nhanvienlogin.getEmail());
            statement.setString(4,nhanvienlogin.getMat_khau());
            statement.setString(5,nhanvienlogin.getMa_nhan_vien());
            
            statement.execute();
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}


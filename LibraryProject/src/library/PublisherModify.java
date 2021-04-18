package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherModify {
    public static List<Publisher> findAll(){
        List<Publisher> nxbInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from nha_xuat_ban";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Publisher std = new Publisher(resultSet.getString("ma_nxb"), resultSet.getString("ten_nxb"), resultSet.getString("dia_chi"), resultSet.getString("email"), resultSet.getString("website"));
                nxbInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return nxbInfoList;
    }
}

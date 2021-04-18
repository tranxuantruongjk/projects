package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryModify {
    public static List<Category> findAll(){
        List<Category> theloaiInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from the_loai";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Category std = new Category(resultSet.getString("ma_the_loai"), resultSet.getString("ten_the_loai"));
                theloaiInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return theloaiInfoList;
    }
}

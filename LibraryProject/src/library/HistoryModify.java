package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryModify {

    public static List<HistoryInfo> findAll(){
        Connection conn;
        Statement statement;
        List<HistoryInfo> historyInfoList = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from muon_tra";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                HistoryInfo std = new HistoryInfo(resultSet.getString("ma_sach"), resultSet.getString("mssv"), resultSet.getString("ngay_muon"), resultSet.getString("han_tra"));
                historyInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return historyInfoList;
    }

    public static List<HistoryInfo> historyStudent(Student studentlogin){
        List<HistoryInfo> historyInfoList = new ArrayList<>();
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from muon_tra where mssv = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,studentlogin.getMssv());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                HistoryInfo std = new HistoryInfo(resultSet.getString("ma_sach"), resultSet.getString("mssv"), resultSet.getString("ngay_muon") ,resultSet.getString("han_tra"));
                historyInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return historyInfoList;
    }
    public static void insertHistory(String ma_sach,String mssv){
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "insert into muon_tra(ma_sach,mssv) values (?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, ma_sach);
            statement.setString(2,mssv);
            statement.execute();
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static void deleteHistory(String ma_sach,String mssv){
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "delete from muon_tra where ma_sach = ? and mssv = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, ma_sach);
            statement.setString(2,mssv);
            statement.execute();
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static List<HistoryInfo> quaHan(){
        List<HistoryInfo> historyInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from muon_tra where han_tra<= current_date ";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                HistoryInfo std = new HistoryInfo(resultSet.getString("ma_sach"), resultSet.getString("mssv"), resultSet.getString("ngay_muon"), resultSet.getString("han_tra"));
                historyInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return historyInfoList;
    }
    public static List<HistoryInfo> historyFind(String ma_sach,String mssv){
        List<HistoryInfo> historyInfoList = new ArrayList<>();
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from muon_tra where ma_sach LIKE ? and mssv LIKE ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,"%"+ma_sach+"%");
            statement.setString(2,"%"+mssv+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                HistoryInfo std = new HistoryInfo(resultSet.getString("ma_sach"), resultSet.getString("mssv"), resultSet.getString("ngay_muon") ,resultSet.getString("han_tra"));
                historyInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return historyInfoList;
    }
}


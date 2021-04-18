package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookModify {
    public static List<Book> findAll(){
        List<Book> bookInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from sach";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Book std = new Book(resultSet.getString("ma_sach"), resultSet.getString("ten_sach"), resultSet.getString("ma_the_loai"), resultSet.getString("ma_nxb"), resultSet.getString("tac_gia"), resultSet.getString("nam_xb"),resultSet.getInt("gia_dat"), resultSet.getInt("so_luong") );
                bookInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bookInfoList;
    }
    public static List<Book> findBook(String ten_sach,String ten_the_loai,String tu_nam,String den_nam){
        List<Book> bookInfoList = new ArrayList<>();
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select sach.* from sach,the_loai where sach.ma_the_loai = the_loai.ma_the_loai and lower(sach.ten_sach) LIKE lower(?) and lower(the_loai.ten_the_loai) LIKE lower(?) and sach.nam_xb between ? and ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,"%"+ten_sach+"%");
            statement.setString(2,"%"+ten_the_loai+"%");
            statement.setString(3,tu_nam);
            statement.setString(4,den_nam);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Book std = new Book(resultSet.getString("ma_sach"), resultSet.getString("ten_sach"), resultSet.getString("ma_the_loai"), resultSet.getString("ma_nxb"), resultSet.getString("tac_gia"), resultSet.getString("nam_xb"),resultSet.getInt("gia_dat"), resultSet.getInt("so_luong") );
                bookInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bookInfoList;
    }
    public static List<Book> findMyBook(Manager nhanvienlogin){
        List<Book> bookInfoList = new ArrayList<>();
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select sach.* from sach,nhan_vien,quan_ly where sach.ma_the_loai = quan_ly.ma_the_loai and quan_ly.ma_nhan_vien = nhan_vien.ma_nhan_vien and nhan_vien.ma_nhan_vien = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,nhanvienlogin.getMa_nhan_vien());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Book std = new Book(resultSet.getString("ma_sach"), resultSet.getString("ten_sach"), resultSet.getString("ma_the_loai"), resultSet.getString("ma_nxb"), resultSet.getString("tac_gia"), resultSet.getString("nam_xb"),resultSet.getInt("gia_dat"), resultSet.getInt("so_luong") );
                bookInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return bookInfoList;
    }
    public static void update(Book bookInfo)
    {
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "update sach set ten_sach = ?,ma_the_loai = ?,ma_nxb = ?,tac_gia = ?,nam_xb = ?,gia_dat = ?,so_luong = ? where ma_sach = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,bookInfo.getTen_sach());
            statement.setString(2,bookInfo.getMa_the_loai());
            statement.setString(3,bookInfo.getMa_nxb());
            statement.setString(4,bookInfo.getTac_gia());
            statement.setString(5,bookInfo.getNam_xb());
            statement.setInt(6,bookInfo.getGia_dat());
            statement.setInt(7,bookInfo.getSo_luong());
            statement.setString(8,bookInfo.getMa_sach());

            statement.execute();
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

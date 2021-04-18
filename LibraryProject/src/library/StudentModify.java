package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModify {
    public static List<Student> findAll(){
        List<Student> studentInfoList = new ArrayList<>();
        Connection conn;
        Statement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "select * from sinh_vien";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Student std = new Student(resultSet.getString("mssv"), resultSet.getString("ho_ten"), resultSet.getString("khoa"), resultSet.getString("lop"), resultSet.getString("email_sis"), resultSet.getString("mat_khau") );
                studentInfoList.add(std);
            }
        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return studentInfoList;
    }
    public static void update(Student std){
        Connection conn;
        PreparedStatement statement;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/librarydb","postgres","admin");
            String sql = "update sinh_vien set ho_ten = ?,khoa = ?,lop = ?,email_sis = ?,mat_khau = ? where mssv = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,std.getHo_ten());
            statement.setString(2,std.getKhoa());
            statement.setString(3,std.getLop());
            statement.setString(4,std.getEmail_sis());
            statement.setString(5,std.getMat_khau());
            statement.setString(6,std.getMssv());

            statement.execute();

        }catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

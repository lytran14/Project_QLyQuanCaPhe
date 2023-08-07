
package CLass_DAO;

import Class_DBHelder.DBHelder_SQL;
import Class_Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVien_DAO {
    //lay dư lieu
    public static List<NhanVien> getAllStudents() {
        List<NhanVien> list = new ArrayList<>();
        try {
            String sql = "select * from NhanVien";
            Connection con = DBHelder_SQL.getDbConnection();
            Statement st = con.createStatement();
            //st.executeQuery(sql);
            ResultSet re = st.executeQuery(sql);
            while (re.next()) {
                NhanVien nv = new NhanVien();
                 nv.setMaNV(re.getString("manv"));
                 nv.setTenNV(re.getString("tennv"));
                 nv.setSdt(re.getString("sdt"));
                 nv.setEmail(re.getString("email"));
                 nv.setSoGioLam(re.getInt("sogiolam"));
                 nv.setLuong(re.getDouble("luong"));
                
                list.add(nv);
            }con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //insert
    public static int insert(NhanVien nv) {
        int rs = 0;
        try {
            String sql = "insert into NhanVien values (?,?,?,?,?,?)";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nv.getMaNV() );
            stmt.setString(2,nv.getTenNV() );
            stmt.setString(3, nv.getSdt());
            stmt.setString(4, nv.getEmail());
            stmt.setInt(5, nv.getSoGioLam());
            stmt.setDouble(6, nv.getLuong());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //update
    public static int update(NhanVien nv) {
        int rs = 0;
        try {
            String sql = "update NhanVien set tenNV=?,sdt=?,Email=?,soGioLam=? where MaSV=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(6,nv.getMaNV() );
            stmt.setString(1,nv.getTenNV() );
            stmt.setString(2, nv.getSdt());
            stmt.setString(3, nv.getEmail());
            stmt.setInt(4, nv.getSoGioLam());
            stmt.setDouble(5, nv.getLuong());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //delete
    public static int Delete(NhanVien nv) {
        int rs = 0;
        try {
            String sql = "Delete from NhanVien where MaSV=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getMaNV());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}

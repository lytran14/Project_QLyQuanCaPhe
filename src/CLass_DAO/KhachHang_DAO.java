
package CLass_DAO;
import Class_DBHelder.DBHelder_SQL;
import Class_Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KhachHang_DAO {
    //lay dư lieu
    public static List<KhachHang> getAllStudents() {
        List<KhachHang> list = new ArrayList<>();
        try {
            String sql = "select * from KhachHang";
            Connection con = DBHelder_SQL.getDbConnection();
            Statement st = con.createStatement();
            //st.executeQuery(sql);
            ResultSet re = st.executeQuery(sql);
            while (re.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(re.getString("makh"));
                kh.setTenKH(re.getString("tenkh"));
                kh.setSdt(re.getString("sdt"));
                kh.setDiachi(re.getString("donvitinh"));
                kh.setDiemTichLuy(re.getInt("diemtichluy"));
                
                list.add(kh);
            }con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //insert
    public static int insert(KhachHang kh) {
        int rs = 0;
        try {
            String sql = "insert into KHACHHANG values (?,?,?,?,?)";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getSdt());
            stmt.setString(4, kh.getDiachi());
            stmt.setInt(4, kh.getDiemTichLuy());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //update
    public static int update(KhachHang kh) {
        int rs = 0;
        try {
            String sql = "update KHACHHANG set tenkh=?,sdt=?, diachi=?,diemtichluy=? where MaSV=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getSdt());
            stmt.setString(4, kh.getDiachi());
            stmt.setInt(4, kh.getDiemTichLuy());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //delete
    public static int delete(KhachHang kh) {
        int rs = 0;
        try {
            String sql = "delete from KhachHang where MaKH=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getSdt());
            stmt.setString(4, kh.getDiachi());
            stmt.setInt(4, kh.getDiemTichLuy());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}

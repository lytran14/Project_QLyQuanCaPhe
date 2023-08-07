
package CLass_DAO;
import Class_DBHelder.DBHelder_SQL;
import Class_Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HoaDon_DAO {
    //lay dư lieu
    public static List<HoaDon> getAllStudents() {
        List<HoaDon> list = new ArrayList<>();
        try {
            String sql = "select * from Students";
            Connection con = DBHelder_SQL.getDbConnection();
            Statement st = con.createStatement();
            //st.executeQuery(sql);
            ResultSet re = st.executeQuery(sql);
            while (re.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(re.getString("mahd"));
                hd.setTenDoUong(re.getString("tendouong"));
                hd.setTongTien(re.getDouble("tongtien"));
                hd.setMaKhachHang(re.getString("makh"));
                hd.setMaNhanVien(re.getString("manv"));
                hd.setGiamGia(re.getDouble("giamgia"));
                hd.setUuDai(re.getString("uudai"));
                list.add(hd);
            }con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

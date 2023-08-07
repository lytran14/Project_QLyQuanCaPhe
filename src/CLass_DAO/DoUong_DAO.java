
package CLass_DAO;

import Class_DBHelder.DBHelder_SQL;
import Class_Model.DoUong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoUong_DAO {
    //lay dư lieu
    public static List<DoUong> getAllStudents() {
        List<DoUong> list = new ArrayList<>();
        try {
            String sql = "select * from DoUong";
            Connection con = DBHelder_SQL.getDbConnection();
            Statement st = con.createStatement();
            //st.executeQuery(sql);
            ResultSet re = st.executeQuery(sql);
            while (re.next()) {
                DoUong doUong = new DoUong();
                doUong.setMaDoUong(re.getString("madouong"));
                doUong.setTenDoUong(re.getString("tendouong"));
                doUong.setGiaTien(re.getDouble("giatien"));
                doUong.setDonViTinh(re.getString("donvitinh"));
                
                list.add(doUong);
            }con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //insert
    public static int insert(DoUong doUong) {
        int rs = 0;
        try {
            String sql = "insert into DoUong values (?,?,?,?)";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, doUong.getMaDoUong());
            stmt.setString(2, doUong.getTenDoUong());
            stmt.setDouble(3, doUong.getGiaTien());
            stmt.setString(4, doUong.getDonViTinh());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //update
    public static int Update(DoUong doUong) {
        int rs = 0;
        try {
            String sql = "update DoUong set tenDoUong=?,giaTien=?,donViTinh=? where MaDoUong=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(4, doUong.getMaDoUong());
            stmt.setString(1, doUong.getTenDoUong());
            stmt.setDouble(2, doUong.getGiaTien());
            stmt.setString(3, doUong.getDonViTinh());
           
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //delete
    public static int Delete(DoUong doUong) {
        int rs = 0;
        try {
            String sql = "Delete from DoUong where MaDoUong=?";
            Connection con = DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, doUong.getMaDoUong());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}

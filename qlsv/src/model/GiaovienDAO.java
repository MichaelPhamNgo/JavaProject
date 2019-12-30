package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DBUtil;

public class GiaovienDAO {

	private Connection conn;
	private PreparedStatement stmt;

	public GiaovienDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addGiaoVien(Giaovien giaovien){
		String sql = "INSERT INTO project.giaovien (idgv, hoten, idmon, idkhoa,idlop,ngaysinh, gioitinh, email, sdt) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, giaovien.getIDgiaovien());
			stmt.setString(2, giaovien.getHoten());
			stmt.setString(3, giaovien.getIDmonday());
			stmt.setString(4, giaovien.getIDkhoa());
			stmt.setString(5, giaovien.getIDlop());
			stmt.setString(6, giaovien.getNgaysinh());
			stmt.setString(7, giaovien.getGioitinh());
			stmt.setString(8, giaovien.getEmail());
			stmt.setString(9, giaovien.getSdt());
			stmt.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ID này đã tồn tại !");
		}
	}
	public void editGiaoVien(Giaovien giaovien){
		String sql = "UPDATE project.giaovien SET idgv=?, hoten=?, idmon=?, idkhoa=?,idlop=?,ngaysinh=?, gioitinh=?, email=?, sdt=? WHERE idgv=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, giaovien.getIDgiaovien());
			stmt.setString(2, giaovien.getHoten());
			stmt.setString(3, giaovien.getIDmonday());
			stmt.setString(4, giaovien.getIDkhoa());
			stmt.setString(5, giaovien.getIDlop());
			stmt.setString(6, giaovien.getNgaysinh());
			stmt.setString(7, giaovien.getGioitinh());
			stmt.setString(8, giaovien.getEmail());
			stmt.setString(9, giaovien.getSdt());
			stmt.setString(10, giaovien.getIDgiaovien());
			stmt.executeUpdate();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}
	public void deleteGiaoVien(JTable table){
		boolean tich = false;
		Object[] options = { "Yes", "No" };
		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) // Confirm Delete = Yes
		{
			for (int i = 0; i < table.getRowCount(); i++) {
				Boolean chkDel = Boolean.valueOf(table.getValueAt(i, 0).toString()); // Checked
				if (chkDel) // Checked to Delete
				{
					// Delete Data
					String sql = "DELETE FROM project.giaovien  WHERE idgv = ?";
					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, table.getValueAt(i, 1).toString());
						stmt.executeUpdate();
						tich = true;
					} catch (Exception ed) {
						JOptionPane.showMessageDialog(null, "Không thể xóa giáo viên "
								+ table.getValueAt(i, 2).toString() + " vui lòng xem lại");
						tich = false;
					}
				}
			}
			if (tich) {
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
			}
		}
	}
}

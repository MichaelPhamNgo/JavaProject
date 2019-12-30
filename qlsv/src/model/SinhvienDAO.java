package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DBUtil;

public class SinhvienDAO {

	private Connection conn;
	private PreparedStatement stmt;

	public SinhvienDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addSinhVien(Sinhvien sinhvien){
		String sql = "INSERT INTO project.sinhvien (idsv, hoten, idlop, hedt, ngaysinh, diachi, gioitinh, sdt, idkhoa) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sinhvien.getIDsinhvien());
			stmt.setString(2, sinhvien.getHoten());
			stmt.setString(3, sinhvien.getIDlop());
			stmt.setString(4, sinhvien.getHedaotao());
			stmt.setString(5, sinhvien.getNgaysinh());
			stmt.setString(6, sinhvien.getDiachi());
			stmt.setString(7, sinhvien.getGioitinh());
			stmt.setString(8, sinhvien.getSdt());
			stmt.setString(9, sinhvien.getIDkhoa());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ID đã tồn tại !");
		}
	}
	public void editSinhVien(Sinhvien sinhvien){
		String sql = "UPDATE project.sinhvien SET idsv=?, hoten=?, idlop=?, hedt=?, ngaysinh=?, diachi=?, gioitinh=?, sdt=? , idkhoa=? WHERE idsv=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sinhvien.getIDsinhvien());
			stmt.setString(2, sinhvien.getHoten());
			stmt.setString(3, sinhvien.getIDlop());
			stmt.setString(4, sinhvien.getHedaotao());
			stmt.setString(5, sinhvien.getNgaysinh());
			stmt.setString(6, sinhvien.getDiachi());
			stmt.setString(7, sinhvien.getGioitinh());
			stmt.setString(8, sinhvien.getSdt());
			stmt.setString(9, sinhvien.getIDkhoa());
			stmt.setString(10, sinhvien.getIDsinhvien());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhập!");
		}
	}
	public void deleteSinhVien(JTable table){
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
					String sql = "DELETE FROM project.sinhvien  WHERE idsv = ?";
					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, table.getValueAt(i, 1).toString());
						stmt.executeUpdate();
						tich = true;
					} catch (Exception ed) {
						JOptionPane.showMessageDialog(null, "Không thể xóa id "
								+ table.getValueAt(i, 1).toString() + " vui lòng xem lại bảng điểm");
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

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DBUtil;

public class DiemDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private String IDsinhvien;
	private String IDmonhoc;

	public DiemDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDiem(Diem diem, String idsv, String idmon) {
		boolean test = false;
		//Check idsv va idmon voi database - Neu da co thi ID da ton tai - Neu chua co thi thuc thi cau lenh Insert them moi diem
		String sqlID = "SELECT * FROM project.diem";
		try {
			stmt = conn.prepareStatement(sqlID);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String plus = rs.getString("idsv") + rs.getString("idmon");
				if (plus.equals(idsv + idmon)) {
					test = true;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Có lỗi khi thêm điểm!\n" + e);
		}
		// Thuc thi Insert Them moi diem
		String sql = "INSERT INTO project.diem (idlop, mon, idmon, idsv, diem15, diem45, diemthi, tongket ,ketqua, idgv) VALUES (?,?,?,?, ?,?, ?,?, ?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, diem.getIDlop());
			stmt.setString(2, diem.getMonhoc());
			stmt.setString(3, diem.getIDMonhoc());
			stmt.setString(4, diem.getIDsinhvien());
			stmt.setFloat(5, diem.getDiem15());
			stmt.setFloat(6, diem.getDiem45());
			stmt.setFloat(7, diem.getDiemthi());
			stmt.setFloat(8, diem.getTongket());
			stmt.setString(9, diem.getKetqua());
			stmt.setString(10, diem.getIDgiaovien());
			//Check boolean dua ra ket luan cuoi cung
			if (test == true) {
				JOptionPane.showMessageDialog(null, "ID Sinh viên \nID Môn \nĐã tồn tại !");
			} else {
				stmt.executeUpdate();
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Một số trường bạn đang để trống\n Vui lòng xem lại!");
		}
	}

	public void editDiem(Diem diem) {
		String sql = "UPDATE project.diem SET idlop=?, mon=?, idmon=?, idsv=?, diem15=?, diem45=?,diemthi=?, tongket=?, ketqua=?, idgv=? WHERE idsv=? AND idmon=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, diem.getIDlop());
			stmt.setString(2, diem.getMonhoc());
			stmt.setString(3, diem.getIDMonhoc());
			stmt.setString(4, diem.getIDsinhvien());
			stmt.setFloat(5, diem.getDiem15());
			stmt.setFloat(6, diem.getDiem45());
			stmt.setFloat(7, diem.getDiemthi());
			stmt.setFloat(8, diem.getTongket());
			stmt.setString(9, diem.getKetqua());
			stmt.setString(10, diem.getIDgiaovien());

			stmt.setString(11, diem.getIDsinhvien());
			stmt.setString(12, diem.getIDMonhoc());
			stmt.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}

	public void deleteDiem(JTable table) {
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
					String sql = "DELETE FROM project.diem WHERE idmon=? AND idsv = ? ";
					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, table.getValueAt(i, 3).toString());
						stmt.setString(2, table.getValueAt(i, 2).toString());
						stmt.executeUpdate();
						tich = true;
					} catch (Exception ed) {
						JOptionPane.showMessageDialog(null,
								"Không thể xóa điểm ID " + table.getValueAt(i, 2).toString() + " vui lòng xem lại");
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

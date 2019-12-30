package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DBUtil;

public class LopDAO {

	private Connection conn;
	private PreparedStatement stmt;

	public LopDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addLop̣̣̣(Lop lop){
		String sql = "INSERT INTO project.lop (idlop, lop, idkhoa, khoahoc) VALUES (?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lop.getIDlop());
			stmt.setString(2, lop.getTenlop());
			stmt.setString(3, lop.getIDkhoa());
			stmt.setString(4, lop.getKhoahoc());
			stmt.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ID đã tồn tại !");
		}
	}
	public void editLop(Lop lop){
		String sql = "UPDATE project.lop SET idlop=?, lop=?, idkhoa=?, khoahoc=? WHERE idlop=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lop.getIDlop());
			stmt.setString(2, lop.getTenlop());
			stmt.setString(3, lop.getIDkhoa());
			stmt.setString(4, lop.getKhoahoc());
			stmt.setString(5, lop.getIDlop());
			stmt.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}
	public void deleteLop(JTable table){
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
					String sql = "DELETE FROM project.lop  WHERE idlop = ?";
					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, table.getValueAt(i, 1).toString());
						stmt.executeUpdate();
						tich = true;
					} catch (Exception ed) {
						JOptionPane.showMessageDialog(null, "Không thể xóa lớp "
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

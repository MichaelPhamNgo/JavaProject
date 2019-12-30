package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.DBUtil;

public class MonDAO {
	private Connection conn;
	private PreparedStatement stmt;

	public MonDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addMoṇ(Mon mon){
		String sql = "INSERT INTO project.mon (idmon, mon, tinchi, idkhoa) VALUES (?, ?, ?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mon.getIDmon());
			stmt.setString(2, mon.getTenmon());
			stmt.setString(3, mon.getTinchi());
			stmt.setString(4, mon.getIDkhoa());
			stmt.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ID đã tồn tại !");
		}
	}
	public void editMon(Mon mon){
		String sql = "UPDATE project.mon SET idmon=?, mon=?, tinchi=? , idkhoa=? WHERE idmon=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mon.getIDmon());
			stmt.setString(2, mon.getTenmon());
			stmt.setString(3, mon.getTinchi());
			stmt.setString(4, mon.getIDkhoa());
			stmt.setString(5, mon.getIDmon());
			stmt.executeUpdate();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}
	public void deleteMon(JTable table){
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
					String sql = "DELETE FROM project.mon  WHERE idmon = ?";
					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, table.getValueAt(i, 1).toString());
						stmt.executeUpdate();
						tich = true;
					} catch (Exception ed) {
						JOptionPane.showMessageDialog(null, "Không thể xóa môn "
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

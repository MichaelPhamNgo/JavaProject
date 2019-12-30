package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBUtil;
import program_from.DetailsForm;

public class DetailsDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public DetailsDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chiTiet(Details details,String idsinhvien, String idgv){
		String sql ="Select * From  project.sinhvien INNER JOIN project.diem ON diem.idsv = sinhvien.idsv INNER JOIN project.giaovien ON diem.idgv = giaovien.idgv INNER JOIN project.lop ON lop.idlop = sinhvien.idlop WHERE sinhvien.idsv=? AND giaovien.idgv=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idsinhvien);
			stmt.setString(2, idgv);
			rs = stmt.executeQuery();
			while(rs.next()){
				details.setIDsinhvien(rs.getString("sinhvien.idsv"));
				details.setHotensv(rs.getString("sinhvien.hoten"));
				details.setGioitinhsv(rs.getString("sinhvien.gioitinh"));
				details.setNgaysinhsv(rs.getString("sinhvien.ngaysinh"));
				details.setDiachisv(rs.getString("sinhvien.diachi"));
				details.setSdtsv(rs.getString("sinhvien.sdt"));
				details.setBac(rs.getString("sinhvien.hedt"));
				details.setKhoahoc(rs.getString("lop.khoahoc"));
							
				details.setIDgiaovien(rs.getString("giaovien.idgv"));
				details.setHotengv(rs.getString("giaovien.hoten"));
				details.setGioitinhgv(rs.getString("giaovien.gioitinh"));
				details.setNgaysinhgv(rs.getString("giaovien.ngaysinh"));
				details.setMonday(rs.getString("giaovien.idmon"));
				details.setSdtgv(rs.getString("giaovien.sdt"));
				details.setEmail(rs.getString("giaovien.email"));
			}
			 DetailsForm detailsdiem = new DetailsForm();
			 detailsdiem.frmChiTi.setVisible(true);
			 detailsdiem.actionDetails(details);
		} catch (Exception e) {
			System.out.println("Error detailsDAO : "+e);
		}
		
	}
}

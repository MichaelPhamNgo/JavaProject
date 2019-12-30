package model;

public class Giaovien {

	private String IDgiaovien;
	private String Hoten;
	private String IDmonday;
	private String IDkhoa;
	private String IDlop;
	private String Ngaysinh;
	private String Gioitinh;
	private String Email;
	private String Sdt;

	public String getIDgiaovien() {
		return IDgiaovien;
	}

	public void setIDgiaovien(String iDgiaovien) {
		IDgiaovien = iDgiaovien;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getIDmonday() {
		return IDmonday;
	}

	public void setIDmonday(String iDmonday) {
		IDmonday = iDmonday;
	}

	public String getIDkhoa() {
		return IDkhoa;
	}

	public void setIDkhoa(String iDkhoa) {
		IDkhoa = iDkhoa;
	}

	public String getIDlop() {
		return IDlop;
	}

	public void setIDlop(String iDlop) {
		IDlop = iDlop;
	}

	public String getNgaysinh() {
		return Ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		Ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return Gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public Giaovien(String iDgiaovien, String hoten, String iDmonday, String iDkhoa, String iDlop, String ngaysinh,
			String gioitinh, String email, String sdt) {
		super();
		IDgiaovien = iDgiaovien;
		Hoten = hoten;
		IDmonday = iDmonday;
		IDkhoa = iDkhoa;
		IDlop = iDlop;
		Ngaysinh = ngaysinh;
		Gioitinh = gioitinh;
		Email = email;
		Sdt = sdt;
	}

	public Giaovien() {
		super();
		// TODO Auto-generated constructor stub
	}

}

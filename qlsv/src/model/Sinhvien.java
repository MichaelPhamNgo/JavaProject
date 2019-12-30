package model;

public class Sinhvien {

	private String IDsinhvien;
	private String Hoten;
	private String IDlop;
	private String IDkhoa;
	private String Hedaotao;
	private String Ngaysinh;
	private String Diachi;
	private String Gioitinh;
	private String Sdt;

	public String getIDsinhvien() {
		return IDsinhvien;
	}

	public void setIDsinhvien(String iDsinhvien) {
		IDsinhvien = iDsinhvien;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getIDlop() {
		return IDlop;
	}

	public void setIDlop(String iDlop) {
		IDlop = iDlop;
	}

	public String getIDkhoa() {
		return IDkhoa;
	}

	public void setIDkhoa(String iDkhoa) {
		IDkhoa = iDkhoa;
	}

	public String getHedaotao() {
		return Hedaotao;
	}

	public void setHedaotao(String hedaotao) {
		Hedaotao = hedaotao;
	}

	public String getNgaysinh() {
		return Ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		Ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getGioitinh() {
		return Gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public Sinhvien(String iDsinhvien, String hoten, String iDlop, String iDkhoa, String hedaotao, String ngaysinh,
			String diachi, String gioitinh, String sdt) {
		super();
		IDsinhvien = iDsinhvien;
		Hoten = hoten;
		IDlop = iDlop;
		IDkhoa = iDkhoa;
		Hedaotao = hedaotao;
		Ngaysinh = ngaysinh;
		Diachi = diachi;
		Gioitinh = gioitinh;
		Sdt = sdt;
	}

	public Sinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}

}

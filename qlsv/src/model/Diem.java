package model;

public class Diem {

	private String IDlop;
	private String Monhoc;
	private String IDMonhoc;
	private String IDsinhvien;
	private float Diem15;
	private float Diem45;
	private float Diemthi;
	private float Tongket;
	private String Ketqua;
	private String IDgiaovien;

	public String getIDlop() {
		return IDlop;
	}

	public void setIDlop(String iDlop) {
		IDlop = iDlop;
	}

	public String getMonhoc() {
		return Monhoc;
	}

	public void setMonhoc(String monhoc) {
		Monhoc = monhoc;
	}

	public String getIDMonhoc() {
		return IDMonhoc;
	}

	public void setIDMonhoc(String iDMonhoc) {
		IDMonhoc = iDMonhoc;
	}

	public String getIDsinhvien() {
		return IDsinhvien;
	}

	public void setIDsinhvien(String iDsinhvien) {
		IDsinhvien = iDsinhvien;
	}

	public float getDiem15() {
		return Diem15;
	}

	public void setDiem15(float diem15) {
		Diem15 = diem15;
	}

	public float getDiem45() {
		return Diem45;
	}

	public void setDiem45(float diem45) {
		Diem45 = diem45;
	}

	public float getDiemthi() {
		return Diemthi;
	}

	public void setDiemthi(float diemthi) {
		Diemthi = diemthi;
	}

	public float getTongket() {
		return Tongket;
	}

	public void setTongket(float tongket) {
		Tongket = tongket;
	}

	public String getKetqua() {
		return Ketqua;
	}

	public void setKetqua(String ketqua) {
		Ketqua = ketqua;
	}

	public String getIDgiaovien() {
		return IDgiaovien;
	}

	public void setIDgiaovien(String iDgiaovien) {
		IDgiaovien = iDgiaovien;
	}

	public Diem(String iDlop, String monhoc, String iDMonhoc, String iDsinhvien, float diem15, float diem45,
			float diemthi, float tongket, String ketqua, String iDgiaovien) {
		super();
		IDlop = iDlop;
		Monhoc = monhoc;
		IDMonhoc = iDMonhoc;
		IDsinhvien = iDsinhvien;
		Diem15 = diem15;
		Diem45 = diem45;
		Diemthi = diemthi;
		Tongket = tongket;
		Ketqua = ketqua;
		IDgiaovien = iDgiaovien;
	}

	public Diem() {
		super();
		// TODO Auto-generated constructor stub
	}

}

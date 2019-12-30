package model;

public class Lop {

	private String IDlop;
	private String Tenlop;
	private String IDkhoa;
	private String Khoahoc;

	public String getIDlop() {
		return IDlop;
	}

	public void setIDlop(String iDlop) {
		IDlop = iDlop;
	}

	public String getTenlop() {
		return Tenlop;
	}

	public void setTenlop(String tenlop) {
		Tenlop = tenlop;
	}

	public String getIDkhoa() {
		return IDkhoa;
	}

	public void setIDkhoa(String iDkhoa) {
		IDkhoa = iDkhoa;
	}

	public String getKhoahoc() {
		return Khoahoc;
	}

	public void setKhoahoc(String khoahoc) {
		Khoahoc = khoahoc;
	}

	public Lop(String iDlop, String tenlop, String iDkhoa, String khoahoc) {
		super();
		IDlop = iDlop;
		Tenlop = tenlop;
		IDkhoa = iDkhoa;
		Khoahoc = khoahoc;
	}

	public Lop() {
		super();
		// TODO Auto-generated constructor stub
	}

}

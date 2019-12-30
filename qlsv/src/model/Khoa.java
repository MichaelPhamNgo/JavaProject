package model;

public class Khoa {

	private String IDkhoa;
	private String Tenkhoa;

	public String getIDkhoa() {
		return IDkhoa;
	}

	public void setIDkhoa(String iDkhoa) {
		IDkhoa = iDkhoa;
	}

	public String getTenkhoa() {
		return Tenkhoa;
	}

	public void setTenkhoa(String tenkhoa) {
		Tenkhoa = tenkhoa;
	}

	public Khoa(String iDkhoa, String tenkhoa) {
		super();
		IDkhoa = iDkhoa;
		Tenkhoa = tenkhoa;
	}

	public Khoa() {
		super();
		// TODO Auto-generated constructor stub
	}

}

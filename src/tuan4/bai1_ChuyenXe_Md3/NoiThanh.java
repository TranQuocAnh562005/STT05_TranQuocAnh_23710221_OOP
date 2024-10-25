package tuan4.bai1_ChuyenXe_Md3;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe {
	private int soTuyen;
	private double soKm;

	// ------------------- contructor đầy đủ tham số ----------------------------
	public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	// -------------------- contructor mặc định ---------------------------------
	public NoiThanh() {
		
	}

	// -------------------- begin setget----------------------------------------
	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}

	// ------------------------- end --------------------------------------------
	@Override
	public String toString() {
	    DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	    String doanhThuString = df.format(doanhThu);
	    DecimalFormat kmFormat = new DecimalFormat("#,##0.00 km");
	    String kmString = kmFormat.format(soKm);
	    
	    // Format the table header and rows
	    String header = String.format("%-15s | %-20s | %-10s | %-15s | %-10s | %-15s", "Mã chuyến xe", "Họ và tên", "Số xe", "Doanh thu", "Số tuyến", "Số km");
	    String separator = "----------------------------------------------------------------------------------";
	    String row = String.format("%-15s | %-20s | %-10d | %-15s | %-10d | %-15s", getMaChuyenXe(), getHoTen(), getSoXe(), doanhThuString, getSoTuyen(), kmString);
	    
	    return header + "\n" + separator + "\n" + row;
	}


}

package tuan4.bai1_ChuyenXe_Md3;

import java.text.DecimalFormat;

public class NgoaiThanh  extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;

	

	public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// ------------------ contructor mặc định -----------------------------
	public NgoaiThanh() {
		super();
	}
	// -------------------- begin setget -----------------------------------------
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// --------------------------end ---------------------------------------------
	@Override
	public String toString() {
	    DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	    String doanhThuString = df.format(doanhThu);
	    
	    // Format the table header and rows
	    String header = String.format("%-15s | %-20s | %-10s | %-15s | %-20s | %-15s", "Mã chuyến xe", "Họ và tên", "Số xe", "Doanh thu", "Nơi đến", "Số ngày đi");
	    String separator = "--------------------------------------------------------------------------------------------";
	    String row = String.format("%-15s | %-20s | %-10d | %-15s | %-20s | %-15d", getMaChuyenXe(), getHoTen(), getSoXe(), doanhThuString, getNoiDen(), getSoNgayDiDuoc());
	    
	    return header + "\n" + separator + "\n" + row;
	}


}

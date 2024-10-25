package tuan4.bai1_ChuyenXe_Md3;

import java.text.DecimalFormat;
import java.util.Objects;



public abstract class ChuyenXe {
	protected String maChuyenXe;
	protected String hoTen;
	protected int soXe;
	protected double doanhThu;

	public ChuyenXe(String maChuyenXe, String hoTen, int soXe, double doanhThu) {
		super();
		this.maChuyenXe = maChuyenXe;
		this.hoTen = hoTen;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	public ChuyenXe() {
		super();
	}

	public String getMaChuyenXe() {
		return maChuyenXe;
	}

	public void setMaChuyenXe(String maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoXe() {
		return soXe;
	}

	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) throws Exception {
		if(doanhThu > 0)
			this.doanhThu = doanhThu;
		else
			throw new Exception("Doanh thu phải lớn hơn không");
	}
	@Override
	public int hashCode() {
		return Objects.hash(maChuyenXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maChuyenXe, other.maChuyenXe);
	}

	@Override
	public String toString() {
	    DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	    String doanhThuString = df.format(doanhThu);
	    String header = String.format("%-15s | %-20s | %-10s | %-15s", "Mã chuyến xe", "Họ và tên", "Số xe", "Doanh thu");
	    String separator = "---------------------------------------------------------------";
	    String row = String.format("%-15s | %-20s | %-10d | %-15s", getMaChuyenXe(), getHoTen(), getSoXe(), doanhThuString);
	    
	    return header + "\n" + separator + "\n" + row;
	}
	
}

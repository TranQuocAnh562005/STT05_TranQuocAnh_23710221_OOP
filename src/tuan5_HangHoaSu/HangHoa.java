package tuan5_HangHoaSu;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public abstract  class HangHoa {
	protected final String maHang; // Mã hàng không được sửa
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;
    protected String loaiHang;
	public abstract double tinhVAT();
    public abstract String danhGiaMucDoBanBuon();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	

	    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia, String loaiHang) {
	        if (maHang == null || maHang.isEmpty()) {
	            throw new IllegalArgumentException("Mã hàng không được để trống.");
	        }
	        if (tenHang == null || tenHang.isEmpty()) {
	            throw new IllegalArgumentException("Tên hàng không được để trống.");
	        }
	        if (soLuongTon < 0) {
	            throw new IllegalArgumentException("Số lượng tồn phải >= 0.");
	        }
	        if (donGia <= 0) {
	            throw new IllegalArgumentException("Đơn giá phải > 0.");
	        }
	        this.maHang = maHang;
	        this.tenHang = tenHang;
	        this.soLuongTon = soLuongTon;
	        this.donGia = donGia;
	        this.loaiHang = loaiHang; // Thêm thuộc tính phân loại
	    }

	    public String getMaHang() {
	        return maHang;
	    }

	    public String getTenHang() {
	        return tenHang;
	    }

	    public void setTenHang(String tenHang) {
	        if (tenHang == null || tenHang.isEmpty()) {
	            throw new IllegalArgumentException("Tên hàng không được để trống.");
	        }
	        this.tenHang = tenHang;
	    }

	    public int getSoLuongTon() {
	        return soLuongTon;
	    }

	    public void setSoLuongTon(int soLuongTon) {
	        if (soLuongTon < 0) {
	            throw new IllegalArgumentException("Số lượng tồn phải >= 0.");
	        }
	        this.soLuongTon = soLuongTon;
	    }

	    public double getDonGia() {
	        return donGia;
	    }

	    public void setDonGia(double donGia) {
	        if (donGia <= 0) {
	            throw new IllegalArgumentException("Đơn giá phải > 0.");
	        }
	        this.donGia = donGia;
	    }
	    
	    public double tinhGiaBan() {
	        return soLuongTon * donGia;
	    }

	    
	
	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}
	@Override
	public String toString() {
		 return String.format("%-10s|%-15s|%-10d|%-10.2f|%-15s", maHang, tenHang, soLuongTon, donGia, loaiHang);
	}
	
	
	
	
	
	
}
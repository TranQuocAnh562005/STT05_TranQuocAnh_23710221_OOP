package tuan5_GiaoDichVang;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class GiaoDich {
  protected String maGiaoDich;
  protected LocalDate ngayGiaoDich;
  protected double donGia;
  protected int soLuong;
  protected String loaiGiaoDich;
  abstract double thanhTien();
  
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
  
	public GiaoDich() {
		super();
	}

	

	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.loaiGiaoDich = loaiGiaoDich;
	}



	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	

	public String getLoaiGiaoDich() {
		return loaiGiaoDich;
	}

	public void setLoaiGiaoDich(String loaiGiaoDich) {
		this.loaiGiaoDich = loaiGiaoDich;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maGiaoDich);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Objects.equals(maGiaoDich, other.maGiaoDich);
	}
	
	
	@Override
	public String toString() {
	    // Kiểm tra nếu ngayGiaoDich là null
	    String ngayGiaoDichFormatted = (ngayGiaoDich != null) ? 
	        ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";

	    return String.format(
	        "%-10s|%-15s|%-10.2f|%-10d|%-20s|%-15s", // Kích thước cột cho các trường
	        maGiaoDich,                          // Mã giao dịch
	        ngayGiaoDichFormatted,               // Ngày giao dịch (đã kiểm tra null)
	        donGia,                              // Đơn giá
	        soLuong,                             // Số lượng
	        loaiGiaoDich,                        // Loại giao dịch
	        getLoaiGiaoDich()                    // Loại giao dịch chi tiết
	    );
	}


	
}

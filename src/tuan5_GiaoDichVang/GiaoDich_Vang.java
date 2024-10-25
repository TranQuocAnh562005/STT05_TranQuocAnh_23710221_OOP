package tuan5_GiaoDichVang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich_Vang extends GiaoDich {
	public String loaiVang;
	
	
	public GiaoDich_Vang() {
		super();
		this.loaiGiaoDich =	"Giao Dịch Vàng";
	}
	

	public GiaoDich_Vang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich,
			String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong, loaiGiaoDich);
		this.loaiVang = loaiVang;
	}
	
	


	public String getLoaiVang() {
		return loaiVang;
	}


	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}


	@Override
	double thanhTien() {
		try {
			return soLuong * donGia;
		} catch (Exception e) {
			System.out.println("Lỗi khi tính thành tiền giao dịch vàng: " + e.getMessage());
			return 0;
		}
		
	}


	@Override
	public String toString() {
		 String ngayGiaoDichFormatted = (ngayGiaoDich != null) ? 
			        ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
	    return String.format("%-10s|%-15s|%-10.2f|%-10d|%-20s|%-20s|%-20.2f",
	            maGiaoDich, ngayGiaoDichFormatted, donGia, soLuong, loaiGiaoDich, loaiVang, thanhTien());
	}


	
	
	
}
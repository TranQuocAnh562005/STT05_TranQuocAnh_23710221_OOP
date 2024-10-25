package tuan5_GiaoDichVang;

import java.time.LocalDate;

public class GiaoDich_Tien extends GiaoDich {
	public String loaiTien;
	public double tiGia;

	public GiaoDich_Tien(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong, loaiGiaoDich);
		this.loaiGiaoDich = "Tiền Tệ";
	}

	public GiaoDich_Tien(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich,
			String loaiTien, double tiGia) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong, "Tiền tệ");
		this.loaiTien = loaiTien != null ? loaiTien : "VND"; // Gán mặc định là "VND" nếu null
		this.tiGia = tiGia;
	}

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}

	@Override
	double thanhTien() {
		try {
			if (loaiTien != null && (loaiTien.equals("USD") || loaiTien.equals("EURO"))) {
				return soLuong * donGia * tiGia;
			} else {
				return soLuong * donGia;
			}
		} catch (Exception e) {
			System.out.println("Lỗi khi tính thành tiền giao dịch tiền tệ: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.format("%-10s|%-15s|%-10.2f|%-10d|%-15s|%-10s|%-10.2f|%-10.2f", // Căn chỉnh đúng kích thước cột
				maGiaoDich, // Mã Giao Dịch
				ngayGiaoDich, // Ngày giao dịch
				donGia, // Đơn giá
				soLuong, // Số lượng
				loaiGiaoDich, // Loại giao dịch
				loaiTien != null ? loaiTien : "N/A", // Loại tiền, nếu null thì hiển thị "N/A"
				tiGia, // Tỉ giá
				thanhTien() // Thành tiền
		);
	}

}

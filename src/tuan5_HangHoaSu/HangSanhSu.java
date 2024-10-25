package tuan5_HangHoaSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat; // Nhà sản xuất
	private LocalDate ngayNhapKho; // Ngày nhập kho

	// Constructor
	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, donGia, "Sành sứ"); // Gọi constructor của lớp cha
		this.nhaSanXuat = nhaSanXuat; // Khởi tạo nhà sản xuất
		this.ngayNhapKho = ngayNhapKho; // Khởi tạo ngày nhập kho
	}

	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String loaiHang, String nhaSanXuat,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, donGia, loaiHang);
		this.nhaSanXuat = nhaSanXuat;
		this.ngayNhapKho = ngayNhapKho;
	}

	// Getter và Setter cho nhaSanXuat
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	// Getter và Setter cho ngayNhapKho
	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	@Override
	public double tinhVAT() {
		return tinhGiaBan() * 0.1; // Tính VAT cho hàng sành sứ
	}

	@Override
	public String danhGiaMucDoBanBuon() {
		int soNgayLuuKho = (int) java.time.temporal.ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
		if (soLuongTon > 50 && soNgayLuuKho > 10) {
			return "Bán chậm"; // Đánh giá bán chậm nếu số lượng tồn và số ngày lưu kho thỏa mãn
		}
		return "Không đánh giá"; // Trả về đánh giá không có
	}

	@Override

	public String toString() {
		String ngayNhapKhotFormatted = (ngayNhapKho != null)
				? ngayNhapKho.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				: "N/A";
		return super.toString() + String.format("|%-20s|%-15s|%-10.2f", nhaSanXuat, ngayNhapKhotFormatted, tinhVAT());
	}

}
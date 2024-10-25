package tuan4.bai1_ChuyenXe_Md3;

import java.util.Scanner;

public class KiemThuChuyenXe {
	static DanhSachChuyenXe DS = new DanhSachChuyenXe();

	static void Menu() {
		System.out.println("""
			\t****************************************
			\t**   Chương trình quản lí chuyến xe   **
			\t* 1. Nhập cứng                         *
			\t* 2. Thêm 1 chuyến xe                  *
			\t* 3. Xóa                               *
			\t* 4. Sửa                               *
			\t* 5. Xuất doanh thu                    *
			\t* 6. Xuất                              *
			\t* 7. Sắp xếp theo doanh thu            *
			\t* 8. Sắp xếp theo tên tài xế           *
			\t* 9. Xuất danh sách xe ngoại thành     *
			\t* 10. Xuất danh sách xe nội thành      *
			\t* 11. Sắp xếp theo 2 thuộc tính        *
			\t* 12. Thoát                            *
			\t****************************************
		""");
	}

	static void nhapCung() {
		try {
			DS.them(new NoiThanh("CX001", "Trần Văn Linh", 1, 3000000, 3, 12.3));
			DS.them(new NgoaiThanh("CX002", "Lê Văn Bình", 2, 2000000, "Long Thành", 12));
			DS.them(new NoiThanh("CX003", "Võ Tấn Đạt", 1, 1600000, 3, 12.3));
			DS.them(new NgoaiThanh("CX004", "Võ An Vy", 2, 8000000, "An Nhơn", 12));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static ChuyenXe ThemMotXe() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập mã chuyến xe: ");
			String maChuyenXe = sc.nextLine();
			if (DS.timKiemViTri(maChuyenXe) == -1) {
				System.out.print("Nhập tên tài xế: ");
				String hoTen = sc.nextLine();
				System.out.print("Nhập doanh thu: ");
				double doanhThu = sc.nextDouble();
				System.out.print("Nhập số xe: ");
				int soXe = sc.nextInt();
				System.out.print("Nhập xe nội thành [1] hoặc khác để nhập xe ngoại thành: ");
				int chon = sc.nextInt();

				sc.nextLine(); // Consume newline
				if (chon != 1) {
					System.out.print("Nhập nơi đến: ");
					String noiDen = sc.nextLine();
					System.out.print("Nhập số ngày đi được: ");
					int soNgay = sc.nextInt();
					return new NgoaiThanh(maChuyenXe, hoTen, soXe, doanhThu, noiDen, soNgay);
				} else {
					System.out.print("Nhập số tuyến: ");
					int soTuyen = sc.nextInt();
					System.out.print("Nhập số km đi được: ");
					double soKm = sc.nextDouble();
					return new NoiThanh(maChuyenXe, hoTen, soXe, doanhThu, soTuyen, soKm);
				}
			} else {
				System.out.println("Mã chuyến xe đã trùng");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	static void xoa() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập mã chuyến xe cần xóa: ");
			ChuyenXe xex = DS.timKiem(sc.nextLine());
			if (xex != null) {
				System.out.print("Xác nhận xóa [y/n]: ");
				if (sc.nextLine().equalsIgnoreCase("y")) {
					DS.xoa(xex);
					System.out.println("Đã xóa thành công");
				} else {
					System.out.println("Chuyến xe được giữ lại");
				}
			} else {
				System.out.println("Không tồn tại xe này");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void sua() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập mã chuyến xe cần sửa: ");
			ChuyenXe xe = DS.timKiem(sc.nextLine());
			if (xe == null) {
				System.out.println("Mã chuyến xe không tồn tại");
				return;
			}
			if (xe instanceof NoiThanh nt) {
				System.out.print("Nhập tên tài xế: ");
				nt.setHoTen(sc.nextLine());
				System.out.print("Nhập số tuyến: ");
				nt.setSoTuyen(sc.nextInt());
				System.out.print("Nhập số km: ");
				nt.setSoKm(sc.nextDouble());
			} else if (xe instanceof NgoaiThanh ngt) {
				System.out.print("Nhập tên tài xế: ");
				ngt.setHoTen(sc.nextLine());
				System.out.print("Nhập nơi đến: ");
				ngt.setNoiDen(sc.nextLine());
				System.out.print("Nhập số ngày đi được: ");
				ngt.setSoNgayDiDuoc(sc.nextInt());
			}
			System.out.println("Đã cập nhật thành công");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void mainMenu() {
		int chon;
		do {
			
			System.out.print("Nhập lựa chọn: ");
			chon = new Scanner(System.in).nextInt();
			switch (chon) {
				case 1 -> nhapCung();
				case 2 -> {
					ChuyenXe xe = ThemMotXe();
					if (xe != null)
						try {
							DS.them(xe);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				case 3 -> xoa();
				case 4 -> sua();
				case 5 -> System.out.println("Doanh thu: " + DS.tinhDoanhThu());
				case 6 -> DS.getDS().forEach(System.out::println);
				case 7 -> DS.sortTheoDoanhThu();
				case 8 -> DS.sortTheoTenTaiXe();
				case 9 -> DS.getDSXeNgoaiThanh().forEach(System.out::println);
				case 10 -> DS.getDSXeNoiThanh().forEach(System.out::println);
				case 11 -> DS.sortTheo2Fied();
			}
		} while (chon < 12);
		System.out.println("Cảm ơn bạn đã sử dụng chương trình");
	}
	
	


	public static void main(String[] args) {
		Menu();
		mainMenu();
	}
}

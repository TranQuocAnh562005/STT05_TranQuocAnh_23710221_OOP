package tuan5_HangHoaSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testmain {
    static QuanLyKho dsHang = new QuanLyKho();
    static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị menu
    static void Menu() {
        System.out.println("\t***************************************");
        System.out.println("\t**   Chương trình quản lý kho hàng   **");
        System.out.println("\t* 1. Nhập hàng hóa cứng               *");
        System.out.println("\t* 2. Thêm hàng hóa từ bàn phím        *");
        System.out.println("\t* 3. Xuất danh sách hàng hóa          *");
        System.out.println("\t* 4. Xóa hàng hóa theo mã             *");  // Tùy chọn mới
        System.out.println("\t* 5. Sắp xếp theo đơn giá             *");  // Tùy chọn mới
        System.out.println("\t* 6. Sắp xếp theo đơn giá ngày nhập   *");  // Tùy chọn mới
        System.out.println("\t* 0. Thoát                            *");
        System.out.println("\t***************************************");
    }

    public static void inTieuDe(String loaiHang) {
        switch (loaiHang) {
            case "Thực phẩm":
                System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-20s|%-15s|%-15s|%-15s\n", 
                                  "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", 
                                  "Loại Hàng", "Nhà Cung Cấp", "Ngày Sản Xuát", "Ngày Hết Hạn", "VAT");
                
                break;
            case "Điện máy":
            	System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-20s|%-15s|%-15s\n", 
                                  "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", 
                                  "Loại Hàng", "Thời Gian BH", "Công suất", "VAT");
              
                break;
            case "Sành sứ":
            	System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-20s|%-15s|%-15s\n", 
                                  "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", 
                                  "Loại Hàng", "Nhà sản xuất", "Ngày nhập kho", "VAT");
                
                break;
            default:
                System.out.println("Loại hàng không hợp lệ.");
        }
    }


    static void xoa(QuanLyKho dsHang) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã hàng cần xóa: ");
        String ma = scanner.nextLine();
        
        // Sử dụng phương thức xoaHang của đối tượng ds (QuanLyKho)
        if (dsHang.xoaHang(ma)) {
            System.out.println("Xóa thành công hàng có mã: " + ma);
        } else {
            System.out.println("Xóa không thành công. Không tìm thấy hàng có mã: " + ma);
        }
    }

    static void nhapCung() throws Exception {
        try {
            // Thêm một số hàng hóa mẫu
        	HangHoa thucPham1 = new HangThucPham("TP001", "Sữa tươi", 100, 20000, 
                    "Công ty TNHH ABC", LocalDate.of(2023, 9, 13), LocalDate.of(2023, 9, 14)); // Cung cấp nhà cung cấp, ngày sản xuất và ngày hết hạn

        	HangHoa dienMay1 = new HangDienMay("DM001", "Tivi LED", 50, 5000000, 24, 150);

            HangHoa sanhSu1 = new HangSanhSu("SS001", "Bộ chén sứ", 200, 50000, 
                    "Công ty TNHH XYZ",LocalDate.of(2023, 9, 13)); // Thêm tham số ngày nhập kho


            // Thêm hàng vào danh sách
            dsHang.addHang(thucPham1);
            dsHang.addHang(dienMay1);
            dsHang.addHang(sanhSu1);

            System.out.println("Đã thêm hàng hóa mẫu vào danh sách.");

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    
    static void xuat(QuanLyKho dsHang) {
        for (HangHoa hang : dsHang.getListHang()) {
            if (hang instanceof HangThucPham) {
                inTieuDe("Thực phẩm");
                System.out.println(hang);
            } else if (hang instanceof HangDienMay) {
                inTieuDe("Điện máy");
                System.out.println(hang);
            } else if (hang instanceof HangSanhSu) {
                inTieuDe("Sành sứ");
                System.out.println(hang);
            }
        }
    }
    
    


    // Hàm nhập hàng hóa từ bàn phím
 // Hàm nhập hàng hóa từ bàn phím
    static void nhapHangTuBanPhim() throws Exception {
        System.out.println("Chọn loại hàng (1: Thực phẩm, 2: Điện máy, 3: Sành sứ): ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới sau khi nhập số

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập số lượng tồn: ");
        int soLuongTon = scanner.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng mới

        HangHoa hang = null;

        switch (loaiHang) {
            case 1: // Hàng thực phẩm
				/*
				 * System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): "); String ngaySanXuat =
				 * scanner.nextLine(); System.out.print("Nhập ngày giao dịch (dd/MM/yyyy): ");
				 */
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
                LocalDate ngaySanXuat = LocalDate.parse(scanner.nextLine(), formatter);
                System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
                LocalDate ngayHetHan = LocalDate.parse(scanner.nextLine(), formatter);
              
                System.out.print("Nhập nhà cung cấp: ");
                String nhaCungCap = scanner.nextLine();
                hang = new HangThucPham(maHang, tenHang, soLuongTon, donGia, nhaCungCap, ngaySanXuat, ngayHetHan);
                break;

            case 2: // Hàng điện máy
                System.out.print("Nhập thời gian bảo hành (tháng): ");
                int thoiGianBaoHanh = scanner.nextInt();
                System.out.print("Nhập công suất (KW): ");
                double congSuat = scanner.nextDouble();
                hang = new HangDienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
                break;

            case 3: // Hàng sành sứ
                System.out.print("Nhập nhà sản xuất: ");
                String nhaSanXuat = scanner.nextLine();
                System.out.print("Nhập ngày nhập kho (yyyy-MM-dd): ");
                String ngayNhapKhoStr = scanner.nextLine(); // Nhập ngày nhập kho dưới dạng String
                LocalDate ngayNhapKho = LocalDate.parse(ngayNhapKhoStr); // Chuyển đổi từ String sang LocalDate

                hang = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho); 
                break;

            default:
                System.out.println("Loại hàng không hợp lệ.");
                return;
        }

        dsHang.addHang(hang);
        System.out.println("Thêm hàng hóa thành công!");
    }





    public static void main(String[] args) {
        int chon = -1;
        try {
            do {
                Menu();
                System.out.println("Nhập lựa chọn: ");
                chon = scanner.nextInt();
                scanner.nextLine(); // Xử lý dòng mới

                switch (chon) {
                    case 1:
                        nhapCung();
                        break;
                    case 2:
                        nhapHangTuBanPhim();
                        break;
                    case 3:
                        xuat(dsHang);
                        break;
                    case 4: // Chức năng xóa hàng hóa
					
						xoa(dsHang);
						xuat(dsHang);
                        break;
					case 5: // Sắp xếp theo đơn giá
						dsHang.sortTheoSoLuong();
						xuat(dsHang);
						break;
					case 6: // Sắp xếp theo đơn giá và ngày nhập
						dsHang.sortDonGia();
						xuat(dsHang);
						break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                }
            } while (chon != 0);  // Kết thúc khi chọn 0
        } catch (Exception e) {
            System.out.println("Đã có lỗi xảy ra: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
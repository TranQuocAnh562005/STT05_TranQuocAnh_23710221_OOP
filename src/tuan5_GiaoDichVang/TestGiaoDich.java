package tuan5_GiaoDichVang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class TestGiaoDich {
  static ListGiaoDich dsGiaoDich = new ListGiaoDich();
  static Scanner scanner = new Scanner(System.in);
  // Hàm hiển thị menu
  static void Menu() {
      System.out.println("\t****************************************");
      System.out.println("\t**   Chương trình quản lí            **");
      System.out.println("\t* 1. Nhập cứng                         *");
      System.out.println("\t* 2. Thêm sách từ bàn phím             *");
      System.out.println("\t* 3. Xuất                              *");
      System.out.println("\t* 4. Sắp xếp theo số lượng             *");
      System.out.println("\t* 5. Thoát                             *");
      System.out.println("\t****************************************");
  }

  public static void inTieuDe(String loaiGiaoDich) {
	    if (loaiGiaoDich.equals("Vàng")) {
	    	 System.out.println("-----------------------------------------------------------------------------------");
	        System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-20s|%-20s\n", 
	                          "Mã Giao Dịch", "Ngày", "Đơn Giá", "Số Lượng", 
	                          "Loại Giao Dịch", "Loại Vàng", "Thành Tiền");
	    } else if (loaiGiaoDich.equals("Tiền")) {
	    	 System.out.println("-----------------------------------------------------------------------------------");
	        System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-10s|%-10s|%-10s\n", 
	                          "Mã Giao Dịch", "Ngày", "Đơn Giá", "Số Lượng", 
	                          "Loại Giao Dịch", "Loại Tiền", "Tỉ Giá", "Thành Tiền");
	    }
	}
  static void xuat(ListGiaoDich dsGiaoDich) {
	    for (GiaoDich giaodich : dsGiaoDich.getListGiaoDich()) {
	        if (giaodich instanceof GiaoDich_Vang) {
	            inTieuDe("Vàng");
	            System.out.println(giaodich);
	        } else if (giaodich instanceof GiaoDich_Tien) {
	            inTieuDe("Tiền");
	            System.out.println(giaodich);
	        }
	    }
	}


	static void nhapCung() throws Exception {
		try {
			// Khởi tạo đối tượng Sach_Kham_Khao
			GiaoDich gd1 = new GiaoDich_Vang("GD001", // maSach
					LocalDate.of(2023, 9, 13), // ngaNhap
					150000.0, // donGia
					10, // soLuong
					"Giao Dịch Vàng", "Loai 1");

			// Khởi tạo đối tượng Sach_Giao_Khoa
			GiaoDich gd2 = new GiaoDich_Vang("GD002", // maSach
					LocalDate.of(2023, 9, 13), // ngaNhap
					50000.0, // donGia
					20, // soLuong
					"Giao Dịch Vàng", "Loai 2");
			GiaoDich gd3 = new GiaoDich_Vang("GD003", // maSach
					LocalDate.of(2023, 9, 13), // ngaNhap
					50000.0, // donGia
					15, // soLuong
					"Giao Dịch Vàng", "Loai 3");
			GiaoDich gd4 = new GiaoDich_Tien(
				    "GD004", // maGiaoDich
				    LocalDate.of(2023, 9, 13), // ngayGiaoDich
				    50000.0, // donGia
				    15, // soLuong
				    "Giao Dịch Tiền" ,
				    "USD", 23.000// loaiTien
				    // tiGia, giả sử tỷ giá USD/VND là 23000
				);

			// Thêm cả hai sách vào danh sách 'sach'
			dsGiaoDich.addGiaoDich(gd1);
			dsGiaoDich.addGiaoDich(gd2);
			dsGiaoDich.addGiaoDich(gd3);
			dsGiaoDich.addGiaoDich(gd4);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Hàm nhập sách từ bàn phím
    static void nhapSachTuBanPhim() throws Exception {
        System.out.println("Chọn loại Giao Dịch (1. Giao Dịch Vàng, 2. Giao Dịch Tiền): ");
        int loaiGiaoDich = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới sau khi nhập số

        System.out.print("Nhập mã giao dich: ");
        String maGiaoDich = scanner.nextLine();

       
      
        System.out.print("Nhập ngày giao dịch (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayGiaoDich = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới


        if (loaiGiaoDich == 1) { // Giao dịch vàng
            System.out.print("Nhập Loại Vàng (VD: Vàng 24K, Vàng 18K, ...): ");
            String loaiVang = scanner.nextLine(); // Người dùng nhập loại vàng

            GiaoDich giaoDich_Vang = new GiaoDich_Vang(maGiaoDich, ngayGiaoDich, donGia, soLuong, "Giao Dịch Vàng", loaiVang);
            dsGiaoDich.addGiaoDich(giaoDich_Vang);

        } else if (loaiGiaoDich == 2) { // Giao dịch tiền
           
            System.out.print("Nhập loại tiền (VD: USD, EURO, ...): ");
            String loaiTien = scanner.nextLine(); // Người dùng nhập loại tiền
            System.out.print("Nhập tỉ giá: ");
            double tiGia = scanner.nextDouble(); // Người dùng nhập tỉ giá

            GiaoDich giaoDich_Tien = new GiaoDich_Tien(maGiaoDich, ngayGiaoDich, donGia, soLuong, "Giao Dịch Tiền", loaiTien, tiGia);

            dsGiaoDich.addGiaoDich(giaoDich_Tien);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    
	

    
    public static void main(String[] args) throws Exception {
        int chon = -1;
        do {
            Menu();
            System.out.println("Nhập lựa chọn: ");

            chon = new Scanner(System.in).nextInt();
            switch (chon) {
                case 1:
                    nhapCung();
                    break;
                case 2:
                    nhapSachTuBanPhim();
                    break;
                case 3:
                    xuat(dsGiaoDich);
                    break;
               
                case 4: 
					dsGiaoDich.sortTheoSoLuong();
					xuat(dsGiaoDich);
					break;
                case 5:
					System.out.println("Cảm ơn bạn đã sử dụng chương trình");
					break;
                    

                default:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình");
            }
        } while (chon != 4);  // Đóng dấu ngoặc đơn và thêm dấu chấm phẩy ở cuối câu lệnh while
    }

}

package tuan4.bai2_Sach_Module_3;

import java.time.LocalDate;
import java.util.Scanner;

import tuan4.bai1_ChuyenXe_Module3.ChuyenXe;
import tuan4.bai1_ChuyenXe_Module3.DanhSachChuyenXe;
import tuan4.bai1_ChuyenXe_Module3.NgoaiThanh;
import tuan4.bai1_ChuyenXe_Module3.NoiThanh;

public class TestSach {
	static ListSach sach = new ListSach();
	static void Menu() {
		System.out.println("\t****************************************");
		System.out.println("\t**   Chương trình quản lí chuyến xe   **");
		System.out.println("\t* 1. Nhập cứng                         *");
		System.out.println("\t* 2. Thêm 1 chuyến xe                  *");
		System.out.println("\t* 3. Xuất                              *");
		System.out.println("\t* 4. Thoát                            *");
		System.out.println("\t****************************************");
	}
	// Giả sử s là một danh sách

	public static void inTieuDe() {
	    System.out.printf("%-10s %-15s %-10s %-10s %-20s %-15s \n", 
	                      "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng", "Nhà Xuất Bản", "Loại Sách");
	}


	static void nhapCung() throws Exception {
	    try {
	        Sach sachkhamkhao = new Sach_Kham_Khao(
	            "SACH001",                        // maSach
	            LocalDate.of(2023, 9, 13),        // ngaNhap
	            150000.0,                         // donGia
	            10,                               // soLuong
	            "NXB Giáo Dục",                   // nhaXuatBan
	            0.05f                             // thue
	        );

	        sach.add(sachkhamkhao); // Sử dụng s.add thay vì s.them nếu s là ArrayList
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	static void xuat(ListSach sach) {
		inTieuDe();
		for (Sach s : sach.getDS()) {
			System.out.println(s);
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
			case 3:
				xuat(sach);
				break;
		

			default:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình");
			}
		} while (chon < 12);
	}

}

package tuan3.bai7;

import java.util.Arrays;
import java.util.Scanner;

public class TestSinhVien {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        SinhVien[] danhSachSinhVien = new SinhVien[n];

        // Gọi hàm nhập thông tin sinh viên
        nhapDanhSachSinhVien(danhSachSinhVien, scanner);

        // Sắp xếp danh sách sinh viên theo mã sinh viên (tăng dần)
        Arrays.sort(danhSachSinhVien, (sv1, sv2) -> sv1.getMaSinhVien() - sv2.getMaSinhVien());

        // Xuất danh sách sinh viên
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp:");
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
            System.out.println("------------------");
        }

        scanner.close();
    }

    // Hàm nhập thông tin sinh viên
    public static void nhapDanhSachSinhVien(SinhVien[] danhSachSinhVien, Scanner scanner) {
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Mã sinh viên: ");
            int maSinhVien = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();

            System.out.print("Số điện thoại (7 chữ số): ");
            String soDienThoai = scanner.nextLine();

            // Tạo đối tượng sinh viên và thêm vào mảng
            danhSachSinhVien[i] = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai);
        }
    }
}


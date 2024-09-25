package tuan4.bai2_Sach_Module_3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Sach_Giao_Khoa extends Sach {
	private String tinhTrang;

	


	
	
	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	

	
	

	

	public Sach_Giao_Khoa(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan,
			 String tinhTrang) {
		super(maSach, ngaNhap, donGia, soLuong, nhaXuatBan, "Sách Giáo Khoa");
		this.tinhTrang = tinhTrang;
	}
	
	

	

	

	@Override
	public double thanhTien() {
		 try {
		        if ("Mới".equalsIgnoreCase(tinhTrang)) { // Nếu tình trạng là "Mới"
		            return soLuong * donGia;             // Tính giá sách mới
		        } else if ("Cũ".equalsIgnoreCase(tinhTrang)) { // Nếu tình trạng là "Cũ"
		            return soLuong * donGia * 0.5;       // Tính giá sách cũ với 50% giá
		        } else {
		            throw new IllegalArgumentException("Tình trạng sách không hợp lệ");
		        }
		    } catch (Exception e) {
		        System.out.println("Lỗi khi tính thành tiền sách giáo khoa: " + e.getMessage());
		        return 0;
		    }
	}
	
	
	@Override
	public String toString() {
		 return String.format(
		            "%s|%-15s|%-20.2f", // Điều chỉnh kích thước cột nếu cần thiết
		            super.toString(), 
		            
		           getTinhTrang(),
		           thanhTien()
		        );
	}
}

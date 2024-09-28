package tuan4.bai3_GiaoDich_Module_3;

import java.time.LocalDate;

public class GiaoDich_Vang extends GiaoDich {
	public String loaiVang;
	
	
	public GiaoDich_Vang() {
		super();
		this.loaiGiaoDich =	"Giao Dịch Vàng";
	}
	

	public GiaoDich_Vang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich,
			String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong, "Giao Dịch Vàng");
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
	    return String.format(
	        "%s|%-15s|%-20.2f", // Điều chỉnh kích thước cột nếu cần thiết
	        super.toString(), 
	        loaiVang,           // Loại vàng
	        thanhTien()         // Thành tiền
	    );
	}

	
	
	
}

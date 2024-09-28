package tuan4.bai8_HangHoa_Module_3;

public class HangSanhSu extends HangHoa {
	 private String nhaSanXuat;
	    private String ngayNhapKho;
	    
	    
	    

	    public String getNhaSanXuat() {
			return nhaSanXuat;
		}

		public void setNhaSanXuat(String nhaSanXuat) {
			this.nhaSanXuat = nhaSanXuat;
		}

		public String getNgayNhapKho() {
			return ngayNhapKho;
		}

		public void setNgayNhapKho(String ngayNhapKho) {
			this.ngayNhapKho = ngayNhapKho;
		}

		public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
	                      String nhaSanXuat, String ngayNhapKho) {
	        super(maHang, tenHang, soLuongTon, donGia);
	        this.nhaSanXuat = nhaSanXuat;
	        this.ngayNhapKho = ngayNhapKho;
	    }

	    @Override
	    public double tinhVAT() {
	        return tinhGiaBan() * 0.1;
	    }

	  

		@Override
		public String danhGiaMucDoBanBuon() {
			// Nếu số lượng tồn kho > 50 và thời gian lưu kho > 10 ngày thì đánh giá là bán chậm
	        // Tính thời gian lưu kho giả định
	        int soNgayLuuKho = 15; // Thay thế bằng cách tính ngày thực tế
	        if (soLuongTon > 50 && soNgayLuuKho > 10) {
	            return "Bán chậm";
	        }
	        return "Không đánh giá";
		}

		@Override
		public String toString() {
			 return super.toString() + String.format("|%-20s|%-15s", nhaSanXuat, ngayNhapKho);
		}
		
		
}

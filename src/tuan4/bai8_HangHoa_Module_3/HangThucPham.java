package tuan4.bai8_HangHoa_Module_3;
import java.time.LocalDate;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                        String ngaySanXuat, String ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        
        // Chuyển đổi từ String sang LocalDate
        LocalDate dateSanXuat = LocalDate.parse(ngaySanXuat);
        LocalDate dateHetHan = LocalDate.parse(ngayHetHan);
        
        // Kiểm tra ngày hết hạn phải sau hoặc bằng ngày sản xuất
        if (dateHetHan.isBefore(dateSanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất.");
        }
        
        this.ngaySanXuat = dateSanXuat;
        this.ngayHetHan = dateHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return tinhGiaBan() * 0.05;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-20s|%-15s|%-15s", nhaCungCap, ngaySanXuat, ngayHetHan);
    }
}


package tuan4.bai8_HangHoa_Module_3;

import java.util.ArrayList;

public class QuanLyKho {
    private ArrayList<HangHoa> danhSachHang;

    public QuanLyKho() {
        danhSachHang = new ArrayList<>();
    }

    public void addHang(HangHoa hang) throws Exception {
    	if (!danhSachHang.contains(hang))// hiểu dc nhờ hascode equa của lớp sach
			danhSachHang.add(hang);
		else {
			throw new Exception("Mã Giao Dich đã trùng");
		}
    }

    public HangHoa timKiem(String maHang) {
        for (HangHoa hang : danhSachHang) {
            if (hang.maHang.equalsIgnoreCase(maHang)) {
                return hang;
            }
        }
        return null;
    }

    public void xoaHang(HangHoa hang) {
        danhSachHang.remove(hang);
    }

    public ArrayList<HangHoa> getListHangThucPham() {
        ArrayList<HangHoa> listThucPham = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangThucPham) {
                listThucPham.add(hang);
            }
        }
        return listThucPham;
    }

    public ArrayList<HangHoa> getListHangDienMay() {
        ArrayList<HangHoa> listDienMay = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangDienMay) {
                listDienMay.add(hang);
            }
        }
        return listDienMay;
    }

    public ArrayList<HangHoa> getListHangSanhSu() {
        ArrayList<HangHoa> listSanhSu = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangSanhSu) {
                listSanhSu.add(hang);
            }
        }
        return listSanhSu;
    }

    public ArrayList<HangHoa> getListHang() {
        return danhSachHang;
    }
}

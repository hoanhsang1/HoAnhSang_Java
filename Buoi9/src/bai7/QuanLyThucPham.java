package bai7;

import java.util.ArrayList;
import java.util.Date;

public class QuanLyThucPham {
    private ArrayList<ThucPham> danhSach;
    
    public QuanLyThucPham() {
        danhSach = new ArrayList<>();
    }
    
    // Thêm thực phẩm
    public void themThucPham(ThucPham tp) {
        danhSach.add(tp);
        System.out.println("✓ Đã thêm thực phẩm: " + tp.getTenHang());
    }
    
    // Hiển thị tất cả
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("\n⚠ Danh sách thực phẩm trống!");
            return;
        }
        
        System.out.println("\n==================================================================================================");
        System.out.println("                             DANH SÁCH THỰC PHẨM (" + danhSach.size() + " sản phẩm)");
        System.out.println("==================================================================================================");
        System.out.println("  Mã hàng    Tên hàng               Đơn giá      Ngày SX     Ngày HH     Trạng thái");
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        int hetHan = 0, conHan = 0;
        for (ThucPham tp : danhSach) {
            System.out.println(tp.toStringNgan());
            if (tp.daHetHan()) {
                hetHan++;
            } else {
                conHan++;
            }
        }
        
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("THỐNG KÊ: Còn hạn: " + conHan + " | Hết hạn: " + hetHan);
        System.out.println("==================================================================================================\n");
    }
    
    // Hiển thị chi tiết 1 sản phẩm
    public void hienThiChiTiet(int index) {
        if (index >= 0 && index < danhSach.size()) {
            System.out.println(danhSach.get(index).toString());
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
    
    // Tìm kiếm theo mã hàng
    public void timKiemTheoMa(String maHang) {
        boolean found = false;
        System.out.println("\n=== KẾT QUẢ TÌM KIẾM MÃ: " + maHang + " ===");
        
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaHang().equalsIgnoreCase(maHang)) {
                hienThiChiTiet(i);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + maHang);
        }
    }
    
    // Tìm sản phẩm hết hạn
    public void timSanPhamHetHan() {
        ArrayList<ThucPham> dsHetHan = new ArrayList<>();
        
        for (ThucPham tp : danhSach) {
            if (tp.daHetHan()) {
                dsHetHan.add(tp);
            }
        }
        
        if (dsHetHan.isEmpty()) {
            System.out.println("\n✓ Không có sản phẩm nào hết hạn!");
            return;
        }
        
        System.out.println("\n⚠ DANH SÁCH SẢN PHẨM HẾT HẠN (" + dsHetHan.size() + " sản phẩm)");
        System.out.println("==================================================================");
        
        for (ThucPham tp : dsHetHan) {
            System.out.println(tp.toStringNgan());
        }
    }
    
    // Tìm sản phẩm sắp hết hạn (< 7 ngày)
    public void timSanPhamSapHetHan() {
        ArrayList<ThucPham> dsSapHetHan = new ArrayList<>();
        
        for (ThucPham tp : danhSach) {
            if (tp.sapHetHan() && !tp.daHetHan()) {
                dsSapHetHan.add(tp);
            }
        }
        
        if (dsSapHetHan.isEmpty()) {
            System.out.println("\n✓ Không có sản phẩm nào sắp hết hạn!");
            return;
        }
        
        System.out.println("\n⚠ DANH SÁCH SẢN PHẨM SẮP HẾT HẠN (" + dsSapHetHan.size() + " sản phẩm)");
        System.out.println("=====================================================================");
        
        for (ThucPham tp : dsSapHetHan) {
            int ngayConLai = tp.tinhSoNgayConHan();
            System.out.println(tp.toStringNgan() + " (Còn " + ngayConLai + " ngày)");
        }
    }
    
    // Getter
    public ArrayList<ThucPham> getDanhSach() {
        return danhSach;
    }
    
    public int getSoLuong() {
        return danhSach.size();
    }
}

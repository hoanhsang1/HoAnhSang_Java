package bai4;

import TaomoiTV.Test;

public class MainProgram {
    public static void main(String[] args) {
        QuanLyBienLai qlbl = new QuanLyBienLai();
        Test test = new Test();
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("   QUẢN LÝ BIÊN LAI TIỀN ĐIỆN - TAOMOITV");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập danh sách biên lai (n hộ)");
            System.out.println("2. Thêm 1 biên lai mới");
            System.out.println("3. Hiển thị tất cả biên lai");
            System.out.println("4. Hiển thị chi tiết 1 biên lai");
            System.out.println("5. Tìm kiếm theo tên chủ hộ");
            System.out.println("6. Tìm kiếm theo mã công tơ");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            
            chon = test.inputIntInRange("Chọn chức năng (0-6): ", 0, 6);
            
            switch (chon) {
                case 1:
                    qlbl.nhapDanhSachHoaDon();
                    break;
                    
                case 2:
                    qlbl.themBienLai();
                    break;
                    
                case 3:
                    qlbl.hienThiTatCaBienLai();
                    break;
                    
                case 4:
                    qlbl.hienThiChiTietBienLai();
                    break;
                    
                case 5:
                    qlbl.timKiemTheoTen();
                    break;
                    
                case 6:
                    qlbl.timKiemTheoMaCongTo();
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("   Cảm ơn đã sử dụng hệ thống!");
                    System.out.println("   Thư viện TaomoiTV - Phiên bản 1.0");
                    System.out.println("══════════════════════════════════════════");
                    break;
            }
            
        } while (chon != 0);
    }
}
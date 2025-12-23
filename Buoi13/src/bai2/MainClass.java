package bai2;

public class MainClass {
    public static void main(String[] args) {
        KhachSanX khachSan = new KhachSanX();
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("   QUẢN LÝ KHÁCH SẠN X - MENU CHÍNH");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập danh sách hóa đơn theo giờ");
            System.out.println("2. Nhập danh sách hóa đơn theo ngày");
            System.out.println("3. Xuất danh sách hóa đơn theo giờ");
            System.out.println("4. Xuất danh sách hóa đơn theo ngày");
            System.out.println("5. Tổng số lượng từng loại hóa đơn");
            System.out.println("6. Trung bình thành tiền tháng 9/2013");
            System.out.println("7. Tổng hợp thông tin");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            
            chon = TaomoiTV.Test.inputIntInRange("Chọn chức năng: ", 0, 7);
            
            switch (chon) {
                case 1:
                    khachSan.nhapDanhSachHDGio();
                    break;
                    
                case 2:
                    khachSan.nhapDanhSachHDNgay();
                    break;
                    
                case 3:
                    khachSan.xuatDanhSachHDGio();
                    break;
                    
                case 4:
                    khachSan.xuatDanhSachHDNgay();
                    break;
                    
                case 5:
                    khachSan.tinhTongSoLuongTungLoai();
                    break;
                    
                case 6:
                    khachSan.tinhTrungBinhThanhTienThang9_2013();
                    break;
                    
                case 7:
                    System.out.println("\n=== TỔNG HỢP THÔNG TIN ===");
                    System.out.println("Tổng hóa đơn theo giờ: " + khachSan.getSoLuongHDGio());
                    System.out.println("Tổng hóa đơn theo ngày: " + khachSan.getSoLuongHDNgay());
                    System.out.println("Tổng cộng: " + (khachSan.getSoLuongHDGio() + khachSan.getSoLuongHDNgay()));
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng hóa đơn: " + 
                        (khachSan.getSoLuongHDGio() + khachSan.getSoLuongHDNgay()));
                    System.out.println("══════════════════════════════════════════");
                    break;
            }
            
        } while (chon != 0);
    }
}
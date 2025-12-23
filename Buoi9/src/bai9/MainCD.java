package bai9;

import java.util.Scanner;

public class MainCD {
    public static void main(String[] args) {
        QuanLyCD qlcd = new QuanLyCD(50); // Tối đa 50 CD
        XuLyCD xl = new XuLyCD(qlcd);
        Scanner sc = new Scanner(System.in);
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        QUẢN LÝ ALBUM CD - MENU CHÍNH");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Thêm CD mới");
            System.out.println("2. Xem danh sách CD");
            System.out.println("3. Tính tổng số lượng CD");
            System.out.println("4. Tính tổng giá thành");
            System.out.println("5. Sắp xếp giảm dần theo giá thành");
            System.out.println("6. Sắp xếp tăng dần theo tựa CD");
            System.out.println("7. Tìm kiếm CD theo mã");
            System.out.println("8. Xóa CD theo mã");
            System.out.println("9. Xem thông tin chi tiết CD");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            
            chon = xl.nhapLuaChon(0, 9);
            
            switch (chon) {
                case 1:
                    themCDMoi(qlcd, xl);
                    break;
                    
                case 2:
                    qlcd.xuatDanhSachDonGian();
                    break;
                    
                case 3:
                    System.out.println("\n=== TỔNG SỐ LƯỢNG CD ===");
                    System.out.println("Số lượng CD hiện có: " + qlcd.tinhSoLuongCD());
                    System.out.println("Kích thước tối đa: " + qlcd.getMaxSize());
                    break;
                    
                case 4:
                    System.out.println("\n=== TỔNG GIÁ THÀNH ===");
                    System.out.printf("Tổng giá thành: %,15.0f VNĐ\n", qlcd.tinhTongGiaThanh());
                    if (qlcd.tinhSoLuongCD() > 0) {
                        System.out.printf("Giá trung bình: %,15.0f VNĐ/CD\n", 
                            qlcd.tinhTongGiaThanh() / qlcd.tinhSoLuongCD());
                    }
                    break;
                    
                case 5:
                    qlcd.sapXepGiamDanTheoGia();
                    System.out.println("\n✓ Đã sắp xếp giảm dần theo giá thành!");
                    qlcd.xuatDanhSachDonGian();
                    break;
                    
                case 6:
                    qlcd.sapXepTangDanTheoTuaCD();
                    System.out.println("\n✓ Đã sắp xếp tăng dần theo tựa CD!");
                    qlcd.xuatDanhSachDonGian();
                    break;
                    
                case 7:
                    timKiemCD(qlcd, xl);
                    break;
                    
                case 8:
                    xoaCD(qlcd, xl);
                    break;
                    
                case 9:
                    xemChiTietCD(qlcd, xl);
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng số CD: " + qlcd.tinhSoLuongCD());
                    System.out.println("     Tổng giá trị: " + String.format("%,.0f", qlcd.tinhTongGiaThanh()) + " VNĐ");
                    System.out.println("══════════════════════════════════════════");
                    break;
            }
            
        } while (chon != 0);
    }
    
    private static void themCDMoi(QuanLyCD qlcd, XuLyCD xl) {
        if (qlcd.isDanhSachDay()) {
            System.out.println("\n⚠ Danh sách CD đã đầy! Không thể thêm mới.");
            return;
        }
        
        CD cd = xl.nhapCD();
        if (qlcd.themCD(cd)) {
            System.out.println("\n✓ Đã thêm CD thành công!");
        }
    }
    
    private static void timKiemCD(QuanLyCD qlcd, XuLyCD xl) {
        if (qlcd.tinhSoLuongCD() == 0) {
            System.out.println("\nDanh sách CD trống!");
            return;
        }
        
        int maCD = xl.nhapSoNguyen("Nhập mã CD cần tìm: ");
        CD cd = qlcd.timKiemTheoMa(maCD);
        
        if (cd != null) {
            System.out.println("\n=== THÔNG TIN CD TÌM THẤY ===");
            System.out.println(cd.toStringDep());
        } else {
            System.out.println("\nKhông tìm thấy CD với mã: " + maCD);
        }
    }
    
    private static void xoaCD(QuanLyCD qlcd, XuLyCD xl) {
        if (qlcd.tinhSoLuongCD() == 0) {
            System.out.println("\nDanh sách CD trống!");
            return;
        }
        
        int maCD = xl.nhapSoNguyen("Nhập mã CD cần xóa: ");
        
        System.out.print("Bạn có chắc chắn muốn xóa CD này? (y/n): ");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            if (qlcd.xoaCDTheoMa(maCD)) {
                System.out.println("✓ Đã xóa CD có mã: " + maCD);
            } else {
                System.out.println("Không tìm thấy CD với mã: " + maCD);
            }
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }
    
    private static void xemChiTietCD(QuanLyCD qlcd, XuLyCD xl) {
        if (qlcd.tinhSoLuongCD() == 0) {
            System.out.println("\nDanh sách CD trống!");
            return;
        }
        
        int stt = xl.nhapSoNguyen("Nhập số thứ tự CD (1-" + qlcd.tinhSoLuongCD() + "): ");
        if (stt >= 1 && stt <= qlcd.tinhSoLuongCD()) {
            CD cd = qlcd.getDanhSachCD().get(stt - 1);
            System.out.println(cd.toStringDep());
        } else {
            System.out.println("Số thứ tự không hợp lệ!");
        }
    }
}
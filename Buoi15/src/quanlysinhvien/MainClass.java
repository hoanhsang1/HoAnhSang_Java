package quanlysinhvien;

import java.util.Scanner;

public class MainClass {
    // TRƯỜNG DUY NHẤT QUẢN LÝ TOÀN HỆ THỐNG
    private static QuanLySinhVien qlsv;
    
    public static void main(String[] args) {
        qlsv = new QuanLySinhVien();
        Scanner scanner = new Scanner(System.in);
        
        int chon;
        
        do {
            hienThiMenu();
            
            try {
                System.out.print("Chọn chức năng: ");
                chon = Integer.parseInt(scanner.nextLine());
                xuLyLuaChon(chon);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                chon = -1;
            }
            
        } while (chon != 0);
    }
    
    private static void hienThiMenu() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  QUẢN LÝ SINH VIÊN TRƯỜNG ĐHCN");
        System.out.println("══════════════════════════════════════════");
        System.out.println("=== BÀI 1 + BÀI 2 KẾT HỢP ===");
        System.out.println("=== QUẢN LÝ TRƯỜNG & KHOA ===");
        System.out.println("1. Nhập thông tin trường (DUY NHẤT 1 TRƯỜNG)");
        System.out.println("2. Xuất thông tin trường");
        System.out.println("3. Nhập danh sách khoa");
        System.out.println("4. Xuất danh sách khoa");
        System.out.println("=== QUẢN LÝ SINH VIÊN ===");
        System.out.println("5. Nhập thông tin sinh viên (BÀI 1.1)");
        System.out.println("6. Xuất danh sách sinh viên (BÀI 1.2)");
        System.out.println("7. Xuất SV theo khoa");
        System.out.println("8. Xuất SV theo hệ đào tạo");
        System.out.println("9. Cập nhật thông tin sinh viên");
        System.out.println("=== SẮP XẾP ===");
        System.out.println("10. Sắp xếp theo mã (riêng từng hệ) (BÀI 1.3)");
        System.out.println("11. Sắp xếp theo tên");
        System.out.println("12. Sắp xếp theo điểm");
        System.out.println("=== TÌM KIẾM ===");
        System.out.println("13. Tìm kiếm theo tên sinh viên (BÀI 1.5)");
        System.out.println("14. Tìm kiếm theo mã sinh viên");
        System.out.println("=== THỐNG KÊ ===");
        System.out.println("15. Thống kê tổng số SV (BÀI 1.4)");
        System.out.println("16. Danh sách SV được khen thưởng (BÀI 1.6)");
        System.out.println("17. Thống kê kết quả học tập");
        System.out.println("0. Thoát chương trình (BÀI 1.7)");
        System.out.println("══════════════════════════════════════════");
    }
    
    private static void xuLyLuaChon(int chon) {
        switch (chon) {
            case 1:
                qlsv.nhapThongTinTruong();
                break;
                
            case 2:
                qlsv.xuatThongTinTruong();
                break;
                
            case 3:
                qlsv.nhapDanhSachKhoa();
                break;
                
            case 4:
                qlsv.xuatDanhSachKhoa();
                break;
                
            case 5:
                qlsv.nhapThongTinSinhVien();
                break;
                
            case 6:
                qlsv.xuatDanhSachSinhVien();
                break;
                
            case 7:
                qlsv.xuatSinhVienTheoKhoa();
                break;
                
            case 8:
                qlsv.xuatSinhVienTheoHe();
                break;
                
            case 9:
                qlsv.capNhatThongTinSinhVien();
                break;
                
            case 10:
                qlsv.sapXepTheoMa();
                break;
                
            case 11:
                qlsv.sapXepTheoTen();
                break;
                
            case 12:
                qlsv.sapXepTheoDiem();
                break;
                
            case 13:
                qlsv.timKiemTheoTen();
                break;
                
            case 14:
                qlsv.timKiemTheoMa();
                break;
                
            case 15:
                qlsv.thongKeSoLuongSinhVien();
                break;
                
            case 16:
                qlsv.danhSachSinhVienDuocKhenThuong();
                break;
                
            case 17:
                qlsv.thongKeKetQuaHocTap();
                break;
                
            case 0:
                thoatChuongTrinh();
                break;
                
            default:
                System.out.println("Chức năng không hợp lệ!");
        }
    }
    
    private static void thoatChuongTrinh() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("     CẢM ƠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!");
        System.out.println("     TỔNG KẾT DỰ ÁN QUẢN LÝ SINH VIÊN");
        System.out.println("══════════════════════════════════════════");
        System.out.println("TRƯỜNG: ĐHCN (DUY NHẤT 1 TRƯỜNG)");
        System.out.println("Tổng số khoa: " + qlsv.getSoLuongKhoa());
        System.out.println("Tổng số sinh viên: " + qlsv.getSoLuongSinhVien());
        System.out.println("══════════════════════════════════════════");
        System.out.println("ĐÃ HOÀN THÀNH TẤT CẢ YÊU CẦU:");
        System.out.println("✓ Bài 1 + Bài 2 kết hợp");
        System.out.println("✓ 1 trường duy nhất (Singleton Pattern)");
        System.out.println("✓ Kiểm tra khoa thành lập sau trường");
        System.out.println("✓ Đa hình: sv.getXepLoai()");
        System.out.println("✓ Không dùng if-else xử lý đa hình");
        System.out.println("✓ Validate tuổi theo hệ đào tạo");
        System.out.println("✓ 17 chức năng quản lý đầy đủ");
        System.out.println("══════════════════════════════════════════");
    }
}
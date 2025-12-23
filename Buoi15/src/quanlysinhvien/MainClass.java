package quanlysinhvien;

public class MainClass {
    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("  QUẢN LÝ SINH VIÊN ĐHCN - MENU CHÍNH");
            System.out.println("══════════════════════════════════════════");
            System.out.println("=== QUẢN LÝ TRƯỜNG ===");
            System.out.println("1. Nhập thông tin trường");
            System.out.println("2. Xuất danh sách trường");
            System.out.println("3. Chọn trường hiện tại");
            System.out.println("=== QUẢN LÝ KHOA ===");
            System.out.println("4. Nhập danh sách khoa");
            System.out.println("5. Xuất danh sách khoa");
            System.out.println("=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("6. Nhập thông tin sinh viên");
            System.out.println("7. Xuất danh sách sinh viên");
            System.out.println("8. Sắp xếp theo mã (riêng từng hệ)");
            System.out.println("9. Tìm kiếm theo tên sinh viên");
            System.out.println("=== THỐNG KÊ ===");
            System.out.println("10. Thống kê tổng số sinh viên");
            System.out.println("11. Danh sách sinh viên được khen thưởng");
            System.out.println("12. Thống kê kết quả học tập");
            System.out.println("13. Thống kê theo trường");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            
            chon = TaomoiTV.Test.inputIntInRange("Chọn chức năng: ", 0, 13);
            
            switch (chon) {
                case 1:
                    qlsv.nhapThongTinTruong();
                    break;
                    
                case 2:
                    qlsv.xuatDanhSachTruong();
                    break;
                    
                case 3:
                    qlsv.chonTruongHienTai();
                    break;
                    
                case 4:
                    qlsv.nhapDanhSachKhoa();
                    break;
                    
                case 5:
                    qlsv.xuatDanhSachKhoa();
                    break;
                    
                case 6:
                    qlsv.nhapThongTinSinhVien();
                    break;
                    
                case 7:
                    qlsv.xuatDanhSachSinhVien();
                    break;
                    
                case 8:
                    qlsv.sapXepTheoMa();
                    break;
                    
                case 9:
                    qlsv.timKiemTheoTen();
                    break;
                    
                case 10:
                    qlsv.thongKeSoLuongSinhVien();
                    break;
                    
                case 11:
                    qlsv.danhSachSinhVienDuocKhenThuong();
                    break;
                    
                case 12:
                    qlsv.thongKeKetQuaHocTap();
                    break;
                    
                case 13:
                    qlsv.thongKeTheoTruong();
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng số trường: " + qlsv.getSoLuongTruong());
                    System.out.println("     Tổng số khoa: " + qlsv.getSoLuongKhoa());
                    System.out.println("     Tổng số sinh viên: " + qlsv.getSoLuongSinhVien());
                    System.out.println("══════════════════════════════════════════");
                    break;
            }
            
        } while (chon != 0);
    }
}
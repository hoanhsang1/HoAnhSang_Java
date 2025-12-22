package bai1;

import java.util.Scanner;

public class Menu {
    private XuLy xuLy;
    private Scanner scanner;
    
    public Menu() {
        xuLy = new XuLy();
        scanner = new Scanner(System.in);
    }
    
    public void hienThiMenu() {
        int choice;
        
        // Thêm dữ liệu mẫu để test
//        xuLy.themDuLieuMau();
        
        do {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("    QUẢN LÝ SINH VIÊN TRƯỜNG ĐHCN    ");
            System.out.println("=".repeat(60));
            System.out.println("1. Nhập thông tin 1 sinh viên");
            System.out.println("2. Nhập danh sách nhiều sinh viên");
            System.out.println("3. Xuất thông tin dạng bảng");
            System.out.println("4. Xuất thông tin chi tiết");
            System.out.println("5. Sắp xếp theo mã (riêng từng hệ)");
            System.out.println("6. Thống kê tổng số sinh viên");
            System.out.println("7. Tìm kiếm theo tên");
            System.out.println("8. In sinh viên được thưởng dạng bảng");
            System.out.println("9. Thoát chương trình");
            System.out.println("-".repeat(60));
            System.out.print("Chọn chức năng (1-9): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            
            switch (choice) {
                case 1:
                    xuLy.nhapThongTinSV();
                    break;
                case 2:
                    xuLy.nhapThongTinDSSV();
                    break;
                case 3:
                    xuLy.xuatThongTinBang();
                    break;
                case 4:
                    xuLy.xuatThongTinChiTiet();
                    break;
                case 5:
                    xuLy.sapXepTheoMa();
                    System.out.println("Đã sắp xếp xong. Chọn chức năng 3 để xem kết quả!");
                    break;
                case 6:
                    xuLy.thongKeSV();
                    break;
                case 7:
                    System.out.print("Nhập tên cần tìm: ");
                    String ten = scanner.nextLine();
                    xuLy.timKiemTheoTen(ten);
                    break;
                case 8:
                    xuLy.inSVDuocThuongBang();
                    break;
                case 9:
                    System.out.println("\n" + "=".repeat(60));
                    System.out.println("    CẢM ƠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!    ");
                    System.out.println("=".repeat(60));
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
            
            if (choice != 9) {
                System.out.print("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        } while (choice != 9);
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.hienThiMenu();
    }
}
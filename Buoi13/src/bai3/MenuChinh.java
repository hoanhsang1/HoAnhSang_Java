package bai3;

import TaomoiTV.Test;

public class MenuChinh {
    
    public static void main(String[] args) {
        // Khởi tạo đối tượng xử lý
        Xuly quanLy = new Xuly();
        int luaChon;

        do {
            // === HIỂN THỊ MENU CHỨC NĂNG ===
            System.out.println("\n================ MENU QUẢN LÝ TÀI KHOẢN NGÂN HÀNG ================");
            System.out.println("1. Nhập danh sách tài khoản (Account/Savings/TermDeposit/Overdraft)");
            System.out.println("2. Xuất (Hiển thị) toàn bộ danh sách tài khoản");
            System.out.println("3. Thực hiện Giao dịch (Gửi/Rút tiền)");
            System.out.println("4. Cộng lãi suất cho các Tài khoản Tiết kiệm và Kỳ hạn");
            System.out.println("5. Thoát chương trình");
            System.out.println("===================================================================");

            // Hàm thư viện: Test.inputIntInRange(msg, min, max)
            luaChon = Test.inputIntInRange(">> Nhập lựa chọn của bạn (1-5): ", 1, 5);

            switch (luaChon) {
                case 1:
                    quanLy.nhapDanhSach();
                    break;
                case 2:
                    quanLy.xuatDanhSach();
                    break;
                case 3:
                    quanLy.thucHienGiaoDich();
                    break;
                case 4:
                    quanLy.congLaiChoTaiKhoanTietKiem();
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc. Hẹn gặp lại!");
                    break;
            }
        } while (luaChon != 5);
    }
}
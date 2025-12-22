package bai3; // Đổi lại package thành chữ thường 'bai3' cho đồng bộ

import TaomoiTV.Test;

public class OverdraftAccount extends Account {
    protected double odLimit; // Hạn mức thấu chi
    protected double overdraft; // Số tiền thấu chi đang sử dụng
    // availableBalance có thể được tính toán qua getter, không cần lưu trữ làm field
    
    // ... (Các Constructor giữ nguyên)

    // === GHI ĐÈ PHƯƠNG THỨC NHẬP ===
    @Override
    public void nhap() {
        super.nhap(); // Nhập ID và Balance cơ bản
        System.out.println("--- NHẬP THÔNG TIN TÀI KHOẢN THẤU CHI ---");
        
        // Nhập Hạn mức thấu chi (odLimit). Phải là số dương
        double limit;
        do {
            // Hàm thư viện: Test.inputDouble(msg) (kiểm tra > 0)
            limit = Test.inputDouble("  Nhập Hạn mức thấu chi (Limit > 0): ");
            if (limit <= 0) System.out.println("  Lỗi: Hạn mức phải là số dương. Nhập lại.");
        } while (limit <= 0);
        this.odLimit = limit;
        
        // Cập nhật overdraft và availableBalance sau khi nhập xong (nếu cần)
        if (this.balance < 0) {
            this.overdraft = -this.balance;
        } else {
            this.overdraft = 0;
        }
    }
    
    // === GHI ĐÈ PHƯƠNG THỨC RÚT TIỀN (Giữ nguyên logic chính xác của bạn) ===
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= (this.balance + this.odLimit)) {
            this.balance -= amount;
            
            if (this.balance < 0) {
                this.overdraft = -this.balance;
            } else {
                this.overdraft = 0;
            }
            
            // Thông báo kết quả
            System.out.printf("  Rút tiền thành công. Số dư hiện tại: %,.2f VND\n", this.balance);
            return true;
        } else {
             System.out.printf("Rút tiền thất bại. Số dư khả dụng (%,.2f VND) không đủ.\n", getAvailableBalance());
             return false;
        }
    }

    // === GHI ĐÈ PHƯƠNG THỨC XUẤT ===
    @Override
    public void xuat() {
        super.xuat(); // Gọi hàm xuat của lớp cha
        System.out.printf("Loại TK: Thấu chi (Overdraft)\n");
        System.out.printf("Hạn mức Thấu chi (Limit): %,.2f VND\n", this.odLimit);
        System.out.printf("Số tiền đã thấu chi (Overdraft Used): %,.2f VND\n", this.overdraft);
        System.out.printf("Số dư Khả dụng: %,.2f VND\n", getAvailableBalance()); 
        System.out.println("-----------------------------------");
    }
    
    
    public double getAvailableBalance() {
        return this.balance + this.odLimit;
    }
}
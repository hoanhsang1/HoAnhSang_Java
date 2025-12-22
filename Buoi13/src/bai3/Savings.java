package bai3;
import TaomoiTV.Test; // Import thư viện nhập liệu của bạn
public class Savings extends Account {
   protected double intRate; // Tỷ lệ lãi suất
   // Constructor giữ nguyên
   public Savings() {
       super();
       this.intRate = 0.0;
   }
   // Constructor giữ nguyên
   public Savings(String acct_id, double balance, double intRate) {
       // Gọi constructor của lớp cha
       super(acct_id, balance);
       this.intRate = intRate;
   }
   // === GHI ĐÈ PHƯƠNG THỨC NHẬP ===
   @Override
   public void nhap() {
       super.nhap(); // Nhập ID và Balance cơ bản
       System.out.println("--- NHẬP THÔNG TIN TÀI KHOẢN TIẾT KIỆM ---");
      
       // Nhập Lãi suất (intRate). Phải là số dương
       // Hàm thư viện: Test.inputPositiveDouble(msg) (Nên dùng nếu đã sửa Test.java)
       double rate;
       do {
           rate = Test.inputDouble("  Nhập Lãi suất hàng năm (intRate > 0): ");
           if (rate <= 0) System.out.println("  Lỗi: Lãi suất phải là số dương. Nhập lại.");
       } while (rate <= 0);
       this.intRate = rate;
   }
  
   // === PHƯƠNG THỨC NGHIỆP VỤ ===
  
   // Tính tiền lãi
   public double calculateInterest() {
       // Giả định intRate là lãi suất hàng năm, cần chia cho 100 nếu nhập theo phần trăm
       return this.balance * this.intRate;
   }
   // Cộng lãi vào số dư
   public void addInterestToBalance() {
       double interest = calculateInterest();
       this.balance += interest; // Cộng lãi vào số dư
       System.out.printf("  Đã cộng lãi %.2f VND. Số dư mới: %.2f\n", interest, this.balance);
   }
   // === GETTERS / SETTERS ===
   public double getIntRate() { return this.intRate; } //
   public void setIntRate(double intRate) { this.intRate = intRate; } //
   // Hàm này tương đương getIntAmount() trong sơ đồ UML
   public double getInterestAmount() { return calculateInterest(); }
   // === PHƯƠNG THỨC XUẤT ===
   @Override
   public void xuat() {
       // Gọi hàm xuat của lớp cha để in thông tin cơ bản
       super.xuat();
       System.out.printf("Loại TK: Tiết kiệm\n");
       System.out.printf("Lãi suất (Rate): %.4f\n", this.intRate);
       System.out.printf("Tiền lãi dự kiến: %,.2f VND\n", calculateInterest());
       System.out.println("-----------------------------------");
   }
}


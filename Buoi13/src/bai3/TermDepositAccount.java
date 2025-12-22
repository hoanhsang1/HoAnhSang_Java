package bai3;
import TaomoiTV.Test;
// Kế thừa từ Savings (theo UML)
public class TermDepositAccount extends Savings {
   protected int term; // Kỳ hạn (tháng)
   public TermDepositAccount() {
       super();
       this.term = 0;
   }
   // Constructor giữ nguyên
   public TermDepositAccount(String acct_id, double balance, double intRate, int term) {
       super(acct_id, balance, intRate);
       this.term = term;
   }
  
   // === GHI ĐÈ PHƯƠNG THỨC NHẬP ===
   @Override
   public void nhap() {
       // Gọi hàm nhap() của Savings (nhập ID, Balance, intRate)
       super.nhap();
       System.out.println("--- NHẬP THÔNG TIN TÀI KHOẢN KỲ HẠN ---");
      
       // Nhập Kỳ hạn (term). Phải là số nguyên dương
       // Hàm thư viện: Test.inputPositiveInt(msg)
       this.term = Test.inputPositiveInt("  Nhập Kỳ hạn gửi (tháng): ");
   }
   // === GHI ĐÈ PHƯƠNG THỨC RÚT TIỀN (NGHIỆP VỤ ĐẶC TRƯNG) ===
   @Override
   public boolean withdraw(double amount) {
       // Tài khoản có kỳ hạn thường không cho rút trước hạn
       System.out.println("Lỗi: Tài khoản có kỳ hạn không cho phép rút tiền trước khi đáo hạn.");
       return false;
   }
   // === GHI ĐÈ PHƯƠNG THỨC CỘNG LÃI (Cần thiết nếu logic tính lãi khác Savings) ===
   // Giữ nguyên logic của Savings, hoặc có thể ghi đè nếu lãi suất thay đổi theo kỳ hạn.
   // Tạm thời giữ nguyên.
   // === GHI ĐÈ PHƯƠNG THỨC XUẤT ===
   @Override
   public void xuat() {
       // Gọi hàm xuat() của lớp cha (Savings)
       super.xuat();
       // Ghi đè lại một số thông tin
       System.out.printf("Loại TK: Tiền gửi có Kỳ hạn\n");
       System.out.printf("Kỳ hạn gửi: %d tháng\n", this.term);
       System.out.println("-----------------------------------");
   }
   // === GETTERS / SETTERS ===
   public int getTerm() { return term; } //
   public void setTerm(int term) { this.term = term; } //
}



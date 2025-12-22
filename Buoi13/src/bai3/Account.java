package bai3;
import TaomoiTV.Test;
public class Account {
	protected double balance;
	protected String acct_id;
	
	public Account () {};
	public Account(String id) {
		this.acct_id = id;
		this.balance = 0;
	}
	
	public Account(String acct_id2, double balance2) {
		// TODO Auto-generated constructor stub
	}
	public void setAcct_id(String id) {this.acct_id = id;}
	
	public String getAcct_id() {return this.acct_id;}
	public double getBalance() {return this.balance;}
	
	public boolean deposit(double aMount) {
   if (aMount <= 0) {
       System.out.println("Lỗi: Số tiền gửi phải lớn hơn 0.");
       return false;
   }
   this.balance += aMount; // GỬI LÀ CỘNG
   return true;
}
// === HÀM RÚT TIỀN (WITHDRAW) ===
// Rút tiền: Phải trừ đi số tiền và kiểm tra đủ số dư
public boolean withdraw(double aMount) {
   if (aMount <= 0) {
       System.out.println("Lỗi: Số tiền rút phải lớn hơn 0.");
       return false;
   }
   if (aMount > balance) {
       // Tài khoản cơ bản không hỗ trợ thấu chi
       System.out.println("Rút tiền thất bại: Số dư không đủ.");
       return false;
   } else {
       this.balance -= aMount; // RÚT LÀ TRỪ
       return true;
   }
}




	
	@Override
	public String toString() {
		return String.format("ACC|%s|%.2f", acct_id,balance);
	}


	// Thêm Setter cho Balance
public void setBalance(double balance) {this.balance = balance;}
// Hàm Nhập liệu
public void nhap() {
   System.out.println("--- NHẬP THÔNG TIN ACCOUNT CƠ BẢN ---");
   // Hàm thư viện: Test.inputNonEmptyString(msg)
   this.acct_id = Test.inputNonEmptyString("  Nhập ID/Số tài khoản: ");
  
   // Hàm thư viện: Test.inputDouble(msg) (và kiểm tra >= 0)
   double initialBalance = 0;
   do {
       initialBalance = Test.inputDouble("  Nhập Số dư ban đầu (>= 0): ");
   } while (initialBalance < 0);
   this.balance = initialBalance;
}
// Hàm Xuất chi tiết
public void xuat() {
   System.out.println("\n--- THÔNG TIN TÀI KHOẢN ---");
   System.out.printf("Loại TK: Cơ bản\n");
   System.out.printf("ID TK: %s\n", this.acct_id);
   System.out.printf("Số dư: %,.2f VND\n", this.balance);
}


}




	

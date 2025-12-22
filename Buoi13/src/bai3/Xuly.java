package bai3;

import java.util.ArrayList;
import java.util.List;
import TaomoiTV.Test; // BẮT BUỘC dùng thư viện này để kiểm lỗi nhập liệu

public class Xuly {
    // Thay đổi từ ArrayList sang List và đặt tên chuẩn hơn
    private List<Account> danhSachTaiKhoan = new ArrayList<>();
	
    // Hàm tìm tài khoản (giữ nguyên từ phân tích trước)
    private Account findAccount(String acctId) {
        for (Account acc : danhSachTaiKhoan) {
            if (acc.getAcct_id().equalsIgnoreCase(acctId)) {
                return acc;
            }
        }
        return null;
    }
    
    // --- CHỨC NĂNG 1: NHẬP DANH SÁCH HỖN HỢP (Tên chuẩn hơn: nhapDanhSach) ---
	public void nhapDanhSach() {
        // Hàm thư viện: Test.inputPositiveInt(msg)
		int soLuong = Test.inputPositiveInt("Nhập số lượng tài khoản muốn thêm: "); 
		
		for (int i = 0; i < soLuong; i++) {
			System.out.println("\n--- NHẬP TK THỨ " + (i + 1) + " ---");
			System.out.println("1. Tài khoản Cơ bản (Account)");
			System.out.println("2. Tài khoản Tiết kiệm (Savings)"); // Đã có
            System.out.println("3. Tài khoản Kỳ hạn (TermDepositAccount)"); // Đã có
			// 4. Tài khoản Thấu chi (OverdraftAccount) - Sẽ thêm sau

            // Hàm thư viện: Test.inputIntInRange(msg, min, max)
			int luaChon = Test.inputIntInRange("Chọn loại tài khoản (1-3): ", 1, 3);
			
			Account accMoi = null;
			if (luaChon == 1) {
                accMoi = new Account();
			} else if (luaChon == 2) {
                // Sửa tên lớp thành Savings
				accMoi = new Savings(); 
			} else if (luaChon == 3) {
                accMoi = new TermDepositAccount();
            } 
            // else if (luaChon == 4) { accMoi = new OverdraftAccount(); } 
			
            // GỌI HÀM NHAP() CỦA LỚP CON (Đa hình)
            accMoi.nhap(); 
            
            // Kiểm tra duy nhất ID (nên làm trong lớp XuLy)
            if (findAccount(accMoi.getAcct_id()) != null) {
                System.out.println("ID tài khoản đã tồn tại. Thêm thất bại.");
                // Quay lại bước trước (có thể dùng cờ hoặc vòng lặp do-while bên ngoài)
                i--; 
                continue; 
            }
            
            this.danhSachTaiKhoan.add(accMoi);
		}
	}
    
    // --- CHỨC NĂNG 2: XUẤT DANH SÁCH ---
    public void xuatDanhSach() {
        // ... (Code đã có từ phân tích trước, gọi acc.xuat())
        if (danhSachTaiKhoan.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.println("\n================ DANH SÁCH TÀI KHOẢN ===============");
        for (Account acc : danhSachTaiKhoan) {
            acc.xuat(); 
        }
        System.out.println("====================================================");
    }
    
    // --- CHỨC NĂNG 3: THỰC HIỆN GIAO DỊCH (GỬI/RÚT) ---
    public void thucHienGiaoDich() {
        // ... (Code đã có từ phân tích trước, gọi acc.deposit/withdraw)
        String idTim = Test.inputNonEmptyString("Nhập ID tài khoản cần giao dịch: ");
        Account acc = findAccount(idTim);
        
        if (acc == null) {
            System.out.println("Không tìm thấy tài khoản có ID: " + idTim);
            return;
        }
        
        int loaiGiaoDich = Test.inputIntInRange("Chọn giao dịch (1-Gửi tiền, 2-Rút tiền): ", 1, 2); 
        double amount = 0;
        do {
            amount = Test.inputDouble("Nhập số tiền giao dịch (> 0): ");
            if (amount <= 0) System.out.println("Số tiền phải lớn hơn 0.");
        } while (amount <= 0);

        if (loaiGiaoDich == 1) {
            acc.deposit(amount);
        } else if (loaiGiaoDich == 2) {
            if (acc.withdraw(amount)) {
                 System.out.printf("Rút tiền thành công. Số dư mới: %.2f\n", acc.getBalance());
            } else {
                 // Nếu withdraw trả về false, thông báo lỗi đã được in trong Account/Savings/TermDeposit
            }
        }
    }
    
    // --- CHỨC NĂNG 4: CỘNG LÃI CHO TÀI KHOẢN TIẾT KIỆM VÀ KỲ HẠN ---
    public void congLaiChoTaiKhoanTietKiem() {
        int soTKDuocCongLai = 0;
        for (Account acc : danhSachTaiKhoan) {
            // Cả Savings và TermDepositAccount đều kế thừa Savings, nên đều có hàm addInterestToBalance()
            if (acc instanceof Savings) {
                // Ép kiểu về lớp Savings (hoặc TermDepositAccount) để gọi hàm riêng
                Savings savingsAcc = (Savings) acc; 
                savingsAcc.addInterestToBalance(); 
                soTKDuocCongLai++;
            }
        }
        System.out.println("\nĐã cộng lãi cho " + soTKDuocCongLai + " tài khoản tiết kiệm và kỳ hạn.");
    }
    
 // Sửa đổi trong file XuLy.java của bạn (package bai3)

    public void nhapDanhSach1() {
        int soLuong = Test.inputPositiveInt("Nhập số lượng tài khoản muốn thêm: "); 

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- NHẬP TK THỨ " + (i + 1) + " ---");
            System.out.println("1. Tài khoản Cơ bản (Account)");
            System.out.println("2. Tài khoản Tiết kiệm (Savings)"); 
            System.out.println("3. Tài khoản Kỳ hạn (TermDepositAccount)");
            System.out.println("4. Tài khoản Thấu chi (OverdraftAccount)"); // <-- Đã thêm

            // Cập nhật phạm vi lựa chọn: 1-4
            // Hàm thư viện: Test.inputIntInRange(msg, min, max)
            int luaChon = Test.inputIntInRange("Chọn loại tài khoản (1-4): ", 1, 4); 

            Account accMoi = null;
            if (luaChon == 1) {
                accMoi = new Account();
            } else if (luaChon == 2) {
                accMoi = new Savings(); 
            } else if (luaChon == 3) {
                accMoi = new TermDepositAccount();
            } else if (luaChon == 4) { 
                // KHỞI TẠO LỚP OVERDRAFTACCOUNT MỚI
                accMoi = new OverdraftAccount(); 
            }
            
            // Gọi hàm nhap() đã được ghi đè (Đa hình)
            accMoi.nhap(); 
            
            // Kiểm tra ID duy nhất (giữ nguyên logic đã có)
            if (findAccount(accMoi.getAcct_id()) != null) {
                System.out.println("ID tài khoản đã tồn tại. Thêm thất bại.");
                i--; 
                continue; 
            }
            
            this.danhSachTaiKhoan.add(accMoi);
        }
    }
}
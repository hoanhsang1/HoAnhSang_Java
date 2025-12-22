package bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class manageAcc {
	ArrayList<Account> AccS = new ArrayList<Account>();
	static Scanner sc = new Scanner(System.in);
	
	public ArrayList<Account> taoDS() {
		//int n = //nhập số nguyên;
		
		for (int i=0;i<n;i++) {
			System.out.println("Nhập thông tin của tài khoản thứ "+i);
			System.out.println("Nhập mã của account");
			String acct_id = sc.nextLine(); // thên hàm kiểm tra duy nhất
			
			System.out.println("Nhập số 1 nếu muốn tạo tài khoản OverdraftAccount");
			System.out.println("Nhập số 2 nếu muốn tạo tài khoản Saving");
			int a = sc.nextInt(); //thêm hàm nhập số
			while(true) {
				if (a==1 || a == 2) {
					break;
				}else {
					System.out.println("Vui lòng nhập số 1 hoặc 2");
					a = sc.nextInt(); //thêm hàm nhập số
				}
			}
			
			if (a==1) {
				System.out.println("Vui lòng nhập giới hạn của tài khoản");
				double odLimit = sc.nextDouble(); // thêm hàm nhập
				
				System.out.println("Vui lòng nhập số tiền thấu chi");
				double overdraft = sc.nextDouble(); // thêm hàm nhập
				OverdraftAccount acc = new OverdraftAccount(acct_id,odLimit,overdraft);
				AccS.add(acc);
			}else {
				Saving acc = new Saving();
				AccS.add(acc);
			}
		}
				
	}
}

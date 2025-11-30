package bai2;
import bai1.Xulycau1;

import java.util.Scanner;

import bai1.Xulycau1;

public class MainProgramCau2 {
	public static void main(String[] args) {
		Xulycau2 xl2 = new Xulycau2();
		Xulycau1 xl1 = new Xulycau1();
				
		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		
		System.out.print("Chọn câu muốn chạy: ");
		int cau2 = xl1.inputINT();
		
		switch (cau2) {
			case 1:
				System.out.println("Nhập mảng số nguyên");
				int [] result = xl1.inputList();
				break;
			case 2:
				System.out.println("Xuất mảng số nguyên");
				int [] n = xl1.inputList();
				System.out.println("Danh của bạn là: ");
				for (int i = 0; i<n.length;i++) {
					System.out.print(n[i]);
				}
				break;
			case 3:
		}
				
	}
}

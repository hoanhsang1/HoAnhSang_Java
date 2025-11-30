package bai1;
import java.util.Scanner;
public class Mainprogram {

	public static void main(String[] args) {
		Scanner inform = new Scanner(System.in);
		Xulycau1 xl1 = new Xulycau1();
				
		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		int chon;
		do {
	            System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
	            System.out.println("1. Viết chương trình in ra tổng của từ 0 đền n, số chẵn đầu (sử dụng vòng lặp for hoặc while)");
	            System.out.println("2. Viết chương trình in ra những số lẻ từ a đến b.");
	            System.out.println("3. Viết chương trình xuất ra tổng các số là bội số của x (từ a đến b, a>b)");
	            System.out.println("4. Viết chương trình in ra tổng a+(a+1)+(a+2)....+b với a,b được nhập từ tham số command line");
	            System.out.println("5. Viết chương trình in ra tổng 1+3+5....+n nếu n là số chẵn, 2+4+6+....n nếu n là số lẻ. Giá trị n được nhập vào từ tham số command line");
	            System.out.println("6. Viết chương trình in ra giá trị lớn nhất và nhỏ nhất trong một dãy các giá trị user đã nhập vào từ tham số command line.");
	            System.out.println("7. Viết chương trình giải phương trình bậc 1 với hệ số a, b được nhập vào bởi user từ tham số command line.");
	            System.out.println("8. Viết chương trình đọc một giá trị nguyên từ bàn phím và in ra số đó là số chẵn, lẻ hoặc zero.");
	            System.out.println("0. Thoát");
	            chon = xl1.inputINT();
	    		switch (chon) {
	    			case 1:
	    				System.out.print("Nhập số nguyên N: ");
	    				int n = xl1.inputINT();
	    				int DAcau1 = xl1.cau1(n);
	    				System.out.println("Đáp án câu 1 là: "+DAcau1);
	    				break;
	    			case 2:
	    				xl1.cau2();
	    				break;
	    			case 3:
	    				xl1.cau3();
	    				break;
	    			case 4:
	    				xl1.cau4();
	    				break;
	    			case 5:
	    				xl1.cau5();
	    				break;
	    			case 6:
	    				xl1.cau6();
	    				break;
	    			case 7:
	    				xl1.cau7();
	    				break;
	    			case 8:
	    				xl1.cau8();
	    				break;
	    			case 0:
	    				break;
	    			default: 
	    		        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 đến 8.");
	    		        break; 
	    		}
	        } while (chon != 0);
	    
		
	}

}

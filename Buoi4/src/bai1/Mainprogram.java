package bai1;
import java.util.Scanner;

public class Mainprogram {
    public static void main(String[] args) {
        Scanner inform = new Scanner(System.in);
        Xulycau1 xl1 = new Xulycau1();
        int chon;
        
        do {
            System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
            System.out.println("1. Tính tổng từ 0 đến n và số chẵn đầu");
            System.out.println("2. In ra những số lẻ từ a đến b");
            System.out.println("3. Tổng các số là bội số của x (từ a đến b, a>b)");
            System.out.println("4. Tổng a+(a+1)+(a+2)....+b");
            System.out.println("5. Tổng 1+3+5....+n (n chẵn) hoặc 2+4+6+....n (n lẻ)");
            System.out.println("6. Tìm giá trị lớn nhất và nhỏ nhất");
            System.out.println("7. Giải phương trình bậc 1");
            System.out.println("8. Kiểm tra số chẵn/lẻ/zero");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            
            chon = xl1.inputINT();
            
            switch (chon) {
                case 1:
                    System.out.print("Nhập số nguyên N: ");
                    int n = xl1.inputINT();
                    int DAcau1 = xl1.cau1(n);
                    System.out.println("Đáp án câu 1 là: " + DAcau1);
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
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default: 
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 8.");
                    break; 
            }
        } while (chon != 0);
        
        // Đóng Scanner sau khi sử dụng
        inform.close();
    }
}
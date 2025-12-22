package bai2;
import java.util.Scanner;

public class MainProgramCau2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Xulycau2 xlMang = new Xulycau2();
        
        int chon;
        do {
            System.out.println("\n========== MENU QUẢN LÝ MẢNG SỐ NGUYÊN ==========");
            System.out.println("1. Nhập mảng số nguyên");
            System.out.println("2. Xuất mảng số nguyên");
            System.out.println("3. Sắp xếp mảng giảm dần");
            System.out.println("4. Chèn phần tử vào mảng đã sắp xếp");
            System.out.println("5. Trộn 2 mảng đã sắp xếp");
            System.out.println("6. In phần tử lớn hơn giá trị trung bình cộng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            
            // Kiểm tra lựa chọn hợp lệ
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số nguyên!");
                sc.next();
                System.out.print("Nhập lựa chọn: ");
            }
            chon = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng newline
            
            switch (chon) {
                case 1:
                    xlMang.nhapMang();
                    break;
                    
                case 2:
                    xlMang.xuatMang();
                    break;
                    
                case 3:
                    if (!xlMang.isMangInitialized()) {
                        System.out.println("Vui lòng nhập mảng trước (chọn 1)!");
                    } else {
                        xlMang.sapXepGiamDan();
                    }
                    break;
                    
                case 4:
                    if (!xlMang.isMangInitialized()) {
                        System.out.println("Vui lòng nhập mảng trước (chọn 1)!");
                    } else {
                        xlMang.chenPhanTu();
                    }
                    break;
                    
                case 5:
                    if (!xlMang.isMangInitialized()) {
                        System.out.println("Vui lòng nhập mảng trước (chọn 1)!");
                    } else {
                        xlMang.tronHaiMang();
                    }
                    break;
                    
                case 6:
                    if (!xlMang.isMangInitialized()) {
                        System.out.println("Vui lòng nhập mảng trước (chọn 1)!");
                    } else {
                        xlMang.phanTuLonHonTrungBinh();
                    }
                    break;
                    
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 6.");
                    break;
            }
        } while (chon != 0);
        
        sc.close();
    }
}
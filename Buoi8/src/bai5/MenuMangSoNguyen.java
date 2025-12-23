package bai5;

import java.util.Scanner;

public class MenuMangSoNguyen {
    public static void main(String[] args) {
        MangSoNguyen mang = new MangSoNguyen();
        Scanner sc = new Scanner(System.in);
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        THAO TÁC TRÊN MẢNG SỐ NGUYÊN");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập mảng mới");
            System.out.println("2. Xuất mảng");
            System.out.println("3. Thêm giá trị vào chỉ số i");
            System.out.println("4. Thêm giá trị vào cuối mảng");
            System.out.println("5. Xóa tại chỉ số i");
            System.out.println("6. Xóa giá trị x");
            System.out.println("7. Sắp xếp tăng dần");
            System.out.println("8. Tìm kiếm giá trị x");
            System.out.println("9. Lấy giá trị tại chỉ số i");
            System.out.println("10. Xem số phần tử");
            System.out.println("11. Ghi đè giá trị tại chỉ số i");
            System.out.println("12. Tính tổng mảng");
            System.out.println("13. Tìm giá trị lớn nhất");
            System.out.println("14. Tìm giá trị nhỏ nhất");
            System.out.println("0. Thoát");
            System.out.println("══════════════════════════════════════════");
            System.out.print("Chọn chức năng: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    mang.nhapMang();
                    break;
                    
                case 2:
                    mang.xuatMangChiSo();
                    break;
                    
                case 3:
                    try {
                        System.out.print("Nhập giá trị cần thêm: ");
                        int giaTri = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập chỉ số i: ");
                        int chiSo = Integer.parseInt(sc.nextLine());
                        mang.themTaiChiSo(giaTri, chiSo);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số hợp lệ!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Nhập giá trị cần thêm vào cuối: ");
                    try {
                        int giaTri = Integer.parseInt(sc.nextLine());
                        mang.themVaoCuoi(giaTri);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 5:
                    System.out.print("Nhập chỉ số i cần xóa: ");
                    try {
                        int chiSo = Integer.parseInt(sc.nextLine());
                        mang.xoaTaiChiSo(chiSo);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 6:
                    System.out.print("Nhập giá trị x cần xóa: ");
                    try {
                        int giaTri = Integer.parseInt(sc.nextLine());
                        mang.xoaGiaTri(giaTri);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 7:
                    mang.sapXepTang();
                    System.out.println("Mảng sau khi sắp xếp:");
                    mang.xuatMang();
                    break;
                    
                case 8:
                    System.out.print("Nhập giá trị x cần tìm: ");
                    try {
                        int giaTri = Integer.parseInt(sc.nextLine());
                        int viTri = mang.timKiem(giaTri);
                        if (viTri != -1) {
                            System.out.println("Tìm thấy " + giaTri + " tại vị trí " + viTri);
                        } else {
                            System.out.println("Không tìm thấy " + giaTri + " trong mảng!");
                        }
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 9:
                    System.out.print("Nhập chỉ số i: ");
                    try {
                        int chiSo = Integer.parseInt(sc.nextLine());
                        int giaTri = mang.layGiaTriTaiChiSo(chiSo);
                        System.out.println("Giá trị tại vị trí " + chiSo + " là: " + giaTri);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 10:
                    System.out.println("Số phần tử trong mảng: " + mang.demSoPhanTu());
                    break;
                    
                case 11:
                    try {
                        System.out.print("Nhập giá trị mới: ");
                        int giaTri = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập chỉ số i: ");
                        int chiSo = Integer.parseInt(sc.nextLine());
                        mang.ghiDeGiaTri(giaTri, chiSo);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số hợp lệ!");
                    }
                    break;
                    
                case 12:
                    System.out.println("Tổng các phần tử: " + mang.tinhTong());
                    break;
                    
                case 13:
                    try {
                        System.out.println("Giá trị lớn nhất: " + mang.timMax());
                    } catch (IllegalStateException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;
                    
                case 14:
                    try {
                        System.out.println("Giá trị nhỏ nhất: " + mang.timMin());
                    } catch (IllegalStateException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;
                    
                case 0:
                    System.out.println("\nCảm ơn đã sử dụng chương trình!");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
    }
}

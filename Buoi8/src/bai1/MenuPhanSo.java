package bai1;

import java.util.Scanner;

public class MenuPhanSo {
    public static void main(String[] args) {
        XuLyPhanSo xl = new XuLyPhanSo();
        Scanner sc = new Scanner(System.in);
        
        PhanSo ps1 = null;
        PhanSo ps2 = null;
        int chon;
        
        do {
            System.out.println("\n=== PHÉP TOÁN PHÂN SỐ ===");
            System.out.println("1. Nhập phân số 1");
            System.out.println("2. Nhập phân số 2");
            System.out.println("3. Rút gọn phân số");
            System.out.println("4. Cộng 2 phân số");
            System.out.println("5. Trừ 2 phân số");
            System.out.println("6. Nhân 2 phân số");
            System.out.println("7. Chia 2 phân số");
            System.out.println("8. Xuất phân số");
            System.out.println("9. Tìm UCLN của 2 phân số");
            System.out.println("10. Tìm BCNN của 2 phân số");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    ps1 = xl.nhapPhanSo();
                    System.out.println("Đã nhập: " + ps1.xuatPhanSo());
                    break;
                    
                case 2:
                    ps2 = xl.nhapPhanSo();
                    System.out.println("Đã nhập: " + ps2.xuatPhanSo());
                    break;
                    
                case 3:
                    if (ps1 != null) {
                        System.out.print("Phân số 1: " + ps1.xuatPhanSo());
                        ps1.rutGon();
                        System.out.println(" -> " + ps1.xuatPhanSo());
                    }
                    if (ps2 != null) {
                        System.out.print("Phân số 2: " + ps2.xuatPhanSo());
                        ps2.rutGon();
                        System.out.println(" -> " + ps2.xuatPhanSo());
                    }
                    break;
                    
                case 4:
                    if (ps1 != null && ps2 != null) {
                        PhanSo kq = ps1.cong(ps2);
                        System.out.println(ps1.xuatPhanSo() + " + " + ps2.xuatPhanSo() + 
                                         " = " + kq.xuatPhanSo());
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 5:
                    if (ps1 != null && ps2 != null) {
                        PhanSo kq = ps1.tru(ps2);
                        System.out.println(ps1.xuatPhanSo() + " - " + ps2.xuatPhanSo() + 
                                         " = " + kq.xuatPhanSo());
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 6:
                    if (ps1 != null && ps2 != null) {
                        PhanSo kq = ps1.nhan(ps2);
                        System.out.println(ps1.xuatPhanSo() + " × " + ps2.xuatPhanSo() + 
                                         " = " + kq.xuatPhanSo());
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 7:
                    if (ps1 != null && ps2 != null) {
                        if (ps2.getTuSo() == 0) {
                            System.out.println("Không thể chia cho phân số có tử = 0!");
                        } else {
                            PhanSo kq = ps1.chia(ps2);
                            System.out.println(ps1.xuatPhanSo() + " ÷ " + ps2.xuatPhanSo() + 
                                             " = " + kq.xuatPhanSo());
                        }
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 8:
                    System.out.print("Phân số 1: ");
                    if (ps1 != null) System.out.println(ps1.xuatPhanSo());
                    else System.out.println("Chưa nhập");
                    
                    System.out.print("Phân số 2: ");
                    if (ps2 != null) System.out.println(ps2.xuatPhanSo());
                    else System.out.println("Chưa nhập");
                    break;
                    
                case 9:
                    if (ps1 != null && ps2 != null) {
                        System.out.println("\n=== UCLN CỦA 2 PHÂN SỐ ===");
                        System.out.println("Phân số 1: " + ps1.xuatPhanSo());
                        System.out.println("Phân số 2: " + ps2.xuatPhanSo());
                        
                        PhanSo ucln = ps1.timUCLNPhanSo(ps2);
                        System.out.println("UCLN = " + ucln.xuatPhanSo());
                        
                        // Giải thích
                        System.out.println("UCLN(" + ps1.getTuSo() + "/" + ps1.getMauSo() + ", " 
                                          + ps2.getTuSo() + "/" + ps2.getMauSo() + ") = ");
                        System.out.println("= " + ps1.timUCLN(ps1.getTuSo(), ps2.getTuSo()) + "/" 
                                          + ps1.timUCLN(ps1.getMauSo(), ps2.getMauSo()));
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 10:
                    if (ps1 != null && ps2 != null) {
                        System.out.println("\n=== BCNN CỦA 2 PHÂN SỐ ===");
                        System.out.println("Phân số 1: " + ps1.xuatPhanSo());
                        System.out.println("Phân số 2: " + ps2.xuatPhanSo());
                        
                        PhanSo bcnn = ps1.timBCNNPhanSo(ps2);
                        System.out.println("BCNN = " + bcnn.xuatPhanSo());
                        
                        // Giải thích
                        System.out.println("BCNN(" + ps1.getTuSo() + "/" + ps1.getMauSo() + ", " 
                                          + ps2.getTuSo() + "/" + ps2.getMauSo() + ") = ");
                        System.out.println("= " + ps1.timBCNN(ps1.getTuSo(), ps2.getTuSo()) + "/" 
                                          + ps1.timUCLN(ps1.getMauSo(), ps2.getMauSo()));
                    } else {
                        System.out.println("Chưa nhập đủ 2 phân số!");
                    }
                    break;
                    
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
    }
}
package bai2;

import java.util.Scanner;

public class MenuSoPhuc {
    public static void main(String[] args) {
        XuLySoPhuc xl = new XuLySoPhuc();
        Scanner sc = new Scanner(System.in);
        
        SoPhuc sp1 = null;
        SoPhuc sp2 = null;
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("         PHÉP TOÁN TRÊN SỐ PHỨC");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập số phức thứ nhất");
            System.out.println("2. Nhập số phức thứ hai");
            System.out.println("3. Xuất 2 số phức");
            System.out.println("4. Cộng 2 số phức");
            System.out.println("5. Trừ 2 số phức");
            System.out.println("6. Nhân 2 số phức");
            System.out.println("7. Chia 2 số phức");
            System.out.println("8. Tính module (độ lớn)");
            System.out.println("9. Tìm số phức liên hợp");
            System.out.println("10. Tính argument (góc φ)");
            System.out.println("11. Lũy thừa số phức");
            System.out.println("12. Dạng lượng giác");
            System.out.println("13. So sánh 2 số phức");
            System.out.println("14. Kiểm tra loại số phức");
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
                    sp1 = xl.nhapSoPhuc("SỐ PHỨC THỨ NHẤT");
                    System.out.println("Đã nhập: " + sp1.xuatSoPhuc());
                    break;
                    
                case 2:
                    sp2 = xl.nhapSoPhuc("SỐ PHỨC THỨ HAI");
                    System.out.println("Đã nhập: " + sp2.xuatSoPhuc());
                    break;
                    
                case 3:
                    xuatHaiSoPhuc(sp1, sp2);
                    break;
                    
                case 4:
                    if (sp1 != null && sp2 != null) {
                        SoPhuc kq = sp1.cong(sp2);
                        System.out.println(sp1.xuatSoPhuc() + " + " + sp2.xuatSoPhuc() + 
                                         " = " + kq.xuatSoPhuc());
                    } else {
                        System.out.println("Chưa nhập đủ 2 số phức!");
                    }
                    break;
                    
                case 5:
                    if (sp1 != null && sp2 != null) {
                        SoPhuc kq = sp1.tru(sp2);
                        System.out.println(sp1.xuatSoPhuc() + " - " + sp2.xuatSoPhuc() + 
                                         " = " + kq.xuatSoPhuc());
                    } else {
                        System.out.println("Chưa nhập đủ 2 số phức!");
                    }
                    break;
                    
                case 6:
                    if (sp1 != null && sp2 != null) {
                        SoPhuc kq = sp1.nhan(sp2);
                        System.out.println("(" + sp1.xuatSoPhuc() + ") × (" + sp2.xuatSoPhuc() + 
                                         ") = " + kq.xuatSoPhuc());
                    } else {
                        System.out.println("Chưa nhập đủ 2 số phức!");
                    }
                    break;
                    
                case 7:
                    if (sp1 != null && sp2 != null) {
                        try {
                            SoPhuc kq = sp1.chia(sp2);
                            System.out.println("(" + sp1.xuatSoPhuc() + ") ÷ (" + sp2.xuatSoPhuc() + 
                                             ") = " + kq.xuatSoPhuc());
                        } catch (ArithmeticException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Chưa nhập đủ 2 số phức!");
                    }
                    break;
                    
                case 8:
                    System.out.println("\n=== TÍNH MODULE ===");
                    if (sp1 != null) {
                        System.out.println("|" + sp1.xuatSoPhuc() + "| = " + 
                                         String.format("%.4f", sp1.module()));
                    }
                    if (sp2 != null) {
                        System.out.println("|" + sp2.xuatSoPhuc() + "| = " + 
                                         String.format("%.4f", sp2.module()));
                    }
                    break;
                    
                case 9:
                    System.out.println("\n=== SỐ PHỨC LIÊN HỢP ===");
                    if (sp1 != null) {
                        SoPhuc lienHop1 = sp1.lienHop();
                        System.out.println("Liên hợp của " + sp1.xuatSoPhuc() + 
                                         " = " + lienHop1.xuatSoPhuc());
                    }
                    if (sp2 != null) {
                        SoPhuc lienHop2 = sp2.lienHop();
                        System.out.println("Liên hợp của " + sp2.xuatSoPhuc() + 
                                         " = " + lienHop2.xuatSoPhuc());
                    }
                    break;
                    
                case 10:
                    System.out.println("\n=== TÍNH ARGUMENT (GÓC φ) ===");
                    if (sp1 != null) {
                        System.out.println("arg(" + sp1.xuatSoPhuc() + ") = " + 
                                         String.format("%.4f rad", sp1.argument()) + 
                                         " ≈ " + String.format("%.2f°", Math.toDegrees(sp1.argument())));
                    }
                    if (sp2 != null) {
                        System.out.println("arg(" + sp2.xuatSoPhuc() + ") = " + 
                                         String.format("%.4f rad", sp2.argument()) + 
                                         " ≈ " + String.format("%.2f°", Math.toDegrees(sp2.argument())));
                    }
                    break;
                    
                case 11:
                    if (sp1 != null) {
                        int n = xl.nhapSoNguyen("Nhập số mũ (n): ");
                        SoPhuc kq = sp1.luyThua(n);
                        System.out.println("(" + sp1.xuatSoPhuc() + ")^" + n + 
                                         " = " + kq.xuatSoPhuc());
                    } else {
                        System.out.println("Chưa nhập số phức!");
                    }
                    break;
                    
                case 12:
                    System.out.println("\n=== DẠNG LƯỢNG GIÁC ===");
                    if (sp1 != null) {
                        System.out.println(sp1.xuatSoPhuc() + " = " + sp1.dangLuongGiac());
                    }
                    if (sp2 != null) {
                        System.out.println(sp2.xuatSoPhuc() + " = " + sp2.dangLuongGiac());
                    }
                    break;
                    
                case 13:
                    if (sp1 != null && sp2 != null) {
                        System.out.println("\n=== SO SÁNH 2 SỐ PHỨC ===");
                        System.out.println("Số phức 1: " + sp1.xuatSoPhuc());
                        System.out.println("Số phức 2: " + sp2.xuatSoPhuc());
                        
                        if (sp1.bangNhau(sp2)) {
                            System.out.println("Hai số phức BẰNG NHAU");
                        } else {
                            System.out.println("Hai số phức KHÁC NHAU");
                        }
                    } else {
                        System.out.println("Chưa nhập đủ 2 số phức!");
                    }
                    break;
                    
                case 14:
                    System.out.println("\n=== KIỂM TRA LOẠI SỐ PHỨC ===");
                    if (sp1 != null) {
                        System.out.println("Số phức 1: " + sp1.xuatSoPhuc());
                        if (sp1.laSoPhucThuanThuc()) {
                            System.out.println("→ Là số thực (phần ảo = 0)");
                        } else if (sp1.laSoPhucThuanAo()) {
                            System.out.println("→ Là số thuần ảo (phần thực = 0)");
                        } else {
                            System.out.println("→ Là số phức tổng quát");
                        }
                    }
                    if (sp2 != null) {
                        System.out.println("\nSố phức 2: " + sp2.xuatSoPhuc());
                        if (sp2.laSoPhucThuanThuc()) {
                            System.out.println("→ Là số thực (phần ảo = 0)");
                        } else if (sp2.laSoPhucThuanAo()) {
                            System.out.println("→ Là số thuần ảo (phần thực = 0)");
                        } else {
                            System.out.println("→ Là số phức tổng quát");
                        }
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
    
    private static void xuatHaiSoPhuc(SoPhuc sp1, SoPhuc sp2) {
        System.out.println("\n=== HAI SỐ PHỨC ===");
        System.out.print("Số phức 1: ");
        if (sp1 != null) System.out.println(sp1.xuatSoPhuc());
        else System.out.println("Chưa nhập");
        
        System.out.print("Số phức 2: ");
        if (sp2 != null) System.out.println(sp2.xuatSoPhuc());
        else System.out.println("Chưa nhập");
    }
}

package bai5;

import java.util.Arrays;
import java.util.Scanner;

public class MangSoNguyen {
    // Thuộc tính
    private int[] mang;
    private int soPhanTu;
    private Scanner sc;
    
    // 1. Hàm dựng rỗng
    public MangSoNguyen() {
        this.mang = new int[10]; // Khởi tạo mảng 10 phần tử
        this.soPhanTu = 0;
        this.sc = new Scanner(System.in);
    }
    
    // 2. Hàm dựng có tham số (kích thước)
    public MangSoNguyen(int kichThuoc) {
        this.mang = new int[kichThuoc];
        this.soPhanTu = 0;
        this.sc = new Scanner(System.in);
    }
    
    // 3. Getter - Setter
    public int[] getMang() {
        return mang;
    }
    
    public int getSoPhanTu() {
        return soPhanTu;
    }
    
    // 4. Thêm 1 giá trị vào chỉ số i
    public void themTaiChiSo(int giaTri, int chiSo) {
        if (chiSo < 0 || chiSo > soPhanTu) {
            System.out.println("Chỉ số không hợp lệ!");
            return;
        }
        
        // Kiểm tra nếu mảng đầy thì tăng kích thước
        if (soPhanTu == mang.length) {
            tangKichThuocMang();
        }
        
        // Dời các phần tử từ vị trí chiSo sang phải
        for (int i = soPhanTu; i > chiSo; i--) {
            mang[i] = mang[i - 1];
        }
        
        // Thêm giá trị mới
        mang[chiSo] = giaTri;
        soPhanTu++;
        
        System.out.println("Đã thêm " + giaTri + " tại vị trí " + chiSo);
    }
    
    // 5. Thêm 1 giá trị vào cuối mảng
    public void themVaoCuoi(int giaTri) {
        // Kiểm tra nếu mảng đầy thì tăng kích thước
        if (soPhanTu == mang.length) {
            tangKichThuocMang();
        }
        
        mang[soPhanTu] = giaTri;
        soPhanTu++;
        System.out.println("Đã thêm " + giaTri + " vào cuối mảng");
    }
    
    // 6. Xóa phần tử tại chỉ số i
    public void xoaTaiChiSo(int chiSo) {
        if (chiSo < 0 || chiSo >= soPhanTu) {
            System.out.println("Chỉ số không hợp lệ!");
            return;
        }
        
        int giaTriBiXoa = mang[chiSo];
        
        // Dời các phần tử từ chiSo+1 sang trái
        for (int i = chiSo; i < soPhanTu - 1; i++) {
            mang[i] = mang[i + 1];
        }
        
        soPhanTu--;
        System.out.println("Đã xóa giá trị " + giaTriBiXoa + " tại vị trí " + chiSo);
    }
    
    // 7. Xóa phần tử có giá trị x (xóa phần tử đầu tiên tìm thấy)
    public void xoaGiaTri(int giaTri) {
        int chiSo = timKiem(giaTri);
        if (chiSo != -1) {
            xoaTaiChiSo(chiSo);
        } else {
            System.out.println("Không tìm thấy giá trị " + giaTri + " trong mảng!");
        }
    }
    
    // 8. Sắp xếp tăng dần
    public void sapXepTang() {
        for (int i = 0; i < soPhanTu - 1; i++) {
            for (int j = i + 1; j < soPhanTu; j++) {
                if (mang[i] > mang[j]) {
                    // Hoán đổi
                    int temp = mang[i];
                    mang[i] = mang[j];
                    mang[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp mảng tăng dần!");
    }
    
    // 9. Tìm kiếm 1 giá trị x
    public int timKiem(int giaTri) {
        for (int i = 0; i < soPhanTu; i++) {
            if (mang[i] == giaTri) {
                return i; // Trả về chỉ số nếu tìm thấy
            }
        }
        return -1; // Không tìm thấy
    }
    
    // 10. Lấy giá trị tại chỉ số i
    public int layGiaTriTaiChiSo(int chiSo) {
        if (chiSo < 0 || chiSo >= soPhanTu) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ!");
        }
        return mang[chiSo];
    }
    
    // 11. Xác định số phần tử của mảng
    public int demSoPhanTu() {
        return soPhanTu;
    }
    
    // 12. Ghi đè giá trị x vào chỉ số i
    public void ghiDeGiaTri(int giaTri, int chiSo) {
        if (chiSo < 0 || chiSo >= soPhanTu) {
            System.out.println("Chỉ số không hợp lệ!");
            return;
        }
        
        int giaTriCu = mang[chiSo];
        mang[chiSo] = giaTri;
        System.out.println("Đã ghi đè " + giaTri + " lên vị trí " + chiSo + 
                         " (giá trị cũ: " + giaTriCu + ")");
    }
    
    // 13. Nhập mảng từ bàn phím
    public void nhapMang() {
        System.out.print("Nhập số lượng phần tử: ");
        int n = nhapSoNguyen();
        
        if (n > mang.length) {
            mang = new int[n + 10];
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            mang[i] = nhapSoNguyen();
        }
        soPhanTu = n;
        System.out.println("Đã nhập " + n + " phần tử!");
    }
    
    // 14. Xuất mảng
    public void xuatMang() {
        if (soPhanTu == 0) {
            System.out.println("Mảng rỗng!");
            return;
        }
        
        System.out.print("Mảng [" + soPhanTu + " phần tử]: ");
        for (int i = 0; i < soPhanTu; i++) {
            System.out.print(mang[i]);
            if (i < soPhanTu - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    // 15. Xuất mảng có chỉ số
    public void xuatMangChiSo() {
        if (soPhanTu == 0) {
            System.out.println("Mảng rỗng!");
            return;
        }
        
        System.out.println("\n=== MẢNG HIỆN TẠI ===");
        System.out.println("Chỉ số: ");
        for (int i = 0; i < soPhanTu; i++) {
            System.out.printf("%4d", i);
        }
        
        System.out.println("\nGiá trị: ");
        for (int i = 0; i < soPhanTu; i++) {
            System.out.printf("%4d", mang[i]);
        }
        System.out.println("\nSố phần tử: " + soPhanTu);
    }
    
    // 16. Tăng kích thước mảng
    private void tangKichThuocMang() {
        int[] mangMoi = new int[mang.length * 2];
        for (int i = 0; i < soPhanTu; i++) {
            mangMoi[i] = mang[i];
        }
        mang = mangMoi;
        System.out.println("Đã tăng kích thước mảng lên " + mang.length);
    }
    
    // 17. Tính tổng mảng
    public int tinhTong() {
        int tong = 0;
        for (int i = 0; i < soPhanTu; i++) {
            tong += mang[i];
        }
        return tong;
    }
    
    // 18. Tìm giá trị lớn nhất
    public int timMax() {
        if (soPhanTu == 0) {
            throw new IllegalStateException("Mảng rỗng!");
        }
        
        int max = mang[0];
        for (int i = 1; i < soPhanTu; i++) {
            if (mang[i] > max) {
                max = mang[i];
            }
        }
        return max;
    }
    
    // 19. Tìm giá trị nhỏ nhất
    public int timMin() {
        if (soPhanTu == 0) {
            throw new IllegalStateException("Mảng rỗng!");
        }
        
        int min = mang[0];
        for (int i = 1; i < soPhanTu; i++) {
            if (mang[i] < min) {
                min = mang[i];
            }
        }
        return min;
    }
    
    // Hàm nhập số nguyên
    private int nhapSoNguyen() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }
    }
}
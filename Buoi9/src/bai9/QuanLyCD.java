package bai9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyCD {
    private ArrayList<CD> danhSachCD;
    private int maxSize; // Kích thước tối đa của danh sách
    
    // Constructor
    public QuanLyCD() {
        this.danhSachCD = new ArrayList<>();
        this.maxSize = 100; // Mặc định 100 CD
    }
    
    public QuanLyCD(int maxSize) {
        this.danhSachCD = new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    // 1. Thêm CD vào danh sách (không trùng mã và còn chỗ)
    public boolean themCD(CD cd) {
        if (danhSachCD.size() >= maxSize) {
            System.out.println("Danh sách đã đầy! Không thể thêm CD mới.");
            return false;
        }
        
        // Kiểm tra mã CD đã tồn tại chưa
        if (kiemTraMaCDTonTai(cd.getMaCD())) {
            System.out.println("Mã CD " + cd.getMaCD() + " đã tồn tại!");
            return false;
        }
        
        danhSachCD.add(cd);
        return true;
    }
    
    // Kiểm tra mã CD đã tồn tại chưa
    private boolean kiemTraMaCDTonTai(int maCD) {
        for (CD cd : danhSachCD) {
            if (cd.getMaCD() == maCD) {
                return true;
            }
        }
        return false;
    }
    
    // 2. Tính số lượng CD
    public int tinhSoLuongCD() {
        return danhSachCD.size();
    }
    
    // 3. Tính tổng giá thành
    public double tinhTongGiaThanh() {
        double tong = 0;
        for (CD cd : danhSachCD) {
            tong += cd.getGiaThanh();
        }
        return tong;
    }
    
    // 4. Sắp xếp giảm dần theo giá thành
    public void sapXepGiamDanTheoGia() {
        Collections.sort(danhSachCD, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
            }
        });
    }
    
    // 5. Sắp xếp tăng dần theo tựa CD
    public void sapXepTangDanTheoTuaCD() {
        Collections.sort(danhSachCD, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                return cd1.getTuaCD().compareToIgnoreCase(cd2.getTuaCD());
            }
        });
    }
    
    // 6. Xuất toàn bộ danh sách
    public void xuatDanhSach() {
        if (danhSachCD.isEmpty()) {
            System.out.println("\nDanh sách CD trống!");
            return;
        }
        
        System.out.println("\n┌──────────┬───────────────────────────┬──────────────────────┬──────────────┬──────────────────┐");
        System.out.println("│ Mã CD    │ Tựa CD                    │ Ca sĩ               │ Số bài hát   │ Giá thành       │");
        System.out.println("├──────────┼───────────────────────────┼──────────────────────┼──────────────┼──────────────────┤");
        
        for (CD cd : danhSachCD) {
            System.out.println(cd.toString());
        }
        
        System.out.println("├──────────┴───────────────────────────┴──────────────────────┴──────────────┴──────────────────┤");
        System.out.printf("│ Tổng số CD: %-3d                                                   Tổng giá: %,15.0f VNĐ │\n",
            tinhSoLuongCD(), tinhTongGiaThanh());
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────┘");
    }
    
    // 7. Xuất danh sách theo dạng đơn giản
    public void xuatDanhSachDonGian() {
        if (danhSachCD.isEmpty()) {
            System.out.println("\nDanh sách CD trống!");
            return;
        }
        
        System.out.println("\n========================================================================================");
        System.out.println("                             DANH SÁCH CD (" + danhSachCD.size() + " CD)");
        System.out.println("========================================================================================");
        System.out.println("Mã CD    Tựa CD                    Ca sĩ               Số bài hát   Giá thành (VNĐ)");
        System.out.println("---------------------------------------------------------------------------------------");
        
        for (CD cd : danhSachCD) {
            System.out.printf("%-8d %-25s %-20s %12d %,15.0f\n",
                cd.getMaCD(),
                cd.getTuaCD(),
                cd.getCaSy(),
                cd.getSoBaiHat(),
                cd.getGiaThanh());
        }
        
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("Tổng số CD: %d | Tổng giá thành: %,15.0f VNĐ\n", 
            tinhSoLuongCD(), tinhTongGiaThanh());
        System.out.println("========================================================================================\n");
    }
    
    // 8. Tìm kiếm CD theo mã
    public CD timKiemTheoMa(int maCD) {
        for (CD cd : danhSachCD) {
            if (cd.getMaCD() == maCD) {
                return cd;
            }
        }
        return null;
    }
    
    // 9. Xóa CD theo mã
    public boolean xoaCDTheoMa(int maCD) {
        for (int i = 0; i < danhSachCD.size(); i++) {
            if (danhSachCD.get(i).getMaCD() == maCD) {
                danhSachCD.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // 10. Lấy danh sách CD
    public ArrayList<CD> getDanhSachCD() {
        return danhSachCD;
    }
    
    // 11. Kiểm tra danh sách đầy
    public boolean isDanhSachDay() {
        return danhSachCD.size() >= maxSize;
    }
    
    // 12. Lấy kích thước tối đa
    public int getMaxSize() {
        return maxSize;
    }
}
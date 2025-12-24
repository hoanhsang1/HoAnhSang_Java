package quanlysinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSV;
    private ArrayList<Faculty> danhSachKhoa;
    private School truong;
    private Set<String> danhSachMaSV;
    private Set<String> danhSachMaKhoa;
    
    public QuanLySinhVien() {
        danhSachSV = new ArrayList<>();
        danhSachKhoa = new ArrayList<>();
        truong = School.getInstance(); // CHỈ 1 TRƯỜNG DUY NHẤT
        danhSachMaSV = new HashSet<>();
        danhSachMaKhoa = new HashSet<>();
    }
    
    // ==================== KIỂM TRA MÃ DUY NHẤT ====================
    
    private boolean maSVTonTai(String maSV) {
        return danhSachMaSV.contains(maSV);
    }
    
    private void themMaSV(String maSV) {
        danhSachMaSV.add(maSV);
    }
    
    private boolean maKhoaTonTai(String maKhoa) {
        return danhSachMaKhoa.contains(maKhoa);
    }
    
    private void themMaKhoa(String maKhoa) {
        danhSachMaKhoa.add(maKhoa);
    }
    
    // ==================== PHƯƠNG THỨC TIỆN ÍCH ====================
    
    private String inputNonEmptyString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Không được để trống!");
        }
    }
    
    private int inputPositiveInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                }
                System.out.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
    
    private int inputIntInRange(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Giá trị phải từ " + min + " đến " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
    
    // ==================== QUẢN LÝ TRƯỜNG ====================
    
    public void nhapThongTinTruong() {
        truong.nhapThongTin();
    }
    
    public void xuatThongTinTruong() {
        if (truong.getMaTruong() == null) {
            System.out.println("\nChưa có thông tin trường!");
            return;
        }
        truong.xuatThongTin();
    }
    
    // ==================== QUẢN LÝ KHOA ====================
    
    public void nhapDanhSachKhoa() {
        if (truong.getMaTruong() == null) {
            System.out.println("\n⚠️ Vui lòng nhập thông tin trường trước!");
            return;
        }
        
        System.out.println("\n=== NHẬP DANH SÁCH KHOA ===");
        
        int n = inputPositiveInt("Nhập số lượng khoa: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Khoa thứ " + (i + 1) + " ---");
            
            Faculty khoa = new Faculty();
            khoa.nhapThongTin();
            
            // Kiểm tra mã khoa duy nhất
            while (maKhoaTonTai(khoa.getMaKhoa())) {
                System.out.println("Mã khoa đã tồn tại! Vui lòng nhập mã khác.");
                khoa.setMaKhoa(inputNonEmptyString("Mã khoa mới: "));
            }
            
            danhSachKhoa.add(khoa);
            truong.themKhoa(khoa);
            themMaKhoa(khoa.getMaKhoa());
            System.out.println("✓ Đã thêm khoa: " + khoa.getTenKhoa());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + n + " khoa!");
    }
    
    public void xuatDanhSachKhoa() {
        if (danhSachKhoa.isEmpty()) {
            System.out.println("\nDanh sách khoa trống!");
            return;
        }
        
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("              DANH SÁCH KHOA");
        System.out.println("══════════════════════════════════════════════");
        System.out.printf("%-10s %-25s %-12s %-15s\n", "Mã khoa", "Tên khoa", "Ngày TL", "Số SV");
        System.out.println("──────────────────────────────────────────────────");
        
        int stt = 1;
        for (Faculty khoa : danhSachKhoa) {
            System.out.printf("%-3d %-10s %-25s %-12s %-15d\n",
                stt++, khoa.getMaKhoa(), khoa.getTenKhoa(), 
                khoa.getNgayThanhLap().toString(), khoa.getDanhSachSV().size());
        }
        
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Tổng số khoa: " + danhSachKhoa.size());
    }
    
    // ==================== QUẢN LÝ SINH VIÊN ====================
    
    public void nhapThongTinSinhVien() {
        if (danhSachKhoa.isEmpty()) {
            System.out.println("\n⚠️ Vui lòng nhập danh sách khoa trước!");
            return;
        }
        
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ===");
        
        // Chọn hệ đào tạo
        System.out.println("Chọn hệ đào tạo:");
        System.out.println("1. Đại học (Tín chỉ)");
        System.out.println("2. Cao đẳng (Niên chế)");
        System.out.println("3. Trung cấp (Niên chế)");
        
        int choice = inputIntInRange("Lựa chọn (1-3): ", 1, 3);
        
        SinhVien sv = null;
        
        switch (choice) {
            case 1:
                sv = new SinhVienTinhChi();
                break;
            case 2:
                sv = new CaoDang();
                break;
            case 3:
                sv = new TrungCap();
                break;
        }
        
        if (sv != null) {
            // NHẬP MÃ SINH VIÊN (chỉ 1 lần)
            String maSVInput;
            while (true) {
                maSVInput = inputNonEmptyString("Mã sinh viên: ");
                if (maSVTonTai(maSVInput)) {
                    System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập mã khác.");
                } else {
                    themMaSV(maSVInput);
                    break;
                }
            }
            
            // NHẬP TOÀN BỘ THÔNG TIN SINH VIÊN (liên tục)
            sv.nhapThongTin(maSVInput);
            
            // CHỌN KHOA (sau khi nhập xong thông tin cá nhân và học tập)
            System.out.println("\n--- CHỌN KHOA ---");
            for (int i = 0; i < danhSachKhoa.size(); i++) {
                Faculty khoa = danhSachKhoa.get(i);
                System.out.println((i + 1) + ". " + khoa.getTenKhoa() + " (Mã: " + khoa.getMaKhoa() + ")");
            }
            
            int chonKhoa = inputIntInRange("Chọn khoa (1-" + danhSachKhoa.size() + "): ", 1, danhSachKhoa.size());
            Faculty khoaChon = danhSachKhoa.get(chonKhoa - 1);
            sv.setKhoa(khoaChon);
            khoaChon.themSinhVien(sv);
            
            // THÊM VÀO DANH SÁCH
            danhSachSV.add(sv);
            
            System.out.println("\n══════════════════════════════════════════════");
            System.out.println("     ĐÃ HOÀN THÀNH NHẬP THÔNG TIN SINH VIÊN");
            System.out.println("══════════════════════════════════════════════");
            System.out.println("Mã SV: " + sv.getMaSV());
            System.out.println("Họ tên: " + sv.getHoTen());
            System.out.println("Giới tính: " + sv.getGioiTinh());
            System.out.println("Tuổi: " + sv.tinhTuoi());
            System.out.println("Khoa: " + sv.getKhoa().getTenKhoa());
            System.out.println("Hệ đào tạo: " + sv.getHeDaoTao());
            System.out.println("Xếp loại: " + sv.getXepLoai());
            System.out.println("Tốt nghiệp: " + (sv.isTotNghiep() ? "Đạt" : "Chưa đạt"));
            System.out.println("══════════════════════════════════════════════");
        }
    }
    
    // 2. Xuất danh sách sinh viên (BÀI 1)
    public void xuatDanhSachSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : danhSachSV) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
    }
    
    // Xuất theo khoa
    public void xuatSinhVienTheoKhoa() {
        if (danhSachKhoa.isEmpty()) {
            System.out.println("\nChưa có khoa nào!");
            return;
        }
        
        System.out.println("\n=== XUẤT SINH VIÊN THEO KHOA ===");
        for (int i = 0; i < danhSachKhoa.size(); i++) {
            Faculty khoa = danhSachKhoa.get(i);
            System.out.println((i + 1) + ". " + khoa.getTenKhoa());
        }
        
        int chon = inputIntInRange("Chọn khoa (1-" + danhSachKhoa.size() + "): ", 1, danhSachKhoa.size());
        Faculty khoaChon = danhSachKhoa.get(chon - 1);
        
        if (khoaChon.getDanhSachSV().isEmpty()) {
            System.out.println("\nKhoa " + khoaChon.getTenKhoa() + " chưa có sinh viên!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                          DANH SÁCH SINH VIÊN KHOA " + khoaChon.getTenKhoa().toUpperCase());
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : khoaChon.getDanhSachSV()) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("Tổng số: " + khoaChon.getDanhSachSV().size() + " sinh viên");
    }
    
    // Xuất theo hệ đào tạo
    public void xuatSinhVienTheoHe() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        System.out.println("\n=== XUẤT SINH VIÊN THEO HỆ ĐÀO TẠO ===");
        System.out.println("1. Đại học (Tín chỉ)");
        System.out.println("2. Cao đẳng");
        System.out.println("3. Trung cấp");
        
        int choice = inputIntInRange("Chọn hệ (1-3): ", 1, 3);
        
        String heDaoTao = "";
        switch (choice) {
            case 1: heDaoTao = "Đại học"; break;
            case 2: heDaoTao = "Cao đẳng"; break;
            case 3: heDaoTao = "Trung cấp"; break;
        }
        
        ArrayList<SinhVien> dsTheoHe = new ArrayList<>();
        for (SinhVien sv : danhSachSV) {
            if (sv.getHeDaoTao().contains(heDaoTao)) {
                dsTheoHe.add(sv);
            }
        }
        
        if (dsTheoHe.isEmpty()) {
            System.out.println("\nKhông có sinh viên hệ " + heDaoTao + "!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                          DANH SÁCH SINH VIÊN HỆ " + heDaoTao.toUpperCase());
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : dsTheoHe) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("Tổng số: " + dsTheoHe.size() + " sinh viên");
    }
    
    // 3. Sắp xếp theo mã (riêng từng hệ) (BÀI 1)
    public void sapXepTheoMa() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        // Tách danh sách theo hệ
        ArrayList<SinhVienTinhChi> dsTinhChi = new ArrayList<>();
        ArrayList<SinhVienNienChe> dsNienChe = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            if (sv instanceof SinhVienTinhChi) {
                dsTinhChi.add((SinhVienTinhChi) sv);
            } else if (sv instanceof SinhVienNienChe) {
                dsNienChe.add((SinhVienNienChe) sv);
            }
        }
        
        // Sắp xếp từng hệ
        if (!dsTinhChi.isEmpty()) {
            Collections.sort(dsTinhChi, Comparator.comparing(SinhVienTinhChi::getMaSV));
        }
        if (!dsNienChe.isEmpty()) {
            Collections.sort(dsNienChe, Comparator.comparing(SinhVienNienChe::getMaSV));
        }
        
        // Gộp lại
        danhSachSV.clear();
        danhSachSV.addAll(dsTinhChi);
        danhSachSV.addAll(dsNienChe);
        
        System.out.println("\n✓ Đã sắp xếp sinh viên theo mã (riêng từng hệ)");
        System.out.println("  - Đại học (Tín chỉ): " + dsTinhChi.size() + " sinh viên");
        System.out.println("  - Niên chế: " + dsNienChe.size() + " sinh viên");
    }
    
    // Sắp xếp theo tên
    public void sapXepTheoTen() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        Collections.sort(danhSachSV, Comparator.comparing(SinhVien::getHoTen));
        System.out.println("\n✓ Đã sắp xếp sinh viên theo tên");
    }
    
    // Sắp xếp theo điểm (mỗi hệ khác nhau)
    public void sapXepTheoDiem() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        // Sắp xếp giảm dần theo điểm
        Collections.sort(danhSachSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Float.compare(sv2.getDiem(), sv1.getDiem());
            }
        });
        
        System.out.println("\n✓ Đã sắp xếp sinh viên theo điểm (giảm dần)");
    }
    
    // 4. Thống kê tổng số sinh viên (BÀI 1)
    public void thongKeSoLuongSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        int countTinhChi = 0;
        int countCaoDang = 0;
        int countTrungCap = 0;
        int countTotNghiep = 0;
        
        for (SinhVien sv : danhSachSV) {
            if (sv instanceof SinhVienTinhChi) {
                countTinhChi++;
            } else if (sv instanceof CaoDang) {
                countCaoDang++;
            } else if (sv instanceof TrungCap) {
                countTrungCap++;
            }
            
            if (sv.isTotNghiep()) {
                countTotNghiep++;
            }
        }
        
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("        THỐNG KÊ SỐ LƯỢNG SINH VIÊN");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("TRƯỜNG: " + (truong.getTenTruong() != null ? truong.getTenTruong() : "Chưa đặt tên"));
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
        System.out.println("Số sinh viên đã tốt nghiệp: " + countTotNghiep);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Đại học (Tín chỉ): " + countTinhChi);
        System.out.println("Cao đẳng: " + countCaoDang);
        System.out.println("Trung cấp: " + countTrungCap);
        System.out.println("══════════════════════════════════════════════");
    }
    
    // 5. Tìm kiếm theo tên sinh viên (BÀI 1)
    public void timKiemTheoTen() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        String tenCanTim = inputNonEmptyString("Nhập tên sinh viên cần tìm: ").toLowerCase();
        
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            if (sv.getHoTen().toLowerCase().contains(tenCanTim)) {
                ketQua.add(sv);
            }
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("\nKhông tìm thấy sinh viên có tên: " + tenCanTim);
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               KẾT QUẢ TÌM KIẾM: '" + tenCanTim + "' (" + ketQua.size() + " kết quả)");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : ketQua) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
    }
    
    // Tìm kiếm theo mã sinh viên
    public void timKiemTheoMa() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        String maCanTim = inputNonEmptyString("Nhập mã sinh viên cần tìm: ");
        
        for (SinhVien sv : danhSachSV) {
            if (sv.getMaSV().equalsIgnoreCase(maCanTim)) {
                System.out.println("\n✓ Tìm thấy sinh viên:");
                sv.xuatThongTinChiTiet();
                return;
            }
        }
        
        System.out.println("\nKhông tìm thấy sinh viên có mã: " + maCanTim);
    }
    
    // 6. Danh sách sinh viên được khen thưởng (BÀI 1)
    public void danhSachSinhVienDuocKhenThuong() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        ArrayList<SinhVien> danhSachKhenThuong = new ArrayList<>();
        
        for (SinhVien sv : danhSachSV) {
            if (sv.isDuocKhenThuong()) {
                danhSachKhenThuong.add(sv);
            }
        }
        
        if (danhSachKhenThuong.isEmpty()) {
            System.out.println("\nKhông có sinh viên nào được khen thưởng!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               DANH SÁCH SINH VIÊN ĐƯỢC KHEN THƯỞNG CUỐI KHÓA");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : danhSachKhenThuong) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
            System.out.println();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số: " + danhSachKhenThuong.size() + " sinh viên được khen thưởng");
    }
    
    // Thống kê kết quả học tập
    public void thongKeKetQuaHocTap() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int countGioi = 0, countKha = 0, countTB = 0, countYeu = 0;
        
        for (SinhVien sv : danhSachSV) {
            String xepLoai = sv.getXepLoai();
            
            if (sv instanceof SinhVienTinhChi) {
                switch (xepLoai) {
                    case "A": countA++; break;
                    case "B": countB++; break;
                    case "C": countC++; break;
                    case "D": countD++; break;
                }
            } else if (sv instanceof SinhVienNienChe) {
                switch (xepLoai) {
                    case "Giỏi": countGioi++; break;
                    case "Khá": countKha++; break;
                    case "Trung bình": countTB++; break;
                    case "Yếu": countYeu++; break;
                }
            }
        }
        
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("         THỐNG KÊ KẾT QUẢ HỌC TẬP");
        System.out.println("══════════════════════════════════════════════");
        
        System.out.println("\nHệ Đại học (Tín chỉ):");
        System.out.println("────────────────────");
        System.out.println("A (Xuất sắc): " + countA + " sinh viên");
        System.out.println("B (Giỏi): " + countB + " sinh viên");
        System.out.println("C (Khá): " + countC + " sinh viên");
        System.out.println("D (Trung bình): " + countD + " sinh vien");
        
        System.out.println("\nHệ Niên chế (Cao đẳng/Trung cấp):");
        System.out.println("────────────────────────────────");
        System.out.println("Giỏi: " + countGioi + " sinh viên");
        System.out.println("Khá: " + countKha + " sinh viên");
        System.out.println("Trung bình: " + countTB + " sinh viên");
        System.out.println("Yếu: " + countYeu + " sinh viên");
        
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("Sinh viên đã tốt nghiệp: " + demSoSinhVienTotNghiep() + "/" + danhSachSV.size());
        System.out.println("══════════════════════════════════════════════");
    }
    
    // Đếm số sinh viên tốt nghiệp
    private int demSoSinhVienTotNghiep() {
        int count = 0;
        for (SinhVien sv : danhSachSV) {
            if (sv.isTotNghiep()) {
                count++;
            }
        }
        return count;
    }
    
    public void capNhatThongTinSinhVien() {
    if (danhSachSV.isEmpty()) {
        System.out.println("\nDanh sách sinh viên trống!");
        return;
    }
    
    String maSV = inputNonEmptyString("Nhập mã sinh viên cần cập nhật: ");
    
    for (SinhVien sv : danhSachSV) {
        if (sv.getMaSV().equals(maSV)) {
            System.out.println("\n=== CẬP NHẬT THÔNG TIN SINH VIÊN ===");
            System.out.println("Thông tin hiện tại:");
            sv.xuatThongTinChiTiet();
            
            System.out.println("\nChọn thông tin cần cập nhật:");
            System.out.println("1. Cập nhật địa chỉ");
            System.out.println("2. Cập nhật điểm học tập");
            System.out.println("3. Cập nhật thông tin cá nhân");
            System.out.println("4. Cập nhật ngày sinh (có validate tuổi)");
            System.out.println("5. Cập nhật khoa");
            
            int choice = inputIntInRange("Chọn thao tác (1-5): ", 1, 5);
            
            switch (choice) {
                case 1:
                    sv.getDiaChi().capNhatDiaChi();
                    break;
                    
                case 2:
                    sv.capNhatDiem();
                    break;
                    
                case 3:
                    capNhatThongTinCaNhan(sv);
                    break;
                    
                case 4:
                    capNhatNgaySinh(sv);
                    break;
                    
                case 5:
                    capNhatKhoa(sv);
                    break;
            }
            
            System.out.println("✓ Đã cập nhật thông tin sinh viên: " + sv.getHoTen());
            return;
        }
    }
    
    System.out.println("\nKhông tìm thấy sinh viên có mã: " + maSV);
}

// Cập nhật thông tin cá nhân
private void capNhatThongTinCaNhan(SinhVien sv) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Họ tên mới (Enter để giữ nguyên): ");
    String input = scanner.nextLine().trim();
    if (!input.isEmpty()) {
        sv.setHoTen(input);
    }
    
    // Validate giới tính
    while (true) {
        System.out.print("Giới tính mới (Nam/Nữ, Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            break; // Giữ nguyên
        }
        if (input.equalsIgnoreCase("Nam") || input.equalsIgnoreCase("Nữ")) {
            sv.setGioiTinh(input);
            break;
        }
        System.out.println("Giới tính phải là 'Nam' hoặc 'Nữ'!");
    }
    
    System.out.println("✓ Đã cập nhật thông tin cá nhân!");
}

// Cập nhật ngày sinh với validate tuổi theo hệ đào tạo
private void capNhatNgaySinh(SinhVien sv) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n=== CẬP NHẬT NGÀY SINH ===");
    System.out.println("Ngày sinh hiện tại: " + sv.getNgaySinh().toString());
    
    // Xác định tuổi tối thiểu theo hệ đào tạo
    int tuoiToiThieu = 0;
    if (sv instanceof SinhVienTinhChi) {
        tuoiToiThieu = 18; // Đại học >= 18
        System.out.println("Yêu cầu: Đại học phải đủ 18 tuổi");
    } else if (sv instanceof CaoDang) {
        tuoiToiThieu = 18; // Cao đẳng >= 18
        System.out.println("Yêu cầu: Cao đẳng phải đủ 18 tuổi");
    } else if (sv instanceof TrungCap) {
        tuoiToiThieu = 16; // Trung cấp >= 16
        System.out.println("Yêu cầu: Trung cấp phải đủ 16 tuổi");
    }
    
    // Nhập ngày sinh mới với validate
    Date ngaySinhMoi = null;
    while (true) {
        System.out.print("Nhập ngày sinh mới (dd/MM/yyyy, Enter để hủy): ");
        String input = scanner.nextLine().trim();
        
        if (input.isEmpty()) {
            System.out.println("Đã hủy cập nhật ngày sinh.");
            return;
        }
        
        try {
            // Parse ngày sinh
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            java.time.LocalDate date = java.time.LocalDate.parse(input, formatter);
            ngaySinhMoi = new Date(date);
            
            // Kiểm tra không được ở tương lai
            if (date.isAfter(java.time.LocalDate.now())) {
                System.out.println("Lỗi: Ngày sinh không được ở tương lai!");
                continue;
            }
            
            // Kiểm tra tuổi tối thiểu
            int tuoi = ngaySinhMoi.tinhTuoi();
            if (tuoi < tuoiToiThieu) {
                System.out.println("Lỗi: Phải đủ " + tuoiToiThieu + " tuổi trở lên! (Tuổi hiện tại: " + tuoi + ")");
                continue;
            }
            
            // Nếu hợp lệ
            sv.setNgaySinh(ngaySinhMoi);
            System.out.println("✓ Đã cập nhật ngày sinh! Tuổi hiện tại: " + sv.tinhTuoi());
            break;
            
        } catch (Exception e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập dd/MM/yyyy");
        }
    }
}

// Cập nhật khoa
private void capNhatKhoa(SinhVien sv) {
    if (danhSachKhoa.isEmpty()) {
        System.out.println("Chưa có khoa nào để chuyển!");
        return;
    }
    
    System.out.println("\n=== CẬP NHẬT KHOA ===");
    System.out.println("Khoa hiện tại: " + (sv.getKhoa() != null ? sv.getKhoa().getTenKhoa() : "Chưa có"));
    
    System.out.println("\nDanh sách khoa:");
    for (int i = 0; i < danhSachKhoa.size(); i++) {
        Faculty khoa = danhSachKhoa.get(i);
        System.out.println((i + 1) + ". " + khoa.getTenKhoa() + " (Mã: " + khoa.getMaKhoa() + ")");
    }
    
    System.out.print("Chọn khoa mới (1-" + danhSachKhoa.size() + ", 0 để hủy): ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine().trim();
    
    if (input.equals("0")) {
        System.out.println("Đã hủy thay đổi khoa.");
        return;
    }
    
    try {
        int choice = Integer.parseInt(input);
        if (choice >= 1 && choice <= danhSachKhoa.size()) {
            Faculty khoaCu = sv.getKhoa();
            Faculty khoaMoi = danhSachKhoa.get(choice - 1);
            
            // Xóa sinh viên khỏi khoa cũ
            if (khoaCu != null) {
                khoaCu.getDanhSachSV().remove(sv);
            }
            
            // Thêm vào khoa mới
            sv.setKhoa(khoaMoi);
            khoaMoi.themSinhVien(sv);
            
            System.out.println("✓ Đã chuyển sinh viên sang khoa: " + khoaMoi.getTenKhoa());
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    } catch (NumberFormatException e) {
        System.out.println("Vui lòng nhập số hợp lệ!");
    }
}
    // Getter
    public int getSoLuongSinhVien() {
        return danhSachSV.size();
    }
    
    public int getSoLuongKhoa() {
        return danhSachKhoa.size();
    }
}
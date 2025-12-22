package bai1;

import java.text.SimpleDateFormat;
import java.util.*;
import TaomoiTV.*;

public class XuLy {
    private List<SV> danhSachSV;
    private Scanner sc = new Scanner(System.in);
    
    public XuLy() {
        danhSachSV = new ArrayList<>();
    }
    
    // Thêm sinh viên vào danh sách
    public void themSV(SV sv) {
        danhSachSV.add(sv);
    }
    
    public void nhapThongTinDSSV() {
        int n = Test.inputPositiveInt("Nhập số lượng sinh viên muốn thêm: ");
        for(int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập sinh viên thứ " + (i+1) + " ---");
            nhapThongTinSV();
        }
    }
    
    // 1. Nhập thông tin cụ thể cho 1 sinh viên
    public void nhapThongTinSV() {
        System.out.println("\n===== NHẬP THÔNG TIN SINH VIÊN =====");
        System.out.print("Chọn hệ đào tạo (1 - Trung cấp, 2 - Cao đẳng, 3 - Đại học): ");
        int he = Test.inputIntInRange("Nhập lựa chọn: ", 1, 3);
        sc.nextLine(); // Xóa bộ đệm
        
        String maSV;
        while(true) {
            maSV = Test.inputNonEmptyString("Mã sinh viên: ");
            if (findSVByMa(maSV) == null) {
                break; // Mã chưa tồn tại
            }
            System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác!");
        }
        
        String ten = Test.inputNonEmptyString("Tên: ");
        
        String gioiTinh;
        while(true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            gioiTinh = sc.nextLine().trim();
            if (gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nữ")) {
                break;
            } else {
                System.out.println("Nhập lại giới tính (chỉ chấp nhận 'Nam' hoặc 'Nữ')!");
            }
        }
        
        Date ngaySinh = null;
        while(ngaySinh == null) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); // Kiểm tra ngày chặt chẽ
                ngaySinh = sdf.parse(ngaySinhStr);
            } catch (Exception e) {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại!");
            }
        }
        
        switch (he) {
            case 1: // Trung cấp
                double diemTrungCap = inputDoubleInRange("Điểm thi tốt nghiệp (thang 10): ", 0, 10);
                
                SVTrungCap svTrungCap = new SVTrungCap(
                    maSV, ten, gioiTinh, ngaySinh, diemTrungCap
                );
                danhSachSV.add(svTrungCap);
                System.out.println("Đã thêm sinh viên Trung cấp!");
                break;
                
            case 2: // Cao đẳng
                double diemCaoDang = inputDoubleInRange("Điểm thi tốt nghiệp (thang 10): ", 0, 10);
                
                SVCaoDang svCaoDang = new SVCaoDang(
                    maSV, ten, gioiTinh, ngaySinh, diemCaoDang
                );
                danhSachSV.add(svCaoDang);
                System.out.println("Đã thêm sinh viên Cao đẳng!");
                break;
                
            case 3: // Đại học
                int tinChi = Test.inputPositiveInt("Số tín chỉ: ");
                
                String tenDeTai = Test.inputNonEmptyString("Tên đề tài tốt nghiệp: ");
                
                double diemDanhGia = inputDoubleInRange("Điểm đánh giá (thang 5): ", 0, 5);
                
                SinhVienDaiHoc svDaiHoc = new SinhVienDaiHoc(
                    maSV, ten, gioiTinh, ngaySinh,
                    tinChi, tenDeTai, diemDanhGia
                );
                danhSachSV.add(svDaiHoc);
                System.out.println("Đã thêm sinh viên Đại học!");
                break;
        }
    }
    
    // Phương thức tìm sinh viên theo mã
    private SV findSVByMa(String maSV) {
        for (SV sv : danhSachSV) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }
    
    // 2. Xuất thông tin đầy đủ về sinh viên (dùng XuatSV())
    public void xuatThongTinSV() {
        System.out.println("\n===== DANH SÁCH SINH VIÊN (XuatSV) =====");
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            for (int i = 0; i < danhSachSV.size(); i++) {
                System.out.println("SV " + (i + 1) + ": " + danhSachSV.get(i).XuatSV());
            }
        }
    }
    
    // Xuất thông tin chi tiết (dùng getThongTin)
    public void xuatThongTinChiTiet() {
        System.out.println("\n===== DANH SÁCH SINH VIÊN CHI TIẾT =====");
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            for (int i = 0; i < danhSachSV.size(); i++) {
                System.out.println("\n--- Sinh viên thứ " + (i + 1) + " ---");
                System.out.println(danhSachSV.get(i).getThongTin());
            }
        }
    }
    
    // Xuất thông tin dưới dạng bảng
    public void xuatThongTinBang() {
        System.out.println("\n" + String.format("%-120s", "").replace(' ', '='));
        System.out.println("DANH SÁCH SINH VIÊN");
        System.out.println(String.format("%-120s", "").replace(' ', '='));
        
        if (danhSachSV.isEmpty()) {
            System.out.println("| Danh sách sinh viên trống! |");
            System.out.println(String.format("%-120s", "").replace(' ', '-'));
            return;
        }
        
        // In tiêu đề bảng
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        System.out.printf("| %-3s | %-10s | %-20s | %-8s | %-12s | %-15s | %-10s | %-15s |\n",
            "STT", "Mã SV", "Tên", "Giới tính", "Ngày sinh", "Hệ đào tạo", "Điểm", "Xếp loại");
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        
        // In dữ liệu
        int stt = 1;
        for (SV sv : danhSachSV) {
            String heDaoTao = sv.getHeDaoTao();
            String diem = "";
            String xepLoai = sv.TinhXepLoai();
            
            if (sv instanceof SVTrungCap) {
                diem = String.format("%.1f", ((SVTrungCap) sv).getDiemThiTN());
            } else if (sv instanceof SVCaoDang) {
                diem = String.format("%.1f", ((SVCaoDang) sv).getDiemThiTN());
            } else if (sv instanceof SinhVienDaiHoc) {
                diem = String.format("%.1f", ((SinhVienDaiHoc) sv).getDiemDanhGia());
            }
            
            System.out.printf("| %-3d | %-10s | %-20s | %-8s | %-12s | %-15s | %-10s | %-15s |\n",
                stt++,
                sv.getMaSV(),
                sv.getTen(),
                sv.getGioiTinh(),
                sv.getNgaySinhFormatted(),
                heDaoTao,
                diem,
                xepLoai);
        }
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
    }
    
    // 3. Sắp xếp theo mã (riêng từng hệ)
    public void sapXepTheoMa() {
        // Tách danh sách sinh viên theo hệ
        List<SV> svTrungCap = new ArrayList<>();
        List<SV> svCaoDang = new ArrayList<>();
        List<SV> svDaiHoc = new ArrayList<>();
        
        for (SV sv : danhSachSV) {
            if (sv instanceof SVTrungCap) {
                svTrungCap.add(sv);
            } else if (sv instanceof SVCaoDang) {
                svCaoDang.add(sv);
            } else if (sv instanceof SinhVienDaiHoc) {
                svDaiHoc.add(sv);
            }
        }
        
        // Sắp xếp từng danh sách
        svTrungCap.sort(Comparator.comparing(SV::getMaSV));
        svCaoDang.sort(Comparator.comparing(SV::getMaSV));
        svDaiHoc.sort(Comparator.comparing(SV::getMaSV));
        
        // Gộp lại theo thứ tự: Trung cấp -> Cao đẳng -> Đại học
        danhSachSV.clear();
        danhSachSV.addAll(svTrungCap);
        danhSachSV.addAll(svCaoDang);
        danhSachSV.addAll(svDaiHoc);
        
        System.out.println("Đã sắp xếp danh sách sinh viên theo mã (riêng từng hệ)!");
    }
    
    // 4. Thống kê tổng số sinh viên (tất cả các hệ, riêng từng hệ)
    public void thongKeSV() {
        int tongSo = danhSachSV.size();
        int soTrungCap = 0;
        int soCaoDang = 0;
        int soDaiHoc = 0;
        
        for (SV sv : danhSachSV) {
            if (sv instanceof SVTrungCap) {
                soTrungCap++;
            } else if (sv instanceof SVCaoDang) {
                soCaoDang++;
            } else if (sv instanceof SinhVienDaiHoc) {
                soDaiHoc++;
            }
        }
        
        System.out.println("\n===== THỐNG KÊ SINH VIÊN =====");
        System.out.println("Tổng số sinh viên: " + tongSo);
        System.out.println("Số sinh viên Trung cấp: " + soTrungCap);
        System.out.println("Số sinh viên Cao đẳng: " + soCaoDang);
        System.out.println("Số sinh viên Đại học: " + soDaiHoc);
    }
    
    // 5. Tìm kiếm theo Tên sinh viên
    public void timKiemTheoTen(String ten) {
        System.out.println("\n===== KẾT QUẢ TÌM KIẾM THEO TÊN: " + ten + " =====");
        boolean found = false;
        
        for (SV sv : danhSachSV) {
            if (sv.getTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(sv.XuatSV());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có tên chứa \"" + ten + "\"");
        }
    }
    
    // 6. In danh sách sinh viên được thưởng cuối khóa
    public void inSVDuocThuong() {
        System.out.println("\n===== DANH SÁCH SINH VIÊN ĐƯỢC THƯỞNG CUỐI KHÓA =====");
        boolean found = false;
        
        for (SV sv : danhSachSV) {
            if (sv instanceof SinhVienDaiHoc) {
                // Đại học: Xếp loại A
                if (sv.TinhXepLoai().equals("A")) {
                    System.out.println(sv.XuatSV());
                    found = true;
                }
            } else if (sv instanceof SVTrungCap || sv instanceof SVCaoDang) {
                // Trung cấp/Cao đẳng: Xếp loại Giỏi
                if (sv.TinhXepLoai().equals("Giỏi")) {
                    System.out.println(sv.XuatSV());
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("Không có sinh viên nào được nhận thưởng cuối khóa.");
        }
    }
    
    // In sinh viên được thưởng dạng bảng
    public void inSVDuocThuongBang() {
        System.out.println("\n" + String.format("%-120s", "").replace(' ', '='));
        System.out.println("DANH SÁCH SINH VIÊN ĐƯỢC THƯỞNG CUỐI KHÓA");
        System.out.println(String.format("%-120s", "").replace(' ', '='));
        
        List<SV> svDuocThuong = new ArrayList<>();
        for (SV sv : danhSachSV) {
            if (sv instanceof SinhVienDaiHoc && sv.TinhXepLoai().equals("A")) {
                svDuocThuong.add(sv);
            } else if ((sv instanceof SVTrungCap || sv instanceof SVCaoDang) 
                      && sv.TinhXepLoai().equals("Giỏi")) {
                svDuocThuong.add(sv);
            }
        }
        
        if (svDuocThuong.isEmpty()) {
            System.out.println("| Không có sinh viên nào được nhận thưởng cuối khóa |");
            System.out.println(String.format("%-120s", "").replace(' ', '-'));
            return;
        }
        
        // In tiêu đề bảng
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        System.out.printf("| %-3s | %-10s | %-20s | %-8s | %-12s | %-15s | %-10s | %-15s |\n",
            "STT", "Mã SV", "Tên", "Giới tính", "Ngày sinh", "Hệ đào tạo", "Điểm", "Xếp loại");
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        
        // In dữ liệu
        int stt = 1;
        for (SV sv : svDuocThuong) {
            String heDaoTao = sv.getHeDaoTao();
            String diem = "";
            
            if (sv instanceof SVTrungCap) {
                diem = String.format("%.1f", ((SVTrungCap) sv).getDiemThiTN());
            } else if (sv instanceof SVCaoDang) {
                diem = String.format("%.1f", ((SVCaoDang) sv).getDiemThiTN());
            } else if (sv instanceof SinhVienDaiHoc) {
                diem = String.format("%.1f", ((SinhVienDaiHoc) sv).getDiemDanhGia());
            }
            
            System.out.printf("| %-3d | %-10s | %-20s | %-8s | %-12s | %-15s | %-10s | %-15s |\n",
                stt++,
                sv.getMaSV(),
                sv.getTen(),
                sv.getGioiTinh(),
                sv.getNgaySinhFormatted(),
                heDaoTao,
                diem,
                sv.TinhXepLoai());
        }
        System.out.println(String.format("%-120s", "").replace(' ', '-'));
        System.out.println("Tổng số sinh viên được thưởng: " + svDuocThuong.size());
    }
     
    public double inputDoubleInRange(String message, double min, double max) {
    	while (true) {
            try {
                System.out.print(message);
                double number = Test.inputDouble("Nhập giá trị: ");
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Lỗi: Vui lòng nhập số từ " + min + " đến " + max + "! Nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên! Nhập lại.");
            }
        }
    }
    
    // Getter cho danh sách sinh viên
    public List<SV> getDanhSachSV() {
        return danhSachSV;
    }
}
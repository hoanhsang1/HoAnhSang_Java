package model;
import ThuVienSang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class XuLyPhieuKiemKe {
    private List<PhongBan> danhSachPhongBan;
    private List<NhanVien> danhSachNhanVien;
    private List<PhieuKiemKe> danhSachPhieu;
    private List<TaiSan> danhSachTaiSan;
    
    public XuLyPhieuKiemKe() {
        this.danhSachPhongBan = new ArrayList<>();
        this.danhSachNhanVien = new ArrayList<>();
        this.danhSachPhieu = new ArrayList<>();
        this.danhSachTaiSan = new ArrayList<>();
        khoiTaoDuLieuMau();
    }
    
    private void khoiTaoDuLieuMau() {
        try {
            // Tạo phòng ban mẫu
            themPhongBanMau("PTC", "Tổ chức hành chính", "Hoàng Bích Hảo");
            themPhongBanMau("PKD", "Kinh doanh", "Nguyễn Văn A");
            themPhongBanMau("PNS", "Nhân sự", "Trần Thị B");
            
            // Tạo tài sản mẫu
            themTaiSanMau("TS001", "Máy vi tính", 5, "Tốt");
            themTaiSanMau("TS002", "Máy in", 2, "Tốt");
            themTaiSanMau("TS003", "Bàn làm việc", 10, "Tốt");
            
            // Tạo nhân viên mẫu
            PhongBan pb1 = timPhongBanTheoMa("PTC");
            if (pb1 != null) {
                danhSachNhanVien.add(new NhanVien("NV01", "Kiều Thị Thanh", "Kế toán viên", pb1, Quyen.NHAN_VIEN_KK));
                danhSachNhanVien.add(new NhanVien("NV02", "Nguyễn Văn Bình", "Kế toán trưởng", pb1, Quyen.QUAN_LY));
                danhSachNhanVien.add(new NhanVien("TP01", "Hoàng Bích Hảo", "Trưởng phòng", pb1, Quyen.TRUONG_PHONG));
                danhSachNhanVien.add(new NhanVien("ADMIN01", "Admin System", "Quản trị viên", pb1, Quyen.ADMIN));
            }
            
            // Tạo phiếu mẫu từ đề bài
            taoPhieuKiemKeMau();
            
            System.out.println("✅ Đã khởi tạo dữ liệu mẫu thành công!");
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi khởi tạo dữ liệu: " + e.getMessage());
        }
    }
    
    private void themPhongBanMau(String maPhong, String tenPhong, String truongPhong) {
        try {
            PhongBan pb = new PhongBan(maPhong, tenPhong, truongPhong);
            danhSachPhongBan.add(pb);
        } catch (Exception e) {
            System.out.println("Lỗi thêm phòng " + maPhong + ": " + e.getMessage());
        }
    }
    
    private void themTaiSanMau(String maTS, String tenTS, int soLuong, String tinhTrang) {
        try {
            TaiSan ts = new TaiSan(maTS, tenTS, soLuong, tinhTrang);
            danhSachTaiSan.add(ts);
        } catch (Exception e) {
            System.out.println("Lỗi thêm tài sản " + maTS + ": " + e.getMessage());
        }
    }
    
    private void taoPhieuKiemKeMau() {
        try {
            NhanVien nv = timNhanVienTheoMa("NV01");
            PhongBan pb = timPhongBanTheoMa("PTC");
            
            if (nv != null && pb != null) {
                PhieuKiemKe phieu = new PhieuKiemKe("PH01", 
                    LocalDate.of(2007, 1, 1), nv, pb);
                
                phieu.themTaiSan(new TaiSan("TS001", "Máy vi tính", 5, "Tốt"));
                phieu.themTaiSan(new TaiSan("TS002", "Máy vi tính", 3, "Hết khấu hao - hỏng"));
                phieu.themTaiSan(new TaiSan("TS003", "Bàn làm việc", 6, "Tốt"));
                
                danhSachPhieu.add(phieu);
            }
        } catch (Exception e) {
            System.out.println("Lỗi tạo phiếu mẫu: " + e.getMessage());
        }
    }
    
    // ========== THÊM PHÒNG BAN ==========
    public void themPhongBan() {
        System.out.println("\n════════════ THÊM PHÒNG BAN MỚI ════════════");
        
        try {
            // Nhập mã phòng
            String maPhong;
            while (true) {
                maPhong = Test.inputNonEmptyString("Nhập mã phòng (P__): ");
                if (!maPhong.matches("P[A-Z]{2}")) {
                    System.out.println("⚠ Mã phòng phải có dạng P + 2 chữ cái (VD: PTC, PKD)");
                    continue;
                }
                
                if (timPhongBanTheoMa(maPhong) != null) {
                    System.out.println("⚠ Mã phòng đã tồn tại!");
                } else {
                    break;
                }
            }
            
            // Nhập tên phòng
            String tenPhong = Test.inputNonEmptyString("Nhập tên phòng: ");
            
            // CHỌN TRƯỞNG PHÒNG TỪ DANH SÁCH NHÂN VIÊN
            String truongPhong;
            
            if (danhSachNhanVien.isEmpty()) {
                // Nếu chưa có nhân viên, nhập tên trực tiếp
                truongPhong = Test.inputNonEmptyString("Nhập tên trưởng phòng (chưa có nhân viên): ");
            } else {
                System.out.println("\n─── CHỌN TRƯỞNG PHÒNG TỪ DANH SÁCH NHÂN VIÊN ───");
                
                // Hiển thị danh sách nhân viên
                List<String> dsNhanVien = new ArrayList<>();
                for (int i = 0; i < danhSachNhanVien.size(); i++) {
                    NhanVien nv = danhSachNhanVien.get(i);
                    String info = String.format("%d. %s - %s (%s)", 
                        i + 1, nv.getMaNV(), nv.getTenNV(), nv.getChucVu());
                    dsNhanVien.add(info);
                }
                
                // Hiển thị dạng bảng
                Mang.displayAsTable(dsNhanVien, 1);
                
                // Tùy chọn
                System.out.println("\n0. Nhập tên trưởng phòng mới");
                System.out.println("1-" + danhSachNhanVien.size() + ". Chọn nhân viên làm trưởng phòng");
                
                int choiceTP = Test.inputInt("Lựa chọn (0-" + danhSachNhanVien.size() + "): ");
                
                if (choiceTP == 0) {
                    // Nhập tên mới
                    truongPhong = Test.inputNonEmptyString("Nhập tên trưởng phòng: ");
                } else if (choiceTP >= 1 && choiceTP <= danhSachNhanVien.size()) {
                    // Chọn từ danh sách
                    NhanVien nvChon = danhSachNhanVien.get(choiceTP - 1);
                    truongPhong = nvChon.getTenNV();
                    
                    // Cập nhật quyền cho nhân viên thành TRƯỞNG PHÒNG nếu chưa phải
                    if (!nvChon.laTruongPhong()) {
                        nvChon.setQuyen(Quyen.TRUONG_PHONG);
                        System.out.println("✅ Đã cập nhật " + nvChon.getTenNV() + " thành Trưởng phòng");
                    }
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
                }
            }
            
            // Tạo và thêm phòng ban
            PhongBan pb = new PhongBan(maPhong, tenPhong, truongPhong);
            danhSachPhongBan.add(pb);
            
            System.out.println("\n✅ ĐÃ THÊM PHÒNG BAN THÀNH CÔNG!");
            System.out.println("Mã phòng: " + maPhong);
            System.out.println("Tên phòng: " + tenPhong);
            System.out.println("Trưởng phòng: " + truongPhong);
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
    
    // ========== THÊM TÀI SẢN ==========
    public void themTaiSan() {
        System.out.println("\n════════════ THÊM TÀI SẢN MỚI ════════════");
        
        try {
            // Nhập mã tài sản
            String maTS;
            while (true) {
                maTS = Test.inputNonEmptyString("Nhập mã tài sản (TS___): ");
                if (!maTS.matches("TS\\d{3}")) {
                    System.out.println("⚠ Mã tài sản phải có dạng TS + 3 số (VD: TS001)");
                    continue;
                }
                
                if (timTaiSanTheoMa(maTS) != null) {
                    System.out.println("⚠ Mã tài sản đã tồn tại!");
                } else {
                    break;
                }
            }
            
            // Nhập tên tài sản
            String tenTS = Test.inputNonEmptyString("Nhập tên tài sản: ");
            
            // Nhập số lượng
            int soLuong = Test.inputPositiveInt("Nhập số lượng: ");
            
            // Nhập tình trạng với menu lựa chọn
            System.out.println("\nChọn tình trạng:");
            System.out.println("1. Tốt");
            System.out.println("2. Khá");
            System.out.println("3. Hỏng");
            System.out.println("4. Hết khấu hao");
            System.out.println("5. Khác");
            
            int choiceTT = Test.inputInt("Lựa chọn (1-5): ");
            String tinhTrang;
            
            switch (choiceTT) {
                case 1: tinhTrang = "Tốt"; break;
                case 2: tinhTrang = "Khá"; break;
                case 3: tinhTrang = "Hỏng"; break;
                case 4: tinhTrang = "Hết khấu hao"; break;
                default: tinhTrang = Test.inputNonEmptyString("Nhập tình trạng: ");
            }
            
            // Tạo và thêm tài sản
            TaiSan ts = new TaiSan(maTS, tenTS, soLuong, tinhTrang);
            danhSachTaiSan.add(ts);
            
            System.out.println("\n✅ ĐÃ THÊM TÀI SẢN THÀNH CÔNG!");
            System.out.println("Mã TS: " + maTS);
            System.out.println("Tên TS: " + tenTS);
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Tình trạng: " + tinhTrang);
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
    
    // ========== THÊM NHÂN VIÊN ==========
    public void themNhanVien() {
        System.out.println("\n════════════ THÊM NHÂN VIÊN MỚI ════════════");
        
        try {
            // Nhập mã nhân viên
            String maNV;
            while (true) {
                maNV = Test.inputNonEmptyString("Nhập mã nhân viên (NV/TP/ADMIN + số): ");
                if (!maNV.matches("(NV|TP|ADMIN)\\d+")) {
                    System.out.println("⚠ Mã NV phải bắt đầu bằng NV, TP hoặc ADMIN");
                    continue;
                }
                
                if (timNhanVienTheoMa(maNV) != null) {
                    System.out.println("⚠ Mã nhân viên đã tồn tại!");
                } else {
                    break;
                }
            }
            
            // Nhập tên nhân viên
            String tenNV = Test.inputNonEmptyString("Nhập tên nhân viên: ");
            
            // HIỂN THỊ DANH SÁCH CHỨC VỤ ĐỂ CHỌN
            System.out.println("\n─── CHỌN CHỨC VỤ ───");
            String[] chucVuList = {
                "Trưởng phòng",
                "Phó phòng", 
                "Kế toán trưởng",
                "Kế toán viên",
                "Nhân viên hành chính",
                "Nhân viên kinh doanh",
                "Nhân viên nhân sự",
                "Quản trị viên",
                "Khác (nhập tay)"
            };
            
            int choiceCV = Test.showMenu("DANH SÁCH CHỨC VỤ", chucVuList);
            String chucVu;
            
            if (choiceCV >= 1 && choiceCV <= chucVuList.length - 1) {
                chucVu = chucVuList[choiceCV - 1];
                System.out.println("Đã chọn chức vụ: " + chucVu);
            } else if (choiceCV == chucVuList.length) {
                chucVu = Test.inputNonEmptyString("Nhập chức vụ: ");
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
            
            // CHỌN PHÒNG BAN
            System.out.println("\n─── CHỌN PHÒNG BAN ───");
            if (danhSachPhongBan.isEmpty()) {
                System.out.println("Chưa có phòng ban nào!");
                return;
            }
            
            // Hiển thị danh sách phòng ban
            List<String> dsPhong = new ArrayList<>();
            for (int i = 0; i < danhSachPhongBan.size(); i++) {
                PhongBan pb = danhSachPhongBan.get(i);
                dsPhong.add((i + 1) + ". " + pb.getMaPhong() + " - " + pb.getTenPhong());
            }
            Mang.displayAsTable(dsPhong, 2);
            
            int choicePB = Test.inputInt("Chọn phòng (1-" + danhSachPhongBan.size() + "): ");
            if (choicePB < 1 || choicePB > danhSachPhongBan.size()) {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
            PhongBan phongBan = danhSachPhongBan.get(choicePB - 1);
            
            // CHỌN QUYỀN - TỰ ĐỘNG GÁN DỰA TRÊN CHỨC VỤ
            Quyen quyen;
            
            if (chucVu.toLowerCase().contains("trưởng phòng")) {
                quyen = Quyen.TRUONG_PHONG;
                System.out.println("⚠ Tự động gán quyền: TRUONG_PHONG (vì chức vụ là Trưởng phòng)");
                
                // Cập nhật tên trưởng phòng trong phòng ban
                phongBan.setTruongPhong(tenNV);
                System.out.println("✅ Đã cập nhật " + tenNV + " làm trưởng phòng của " + 
                    phongBan.getTenPhong());
            } else if (chucVu.toLowerCase().contains("quản lý") || 
                       chucVu.toLowerCase().contains("quản lý") ||
                       chucVu.toLowerCase().contains("trưởng")) {
                quyen = Quyen.QUAN_LY;
                System.out.println("⚠ Tự động gán quyền: QUAN_LY (vì chức vụ là Quản lý)");
            } else if (chucVu.toLowerCase().contains("admin") || 
                       chucVu.toLowerCase().contains("quản trị")) {
                quyen = Quyen.ADMIN;
                System.out.println("⚠ Tự động gán quyền: ADMIN (vì chức vụ là Admin)");
            } else {
                // Hiển thị menu chọn quyền cho nhân viên thường
                String[] menuQuyen = {
                    "NHAN_VIEN_KK - Nhân viên kiểm kê",
                    "XEM_BAO_CAO - Chỉ xem báo cáo"
                };
                
                System.out.println("\n─── CHỌN QUYỀN CHO NHÂN VIÊN ───");
                int choiceQuyen = Test.showMenu("CHỌN QUYỀN", menuQuyen);
                
                switch (choiceQuyen) {
                    case 1: quyen = Quyen.NHAN_VIEN_KK; break;
                    case 2: quyen = Quyen.XEM_BAO_CAO; break;
                    default: quyen = Quyen.NHAN_VIEN_KK;
                }
            }
            
            // Tạo và thêm nhân viên
            NhanVien nv = new NhanVien(maNV, tenNV, chucVu, phongBan, quyen);
            danhSachNhanVien.add(nv);
            
            System.out.println("\n" + "=".repeat(60));
            System.out.println("✅ ĐÃ THÊM NHÂN VIÊN THÀNH CÔNG!");
            System.out.println("=".repeat(60));
            System.out.println("Mã NV: " + maNV);
            System.out.println("Tên NV: " + tenNV);
            System.out.println("Chức vụ: " + chucVu);
            System.out.println("Phòng: " + phongBan.getTenPhong() + " (" + phongBan.getMaPhong() + ")");
            System.out.println("Quyền: " + quyen.getTenQuyen());
            System.out.println("Trưởng phòng: " + phongBan.getTruongPhong());
            System.out.println("=".repeat(60));
            
            // Hỏi thêm nhân viên khác
            if (Test.inputYesNo("Bạn có muốn thêm nhân viên khác ngay bây giờ?")) {
                themNhanVien();
            }
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
    
    // ========== HIỂN THỊ DANH SÁCH ==========
    public void hienThiDanhSachPhongBan() {
        System.out.println("\n════════════ DANH SÁCH PHÒNG BAN ════════════");
        
        if (danhSachPhongBan.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (PhongBan pb : danhSachPhongBan) {
            String info = String.format("%s - %s | TP: %s", 
                pb.getMaPhong(), pb.getTenPhong(), pb.getTruongPhong());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        System.out.println("Tổng cộng: " + danhSachPhongBan.size() + " phòng ban");
    }
    
    public void hienThiDanhSachTaiSan() {
        System.out.println("\n════════════ DANH SÁCH TÀI SẢN ════════════");
        
        if (danhSachTaiSan.isEmpty()) {
            System.out.println("Chưa có tài sản nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (TaiSan ts : danhSachTaiSan) {
            String info = String.format("%s: %s x%d - %s", 
                ts.getMaTS(), ts.getTenTS(), ts.getSoLuong(), ts.getTinhTrang());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        
        // Thống kê
        int tongSoLuong = 0;
        int[] soLuongArray = new int[danhSachTaiSan.size()];
        
        for (int i = 0; i < danhSachTaiSan.size(); i++) {
            int sl = danhSachTaiSan.get(i).getSoLuong();
            soLuongArray[i] = sl;
            tongSoLuong += sl;
        }
        
        System.out.println("\n📊 Thống kê:");
        System.out.println("• Tổng số loại tài sản: " + danhSachTaiSan.size());
        System.out.println("• Tổng số lượng: " + tongSoLuong);
        System.out.println("• Trung bình số lượng/loại: " + Mang.averageArray(soLuongArray));
    }
    
    public void hienThiDanhSachNhanVien() {
        System.out.println("\n════════════ DANH SÁCH NHÂN VIÊN ════════════");
        
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }
        
        List<String> dsHienThi = new ArrayList<>();
        for (NhanVien nv : danhSachNhanVien) {
            String info = String.format("%s: %s - %s | %s", 
                nv.getMaNV(), nv.getTenNV(), nv.getChucVu(),
                nv.getPhongBan().getTenPhong());
            dsHienThi.add(info);
        }
        
        Mang.displayAsTable(dsHienThi, 2);
        
        // Thống kê
        System.out.println("\n📊 Thống kê:");
        System.out.println("• Tổng số nhân viên: " + danhSachNhanVien.size());
        
        Map<Quyen, Integer> thongKeQuyen = new HashMap<>();
        for (NhanVien nv : danhSachNhanVien) {
            Quyen q = nv.getQuyen();
            thongKeQuyen.put(q, thongKeQuyen.getOrDefault(q, 0) + 1);
        }
        
        for (Map.Entry<Quyen, Integer> entry : thongKeQuyen.entrySet()) {
            System.out.println("• " + entry.getKey().getTenQuyen() + ": " + entry.getValue() + " người");
        }
    }
    
    // ========== TÌM KIẾM ==========
    private PhongBan timPhongBanTheoMa(String maPhong) {
        for (PhongBan pb : danhSachPhongBan) {
            if (pb.getMaPhong().equalsIgnoreCase(maPhong)) {
                return pb;
            }
        }
        return null;
    }
    
    private TaiSan timTaiSanTheoMa(String maTS) {
        for (TaiSan ts : danhSachTaiSan) {
            if (ts.getMaTS().equalsIgnoreCase(maTS)) {
                return ts;
            }
        }
        return null;
    }
    
    private NhanVien timNhanVienTheoMa(String maNV) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return nv;
            }
        }
        return null;
    }
    
    // ========== THÊM PHIẾU KIỂM KÊ ==========
    public void nhapPhieuKiemKeTuBanPhim() {
        System.out.println("\n════════════ NHẬP PHIẾU KIỂM KÊ MỚI ════════════");
        
        try {
            // Nhập mã phiếu
            String maPhieu;
            while (true) {
                maPhieu = Test.inputNonEmptyString("Nhập mã phiếu (PH__): ");
                if (!maPhieu.matches("PH\\d+")) {
                    System.out.println("⚠ Mã phiếu phải bắt đầu bằng 'PH' và có số!");
                    continue;
                }
                
                boolean trung = false;
                for (PhieuKiemKe p : danhSachPhieu) {
                    if (p.getMaPhieu().equals(maPhieu)) {
                        trung = true;
                        break;
                    }
                }
                if (!trung) break;
                System.out.println("⚠ Mã phiếu đã tồn tại!");
            }
            
            // Nhập ngày
            LocalDate ngayKiemKe = Test.inputDateNotFuture("Nhập ngày kiểm kê");
            
            // Chọn nhân viên
            System.out.println("\n─── CHỌN NHÂN VIÊN KIỂM KÊ ───");
            if (danhSachNhanVien.isEmpty()) {
                System.out.println("Chưa có nhân viên!");
                return;
            }
            
            List<String> dsNV = new ArrayList<>();
            List<NhanVien> nvCoQuyen = new ArrayList<>();
            
            for (int i = 0; i < danhSachNhanVien.size(); i++) {
                NhanVien nv = danhSachNhanVien.get(i);
                Quyen q = nv.getQuyen();
                if (q == Quyen.ADMIN || q == Quyen.TRUONG_PHONG || 
                    q == Quyen.QUAN_LY || q == Quyen.NHAN_VIEN_KK) {
                    dsNV.add((i + 1) + ". " + nv.getTenNV() + " - " + nv.getChucVu());
                    nvCoQuyen.add(nv);
                }
            }
            
            if (nvCoQuyen.isEmpty()) {
                System.out.println("Không có NV có quyền kiểm kê!");
                return;
            }
            
            Mang.displayAsTable(dsNV, 2);
            
            int choiceNV = Test.inputInt("Chọn nhân viên (1-" + nvCoQuyen.size() + "): ");
            if (choiceNV < 1 || choiceNV > nvCoQuyen.size()) {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
            NhanVien nhanVienKK = nvCoQuyen.get(choiceNV - 1);
            
            // Chọn phòng
            System.out.println("\n─── CHỌN PHÒNG KIỂM KÊ ───");
            List<String> dsPhong = new ArrayList<>();
            for (int i = 0; i < danhSachPhongBan.size(); i++) {
                PhongBan pb = danhSachPhongBan.get(i);
                dsPhong.add((i + 1) + ". " + pb.getMaPhong() + " - " + pb.getTenPhong());
            }
            
            Mang.displayAsTable(dsPhong, 2);
            
            int choicePB = Test.inputInt("Chọn phòng (1-" + danhSachPhongBan.size() + "): ");
            if (choicePB < 1 || choicePB > danhSachPhongBan.size()) {
                System.out.println("Lựa chọn không hợp lệ!");
                return;
            }
            PhongBan phongBanKK = danhSachPhongBan.get(choicePB - 1);
            
            // Kiểm tra quyền
            if (!kiemTraQuyenKiemKe(nhanVienKK, phongBanKK)) {
                System.out.println("⚠ NV không có quyền kiểm kê phòng này!");
                return;
            }
            
            // Tạo phiếu
            PhieuKiemKe phieu = new PhieuKiemKe(maPhieu, ngayKiemKe, nhanVienKK, phongBanKK);
            
            // Nhập tài sản
            System.out.println("\n─── NHẬP DANH SÁCH TÀI SẢN ───");
            int stt = 1;
            boolean tiepTuc = true;
            
            while (tiepTuc && stt <= 10) {
                System.out.println("\n📦 Tài sản thứ " + stt);
                
                String maTS = Test.inputNonEmptyString("Mã tài sản: ");
                String tenTS = Test.inputNonEmptyString("Tên tài sản: ");
                int soLuong = Test.inputPositiveInt("Số lượng: ");
                String tinhTrang = Test.inputNonEmptyString("Tình trạng: ");
                
                try {
                    TaiSan taiSan = new TaiSan(maTS, tenTS, soLuong, tinhTrang);
                    phieu.themTaiSan(taiSan);
                    stt++;
                    
                    if (stt <= 10) {
                        tiepTuc = Test.inputYesNo("Thêm tài sản khác?");
                    }
                } catch (Exception e) {
                    System.out.println("❌ Lỗi: " + e.getMessage());
                }
            }
            
            if (stt == 1) {
                System.out.println("Phải có ít nhất 1 tài sản!");
                return;
            }
            
            danhSachPhieu.add(phieu);
            System.out.println("\n✅ THÊM PHIẾU THÀNH CÔNG!");
            phieu.xuatBaoCao();
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
    
    private boolean kiemTraQuyenKiemKe(NhanVien nv, PhongBan phong) {
        if (nv == null || phong == null) return false;
        
        Quyen quyen = nv.getQuyen();
        boolean cungPhong = nv.getPhongBan().getMaPhong().equals(phong.getMaPhong());
        
        switch (quyen) {
            case ADMIN:
                return true;
            case TRUONG_PHONG:
            case QUAN_LY:
                return cungPhong || quyen.coQuyenCaoHon(Quyen.TRUONG_PHONG);
            case NHAN_VIEN_KK:
                return cungPhong;
            default:
                return false;
        }
    }
    
    // ========== XUẤT BÁO CÁO ==========
    public void xuatBaoCaoTheoMaPhieu() {
        System.out.println("\n════════════ XUẤT BÁO CÁO THEO MÃ PHIẾU ════════════");
        
        if (danhSachPhieu.isEmpty()) {
            System.out.println("Chưa có phiếu nào!");
            return;
        }
        
        String maPhieu = Test.inputNonEmptyString("Nhập mã phiếu: ");
        
        for (PhieuKiemKe phieu : danhSachPhieu) {
            if (phieu.getMaPhieu().equalsIgnoreCase(maPhieu)) {
                phieu.xuatBaoCao();
                return;
            }
        }
        
        System.out.println("❌ Không tìm thấy phiếu với mã: " + maPhieu);
    }
    
    public void xuatTatCaBaoCao() {
        System.out.println("\n════════════ DANH SÁCH TẤT CẢ PHIẾU KIỂM KÊ ════════════");
        
        if (danhSachPhieu.isEmpty()) {
            System.out.println("Chưa có phiếu nào!");
            return;
        }
        
        // Hiển thị tóm tắt
        System.out.println("TỔNG HỢP " + danhSachPhieu.size() + " PHIẾU KIỂM KÊ:");
        System.out.println("=".repeat(80));
        
        for (int i = 0; i < danhSachPhieu.size(); i++) {
            PhieuKiemKe phieu = danhSachPhieu.get(i);
            System.out.printf("%d. %s - %s - %s - %d loại - %d cái\n",
                i + 1,
                phieu.getMaPhieu(),
                phieu.getNgayKiemKe().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                phieu.getPhongBanKK().getTenPhong(),
                phieu.soLoaiTaiSan(),
                phieu.tongSoLuong());
        }
        
        // Thống kê
        int[] soLuongArray = new int[danhSachPhieu.size()];
        for (int i = 0; i < danhSachPhieu.size(); i++) {
            soLuongArray[i] = danhSachPhieu.get(i).tongSoLuong();
        }
        
        System.out.println("\n📊 THỐNG KÊ:");
        System.out.println("• Tổng số phiếu: " + danhSachPhieu.size());
        System.out.println("• Tổng số lượng tài sản: " + Mang.sumArray(soLuongArray));
        System.out.println("• Trung bình số lượng/phiếu: " + Mang.averageArray(soLuongArray));
    }
    
    // ========== XEM CHI TIẾT PHÒNG BAN ==========
    public void xemChiTietPhongBan() {
        System.out.println("\n════════════ CHI TIẾT PHÒNG BAN ════════════");
        
        if (danhSachPhongBan.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        
        // Hiển thị danh sách phòng để chọn
        List<String> dsPhong = new ArrayList<>();
        for (int i = 0; i < danhSachPhongBan.size(); i++) {
            PhongBan pb = danhSachPhongBan.get(i);
            dsPhong.add((i + 1) + ". " + pb.getMaPhong() + " - " + pb.getTenPhong());
        }
        Mang.displayAsTable(dsPhong, 2);
        
        int choice = Test.inputInt("Chọn phòng để xem chi tiết (1-" + danhSachPhongBan.size() + "): ");
        if (choice < 1 || choice > danhSachPhongBan.size()) {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }
        
        PhongBan pb = danhSachPhongBan.get(choice - 1);
        
        // Hiển thị thông tin phòng
        System.out.println("\n" + "=".repeat(60));
        System.out.println("THÔNG TIN PHÒNG BAN");
        System.out.println("=".repeat(60));
        System.out.println("Mã phòng: " + pb.getMaPhong());
        System.out.println("Tên phòng: " + pb.getTenPhong());
        System.out.println("Trưởng phòng: " + pb.getTruongPhong());
        
        // Danh sách nhân viên trong phòng
        System.out.println("\nDANH SÁCH NHÂN VIÊN TRONG PHÒNG:");
        System.out.println("-".repeat(60));
        
        List<NhanVien> nvTrongPhong = new ArrayList<>();
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getPhongBan().getMaPhong().equals(pb.getMaPhong())) {
                nvTrongPhong.add(nv);
            }
        }
        
        if (nvTrongPhong.isEmpty()) {
            System.out.println("Chưa có nhân viên nào trong phòng này");
        } else {
            List<String> dsNV = new ArrayList<>();
            for (NhanVien nv : nvTrongPhong) {
                String truongPhongFlag = nv.laTruongPhong() ? " [TRƯỞNG PHÒNG]" : "";
                String info = String.format("%s - %s - %s%s", 
                    nv.getMaNV(), nv.getTenNV(), nv.getChucVu(), truongPhongFlag);
                dsNV.add(info);
            }
            Mang.displayAsTable(dsNV, 1);
            System.out.println("Tổng cộng: " + nvTrongPhong.size() + " nhân viên");
        }
        System.out.println("=".repeat(60));
    }
    
    // ========== MENU CHÍNH ==========
    public void hienThiMenu() {
        String[] menuChinh = {
            "Thêm phiếu kiểm kê mới",
            "Xuất báo cáo theo mã phiếu",
            "Xem tất cả phiếu kiểm kê",
            "--- QUẢN LÝ PHÒNG BAN ---",
            "Thêm phòng ban mới",
            "Xem danh sách phòng ban",
            "Xem chi tiết phòng ban",
            "--- QUẢN LÝ TÀI SẢN ---",
            "Thêm tài sản mới",
            "Xem danh sách tài sản",
            "--- QUẢN LÝ NHÂN VIÊN ---",
            "Thêm nhân viên mới",
            "Xem danh sách nhân viên",
            "Thoát"
        };
        
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        
        while (running) {
            System.out.println("\n" + "★".repeat(70));
            System.out.println("           HỆ THỐNG QUẢN LÝ KIỂM KÊ TÀI SẢN");
            System.out.println("★".repeat(70));
            
            // Thống kê nhanh
            System.out.println("📊 THỐNG KÊ HỆ THỐNG:");
            System.out.printf("   • %-15s: %d phòng\n", "Phòng ban", danhSachPhongBan.size());
            System.out.printf("   • %-15s: %d người\n", "Nhân viên", danhSachNhanVien.size());
            System.out.printf("   • %-15s: %d loại\n", "Tài sản", danhSachTaiSan.size());
            System.out.printf("   • %-15s: %d phiếu\n", "Phiếu kiểm kê", danhSachPhieu.size());
            System.out.println("★".repeat(70));
            
            int choice = Test.showMenu("MENU CHÍNH", menuChinh);
            
            switch (choice) {
                case 1:
                    nhapPhieuKiemKeTuBanPhim();
                    break;
                case 2:
                    xuatBaoCaoTheoMaPhieu();
                    break;
                case 3:
                    xuatTatCaBaoCao();
                    break;
                case 4: // Phân cách
                    break;
                case 5:
                    themPhongBan();
                    break;
                case 6:
                    hienThiDanhSachPhongBan();
                    break;
                case 7:
                    xemChiTietPhongBan();
                    break;
                case 8: // Phân cách
                    break;
                case 9:
                    themTaiSan();
                    break;
                case 10:
                    hienThiDanhSachTaiSan();
                    break;
                case 11: // Phân cách
                    break;
                case 12:
                    themNhanVien();
                    break;
                case 13:
                    hienThiDanhSachNhanVien();
                    break;
                case 14:
                    if (Test.confirmAction("Bạn có chắc muốn thoát?")) {
                        running = false;
                        System.out.println("\n👋 Cảm ơn đã sử dụng hệ thống!");
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("⚠ Lựa chọn không hợp lệ!");
            }
            
            if (choice != 0 && running) {
                System.out.println("\n↵ Nhấn Enter để tiếp tục...");
                sc.nextLine();
            }
        }
    }
}
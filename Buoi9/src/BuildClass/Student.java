package BuildClass;

public class Student {
    // Thuộc tính
    private String id;
    private String ten;
    private double diemTB;
    
    // Constructor mặc định
    public Student() {
        this.id = "SV000";
        this.ten = "Chưa có tên";
        this.diemTB = 0.0;
    }
    
    // Constructor có tham số
    public Student(String id, String ten, double diemTB) {
        this.id = id;
        this.ten = ten;
        setDiemTB(diemTB); // Dùng setter để kiểm tra
    }
    
    // Getter - Setter
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public double getDiemTB() {
        return diemTB;
    }
    
    public void setDiemTB(double diemTB) {
        // Kiểm tra điểm từ 0-10
        if (diemTB < 0) {
            this.diemTB = 0;
        } else if (diemTB > 10) {
            this.diemTB = 10;
        } else {
            this.diemTB = diemTB;
        }
    }
    
    // Phương thức xếp loại học lực
    public String xepLoai() {
        if (diemTB >= 8) return "Giỏi";
        else if (diemTB >= 6.5) return "Khá";
        else if (diemTB >= 5) return "Trung bình";
        else return "Yếu";
    }
    
    // Phương thức toString
    @Override
    public String toString() {
        return String.format("│ %-10s │ %-25s │ %8.2f │ %-12s │",
            id, ten, diemTB, xepLoai());
    }
    
    // Phương thức hiển thị ngắn
    public String toStringNgan() {
        return String.format("%-10s %-25s %8.2f %12s",
            id, ten, diemTB, xepLoai());
    }
}
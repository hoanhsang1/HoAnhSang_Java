package BuildClass;

import java.util.Comparator;

public class SortByDiemTB implements Comparator<Student> {
    // Sắp xếp tăng dần theo điểm trung bình
    @Override
    public int compare(Student sv1, Student sv2) {
        return Double.compare(sv1.getDiemTB(), sv2.getDiemTB());
    }
}
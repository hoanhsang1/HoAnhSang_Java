package test;

public class Book {
	private String tieude;
	private int giabia;
	
	// constructor
	public Book(String tieude, int giabia) {
		this.tieude = tieude; this.giabia = giabia;
	}
	
	public Book() {};
	
	//get
	public String GetTieuDe() {return this.tieude;}
	public int GetGiaBia() {return this.giabia;}
	
	//set
	public void SetTieuDe(String tieude) {this.tieude = tieude;}
	public void SetGiaBan (int giabia) {
		if (giabia<0) {
			System.out.println("Vui lòng nhập giá lớn hơn 0.");
		}
		this.giabia = giabia;
	}
	
	//in thông tin
	public void InThongTin() {
		System.out.println("Tên sách là: "+tieude);
		System.out.println("Giá bìa là: "+giabia);
	}
}
	
package bai1;

public class Person {
	protected String Name;
	protected int Age;
	
	
	//constructor
	public Person() {};
	
	public Person(String name, int age) {
		this.Name = name;
		this.Age = age;
	}
	
	//get
	public String getName() {return this.Name;};
	public int getAge() {return this.Age;};
	
	//set 
	public void setName(String name) {this.Name=name;};
	public void setAge(int age) {this.Age = age;};
	
	@Override
    public String toString() {
        return String.format("%s|%d", Name, Age);
    }
}

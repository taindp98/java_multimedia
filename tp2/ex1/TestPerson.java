import util.Person;
//main
class TestPerson{
public static void main(String args[]){
	// ex1
	Person person1 = new Person();
	// Name
	person1.setName("Remi");
	System.out.println("This is: " + person1.getName());
	// Address
	person1.setAdd("Villetaneuse");
	System.out.println("His address is: " + person1.getAdd());
	// Telephone
	person1.setTel(1234);
	System.out.printf("His number phone is: %d%n", person1.getTel());
}
}

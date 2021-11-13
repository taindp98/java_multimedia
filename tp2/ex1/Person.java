package util;

public class Person {
	private String personName;
	private String personAdd;
	private int personTel;

	public Person() {
		}

	public void setName(String name){
		personName = name;
	}
	public String getName(){
		return personName;
	}
	public void setAdd(String add){
		personAdd = add;
	}

	public String getAdd(){
		return personAdd;
	}

	public void setTel(int tel){
		personTel = tel;
	}

	public int getTel(){
		return personTel;
	}
}
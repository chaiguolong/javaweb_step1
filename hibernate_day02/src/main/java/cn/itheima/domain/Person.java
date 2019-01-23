package cn.itheima.domain;
public class Person {
	private String name;
	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" +
			"name = " + getName() +
			", age = " + getAge() +
			"}";
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

}




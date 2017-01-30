
package org.bildit.DTO;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class User {
	private int id;
	private String name;
	private int pass;
	private int age;
	public User(int id, String name, int pass, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPass() {
		return pass;
	}
	public int getAge() {
		return age;
	}
}


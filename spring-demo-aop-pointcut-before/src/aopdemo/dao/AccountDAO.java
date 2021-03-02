package aopdemo.dao;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	public String name;
	public String level;
	
	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}
	
	public String getLevel() {
		System.out.println(getClass() + ": in getLevel");
		return level;
	}
	
	public void setLevel(String level) {
		System.out.println(getClass() + ": in setLevel");
		this.level = level;
	}
	
	public void addAccount( Account theAccount) {
		System.out.println(getClass() + " Doing work: adding an account");
	}

	public void sayHi() {
		System.out.println(getClass() + " Just saying hi!");
	}

}

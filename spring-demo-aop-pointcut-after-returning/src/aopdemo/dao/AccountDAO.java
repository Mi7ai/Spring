package aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String level;
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<Account>();
		
		myAccounts.add(new Account("Mike","Silver1"));
		myAccounts.add(new Account("Jake","Silver2"));
		myAccounts.add(new Account("Dowe","Silver3"));
		
		return myAccounts;
	}
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

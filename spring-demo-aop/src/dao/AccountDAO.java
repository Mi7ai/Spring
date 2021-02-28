package dao;

import org.springframework.stereotype.Component;

import aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount( Account theAccount) {
		System.out.println(getClass() + " Doing work: adding an account");
	}

	public void sayHi() {
		System.out.println(getClass() + " Just saying hi!");
	}

}

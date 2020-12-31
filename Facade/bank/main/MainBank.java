package main;

import bank.facade.BankFacade;

public class MainBank {

	public static void main(String[] args) {

		BankFacade b = new BankFacade();
		b.getUtil().dropDatabase();
		b.getUtil().createDatabase();
	}
}

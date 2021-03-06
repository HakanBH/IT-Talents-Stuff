package Homework11.Bank;

import java.util.Collection;
import java.util.HashSet;

public class Client implements IClient {
	private String name;
	private String address;
	private double money;
	private double salary;
	private Bank bank; // ���������� ��, �� ��������� ����������� ��� �����
						// �����
						// ������ ������� � �� ����� ����� �� ������� � �����
						// �����

	private Collection<Deposit> deposits;
	private Collection<Credit> credits;

	public Client(String name, Bank bank) {
		setName(name);
		setBank(bank);
		deposits = new HashSet<Deposit>();
		credits = new HashSet<Credit>();
	}

	@Override
	//��������� �� ������� �� ���������� ���� � ������
	public void openDeposit(double depositSize, int numberOfMonths) throws Exception {
		if(depositSize<=this.money){
			Deposit d = new Deposit(depositSize, numberOfMonths);
			d.setName(name + "'s deposit " + (deposits.size()+1));
			deposits.add(d);
			bank.acceptDeposit(d);
			setMoney(money-depositSize);
		}else{
			throw new Exception("Not enough money to open deposit!");
		}
	}

	@Override
	//������� �� ������ �� ���������� ���� � ������
	public void demandCredit(double sum, int numberOfMonths){
		if(this.monthlyCreditPayment() > (salary/2)){
			System.out.println("Sorry. Your credit was not approved!");
		}else{
			Credit c = new Credit(sum,numberOfMonths);
			if(bank.openCredit(c))
			{
				credits.add(c);
				this.money += sum;
			}
		}
	}
	
	@Override
	public void payCredits() {
		money -= this.monthlyCreditPayment();
		bank.addMoneyToBank(this.monthlyCreditPayment());
	}
	
	public double monthlyCreditPayment(){
		double payment=0;
		for(Credit c: credits){
			payment += c.getMonthlyPayment(); 
		}
		return payment;
	}
	
	@Override
	public String toString() {
		return this.name + ", Salary: " + this.salary + ", Cash: " + this.money;
	}
	
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getMoney() {
		return money;
	}

	public double getSalary() {
		return salary;
	}

	public Bank getBank() throws CloneNotSupportedException {
		return (Bank) this.clone();
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}

	public void setAddress(String address) {
		if (name != null && !name.isEmpty()) {
			this.address = address;
		}
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setSalary(double salary) {
		if (salary >= 280) {
			this.salary = salary;
		}
	}

	public void setBank(Bank bank) {
		if (bank != null) {
			this.bank = bank;
		}
	}

}

package com.test.model;

public class MetroSmartCard {
	private double balance;
	private boolean isValid;
	private boolean isSwiped = false;
	private long cardNo;

	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public boolean isSwiped() {
		return isSwiped;
	}
	public void setSwiped(boolean isSwiped) {
		this.isSwiped = isSwiped;
	}
	public MetroSmartCard(double balance, boolean isValid, boolean isSwiped,
			long cardNo) {
		super();
		this.balance = balance;
		this.isValid = isValid;
		this.isSwiped = isSwiped;
		this.cardNo = cardNo;
	}

}

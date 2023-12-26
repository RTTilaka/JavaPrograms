package com.example.prg1Practice;

public class Ticket {
	int ticNo,price,seatNo;
	public int getTicNo() {
		return ticNo;
	}
	public void setTicNo(int ticNo) {
		this.ticNo = ticNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getTicType() {
		return ticType;
	}
	public void setTicType(String ticType) {
		this.ticType = ticType;
	}
	String ticType;
}

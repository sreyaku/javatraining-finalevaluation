package com.librarymanagement.clientserver.dto;

public class bookIssual {

	private String iid;// issue id
	private String issueddate;
	private String uid;// user id
	private String bid;// book id
	private int period;
	private String returndate;
	@SuppressWarnings("unused")
	private int fine;
	private String bookstatus;

	public String getIid() {
		return iid;

	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getIssueddate() {
		return issueddate;

	}

	public void setIssueddate(String issued_date) {
		this.issueddate = issueddate;
	}

	public String getBid() {
		return bid;

	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getUid() {
		return uid;

	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getPeriod() {
		return period;

	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getReturndate() {
		return returndate;

	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;

	}

	public static int getFine() {
		return 5;

	}

	public void setFine(int fine) {
		this.fine = fine;

	}

	public String setBookstatus(String string) {
		return bookstatus;

	}

	public String getBookname() {

		return null;
	}

	public String setBookname(String Bookname) {
		return Bookname;

	}

}

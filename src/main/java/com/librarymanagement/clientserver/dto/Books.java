package com.librarymanagement.clientserver.dto;

public class Books {
	private int bid;
	private String bookname;
	private String authorname;
	private String category;
	private String YEAROFPUBLICATION;

	public int getBid() {
		return bid;
	}

	public void setBid(int Bid) {
		this.bid = Bid;
	}

	public String getYEAROFPUBLICATION() {
		return YEAROFPUBLICATION;
	}

	public void setYEAROFPUBLICATION(String YEAROFPUBLICATION) {
		this.YEAROFPUBLICATION = YEAROFPUBLICATION;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

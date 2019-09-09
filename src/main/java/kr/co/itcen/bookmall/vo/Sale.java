package kr.co.itcen.bookmall.vo;

public class Sale {
	private Long no;
	private Long Saleprice;
	private String Saletitle;
	private Long booknum;
	public Long getBooknum() {
		return booknum;
	}
	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getSaleprice() {
		return Saleprice;
	}
	public void setSaleprice(Long saleprice) {
		Saleprice = saleprice;
	}
	public String getSaletitle() {
		return Saletitle;
	}
	public void setSaletitle(String saletitle) {
		Saletitle = saletitle;
	}
	@Override
	public String toString() {
		return "Sale [no=" + no + ", Saleprice=" + Saleprice + ", Saletitle=" + Saletitle + ", booknum=" + booknum
				+ "]";
	}
}

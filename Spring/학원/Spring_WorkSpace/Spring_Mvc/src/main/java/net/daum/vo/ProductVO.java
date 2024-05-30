package net.daum.vo;

public class ProductVO {//데이터 저장빈 클래스

	private String productName;//상품이름
	private String productPrice;//상품가격
	
	public ProductVO(String productName, String productPrice) {
		this.productName=productName;
		this.productPrice=productPrice;
	}//전달인자 개수가 다른 생성자 오버로딩

	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	@Override
	public String toString() {
		
		return "상품이름 = " + productName + ", 상품가격 = " + productPrice;
	}//toString()메서드 오버라이딩		
}








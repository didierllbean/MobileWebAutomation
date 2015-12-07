package DataObjects;

import org.testng.annotations.Optional;

public class ProductData {

	private String productID;
	private String productName;
	private String productColor;
	private String productSize;
	private String productQty;
	private String productSizeType;
	private String productPrice;
	
	public ProductData(String id, String name, String price, @Optional String color, @Optional String size, @Optional String qty, @Optional String type) {
		setProductID(id);
		setProductName(name);
		setProductPrice(price);
		
		if(color != null)
			setProductColor(color);
		if(size != null)
			setProductSize(size);
		if(qty != null)
			setProductQty(qty);
		if(type != null)
			setProductSizeType(type);
	}
	
	public String getProductID() {	return productID;	}
	public void setProductID(String productID) { this.productID = productID; }
	
	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName; }
	
	public String getProductColor() { return productColor; }
	public void setProductColor(String productColor) { this.productColor = productColor; }
	
	public String getProductSize() { return productSize; }
	public void setProductSize(String productSize) { this.productSize = productSize; }
	
	public String getProductQty() {	return productQty;	}
	public void setProductQty(String productQty) {	this.productQty = productQty; }
	
	public String getProductSizeType() { return productSizeType; }
	public void setProductSizeType(String productSizeType) { this.productSizeType = productSizeType; }	
	
	public String getProductPrice() { return productPrice; }
	public void setProductPrice(String productPrice) {	this.productPrice = productPrice; }
}

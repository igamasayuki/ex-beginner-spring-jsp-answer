package jp.co.sample.java_marathon_beginner.domain;

/**
 * 商品情報を表すドメイン.
 * 
 * @author igamasayuki
 *
 */
public class Item {
	/** 商品名*/
	private String name; 	
	/** 商品価格*/
	private Integer price;  
	
	public Item(){}
	
	public Item(String name, Integer price) {
		this.name=name;
		this.price=price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}

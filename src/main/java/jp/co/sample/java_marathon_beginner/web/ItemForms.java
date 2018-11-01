package jp.co.sample.java_marathon_beginner.web;

import org.hibernate.validator.constraints.Length;

/**
 * 商品情報のリクエストパラメータ用フォームクラス.
 * @author igamasayuki
 *
 */
public class ItemForms {
	
	/** 商品１の価格 */
	@Length(min=1,message="入力してください" )
	private String goods1;
	/** 商品２の価格 */
	@Length(min=1,message="入力してください" )
	private String goods2;
	/** 商品３の価格 */
	@Length(min=1,message="入力してください" )
	private String goods3;
	
	public String getGoods1() {
		return goods1;
	}
	public void setGoods1(String goods1) {
		this.goods1 = goods1;
	}
	public String getGoods2() {
		return goods2;
	}
	public void setGoods2(String goods2) {
		this.goods2 = goods2;
	}
	public String getGoods3() {
		return goods3;
	}
	public void setGoods3(String goods3) {
		this.goods3 = goods3;
	}

}

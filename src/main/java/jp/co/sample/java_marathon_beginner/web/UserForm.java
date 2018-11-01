package jp.co.sample.java_marathon_beginner.web;

import org.hibernate.validator.constraints.Length;

/**
 * ユーザ情報のリクエストパラメータ用フォームクラス.
 * @author igamasayuki
 *
 */
public class UserForm {
	/** ID */
	@Length(min=1,message = "入力されていません")
	private String id;	
	/** 名前 */
	private String name;
	/** 年齢 */
	private String age;
	/** 住所 */
	private String address;

	/**
	 * age（年齢）をint型に変換.
	 * @return int型に変換された年齢
	 */
	public Integer getIntAge(){
		return Integer.parseInt(age);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge(){
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

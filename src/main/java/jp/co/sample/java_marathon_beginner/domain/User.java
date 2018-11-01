package jp.co.sample.java_marathon_beginner.domain;

/**
 * ユーザ情報を表すドメイン.
 * @author igamasayuki
 *
 */
public class User {
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** 住所 */
	private String address;
	
	public User(){}
	
	public User(Integer id, String name, String age, String address) {
		this.id = id;
		this.name = name;
		this.age = Integer.parseInt(age);
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

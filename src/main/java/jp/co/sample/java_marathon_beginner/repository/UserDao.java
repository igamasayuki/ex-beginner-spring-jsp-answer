package jp.co.sample.java_marathon_beginner.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.sample.java_marathon_beginner.domain.User;

/**
 * infoテーブル操作用のリポジトリクラス.
 * 
 * @author igamasayuki
 *
 */
@Repository
public class UserDao {

	/**
	 * ResultSetオブジェクトからUserオブジェクトに変換するためのクラス実装&インスタンス化
	 */
	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String age = rs.getString("age");
		String address = rs.getString("address");
		return new User(id, name, age, address);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * IDから1件のユーザー情報を取得する.
	 * 
	 * @param id
	 *            検索したいユーザーID
	 * @return 検索されたユーザー情報 0件の時はnullが返る
	 */
	public User load(Integer id) {
		
		String sql = "SELECT id,name,age,address FROM info WHERE id= :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		try {
			User user = jdbcTemplate.queryForObject(sql, param,USER_ROW_MAPPER);
			
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}

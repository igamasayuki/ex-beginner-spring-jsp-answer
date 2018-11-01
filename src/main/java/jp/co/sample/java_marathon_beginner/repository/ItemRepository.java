package jp.co.sample.java_marathon_beginner.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.java_marathon_beginner.domain.Item;

/**
 * itemsテーブル操作用のリポジトリクラス.
 * 
 * @author igamasayuki
 *
 */
@Repository
public class ItemRepository {

	/**
	 * ResultSetオブジェクトからItemオブジェクトに変換するためのクラス実装&インスタンス化
	 */
	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		String name = rs.getString("name");
		Integer price = rs.getInt("price");
		return new Item(name, price);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * 商品情報一覧を取得する.
	 * @return 顧客情報一覧 0件の時は0件のリストが返る
	 */
	public List<Item> findAll() {
		List<Item> items = jdbcTemplate.query(
				"SELECT id,name,price FROM item ORDER BY id",
				ITEM_ROW_MAPPER);
		return items;
	}
	
	/**
	 * IDから1件の商品情報を取得し、カートリストに追加する.
	 * 
	 * @param id
	 *            検索したい商品ID
	 * @return 商品を追加したカートリスト 0件の時はnullが返る
	 */
	public Item save(Integer id) {
		
		String sql = "SELECT name,price FROM item WHERE id= :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		try {
			Item item = jdbcTemplate.queryForObject(sql, param,ITEM_ROW_MAPPER);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * IDから1件の商品を削除する.
	 * @param id ID
	 */
	public void delete (Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update("DELETE FROM items WHERE id=:id", 
				param);
	}

}

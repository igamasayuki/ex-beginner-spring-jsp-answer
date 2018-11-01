package jp.co.sample.java_marathon_beginner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.java_marathon_beginner.domain.Item;
import jp.co.sample.java_marathon_beginner.repository.ItemRepository;

/**
 * 商品関連サービスクラス.
 * @author igamasayuki
 *
 */
@Service
public class ItemService {
    
	@Autowired
    private ItemRepository itemRepository;
    
        
	/**
	 * 引数でもらった商品情報をカートに入れる.
	 * @param 　情報
	 * @return 登録された顧客情報
	 */
    public Item inCart(Integer id) {
        return itemRepository.save(id);
    }
    
	/**
	 * IDから1件の商品情報を削除する.
	 * @param id ID
	 */
    public void delete(Integer id) {
        itemRepository.delete(id);
    }
}

package jp.co.sample.java_marathon_beginner.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.java_marathon_beginner.domain.Item;

/**
 * ショッピングカートを操作するコントローラー.
 * 
 * @author igamasayuki
 */
@Controller
@RequestMapping(value = "/25km")
public class ShoppingCartController {

	@Autowired
	private ServletContext application;

	@Autowired
	private HttpSession session;

	/**
	 * 商品一覧とカートの中身を表示する.
	 * 
	 * @param model モデル
	 * @return 商品一覧とカートの中身を表示する画面
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {

		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		if(itemList == null) {
			itemList = new ArrayList<>();
			itemList.add(new Item("手帳ノート", 1000));
			itemList.add(new Item("文房具セット", 1500));
			itemList.add(new Item("ファイル", 2000));
			application.setAttribute("itemList", itemList);
		}

		// カートに入れた商品合計金額を計算
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>)session.getAttribute("cartItemList");
		int totalPrice = 0;
		if(cartItemList != null) {
			for(Item item : cartItemList) {
				totalPrice += item.getPrice();
			}
		}
		model.addAttribute("totalPrice", totalPrice);
		
		// カートが空なら0件のリストを入れる
		if(cartItemList == null) {
			session.setAttribute("cartItemList", new ArrayList<Item>());
		}
		
		return "25km/itemAndCart";
	}

	/**
	 * 商品をカートに入れる.
	 * 
	 * @param index
	 *            入れたい商品のindex番号
	 * @param model
	 *            モデル
	 * @return 商品一覧とカートの中身を表示する画面
	 */
	@RequestMapping(value = "/in-cart")
	public String inCart(int index, Model model) {

		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		Item item = itemList.get(index);

		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>)session.getAttribute("cartItemList");
		cartItemList.add(item);

		return index(model);
	}

	/**
	 * 商品をカートから削除する.
	 * 
	 * @param index
	 *            入れたい商品のindex番号
	 * @param model
	 *            モデル
	 * @return 商品一覧とカートの中身を表示する画面
	 */
	@RequestMapping("delete")
	public String delete(int index, Model model) {

		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>)session.getAttribute("cartItemList");
		cartItemList.remove(index);

		return index(model);
	}

}

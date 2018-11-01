package jp.co.sample.java_marathon_beginner.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 商品合計金額コントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping(value = "/15km")
public class RegisterController {
	
	/**
	 * フォームの初期化
	 * 
	 * @return 初期化されたフォーム
	 */
	@ModelAttribute
	public ItemForms setUpForm(){
		return new ItemForms();
	}
	
	/**
	 * 初期画面
	 * 
	 * @return 金額入力画面
	 */
	@RequestMapping(value = "/input")
	public String index(){
		return "15km/buygoods";
	}
	
	/**
	 * 計算
	 * 
	 * @param goods1 商品１の値段
	 * @param goods2 商品２の値段
	 * @param goods3 商品３の値段
	 * @param applicationScope アプリケーションスコープ
	 * @return 合計金額表示画面
	 */
	@RequestMapping(value = "/calc")
	public String calc(@Validated ItemForms form,BindingResult result,
			HttpServletRequest applicationScope){
	
		if(result.hasErrors()){
			return index();
		}
		
		int sum = Integer.parseInt(form.getGoods1()) 
				+ Integer.parseInt(form.getGoods2()) 
				+ Integer.parseInt(form.getGoods3()); //合計金額
		
		applicationScope.setAttribute("priceintax", (int)(sum*1.08));
		applicationScope.setAttribute("pricenotintax", sum);
		
		return "15km/totalprice";
		
	}

}

package jp.co.sample.java_marathon_beginner.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * 掛け算コントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping(value = "/10km")
public class CalcController {
	
	
	/**
	 * 初期表示
	 * 
	 * @return 数値入力画面
	 */
	@RequestMapping(value = "/input")
	public String index(){
		return "10km/inputvalue";
	}
	
	
	/**
	 * 計算
	 * 
	 * @param num1 一つ目の数値
	 * @param num2 二つ目の数値
	 * @param model モデル
	 * @param session セッションスコープ
	 * @return 計算結果出力画面
	 */
	@RequestMapping(value = "/calc")
	public String calc(String num1,String num2,Model model,HttpSession session){		
		
		boolean hasErrors = false;
		if("".equals(num1)){
			model.addAttribute("error1", "一つ目の数値が入力されていません");
			hasErrors = true;
		} else {
			try {
				Integer.parseInt(num1);
			} catch (Exception e) {
				model.addAttribute("error1", "一つ目には数値を入力してください");
				hasErrors = true;
			}
		}
		if("".equals(num2)){
			model.addAttribute("error2", "二つ目の数値が入力されていません");
			hasErrors = true;
		} else {
			try {
				Integer.parseInt(num1);
			} catch (Exception e) {
				model.addAttribute("error2", "二つ目には数値を入力してください");
				hasErrors = true;
			}
		}
		if(hasErrors) {
			return "10km/inputvalue";
		}
			
		
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		
		int answer = Integer.parseInt(num1) * Integer.parseInt(num2);
		
		session.setAttribute("answer",answer); 
		
		return "10km/outputvalue";
	}
	
	/**
	 * 次のページへ
	 * 
	 * @return 二つ目の出力画面
	 */
	@RequestMapping(value = "/outputvalue2")
	public String output2(){
		return "10km/outputvalue2";
	}

}

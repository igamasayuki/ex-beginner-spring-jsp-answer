package jp.co.sample.java_marathon_beginner.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 名前登録・表示処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping(value = "/1km")
public class NameReceiveController {
		
	/**
	 * 初期表示.
	 * 
	 * @return 名前入力画面
	 */
	@RequestMapping(value = "/input")
	public String input(){
		return "1km/inputname";
	}

	/**
	 * 名前登録.
	 * 
	 * @return 入力結果画面
	 */
	@RequestMapping(value = "/name-receive")
	public String namereceive(String name,Model model){
		
		//入力値チェック
		if("".equals(name)){
			model.addAttribute("error","文字を入力してください");
			return "1km/inputname";
		}
		
		model.addAttribute("name", name);
		
		return "1km/outputname";
		
	}
	
}

package jp.co.sample.java_marathon_beginner.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.java_marathon_beginner.domain.User;
import jp.co.sample.java_marathon_beginner.service.UserService;

/**
 * ユーザの情報処理を行うコントローラー.
 * 
 * @author igamasayuki
 */
@Controller
@Transactional
@RequestMapping(value = "/20km")
public class SearchController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * フォームの初期化
	 * 
	 * @return 初期化されたフォーム
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	/**
	 * 初期画面
	 * 
	 * @return id入力画面
	 */
	@RequestMapping(value = "/input")
	public String index(){
		return "20km/userinfosearch";
	}
	
	/**
	 * id検索
	 * 
	 * @param id
	 * @param request リクエストスコープ
	 * @return 結果画面
	 */
	@RequestMapping(value = "/search")
	public String search(@Validated UserForm form,BindingResult result,HttpServletRequest request){
		
		if(result.hasErrors()){
			return index();
		}
		
		int id = Integer.parseInt(form.getId());
		
		User user = userService.load(id);
				
		request.setAttribute("user", user);
		
		return "20km/userinfoview";
		
	}

}

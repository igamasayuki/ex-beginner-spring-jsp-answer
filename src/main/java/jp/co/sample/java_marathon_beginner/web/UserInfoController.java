package jp.co.sample.java_marathon_beginner.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.java_marathon_beginner.domain.User;
import jp.co.sample.java_marathon_beginner.service.UserService;

/**
 * ユーザ情報処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping(value = "/5km")
public class UserInfoController {

	/**
	 * フォームの初期化.
	 * 
	 * @return 初記化されたフォーム
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@Autowired
	private UserService userService;

	/**
	 * 初期表示.
	 * 
	 * @return ユーザ情報入力画面
	 */
	@RequestMapping(value = "/input")
	public String input() {
		return "5km/inputuserinfo";
	}

	/**
	 * ユーザ登録.
	 * 
	 * @param form
	 *            入力フォーム
	 * @param model
	 *            スコープ
	 * @return ユーザ情報表示画面
	 */
	@RequestMapping(value = "/register-user-info")
	public String register(UserForm form, Model model) {

		boolean hasErrors = false;
		if ("".equals(form.getName())) {
			model.addAttribute("error1", "名前を入力してください");
			hasErrors = true;
		}
		if ("".equals(form.getAge())) {
			model.addAttribute("error2", "年齢を入力してください");
			hasErrors = true;
		}
		if ("".equals(form.getAddress())) {
			model.addAttribute("error3", "住所を入力してください");
			hasErrors = true;
		}
		// 年齢に文字を入れた場合のエラー
		try {
			Integer.parseInt(form.getAge());
		} catch (Exception e) {
			model.addAttribute("error", "年齢は半角数字で入力してください");
			hasErrors = true;
		}
		if (hasErrors) {
			return "5km/inputuserinfo";
		}

		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setAge(form.getIntAge());

		user = userService.save(user);

		model.addAttribute("user", user);

		return "5km/outputuserinfo";
	}

}

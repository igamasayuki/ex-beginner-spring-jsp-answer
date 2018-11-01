package jp.co.sample.java_marathon_beginner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.java_marathon_beginner.domain.User;
import jp.co.sample.java_marathon_beginner.repository.UserDao;

/**
 * ユーザー関連サービスクラス.
 * 
 * @author igamasayuki
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * ユーザ情報登録
	 * 
	 * @param user
	 * @return ユーザ
	 */
	public User save(User user) {
		return user;
	}

	/**
	 * IDから1件のユーザ情報を取得する.
	 * 
	 * @param id
	 *            検索したいユーザID
	 * @return 検索されたユーザ情報 0件の時はnullが返る
	 */
	public User load(Integer id) {
		return userDao.load(id);
	}

}

package demo;

import com.jfinal.plugin.activerecord.Page;

public class UserService {
	
	/**
	 * 所有的 dao 对象也放在 Service 中
	 */
	private static final User dao = new User().dao();
	
	public Page<User> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from en_user order by id asc");
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
}

package com.hanxu.action;

import java.util.List;
import java.util.Map;

import com.hanxu.dao.GoddessDao;
import com.hanxu.model.Goddess;

public class GoddessAction {
	// 控制层
	public void add(Goddess goddess) throws Exception {
		GoddessDao dao = new GoddessDao();
		dao.addGoddess(goddess);
	}

	public void edit(Goddess goddess) throws Exception {
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
	}

	public void del(Integer id) throws Exception {
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}

	public Goddess get(Integer id) throws Exception {
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}

	public List<Goddess> query(String name, String moblie, String email)
			throws Exception {
		GoddessDao dao = new GoddessDao();
		return dao.query(name, moblie, email);
	}

	public List<Goddess> query1(List<Map<String, Object>> params)
			throws Exception {
		GoddessDao dao = new GoddessDao();
		return dao.query1(params);
	}

	public List<Goddess> query2() throws Exception {
		GoddessDao dao = new GoddessDao();
		return dao.query2();
	}

	/*
	 * public static void main(String[] args) throws Exception { GoddessDao g =
	 * new GoddessDao();
	 * 
	 * List<Goddess> gs = g.query();
	 * 
	 * for (Goddess goddess : gs) { System.out.println(goddess.getUser_name() +
	 * "," + goddess.getAge()); }
	 * 
	 * 
	 * 
	 * java.util.List<Goddess> gsGoddesses = g.query("aya", "1387120495",
	 * "xiao");
	 * 
	 * List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
	 * 
	 * Map<String, Object> param = new HashMap<String, Object>();
	 * param.put("name", "user_name"); // param.put("rela", "=");
	 * param.put("rela", "like"); param.put("value", "'%aya%'");
	 * params.add(param);
	 * 
	 * param.put("name", "mobile"); // param.put("rela", "="); param.put("rela",
	 * "like"); param.put("value", "'%1234120495%'"); params.add(param);
	 * 
	 * List<Goddess> result = g.query1(params);
	 * 
	 * for (Goddess goddess : gsGoddesses) {
	 * System.out.println(gsGoddesses.toString()); }
	 * 
	 * 
	 * for (int i = 0; i < result.size(); i++) {
	 * System.out.println(result.get(i).toString()); }
	 * 
	 * Goddess g1 = new Goddess(); g1.setUser_name("aya"); g1.setAge(29);
	 * g1.setSex(2); g1.setBirthday(new Date(20170102));
	 * g1.setEmail("xiaoq@qq.com"); g1.setMoblie("1234120495");
	 * g1.setCreate_user("ADMIN"); g1.setId(4); // g.addGoddess(g1); //
	 * g.delGoddess(2);
	 * 
	 * // Goddess gaGoddess = g.get(3); //
	 * System.out.println(gaGoddess.toString());
	 * 
	 * // g1.setIsdel(1); // g1.setId(3); // g.get(2); // g.updateGoddess(g1);
	 * 
	 * }
	 */
}

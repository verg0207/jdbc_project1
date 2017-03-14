package com.hanxu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanxu.action.GoddessAction;
import com.hanxu.model.Goddess;

public class TestAction {
	public static void main(String[] args) throws Exception {
		GoddessAction action = new GoddessAction();
		// 查询
		/*
		 * List<Goddess> result = action.query2(); for (int i = 0; i <
		 * result.size(); i++) { System.out.println(result.get(i).getId() + ":"
		 * + result.get(i).getUser_name());
		 */

		// 添加
		/*
		 * Goddess goddess = new Goddess(); goddess.setUser_name("xiaoqing");
		 * goddess.setSex(1); goddess.setAge(25); goddess.setBirthday(new
		 * Date(20170102)); goddess.setEmail("xq@qq.com");
		 * goddess.setMoblie("122222222"); goddess.setIsdel(0);
		 * 
		 * action.add(goddess);
		 */

		// edit del类似

		List<Map<String, Object>> params = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'aya'");

		params.add(map);

		List<Goddess> result = action.query1(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + ":"
					+ result.get(i).getUser_name());

		}
	}
}

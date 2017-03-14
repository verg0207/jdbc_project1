package com.hanxu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanxu.db.DBUtil;
import com.hanxu.model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+ "insert into imooc_goddess"
				+ "(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel)"
				+ "values("
				+ "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译sql语句,不直接执行

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMoblie());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());

		ptmt.execute();
	}

	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+ " update imooc_goddess "
				+ " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=? "
				+ " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译sql语句,不直接执行

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMoblie());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		ptmt.execute();
	}

	public void delGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from imooc_goddess " + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译sql语句,不直接执行

		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public List<Goddess> query(String name, String moblie, String email)
			throws SQLException {
		Connection conn = DBUtil.getConnection();

		List<Goddess> gs = new ArrayList<Goddess>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess ");

		sb.append("where user_name like ? and mobile like ? and email like ? ");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		ptmt.setString(1, "%" + name + "%");
		ptmt.setString(2, "%" + moblie + "%");
		ptmt.setString(3, "%" + email + "%");
		ResultSet rSet = ptmt.executeQuery();
		Goddess goddess = null;

		while (rSet.next()) {
			goddess = new Goddess();
			goddess.setId(rSet.getInt("id"));
			goddess.setUser_name(rSet.getString("user_name"));
			goddess.setId(rSet.getInt("id"));
			goddess.setAge(rSet.getInt("age"));
			goddess.setBirthday(rSet.getDate("birthday"));
			goddess.setEmail(rSet.getString("email"));
			goddess.setMoblie(rSet.getString("mobile"));
			goddess.setCreate_date(rSet.getDate("create_date"));
			goddess.setCreate_user(rSet.getString("create_user"));
			goddess.setUpdate_user(rSet.getString("update_date"));
			goddess.setUpdate_date(rSet.getDate("update_date"));
			goddess.setIsdel(rSet.getInt("isdel"));

			gs.add(goddess);
		}
		return gs;
	}

	public List<Goddess> query1(List<Map<String, Object>> params)
			throws SQLException {
		Connection conn = DBUtil.getConnection();

		List<Goddess> gs = new ArrayList<Goddess>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess where 1=1 ");

		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") + " " + map.get("rela")
						+ " " + map.get("value"));
			}
		}

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		ResultSet rSet = ptmt.executeQuery();
		Goddess goddess = null;

		while (rSet.next()) {
			goddess = new Goddess();
			goddess.setId(rSet.getInt("id"));
			goddess.setUser_name(rSet.getString("user_name"));
			goddess.setId(rSet.getInt("id"));
			goddess.setAge(rSet.getInt("age"));
			goddess.setBirthday(rSet.getDate("birthday"));
			goddess.setEmail(rSet.getString("email"));
			goddess.setMoblie(rSet.getString("mobile"));
			goddess.setCreate_date(rSet.getDate("create_date"));
			goddess.setCreate_user(rSet.getString("create_user"));
			goddess.setUpdate_user(rSet.getString("update_date"));
			goddess.setUpdate_date(rSet.getDate("update_date"));
			goddess.setIsdel(rSet.getInt("isdel"));

			gs.add(goddess);
		}
		return gs;
	}

	public List<Goddess> query2() throws SQLException {
		Connection conn = DBUtil.getConnection();

		List<Goddess> gs = new ArrayList<Goddess>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		ResultSet rSet = ptmt.executeQuery();
		Goddess goddess = null;

		while (rSet.next()) {
			goddess = new Goddess();
			goddess.setId(rSet.getInt("id"));
			goddess.setUser_name(rSet.getString("user_name"));
			goddess.setId(rSet.getInt("id"));
			goddess.setAge(rSet.getInt("age"));
			goddess.setBirthday(rSet.getDate("birthday"));
			goddess.setEmail(rSet.getString("email"));
			goddess.setMoblie(rSet.getString("mobile"));
			goddess.setCreate_date(rSet.getDate("create_date"));
			goddess.setCreate_user(rSet.getString("create_user"));
			goddess.setUpdate_user(rSet.getString("update_date"));
			goddess.setUpdate_date(rSet.getDate("update_date"));
			goddess.setIsdel(rSet.getInt("isdel"));

			gs.add(goddess);
		}
		return gs;
	}

	public Goddess get(Integer id) throws SQLException {
		Goddess goddess = null;
		Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from imooc_goddess " + "where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql); // 预编译sql语句,不直接执行

		ptmt.setInt(1, id);
		ResultSet rSet = ptmt.executeQuery();
		while (rSet.next()) {
			goddess = new Goddess();
			goddess.setUser_name(rSet.getString("user_name"));
			goddess.setId(rSet.getInt("id"));
			goddess.setAge(rSet.getInt("age"));
			goddess.setBirthday(rSet.getDate("birthday"));
			goddess.setEmail(rSet.getString("email"));
			goddess.setMoblie(rSet.getString("mobile"));
			goddess.setCreate_date(rSet.getDate("create_date"));
			goddess.setCreate_user(rSet.getString("create_user"));
			goddess.setUpdate_user(rSet.getString("update_date"));
			goddess.setUpdate_date(rSet.getDate("update_date"));
			goddess.setIsdel(rSet.getInt("isdel"));
		}
		return goddess;

	}
}

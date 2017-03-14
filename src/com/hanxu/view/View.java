package com.hanxu.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.hanxu.action.GoddessAction;
import com.hanxu.model.Goddess;

public class View {
	private static final String CONTEXT = "欢迎：\n" + "功能列表：\n" + "[M]主菜单\n"
			+ "[Q]查询全部\n" + "[G]查看详细信息\n" + "[A]添加\n" + "[U]更新\n" + "[D]删除\n"
			+ "[S]根据姓名，电话，email查\n" + "[E]退出\n" + "[B]退出当前功能，返回主菜单\n";

	private static final String MAIN = "M";
	private static final String QUERY = "Q";
	private static final String GET = "G";
	private static final String ADD = "A";
	private static final String UPDATE = "U";
	private static final String DELETE = "D";
	private static final String SEARCH = "S";
	private static final String EXIT = "E";
	private static final String BREAK = "B";

	public static void main(String[] args) {
		System.out.println(CONTEXT);

		Scanner scanner = new Scanner(System.in);

		Goddess goddess = new Goddess();
		GoddessAction action = new GoddessAction();
		String prenious = null;
		Integer stepInteger = null;

		while (scanner.hasNext()) { // 有输入值时循环
			String in = scanner.next().toString();
			if (EXIT.equals(in.toUpperCase())
					|| EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("您已成功退出\n");
				break;
			} else if (ADD.equals(in.toUpperCase())
					|| ADD.substring(0, 1).equals(in.toUpperCase())
					|| ADD.equals(prenious)) {
				// add
				prenious = ADD;
				if (stepInteger == 1) {
					System.out.println("输入姓名：");
				} else if (stepInteger == 2) {
					goddess.setUser_name(in);
					System.out.println("输入年龄：");
				} else if (stepInteger == 3) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("输入生日： 格式：yyyy-MM-dd");
				} else if (stepInteger == 4) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday = null;
					try {
						/*
						 * birthday = sdf.parse(in);
						 * goddess.setBirthday(birthday);
						 * System.out.println("邮箱：");
						 */
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("输入格式有误，重新输入");
						stepInteger = 3;
					}
				} else if (stepInteger == 5) {
					goddess.setEmail(in);
					System.out.println("电话：");
				} else if (stepInteger == 6) {
					goddess.setMoblie(in);
					try {
						action.add(goddess);
						System.out.println("新增成功");
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println("新增失败");
					}

				}
				if (ADD.equals(prenious)) {
					stepInteger++;
				}
			} else {
				System.err.println("输入值是：" + in);
			}

		}
	}
}

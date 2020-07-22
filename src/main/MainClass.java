package main;

import java.util.Scanner;

import db.DBClass;

public class MainClass {

	public static void main(String[] args) {
		TheDal td = new TheDal();// new Scanner도 같이 생산, td안에 메소드에 접근할때 사용 가능함
		Scanner sc = new Scanner(System.in);

		for (;;) {
			if (0 == td.menu()) {
				break;
			}
			td.munje(10);
			td.ox();
		}
//		System.out.print("이름을 입력: ");
//		String name = sc.next();
//		
//		tdo.setName(name);
		ThedalTB dto = td.userinfo();
		DBClass.insert(dto.getName(), dto.getScore());
		DBClass.select();
		System.out.println("감사합니다");
	}
}

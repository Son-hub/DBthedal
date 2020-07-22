package main;

import java.util.Random;
import java.util.Scanner;

import main.NumVO;

public class TheDal {
		// 멤버 변수
		private Scanner sc;
		private NumVO numVo;
		private int op; // 기호를 정하는 변수
		private int o;
		private int x;

		ThedalTB Tb = new ThedalTB();
		
		public TheDal() {
			sc = new Scanner(System.in);
			numVo = new NumVO();
		}// 값을 초기화할때

		// 랜덤 숫자 만들기 메소드
		public void rNum() {
			Random rnd = new Random();

			// int num2 = rnd.nextInt(10) + 10;
			// numVo.setNum1(num2);
			// 랑같다
			numVo.setNum1(rnd.nextInt(89) + 10);
			numVo.setNum2(rnd.nextInt(89) + 10);

		}

		// 메뉴 출력
		public int menu() {
			System.out.print("1: 더하기, 2:빼기, 3:곱하기, 4:나누기 0: 종료 >> ");
			op = sc.nextInt();
			System.out.println("당신이 선택한 번호: " + op);
			return op;
		}

		// 문제 만들기
		public void munje(int su) {
			for (int i = 0; i < su; i++) {
				rNum(); // 숫자 만들기 메소드

				// 문제출력
				if (op == 1) {
//				int dab = the();
					bikyo(the());
				} else if (op == 2) {
					bikyo(bbe());
				} else if (op == 3) {
					bikyo(goh());
				} else if (op == 4) {
					bikyo(na());
				}
			}
		}

		// 빼기나 나누기때 num1 과 num2를 바꾸는 메소드
		public void chNum(int a, int b) {
			numVo.setNum1(Math.max(a, b));
			numVo.setNum2(Math.min(a, b));
		}

		// 나누기를 무조건 떨어지게 만들기
		public boolean ddul(int a, int b) {
			if (a % b == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void bikyo(int dab) {
//			int dab = numVo.getNum1() + numVo.getNum2();
			// 답 입력 받기
			int i = sc.nextInt();
			System.out.println("당신이 입력한 답은: " + i);

			// 문제의 답과 사용자의 답과 비교해서
			// 맞으면 정답 틀리면 오답
			if (dab == i) {
				System.out.println("정답");
				o++;
			} else {
				System.out.println("오답");
				x++;
			}
		}
		//맞은갯수 틀린갯수 출력하기
		public void ox() {
			System.out.println("정답수: " + o);
			Tb.setScore(o*10);
			System.out.println("정답수: " + x);
		}
		public ThedalTB userinfo() {
			System.out.print("이름을 입력: ");
			String name = sc.next();
			Tb.setName(name);
			return Tb;
		}

		// 더하기
		public int the() {
			System.out.println(numVo.getNum1() + "+" + numVo.getNum2() + "= ");
			return numVo.getNum1() + numVo.getNum2();
		}

		// 빼기
		public int bbe() {
			chNum(numVo.getNum1(), numVo.getNum2());
			System.out.println(numVo.getNum1() + "-" + numVo.getNum2() + "= ");
			return numVo.getNum1() - numVo.getNum2();
		}

		// 곱하기
		public int goh() {
			System.out.println(numVo.getNum1() + "*" + numVo.getNum2() + "= ");
			return numVo.getNum1() * numVo.getNum2();
		}

		// 나누기
		public int na() {
			for (;;) {
				chNum(numVo.getNum1(), numVo.getNum2());
				if (ddul(numVo.getNum1(), numVo.getNum2())) {
					break;
				} else {
					rNum();
				}
			}
			System.out.println(numVo.getNum1() + "/" + numVo.getNum2() + "= ");
			return numVo.getNum1() / numVo.getNum2();
		}
	}

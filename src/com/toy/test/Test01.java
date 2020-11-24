package com.toy.test;

import org.springframework.util.StringUtils;

public class Test01 {

	public static void main(String[] args) {
		// 1. 시작번호부터 마지막 번호까지의 합을 리턴
		int calc01result = calc01(1, 10);
		System.out.println("calc01result =" + calc01result);

		int calc01result02 = calc01(1, 100);
		System.out.println("calc01result02 =" + calc01result02);

		// 2. 시작번호부터 마지막 번호까지중 홀수의 합 리턴
		int calc02result = calc02(1, 10);
		System.out.println("calc02result =" + calc02result);

		// 3. 시작번호부터 마지막 번호까지의 구구단
		int calc03result = calc03(1, 10);
		System.out.println("calc03result =" + calc03result);

		// 4. 시작번호부터 마지막 번호까지의 숫자중 no이 들어가는 숫자의 합계
		int calc04result = calc04(1, 100, 3);
		System.out.println("calc04result =" + calc04result);

		// 5. [갯수]
		// 1~1000에서 각 숫자의 갯수 구하기
		// 0 ~ 9 까지의 각 숫자의 개수를 구해보자
		// [결과]
		// 0: 192, 1: 301, 2: 300, 3: 300, 4: 300, 5: 300, 6: 300, 7:300, 8:300, 9: 300
		int calc05result = calc05(1, 1000);
		System.out.println("calc0");

		// 6. [시저 암호 풀기]
		// 시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데, 예를 들어 알파벳 A를 입력했을 떼,
		// 그 알파벳의 n개 뒤에 오는(여기는서는 예를 들 때 3으로 지정하였다)알파벳이 출력되는 것이다.
		// 예를 들어 바꾸려는 단어가 'CAT'고, n을 5로 지정하였을 때 'HFY'가 되는 것이다.
		// 어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성하라.
		// [결과]
		// CAT --> HFY

//		String aaa = "XYZ";
		
		String aaa = "Hello, World! JAVA";
		String calc06result = calc06(aaa, 5);
		System.out.println(aaa + " --> " + calc06result);
		
	}

	public static int calc01(int startNo, int endNo) {
		int result = 0;
		for (int i = startNo; i <= endNo; i++) {
			result = result + i;
		}

		return result;
	}

	public static int calc02(int startNo, int endNo) {
		// 2. 시작번호부터 마지막 번호까지중 홀수의 합 리턴
		int result = 0;
		for (int i = startNo; i <= endNo; i++) {
			if (i % 2 == 1) {
				result = result + i;
			}
		}

		return result;
	}

	public static int calc03(int startNo, int endNo) {
		// 3. 시작번호부터 마지막 번호까지의 구구단
		for (int i = startNo; i <= endNo; i++) {
			System.out.println(i + " 단");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
			}
		}

		return 0;
	}

	public static int calc04(int startNo, int endNo, int no) {
		// 4. 시작번호부터 마지막 번호까지의 숫자중 no이 들어가는 숫자의 합계
		int result = 0;
		for (int i = startNo; i <= endNo; i++) {
			String strI = String.valueOf(i);
			String strNo = "" + no;
			// if (strI.indexOf(strNo) > -1) {
			if (strI.contains(strNo)) {
				result = result + i;
				System.out.println("i : " + i);
			}
		}

		return result;
	}

	public static int calc05(int startNo, int endNo) {
		// 5. [갯수]
		// 1~1000에서 각 숫자의 갯수 구하기
		// 0 ~ 9 까지의 각 숫자의 개수를 구해보자
		for (int j = 0; j < 10; j++) {
			int result = 0;
			String strJ = String.valueOf(j);
			for (int i = startNo; i <= endNo; i++) {
				String strI = String.valueOf(i);

//				int countOcc = StringUtils.countOccurrencesOf(strI, strJ);
//				result = result + countOcc;
//				result = result + StringUtils.countOccurrencesOf(strI, strJ);
				result += StringUtils.countOccurrencesOf(strI, strJ);
			}
			System.out.println(j + " : " + result);
		}
		return 0;
	}

	public static String calc06(String str, int n) {
		// 6. [시저 암호 풀기]
		// 시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데, 예를 들어 알파벳 A를 입력했을 떼,
		// 그 알파벳의 n개 뒤에 오는(여기는서는 예를 들 때 3으로 지정하였다)알파벳이 출력되는 것이다.
		// 예를 들어 바꾸려는 단어가 'CAT'고, n을 5로 지정하였을 때 'HFY'가 되는 것이다.
		// 어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성하라.

		char[] arrCh = new char[str.length()];
		// char ch1 = str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (!Character.isAlphabetic(ch)) {
				arrCh[i] = ch;
			} else if (Character.isAlphabetic(ch + n)) {
				arrCh[i] = (char) (ch + n);
			} else {
				arrCh[i] = (char) (ch + n - 26);
			}
			/*
			if (Character.isAlphabetic(ch + n)) {
				arrCh[i] = (char) (ch + n);
			} else if (Character.isAlphabetic(ch + n - 26)) {
				arrCh[i] = (char) (ch + n - 26);
			} else {
				arrCh[i] = ch;
			}*/
		}
		
		String strResult = String.valueOf(arrCh);
		
		return strResult;
	}

}

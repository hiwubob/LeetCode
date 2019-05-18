package Huisu;

import java.util.ArrayList;
import java.util.List;

public class T784letterCasePermutation {
	public static List<String> letterCasePermutation(String s) {
		List<String> list = new ArrayList<>();
		char[] arr = s.toCharArray();
		function(list, arr, 0);
		return list;
	}

	private static void function(List<String> list, char[] arr, int i) {
		if (i >= arr.length) {
			list.add(new String(arr));
			return;
		}
		function(list, arr, i + 1);
		if (!Character.isDigit(arr[i])) {// 将i位置的非数字字符，大变小，小变大
			if (Character.isUpperCase(arr[i])) {
				arr[i] = Character.toLowerCase(arr[i]);
				function(list, arr, i + 1);
				arr[i] = Character.toUpperCase(arr[i]);// 回溯
			} else {
				arr[i] = Character.toUpperCase(arr[i]);
				function(list, arr, i + 1);
				arr[i] = Character.toLowerCase(arr[i]);// 回溯
			}
		}
	}

	public static void main(String[] args) {
		String s = "a1b2";
		List<String> list = new ArrayList<>();
		list = letterCasePermutation(s);
		System.out.println(list);
	}
}

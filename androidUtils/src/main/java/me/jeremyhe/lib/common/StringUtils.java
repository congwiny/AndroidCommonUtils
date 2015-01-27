package me.jeremyhe.lib.common;

public class StringUtils {
	public static boolean isEmpty(String str){
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean notEmpty(String str){
		if (str != null && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
}

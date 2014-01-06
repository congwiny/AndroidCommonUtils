package me.jeremyhe.lib.androidutils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SystemUtils {
	/**
	 * 返回状态栏（通知栏）的高度
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context) {
		Rect frameRect = new Rect();
		View view = new View(context);
		view.getWindowVisibleDisplayFrame(frameRect);
		return frameRect.top;
	}
	
	/**
	 * 根据像素密度计算出不同分辨率机型应该显示的像素值
	 * @param pixel
	 * @return
	 */
	public static float getExactPixel(Context context, float pixel) {
		int dip = context.getResources().getDisplayMetrics().densityDpi;
		float factor = dip/160f;
		return pixel*factor;
	}
	
	/**
	 * 判断是否拥有某个权限
	 * @param context
	 * @param permission
	 * @return
	 */
	public static boolean checkPermissions(Context context, String permission) {
		PackageManager localPackageManager = context.getPackageManager();
		return localPackageManager.checkPermission(permission, context
				.getPackageName()) == PackageManager.PERMISSION_GRANTED;
	}
	
	public static void showInputMethod(Activity activity,boolean show){
		InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (show) {
			inputMethodManager.showSoftInput(activity.getCurrentFocus(), InputMethodManager.SHOW_FORCED);
		} else {
			inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
	

}

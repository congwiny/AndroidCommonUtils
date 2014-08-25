package me.jeremyhe.lib.androidutils;

import java.io.DataOutputStream;

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
	public static float getExactPixel(Context context, float dp) {
		int dip = context.getResources().getDisplayMetrics().densityDpi;
		float factor = dip/160f;
		return dp*factor;
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
	
	/**
	 * 显示或者隐藏输入法
	 * @param activity
	 * @param show
	 */
	public static void showInputMethod(Activity activity,boolean show){
		InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (show) {
			inputMethodManager.showSoftInput(activity.getCurrentFocus(), InputMethodManager.SHOW_FORCED);
		} else {
			inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
	
	
	/**
	 * 应用程序运行命令获取 Root权限，设备必须已破解(获得ROOT权限)
	 */
	public static boolean upgradeRootPermission(String pkgCodePath) {
	    Process process = null;
	    DataOutputStream os = null;
	    try {
	        String cmd="chmod 777 " + pkgCodePath;
	        process = Runtime.getRuntime().exec("su"); //切换到root帐号
	        os = new DataOutputStream(process.getOutputStream());
	        os.writeBytes(cmd + "\n");
	        os.writeBytes("exit\n");
	        os.flush();
	        process.waitFor();
	    } catch (Exception e) {
	        return false;
	    } finally {
	        try {
	            if (os != null) {
	                os.close();
	            }
	            process.destroy();
	        } catch (Exception e) {
	        }
	    }
	    return true;
	}

}

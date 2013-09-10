package org.lib.androidutils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

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
}

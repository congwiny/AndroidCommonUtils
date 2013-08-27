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
}

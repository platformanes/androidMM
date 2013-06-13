package com.mm.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * @author Rect
 * @version  Time：2013-6-13 
 */
public class MMCleanLocalCache implements FREFunction {

	private String TAG = "MMCleanLocalCache";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 我这里直接传回。。
		try {
			if(MMUitl._context != null)
				MMUitl.purchase.clearCache(MMUitl._context.getActivity());
			else
				callBack("尚未初始化");
		} catch (Exception e1) {
			callBack(e1.getMessage());
		}
		
		//--------------------------------

		return result;
	}

	/**
	 * 回调 结果传给AS端
	 */
	public void callBack(String status ){
		Log.d(TAG, "---------返回-------");
		_context.dispatchStatusEventAsync(TAG, TAG+":"+status);

	}

}

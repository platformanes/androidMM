package com.mm.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 执行登录
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class MMQuery implements FREFunction {

	private String TAG = "MMQuery";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 我这里直接传回。。
		/**
		 * 商品查询接口
		 */
		try {
			if(MMUitl._context != null)
				MMUitl.purchase.query(MMUitl._context.getActivity(), MMUitl.mPaycode, null, MMUitl.mListener);
			else
				callBack("尚未初始化");
			
		} catch (Exception e) {
			callBack(e.getMessage());
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

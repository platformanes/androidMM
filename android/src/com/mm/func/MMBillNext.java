package com.mm.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 执行付费
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class MMBillNext implements FREFunction {

	private String TAG = "MMBillNext";
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
			callBack("productnum=" + MMUitl.mProductNum);
			if(MMUitl._context != null)
				MMUitl.purchase.order(MMUitl._context.getActivity(), MMUitl.mPaycode, MMUitl.mProductNum, true, MMUitl.mListener);
			else
				callBack("尚未初始化");
			

		} catch (Exception e1) {
			//
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

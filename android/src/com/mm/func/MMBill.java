package com.mm.func;

import mm.purchasesdk.OnPurchaseListener;
import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 初始化SDK
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class MMBill implements FREFunction {

	private String TAG = "MMBill";
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
		 * 商品购买接口。
		 */
		if(MMUitl._context != null)order(MMUitl._context.getActivity(), MMUitl.mListener);
		else
			callBack("尚未初始化");
		//--------------------------------

		return result;
	}
	public void order(Context context, OnPurchaseListener listener) {
		try {
			MMUitl.purchase.order(context, MMUitl.mPaycode, MMUitl.mProductNum,"Hello_My_ExData", listener);
		} catch (Exception e) {
			callBack(e.getMessage());
		}
	}
	/**
	 * 回调 结果传给AS端
	 */
	public void callBack(String status ){
		Log.d(TAG, "---------返回-------");
		_context.dispatchStatusEventAsync(TAG, TAG+":"+status);

	}

}

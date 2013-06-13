package com.mm.func;

import mm.purchasesdk.Purchase;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * @author Rect
 * @version  Time：2013-6-13 
 */
public class MMBillInit implements FREFunction {

	private String TAG = "MMBillInit";
	private FREContext _context;
	
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		MMUitl._context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 我这里直接传回。。
		try
		{
			MMUitl.APPID = arg1[0].getAsString();
			MMUitl.APPKEY = arg1[1].getAsString();
			MMUitl.LEASE_PAYCODE = arg1[2].getAsString();
			MMUitl.PRODUCT_NUM = arg1[3].getAsInt();
			MMUitl.PAYCODE = arg1[4].getAsString();
			MMUitl.PRODUCTNUM = arg1[5].getAsString();
			MMUitl.mProductNum = arg1[6].getAsInt();
		}
		catch(Exception e)
		{
			callBack(e.getMessage());
			return null;
		}
		//--------------------------------
		
		MMUitl.mProductNum = MMUitl.PRODUCT_NUM;
		IAPHandler iapHandler = new IAPHandler(this._context);
		MMUitl.mPaycode = MMUitl.readPaycode();
		MMUitl.mProductNum = MMUitl.readProductNUM();
		/**
		 * IAP组件初始化.包括下面3步。
		 */
		/**
		 * step1.实例化PurchaseListener。实例化传入的参数与您实现PurchaseListener接口的对象有关。
		 * 例如，此Demo代码中使用IAPListener继承PurchaseListener，其构造函数需要Context实例。
		 */
		MMUitl.mListener = new IAPListener(this._context, iapHandler);
		/**
		 * step2.获取Purchase实例。
		 */
		MMUitl.purchase = Purchase.getInstance();
		/**
		 * step3.向Purhase传入应用信息。APPID，APPKEY。 需要传入参数APPID，APPKEY。 APPID，见开发者文档
		 * APPKEY，见开发者文档
		 */
		try {
			MMUitl.purchase.setAppInfo(MMUitl.APPID, MMUitl.APPKEY);
		} catch (Exception e1) {
			callBack("setAppInfo:"+e1.getMessage());
			return null;
		}
		/**
		 * step4. IAP组件初始化开始， 参数PurchaseListener，初始化函数需传入step1时实例化的
		 * PurchaseListener。
		 */
		try {
			MMUitl.purchase.init(context.getActivity(), MMUitl.mListener); 
		} catch (Exception e) {
			callBack("try_init:"+e.getMessage());
			return null;
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

package com.mm.func;

import mm.purchasesdk.Purchase;

import com.adobe.fre.FREContext;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Rect
 * @version  Time：2013-6-13 
 */
public class MMUitl {
	// 计费信息 (现网环境)
	public static  String APPID = "0000000000";
	public static  String APPKEY = "0000000000";
	// 计费点信息
	public static  String LEASE_PAYCODE = "0000000000";
	public static  int PRODUCT_NUM = 1;
	
	public  static String PAYCODE = "Paycode";
	public  static String PRODUCTNUM = "ProductNUM";
	
	public static Purchase purchase;
	public static String mPaycode;
	public  static int mProductNum = 1;
	public  static IAPListener mListener;
	
	public static FREContext _context;
	
	public static void savePaycode(String paycode) {
		Editor sharedata = _context.getActivity().getSharedPreferences("data", 0).edit();
		sharedata.putString(PAYCODE, paycode);
		sharedata.commit();
	}

	public static String readPaycode() {
		SharedPreferences sharedPreferences = _context.getActivity().getSharedPreferences("data", 0);
		String paycode = sharedPreferences.getString(PAYCODE, LEASE_PAYCODE);
		return paycode;
	}

	public static void saveProductNUM(int num) {
		Editor sharedata = _context.getActivity().getSharedPreferences("data", 0).edit();
		sharedata.putInt(PRODUCTNUM, num);
		sharedata.commit();
	}

	public static int readProductNUM() {
		SharedPreferences sharedPreferences = _context.getActivity().getSharedPreferences("data", 0);
		int num = sharedPreferences.getInt(PRODUCTNUM, PRODUCT_NUM);
		return num;
	}
}

package com.mm.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.mm.func.MMBill;
import com.mm.func.MMBillInit;
import com.mm.func.MMBillNext;
import com.mm.func.MMCleanLocalCache;
import com.mm.func.MMQuery;
import com.mm.func.MMUnsub;

/**
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class MMContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String MM_FUNCTION_INIT = "mm_function_init";
	/**
	 * 订购
	 */
	public static final String MM_FUNCTION_BILL = "mm_function_bill";
	/**
	 * 查询
	 */
	public static final String MM_FUNCTION_QUERY= "mm_function_query";
	/**
	 * 退订
	 */
	public static final String MM_FUNCTION_UNSUB = "mm_function_unsub";
	/**
	 * 续订
	 */
	public static final String MM_FUNCTION_BILL_NEXT = "mm_function_bill_next";
	/**
	 * clean
	 */
	public static final String MM_FUNCTION_CLEAN = "mm_function_clean";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		//映射
		map.put(MM_FUNCTION_INIT, new MMBillInit());
		map.put(MM_FUNCTION_BILL, new MMBill());
		map.put(MM_FUNCTION_QUERY, new MMQuery());
		map.put(MM_FUNCTION_BILL_NEXT, new MMBillNext());
		map.put(MM_FUNCTION_UNSUB, new MMUnsub());
		map.put(MM_FUNCTION_CLEAN, new MMCleanLocalCache());
		return map;
	}

}

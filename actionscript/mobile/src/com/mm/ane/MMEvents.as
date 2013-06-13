package com.mm.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class MMEvents 
	{ 
		public function MMEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 *init 
		 */		
		public static const MM_SDK_STATUS:String = "MMBillInit";
		/**
		 * 订购
		 */
		public static const MM_BILL_STATUS : String = "MMBill";
		
		/**
		 * 查询
		 */
		public static const MM_QUERY_STATUS : String = "MMQuery";
		
		/**
		 * 续订
		 */
		public static const MM_BILL_NEXT_STATUS : String = "MMBillNext";
		/**
		 * 清理本地缓存
		 */
		public static const MM_CLEAN_STATUS : String = "MMCleanLocalCache";
		/**
		 * 退订
		 */
		public static const MM_UNSUB_STATUS : String = "MMUnsub";
	} 
}
package com.mm.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class MMExtension extends EventDispatcher 
	{ 
		public static const MM_FUNCTION_INIT:String = "mm_function_init";//与java端中Map里的key一致
		public static const MM_FUNCTION_BILL:String = "mm_function_bill";//与java端中Map里的key一致
		public static const MM_FUNCTION_QUERY:String = "mm_function_query";//与java端中Map里的key一致
		public static const MM_FUNCTION_UNSUB:String = "mm_function_unsub";//与java端中Map里的key一致
		public static const MM_FUNCTION_BILL_NEXT:String = "mm_function_bill_next";//与java端中Map里的key一致
		public static const MM_FUNCTION_CLEAN:String = "mm_function_clean";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.mm.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:MMExtension; 
		public function MMExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():MMExtension
		{
			if(_instance == null) 
				_instance = new MMExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		/**
		 * 
		 * @param APPID
		 * @param APPKEY
		 * @param LEASE_PAYCODE
		 * @param PRODUCT_NUM
		 * @param PAYCODE
		 * @param PRODUCTNUM
		 * @param mProductNum
		 * @return 
		 * 
		 */			
		public function MMInit(APPID:String,
							   APPKEY:String,
							   LEASE_PAYCODE:String,
							   PRODUCT_NUM:int,
							   PAYCODE:String,
							   PRODUCTNUM:String,
							   mProductNum:int):String{
			if(extContext ){
				return extContext.call(MM_FUNCTION_INIT,APPID,APPKEY,LEASE_PAYCODE,PRODUCT_NUM,PAYCODE,PRODUCTNUM,mProductNum) as String;
			}
			return "call MMInit failed";
		} 
		
		/**
		 * 发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function MMBilling(key:int):String{
			if(extContext ){
				return extContext.call(MM_FUNCTION_BILL,key) as String;
			}
			return "call MMBilling failed";
		} 
		/**
		 * 发送函数 
		 * @param key 暂时传什么都可以 留着以后可能要用
		 * @return 
		 * 
		 */		 
		public function MMQuery(key:int):String{
			if(extContext ){ 
				return extContext.call(MM_FUNCTION_QUERY,key)as String;
			}
			return "call MMQuery failed";
		}
		
		/**
		 * 
		 * @param key
		 * @return 
		 * 
		 */		
		public function MMUnusb(key:int):String{
			if(extContext){ 
				return extContext.call(MM_FUNCTION_UNSUB,key) as String;
			}
			return "call MMUnusb failed";
		}
		/**
		 * 
		 * @param key
		 * @return 
		 * 
		 */		
		public function MMBillingNext(key:int):String{
			if(extContext){ 
				return extContext.call(MM_FUNCTION_BILL_NEXT,key) as String;
			}
			return "call MMBillingNext failed";
		}
		/**
		 * 
		 * @param key
		 * @return 
		 * 
		 */		
		public function MMClean(key:int):String{
			if(extContext){ 
				return extContext.call(MM_FUNCTION_CLEAN,key) as String;
			}
			return "call MMClean failed";
		}
	} 
}
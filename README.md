androidMM
=========

移动MM内支付ANE测试版
* 此ANE可提供aser直接用，无需涉及java端。
* 保留ANE所有源码
* 应某同学的要求，编写了此ANE，由于我尚未拿到相应的KEY和完整的SDK文档，所以目前不知道是否有BUG。

## 资源

* 官方网站 [MM](http://dev.10086.cn/iap/?action=down&areaid=1354082900)

## 编译方法
*  A复制 SDK的JAR到`build/makeJar` ，运行`combine.bat `合并jar
*  B 复制A中得到的jar到`build/buildANE/Android-ARM`，运行`ane_packer.bat`得到ANE
*  C 复制B中得到的ANE到 `bulidAPK` 并修改配置 运行`mm_apk.bat`可生成APK


## 作者

* [platformANEs](https://github.com/platformanes)由 [zrong](http://zengrong.net) 和 [rect](http://www.shadowkong.com/) 共同发起并完成。
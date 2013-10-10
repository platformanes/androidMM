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

## 处理APK方法
(以下处理APK方式由网友提供)
*  D 使用jar命令解压apk
*  E 把这类资源放入到解压的目录中（删除签名相关）
*  F 使用jarsigner命令重新打包签名

按照这三步做就OK。至于删除签名 其实只要在打包的时候重新签名就OK了。
按照如下命令：

>set pa=%cd%
>echo %pa%
>cd %pa%
>cd oyp
>jar -xf 123.apk
>del META-INF\CERT.RSA
>del META-INF\CERT.SF
>copy 你的路径\libcasdkjni.so lib\armeabi-v7a\libcasdkjni.so
>copy 你的路径\libidentifyapp.so lib\armeabi-v7a\libidentifyapp.so
>copy 你的路径\CopyrightDeclaration.xml CopyrightDeclaration.xml
>copy 你的路径\mmiap.xml mmiap.xml
>copy 你的路径\VERSION VERSION
>del 123.apk
>jar -cf 1234.apk .
>jarsigner -verbose -keystore 你的路径\你的签名文件.keystore -storepass ****-keypass 密码 -signedjar oyp-sign.apk 1234.apk android.keystore

路径自行修改 命令中中文部分用你本机的代替


## 作者

* [platformANEs](https://github.com/platformanes)由 [zrong](http://zengrong.net) 和 [rect](http://www.shadowkong.com/) 共同发起并完成。
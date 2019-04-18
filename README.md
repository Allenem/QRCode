# Java使用QRCode.jar生成与解析二维码简介

这个是我根据好几个人的代码修改而成的生成并解读二维码的java程序   
主要由3个文件组成：   
   
**1.control.java**   
**2.MyQRCodeImage.java**   
**3.QRCode.jar**   
   
**主要思路**就是main函数控制encode类和decode类   
class encode生成并存储二维码图片   
class decode解码图片并输出二维码图片信息   
MyQRCodeImage.java是读取图片接口   
QRCode.jar是二维码相关运算的依赖包   
   
去下面给出的地址下载QRCode.jar包，此jar包已经包括 生成与解析 。官网下载到的jar包是没有解析的。   
[**QRCode.zip**](https://files.cnblogs.com/files/bigroc/QRCode.zip)   
   
**特别感谢**[bigroc](https://www.cnblogs.com/bigroc/)的文章[《Java使用QRCode.jar生成与解析二维码》](http://www.cnblogs.com/bigroc/p/7496995.html)   
   
**文件框架如下：**   
![文件框架.png](https://upload-images.jianshu.io/upload_images/7728717-78a61087542051ac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)   
   
**效果图如下：**    
![运行代码截图.png](https://upload-images.jianshu.io/upload_images/7728717-f54df946a40a2e93.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)   
   
**生成二维码图片如下：**   
![qrcode.jpg](https://upload-images.jianshu.io/upload_images/7728717-fa50a4db8a5acd0f.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)   
   
初学者不足之处还请批评指正 ︿(๑‾ ꇴ ‾๑)︿[THANK YOU~]
package com.allenem.qrcode;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class control {
    public static void main(String[] args) {
    	String data="https://github.com/Allenem";
    	long t = System.currentTimeMillis();
    	Random rand = new Random(t);
    	int [][] r = new int[37][37];
    	for(int i=0; i<37; i++) {
    		for(int j=0; j<37; j++) {
    			r[j][i] = rand.nextInt(2);
    		}
    	}
    	// 生成二维码
    	control.encode(data, "qrcodeimage/qrcode.jpg");

    	// 解析二维码
    	control.decode("qrcodeimage/qrcode.jpg");
    }
    
    //生成并输出二维码
    private static boolean encode(String srcValue, String qrcodePicfilePath){
    	int MAX_DATA_LENGTH = 200;
    	byte[] d = srcValue.getBytes();
    	int dataLength = d.length;
    	int imageWidth = 189;
    	int imageHeight = imageWidth;
    	BufferedImage bi = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);//缓冲区
    	Graphics2D g = bi.createGraphics();//绘图
    	g.setBackground(Color.WHITE);
    	g.clearRect(0, 0, imageWidth, imageHeight);
    	g.setColor(Color.BLACK);
    	if (dataLength > 0 && dataLength <= MAX_DATA_LENGTH) {
    		Qrcode qrcode = new Qrcode();
    		/**
    		 * correction level分为
    		 * level L : 最大 7% 的错误能够被纠正；
    		 * level M : 最大 15% 的错误能够被纠正；
             * level Q : 最大 25% 的错误能够被纠正；
             * level H : 最大 30% 的错误能够被纠正；
             */
    		qrcode.setQrcodeErrorCorrect('Q');
    		qrcode.setQrcodeEncodeMode('B');//注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表其他
    		qrcode.setQrcodeVersion(5);//版本号  1-40
    		boolean[][] b = qrcode.calQrcode(d);//让字符串生成二维码
    		int qrcodeDataLen = b.length;
    		for (int i = 0; i < qrcodeDataLen; i++) {
    			for (int j = 0; j < qrcodeDataLen; j++) {
    				if (b[j][i]) {
    					g.fillRect(j * 5 + 2, i * 5 + 2, 5, 5);//2为偏移量，5,5为矩形小块宽高
    					}
    			}
    		}
    	System.out.println("二维码成功生成！！");
    	} else {
    		System.out.println( dataLength +"大于"+ MAX_DATA_LENGTH);
    		return false;
    	}
    	g.dispose();
    	bi.flush();
    	File f = new File(qrcodePicfilePath);
    	String suffix = f.getName().substring(f.getName().indexOf(".")+1, f.getName().length());
    	System.out.println("二维码输出成功！！");
    	try {
    		ImageIO.write(bi, suffix, f);
    		} catch (IOException ioe) {
    			System.out.println("二维码生成失败" + ioe.getMessage());
    		}
    	return true;
    }
    
    //解析二维码
    private static String decode(String qrcodePicfilePath) {
    	System.out.println("开始解析二维码！！");
    	
    	//读取二维码图像数据
    	File imageFile = new File(qrcodePicfilePath);
    	BufferedImage image = null;
    	try {
    		image = ImageIO.read(imageFile);
    	} catch (IOException e) {
    		System.out.println("读取二维码图片失败： " + e.getMessage());
    		return null;
    	}
    	
		//解二维码
    	QRCodeDecoder decoder = new QRCodeDecoder();
    	String decodedData = new String(decoder.decode(new MyQRCodeImage(image))); //MyQRCodeImage要有接口文件
    	System.out.println("解析内容如下："+decodedData);
    	return decodedData;
    }
}
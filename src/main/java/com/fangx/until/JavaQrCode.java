package com.efx.quality.until;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import gui.ava.html.image.generator.HtmlImageGenerator;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class JavaQrCode {
	/**
	 * 生成包含字符串信息的店面二维码图片
	 * @param content 二维码携带信息
	 * @param dmname 二维码店面名称
	 * @throws WriterException
	 * @throws IOException
	 */
	private static int qrCodeSize = 650;//二维码图片大小
	//private static String root=System.getProperty("user.dir");//项目根目录路径
	private static String root= JavaQrCode.class.getClass().getResource("/").getPath();
	
	public static BufferedImage createImage(String tback, String html, Integer xindex, Integer yindex, Integer width, Integer height) throws WriterException, IOException {
		//背景图片的路径
		//File logoFile = new File(JavaQrCode.class.getClassLoader().getResource("tback.jpg").getFile());
		File logoFile = new File(root.substring(1,root.length())+"static/upload/jzimg/"+tback);
		
		InputStream imagein = new FileInputStream(logoFile.toString());
		//读出背景图片
		BufferedImage imagek = ImageIO.read(imagein);

		Graphics g = imagek.getGraphics();
		//将html画到背景图片中 left:xindex top:width

		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		imageGenerator.loadHtml(html);
		int imageWidth = imageGenerator.getBufferedImage().getWidth();
		int imageHeight = imageGenerator.getBufferedImage().getHeight();

		Image big = transferAlpha(imageGenerator,imageWidth, imageHeight);
		g.drawImage(big, xindex, yindex, null);
		imagek.flush();
		return imagek;
	}
	public static Image transferAlpha(HtmlImageGenerator imageGenerator,int imageWidth,int imageHeight) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		BufferedImage bufferedImage = null;
		try {
			ImageIcon imageIcon = new ImageIcon(imageGenerator.getBufferedImage().getScaledInstance(imageWidth, imageHeight,Image.SCALE_SMOOTH));
			bufferedImage =imageGenerator.getBufferedImage();
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
			int alpha = 0;
			for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
				for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
					int rgb = bufferedImage.getRGB(j2, j1);
					int R = (rgb & 0xff0000) >> 16;
					int G = (rgb & 0xff00) >> 8;
					int B = (rgb & 0xff);
					if (((255 - R) < 100) && ((255 - G) < 100) && ((255 - B) < 100)) {
						rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);
					}
					bufferedImage.setRGB(j2, j1, rgb);
				}
			}
			g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return bufferedImage.getScaledInstance(imageWidth, imageHeight,Image.SCALE_DEFAULT);

	}

	public static Image transferAlphaToAny(HtmlImageGenerator imageGenerator,int imageWidth,int imageHeight) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		BufferedImage bufferedImage = null;
		try {
			ImageIcon imageIcon = new ImageIcon(imageGenerator.getBufferedImage().getScaledInstance(imageWidth, imageHeight,Image.SCALE_DEFAULT));
			bufferedImage =imageGenerator.getBufferedImage();
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
			int alpha = 0;
			for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
				for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
					int rgb = bufferedImage.getRGB(j2, j1);
					int R = (rgb & 0xff0000) >> 16;
					int G = (rgb & 0xff00) >> 8;
					int B = (rgb & 0xff);
					if (((255 - R) < 1) && ((255 - G) < 1) && ((255 - B) < 1)) {
						rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);
					}
					bufferedImage.setRGB(j2, j1, rgb);
				}
			}
			g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return bufferedImage.getScaledInstance(imageWidth, imageHeight,Image.SCALE_DEFAULT);
	}

	/**
	 * 读二维码并输出携带的信息
	 */
	public static void readQrCode(InputStream inputStream) throws IOException {
		// 从输入流中获取字符串信息
		BufferedImage image = ImageIO.read(inputStream);
		// 将图像转换为二进制位图源
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		QRCodeReader reader = new QRCodeReader();
		Result result = null;
		try {
			result = reader.decode(bitmap);
		} catch (ReaderException e) {
			e.printStackTrace();
		}
		System.out.println(result.getText());
	}

	/**
	 * BufferedImage 编码转换为 base64
	 * @param bufferedImage
	 * @return
	 */
	public static String BufferedImageToBase64(BufferedImage bufferedImage) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
		try {
			ImageIO.write(bufferedImage, "jpg", baos);//写入流中
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();//转换成字节
		BASE64Encoder encoder = new BASE64Encoder();
		String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
//		System.out.println(png_base64);
		png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
//		System.out.println("值为：" + "data:image/jpg;base64," + png_base64);
		//return 为jpg格式则写jpg ;png则写png
		return "data:image/jpg;base64," + png_base64;
	}

	public static void main(String[] args) {
//		File f = new File("c:\\cs.jpg");
//		if(!f.isDirectory()) f.mkdirs();
//		//PW#表示用户出示的二维码，提供给商户扫码
		try {
		System.out.println(BufferedImageToBase64(createImage("AA-100-212-595-270.jpg",
				"<p>王五小朋友：</p><p>在2022-20232022-2023春的学习中，表现优秀，热心助人，被评为：</p><p style='text-align:center;'><span style='font-size:24px;'>学习标兵</span></p><p>特发此证，以资鼓励 </p> <p style='text-align:right;'> 学校 </p><p style='text-align:right;'> 2023年6月12日 </p>",
				100,212,595,270)));
//			ImageIO.write(JavaQrCode.createQrCode("PW#12","江夏超市"), "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}


	}
	
}

package com.efx.quality.until;

import cn.hutool.core.util.ObjectUtil;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

/**
 * @Description:
 * @author: Ajie
 * @date: 2022/5/26
 */
public class QRCodeUtils {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 1500;
	// LOGO宽度
	private static final int WIDTH = 100;
	// LOGO高度
	private static final int HEIGHT = 100;

	// 这个方法存储1250多个字节
	private static BufferedImage createImage(String content, String imgPath,
											 boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
						: 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtils.insertImage(image, imgPath, needCompress);
		return image;
	}

	/**
	 * 插入LOGO
	 *
	 * @param source
	 *            二维码图片
	 * @param imgPath
	 *            LOGO图片地址
	 * @param needCompress
	 *            是否压缩
	 * @throws Exception
	 */
	private static void insertImage(BufferedImage source, String imgPath,
									boolean needCompress) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
			System.err.println(""+imgPath+"   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 3;
		int y = (QRCODE_SIZE - height) / 3;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param destPath
	 *            存放目录
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String imgPath, String destPath,
								boolean needCompress, String fileName) throws Exception {
		BufferedImage image = QRCodeUtils.createImage(content, imgPath,
				needCompress);
		mkdirs(destPath);
//        String file = new Random().nextInt(99999999)+".jpg";
		String file = fileName +".jpg";
		if (StringUtils.isEmpty(fileName)) {
			file = new Random().nextInt(99999999)+".jpg";
		}
		ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
		return file;
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param destPath
	 *            存放目录
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static String encodeLijie(String content, String imgPath, String destPath,
									 boolean needCompress, String fileName) throws Exception {
		BufferedImage image = QRCodeUtils.createQrCodeLijie(imgPath, content,
				needCompress);
		mkdirs(destPath);
//        String file = new Random().nextInt(99999999)+".jpg";
		String file = fileName +".jpg";
		if (StringUtils.isEmpty(fileName)) {
			file = new Random().nextInt(99999999)+".jpg";
		}
		ImageIO.write(image, "JPEG", new File(destPath+"/"+file));
		return file;
	}

	/**
	 * 生成包含字符串信息的二维码图片  这个方法存储2950多个字节
	 * @param logPath
	 * @param content
	 * @param needCompress
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage createQrCodeLijie(String logPath, String content ,boolean needCompress) throws Exception {
		//设置二维码纠错级别ＭＡＰ
		Hashtable hintMap = new Hashtable();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  // 矫错级别
		//设置UTF-8， 防止中文乱码
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//设置二维码四周白色区域的大小
		//hintMap.put(EncodeHintType.MARGIN,0);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		//创建比特矩阵(位矩阵)的QR码编码的字符串
		BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hintMap);
		// 使BufferedImage勾画QRCode  (matrixWidth 是行二维码像素点)
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth-200, matrixWidth-200, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// 使用比特矩阵画并保存图像
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < matrixWidth; i++){
			for (int j = 0; j < matrixWidth; j++){
				if (byteMatrix.get(i, j)){
					graphics.fillRect(i-100, j-100, 1, 1);
				}
			}
		}
		if (ObjectUtil.isNotNull(logPath))
			QRCodeUtils.insertImage(image, logPath, needCompress);
		return image;
	}

	/**
	 * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
	 * @date 2013-12-11 上午10:16:36
	 * @param destPath 存放目录
	 */
	public static void mkdirs(String destPath) {
		File file =new File(destPath);
		//当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static void encode(String content, String imgPath, String destPath)
			throws Exception {
		QRCodeUtils.encode(content, imgPath, destPath, false, "");
	}

	/**
	 * 生成二维码
	 *
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(String content, String destPath,
							  boolean needCompress) throws Exception {
		QRCodeUtils.encode(content, null, destPath, needCompress, "");
	}

	/**
	 * 生成二维码
	 *
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static void encode(String content, String destPath) throws Exception {
		QRCodeUtils.encode(content, null, destPath, false, "");
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param output
	 *            输出流
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(String content, String imgPath,
							  OutputStream output, boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtils.createImage(content, imgPath,
				needCompress);
		ImageIO.write(image, FORMAT_NAME, output);
	}

	/**
	 * 生成二维码
	 *
	 * @param content
	 *            内容
	 * @param output
	 *            输出流
	 * @throws Exception
	 */
	public static void encode(String content, OutputStream output)
			throws Exception {
		QRCodeUtils.encode(content, null, output, false);
	}

	/**
	 * 解析二维码
	 *
	 * @param file
	 *            二维码图片
	 * @return
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
				image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	/**
	 * 解析二维码
	 *
	 * @param path
	 *            二维码图片地址
	 * @return
	 * @throws Exception
	 */
	public static String decode(String path) throws Exception {
		return QRCodeUtils.decode(new File(path));
	}

	public static void main(String[] args) throws Exception {
		String text = "(0)UaJgr1Mwgt8sKOw9zEggJtrPOVSEhMpIs4FYDTEnnaUh1q5IkQlkSdATZKO1oh+miz5JtVdAShGP\n" +
				"CodjXJQVIdftAPR7+qBmLwg/zXzaKqHrUWBU0Q0NrpCn9v5lgHT6asxFtmPPUrh8jeGPP3AjpylV\n" +
				"MlK";  //这里设置自定义网站url
//        String logoPath = "D:/opt/report/upFiles/code/1.png";
		String destPath = "D:/opt/report/upFiles/code";
		System.out.println(QRCodeUtils.encode(text, null, destPath,true, "baidu"));
	}
}
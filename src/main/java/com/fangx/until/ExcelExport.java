package com.efx.quality.until;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.efx.quality.controller.OtherController;
import com.efx.quality.controller.WishController;
import com.efx.quality.model.*;
import com.efx.quality.service.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 导出并下载EXCL文件
 * 王新苗
 * 2021-06-10
 */
public class ExcelExport {
	private static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf1= new SimpleDateFormat("yyMMddHHmmss");
	private static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy年MM月dd日");

	private FileOutputStream out = null;

	private static OutputStream outt = null;
	String path = null;


	/**
	 *  Excel二维码导出
	 * @param request
	 * @param response
	 *  
	 */
	public static void Excelexportewm(HttpServletRequest request, HttpServletResponse response, List<String> ewmPath) {
		// web浏览通过MIME类型判断文件是excel类型
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName ="二维码导出.xls";// 下载的时候的文件名
		String file="二维码导出";

		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName = null;
		try {
			outt = response.getOutputStream();
			if (StringUtils.contains(userAgent, "MSIE")) {// IE浏览器
				finalFileName = URLEncoder.encode(fileName, "UTF8");
			} else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
				finalFileName = new String(fileName.getBytes(), "ISO8859-1");
			} else {
				finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 声明一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(file);
		sheet.setDefaultColumnWidth(25);
		sheet.setDefaultRowHeightInPoints(20);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle4 = wb.createCellStyle();
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置单元格字体显示居中（左右方向）
		cellStyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 设置单元格字体显示居中(上下方向)
		// 字体
		HSSFFont fontStyle4 = wb.createFont();
		fontStyle4.setFontName("宋体");
		fontStyle4.setFontHeightInPoints((short) 24);//粗体显示  
		fontStyle4.setBold(true);
		cellStyle4.setFont(fontStyle4);
		CellRangeAddress sv1 = new CellRangeAddress((short) 0, (short) 0,(short) 0, (short) 1);
		sheet.addMergedRegion(sv1);
		HSSFCell cells = row.createCell((short) 0);// 合并单元格示例
		cells.setCellValue(file);
		cells.setCellStyle(cellStyle4);
		// 字体
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontHeightInPoints((short) 11);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);
		row=sheet.createRow(1);
//		row.createCell(0).setCellValue("统计条件："+file);
		row.createCell(0).setCellValue("导出时间："+sdf.format(new Date()));
		row = sheet.createRow(2);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"序号","地址"};
		for(int j=0;j<=1;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle);
		}
		int rowNum=3;	

		for (int i = 0; i<ewmPath.size(); i++) {
			row = sheet.createRow(rowNum);
			String[] s1={String.valueOf((i + 1)),ewmPath.get(i)};
					
			for(int j=0;j<=1;j++){
				cell = row.createCell(j);
				cell.setCellValue(s1[j]);
				cell.setCellStyle(cellStyle);
			}
			
			rowNum ++; 
		}
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Excel二维码导出
	 * @param request
	 * @param response
	 *
	 */
	public static void ExcelexportXYQewm(HttpServletRequest request, HttpServletResponse response, List<String> ewmPath) {
		// web浏览通过MIME类型判断文件是excel类型
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName ="二维码导出.xls";// 下载的时候的文件名
		String file="二维码导出";

		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName = null;
		try {
			outt = response.getOutputStream();
			if (StringUtils.contains(userAgent, "MSIE")) {// IE浏览器
				finalFileName = URLEncoder.encode(fileName, "UTF8");
			} else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
				finalFileName = new String(fileName.getBytes(), "ISO8859-1");
			} else {
				finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 声明一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(file);
		sheet.setDefaultColumnWidth(25);
		sheet.setDefaultRowHeightInPoints(20);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle4 = wb.createCellStyle();
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置单元格字体显示居中（左右方向）
		cellStyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 设置单元格字体显示居中(上下方向)
		// 字体
		HSSFFont fontStyle4 = wb.createFont();
		fontStyle4.setFontName("宋体");
		fontStyle4.setFontHeightInPoints((short) 24);//粗体显示
		fontStyle4.setBold(true);
		cellStyle4.setFont(fontStyle4);
		CellRangeAddress sv1 = new CellRangeAddress((short) 0, (short) 0,(short) 0, (short) 1);
		sheet.addMergedRegion(sv1);
		HSSFCell cells = row.createCell((short) 0);// 合并单元格示例
		cells.setCellValue(file);
		cells.setCellStyle(cellStyle4);
		// 字体
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontHeightInPoints((short) 11);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);
		row=sheet.createRow(1);
//		row.createCell(0).setCellValue("统计条件："+file);
		row.createCell(0).setCellValue("导出时间："+sdf.format(new Date()));
		row = sheet.createRow(2);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"序号","标题","地址"};
		for(int j=0;j<=2;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle);
		}
		int rowNum=3;

		for (int i = 0; i<ewmPath.size(); i++) {
			row = sheet.createRow(rowNum);
			String[] s1={String.valueOf((i + 1)),ewmPath.get(i).split("#")[0],ewmPath.get(i).split("#")[1]};

			for(int j=0;j<=2;j++){
				cell = row.createCell(j);
				cell.setCellValue(s1[j]);
				cell.setCellStyle(cellStyle);
			}

			rowNum ++;
		}
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void getByExcelyyqlx(InputStream in, String fileName, CduwmService uwmService, Integer jdid) throws Exception {
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusf item=new cdusf();
		String fpath = WishController.class.getClass().getResource("/").getPath();
		fpath =fpath.substring(1,fpath.length())+"static/upload/xyqewm/";
		String name="";
		cduwm uwm = new cduwm();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				name = getValue(row.getCell(0)).replaceAll(" ", "");
				if (!name.isEmpty()) {
					uwm=uwmService.selectByName(name);
					if(uwm==null){
						uwm=new cduwm();
						uwm.setUwm001(UUID.randomUUID().toString().replaceAll("-",""));
						uwm.setUwm002(name);
						uwm.setUwm003("B");
						uwm.setUwm004(jdid);
						uwm = uwmService.insert(uwm);
						String ewmPath=PubMessage.serverUrl+"/care/toxyqlxwem?id="+uwm.getUwm001();//TODO
						File f=new File(fpath);
						if(!f.exists())f.mkdirs();
						QrCodeUtil.generate(ewmPath, 400, 400, FileUtil.file(fpath+uwm.getUwm002()+".jpg"));
					}/*else{
						String ewmPath=PubMessage.serverUrl+"/care/toxyqlxwem?id="+uwm.getUwm001();//TODO
						File f=new File(fpath);
						if(!f.exists())f.mkdirs();
						QrCodeUtil.generate(ewmPath, 400, 400, FileUtil.file(fpath+uwm.getUwm002()+".jpg"));
					}*/
				}
			}
		}
	}

	public static String getByExcells(InputStream in, String fileName, CdusfService usfService, CdusmService usmService, CduscService uscService, CdusbService usbService, CdusaService usaService, CduseService useService, Integer jgid) throws Exception {
		String fh="";
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusf item=new cdusf();
		String name="";
		String phone="";
		String gwname="";
		String gwlx="";
		String bjname="";
		String rjname="";
		cdusc usc=new cdusc();
		cdusb usb=new cdusb();
		cdusm usm=new cdusm();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				name = getValue(row.getCell(0)).replaceAll(" ", "");
				phone=getValue(row.getCell(1)).replaceAll(" ","");
				gwname=getValue(row.getCell(2)).replaceAll(" ","");
				bjname=getValue(row.getCell(3)).replaceAll(" ","");
				rjname=getValue(row.getCell(4)).replaceAll(" ","");
				if (!name.isEmpty()||!phone.isEmpty()||!gwname.isEmpty()||!bjname.isEmpty()||!rjname.isEmpty()) {
					if (!name.isEmpty()&&!phone.isEmpty()&&!gwname.isEmpty()) {
						gwlx=gwname.equals("行政人员+班主任")?"D":(gwname.equals("行政人员")?"C":(gwname.equals("班主任")?"B":(gwname.equals("教师")?"A":"")));
						item=usfService.selectByjdid1(name,phone,gwlx,jgid);
						if(item==null){
							item=new cdusf();
							item.setUsf002(name);
							item.setUsf003(phone);
							item.setUsf004(jgid);
							item.setUsf006(new Date());
							item.setUsf009("A");
							item.setUsf013("A");
							item.setUsf014(gwlx);
							item=usfService.insert(item);
							cduse use=new cduse();
							use.setUse002(item.getUsf003());
							use.setUse003(EncrpytUtil.getSHA256("123456"));
							use.setUse005(item.getUsf002());
							use.setUse006("D");
							use.setUse007(item.getUsf003());
							use.setUse010(item.getUsf004());
							use.setUse011(item.getUsf001());
							use.setUse008(usaService.selectByname(gwname,item.getUsf004(),item.getUsf005()));
							use.setUse018("A");
							useService.insert(use);
						}
						if(!bjname.isEmpty()){
							String[] bj=bjname.split("#");
							for(String s:bj){
								if(!s.isEmpty()){
									usm=usmService.selectbyllid(item.getUsf001(), s.split("&")[0],s.split("&")[1],jgid,"A");
									if(usm==null){
										usc=uscService.selectByname(s.split("&")[0],jgid);
										usb=usbService.selectByname(s.split("&")[1],usc.getUsc001(),jgid);
										usm=new cdusm();
										usm.setUsm002(item.getUsf001());
										usm.setUsm003(usc.getUsc001());
										usm.setUsm004(usb.getUsb001());
										usm.setUsm006("A");
										usmService.insert(usm);
									}
								}
							}
						}
						if(!rjname.isEmpty()&&(gwlx.equals("D")||gwlx.equals("B"))){
							String[] bj=rjname.split("#");
							for(String s:bj){
								if(!s.isEmpty()){
									usm=usmService.selectbyllid(item.getUsf001(), s.split("&")[0],s.split("&")[1],jgid,"B");
									if(usm==null){
										usc=uscService.selectByname(s.split("&")[0],jgid);
										usb=usbService.selectByname(s.split("&")[1],usc.getUsc001(),jgid);
										usm=new cdusm();
										usm.setUsm002(item.getUsf001());
										usm.setUsm003(usc.getUsc001());
										usm.setUsm004(usb.getUsb001());
										usm.setUsm006("B");
										usmService.insert(usm);
									}
								}
							}
						}
					}else{
						fh+="第"+row_num+"行导入不成功";
						break;
					}
				}
			}
		}
		return fh.isEmpty()?"A":fh;
	}

	public static String getByExcelxs(InputStream in, String fileName, CduscService uscService, CdusbService usbService, CdusnService usnService, CduspService uspService, CdyhaService yhaService, Integer jgid) throws Exception {
		List<cdusn> list = new ArrayList<>();
		String fh="";
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusn item=new cdusn();
		cdusp usp=new cdusp();
		cdyha yha=new cdyha();
		String njname="";
		String bjname="";
		String rxnf="";
		String name="";
		String sex="";
		String code="";
		String phone1="";
		String phone2="";
		cdusc usc=new cdusc();
		cdusb usb=new cdusb();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				njname=getValue(row.getCell(0));
				bjname=getValue(row.getCell(1)).replaceAll(" ","");
				rxnf=getValue(row.getCell(2)).replaceAll(" ","");
				name=getValue(row.getCell(3)).replaceAll(" ","");
				sex=getValue(row.getCell(4));
				code=getValue(row.getCell(5)).replaceAll(" ","");
				phone1=getValue(row.getCell(6)).replaceAll(" ","");
				phone2=getValue(row.getCell(7)).replaceAll(" ","");
				if(!njname.isEmpty()||!bjname.isEmpty()||!rxnf.isEmpty()||!name.isEmpty()||!sex.isEmpty()||!code.isEmpty()||!phone1.isEmpty()||!phone2.isEmpty()){
					if(!njname.isEmpty()){
						usc=uscService.selectByname(njname,jgid);
						if(!bjname.isEmpty()){
							usb=usbService.selectByname(bjname,usc.getUsc001(),jgid);
							if(usb==null){
								if(!rxnf.isEmpty()){
									usb=new cdusb();
									usb.setUsb002(bjname);
									usb.setUsb003("A");
									usb.setUsb004(jgid);
									usb.setUsb005(usc.getUsc001());
									usb.setUsb007(rxnf);
									usb=usbService.insert(usb);
								}else{
									fh+="第"+row_num+"行导入不成功";
									break;
								}
							}
							if(!name.isEmpty()){
								item=usnService.selectByxsid(name,code,usb.getUsb001(),jgid,"K",null);
								if(item!=null){
									if(!sex.isEmpty())item.setUsn003(sex.equals("男")?"M":"N");
									if(!code.isEmpty())item.setUsn004(code);
									item.setUsn013("A");
									yhaService.deletebyxxid(item.getUsn001());
									if(!phone1.isEmpty()){
										item.setUsn011(phone1.replaceAll("\\+86-",""));
										usp=uspService.selectByPhone(item.getUsn011());
										if(usp!=null&&!yhaService.selectByjzxs(usp.getUsp001(),item.getUsn001())){
											yha=new cdyha();
											yha.setYha001(UUID.randomUUID().toString().replaceAll("-",""));
											yha.setYha002(usp.getUsp001());
											yha.setYha003(item.getUsn001());
											yha.setYha004("A");
											yhaService.insert(yha);
										}
									}
									if(!phone2.isEmpty()){
										item.setUsn012(phone2.replaceAll("\\+86-",""));
										usp=uspService.selectByPhone(item.getUsn012());
										if(usp!=null&&!yhaService.selectByjzxs(usp.getUsp001(),item.getUsn001())){
											yha=new cdyha();
											yha.setYha001(UUID.randomUUID().toString().replaceAll("-",""));
											yha.setYha002(usp.getUsp001());
											yha.setYha003(item.getUsn001());
											yha.setYha004("A");
											yhaService.insert(yha);
										}
									}
									usnService.update(item);
								}else{
									item=new cdusn();
									item.setUsn001(UUID.randomUUID().toString().replaceAll("-",""));
									item.setUsn002(name);
									if(!sex.isEmpty())item.setUsn003(sex.equals("男")?"M":"N");
									if(!code.isEmpty())item.setUsn004(code);
									item.setUsn005(jgid);
									item.setUsn006(usb.getUsb001());
									item.setUsn009(0);
									item.setUsn010("K");
									item.setUsn013("A");
									item.setUsn014(0);
									item.setUsn016(0);
									if(!phone1.isEmpty()){
										item.setUsn011(phone1.replaceAll("\\+86-",""));
										usp=uspService.selectByPhone(item.getUsn011());
										if(usp!=null){
											yha=new cdyha();
											yha.setYha001(UUID.randomUUID().toString().replaceAll("-",""));
											yha.setYha002(usp.getUsp001());
											yha.setYha003(item.getUsn001());
											yha.setYha004("A");
											yhaService.insert(yha);
										}
									}
									if(!phone2.isEmpty()){
										item.setUsn012(phone2.replaceAll("\\+86-",""));
										usp=uspService.selectByPhone(item.getUsn012());
										if(usp!=null){
											yha=new cdyha();
											yha.setYha001(UUID.randomUUID().toString().replaceAll("-",""));
											yha.setYha002(usp.getUsp001());
											yha.setYha003(item.getUsn001());
											yha.setYha004("A");
											yhaService.insert(yha);
										}
									}
									item=usnService.insert(item);
//								list.add(item);
								}
							}else{
								fh+="第"+row_num+"行导入不成功";
								break;
							}
						}else{
							fh+="第"+row_num+"行导入不成功";
							break;
						}
					}else{
						fh+="第"+row_num+"行导入不成功";
						break;
					}
				}
			}
		}
//		if(list.size()>0)usnService.insertBatch(list);
		return fh.isEmpty()?"A":fh;
	}

	public static List<cdusb> getByExcelwwg(InputStream in, String fileName, CdusgService usgService, CdusdService usdService, CduscService uscService, CdusbService usbService, Integer jdid) throws Exception {
		List<cdusb> list = new ArrayList<>();
		cdusb item=new cdusb();
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusd usd=new cdusd();
		cdusc usc=new cdusc();
		String jgname="";
		String wgname="";
		String wwgname="";
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				jgname=getValue(row.getCell(0)).replaceAll(" ","");
				wgname=getValue(row.getCell(1)).replaceAll(" ","");
				wwgname=getValue(row.getCell(2)).replaceAll(" ","");
				if(!jgname.isEmpty()){
					usd=usdService.selectByname("B",jgname,jdid);
					if(usd==null) {
						usd = new cdusd();
						usd.setUsd002(jgname);
						usd.setUsd007(new Date());
						usd.setUsd009(jdid);
						usd.setUsd014("B");
						usd.setUsd020("A");
						usd.setUsd021("A");
						usd = usdService.insert(usd);
					}
					usc=uscService.selectByname(wgname,usd.getUsd001());
					if(usc==null) {
						usc=new cdusc();
						usc.setUsc002(wgname);
						usc.setUsc003("A");
						usc.setUsc005(usd.getUsd001());
						usc=uscService.insert(usc);
					}
					item=usbService.selectByname(wwgname,usc.getUsc001(),usd.getUsd001());
					if(item==null) {
						item=new cdusb();
						item.setUsb002(wwgname);
						item.setUsb003("A");
						item.setUsb004(usd.getUsd001());
						item.setUsb005(usc.getUsc001());
						list.add(item);
					}
				}
			}
		}
		work.close();
		in.close();
		return list;
	}

	/**
	 * 描述：对表格中数值进行格式化
	 * @param cell
	 * @return
	 */
	//解决excel类型问题，获得数值
	public static  String getValue(Cell cell) {
		String value = "";
		if(null==cell){
			return value;
		}
		switch (cell.getCellType()) {
			//数值型
			case Cell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					//如果是date类型则 ，获取该cell的date值
					Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					value = format.format(date);;
				}else {// 纯数字
					BigDecimal big=new BigDecimal(cell.getNumericCellValue());
					value = big.toString();
					//解决1234.0  去掉后面的.0
					if(null!=value&&!"".equals(value.trim())){
						String[] item = value.split("[.]");
						if(1<item.length&&"0".equals(item[1])){
							value=item[0];
						}
					}
				}
				break;
			//字符串类型
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue().toString();
				break;
			// 公式类型
			case Cell.CELL_TYPE_FORMULA:
				//读公式计算值
				value = String.valueOf(cell.getNumericCellValue());
				if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
					value = cell.getStringCellValue().toString();
				}
				break;
			// 布尔类型
			case Cell.CELL_TYPE_BOOLEAN:
				value = " "+ cell.getBooleanCellValue();
				break;
			default:
				value = cell.getStringCellValue().toString();
		}
		if("null".endsWith(value.trim())){
			value="";
		}
		return value;
	}

	/**
	 *  Excel二维码导出
	 * @param request
	 * @param response
	 *
	 */
	public static void Excelexportjzmb(HttpServletRequest request, HttpServletResponse response, cdtha yhx) {
		// web浏览通过MIME类型判断文件是excel类型
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName ="名单导入模板.xls";// 下载的时候的文件名
		String file="名单导入";

		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName = null;
		try {
			outt = response.getOutputStream();
			if (StringUtils.contains(userAgent, "MSIE")) {// IE浏览器
				finalFileName = URLEncoder.encode(fileName, "UTF8");
			} else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
				finalFileName = new String(fileName.getBytes(), "ISO8859-1");
			} else {
				finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 声明一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(file);
		sheet.setDefaultColumnWidth(25);
		sheet.setDefaultRowHeightInPoints(20);
		HSSFRow row = sheet.createRow(0);

		// 字体
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontHeightInPoints((short) 11);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		cellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);

		row=sheet.createRow(0);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"学期","年级","班级","学生（以#分割）","奖项名称","奖次名称"};
		for(int j=0;j<s.length;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle);
		}
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getByExceljzxs(InputStream in, String fileName, CdthaService thaService, CdyhkService yhkService, CduscService uscService, CdusbService usbService, CdusnService usnService, CdyhhService yhhService, Integer jzid, Integer jxid) throws Exception {
//		List<cdyhh> list = new ArrayList<>();
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusn usn=null;
		cdusc usc=null;
		cdusb usb=null;
		cdyhk yhk=null;
		String xq="";
		String nj="";
		String bj="";
		String name="";
		String xsid="";
		String jcmc="";
		String jxmc="";
		String xsname="";
		String ts="";
		cdyhh item=null;
		cdtha tha=thaService.selectByPrimaryKey1(jzid);
		String html="";
		boolean flag=true;
		ArrayList<cdyhh> thhlist = new ArrayList<cdyhh>();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				flag=true;
				item= new cdyhh();
				xsname="";
				html="";
				xq=getValue(row.getCell(0));
				nj=getValue(row.getCell(1));
				bj=getValue(row.getCell(2));
				name=getValue(row.getCell(3));
				jxmc=getValue(row.getCell(4));
				jcmc=getValue(row.getCell(5));
				yhk=yhkService.selectByname(xq,tha.getTha009());
				usc=uscService.selectByname(nj,tha.getTha009());
				if(usc!=null){
					item=new cdyhh();
					item.setYhh002(jzid);
					item.setYhh003(jxid);
					item.setYhh004(usc.getUsc001());
					if(!bj.isEmpty()){
						usb=usbService.selectByname(bj,usc.getUsc001(),tha.getTha009());
						if(usb!=null){
							item.setYhh005(usb.getUsb001());
							if(!name.isEmpty()){
								xsid="#";
								String[] names=name.split("#");
								List<cdusn> usnlist=new ArrayList<>();
								for(int i=0;i<names.length;i++){
									if(!name.isEmpty()){
										usn=usnService.selectByxsid(name,null,usb.getUsb001(),tha.getTha009(),"K","A");
										if(usn!=null){
											usnlist.add(usn);
											xsid+=usn.getUsn001()+"#";
											xsname+=name+"、";
										}else{
											ts=ts+"第"+row_num+"行导入不成功";
											flag=false;
											break;
										}
									}
								}
								if(flag&&!jxmc.isEmpty()&&!jxmc.isEmpty()){
									item.setYhh006(xsid);
									xsname=xsname.substring(0,xsname.length()-1);
									item.setYhh009(yhk.getYhk001());
									item.setYhh012(jcmc);
									item.setYhh016(jxmc);
									item.setYhh014(sdf1.format(new Date()));
									item=yhhService.insert(item);//todo
									item.setUsnlist(usnlist);
									thhlist.add(item);
								}else{
									ts=ts+"第"+row_num+"行导入不成功";
								}
							}else{
								ts=ts+"第"+row_num+"行导入不成功";
							}
						}else{
							ts=ts+"第"+row_num+"行导入不成功";
						}
					}else{
						ts=ts+"第"+row_num+"行导入不成功";
					}
				}else{
					ts=ts+"第"+row_num+"行导入不成功";
				}
			}
		}
		IMGUtil.createImage(tha,thhlist,item.getYhh014());
		ts=ts.isEmpty()?"A":ts;
		return ts;
	}

	public static List<cdusn> getByExcelwwgy(InputStream in, String fileName, CdusnService usnService, CdusgService usgService, CdusdService usdService, CduscService uscService, CdusbService usbService, Integer jdid) throws Exception {
		List<cdusn> list = new ArrayList<>();
		cdusn item=new cdusn();
		ExcelImport exc = new ExcelImport();
		// 创建Excel工作薄
		Workbook work = exc.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null; // 页数
		Row row = null; // 行数
		//Cell cell = null; // 列数
		sheet = work.getSheetAt(0);
		cdusb usb =new cdusb();
		cdusd usd=new cdusd();
		cdusc usc=new cdusc();
		cdusn item1=new cdusn();
		String jgname="";
		String wgname="";
		String wwgname="";
		String wwgyname="";
		String wwgyphone="";
		String wwgycode="";
		String fpath = OtherController.class.getClass().getResource("/").getPath();
		fpath =fpath.substring(1,fpath.length())+"static/upload/wgy/";
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				jgname=getValue(row.getCell(0)).replaceAll(" ","");
				wgname=getValue(row.getCell(1)).replaceAll(" ","");
				wwgname=getValue(row.getCell(2)).replaceAll(" ","");
				wwgyname=getValue(row.getCell(3)).replaceAll(" ","");
				wwgyphone=getValue(row.getCell(4)).replaceAll(" ","");
				wwgycode=getValue(row.getCell(5)).replaceAll(" ","");
				if(!jgname.isEmpty()){
					usd=usdService.selectByname("B",jgname,jdid);
					if(usd==null) {
						usd = new cdusd();
						usd.setUsd002(jgname);
						usd.setUsd007(new Date());
						usd.setUsd009(jdid);
						usd.setUsd014("B");
						usd.setUsd020("A");
						usd.setUsd021("A");
						usd = usdService.insert(usd);
					}
					usc=uscService.selectByname(wgname,usd.getUsd001());
					if(usc==null) {
						usc=new cdusc();
						usc.setUsc002(wgname);
						usc.setUsc003("A");
						usc.setUsc005(usd.getUsd001());
						usc=uscService.insert(usc);
					}
					usb=usbService.selectByname(wwgname,usc.getUsc001(),usd.getUsd001());
					if(usb==null) {
						usb=new cdusb();
						usb.setUsb002(wwgname);
						usb.setUsb003("A");
						usb.setUsb004(usd.getUsd001());
						usb.setUsb005(usc.getUsc001());
						usb=usbService.insert(usb);
					}
					item=usnService.selectBywwgy1(wwgyname,wwgyphone, null);
					item1=usnService.selectBywwgy(wwgycode);
					if(item==null) {
						if(item1==null){
							item=new cdusn();
							item.setUsn001(UUID.randomUUID().toString().replace("-",""));
							item.setUsn002(wwgyname);
							item.setUsn004(wwgycode);
							item.setUsn005(usd.getUsd001());
							item.setUsn006(usb.getUsb001());
							item.setUsn009(0);
							item.setUsn011(wwgyphone);
							item.setUsn013("A");
							item.setUsn014(0);
							item.setUsn016(0);
							item.setUsn018(0);
							item.setUsn019("A");
							item.setUsn020(1);
							item.setUsn007(new Date());
							list.add(item);
						}else{
							item=new cdusn();
							item.setUsn001(UUID.randomUUID().toString().replace("-",""));
							item.setUsn002(wwgyname);
							item.setUsn004(wwgycode);
							item.setUsn005(usd.getUsd001());
							item.setUsn006(usb.getUsb001());
							item.setUsn009(0);
							item.setUsn011(wwgyphone);
							item.setUsn013("A");
							item.setUsn014(0);
							item.setUsn016(0);
							item.setUsn018(0);
							item.setUsn019("A");
							item.setUsn020(1);
							item.setUsn007(new Date());
							list.add(item);
							item1.setUsn004(null);
							item1.setUsn019("B");
							usnService.update(item1);
						}
					}else{
						if(item1==null){
							item.setUsn004(wwgycode);
							item.setUsn005(usd.getUsd001());
							item.setUsn006(usb.getUsb001());
							item.setUsn013("A");
							item.setUsn014(0);
							item.setUsn016(0);
							item.setUsn018(0);
							item.setUsn019("A");
							item.setUsn020(1);
							item.setUsn007(new Date());
							usnService.update(item);
						}else{
							item.setUsn004(wwgycode);
							item.setUsn005(usd.getUsd001());
							item.setUsn006(usb.getUsb001());
							item.setUsn013("A");
							item.setUsn014(0);
							item.setUsn016(0);
							item.setUsn018(0);
							item.setUsn019("A");
							item.setUsn020(1);
							item.setUsn007(new Date());
							usnService.update(item);
							item1.setUsn004(null);
							item1.setUsn019("B");
							usnService.update(item1);
						}
					}
					File f=new File(fpath);
					if(!f.exists()||!(new File(fpath+item.getUsn004()+".jpg")).exists()){
						if(!f.exists())f.mkdirs();
						String hid= item.getUsn001()+"#"+item.getUsn020();
						hid= AesUtil.encrypt(hid,AesUtil.Key1);
//                          hid=AesUtil.encryptSM(yhu.getYhu001(),i);
						String ewmPath=PubMessage.serverUrl+"/care/towgywem?hid="+hid;//TODO
						QrCodeUtil.generate(ewmPath, 400, 400, FileUtil.file(fpath+item.getUsn004()+".jpg"));
					}
				}
			}
		}
		work.close();
		in.close();
		return list;
	}
}

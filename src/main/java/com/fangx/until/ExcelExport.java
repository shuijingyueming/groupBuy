package com.fangx.until;

import com.fangx.model.*;
import com.fangx.service.*;
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
import java.util.Calendar;
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
	private static SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
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
	public static void ExcelexportXYQewm(HttpServletRequest request, HttpServletResponse response, CdusfService usfService) {
		// web浏览通过MIME类型判断文件是excel类型
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName ="菜品临时库存导入模板.xls";// 下载的时候的文件名
		String file="菜品临时库存导入模板";

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
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
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

		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setLocked(true);
		cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		cellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle1.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle1.setFont(fontStyle);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setLocked(false);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);
//		cellStyle.setDataFormat(wb.createDataFormat().getFormat("0"));
		row=sheet.createRow(0);
//		row.createCell(0).setCellValue("统计条件："+file);
//		row.createCell(0).setCellValue("导出时间："+sdf.format(new Date()));
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"序号","菜品名称","临时库存数"};
		for(int j=0;j<=2;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle1);
		}
		int rowNum=1;
		List<cdusf>list=usfService.serachAll();
		for (int i = 0; i<list.size(); i++) {
			row = sheet.createRow(rowNum);
			String[] s1={String.valueOf((i + 1)),list.get(i).getUsf002()};

			for(int j=0;j<=2;j++){
				cell = row.createCell(j);
				if(j<2)cell.setCellValue(s1[j]);
				cell.setCellStyle(j<2?cellStyle1:cellStyle);
			}

			rowNum ++;
		}
		sheet.protectSheet("123456");
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public static void Excelexportjzmb(HttpServletRequest request, HttpServletResponse response) {
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
			
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
			
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

    public static String getByExcelyg(InputStream in, String fileName, CdusdService usdService, CduscService uscService, CduscService uscService1, CdyhdService yhdService, Integer gsid) throws Exception {
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
		cdusc item=new cdusc();
		String name="";
		String phone="";
		String bumen="";
		String czje="";
		cdusd usd=new cdusd();
		cdyhd yhd=new cdyhd();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				name = getValue(row.getCell(0)).replaceAll(" ", "");
				phone=getValue(row.getCell(1)).replaceAll(" ","");
				bumen=getValue(row.getCell(2)).replaceAll(" ","");
				czje=getValue(row.getCell(3)).replaceAll(" ","");
				if (!name.isEmpty()||!phone.isEmpty()) {
					if (!name.isEmpty()&&!phone.isEmpty()) {
						item=uscService.selectBygsid(name,phone,gsid);
						if(item==null){
							item=new cdusc();
							item.setUsc002(name);
							item.setUsc005(gsid);
							item.setUsc015(phone);
							item.setUsc016(bumen);
							item.setUsc003("A");
							item.setUsc008(0.0F);
							item.setUsc009(0.0F);
							item.setUsc010(0.0F);
							item.setUsc011(0.0F);
							item=uscService.insert(item);
						}else if(!bumen.isEmpty()&&!item.getUsc016().equals(bumen)){
							item.setUsc016(bumen);
							uscService.update(item);
						}
						if(!czje.isEmpty()){
							float num=Float.valueOf(czje);
							item.setUsc008(item.getUsc008()+num);
							item.setUsc009(item.getUsc009()+num);
							yhd=new cdyhd();
							yhd.setYhd001(UUID.randomUUID().toString().replace("-",""));
							yhd.setYhd002(item.getUsc001());
							yhd.setYhd003(item.getUsc005());
							yhd.setYhd004(num);
							yhd.setYhd005(new Date());
							yhdService.insert(yhd);
							uscService.update(item);
						}
					}else{
						fh+="第"+(row_num+1)+"行导入不成功";
						break;
					}
				}
			}
		}
		return fh.isEmpty()?"A":fh;
    }

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static String getByExcelcp(InputStream in, String fileName, CdusfService usfService, CdyscService yscService, String time) throws Exception {
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
		cdysc item=new cdysc();
		String name="";
		String kcsl="";
		cdusf usf=new cdusf();
		for (int row_num = 1; row_num < sheet.getPhysicalNumberOfRows(); row_num++) {
			row = sheet.getRow(row_num);
			if (row != null) {
				name = getValue(row.getCell(1));
				kcsl=getValue(row.getCell(2)).replaceAll(" ","");
				if (!name.isEmpty()||!kcsl.isEmpty()) {
					usf=usfService.selectByName(name);
					if(usf!=null){
						if(!kcsl.isEmpty()){
							if(isNumeric(kcsl)&&Integer.valueOf(kcsl)>=0){
								item=yscService.selectBycpid(usf.getUsf001(),time);
								if(item!=null){
									item.setYsc006(Integer.valueOf(kcsl));
									yscService.update(item);
								}else{
									item=new cdysc();
									item.setYsc002(usf.getUsf001());
									item.setYsc003(sdf2.parse(time));
									item.setYsc005("B");
									item.setYsc006(Integer.valueOf(kcsl));
									yscService.insert(item);
								}
							}else{
								fh+="第"+(row_num+1)+"行导入不成功";
								break;
							}
						}/*else{
							fh+="第"+(row_num+1)+"行导入不成功";
							break;
						}*/
					}else{
						fh+="第"+(row_num+1)+"行导入不成功";
						break;
					}
				}
			}
		}
		return fh.isEmpty()?"A":fh;
	}

	public void Excelexportyhcg(HttpServletRequest request, HttpServletResponse response, CdyheService yheService, CdusfService usfService, String date) throws Exception {
		// web浏览通过MIME类型判断文件是excel类型
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName =date+"采购单.xls";// 下载的时候的文件名
		String file=date+"采购单";

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

			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}
		// 声明一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(file);
		sheet.setDefaultColumnWidth(25);
		sheet.setDefaultRowHeightInPoints(20);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle4 = wb.createCellStyle();
		// 字体
		HSSFFont fontStyle4 = wb.createFont();
		fontStyle4.setFontName("宋体");
		fontStyle4.setFontHeightInPoints((short) 26);
		fontStyle4.setBold(true);//粗体显示
		cellStyle4.setFont(fontStyle4);
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		cellStyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		CellRangeAddress sv1 = new CellRangeAddress((short) 0, (short) 0,(short) 0, (short) 4);
		sheet.addMergedRegion(sv1);
		HSSFCell cells = row.createCell((short) 0);// 合并单元格示例
		cells.setCellValue(file);
		cells.setCellStyle(cellStyle4);
		row.setHeight((short) 800);
		// 字体
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontHeightInPoints((short) 11);
		HSSFCellStyle cellStyle = wb.createCellStyle();
//		cellStyle.setLocked(true);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);
		cellStyle.setWrapText(true);// 自动换行

		row=sheet.createRow(1);
//		row.createCell(0).setCellValue("统计条件："+file);
		row.createCell(0).setCellValue("配送时间："+date);

		row = sheet.createRow(2);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"序号","分类","产品名称","产品单位","总订购量"};
		for(int j=0;j<=4;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle);
		}

		int rowNum=3;
		List<cdyhe> list=yheService.serachAll(null);
		for(cdyhe yhe:list){
			yhe.setUsflist(usfService.selectByCG(date,yhe.getYhe001()));
		}
		int o=0;
		for (int j = 0; j<list.size(); j++) {
			for (int k = 0; k<list.get(j).getUsflist().size(); k++) {
				row = sheet.createRow(rowNum);
				o++;
			String[] s1={String.valueOf(o),
					k==0?list.get(j).getYhe002():"",
					list.get(j).getUsflist().get(k).getUsf002(),
					list.get(j).getUsflist().get(k).getUsm().getUsm002(),
					String.valueOf(list.get(j).getUsflist().get(k).getSl())};
			for(int a=0;a<=4;a++){
				cell = row.createCell(a);
				cell.setCellValue(s1[a]);
				cell.setCellStyle(cellStyle);
			}
			rowNum ++;
			}
		}

//		List<cdusf> list=usfService.selectByCG(date, null);
//		for (int j = 0; j<list.size(); j++) {
//			row = sheet.createRow(rowNum);
//			String[] s1={String.valueOf((j + 1)),list.get(j).getUsf002(), String.valueOf(list.get(j).getSl())};
//			for(int a=0;a<=2;a++){
//				cell = row.createCell(a);
//				cell.setCellValue(s1[a]);
//				cell.setCellStyle(cellStyle);
//			}
//			rowNum ++;
//		}
//		sheet.protectSheet("123456");
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void Excelexportyhdd(HttpServletRequest request, HttpServletResponse response, CdusbService usbService, CdusfService usfService, CdusdService usdService, CduscService uscService, CdyhcService yhcService, CdushService ushService, Integer id, String date) throws Exception {
		// web浏览通过MIME类型判断文件是excel类型
		cdusd usd=usdService.getByid(id);
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName =usd.getUsd002()+"配送单.xls";// 下载的时候的文件名
		String file="宁波方兴菜篮子配送单";

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
			
			e.printStackTrace();
		}
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition", "attachment;filename="
				+ finalFileName);

		try {
			outt = response.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		// 声明一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(file);
		sheet.setDefaultColumnWidth(25);
		sheet.setDefaultRowHeightInPoints(20);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle4 = wb.createCellStyle();
		// 字体
		HSSFFont fontStyle4 = wb.createFont();
		fontStyle4.setFontName("宋体");
		fontStyle4.setFontHeightInPoints((short) 26);
		fontStyle4.setBold(true);//粗体显示
		cellStyle4.setFont(fontStyle4);
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		cellStyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		CellRangeAddress sv1 = new CellRangeAddress((short) 0, (short) 0,(short) 0, (short) 4);
		sheet.addMergedRegion(sv1);
		HSSFCell cells = row.createCell((short) 0);// 合并单元格示例
		cells.setCellValue(file);
		cells.setCellStyle(cellStyle4);
		row.setHeight((short) 800);
		// 字体
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontHeightInPoints((short) 11);
		HSSFCellStyle cellStyle = wb.createCellStyle();
//		cellStyle.setLocked(true);
		// 这里仅设置了底边边框，左边框、右边框和顶边框同理可设
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setFont(fontStyle);
		cellStyle.setWrapText(true);// 自动换行

		row=sheet.createRow(1);
//		row.createCell(0).setCellValue("统计条件："+file);
		row.createCell(0).setCellValue("配送时间："+date);
		row.createCell(1).setCellValue("企业名称："+usd.getUsd002());
		row.createCell(2).setCellValue("企业地址："+usd.getUsd003());
		row.createCell(3).setCellValue("企业电话："+usd.getUsd004());

		row = sheet.createRow(2);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		String[] s={"序号","姓名","电话","内容","备注"};
		for(int j=0;j<=4;j++){
			cell = row.createCell(j);
			cell.setCellValue(s[j]);
			cell.setCellStyle(cellStyle);
		}

		int rowNum=3;

		List<cdusc> yglist=uscService.serachAll(usd.getUsd001());
		for (int j = 0; j<yglist.size(); j++) {
			List<cdyhc> ddlist=yhcService.selectByyhid1(yglist.get(j).getUsc001(),date);
			List<cdusf> list=usfService.selectByDD(yglist.get(j).getUsc001(),date);
			if(list.size()>0){
				row = sheet.createRow(rowNum);
				String nr="";
				String bz="";
				for (int k = 0; k<list.size(); k++) {
					nr+=list.get(k).getUsf002()+"("+list.get(k).getSl().toString()+")";
					if(k<list.size()-1)nr+="+";
				}
				for (int k = 0; k<ddlist.size(); k++) {
					if(ddlist.get(k).getYhc009()!=null&&!ddlist.get(k).getYhc009().isEmpty())bz+=ddlist.get(k).getYhc009()+"#";
				}
				String[] s1={String.valueOf((j + 1)),yglist.get(j).getUsc002(),yglist.get(j).getUsc015().substring(0,1)+"*"+yglist.get(j).getUsc015().substring(yglist.get(j).getUsc015().length()-4),nr,bz};
//				String[] s1={String.valueOf((j + 1)),yglist.get(j).getUsc002(),yglist.get(j).getUsc015(),nr,bz};
				for(int a=0;a<=4;a++){
					cell = row.createCell(a);
					cell.setCellValue(s1[a]);
					cell.setCellStyle(cellStyle);
				}
				rowNum ++;
			}
		}
//		sheet.protectSheet("123456");
		try {
			wb.write(outt);
			outt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Integer getWeekDay(Calendar c){
		if(c == null){
			return 2;
		}
		if(Calendar.MONDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 2;
		}
		if(Calendar.TUESDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 3;
		}
		if(Calendar.WEDNESDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 4;
		}
		if(Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 5;
		}
		if(Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 6;
		}
		if(Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 7;
		}
		if(Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK)){
			return 1;
		}
		return 2;
	}

	public static  String getWeek(Integer qs) {
		String value = "";
		if(qs==1){
			value="Sunday";
		}else if(qs==2){
			value="Monday";
		}else if(qs==3){
			value="Tuesday";
		}else if(qs==4){
			value="Wednesday";
		}else if(qs==5){
			value="Thursday";
		}else if(qs==6){
			value="Friday";
		}else if(qs==7){
			value="Saturday";
		}
		return value;
	}
}

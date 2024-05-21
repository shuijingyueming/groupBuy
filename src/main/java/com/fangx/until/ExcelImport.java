package com.efx.quality.until;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelImport {
	private final static String excel2003L =".xls";    //2003- 版本的excel  
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
    private static boolean typed = true;//2003- 版本的excel true  2007+ 版本的excel  false
    private static String yzqname="";
    private static int yzqid=0;

 
    /** 
     * 描述：根据文件后缀，自适应上传文件的版本
     */  
    public  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{  
        Workbook wb = null;  
        String fileType = fileName.substring(fileName.lastIndexOf("."));  
        if(excel2003L.equals(fileType)){  
        	typed = true;
            wb = new HSSFWorkbook(inStr);  //2003-  
        }else if(excel2007U.equals(fileType)){  
        	typed = false;
            wb = new XSSFWorkbook(inStr);  //2007+  
        }else{  
            throw new Exception("解析的文件格式有误！");  
        }  
        return wb;  
    }  
    
    /** 
     * 描述：对表格中数值进行格式化 
     * @param cell 
     * @return 
     */  
  //解决excel类型问题，获得数值  
    public  String getValue(Cell cell) {  
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

}

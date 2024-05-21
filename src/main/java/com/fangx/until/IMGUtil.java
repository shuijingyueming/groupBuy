package com.efx.quality.until;

import cn.hutool.core.util.StrUtil;
import com.efx.quality.controller.OtherController;
import com.efx.quality.model.cdtha;
import com.efx.quality.model.cdusn;
import com.efx.quality.model.cdyhh;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import sun.font.FontDesignMetrics;

import javax.imageio.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class IMGUtil {
    protected final static SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final String fpath = OtherController.class.getClass().getResource("/").getPath();
    private static String url = "";//底图读取路径
    private static String saveurl = "";//生成图片保存路径

    private static String tzurl = "";//图章读取路径
    private static String fonturl = "";//字体读取路径
    private static final int nw = 2000;//略缩图宽度，高度自适应原500
    private static final int conWidth = 600;//文字图片宽度(结合白底图片尺寸固定)
    private static final int conHeight = 350;//文字图片高度
    private static Font s_font;//新宋体
    private static Font l_font;//隶体
    private static Font k_font;//楷体
    private static Font h_font;//黑体
    private static Font m_font;//毛笔体

    private static final int sc_width = 300;//缩小图片的最大宽度，高度自适应

    /**
     *  奖状图片生成调用方法
     *  tha:模版信息，奖状内容(cdtha)
     *  yhhList:获奖名单集合
     *  jImgName: 导出的奖状图名称（小程序段显示，已包含图章）
     *            奖状略缩图:名称-s.jpg  奖状大图:名称-b.jpg    打印使用图片：名称-p.png
     *
     *
     * @throws IOException
     */
    public static void createImage(cdtha tha, ArrayList<cdyhh> yhhList, String jImgName) throws IOException, FontFormatException {
        File s = new File("C:/image");
        if(!s.isDirectory()) s.mkdir();
        //图片保存路径
        url = fpath.substring(1)+"static/upload/jzimg/";
        tzurl = fpath.substring(1)+"static/upload/jztzimg/";
        saveurl = fpath.substring(1)+"static/upload/jzcreatimg/";
        fonturl = fpath.substring(1)+"static/static/css/";
        //字体初始化
        s_font = getFont(fonturl,"新宋体",12);
        m_font = getFont(fonturl,"李旭科毛笔行书",12);
        k_font = getFont(fonturl,"楷体",12);
        l_font = getFont(fonturl,"隶体",12);
        h_font = getFont(fonturl,"黑体",12);

        File f=new File(saveurl);
        if(!f.exists()){
            f.mkdirs();
        }

        // 读取底图图片信息 得到文件
        File srcImgFile = new File(url+tha.getTha003());
        //读取空白图片信息 得到文件
        File srcImgFile1 = new File(fpath.substring(1)+"static/upload/jzimg/zzback.jpg");
        //将文件对象转化为图片对象
        Image srcImg = ImageIO.read(srcImgFile);
        Image srcImg1 = ImageIO.read(srcImgFile1);
         //获取图片的宽
         int srcImgWidth = srcImg.getWidth(null);
         int srcImgWidth1 = srcImg1.getWidth(null);
         //获取图片的高
         int srcImgHeight = srcImg.getHeight(null);
         int srcImgHeight1 = srcImg1.getHeight(null);
         //----------图层canvas-----------
         BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
         BufferedImage bufImg1 = new BufferedImage(srcImgWidth1, srcImgHeight1, BufferedImage.TYPE_INT_RGB);
          //循环获奖名单
          cdyhh yhh = null;
          cdusn usn = null;
          Graphics2D g = null;//带底图的画笔
          Graphics2D g1 = null;//不带底图的画笔
          String zname = "";//获奖人员名称
          String edit = "";//将被替换
          int lk = 0;
          FileOutputStream outImgStream;
          FileOutputStream outImgStream1;
          String fontname = "";//字体名称
          int rowHeight = tha.getTha006();//字体整体高度
          int newRowHeight = tha.getTha006();//第二行开始计算后的字体整体高度
          String[] displauCon;//描述
          Dimension h_temp = new Dimension();//临时高度保存
          int height_temp = 0;
          float fontSize = 0;
          int x,y;
          int width = (tha.getTha007()+tha.getTha005())*4;
          int height;
          Image big;
          JPEGImageEncoder encoder,encoder1;
          JPEGEncodeParam param,param1;
        for(int i=0;i<yhhList.size();i++){
              yhh = yhhList.get(i);
              //----------------画有背景的图---------------
              //从图层canvas中创建画笔
              g = bufImg.createGraphics();
              g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
              g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
              g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_NORMALIZE);
              g1 = bufImg1.createGraphics();
              g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
              g1.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
              g1.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_NORMALIZE);
              //srcImg 为上面获取到的原始图片的图片对象
              g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
              g1.drawImage(srcImg1, 0, 0, srcImgWidth1, srcImgHeight1, null);
              //---------画称呼姓名
              //根据图片的背景设置水印颜色
              g.setColor(Color.decode(tha.getTha015()));
              g1.setColor(Color.decode(tha.getTha015()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha016())*4;
              if(tha.getTha014().equals("新宋体")){
                  g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
              }else if(tha.getTha014().equals("李旭科毛笔行书")){
                  g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
              }else if(tha.getTha014().equals("楷体")){
                  g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
              }else if(tha.getTha014().equals("隶体")){
                  g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
              }else{
                  g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
              }

              //画出水印 第一个参数是水印内容，第二个参数是x轴坐标，第三个参数是y轴坐标
              zname = "";
              for(int j=0;j<yhh.getUsnlist().size();j++){
                   usn = yhh.getUsnlist().get(j);
                   if(j==0) zname = usn.getUsn002();
                   else zname += " " + usn.getUsn002();
              }
              x = tha.getTha005()*4;
              y = rowHeight*4;
              g.drawString(zname,x,y);
              g1.drawString(zname,x,y);
              if(Integer.parseInt(tha.getTha016())>=Integer.parseInt(tha.getTha020())) newRowHeight = getWatermarkHeight(g)+10;
              //---------画称谓
              //计算前一个文字长度
              lk = getWatermarkLength(zname,g);
              //根据图片的背景设置水印颜色
              g.setColor(Color.decode(tha.getTha019()));
              g1.setColor(Color.decode(tha.getTha019()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha020())*4;
            if(tha.getTha018().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha018().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha018().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha018().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              x = tha.getTha005()*4+lk;
              g.drawString(tha.getTha017(),x,y);
              g1.drawString(tha.getTha017(),x,y);
              if(Integer.parseInt(tha.getTha020())>Integer.parseInt(tha.getTha016())) newRowHeight = getWatermarkHeight(g)+10;
              //-----------把新的Y轴付给常量--------
              y += newRowHeight;
              //---------画描述，首起缩进50
              x = (tha.getTha005()+50)*4;
              //如果奖项就是第一个，就不穿插
              if(tha.getTha021().indexOf("${1}")==0){
                  edit = tha.getTha021().replace("${1}","");
                  displauCon = new String[]{"",edit};
              }else{
                  edit = tha.getTha021().replace ("{1}","");
                  displauCon = edit.split("\\$");
                  g.setColor(Color.decode(tha.getTha023()));
                  g1.setColor(Color.decode(tha.getTha023()));
                  fontSize = Integer.parseInt(tha.getTha024())*4;
                  if(tha.getTha022().equals("新宋体")){
                      g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
                  }else if(tha.getTha022().equals("李旭科毛笔行书")){
                      g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
                  }else if(tha.getTha022().equals("楷体")){
                      g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
                  }else if(tha.getTha022().equals("隶体")){
                      g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
                  }else{
                      g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
                  }
                  g.drawString(displauCon[0],x,y);
                  g1.drawString(displauCon[0],x,y);
                  lk = getWatermarkLength(displauCon[0],g);
                  x += lk;
              }
              //画出奖项
              g.setColor(Color.decode(tha.getTha027()));
              g1.setColor(Color.decode(tha.getTha027()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha028())*4;
            if(tha.getTha026().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha026().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha026().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha026().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              g.drawString(yhh.getYhh016(),x,y);
              g1.drawString(yhh.getYhh016(),x,y);
              height_temp = getWatermarkHeight(g);
              x += getWatermarkLength(yhh.getYhh016(),g);
              //画出后面文字,超出长度需要换行
              g.setColor(Color.decode(tha.getTha023()));
              g1.setColor(Color.decode(tha.getTha023()));
              fontSize = Integer.parseInt(tha.getTha024())*4;
            if(tha.getTha022().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha022().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha022().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha022().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              y = y-height_temp/2;
              h_temp = drawWrapString(g,getFont(fonturl,tha.getTha022(),fontSize),displauCon[1], width,y,0,x,getWatermarkHeight(g)+10,2,tha.getTha005()*4);
              drawWrapString(g1,getFont(fonturl,tha.getTha022(),fontSize),displauCon[1],width,y,0,x, getWatermarkHeight(g1)+10,2,tha.getTha005()*4);
              //计算行高度,需要加上原减去的调整行高+奖项行高+40调整值
              y += h_temp.height+height_temp+(height_temp/2)+40;
            //  y += newRowHeight;
              //---------画奖次，居中
              g.setColor(Color.decode(tha.getTha031()));
              g1.setColor(Color.decode(tha.getTha031()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha032())*4;
            if(tha.getTha030().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha030().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha030().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha030().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              lk = (tha.getTha007()*4-getWatermarkLength(yhh.getYhh012(),g))/2+tha.getTha005()*4;
              g.drawString(yhh.getYhh012(),lk,y);
              g1.drawString(yhh.getYhh012(),lk,y);
              //---------画尾注,y轴=设定y+上边距,x轴=设定x+左边距
              lk = (tha.getTha005()+tha.getTha045())*4;
              rowHeight = (tha.getTha006()+tha.getTha046())*4;
              g.setColor(Color.decode(tha.getTha035()));
              g1.setColor(Color.decode(tha.getTha035()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha036())*4;
            if(tha.getTha034().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha034().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha034().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha034().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              g.drawString(tha.getTha033(),lk,rowHeight);
              g1.drawString(tha.getTha033(),lk,rowHeight);
              //---------画发奖机构,y轴=设定y+上边距,x轴=设定x+左边距
              lk = (tha.getTha005()+tha.getTha047())*4;
              rowHeight = (tha.getTha006()+tha.getTha048())*4;
              g.setColor(Color.decode(tha.getTha039()));
              g1.setColor(Color.decode(tha.getTha039()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha040())*4;
            if(tha.getTha038().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha038().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha038().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha038().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              g.drawString(tha.getTha037(),lk,rowHeight);
              g1.drawString(tha.getTha037(),lk,rowHeight);
              //---------画发奖日期,y轴=设定y+上边距,x轴=设定x+左边距
              lk = (tha.getTha005()+tha.getTha049())*4;
              rowHeight = (tha.getTha006()+tha.getTha050())*4;
              g.setColor(Color.decode(tha.getTha043()));
              g1.setColor(Color.decode(tha.getTha043()));
              //设置字体  画笔字体样式为微软雅黑，加粗，文字大小为60pt
              fontSize = Integer.parseInt(tha.getTha044())*4;
            if(tha.getTha042().equals("新宋体")){
                g.setFont(s_font.deriveFont(fontSize));g1.setFont(s_font.deriveFont(fontSize));
            }else if(tha.getTha042().equals("李旭科毛笔行书")){
                g.setFont(m_font.deriveFont(fontSize));g1.setFont(m_font.deriveFont(fontSize));
            }else if(tha.getTha042().equals("楷体")){
                g.setFont(k_font.deriveFont(fontSize));g1.setFont(k_font.deriveFont(fontSize));
            }else if(tha.getTha042().equals("隶体")){
                g.setFont(l_font.deriveFont(fontSize));g1.setFont(l_font.deriveFont(fontSize));
            }else{
                g.setFont(h_font.deriveFont(fontSize));g1.setFont(h_font.deriveFont(fontSize));
            }
              g.drawString(tha.getTha041(),lk,rowHeight);
              g1.drawString(tha.getTha041(),lk,rowHeight);
              //---------画电子图章,y轴=设定y+上边距,x轴=设定x+左边距
              //获取图章水印图片
              big = ImageIO.read(new FileInputStream(tzurl+tha.getTha012()));
              //画出水印 第一个参数是水印内容，第二个参数是x轴坐标，第三个参数是y轴坐标
              g.drawImage(big,480*4, 350*4,160*4, 160*4*(big.getHeight(null)*4)/(big.getWidth(null)*4),null,null);
              //保存出图
              g.dispose();
              g1.dispose();
              //outImgStream = new FileOutputStream("C:\\image\\"+jImgName+"-p.jpg");
              outImgStream = new FileOutputStream(saveurl+jImgName+"-b.jpg");
              encoder = JPEGCodec.createJPEGEncoder(outImgStream);
              param = encoder.getDefaultJPEGEncodeParam(bufImg);
              //设置1 原图保存
              param.setQuality(1, false);
              param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
              encoder.setJPEGEncodeParam(param);
              param.setXDensity(288);
              param.setYDensity(288);
              encoder.encode(bufImg, param);
              outImgStream.close();
             // outImgStream1 = new FileOutputStream("C:\\image\\"+jImgName+"-w.jpg");
              outImgStream1 = new FileOutputStream(saveurl+jImgName+"-p.jpg");
              encoder1 = JPEGCodec.createJPEGEncoder(outImgStream1);
              param1 = encoder1.getDefaultJPEGEncodeParam(bufImg1);
              //设置1 原图保存
              param1.setQuality(1, false);
              param1.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
              encoder1.setJPEGEncodeParam(param1);
              param1.setXDensity(288);
              param1.setYDensity(288);
              encoder1.encode(bufImg1, param1);
              outImgStream1.close();
              creatSmallImage(saveurl+jImgName+"-b.jpg",jImgName,saveurl);
          }
    }


    /**
     * 生成略缩图
     * fileName:要生成的图片
     * sFileName：生成的图片名称
     * saveUrl:服务器保存生成的图片地址
     * @return
     */
     private static void creatSmallImage(String fileName,String sFileName,String saveUrl){
         try {
             //读取已生成的奖状大图图片
             File fi = new File(fileName);
             //--------加入图章---------
             //开始缩图
             File fo = new File(saveUrl+sFileName);
             AffineTransform transform = new AffineTransform();
             BufferedImage bis = ImageIO.read(fi); //读取图片
             int w = bis.getWidth();
             int h = bis.getHeight();
             int nh = (nw * h) / w;
             double sx = (double) nw / w;
             double sy = (double) nh / h;
             transform.setToScale(sx, sy);
             AffineTransformOp ato = new AffineTransformOp(transform, null);
             BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
             ato.filter(bis, bid);
             ImageIO.write(bid, "jpeg", fo);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


    /**
     * 获取水印文字的长度
     * @param waterMarkContent
     * @param g
     * @return
     */
    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
    /**
     * 获取水印文字的长度
     * @param g
     * @return
     */
    public static int getWatermarkHeight(Graphics2D g) {
        FontDesignMetrics metrics = (FontDesignMetrics) g.getFontMetrics(g.getFont());
        return metrics.getHeight();
    }

    /**
     * 将字符串按照自定义的间隔写入
     * @param str   目标字符串
     * @param x     写入的位置的x轴
     * @param y     写入的位置的y轴
     * @param rate  写入间隔
     * @param g     画布
     * @param fontSize  字体的大小
     */
    public static void drawString(String str,int x,int y,int rate, Graphics2D g,int fontSize){
        String tempStr="";
        int tempx=x;
        int tempy=y;
        while (str.length()>0){
            tempStr=str.substring(0, 1);
            str=str.substring(1);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawString(tempStr, tempx, tempy);
            tempx = tempx + fontSize - rate;
        }
    }

    /**
     *  引入自定义的字体
     * @param fontName 字体样式的路劲+名称
     * @param fontSize  字体大小
     * @return
     */
    public static Font getFont(String fonturl,String fontName, float fontSize) throws IOException, FontFormatException {
        if(fontName.equals("新宋体")) fontName = fontName+".ttc";
        else fontName = fontName+".ttf";
        fontName = fonturl+fontName;
        FileInputStream fileInputStream = new FileInputStream(new File(fontName));
        Font tempFont = Font.createFont(Font.TRUETYPE_FONT,fileInputStream);
        Font font  = tempFont.deriveFont(fontSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fileInputStream.close();
        return font;
    }

    /**
     * 添加文字
     * <pre>
     *     在某个固定宽度的画板上添加文字，文字超过宽度限制自动换行
     *     其余内容如果超过最大行数，...显示
     * </pre>
     * @param g       画板
     * @param font    文字字体
     * @param text    文字
     * @param width   宽度限制
     * @param marginTop  距离顶部高度
     * @param indentWidth  首行缩进距离
     * @param rowLeft 第二行开始缩进量
     * @param lineHeight 行高
     * @param maxRow  最大行数
     * @return 返回文字所占用的高度，用于后续操作画板
     */
    private static Dimension drawWrapString(Graphics g, Font font, String text, int width, int marginTop,
                                            int marginLeft, int indentWidth, int lineHeight, int maxRow,int rowLeft) {
        String prompt = StrUtil.maxLength(text, 1000);
        FontMetrics metrics = g.getFontMetrics(font);
        int length = metrics.stringWidth(prompt);
        int height = metrics.getAscent() - metrics.getLeading() - metrics.getDescent();
        int row = 1;
        int top = (lineHeight - height) / 2;
        int paddingTop = marginTop;
        int firstRowWidth = width - indentWidth;
        if (length > firstRowWidth) {
            int rowLen = 0;
            int lastIndex = 0;
            for (int i = 0; i < prompt.length(); i++) {
                rowLen += metrics.charWidth(prompt.charAt(i));
                int fontMarginHeight = row == 1 ? height + top : lineHeight + top;
                int rowWidth = row == 1 ? firstRowWidth : width;
                int leftWidth = row == 1 ?  indentWidth + marginLeft : rowLeft+marginLeft;
                if (rowLen >= rowWidth - 15) {
                    if (row == maxRow) {
                        String lastRowTxt = i == prompt.length() - 1 ?
                                prompt.substring(lastIndex, i + 1) : prompt.substring(lastIndex, i) + "...";
                        g.drawString(lastRowTxt, leftWidth, paddingTop += fontMarginHeight);
                        break;
                    }
                    rowLen = 0;
                    g.drawString(prompt.substring(lastIndex, i + 1), leftWidth, paddingTop += fontMarginHeight);
                    row++;
                    lastIndex = i + 1;
                }
                if (i == prompt.length() - 1) {
                    g.drawString(prompt.substring(lastIndex), leftWidth, paddingTop += fontMarginHeight);
                }
            }
        } else {
            int leftWidth = row == 1 ?  indentWidth + marginLeft : marginLeft;
            g.drawString(prompt, leftWidth, paddingTop += top + height);
        }
        int actualWidth = maxRow == 1 ? firstRowWidth : width;
        return new Dimension(length > actualWidth ? actualWidth : length,paddingTop + top - marginTop);
    }



    public static void main(String[] arg){

       try {
           cdtha tha = new cdtha();
           //底图名称
           tha.setTha003("AA-100-212-595-270.jpg");tha.setTha005(120);tha.setTha006(232);tha.setTha007(595);tha.setTha008(270);
           //图章名称
           tha.setTha012("20230629142142.png");
           //称呼
           tha.setTha013("");tha.setTha014("隶体");tha.setTha015("#000000");tha.setTha016("24");
           //称谓
           tha.setTha017("小朋友");tha.setTha018("隶体");tha.setTha019("#000000");tha.setTha020("18");
           //描述
           tha.setTha021("在${1}的学习中，表现优秀，热心助人，热心助人，被评为");tha.setTha022("隶体");tha.setTha023("#000000");tha.setTha024("18");
           //奖项名称
           tha.setTha025("");tha.setTha026("李旭科毛笔行书");tha.setTha027("#000000");tha.setTha028("24");
           //奖次名称
           tha.setTha029("");tha.setTha030("李旭科毛笔行书");tha.setTha031("#000000");tha.setTha032("60");
           //尾注
           tha.setTha033("特发此证，以致鼓励");tha.setTha034("隶体");tha.setTha035("#000000");tha.setTha036("24");tha.setTha045(40);tha.setTha046(170);
           //发奖机构
           tha.setTha037("宁波易飞迅信息科技有限公司");tha.setTha038("隶体");tha.setTha039("#000000");tha.setTha040("18");tha.setTha047(340);tha.setTha048(190);
           //发奖日期
           tha.setTha041("2023年7月12日");tha.setTha042("隶体");tha.setTha043("#000000");tha.setTha044("18");tha.setTha049(400);tha.setTha050(210);


           //生成文件日期名称
           String fname = "230630103830";

           ArrayList<cdyhh> thhlist = new ArrayList<cdyhh>();
           cdyhh yhh = new cdyhh();
           yhh.setYhh012("学习标兵");
           yhh.setYhh016("19届拉丁舞全国赛");
           yhh.setYhh012("优胜奖");
           cdusn usn = new cdusn();
           usn.setUsn002("王五");
           ArrayList<cdusn> usnlist = new ArrayList<cdusn>();
           usnlist.add(usn);
           yhh.setUsnlist(usnlist);
           thhlist.add(yhh);


           createImage(tha,thhlist,fname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
           throw new RuntimeException(e);
       }

    }

    /**
     * 图片缩小
     * fileName:要缩小的图片(包括路径)
     * sFileName：缩小的图片名称(包括路径)
     * @return
     */
    private static void atSmallImage(String fileName,String sFileName){
        try {
            //读取原始大图图片
            File fi = new File(fileName);
            //开始缩图
            File fo = new File(sFileName+".jpeg");
            AffineTransform transform = new AffineTransform();
            BufferedImage bis = ImageIO.read(fi); //读取图片
            int w = bis.getWidth();
            int h = bis.getHeight();
            int nh = (sc_width * h) / w;
            double sx = (double) sc_width / w;
            double sy = (double) nh / h;
            transform.setToScale(sx, sy);
            AffineTransformOp ato = new AffineTransformOp(transform, null);
            BufferedImage bid = new BufferedImage(sc_width, nh, BufferedImage.TYPE_3BYTE_BGR);
            ato.filter(bis, bid);
            ImageIO.write(bid, "jpeg", fo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

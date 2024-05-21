package com.efx.quality.until;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import com.efx.quality.controller.BaseController;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;


public class OSSUtil extends BaseController {


	private static String webendpoint="https://oss-cn-beijing.aliyuncs.com";//OSS外网访问
	private static String aliendpoint="https://oss-cn-beijing-internal.aliyuncs.com";//OSS内网访问
	private static String FORMATS = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	private static String BucketName = "nbefx";
	
	
	/**
	 * 孙伟丰
	 * 获取OSS文件夹路径
	 * 参数：type    "A":活动    "B"：banner    "C"：公告
       "D"：店铺
	 * @param type
	 */
	public static String getFilePath(String type){
		String path = "https://nbefx.oss-cn-beijing.aliyuncs.com/";
		if(type.equals("A")) path = path + "quality/rongjia/act/";
		else if(type.equals("B")) path = path + "quality/rongjia/ban/";
		else if(type.equals("C")) path = path + "quality/rongjia/gg/";
		else if(type.equals("D")) path = path + "quality/rongjia/shop/";
		return path;	
	}
	
	
	
	/*
	*初始化OSS服务器链接
	*type:"M" 外网链接   "N"内网链接
	**/
	public static OSS getsourceSet(String type){
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = "LTAISL8bC3OCBvcP";
		String accessKeySecret = "uPSW45Wg5N6NAl6pETvRqMRzYQMasp";
		
		// 创建ClientConfiguration实例，按照您的需要修改默认参数。
		ClientConfiguration conf = new ClientConfiguration();
		// 开启支持CNAME。CNAME是指将自定义域名绑定到存储空间上。
		conf.setSupportCname(true);
		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(type.equals("M")?webendpoint:aliendpoint, accessKeyId, accessKeySecret);
        return ossClient;
	}
	
	/**
     * 获取阿里云OSS客户端对象
     * @return ossClient
     */
    public static OSSClient getOSSClient(String type) {
        return new OSSClient(type.equals("M")?webendpoint:aliendpoint, "LTAISL8bC3OCBvcP", "uPSW45Wg5N6NAl6pETvRqMRzYQMasp");
    }

	
	//创建文件夹
	public static String creatBower(String bname){
		OSS oss = OSSUtil.getsourceSet("N");
		if(oss.doesBucketExist(bname)) return "文件名称已存在";
		else{
			oss.createBucket(bname);
			oss.shutdown();
			return "Y";
		}
	}
	
	//删除文件夹
	public static void deleteBower(String bname){
		OSS oss = OSSUtil.getsourceSet("N");
		if(oss.doesBucketExist(bname)){
			oss.deleteBucket(bname);
			oss.shutdown();
		}
	}
	
	
	/**
	 * 孙伟丰
	 * 删除文件
	 * pathName:文件夹类型,filename：文件名称
	 * 返回数组：[0]:返回值,[1]:文件名称
	 * @param pathName
	 */
	public static void deleteFile(String pathName,String filename){
		// 创建OSSClient实例。
		OSS ossClient = OSSUtil.getsourceSet("N");
		 String path="";
		 if(pathName.equals("A")) path = path + "quality/rongjia/act/";
         else if(pathName.equals("B")) path = path + "quality/rongjia/ban/";
         else if(pathName.equals("C")) path = path + "quality/rongjia/gg/";
         else if(pathName.equals("D")) path = path + "quality/rongjia/shop/";
		// 删除文件。
		ossClient.deleteObject(BucketName, path+filename);
		// 关闭OSSClient。
		ossClient.shutdown();
	}
	
	
	/**
	 * 孙伟丰
	 * 上传文件到OSS服务器
	 * pathName:文件夹名称/文件名称,file:request提交文件
	 * 返回数组：[0]:返回值,[1]:文件名称
	 * @param pathName
	 */
	 //上传文件至OSS
    public static String[] uploadObjectOSS(MultipartFile file,String pathName) {
    	int randomNum = (int) (Math.random() * 9000 + 1000);
    	String name = sdf.format(new Date())+String.valueOf(randomNum);
    	OSS ossClient = OSSUtil.getsourceSet("N");
        String resultStr = null;
        String path="";
        String[] fo = new String[] { "", "" };
        if(pathName.equals("A")) path = path + "quality/rongjia/act/";
        else if(pathName.equals("B")) path = path + "quality/rongjia/ban/";
        else if(pathName.equals("C")) path = path + "quality/rongjia/gg/";
        else if(pathName.equals("D")) path = path + "quality/rongjia/shop/";
		else path = pathName;
        try {
            // 以输入流的形式上传文件
            InputStream is = file.getInputStream();
            // 文件名
            String timefile = name;
            String fileName = file.getOriginalFilename();
            /*if(!pathName.equals("C")) */fileName = timefile + fileName.substring(fileName.lastIndexOf("."));
            // 文件大小
            Long fileSize = file.getSize();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(BucketName, path + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = fileName;
            fo[0] = resultStr;
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fo;
    }
    
  //切片上传文件至OSS
    public static String[] qpuploadObjectOSS(MultipartFile file,String pathName) throws Exception {
    	int randomNum = (int) (Math.random() * 9000 + 1000);
    	String name = sdf.format(new Date())+String.valueOf(randomNum);
    	OSS ossClient = OSSUtil.getOSSClient("N");
        String resultStr = null;
        String path="";
        String[] fo = new String[] { "", "" };
        if(pathName.equals("A")) path = path + "quality/rongjia/act/";
        else if(pathName.equals("B")) path = path + "quality/rongjia/ban/";
        else if(pathName.equals("C")) path = path + "quality/rongjia/gg/";
        else if(pathName.equals("D")) path = path + "quality/rongjia/shop/";
		else path = pathName;
     // 文件名
        String timefile = name;
        String fileName = file.getOriginalFilename();
        /*if(!pathName.equals("C"))*/ fileName = timefile + fileName.substring(fileName.lastIndexOf("."));
    	// 创建InitiateMultipartUploadRequest对象。
    	InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(BucketName, path + fileName);
    	
    	// 如果需要在初始化分片时设置文件存储类型，请参考以下示例代码。
    	 ObjectMetadata metadata = new ObjectMetadata();
    	 metadata.setHeader("Pragma", "no-cache");
    	 request.setObjectMetadata(metadata);
    	
    	// 初始化分片。
    	InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
    	// 返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
    	String uploadId = upresult.getUploadId();
    	// partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
    	List<PartETag> partETags =  new ArrayList<PartETag>();
    	// 计算文件有多少个分片。
    	final long partSize = 1 * 1024 * 1024L;   // 1MB
//    	final File sampleFile = MultipartFileToFile(file);
//    	System.out.println(sampleFile.toPath());
//    	long fileLength = sampleFile.length();
    	long fileLength = file.getSize();
    	int partCount = (int) (fileLength / partSize);
    	if (fileLength % partSize != 0) {
    	    partCount++;
    	 }
    	// 遍历分片上传。
    	for (int i = 0; i < partCount; i++) {
    	    long startPos = i * partSize;
    	    long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
//    	    InputStream instream = new FileInputStream(sampleFile);
    	    InputStream instream = file.getInputStream();
    	    // 跳过已经上传的分片。
    	    instream.skip(startPos);
    	    UploadPartRequest uploadPartRequest = new UploadPartRequest();
    	    uploadPartRequest.setBucketName(BucketName);
    	    uploadPartRequest.setKey(path + fileName);
    	    uploadPartRequest.setUploadId(uploadId);
    	    uploadPartRequest.setInputStream(instream);
    	    // 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100KB。
    	    uploadPartRequest.setPartSize(curPartSize);
    	    // 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
    	    uploadPartRequest.setPartNumber( i + 1);
    	    // 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
    	    UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
    	    // 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
    	    partETags.add(uploadPartResult.getPartETag());
    	}


    	// 创建CompleteMultipartUploadRequest对象。
    	// 在执行完成分片上传操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
    	CompleteMultipartUploadRequest completeMultipartUploadRequest =
    	        new CompleteMultipartUploadRequest(BucketName, path + fileName, uploadId, partETags);

    	// 如果需要在完成文件上传的同时设置文件访问权限，请参考以下示例代码。
    	// completeMultipartUploadRequest.setObjectACL(CannedAccessControlList.PublicRead);

    	// 完成上传。
    	CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
    	resultStr = completeMultipartUploadResult.getETag();
        fo[1] = fileName;
        fo[0] = resultStr;
    	
    	ossClient.shutdown();
    	return fo;
    }
    
  //将MultipartFile file转换成为File
    public static File MultipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码
 
        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String[] uploadObjectOSS1(FileItem file, String pathName, String type) {
    	int randomNum = (int) (Math.random() * 9000 + 1000);
    	String name = sdf.format(new Date())+String.valueOf(randomNum);
    	OSS ossClient = OSSUtil.getsourceSet("N");
        String resultStr = null;
        String path=pathName;
        String[] fo = new String[] { "", "" };
        String accessKeyId = "LTAISL8bC3OCBvcP";
		String accessKeySecret = "uPSW45Wg5N6NAl6pETvRqMRzYQMasp";
        OSSUtil.createFolder(new OSSClient(type.equals("M")?webendpoint:aliendpoint, accessKeyId, accessKeySecret), BucketName, path);
        try {
            // 以输入流的形式上传文件
            InputStream is = file.getInputStream();
            // 文件名
            String fileName = file.getName();
            fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+fileName.substring(fileName.lastIndexOf("."));
            // 文件大小
            Long fileSize = file.getSize();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(BucketName, path + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = fileName;
            fo[0] = resultStr;
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fo;
    }
    
    //上传文件至OSS
    public static String[] uploadObjectOSSs(MultipartFile file, String filedz,String type) {
    	OSS ossClient = OSSUtil.getsourceSet("N");
        String resultStr = null;
        String[] fo = new String[] { "", "" };
        String accessKeyId = "LTAISL8bC3OCBvcP";
		String accessKeySecret = "uPSW45Wg5N6NAl6pETvRqMRzYQMasp";
        OSSUtil.createFolder(new OSSClient(type.equals("M")?webendpoint:aliendpoint, accessKeyId, accessKeySecret), BucketName, filedz);
        try {
        	FORMATS = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            // 以输入流的形式上传文件
            String folder = "";
            folder = filedz;
            InputStream is = file.getInputStream();
            // 文件名
            String timefile = FORMATS;
            String fileName = file.getOriginalFilename();
            fileName = timefile + fileName.substring(fileName.lastIndexOf("."));
            // 文件大小
            Long fileSize = file.getSize();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(BucketName, folder + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = folder + fileName;
            fo[0] = resultStr;

            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fo;
    }
  
    //通过文件名判断并获取OSS服务文件上传时文件的contentType
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || ".pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || ".docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xla".equalsIgnoreCase(fileExtension) ||
        		".xlc".equalsIgnoreCase(fileExtension)||
        		".xlm".equalsIgnoreCase(fileExtension)||
        		".xls".equalsIgnoreCase(fileExtension)||
        		".xlt".equalsIgnoreCase(fileExtension)||
        		".xlw".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-excel";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        if (".pdf".equalsIgnoreCase(fileExtension)) {
            return "application/pdf";
        }
        if (".zip".equalsIgnoreCase(fileExtension)) {
            return "application/zip";
        }
        if (".tar".equalsIgnoreCase(fileExtension)) {
            return "application/x-tar";
        }
        if (".avi".equalsIgnoreCase(fileExtension)) {
            return "video/avi";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mpeg4";
        }
        if (".mp3".equalsIgnoreCase(fileExtension)) {
            return "audio/mp3";
        }
        if (".mp2".equalsIgnoreCase(fileExtension)) {
            return "audio/mp2";
        }
        // 默认返回类型
        return "image/jpeg";
    }
    
    /**
     * 创建模拟文件夹
     * @param ossClient oss连接
     * @param bucketName 存储空间
     * @param folder 模拟文件夹名如"qj_nanjing/"
     * @return 文件夹名
     */
    public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
            // 创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            // 得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            ossClient.shutdown();
            return fileDir;
        }
        ossClient.shutdown();
        return keySuffixWithSlash;
    }

    
    
	public static void main(String[] args) {
		 //初始化OSS
		  OSS ossClient = OSSUtil.getsourceSet("N");
		// 设置最大个数。
		 int maxKeys = 200;
		 String bucketName= "nbefx";
	/*	 // 列举文件。
		// 构造ListObjectsRequest请求。
		 ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
		 // 设置prefix参数来获取fun目录下的所有文件。
		 listObjectsRequest.setPrefix("khfile/2/P");
		 listObjectsRequest.setMaxKeys(maxKeys);
		 // 递归列出fun目录下的所有文件。
		 ObjectListing listing = ossClient.listObjects(listObjectsRequest);
		 // 遍历所有文件。
		 for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
		     System.out.println(objectSummary.getKey());
		 }
       */
		
		// 上传文件流。
		// InputStream inputStream = new FileInputStream("<yourlocalFile>");
		// ossClient.putObject("<yourBucketName>", "<yourObjectName>", inputStream);
		 // 关闭OSSClient。
		 ossClient.shutdown();	
	}
	
	

}

package kr.or.ddit.FileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	//form-data; name="img"; filename="sally.png"
	   // ==> sally.png
	   
	   //FileUploadUtilTest
	   public static String getFilename(String contentDisposition) {
	      String filename = "";
	      String[] values = contentDisposition.split("; ");
	      
	      
	      for (String index : values) {
	         String[] value = index.split("=");
	         if (value[0].equals("filename")){
//	            filename = value[1];
	            return value[1].replaceAll("\"", "");
	         }
	      }
	      return filename;
	   }
	   
	  public static String getExtenstion(String filename) {
//		  String[] ext = filename.split("\\.");
//		  String fileExt = ext[0];
//		  logger.debug("확장자:{}",fileExt);
//		  return fileExt;
		  
		  if(filename == null || filename.indexOf(".") == -1) {
			  logger.debug("없음");
			  return "";
		  }else {
			  logger.debug("확장자:{}",filename.split("\\.")[1]);
			  return filename.split("\\.")[1];
		  }
	  }
	}
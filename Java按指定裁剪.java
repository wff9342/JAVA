package vm.util;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Cutbeifen {
	
	public static void main(String[] args) throws IOException {
		String source = "E:\\minbus_SOURCE(1)";//文件来源
		File sourceFile = new File(source);
		File[] files = sourceFile.listFiles();//将路径名返回		
		int i=0;		
		for(File f: files){			
			if(f.getName().endsWith(".txt")){//判断文件路径是否以指定.TXT结尾
				i++;
				System.out.println(i);				
				String data=temp(f);
				JSONObject json = JSONObject.fromObject(data);
				String name = json.getString("name");
				String pathone=source+File.separator+f.getName().split(".t")[0];
				String pathtwo="E:"+File.separator+name+File.separator+f.getName().split(".j")[0]+"_"+name+".jpg";				
				JSONArray family = json.getJSONArray("data");
				File file = new File(pathone);
				if(file.exists()) {
					System.out.println(pathone+"   "+family.getInt(0)+"   "+family.getInt(1)+"   "+family.getInt(2)+"   "+family.getInt(3)+"   "+pathtwo);
					cut(pathone,family.getInt(0),family.getInt(1), family.getInt(2), family.getInt(3),pathtwo);
				}else {
					System.out.println(pathone+"文件不存在");
				}
				
			}
		}
		
	}


	
	
	public static String temp(File file) {
		String name ="";
		StringBuilder sb = new StringBuilder();	
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;								
			int j = 0;			
			while((s = br.readLine()) != null) {				
				String post="";				
				name = s.split(":")[0];				
				String position = s.split(":")[1];
				String tmp1=position.split("_")[0];
				String xmin = tmp1.split("t")[1];
				String tmp2 = position.split("_")[1];
				String xmax = tmp2.split("t")[1];
				String tmp3=position.split("_")[2];
				String ymin = tmp3.split("p")[1];
				String tmp4=position.split("_")[3];
				String ymax = tmp4.split("t")[1];
				int w=Integer.parseInt(xmax)-Integer.parseInt(xmin);
				int h=Integer.parseInt(ymax)-Integer.parseInt(ymin);
				String str = "{\"name\":\""+name+"\","  +"\"data\":["+xmin+","+ymin+","+w+","+h+"]}";		
				if(j==0){
					sb.append(str);				
				}	
				j++;
			}		
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}	 
		  /**  
		    * 对图片裁剪，并把裁剪完蛋新图片保存 。 
		  */  
		public static void cut(String srcpath,int x, int y, int width, int height,String subpath)throws IOException {   
		         
		      FileInputStream is =  null ;  
		      ImageInputStream iis = null ;  
		       
		      try {  
		    	is =new FileInputStream(srcpath);  
		        Iterator < ImageReader > it=ImageIO.getImageReadersByFormatName("jpg");   
		        ImageReader reader = it.next();   

		        iis = ImageIO.createImageInputStream(is);  
		            
		      
		        reader.setInput(iis, true ) ;  
		           
		       
		        ImageReadParam param = reader.getDefaultReadParam();   
		           
		      
		        Rectangle rect =  new Rectangle(x, y, width, height);   
		           
		            
		        // 提供一个 BufferedImage，将其用作解码像素数据的目标。   
		        param.setSourceRegion(rect);   
		  
		        
		        BufferedImage bi=reader.read(0,param);          
		        
		        // 保存新图片   
		        ImageIO.write(bi,"jpg",new File(subpath));     
		      } finally {  
		        if (is != null )  
		         is.close() ;      
		        if (iis != null )  
		         iis.close();   
		      }   
		         
		         
		       
		    }  
	
	
	
}

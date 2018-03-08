package vm.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class Demo_3 {
	// 这个是用来做垃圾检测算法的数据类型调整
	//三版json数据
	public static void main(String[] args) throws IOException {
		String source = "C:\\Users\\Administrator\\Desktop\\test_pic";//文件来源
		File sourceFile = new File(source);
		String target = "E:\\testfore";//目标文件
		File targetFile = new File(target);
		if(!targetFile.exists()){//判断是否有路径，没有创建
			targetFile.mkdir();
		}		
		File[] files = sourceFile.listFiles();//将路径名返回
		File[] flist = new File[files.length];//.txt文件列表		
		int j=0;
		for(File f: files){			
			if(f.getName().endsWith(".txt")){//判断文件路径是否以指定.TXT结尾
				j++;								
				flist[j-1]=f;								
				}
			}
		int i=0;		
		for(File f: files){			
			if(f.getName().endsWith(".txt")){//判断文件路径是否以指定.TXT结尾
				i++;
				System.out.println(i);
				if(flist[i]==null) {
					getTxt(flist[0],flist[i-1],i,target);
				}else {
					getTxt(flist[i],flist[i-1],i,target);
				}
				//打开一个outputstream，将conteng写入里面，并且将对应的图片也复制过去
				File target_dir = new File(target+File.separator+i);
				if(!target_dir.exists()){
					target_dir.mkdir();
				}
				File target_json= new File(target_dir+File.separator+f.getName().split(".j")[0]+".jpg.json");				
				//把对应的图片也移动到相应文件夹下面
				try {
					
					FileUtils.copyFile(new File(source+File.separator+f.getName().split(".j")[0]+".jpg"), 
							new File(target_dir+File.separator+f.getName().split(".j")[0]+".jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}
			}
		}
		
	}

	public static void getTxt(File file,File filetwo,int x,String url) throws IOException {		
		String taskname=file.getName().split(".j")[0];
		String tasknametwo=filetwo.getName().split(".j")[0];			
		int i=x;
		String head = "{" +"\"id\":\"" + UUID.randomUUID().toString() + "\"," + 
				" \"path\":\"videomark/store/source/"+filetwo.getName().split(".t")[0]+"\"," +
				"\"name\":\""+filetwo.getName().split(".t")[0]+"\"," +"\"type\":\"image\"," +"\"taskId\":\"1\"," +
				"\"property\":{}," + "\"frames\":[{\"timestamp\":\"-1\"," +"\"marks\":[" ;														
		String tail = "]}]}";			
		String target = url;
		File target_dir = new File(target+File.separator+i);
		StringBuilder sb = new StringBuilder();			
		if(!target_dir.exists()){
			target_dir.mkdir();
		}
		File target_json= new File(target_dir+File.separator+filetwo.getName().split(".j")[0]+".jpg.json");
		if(taskname.equals(tasknametwo)) {			
			if(target_json.exists()==false) {
		    	 target_json.createNewFile();
		    	 sb.append(head);
				 sb.append(temp(filetwo));
				 sb.append(",");			
				 sb.append(temp(file));
				 sb.append(tail);
				 try {
						FileOutputStream fos = new FileOutputStream(target_json);
				         OutputStreamWriter osw = new OutputStreamWriter(fos);
				         BufferedWriter bw = new BufferedWriter(osw);
				         bw.write(sb.toString());
				         bw.flush();
				         bw.close();
				         osw.close();
				         fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		     }else {
		    	 sb.append(",");
		    	 sb.append(temp(file));
				 sb.append(tail);		    	
		    	 BufferedWriter out = null;
		    	 try {
			    	 out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target_json, true)));
			    	 out.write(sb.toString());
		    	 } catch (Exception e) {
		    		 e.printStackTrace();
		    	 } finally {
		    		 try {
		    			 out.close();
		    		 } catch (IOException e) {
		    			 e.printStackTrace();
		    		 }
		    	 }
		     }
		}else {									
			sb.append(head);	
			sb.append(temp(filetwo));
			sb.append(tail);			
			if(!target_json.exists()) {
				target_json.createNewFile();
			}
			try {
				FileOutputStream fos = new FileOutputStream(target_json);
		         OutputStreamWriter osw = new OutputStreamWriter(fos);
		         BufferedWriter bw = new BufferedWriter(osw);
		         bw.write(sb.toString());
		         bw.flush();
		         bw.close();
		         osw.close();
		         fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				//全部用car来代替
				if(s.split("_")[0]=="lorry") {
					name = "people";
				}else {
					name = "car";
				}
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
				String str = getJson(name,xmin, ymin, Integer.toString(w), Integer.toString(h));				
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
	public static String getJson(String name,String xmin, String ymin, String width, String height) {		
		String json1 ="{\"truncate\":\"\"," +"\"angle\":\"\"," + 
				"\"type\":\""+name+"\"," +"\"shape\":\"rectangle\"," +"\"data\":["+xmin+","+ymin+","+width+","+height+"]}";
		return json1;
	}
	
}

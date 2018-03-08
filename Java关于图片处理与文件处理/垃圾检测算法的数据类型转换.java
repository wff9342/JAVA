import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class Demo_2 {
	// 这个是用来做垃圾检测算法的数据类型调整
	public static void main(String[] args) {
		String source = "I:\\g";
		File sourceFile = new File(source);
		String target = "I:\\garbage";
		File targetFile = new File(target);
		if(!targetFile.exists()){
			targetFile.mkdir();
		}
		File[] files = sourceFile.listFiles();
		int i=0;
		for(File f: files){
			
			if(f.getName().endsWith(".txt")){
				i++;
				System.out.println(i);
				String content = getTxt(f);
				//打开一个outputstream，将conteng写入里面，并且将对应的图片也复制过去
				File target_dir = new File(target+File.separator+i);
				if(!target_dir.exists()){
					target_dir.mkdir();
				}
				File target_json= new File(target_dir+File.separator+f.getName().substring(0,f.getName().length()-4)+".json");
				try {
					FileOutputStream fos = new FileOutputStream(target_json);
			         OutputStreamWriter osw = new OutputStreamWriter(fos);
			         BufferedWriter bw = new BufferedWriter(osw);
			         bw.write(content);
			         bw.flush();
			         bw.close();
			         osw.close();
			         fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//把对应的图片也移动到相应文件夹下面
				try {
					FileUtils.copyFile(new File(source+File.separator+f.getName().substring(0,f.getName().length()-4)+".jpg"), 
							new File(target_dir+File.separator+f.getName().substring(0,f.getName().length()-4)+".jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public static String getTxt(File file) {
		String head = "{\"taskid\":\"1\",\"videolist\":[],\"photolist\":[{\"photoID\":\"Photo_0_\",\"mark\":\"yes\",\"url\":\"\","
				+ "\"original_file_id\":\"" + UUID.randomUUID().toString() + "\",\"masker\":["
				+"{\"maskerID\":\"Photo_0_car_0_\"," + "\"name\":\"" + "car"
				+ "\",\"mark\":[";
		String tail = "]}]}]}";
		StringBuilder sb = new StringBuilder();
		sb.append(head);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			int j = 0;
			while ((s = br.readLine()) != null) {
				
				//全部用car来代替
				String name = "car";
				String position = s.split(":")[1];
				String xmin = position.split(",")[0];
				String mid = position.split(",")[1];
				String ymin = mid.split(";")[0];
				String xmax = Integer.parseInt(xmin)+Integer.parseInt(mid.split(";")[1])+"";
				String ymax = Integer.parseInt(ymin)+Integer.parseInt(mid.split(";")[2])+"";
				String str = getJson(null, xmin, ymin, xmax, ymax);
				if(j==0){
					sb.append(str);
				}else{
					sb.append(",");
					sb.append(str);
				}	
				j++;
			}
			sb.append(tail);
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

	public static String getJson( String pose, String xmin, String ymin, String xmax, String ymax) {

		String json1 = "{\"markID\":\"Photo_0_car_0_rec_0_\"," + "\"pose\":\"" + pose
				+ "\",\"truncated\":\"1\",\"difficult\":\"1\"," + "\"coords\":{\"xmin\":\"" + xmin + "\",\"ymin\":\""
				+ ymin + "\",\"xmax\":\"" + xmax + "\",\"ymax\":\"" + ymax + "\"}}";
		return json1;
	}
}

package vm.util;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import vm.db.common.DBConn;
import vm.db.dao.ResultFileDAO;
/*
1.两表联查，将json与path封装到hashmap中
2.将封装的hashmap转化为集合利用迭代器拿出来，将json写入文件，path copy到指定目录
3.调用方法，实现
*/
public class test {
	
	private DBConn dbConn =new DBConn(); 
	public  Map<String,String> getJsonAndPath(){
		Map<String,String> map = new HashMap<String,String>();
		String sql = "select json,path from cachetask as c,originalfile as o where c.originalFileId = o.originalFileID;";
		PreparedStatement ps;
		try {
			ps = this.dbConn.getConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("json"), rs.getString("path"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	public static void main(String[] args) throws IOException {
		test dao = new test();
		Map<String,String> m = dao.getJsonAndPath();
		System.out.println(m.size());
		store(m);
	}
	public static void store(Map<String,String> map) throws IOException {
		int i=1;
		Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			File  file = new File("D://json//"+i);
			if(!file.exists()) {
				file.mkdirs();
			}
			Map.Entry<String,String> entry = iter.next(); 
			String s = entry.getKey();
			FileOutputStream fos = new FileOutputStream("D://json//"+i+"//"+i+".json");
			fos.write(s.getBytes());
			fos.close();
			FileUtils.copyFile(new File(entry.getValue()),new File("D://json//"+i+"//"+i+".jpg"));
			i++;
		}
		System.out.println(i);
	}
}


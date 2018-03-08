package vm.util;

import java.io.*;
import java.sql.*;
import java.util.*;
import vm.db.common.DBConn;
import org.apache.commons.io.FileUtils;



public class wfftest {
	private DBConn dbconn=new DBConn();

	public  Map<String,String> getpathandjson(){	
		Map<String,String> map=new HashMap<String,String>();
		String sql="select json,path from originalfile AS A,cachetask AS B where A.originalFileID=B.originalFileID;";
		PreparedStatement ps;
		try {
			ps = this.dbconn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("json"), rs.getString("path"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static void load(Map<String,String> map) {		
		Iterator<Map.Entry<String, String>> iter=map.entrySet().iterator();
		int i=1;
		while(iter.hasNext()) {
			Map.Entry<String,String> obj=iter.next();
			File file=new File("E:\\json\\"+i);
			if(!file.exists()) {
				file.mkdirs();
			}			
			try {
				FileOutputStream fop=new FileOutputStream("E:\\json\\"+i+"\\"+i+".json");
				fop.write(obj.getKey().getBytes());
				fop.close();
				FileUtils.copyFile(new File(obj.getValue()),new File("E:\\json\\"+i+"\\"+i+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		System.out.println(i);		
	}
	public static void main(String[] args) {
		wfftest test=new wfftest();
		Map<String,String> map=test.getpathandjson();
		System.out.println(map.size());
		load(map);
	}
	
	
	
	
}

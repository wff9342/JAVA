package vm.util;


import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONObject;
import vm.db.dao.CacheTaskDAO;
import vm.db.dao.OriginalFileDAO;
import vm.db.dao.ResultFileDAO;
import vm.db.dao.TaskDAO;
import vm.db.po.CacheTask;
import vm.db.po.OriginalFile;
import vm.db.po.ResultFile;
import vm.db.po.Task;

public class MainTest3 {
	//三版导入
	public static void main(String[] args) throws Exception {
		File resultRoot = new File("C:\\Users\\Public\\Nwt\\cache\\recv\\SE-PC2222\\test");
		File[] resultDirs = resultRoot.listFiles();
		String path = "C:\\Users\\Administrator\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\videomark\\store";
		for (File resultDir : resultDirs) {
			File resultFile = null;
			try {
				resultFile = resultDir.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						if (name.toLowerCase().endsWith("json")) {
							//将该文件拷贝至result目录下
							/*try {
								FileUtils.copyFile(new File(dir+File.separator+name), new File(path+File.separator +"result"+File.separator+name));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
							return true;
						}
						return false;
					}
				})[0];
			} catch (Exception e) {
				System.out.println("json");
				System.out.println(resultDir.getAbsolutePath());
			}
			
			File originalFile = null;
			try {
				originalFile = resultDir.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						if (name.toLowerCase().endsWith("jpg") || name.toLowerCase().endsWith("png")) {
							//将该文件拷贝至source下面
							/*try {
								FileUtils.copyFile(new File(dir+File.separator+name), new File(path+File.separator+"source"+File.separator+name));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
							return true;
						}
						return false;
					}
				})[0];
			} catch (Exception e) {
				System.out.println("jpg");
				System.out.println(resultDir.getAbsolutePath());	
			}			
			String taskId = "";
			String originalFileId = "";			
			long ctime = System.currentTimeMillis();
			long utime = ctime;
			
			
			String resultJsonContent = FileUtils.readFileToString(resultFile, "utf-8");
			JSONObject json = JSONObject.fromObject(resultJsonContent);
			taskId = json.getString("taskId");
			originalFileId = json.getString("id");
			
			// 1、已经打印出 插入originalfile表需要的关键信息，然后拼sql插入originalfile表
			System.out.println("taskId: " + taskId + "\toriginalFileId: " + originalFileId + "\tctime: " + ctime
					+ "\tutime: " + utime + "\tpath: " + (path + File.separator + originalFile.getName()));
			OriginalFile of = new OriginalFile();
			of.setTaskID(taskId);
			of.setOriginalFileID(originalFileId);
			of.setName(originalFile.getName());
			of.setCtime(ctime);
			of.setFlag(1);
			of.setPath(path + File.separator + "source" +File.separator+ originalFile.getName());
			of.setParent(false);
			of.setUtime(utime);
			of.setPid("0");
			
			OriginalFileDAO od = new OriginalFileDAO();
			od.insert(of);
			// 2、把图片拷贝到path目录下
			
			
			// 3、插入resultfile表
			ResultFile rf = new ResultFile();
			rf.setTaskID(taskId);
			rf.setFlag(1);
			rf.setCtime(ctime);
			rf.setUtime(utime);
			rf.setNote("original_file_id:"+originalFileId+";&"+"null");
			rf.setPath(path + File.separator + "result" + resultFile.getName());
			rf.setResultFileID(UUID.randomUUID().toString());
			ResultFileDAO rd = new ResultFileDAO();
			rd.insert(rf);
			
			//4.cachetask
			CacheTask ct = new CacheTask();
			ct.setJson(resultJsonContent);
			ct.setOriginalFileId(originalFileId);
			ct.setTaskID(taskId);
			CacheTaskDAO cd = new CacheTaskDAO();
			cd.insert(ct);
			
			//5.task
			Task task = new Task();
			task.setTaskID(taskId);
			task.setFlag(1);
			task.setNote("");
			task.setCtime(ctime);
			task.setUtime(utime);
			task.setTaskName("task");
			task.setUserID("9ef9207d-4eaa-4a04-baf1-3d60f84ec179");
			task.setStatusID("cd90072e-51a7-40f2-b21a-9fb65d57afcf");
			task.setResultTypeID("7eb52fa8-09e7-4707-8dab-3f1c66f9846c");
			TaskDAO ta = new TaskDAO();
			if (ta.findTask(taskId).size() <= 0) {
				ta.insert(task);
			}
		}
	}
}

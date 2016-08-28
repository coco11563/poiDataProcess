package dataProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;

import dataStruct.testSetStatus;
/**
 * 使用这个方法读取测试集
 * 
 * 测试集的组成是一个单元为testSetStatus的LinkedList
 * 
 * 读取的文件使checkpoint.txt
 * 
 * @author coco1
 *
 */
public class readTestSet {
	LinkedList<testSetStatus> li = new LinkedList<testSetStatus>();
	private final static String filepath_1 = "./data/checkpoint.txt";
	public readTestSet(){
		System.out.println("初始化TestSet...");
		readFile(filepath_1);
		System.out.println("初始化TestSet完成");
	}
	public void readFile(String path){
		File f = new File(path);
		String encoding = "UTF-8";
		if(!f.exists())
		{
			System.out.println("wrong path in readTestSet");
			}
		else
		{
			InputStreamReader read;
			try {
				long start = new Date().getTime();
				read = new InputStreamReader(new FileInputStream(f),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	String[] as = lineTxt.split(" ");
	            	double[] in = {Double.parseDouble(as[0]),Double.parseDouble(as[1])};
	            	li.add(new testSetStatus(in , as[2] , as[3], as[4]));
                }
	            bufferedReader.close();
	            read.close();
	            System.gc();
	            long end = new Date().getTime();
	            System.out.println("初始化TestSet数据共用："+(-start + end)/1000+"'s");
			} catch (IOException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}

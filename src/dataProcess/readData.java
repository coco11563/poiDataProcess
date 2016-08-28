package dataProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import dataStruct.poiStatus;

public class readData {
	public final static String datapath = "./data/part-00000";
	public final static String outputpath = "./data/output";
	Map<Integer , LinkedList<poiStatus>> m = new HashMap<Integer , LinkedList<poiStatus>>();
	public readData(){
		readFile(datapath);
	}
	public void readFile(String path)
	{
		
		File f = new File(path);
		String encoding = "UTF-8";
		if(!f.exists())
		{
			System.out.println("wrong path in readData");
			}
		else
		{
			InputStreamReader read;
			LinkedList<poiStatus> li;
			try {
				long start = new Date().getTime();
				read = new InputStreamReader(new FileInputStream(f),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	if(m.containsKey(readTime(lineTxt))){
	            		m.get(readTime(lineTxt)).add(readPoiStatus(lineTxt));
	            	}else{
	            		li = new LinkedList<poiStatus>();
	            		li.add(readPoiStatus(lineTxt));
	            		m.put(readTime(lineTxt), li);
	            	}
                }
	            bufferedReader.close();
	            read.close();
	            System.gc();
	            long end = new Date().getTime();
	            System.out.println("初始化Data数据共用："+(-start + end)/1000+"'s");
			} catch (IOException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public int readTime(String Line){
		String[] li = Line.split("\t");
		int ret = Integer.parseInt(li[0]);
		return ret ;
		
	}
	public poiStatus readPoiStatus(String Line){
		String[] li = Line.split("\t");
		poiStatus ret  = new poiStatus(li[1], Double.parseDouble(li[2]) , Double.parseDouble(li[3]) ,li[4], Integer.parseInt(li[5]));
		return ret;
	}
	public int check(int time , String poiid) throws TimeNotExistException{
		if(!m.containsKey(time)){throw new TimeNotExistException() ;}
		LinkedList<poiStatus> li = m.get(time);
		for(poiStatus p : li){
			if(p.getPoiid().equals(poiid)){
				return p.getCheckInNum();
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		readData rd = new readData();
		for(int i = 0 ; i  < rd.m.size() ; i ++){
			for(int j = 0 ; j < rd.m.get(i).size() ; j++){
				rd.m.get(i).get(j).print();
			}
		}
	}
}


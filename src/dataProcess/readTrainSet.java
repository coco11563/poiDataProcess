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

import dataStruct.trainSetStatus;
/**
 * 初始化训练集，读取的是位于data下面的poipoint.txt，存储的内容是武汉市所有的poi点
 * 
 * 实例化这个对象会生成三个实例化对象
 * 
 * ls：存储着以trainSetStatus为节点的链表
 * 
 * m：key poiid ，value 坐标数据
 * 
 * m_id_type key poiid ， value 该点的type
 * 
 * @author coco1
 *
 */
public class readTrainSet {
	LinkedList<trainSetStatus> ls = new LinkedList<trainSetStatus>();
	private static final String inputfile = "./data/poipoint.txt";
	Map<String , double[]> m = new HashMap<String , double[]>();
	Map<String , String> m_id_type = new HashMap<String , String>();
	public readTrainSet(){
		System.out.println("正在初始化TrainSet...");
		readFile(inputfile);
		System.out.println("初始化TrainSet完成");
	}
	
	public void readFile(String path)
	{
		
		File f = new File(path);
		String encoding = "UTF-8";
		if(!f.exists())
		{
			System.out.println("wrong path in readTrainSet");
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
	            	double[] in = new double[2] ;
	            	in[0]= Double.parseDouble(as[0]);
	            	in[1] = Double.parseDouble(as[1]);
	            	ls.add(new trainSetStatus(in , as[3],as[2] ));
	            	m.put(as[3], in);
	            	m_id_type.put(as[3], as[2]);
                }
	            bufferedReader.close();
	            read.close();
	            System.gc();
	            long end = new Date().getTime();
	            System.out.println("初始化TrainSet数据共用："+(-start + end)/1000+"'s");
			} catch (IOException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}

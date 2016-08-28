package dataProcess;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import Knn.KDTree;
import Knn.KeyDuplicateException;
import Knn.KeySizeException;
import dataStruct.priorityQueue;
import dataStruct.testSetStatus;
import dataStruct.trainSetStatus;

public class Main {
	public static final double Pi = Math.PI; 
	private final static double R = 6371229; // 地球的半径(米)
	private static final int k = 10 ;
	public static void main(String[] args) throws TimeNotExistException{
		readData rd = new readData();
		readTrainSet rt = new readTrainSet();
		readTestSet rts = new readTestSet();
		KDTree<String> kd = new KDTree<String>(2);
		
		LinkedList<trainSetStatus> trainset =  rt.ls ;
		int samenum = 0;
		System.out.println("初始化KDTREE...");
		for(int i = 0 ; i < trainset.size() ; i++){
			double[] d = new double[2];
			d[0] = trainset.get(i).getCoor()[0];
			d[1] =trainset.get(i).getCoor()[1];
			try {
				kd.insert(d, trainset.get(i).getPoiid());
//				System.out.println(d[0] + "-" + d[1] + "-" + trainset.get(i).getPoiid());
			} catch (KeySizeException | KeyDuplicateException e) {
				samenum ++ ;
				// TODO Auto-generated catch block
//				System.out.println(samenum + "-" + i+"-"+d[0] + "-" + d[1] + "-" + trainset.get(i).getPoiid());
//				e.printStackTrace();
			}
		} 
		System.out.println("初始化KDTREE完成 ，其中重复率为：" + ((double)samenum / trainset.size()));
		Queue<priorityQueue> pQ =  new PriorityQueue<priorityQueue>(11,OrderIsdn); 
		String poiid ;
		List<String> poi = null ;
		int rightnum = 0 ;
		System.out.println("正在进行一万次随机取点测试...");
		for(int j = 0 ; j < 10000 ; j ++){
			double seed = Math.random();
			testSetStatus test = rts.li.get((int)(seed * rts.li.size())); //随机取点做测试
			try {
				poi = kd.nearest(test.getCoor(),k);
			} catch (KeySizeException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int t = 0 ; t < k ; t ++){
				poiid =poi.get(t);	
				pQ.add(new priorityQueue(poiid,calDistance(rt.m.get(poiid),test.getCoor()) ,rd.check(test.getTime(),poiid)));
			}
//			pQ.peek().print();
//			System.out.println(test.getType());
//			System.out.println(rt.m_id_type.get(pQ.peek().getName()));
			if(rt.m_id_type.get(pQ.poll().getName()).equals(test.getType())){
				rightnum++;
				System.out.println(rightnum + "/" + (j+1) );
				}
		}
		System.out.println("一万次随机取点完成，准确率为："+rightnum / 10000.0);
		
	}
	public static double calDistance(double[] coor1,double[] coor2)
	{
		double x, y, distance;
		x = (coor1[0] - coor2[0]) * Pi * R* Math.cos(((coor1[1] + coor2[1]) / 2) * Pi / 180) / 180;
		y = (coor1[1] - coor2[1]) * Pi * R / 180;
		distance = Math.hypot(x, y);
		return distance;
	}
	static Comparator<priorityQueue> OrderIsdn =  new Comparator<priorityQueue>(){  
        public int compare(priorityQueue o1, priorityQueue o2) {  
            // TODO Auto-generated method stub  
            double numbera = o1.getPopulation();  
            double numberb = o2.getPopulation();  
            if(numberb > numbera)  
            {  
                return 1;  
            }  
            else if(numberb<numbera)  
            {  
                return -1;  
            }  
            else  
            {  
                return 0;  
            }  
          
        }  
    };
}

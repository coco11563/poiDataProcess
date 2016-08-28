package dataStruct;
import java.util.Comparator;  
import java.util.PriorityQueue;  
import java.util.Queue;  
public class priorityQueue {  
	    private String name;  
	    private double population; 
	    private final static double dw = 0.5;
	    private final static double cw = 0.5 ;
	    public void print(){
	    	System.out.println(this.toString());
	    }
	    public priorityQueue(String name, double population)  
	    {  
	        this.name = name;  
	        this.population = population;  
	    }  
	    public priorityQueue(String name , double distance , int checkinnum){
	    	double population = populationCacu(distance , checkinnum );
	    	this.name = name ;
	    	this.population = population; 
	    }
	    public double populationCacu(double distance , double checkinnum ){
	    	double population = sigmoid(checkinnum) * cw - dw * sigmoid(distance) ;
	    	return population;
	    }
	    public double sigmoid(double in){
	    	return (1/(1 + Math.exp(-in)));
	    }
	    public String getName()  
	    {  
	         return this.name;  
	    }  
	  
	    public double getPopulation()  
	    {  
	         return this.population;  
	    }  
	    public String toString()  
	    {  
	         return getName() + " - " + getPopulation();  
	    }  
	    public static void main(String args[])  
	    {  
	        Comparator<priorityQueue> OrderIsdn =  new Comparator<priorityQueue>(){  
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
	        Queue<priorityQueue> priorityQueue =  new PriorityQueue<priorityQueue>(11,OrderIsdn);  
	          
	                  
	              
	        priorityQueue t1 = new priorityQueue("t1",1000,5);  
	        priorityQueue t3 = new priorityQueue("t3",372 ,6);  
	        priorityQueue t2 = new priorityQueue("t2",399 , 5);  
	        priorityQueue t4 = new priorityQueue("t4",473 , 100);  
	        priorityQueue.add(t1);  
	        priorityQueue.add(t3);  
	        priorityQueue.add(t2);  
	        priorityQueue.add(t4);  
	        System.out.println(priorityQueue.poll().toString());
	        System.out.println(priorityQueue.poll().toString());
	        System.out.println(priorityQueue.poll().toString());
	        System.out.println(priorityQueue.poll().toString());
	    }  
	
}

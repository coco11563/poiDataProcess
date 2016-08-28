package dataStruct;  
/**
 * 存储优先队列的节点
 * 
 * 结构是：
 * 
 * poiid
 * 
 * population
 * 
 * distance
 * 
 * @author coco1
 *
 */
public class priorityQueue {  
	    private String name;  
	    private double population; 
	    private double distance ;
	    private final static double dw = 0.5;
	    private final static double cw = 0.5 ;
	    public void print(){
	    	System.out.println(this.toString());
	    }
	    /**
	     * 
	     * 使用这个实例化方法不会存储距离
	     * 
	     * @param name
	     * 
	     * @param population
	     * 
	     */
	    public priorityQueue(String name, double population)  
	    {  
	        this.name = name;  
	        this.population = population;  
	    }  
	    /**
	     * 
	     * 使用这个实例化方法会顺便存储这个点的距离
	     * 
	     * @param name
	     * 
	     * @param distance
	     * 
	     * @param checkinnum
	     * 
	     */
	    public priorityQueue(String name , double distance , int checkinnum){
	    	double population = populationCacu(distance , checkinnum );
	    	this.name = name ;
	    	this.population = population; 
	    	this.setDistance(distance) ;
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
		/**
		 * @return the distance
		 */
		public double getDistance() {
			return distance;
		}
		/**
		 * @param distance the distance to set
		 */
		public void setDistance(double distance) {
			this.distance = distance;
		}  
	
}

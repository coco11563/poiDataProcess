package dataStruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 存储了训练集的最小单元
 * 
 * 每个单元包含：
 * 
 * coor[]
 * 
 * type
 * 
 * time
 * 
 * poiid
 * 
 * @author coco1
 *
 */
public class testSetStatus {
	private double[] coor ; 
	private String type ;
	private int time ;
	private String poiid ;
	/**
	 * 注意变量的输入次序
	 * 
	 * @param coor
	 * 
	 * @param type
	 * 
	 * @param poiid
	 * 
	 * @param time
	 * 
	 */
	public testSetStatus(double [] coor , String type ,String poiid , String time){
		this.setCoor(coor) ;
		this.setType(type) ;
		this.setTime(getTime(time)) ;
		this.setPoiid(poiid);
	}
	/**
	 * 使用这个方法从一段形式是HH:mm:ss的字符串内读取对应的小时
	 * 
	 * @param String time
	 * 
	 * @return int time
	 */
	@SuppressWarnings("deprecation")
	public int getTime(String time){
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("HH:mm:ss");
		Date day;
		int q = 0 ;
		try {
			day = sdf.parse(time);
			q = day.getHours();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q ;
		
	}
	/**
	 * @return the poiid
	 */
	public String getPoiid() {
		return poiid;
	}
	/**
	 * @param poiid the poiid to set
	 */
	public void setPoiid(String poiid) {
		this.poiid = poiid;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the coor
	 */
	public double[] getCoor() {
		return coor;
	}
	/**
	 * @param coor the coor to set
	 */
	public void setCoor(double[] coor) {
		this.coor = coor;
	}
	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
}

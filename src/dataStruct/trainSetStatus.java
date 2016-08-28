package dataStruct;

public class trainSetStatus {
	private double[] coor ;
	private String poiid ;
	private String type ;
	/**
	 * 
	 * @param coor
	 * @param poiid
	 * @param type
	 */
	public trainSetStatus(double[] coor , String poiid , String type){
		this.setCoor(coor) ;
		this.setPoiid(poiid) ;
		this.setType(type) ;
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
}

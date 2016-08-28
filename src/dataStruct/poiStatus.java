package dataStruct;

public class poiStatus {
	private double lat ;
	private double lon ;
	private String poiid ;
	private int checkInNum ;
	private String type ;
	/**
	 * 
	 * @param poiid
	 * @param lat
	 * @param lon
	 * @param checkInNum
	 */
	public poiStatus(String poiid , double lat , double lon , String type ,int checkInNum){
		this.lat = lat ; 
		this.lon = lon ;
		this.checkInNum = checkInNum ; 
		this.poiid = poiid ;
		this.type = type ;
	}
	@Override
	public int hashCode(){
		int hashcode = poiid.hashCode() + checkInNum * 419 + type.hashCode() ;
		return hashcode;
	}
	@Override 
	public boolean equals(Object o){
		if(!(o instanceof poiStatus)) return false ;
		poiStatus p = (poiStatus)o ;
		return p.poiid.equals(poiid) && p.checkInNum == checkInNum && p.type.equals(type);
	}
	public void print(){
		System.out.println(this.poiid +" " +this.type + " " + this.lat + "," + this.lon + " " + this.checkInNum );
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
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
	 * @return the checkInNum
	 */
	public int getCheckInNum() {
		return checkInNum;
	}
	/**
	 * @param checkInNum the checkInNum to set
	 */
	public void setCheckInNum(int checkInNum) {
		this.checkInNum = checkInNum;
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

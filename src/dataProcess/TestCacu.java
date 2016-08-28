package dataProcess;
/**
 * 
 * 测试下距离计算的单位
 * 
 * @author coco1
 *
 */
public class TestCacu {
	static double Pi = Math.PI ;
	static double R = 6371229 ;
	public static double calDistance(double[] coor1,double[] coor2)
	{
		double x, y, distance;
		x = (coor1[0] - coor2[0]) * Pi * R* Math.cos(((coor1[1] + coor2[1]) / 2) * Pi / 180) / 180;
		y = (coor1[1] - coor2[1]) * Pi * R / 180;
		distance = Math.hypot(x, y);
		return distance;
	}
	public static void main(String args[]){
		double[] coor  = new double[2] ;
		double[] coor2 = new double[2] ;
		coor[0] = 114.242271;
		coor[1] = 30.63883 ;
		coor2[0] = 114.226281;
		coor2[1] = 30.580607 ;
		System.out.println(calDistance(coor , coor2));
				
	}
}

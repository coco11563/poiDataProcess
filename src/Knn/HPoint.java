// Hyper-Point class supporting KDTree class

package Knn;

class HPoint {

	protected double[] coord;
	protected HPoint(int n) {
		coord = new double[n];//构造方法1：输入一个维数，构建相应的double数组
	}
	
	protected HPoint(double[] x) {

		coord = new double[x.length];
		for (int i = 0; i < x.length; ++i)//构造方法2：输入一个double数组，复制这个数组
			coord[i] = x[i];
	}

	protected Object clone() {

		return new HPoint(coord);
	}

	protected boolean equals(HPoint p) {

		// seems faster than java.util.Arrays.equals(), which is not
		// currently supported by Matlab anyway
		for (int i = 0; i < coord.length; ++i)
			if (coord[i] != p.coord[i])
				return false;

		return true;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < coord.length; ++i) {
			s = s + coord[i] + " ";
		}
		return s;
	}

	

}

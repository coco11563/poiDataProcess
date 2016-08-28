// Hyper-Rectangle class supporting KDTree class

package Knn;

class HRect {

	protected HPoint min;
	protected HPoint max;

	protected HRect(int ndims) {//构造方法1，定义两个max与min的HPoint，其维度为输入值
		min = new HPoint(ndims);
		max = new HPoint(ndims);
	}

	protected HRect(HPoint vmin, HPoint vmax) {//构造方法2，输入两个HPoint，把值赋进来

		min = (HPoint) vmin.clone();
		max = (HPoint) vmax.clone();
	}

	// from Moore's eqn. 6.6
	/**
	 * 
	 * 输入一个HPoint t
	 * 
	 * 在本超平面中，离这个点最近的点
	 * 
	 * @param t
	 * 
	 * @return
	 * 
	 */
	protected HPoint closest(HPoint t) {//可以返回一个HPoint，这个HPoint点的值是取决于输入点是否在我们设定的超平面内，返回值是输入点离超平面最近的点

		HPoint p = new HPoint(t.coord.length); //定义一个与输入点相同的HPoint

		for (int i = 0; i < t.coord.length; ++i) {//对输入点的每一个维度进行以下操作
			if (t.coord[i] <= min.coord[i]) {//比min小则把min的值赋给p
				p.coord[i] = min.coord[i];
			} else if (t.coord[i] >= max.coord[i]) {//比max大则把max的值赋给p
				p.coord[i] = max.coord[i];
			} else {
				p.coord[i] = t.coord[i];//在min和max之间则把输入值赋给p
			}
		}

		return p;
	}

	// used in initial conditions of KDTree.nearest()
	/**
	 * 输入一个维度int d，返回一个无限大的该维度的超平面
	 * 
	 * @param d
	 * 
	 * @return
	 */
	
	protected static HRect infiniteHRect(int d) {//返回一个无限大的超平面

		HPoint vmin = new HPoint(d);
		HPoint vmax = new HPoint(d);

		for (int i = 0; i < d; ++i) {
			vmin.coord[i] = Double.NEGATIVE_INFINITY;
			vmax.coord[i] = Double.POSITIVE_INFINITY;
		}

		return new HRect(vmin, vmax);
	}

	// currently unused
	/**
	 * 
	 * 将两个超平面进行并计算
	 * 
	 * 返回的超平面的最大值是输入超平面和本超平面之间的最大值
	 * 
	 * 返回的超平面的最小值是输入超平面和本超平面之间的最小值
	 * 
	 * @param r
	 *
	 * @return
	 * 
	 */
	protected HRect intersection(HRect r) {

		HPoint newmin = new HPoint(min.coord.length);
		HPoint newmax = new HPoint(min.coord.length);

		for (int i = 0; i < min.coord.length; ++i) {
			newmin.coord[i] = Math.max(min.coord[i], r.min.coord[i]);
			newmax.coord[i] = Math.min(max.coord[i], r.max.coord[i]);
			if (newmin.coord[i] >= newmax.coord[i])
				return null;
		}

		return new HRect(newmin, newmax);
	}

	// currently unused
	/**
	 * 
	 * 返回超平面的面积
	 * 
	 * @return
	 * 
	 */
	protected double area() {

		double a = 1;

		for (int i = 0; i < min.coord.length; ++i) {
			a *= (max.coord[i] - min.coord[i]);
		}

		return a;
	}

	@Override
	protected Object clone() {
		return new HRect(min, max);
	}

	@Override
	public String toString() {
		return "HRect [max=" + max + ", min=" + min + "]";
	}

}

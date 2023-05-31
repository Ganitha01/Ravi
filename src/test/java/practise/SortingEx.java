package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingEx {

	public static void main(String[] args) {

		List<Double> dd=new ArrayList<Double>();
		 dd.add(100.2d);dd.add(55.3d);dd.add(45.22d);dd.add(110.2d);dd.add(400.2d);dd.add(3.2d);
		 System.out.println(dd);
		 Collections.sort(dd);
		 System.out.println(dd);
	}

}

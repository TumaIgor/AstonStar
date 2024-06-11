package aston.list.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aston.list.interfaces.RealizeList;
import aston.list.models.MyArrayList;

class ListTest {

	@Test
	void test() {
		RealizeList<Integer> list = new MyArrayList<>();
		System.out.println(list.size());
		list.add(2);
		list.add(7);
		list.add(3);
		list.add(5);
		list.add(null);
		list.add(7);
		System.out.println(list.size());
		System.out.println(list.get(4));
		int index = list.indexOf(null);
		System.out.println(index);
		index = list.indexOf(5); 
		System.out.println(index);
		System.out.println(list.contains(12));
		System.out.println("==================");
		System.out.println(list.size());
		int num = list.remove(3);
		System.out.println(list.size());
		System.out.println(num);
		System.out.println("==================");
		
	
		
	}

}

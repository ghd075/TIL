package com.edu.java;

import com.edu.emp.EmpDAO;
import java.util.*;

public class EmpDAOTest {

	public static void main(String[] args) {
		List<Map<String,Object>> list = EmpDAO.getInstance().selectDeptSal();
		for(Map<String,Object> num : list) {
			System.out.println(num);
		}

	}

}

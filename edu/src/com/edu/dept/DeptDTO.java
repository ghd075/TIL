package com.edu.dept;

public class DeptDTO {
	private String department_id;    
	private String department_name;      
	private String manager_id; 
	private String location_id;
	
	public DeptDTO() {
		
	}

	public DeptDTO(String department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	@Override
	public String toString() {
		return "DeptDTO [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + "]";
	}
}

package com.springbook.biz.emp;

public class DeptVO {
	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;

	public DeptVO() {
		super();
	}

	public DeptVO(String department_id, String department_name) {
		super();
		this.departmentId = department_id;
		this.departmentName = department_name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "DeptVO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}	
}

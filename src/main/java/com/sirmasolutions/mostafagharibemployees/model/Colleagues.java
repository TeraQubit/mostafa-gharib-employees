package com.sirmasolutions.mostafagharibemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colleagues {

	private int empId1;
	private int empId2;
	private int projectId;
	private Long days;

	public Colleagues(int empId1, int empId2, Long days) {
		this.empId1 = empId1;
		this.empId2 = empId2;
		this.days = days;
	}

	public Colleagues(int empId1, int empId2) {
		this.empId1 = empId1;
		this.empId2 = empId2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId1;
		result = prime * result + empId2;
		result = prime * result + projectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colleagues other = (Colleagues) obj;
		if (empId1 != other.empId1)
			return false;
		if (empId2 != other.empId2)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}

}
package com.sirmasolutions.mostafagharibemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Input {
	private int employeeID;
	private int projectID;
	private LocalDate dateFrom;
	private LocalDate dateTo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + ((dateFrom == null) ? 0 : dateFrom.hashCode());
		result = prime * result + employeeID;
		result = prime * result + projectID;
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
		Input other = (Input) obj;
		if (dateTo == null) {
			if (other.dateTo != null)
				return false;
		} else if (!dateTo.equals(other.dateTo))
			return false;
		if (dateFrom == null) {
			if (other.dateFrom != null)
				return false;
		} else if (!dateFrom.equals(other.dateFrom))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (projectID != other.projectID)
			return false;
		return true;
	}
}
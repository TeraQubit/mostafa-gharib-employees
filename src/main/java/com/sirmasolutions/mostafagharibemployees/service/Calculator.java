package com.sirmasolutions.mostafagharibemployees.service;

import com.sirmasolutions.mostafagharibemployees.model.Colleagues;
import com.sirmasolutions.mostafagharibemployees.model.Input;

import java.util.List;



public interface Calculator {
	 void calculateColleaguesPairs(Input[] data);
	 void clearColleaguesList();
	 Colleagues getLongestWorkingTeam();
	 List<Colleagues> getColleaguesList();
}
package com.assaasoociates.syraway.controller;

import java.util.List;

import com.assaassociates.syraway.model.Team;

public interface ITeamController {

	public void addTeam(Team oTeam);
	public void updateTeam(Team oTeam);
	public Team getTeam(Integer pTeamId);
	public List<Team> getAllTeams();
	
}

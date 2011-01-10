/**
 * 
 */
package com.assaassociates.syraway.dao;

import java.util.List;
import com.assaassociates.syraway.model.Time;

/**
 * @author waheb
 *
 */
public interface ITimeDAO {
	public Time getTimeById(Integer pTimeId);
	public List<Time> getTimeOfEmployee(Integer pEmployeeId);
	public List<Time> getTimeOfTask(Integer pTaskId);
	public List<Time> getTimeOfTeam(Integer pTeamId);
	public void addTime(Time oTime);
	public void updateTime(Time pTime);
	public void removeTime(Time pTime);
	public void removeTime(Integer pTimeId);
	public List<Time> getAllTimes();
}

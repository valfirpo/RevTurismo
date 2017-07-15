package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bean.AdminNotify;
import com.rev.bean.Challenge;
import com.rev.dao.AdminNotifyDao;
import com.rev.dao.AdminNotifyDaoImpl;
import com.rev.dao.ChallengeDao;

public class ChallengeServiceImpl implements ChallengeService
{
	@Autowired
	public ChallengeDao challengeDao;
	
	@Override
	public Challenge getChallengesById(int id) 
	{
		return challengeDao.getChallengeById(id);
	}

	@Override
	public List<Challenge> getAllChallenges() 
	{
		return challengeDao.getChallenges();
	}
	
	@Override
	public void updateChallenge(Challenge challenge)
	{
		challengeDao.updateChallenge(challenge);
		AdminNotifyDao doa = new AdminNotifyDaoImpl();
		AdminNotify note = new AdminNotify();
		note.setActive(1);
		note.setContent(challenge.getName() + " Has been modified!");
		doa.createAdminNotify(note);
		
	}
}

package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bean.Challenge;
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
	
}

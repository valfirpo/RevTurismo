package com.rev.service;

import java.util.List;

import com.rev.bean.Challenge;

public interface ChallengeService 
{
	public Challenge getChallengesById(int id);
	public List<Challenge> getAllChallenges();

}

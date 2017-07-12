package com.rev.dao;

import java.util.List;

import com.rev.bean.Challenge;

public interface ChallengeDao {
	public Challenge getChallengeById(int challengeId);
	public int createChallenge(Challenge challenge);
	public void updateChallenge(Challenge challenge);
	public void deleteChallenge(Challenge challenge);
	public List<Challenge> getChallenges();

}

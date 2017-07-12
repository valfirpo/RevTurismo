package com.rev.dao;

import com.rev.bean.DirectMessage;

public interface DirectMessageDao {
	public DirectMessage getDmById(int dmId);
	public int createDm(DirectMessage dm);
	public void updateDm(DirectMessage dm);
	public void deleteDm(DirectMessage dm);
	
}

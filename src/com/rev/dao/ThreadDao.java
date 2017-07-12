package com.rev.dao;
import com.rev.bean.Thread;

public interface ThreadDao {
	public Thread getThreadById(int threadId);
	public int createThread(Thread thread);
	public void updateThread(Thread thread);
	public void deleteThread(Thread thread);
}

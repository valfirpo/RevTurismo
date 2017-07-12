package com.rev.dao;

import com.rev.bean.Post;

public interface PostDao {
	public Post getPostById(int postId);
	public int createPost(Post post);
	public void updatePost(Post post);
	public void deletePost(Post post);
}

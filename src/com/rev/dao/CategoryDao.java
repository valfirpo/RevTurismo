package com.rev.dao;

import java.util.List;

import com.rev.bean.Category;

public interface CategoryDao {
	public Category getCategoryById(int categoryId);
	public int createCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	public List<Category> getCategories();
}

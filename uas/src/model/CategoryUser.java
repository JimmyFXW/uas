package model;

public class CategoryUser {
	private int categoryId;
	private String categoryName;
	
	public CategoryUser(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryUser [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
}

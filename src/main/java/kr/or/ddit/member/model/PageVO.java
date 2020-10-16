package kr.or.ddit.member.model;

public class PageVO {

	private int page;
	private int pageSize;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + page;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageVO other = (PageVO) obj;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
}

package thuan.com.fa.demomvc.page;

public class PageAble {
	private int page;
	private int size = 2;

	public PageAble(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

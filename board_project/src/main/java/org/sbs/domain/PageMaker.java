package org.sbs.domain;

public class PageMaker {

	private Integer page = 0;
	private Integer start;
	private Integer end;
	private Integer count;
	private Boolean prev, next;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {

		if (page < 1) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {

		if (count < 1) {
			return;
		}

		this.count = count;
		calcPage();
	}

	private void calcPage() {

		int tempEnd = (int) (Math.ceil(page / 10.0) * 10);

		this.start = tempEnd - 9;

		if (tempEnd * 10 > this.count) {
			this.end = (int) Math.ceil(this.count / 10.0);
		} else {
			this.end = tempEnd;
		}

		this.prev = this.start != 1;

		this.next = this.end * 10 < this.count;
	}

	public Boolean getPrev() {
		return prev;
	}

	public void setPrev(Boolean prev) {
		this.prev = prev;
	}

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", start=" + start + ", end=" + end + ", count=" + count + ", prev=" + prev
				+ ", next=" + next + "]";
	}

}

package com.qixin.common;

import java.util.Collection;

public class PageBean {
	private int pageNum;// 总页面数
	private int curPage = 1;// 当前页
	private int sum;// 总数
	private int perPageNum = 1;// 每页个数
	private Collection<Object> data;// 要显示的数据
	private int start;
	private int end;

	public PageBean(int curPage, int perPageNum) {
		this.curPage = curPage;
		this.perPageNum = perPageNum;
	}

	public int getMaxNum() {
		return perPageNum - 1;
	}

	public PageBean(int curPage) {
		this.curPage = curPage;

	}

	public static int countCurPage(int curPage, int pageNum) {
		if (pageNum == 0) {
			curPage = 0;
		} else if (curPage > pageNum) {
			curPage = pageNum;
		}
		return curPage;
	}

	public static int countPageNum(int sum, int perPageNum) {
		return (sum + perPageNum - 1) / perPageNum;
	}

	public static int countStart(int curPage, int perPageNum) {
		int start = 0;
		if ((curPage - 1) * perPageNum > 0) {
			start = (curPage - 1) * perPageNum;
		}
		return start;
	}

	public void init() {
		this.pageNum = countPageNum(this.sum, this.perPageNum);
		this.curPage = countCurPage(curPage, pageNum);
		this.start = countStart(curPage, perPageNum);

	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;

	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public Collection<Object> getData() {
		return data;
	}

	public void setData(Collection<Object> data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
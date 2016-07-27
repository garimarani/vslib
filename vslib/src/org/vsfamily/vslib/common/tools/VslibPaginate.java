package org.vsfamily.vslib.common.tools;

import java.util.List;

public class VslibPaginate {

	private int						startResult;
	private int						maxResult;
	private int 					totalResult;
	private List<?>					listObject;
	
	public int getStartResult() {
		return startResult;
	}
	public void setStartResult(int startResult) {
		this.startResult = startResult;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public List<?> getListObject() {
		return listObject;
	}
	public void setListObject(List<?> listObject) {
		this.listObject = listObject;
	}
	
	public boolean isFirstPage(){
		if (startResult == 0) return true;
		return false;
	}
	
	public int getNumPages(){
		int bal = this.totalResult / this.maxResult;
		
		if (this.maxResult * bal == this.totalResult) return bal;
		else return bal + 1;
	}
	
	public boolean isLastPage(int currentPage){
		if (currentPage == this.getNumPages()) return true;
		return false;
		
	}
}

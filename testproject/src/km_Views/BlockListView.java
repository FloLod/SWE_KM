package km_Views;

import java.util.Date;

public class BlockListView {
	private int blockListID;
	private StudentView student;
	private String reason;
	private Date endDate;
	
	public BlockListView(){}
	public BlockListView(km_Entities.BlockList block){}
	public BlockListView(int blockListID, StudentView student, String reason, Date endDate) {
		super();
		this.blockListID = blockListID;
		this.student = student;
		this.reason = reason;
		this.endDate = endDate;
	}
	public int getBlockListID() {
		return blockListID;
	}
	public void setBlockListID(int blockListID) {
		this.blockListID = blockListID;
	}
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}

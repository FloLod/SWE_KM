package km_Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlockList implements Serializable{
	@Id
	@GeneratedValue
	private int blockListID;
	@ManyToOne
	private Student student;
	private String reason;
	private Date endDate;
	
	public BlockList(){
		
	}

	public int getBlockListID() {
		return blockListID;
	}

	public void setBlockListID(int blockListID) {
		this.blockListID = blockListID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
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
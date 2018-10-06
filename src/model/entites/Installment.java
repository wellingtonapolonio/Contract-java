package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dueDate;
	private Double amount;
	
	public Installment() {
		
	}

	public Installment(Date dueDate, Double amout) {
		
		this.dueDate = dueDate;
		this.amount = amout;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmout() {
		return amount;
	}

	public void setAmout(Double amout) {
		this.amount = amout;
	}
	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
}
}

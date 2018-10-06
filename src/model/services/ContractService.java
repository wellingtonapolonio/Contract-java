package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entites.Contract;
import model.entites.Installment;

public class ContractService {
	private OnlinePaymentService onlinePayService;

	public ContractService(OnlinePaymentService onlinePayService) {
		
		this.onlinePayService = onlinePayService;
	}
	
	public void processContract(Contract contract, int moths) {
		double basic = contract.getTotalValue() / moths;
		
		for (int i =  1; i<= moths; i++) {
			 Date date = addMonths(contract.getDate(), i);
			double update = basic + onlinePayService.interest(basic, i);
			double full = update + onlinePayService.paymentFee(update);
			contract.addInstallment(new Installment(date, full));
		}
	}
	
	
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
}

}

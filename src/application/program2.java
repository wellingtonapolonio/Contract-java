package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import model.entites.Contract;
import model.entites.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class program2 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		JOptionPane.showMessageDialog(null, "Enter contract data");
		
		
		String s= JOptionPane.showInputDialog("\"Number:\"");
		int num = Integer.parseInt(s);
		String x= JOptionPane.showInputDialog("Date (dd/MM/yyyy):");
		Date d = new SimpleDateFormat("mm/MM/yyy").parse(x);
		String aux =JOptionPane.showInputDialog("Contract value:");
		double contract1 = Double.parseDouble(aux);
		
		Contract contract = new Contract(num, d, contract1);
		
		String aux1=JOptionPane.showInputDialog("\"Enter number of installments:\"");
		int n = Integer.parseInt(aux1);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		JOptionPane.showMessageDialog(null, "Installments:");
		for (Installment y: contract.getInstallment()) {
			JOptionPane.showMessageDialog(null,y);
		}
		
		

	}

}

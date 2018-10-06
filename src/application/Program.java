package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Contract;
import model.entites.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System. in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter contract data");
		sc.nextLine();
		System.out.print("Number:");
		int num = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy):");
		Date d = sdf.parse(sc.next());
		System.out.print("Contract value:");
		double contract1 = sc.nextDouble();
		
		Contract contract = new Contract(num, d, contract1);
		
		System.out.print("Enter number of installments:");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments:");
		
		for(Installment y: contract.getInstallment()) {
			System.out.println(y);
		}
		sc.close();

	}


}

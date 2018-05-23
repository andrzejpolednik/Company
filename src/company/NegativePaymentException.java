package company;

public class NegativePaymentException extends Exception{
	
	double payment;
	double balance;
	public NegativePaymentException(double payment, double balance) {
		this.payment = payment;
		this.balance = balance;
		
		
	}
	public String toString() {
		if (payment <0 ) {return "Error: Cannot take negative payment of " + payment;
		}	
		else if (payment > balance) {return "Error: the amount of payment is higher than the balance";
	}
		return "Unidentifed Error";

	}
}
import java.io.StringReader;
import java.util.Scanner;

public class Payment {
    private String paymentMethod;
    private double amount;

    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public void makePayment() {
        boolean success = false;
        Scanner scanner = new Scanner(System.in);

        if (paymentMethod.equals("E-wallet")) {
            System.out.print("Enter your E-wallet email address: ");
            String email = scanner.nextLine();
            System.out.print("Enter your E-wallet password: ");
            String password = scanner.nextLine();

            // Process the payment using the E-wallet service
            success = processEwalletPayment(amount, email, password);
        } else if (paymentMethod.equals("Cash")) {
            System.out.println("Please pay the amount in cash to the delivery person.");
            success = true;
        } else if (paymentMethod.equals("Voucher")) {
            System.out.print("Enter your voucher code: ");
            String voucherCode = scanner.nextLine();

            // Process the payment using the voucher code
            success = processVoucherPayment(amount, voucherCode);
        
        } else {
            System.out.println("Invalid payment method.");
        }

        if (success) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }

 private boolean processEwalletPayment(double amount, String email, String password) {
       
        boolean isAuthenticated = authenticateEwalletUser(email, password);

    if (isAuthenticated) {
        double balance = getEwalletBalance(email);
        if (balance >= amount) {
            // Deduct the payment amount from the user's E-wallet balance
            boolean isDeducted = deductEwalletBalance(email, amount);
            if (isDeducted) {
                // Payment successful
                return true;
            }
        } else {
            // Insufficient balance
            return false;
        }
    }

    // Authentication failed or payment failed
    return false;
}
    

    private boolean deductEwalletBalance(String email, double amount2) {
	// TODO Auto-generated method stub
	return false;
}

	private double getEwalletBalance(String email) {
	// TODO Auto-generated method stub
	return 0;
}

	private boolean authenticateEwalletUser(String email, String password) {
	// TODO Auto-generated method stub
	return false;
}

	private boolean processVoucherPayment(double amount, String voucherCode) {
        // Your code here to process the payment using the voucher code
        // Return true if the payment was successful, false otherwise
        boolean isVoucherValid = checkVoucherValidity(voucherCode);
    if (isVoucherValid) {
        // Check if the voucher has sufficient balance to cover the payment amount
        double voucherBalance = getVoucherBalance(voucherCode);
        if (voucherBalance >= amount) {
            // Deduct the payment amount from the voucher balance
            boolean isDeducted = deductVoucherBalance(voucherCode, amount);
            if (isDeducted) {
                // Payment successful
                return true;
            }
        } else {
            // Insufficient voucher balance
            return false;
        }
    } else {
        // Invalid voucher code
        return false;
    }

    // Payment failed
    return false;
}
    

    private boolean deductVoucherBalance(String voucherCode, double amount2) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkVoucherValidity(String voucherCode) {
		// TODO Auto-generated method stub
		return false;
	}

	private double getVoucherBalance(String voucherCode) {
		// TODO Auto-generated method stub
		return 0;
	}
}

   

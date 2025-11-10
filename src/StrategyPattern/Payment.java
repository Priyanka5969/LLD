package StrategyPattern;

// interface (strategy)
interface PaymentStrategy{
    void pay(int amount);
}


// concrete strategy classes
class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;

    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid "+amount+" using credit card: "+cardNumber);
    }
}

class UpiPayment implements PaymentStrategy{
    private String upiId;

    public UpiPayment(String upiId){
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid "+amount+" using upi Id: "+upiId);
    }
}

class PayPalPayment implements PaymentStrategy{
    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid "+amount+" using PayPal email: "+ email);
    }
}

// context class (for composition)
class PaymentService{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount){
        if(paymentStrategy == null){
            System.out.println("Payment strategy not set!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class Payment{
    public static void main(String[] args){
        System.out.println("Hello");
        PaymentService paymentService = new PaymentService();

        paymentService.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        paymentService.makePayment(1000);

        paymentService.setPaymentStrategy(new UpiPayment("abc@upi"));
        paymentService.makePayment(300);

        paymentService.setPaymentStrategy(new PayPalPayment("abc@gmail.com"));
        paymentService.makePayment(700);
    }
}
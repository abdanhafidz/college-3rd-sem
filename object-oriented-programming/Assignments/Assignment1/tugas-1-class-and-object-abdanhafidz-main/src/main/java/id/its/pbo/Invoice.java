package id.its.pbo;
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double price;
    private Control controller = new Control();
    public Invoice(String c_partNumber, String c_partDescription, int c_quantity, double c_price){
        this.partNumber = c_partNumber;
        this.partDescription = c_partDescription;
        this.quantity = (int) controller.negativeHandler(c_quantity);
        this.price = controller.negativeHandler( c_price);
    }

    public double getInvoiceAmount(){
        return (double) this.quantity * this.price;
    }
    public void setPartNumber(String c_partNumber){
        this.partNumber = c_partNumber;
    }

    public void setPartDescription(String c_partDescription){
        this.partDescription = c_partDescription;
    }

    public void setQuantity(int c_quantity){
        this.quantity = (int) controller.negativeHandler(c_quantity);
    }

    public void setPrice(double c_price){
        this.price = (double) controller.negativeHandler(c_price);
    }

    public String getPartNumber(){
        return this.partNumber;
    }

    public String getPartDescription(){
        return this.partDescription;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }


}

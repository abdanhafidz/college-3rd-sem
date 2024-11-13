package id.its.pbo;

public class InvoiceProgram {
    public static void main(String[] args) {
        Invoice Invoice1 = new Invoice("a123","blabla",10,10000);
        Invoice Invoice2 = new Invoice("b123","blablab",20,20.3);
        System.out.println("Amount Invoice 1 : " + Invoice1.getInvoiceAmount());
        System.out.println("Amount Invoice 2 : " + Invoice2.getInvoiceAmount());
    
    }
}

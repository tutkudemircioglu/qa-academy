package models;

public class OrderRequest {
    public int id;
    public int petId;
    public int quantity;
    public String shipDate;
    public String status;
    public boolean complete;

    public OrderRequest(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}

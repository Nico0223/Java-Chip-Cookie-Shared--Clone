public class PurchaseTool {
    private int cost;
    private double experience;

    public void initializeOrder(ToolList orderList, String request) {
        int index = orderList.getIndexTool(request);

        if (index != -1) {
            this.cost = orderList.costIndex(index);
            this.experience = orderList.expIndex(index);
        }
    }

    public int getCost() {
        return this.cost;
    }

    public double getExp() {
        return this.experience;
    }
}

public class Lot {
    //private int tile;
    private String state = "Unplowed";
    //private boolean rock;
    private Seed crop;
    private double experience;

    public void plowTile(){
        this.state = "Plowed";
    }
    public void plantSeed(Seed seed){
        this.crop = seed;
        experience = this.crop.getExpGained();
        this.state = this.crop.showName() + " - " + this.crop.showHarvestTime() + " days left";
        crop.checkCondition(new SeedList());
    }
    public void leaveLot(){
        crop.grow();
        crop.checkCondition(new SeedList());
        if (this.crop.showHarvestTime() == 0 && crop.isHarvestable())
            this.state = "Ready to harvest";
        else if (this.crop.isWithered())
            this.state = "Withered";
        else
            this.state = this.crop.showName() + " - " + this.crop.showHarvestTime() + " days left";
    }
    public void waterPlant(){
        System.out.println("Watered");
        this.crop.addWater();
    }
    public void fertilizePlant(){
        System.out.println("Fertilized");
        this.crop.addFertilizer();
    }
    /*public void mineRock(){
        this.state = "Unplowed";
    }*/
    public void shovelTile(){
        if (this.state.equals("Unplowed"))
            System.out.println("Bruh");

        this.state = "Unplowed";
    }
    public int harvest(){
        if (this.state.equals("Ready to harvest")){
            int total = this.crop.getTotalPrice();
            System.out.println("Earned " + total + " objectcoins");
            this.crop = null;
            this.state = "Unplowed";
            return total;
        }

        else if (this.state.equals("Withered"))
            System.out.println("Use the shovel to remove the withered plant");
        else
            System.out.println("This plant is too young to harvest");
        return 0;
    }
    public double getExperience(){
        return this.experience;
    }

    public String showState(){
        return this.state;
    }

}

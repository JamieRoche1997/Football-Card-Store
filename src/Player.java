//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------


//--------------------------------------------------
//
//	CLASS Item
//
//--------------------------------------------------
/**
 * This class models a player card of the store<br>.
 */
public class Player extends Item {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final int rating;
    private double cost;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Item<br>
     * @param _id - The ID of the player.
     * @param name - The name of the player.
     * @param age - The age of the player.
     * @param club - The club of the player.
     * @param country - The country of the player.
     * @param rating - The rating of the player.
     * @param cost - The cost of the player.
     */
    public Player(int _id,
                  String name,
                  int age,
                  String club,
                  String country,
                  int rating,
                  double cost
    ){

        // 1. We call to the item constructor, to initialise all fields except the one specific to players.
        super(_id,
                name,
                age,
                club,
                country
        );

        // 2. We initialise the remaining fields
        this.rating = rating;
        this.cost = cost;
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------
    public int getRating(){
        return this.rating;
    }

    public double getCost(){
        return this.cost;
    }

    public double setCost(double cost){
        return this.cost = cost;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------

    //---------------------------------------
    //	toString
    //---------------------------------------
    /**
     * Given a concrete player (this), the function overrides the method toString.<br>
     */
    public String toString(){
        // 1. We create the output variable
        String res;

        // 2. We append the player info
        res = "" + this.getId() + "\t" +
                this.getName() + "\t" +
                this.getAge() + "\t" +
                this.getClub() + "\t" +
                this.getCountry() + "\t";

        // 3. We print the player specific field
        res = res + this.getRating() + "\t";
        res = res + this.getCost() + "\n";

        // 4. We return res
        return res;
    }
}

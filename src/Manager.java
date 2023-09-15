//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------


//--------------------------------------------------
//
//	CLASS Item
//
//--------------------------------------------------
/**
 * This class models a manager card of the store<br>.
 */
public class Manager extends Item {

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
     * @param _id - The ID of the manager.
     * @param name - The name of the manager.
     * @param age - The age of the manager.
     * @param club - The club of the manager.
     * @param country - The country of the manager.
     * @param rating - The rating of the manager.
     * @param cost - The cost of the manager.
     */
    public Manager(int _id,
                   String name,
                   int age,
                   String club,
                   String country,
                   int rating,
                   double cost
    ){

        // 1. We call to the item constructor, to initialise all fields except the one specific to books.
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
     * Given a concrete manager (this), the function overrides the method toString.<br>
     */
    public String toString(){
        // 1. We create the output variable
        String res;

        // 2. We append the manager info
        res = "" + this.getId() + "\t" +
                this.getName() + "\t" +
                this.getAge() + "\t" +
                this.getClub() + "\t" +
                this.getCountry() + "\t";

        // 3. We print the manager specific fields
        res = res + this.rating + "\t";
        res = res + this.cost + "\n";

        // 4. We return res
        return res;
    }
}

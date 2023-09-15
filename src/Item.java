//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.util.ArrayList;

//--------------------------------------------------
//
//	ABSTRACT CLASS Item
//
//--------------------------------------------------
/**
 * This abstract class models an item of the store<br>.
 */
public abstract class Item extends Agent {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final String name;
    private final int age;
    private final String club;
    private final String country;
    private Purchase currentPurchased;


    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Item<br>
     * @param _id - The ID of the player/manager.
     * @param name - The name of the player/manager.
     * @param age - The age of the player/manager.
     * @param club - The club of the player/manager.
     * @param country - The country of the player/manager.
     */
    public Item(int _id,
                String name,
                int age,
                String club,
                String country
    ){

        // 1. We call to the agent constructor, to initialise the id and the purchaseHistory
        super(_id);

        // 2. We initialise the remaining fields
        this.name = name;
        this.age = age;
        this.club = club;
        this.country = country;

        // 3. The card is not purchased
        this.currentPurchased= null;
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------

    //---------------------------------------
    //	getName
    //---------------------------------------
    /**
     * Given a concrete card (this), the function returns its name.<br>
     * @return The name of the player/manager.
     */
    public String getName(){
        return this.name;
    }


    //---------------------------------------
    //	getAge
    //---------------------------------------
    /**
     * Given a concrete card (this), the function returns its age.<br>
     * @return The age of the player/manager.
     */
    public int getAge(){
        return this.age;
    }


    //---------------------------------------
    //	getClub
    //---------------------------------------
    /**
     * Given a concrete card (this), the function returns its club.<br>
     * @return The club of the player/manager.
     */
    public String getClub(){
        return this.club;
    }


    //---------------------------------------
    //	getCountry
    //---------------------------------------
    /**
     * Given a concrete card (this), the function returns its country.<br>
     * @return The country of the player/manager.
     */
    public String getCountry(){
        return this.country;
    }


    //---------------------------------------
    //	getCurrentPurchased
    //---------------------------------------
    /**
     * Given a concrete card (this), the function returns the purchase object it is associated to (null if not purchased).<br>
     * @return The purchase object it is associated to (null if not purchased).
     */
    public Purchase getCurrentPurchased(){ return this.currentPurchased; }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------

    //---------------------------------------
    //	setCurrentPurchased
    //---------------------------------------
    /**
     * Given a concrete card (this), the function updates its purchase object.<br>
     * @param _newPurchase - The new purchase object to be associated to the card.
     */
    public void setCurrentPurchased(Purchase _newPurchase){ this.currentPurchased = _newPurchase ; }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------

    public abstract int getRating();

    public abstract double getCost();

    //---------------------------------------
    //	isItemInItemsList
    //---------------------------------------
    /**
     * This method attempts to find it a card is in the itemsList<br>
     * @param id - The ID of the card.
     * @param myList - The list of cards that we are looking for.
     * @return The index in myList where the agent with ID is located at; (-1) if it is not in the list.
     */
    public static int isItemInItemsList(int id, ArrayList<Item> myList){
        // 1. We create the output variable
        int res = -1;

        // 2. We create the agent from the ID
        Agent baseline = new Agent(id);

        // 2. We search for the agent in the list
        int size = myList.size();
        int index = 0;

        // 3. If we found the itemID in the list, we assign its index to res
        while ((res == -1) && (index < size)){
            if (baseline.equals(myList.get(index)))
                res = index;
            else
                index++;
        }

        // 4. We return res
        return res;
    }
}

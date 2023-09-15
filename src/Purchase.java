//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------


//--------------------------------------------------
//
//	CLASS User
//
//--------------------------------------------------

import java.util.ArrayList;

/**
 * This class models a purchase for the store<br>.
 */
public class Purchase {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final int purchaseID;
    private final int userID;
    private final int itemID;
    private final int rating;
    private final double cost;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class User<br>
     * @param purchaseID - The ID of the purchase.
     * @param _userID - The ID of the customer.
     * @param _itemID - The ID of the card.
     * @param rating - The rating of the card.
     * @param cost - The cost of the card.
     */
    public Purchase(int purchaseID,
                    int _userID,
                    int _itemID,
                    int rating,
                    double cost
    ){

        // 1. We initialise the fields
        this.purchaseID = purchaseID;
        this.userID = _userID;
        this.itemID = _itemID;
        this.rating = rating;
        this.cost = cost;
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------

    //---------------------------------------
    //	getItemID
    //---------------------------------------
    /**
     * Given a concrete purchase (this), the function returns the ID of its card.<br>
     * @return The ID of the card.
     */
    public int getItemID(){
        return this.itemID;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------

    //---------------------------------------
    //	toString
    //---------------------------------------
    /**
     * Given a concrete purchase (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        // 1. We create the output variable
        String res;

        // 2. We append the purchase info
        res = "" + this.purchaseID + "\t" + this.userID + "\t" + this.itemID + "\t" + this.rating + "\t" + this.cost + "\n";

        // 3. We return res
        return res;
    }

    //---------------------------------------
    //	isItemInPurchasesList
    //---------------------------------------
    /**
     * This method attempts to find if a card is in the purchasesList<br>
     * @param id - The ID of the customer.
     * @param myList - The list of purchases where we are looking for.
     * @return The index in myList where the agent with ID is located at; (-1) if it is not in the list.
     */
    public static int isItemInPurchasesList(int id, ArrayList<Purchase> myList){
        // 1. We create the output variable
        int res = -1;

        // 2. We search for the item in the list
        int size = myList.size();
        int index = 0;

        // 3. If we found the itemID in the list, we assign its index to res
        while ((res == -1) && (index < size)){
            if (myList.get(index).getItemID() == id)
                res = index;
            else
                index++;
        }

        // 4. We return res
        return res;
    }
}

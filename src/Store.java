//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------


//--------------------------------------------------
//
//	INTERFACE Library
//
//--------------------------------------------------
/**
 * This is the main interface for the A03 Final Project,
 * representing the management of a store<br>.
 */
public interface Store {
    //---------------------------------------
    //	addUser
    //---------------------------------------
    /**
     * This method attempts to add a customer to the store<br>
     * @param _name - The name of the customer.
     * @return Whether the customer could be added or not.
     */
    int addUser(String _name);

    //---------------------------------------
    //	removeUser
    //---------------------------------------
    /**
     * This method attempts to remove a customer from the store<br>
     * @param _userID - The ID of the customer.
     * @return (-1) if customer does not exist; (-2) if not possible to remove as it has active purchases; 0 if removed.
     */
    int removeUser(int _userID);

    //---------------------------------------
    //	displayUserInfo
    //---------------------------------------
    /**
     * This method attempts to display the customer info on the screen<br>
     * @param _userID - The ID of the customer.
     */
    void displayUserInfo(int _userID);

    //---------------------------------------
    //	displayAllUserIDs
    //---------------------------------------
    /**
     * This method displays all customer IDs on the screen<br>
     */
    void displayAllUserIDs();


    //---------------------------------------
    //	addPlayer
    //---------------------------------------
    /**
     * This method attempts to add a player to the store<br>
     * @param name - The name of the player.
     * @param age - The age of the player.
     * @param club - The club of the player.
     * @param country - The country of the player.
     * @param rating - The rating of the player.
     * @param cost - The cost of the player.
     * @return The ID of the player created.
     */
    int addPlayer(String name,
                  int age,
                  String club,
                  String country,
                  int rating,
                  double cost
    );

    //---------------------------------------
    //	addManager
    //---------------------------------------
    /**
     * This method attempts to add a manager to the store<br>
     * @param name - The name of the manager.
     * @param age - The age of the manager.
     * @param club - The club of the manager.
     * @param country - The country of the manager.
     * @param rating - The rating of the manager.
     * @param cost - The cost of the manager.
     * @return The ID of the manager created.
     */
    int addManager(String name,
                   int age,
                   String club,
                   String country,
                   int rating,
                   double cost
    );

    //---------------------------------------
    //	removeItem
    //---------------------------------------
    /**
     * This method attempts to remove a card from the store<br>
     * @param _itemID - The ID of the card.
     * @return Whether the card could be removed or not.
     */
    boolean removeItem(int _itemID);

    //---------------------------------------
    //	displayItemInfo
    //---------------------------------------
    /**
     * This method attempts to display the card info on the screen<br>
     * @param _itemID - The ID of the card.
     */
    void displayItemInfo(int _itemID);

    //---------------------------------------
    //	displayAllItemIDs
    //---------------------------------------
    /**
     * This method displays all card IDs on the screen<br>
     */
    void displayAllItemIDs();

    double topUpBalance(int _userID, double balance);

    double withdrawBalance(int _userID, double balance);

    double showBalance(int _userID);

    double showCost(int _itemID);

    //---------------------------------------
    //	purchaseItem
    //---------------------------------------
    /**
     * This method attempts to purchase a card of the store<br>
     * @param _userID - The ID of the customer purchasing the card.
     * @param _itemID - The ID of the card to be purchased.
     * @return The ID of the purchase being performed (-1 if not possible to purchase).
     */
    int PurchaseItem(int _userID, int _itemID);

    //---------------------------------------
    //	returnItem
    //---------------------------------------
    /**
     * This method attempts to sell a card of the store<br>
     * @param _userID - The ID of the customer selling the card.
     * @param _itemID - The ID of the card to be sold.
     * @return Whether the card is successfully sold or not.
     */
    boolean returnItem(int _userID, int _itemID);

    //---------------------------------------
    //	loadContentFromDisk
    //---------------------------------------
    /**
     * This method attempts to load the customers, cards and purchases of the store from disk.<br>
     * @param usersFileName - The name of the database file for customers.
     * @param itemsFileName - The name of the database file for cards.
     * @return Whether the content is loaded or not.
     */
    boolean loadContentFromDisk(String usersFileName, String itemsFileName);


    //---------------------------------------
    //	saveContentToDisk
    //---------------------------------------
    /**
     * This method attempts to save the customers, cards and purchases of the store to disk.<br>
     * @param usersFileName - The name of the database file for customers.
     * @param itemsFileName - The name of the database file for cards.
     * @return Whether the content is saved or not.
     */
    boolean saveContentToDisk(String usersFileName, String itemsFileName);

}

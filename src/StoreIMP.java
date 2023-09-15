//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------
//
//	CLASS StoreIMP
//
//--------------------------------------------------
/**
 * This class implements the interface Store of the A03 Final Project,
 * representing the management of a store<br>.
 * We make the class final, to avoid any further class specialising it more.
 */
public final class StoreIMP implements Store {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final ArrayList<User> usersList;
    private final ArrayList<Item> itemsList;
    private static int nextId = 1;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class StoreIMP<br>
     */
    public StoreIMP(){

        // 1. We assume the story does not have any customers or cards
        this.usersList = new ArrayList<>();
        this.itemsList = new ArrayList<>();
    }

    //---------------------------------------
    //	addUser
    //---------------------------------------
    /**
     * This method attempts to add a customer to the store<br>
     * @param _name - The name of the customer.
     * @return The ID of the customer created.
     */
    public int addUser(String _name){
        // 1. We create the output variable
        int res = StoreIMP.nextId;

        // 2. We create the new user object
        double balance = 0;
        User newUser = new User(res,
                _name,
                balance
        );

        // 3. We add it to the users list
        this.usersList.add(newUser);

        // 4. We increase the static variable of the class
        StoreIMP.nextId++;

        // 5. We return res
        return res;
    }

    //---------------------------------------
    //	removeUser
    //---------------------------------------
    /**
     * This method attempts to remove a customer from the store<br>
     * @param _userID - The ID of the customer.
     * @return (-1) if customer does not exist; (-2) if not possible to remove as it has active purchases; 0 if removed.
     */
    public int removeUser(int _userID){
        // 1. We create the output variable
        int res = -1;

        // 2. We search for the userID in the usersList
        int index = User.isUserInUsersList(_userID, this.usersList);

        // 3. If the index is not -1
        if (index != -1){
            // 3.1. We check the pending purchases of the user
            User myUser = this.usersList.get(index);
            int size = myUser.getActivePurchases().size();

            // 3.2. If there are no pending purchases, we remove the user
            if (size == 0){
                res = 0;
                this.usersList.remove(index);
            }

            // 3.3. Otherwise, we flag that there are pending purchases
            else{
                res = -2;
            }
        }

        // 4. We return res
        return res;
    }

    //---------------------------------------
    //	displayUserInfo
    //---------------------------------------
    /**
     * This method attempts to display the customer info on the screen<br>
     * @param _userID - The ID of the customer.
     */
    public void displayUserInfo(int _userID){
        // 1. We search for the userID in the usersList
        int index = User.isUserInUsersList(_userID, this.usersList);

        // 2. If the index is not -1
        if (index != -1){
            // 2.1. We get the customer
            User myUser = this.usersList.get(index);

            // 2.2. We get the info
            String info = myUser.toString();

            // 2.3. We print the info
            System.out.println(info);
        }

        // 3. Otherwise, we inform that the customer ID is not registered
        else
            System.out.println("Sorry, no customer is registered with ID: " + _userID + ", so the remove operation cannot proceed.");
    }

    //---------------------------------------
    //	displayAllUserIDs
    //---------------------------------------
    /**
     * This method displays all customer IDs on the screen<br>
     */
    public void displayAllUserIDs(){
        System.out.println("---------------\n  Customer IDs\n---------------");
        for (User aux : this.usersList) {
            System.out.println(aux.getId());
        }
    }

    //---------------------------------------
    //	addPlayer
    //---------------------------------------
    /**
     * This method attempts to add a user to the library<br>
     * @param name - The name of the player.
     * @param age - The age of the player.
     * @param club - The club of the player.
     * @param country - The country of the player.
     * @param rating - The rating of the player.
     * @param cost - The cost of the player.
     * @return The ID of the player created.
     */
    public int addPlayer(String name,
                         int age,
                         String club,
                         String country,
                         int rating,
                         double cost
    ){

        // 1. We create the output variable
        int res = StoreIMP.nextId;

        // 2. We create the new player object
        Player newPlayer = new Player(res,
                name,
                age,
                club,
                country,
                rating,
                cost
        );

        // 3. We add it to the store list
        this.itemsList.add(newPlayer);

        // 4. We increase the static variable of the class
        StoreIMP.nextId++;

        // 5. We return res
        return res;
    }


    //---------------------------------------
    //	addManager
    //---------------------------------------
    /**
     * This method attempts to add a user to the library<br>
     * @param name - The name of the manager.
     * @param age - The age of the manager.
     * @param club - The club of the manager.
     * @param country - The country of the manager.
     * @param rating - The rating of the manager.
     * @return The ID of the manager created.
     */
    public int addManager(String name,
                          int age,
                          String club,
                          String country,
                          int rating,
                          double cost
    ){

        // 1. We create the output variable
        int res = StoreIMP.nextId;

        // 2. We create the new manager object
        Manager newManager = new Manager(res,
                name,
                age,
                club,
                country,
                rating,
                cost
        );

        // 3. We add it to the store list
        this.itemsList.add(newManager);

        // 4. We increase the static variable of the class
        StoreIMP.nextId++;

        // 5. We return res
        return res;
    }

    //---------------------------------------
    //	removeItem
    //---------------------------------------
    /**
     * This method attempts to remove a card from the store<br>
     * @param _itemID - The ID of the card.
     * @return Whether the card could be removed or not.
     */
    public boolean removeItem(int _itemID){
        // 1. We create the output variable
        boolean res = false;

        // 1. We search for the userID in the usersList
        int index = Item.isItemInItemsList(_itemID, this.itemsList);

        // 3. If the index is not -1
        if (index != -1){
            res = true;
            this.itemsList.remove(index);
        }

        // 4. We return res
        return res;
    }

    //---------------------------------------
    //	displayItemInfo
    //---------------------------------------
    /**
     * This method attempts to display the card info on the screen<br>
     * @param _itemID - The ID of the card.
     */
    public void displayItemInfo(int _itemID){
        // 1. We search for the itemID in the itemsList
        int index = Item.isItemInItemsList(_itemID, this.itemsList);

        // 2. If the index is not -1
        if (index != -1){
            // 2.1. We get the user
            Item myItem = this.itemsList.get(index);

            // 2.2. We get the info
            String info = myItem.toString();

            // 2.3. We print the info
            System.out.println(info);
        }

        // 3. Otherwise, we inform that the card ID is not registered
        else
            System.out.println("Sorry, no card is registered with ID: " + _itemID + ", so the remove operation cannot proceed.");
    }

    //---------------------------------------
    //	displayAllItemIDs
    //---------------------------------------
    /**
     * This method displays all card IDs on the screen<br>
     */
    public void displayAllItemIDs(){
        System.out.println("---------------\n  Card IDs\n---------------");
        for (Item aux : this.itemsList) {
            System.out.println(aux.getId());
        }
    }

    public double topUpBalance(int _userID, double balance){
        double res;
        int userIndex = User.isUserInUsersList(_userID, this.usersList);
        if (userIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _userID + ", in the UsersList");

        User myUser = this.usersList.get(userIndex);

        res = myUser.getBalance();
        res += balance;

        res = myUser.setBalance(res);

        return res;
    }

    public double withdrawBalance(int _userID, double balance){
        double res;
        int userIndex = User.isUserInUsersList(_userID, this.usersList);
        if (userIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _userID + ", in the UsersList");

        User myUser = this.usersList.get(userIndex);

        res = myUser.getBalance();
        res -= balance;

        res = myUser.setBalance(res);

        return res;
    }

    public double showBalance(int _userID){
        double res;
        int userIndex = User.isUserInUsersList(_userID, this.usersList);
        if (userIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _userID + ", in the UsersList");

        User myUser = this.usersList.get(userIndex);

        res = myUser.getBalance();

        return res;
    }

    public double showCost(int _itemID){
        double res;
        int itemIndex = Item.isItemInItemsList(_itemID, this.itemsList);
        if (itemIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _itemID + ", in the UsersList");

        Item myItem = this.itemsList.get(itemIndex);

        res = myItem.getCost();

        return res;
    }

    //---------------------------------------
    //	purchaseItem
    //---------------------------------------
    /**
     * This method attempts to purchase an item of the library<br>
     * @param _userID - The ID of the customer purchasing the card.
     * @param _itemID - The ID of the card to be purchased.
     * @return The ID of the purchase being performed (-1 if not possible to purchase).
     */
    public int PurchaseItem(int _userID, int _itemID){
        // 1. We create the output variable
        int res = -1;

        // 2. We get the index of the customer and the card in userList and itemsList
        int userIndex = User.isUserInUsersList(_userID, this.usersList);
        if (userIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _userID + ", in the UsersList");

        int itemIndex = Item.isItemInItemsList(_itemID, this.itemsList);
        if (itemIndex == -1)
            System.out.println("Sorry, there is no card with ID: " + _itemID + ", in the ItemsList");

        // 3. If both customer and card exist, we need to ensure that:
        //    (a) the customer can still purchase more items,
        //    (b) the card is available
        if ((userIndex >= 0) && (itemIndex >= 0)){
            // 3.1. We access to the user and item
            User myUser = this.usersList.get(userIndex);
            Item myItem = this.itemsList.get(itemIndex);

            // 3.2. We check that the card is not purchased
            Purchase itemPurchaseObject = myItem.getCurrentPurchased();

            // 3.3. If the conditions are met, we proceed to purchase the card
            if (itemPurchaseObject == null)
                res = auxPurchaseItem(myUser, myItem);
            else
                System.out.println("Sorry, the card with ID: " + _itemID + ", is already purchased.");
        }
        // 4. We return res
        return res;
    }

    //---------------------------------------
    //	auxPurchaseItem
    //---------------------------------------
    /**
     * This method proceeds with the purchasing of the card<br>
     * @param myUser - The customer purchasing the card.
     * @param myItem - The card to be purchased.
     * @return The ID of the purchase being performed.
     */
    private int auxPurchaseItem(User myUser, Item myItem) {
        // 1. We create the output variable
        int res = StoreIMP.nextId;

        // 2. We update the ID
        StoreIMP.nextId++;

        // 3. We get the rating and cost of the card
        int rating = myItem.getRating();
        double cost = myItem.getCost();

        // 4. We create the purchase object
        Purchase myPurchase = new Purchase(res,
                myUser.getId(),
                myItem.getId(),
                rating,
                cost
        );

        // 5. We update the customer by adding the purchase to its active purchases
        myUser.getActivePurchases().add(myPurchase);

        double balance = myUser.getBalance();
        balance -= cost;
        myUser.setBalance(balance);

        // 6. We update the card by setting the purchase as its active purchase
        myItem.setCurrentPurchased(myPurchase);

        // 7. We return res
        return res;
    }

    //---------------------------------------
    //	returnItem
    //---------------------------------------
    /**
     * This method attempts to sell a card of the store<br>
     * @param _userID - The ID of the customer selling the card.
     * @param _itemID - The ID of the card to be sold.
     * @return Whether the card is successfully sold or not.
     */
    public boolean returnItem(int _userID, int _itemID){
        // 1. We create the output variable
        boolean res = false;

        // 2. We get the index of the customer and the card in userList and itemsList
        int userIndex = User.isUserInUsersList(_userID, this.usersList);
        if (userIndex == -1)
            System.out.println("Sorry, there is no customer with ID: " + _userID + ", in the UsersList");

        int itemIndex = Item.isItemInItemsList(_itemID, this.itemsList);
        if (itemIndex == -1)
            System.out.println("Sorry, there is no card with ID: " + _itemID + ", in the ItemsList");

        // 3. If both customer and card exist, we need to ensure that the customer is purchasing the card
        if ((userIndex >= 0) && (itemIndex >= 0)){
            // 3.1. We access to the customer and card
            User myUser = this.usersList.get(userIndex);
            Item myItem = this.itemsList.get(itemIndex);

            // 3.2. We search for the customer in its purchases list
            ArrayList<Purchase> purchaseList = myUser.getActivePurchases();
            int index = Purchase.isItemInPurchasesList(_itemID, purchaseList);

            // 3.3. If the conditions are met, we proceed to sell the card
            if (index != -1) {
                // I. We set res to true
                res = true;

                double balance = myUser.getBalance();
                balance += myItem.getCost();
                myUser.setBalance(balance);
                // II. We remove the purchase from the customer
                purchaseList.remove(index);

                // III. We set the card to not sold
                myItem.setCurrentPurchased(null);
            }
            else
                System.out.println("Sorry, the customer with ID: " + _userID + ", was not purchasing the item with ID: " + _itemID + ".");
        }

        // 4. We return res
        return res;
    }

    //---------------------------------------
    //	loadContentFromDisk
    //---------------------------------------
    /**
     * This method attempts to load the customers, cards and purchases of the store from disk.<br>
     * @param usersFileName - The name of the database file for customers.
     * @param itemsFileName - The name of the database file for cards.
     * @return Whether the content is loaded or not.
     */
    public boolean loadContentFromDisk(String usersFileName,
                                       String itemsFileName
    ){
        return ((this.loadUsersFromDisk(usersFileName)) &&
                (this.loadItemsFromDisk(itemsFileName))
        );
    }

    //---------------------------------------
    //	loadUsersFromDisk
    //---------------------------------------
    /**
     * This method attempts to load the customers from disk.<br>
     * @param usersFileName - The name of the database file for customers.
     */
    private boolean loadUsersFromDisk(String usersFileName){
        // 1. We create the output variable
        boolean res = false;

        try {
            // 1. We create the file variable
            File my_file = new File(usersFileName);
            Scanner sc = new Scanner(my_file);

            // 2. If the file is not empty
            if (sc.hasNext()){
                // 2.1. We get the number of customers
                int usersSize = sc.nextInt();

                // 2.2. We parse each of the customer objects
                for (int userIndex = 0; userIndex < usersSize; userIndex++){
                    // 2.2.1. We read the values for the object
                    int _id = sc.nextInt();
                    String _name = sc.next();


                    // 2.2.2. We create the object
                    double balance = 0;
                    User myUser = new User(_id,
                            _name,
                            balance
                    );

                    // 2.2.3. We read how many active purchases
                    int numPurchases = sc.nextInt();

                    // 2.2.4. If the ID is bigger than the existing one, we update it
                    if (_id >= StoreIMP.nextId)
                        StoreIMP.nextId = _id + 1;

                    // 2.2.5. For each purchase, we read it
                    for (int purchaseIndex = 0; purchaseIndex < numPurchases; purchaseIndex++){
                        // I. We read the values for the object
                        int _purchaseID = sc.nextInt();
                        int _userID = sc.nextInt();
                        int _itemID = sc.nextInt();
                        int rating = sc.nextInt();
                        double cost = sc.nextInt();

                        // II. We create the object
                        Purchase myPurchase = new Purchase(_purchaseID,
                                _userID,
                                _itemID,
                                rating,
                                cost
                        );

                        // III. We append the object to the list
                        myUser.getActivePurchases().add(myPurchase);

                        // IV. If the ID is bigger than the existing one, we update it
                        if (_purchaseID >= StoreIMP.nextId)
                            StoreIMP.nextId = _purchaseID + 1;
                    }

                    // 2.2.6. We append the object to the list
                    this.usersList.add(myUser);
                }
            }

            //3. We close the scanner
            sc.close();

            // 4. We set res to true
            res = true;
        }
        catch (Exception e) {
            System.out.println("Sorry but there is not such file");
        }

        // We return res
        return res;
    }

    //---------------------------------------
    //	loadItemsFromDisk
    //---------------------------------------
    /**
     * This method attempts to load the cards from disk.<br>
     * @param itemsFileName - The name of the database file for cards.
     */
    private boolean loadItemsFromDisk(String itemsFileName){
        // 1. We create the output variable
        boolean res = false;

        try {
            // 1. We create the file variable
            File my_file = new File(itemsFileName);
            Scanner sc = new Scanner(my_file);

            // 2. If the file is not empty
            if (sc.hasNext()){
                // 2.1. We get the number of users
                int itemsSize = sc.nextInt();

                // 2.2. We parse each of the card objects
                for (int itemIndex = 0; itemIndex < itemsSize; itemIndex++){
                    // 2.2.1. We read the values for the object
                    int _id = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    String club = sc.next();
                    String country = sc.next();
                    int rating;
                    double cost = 0;

                    // 2.2.2. We get the type of object based on the last parameter
                    Item myItem;
                    if (sc.hasNextInt()){
                        // I. We read the number of pages
                        rating = sc.nextInt();

                        // II. We create the object
                        myItem = new Player(_id,
                                name,
                                age,
                                club,
                                country,
                                rating,
                                cost
                        );
                    }
                    else{
                        // I. We read the number of pages
                        rating = sc.nextInt();

                        // II. We create the object
                        myItem = new Manager(_id,
                                name,
                                age,
                                club,
                                country,
                                rating,
                                cost
                        );
                    }

                    // 2.2.3. If the ID is bigger than the existing one, we update it
                    if (_id >= StoreIMP.nextId)
                        StoreIMP.nextId = _id + 1;

                    // 2.2.4. We find the info of the purchasing

                    if (sc.hasNextInt()){
                        // I. We read the values for the object
                        sc.nextInt();
                        int _userID = sc.nextInt();
                        int _itemID = sc.nextInt();
                        sc.nextInt();

                        // II. We look for the index of userID
                        int userIndex = User.isUserInUsersList(_userID, this.usersList);
                        User myUser = this.usersList.get(userIndex);

                        // III. We look for the index of purchaseID
                        ArrayList<Purchase> purchaseList = myUser.getActivePurchases();
                        int purchaseIndex = Purchase.isItemInPurchasesList(_itemID, purchaseList);

                        // IV. We get the purchase object
                        Purchase myPurchase = purchaseList.get(purchaseIndex);

                        // V. We associate the purchase object to the card
                        myItem.setCurrentPurchased(myPurchase);
                    }
                    else{
                        // I. If the purchasing was null, we just consume the card
                        sc.next();
                    }

                    // 2.2.5. We add the card to the list
                    this.itemsList.add(myItem);
                }
            }

            //3. We close the scanner
            sc.close();

            // 4. We set res to true
            res = true;
        }
        catch (Exception e) {
            System.out.println("Sorry but there is not such file");
        }

        // We return res
        return res;
    }

    //---------------------------------------
    //	saveContentToDisk
    //---------------------------------------
    /**
     * This method attempts to save the customers, cards and purchases of the store to disk.<br>
     * @param usersFileName - The name of the database file for customers.
     * @param itemsFileName - The name of the database file for cards.
     * @return Whether the content is saved or not.
     */
    public boolean saveContentToDisk(String usersFileName,
                                     String itemsFileName
    ) {

        // 1. We create the output variable
        boolean res = false;

        // 2. We create the print writers objects
        PrintWriter usersWriter;
        PrintWriter itemsWriter;

        // 3. We try to save the content
        try {
            //3.1. We open the files for writing
            usersWriter = new PrintWriter(usersFileName, StandardCharsets.UTF_8);
            itemsWriter = new PrintWriter(itemsFileName, StandardCharsets.UTF_8);

            //3.2. We print the info from the customers
            int size = this.usersList.size();
            usersWriter.println(size);
            for (int index = 0; index < size; index++){
                User myUser = this.usersList.get(index);
                String content = myUser.toString();
                usersWriter.print(content);
            }

            //3.3. We print the info from the cards
            size = this.itemsList.size();
            itemsWriter.println(size);
            for (int index = 0; index < size; index++){
                Item myItem = this.itemsList.get(index);
                String content = myItem.toString();
                itemsWriter.print(content);
            }

            //3.4. We close the files
            usersWriter.close();
            itemsWriter.close();

            // 3.5. We mark the operation as completed
            res = true;
        }

        // 4. We capture any exception happening
        catch (Exception e) {
            System.out.println("Sorry but the file cannot be created for writing to it");
        }

        // 5. We return res
        return res;
    }


}


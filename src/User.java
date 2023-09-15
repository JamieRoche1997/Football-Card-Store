//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.util.ArrayList;

//--------------------------------------------------
//
//	CLASS User
//
//--------------------------------------------------
/**
 * This class models a customer of the store<br>.
 */
public class User extends Agent {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final String name;
    private final ArrayList<Purchase> activePurchases;
    private double balance;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class User<br>
     * @param _id - The ID of the customer.
     * @param _name - The name of the customer.
     * @param balance - The balance (€) of the customer.
     */
    public User(int _id,
                String _name,
                double balance
    ){

        // 1. We call to the agent, to initialise the ID and the purchaseHistory
        super(_id);

        // 2. We initialise the remaining fields
        this.name = _name;

        // 3. The new customer has not purchased any card yet.
        this.activePurchases = new ArrayList<>();
        this.balance = balance;
    }

    //---------------------------------------
    //	getActivePurchases
    //---------------------------------------
    /**
     * Given a concrete customer (this), the function returns the active purchases of the customer.<br>
     * @return The active purchases of the user.
     */
    public ArrayList<Purchase> getActivePurchases(){
        return this.activePurchases;
    }

    public double getBalance(){
        return this.balance;
    }

    public double setBalance(double balance){
        return this.balance = balance;
    }

    //---------------------------------------
    //	toString
    //---------------------------------------
    /**
     * Given a concrete customer (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        // 1. We create the output variable
        StringBuilder res;

        // 2. We append the customer info
        res = new StringBuilder("" + this.getId() + "\t" + this.name + "\t" + this.balance + "\n");

        int size = this.activePurchases.size();
        res.append(size).append("\n");
        for (Purchase activePurchase : this.activePurchases) {
            res.append(activePurchase.toString());
        }

        // 3. We return res
        return res.toString();
    }

    //---------------------------------------
    //	isUserInUsersList
    //---------------------------------------
    /**
     * This method attempts to find if a customer is in the usersList<br>
     * @param id - The ID of the customer.
     * @param myList - The list of customers that we are looking for.
     * @return The index in myList where the agent with ID is located at; (-1) if it is not in the list.
     */
    public static int isUserInUsersList(int id, ArrayList<User> myList){
        // 1. We create the output variable
        int res = -1;

        // 2. We create the agent from the ID
        Agent baseline = new Agent(id);

        // 3. We search for the agent in the list
        int size = myList.size();
        int index = 0;

        // 4. If we found the customer ID in the list, we assign its index to res
        while ((res == -1) && (index < size)){
            if (baseline.equals(myList.get(index)))
                res = index;
            else
                index++;
        }

        // 5. We return res
        return res;
    }
}

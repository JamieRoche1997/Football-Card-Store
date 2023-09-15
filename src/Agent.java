//--------------------------------------------------
//
// CLASS Agent
//
//--------------------------------------------------
/**
 * Our superclass for the A03 Final Project
 * representing all the agents (customers and cards)
 * for managing the store <br>.
 */
public class Agent {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private final int id;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Agent<br>
     * @param _id - The ID of the agent.
     */
    public Agent(int _id) {
        // 1. We initialise the fields
        this.id = _id;
    }

    //---------------------------------------
    //	getId
    //---------------------------------------
    /**
     * Given a concrete agent (this), the function returns its ID.<br>
     * We make the method final, to avoid the subclasses to override it.
     * @return The ID of the agent.
     */
    public final int getId(){
        return this.id;
    }

    //---------------------------------------
    //	equals
    //---------------------------------------
    /**
     * Given a concrete agent (this), the function overrides the Object method equals.<br>
     * @param o - The other agent we want to compare 'this' to.
     * @return - Whether 'this' and 'o' are equal.
     */
    public boolean equals(Agent o) {
        return this.id == o.id;
    }
}

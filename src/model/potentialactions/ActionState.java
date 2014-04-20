package model.potentialactions;

/**
 * Created by Baker on 4/14/2014.
 */
public enum ActionState {
    Valid(true), Invalid(false), Empty(null);

    private Boolean value;

    private ActionState(Boolean value){
        this.value = value;
    }

    public static ActionState fromValue(Boolean value){
        if(value){
            return Valid;
        }
        if(!value){
            return Invalid;
        }
        else{
            return Empty;
        }
    }

}

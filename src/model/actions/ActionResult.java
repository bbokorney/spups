package model.actions;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class ActionResult {

    boolean success;
    int famePoints;
    int actionPoints;
    String message;

    public ActionResult(boolean s, int fp, int ap, String m){
        success = s;
        famePoints = fp;
        actionPoints = ap;
        message = m;
    }


    /*      Getters     */

    public boolean isSuccess(){
        return success;
    }

    public int getFamePoints(){
        return famePoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public String getMessage() {
        return message;
    }


    /*      Setters     */
    /*  these may be unnecessary */

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setFamePoints(int famePoints) {
        this.famePoints = famePoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

package model.actions.serialization;

import model.board.Location;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class Json {

    public Json(String serial){
        //todo
    }

    public static String wrapObject(String members){
    	return "{\n" + members + "\n}";
	}

    public static String wrapArray(String elements){
    	return String.format("[%s]", elements);
	}

    public static String wrapPair(String name, String value){
    	return String.format("\"%s\" : %s", name, value);
	}

    public static String wrapValue(String value){
    	return String.format("\"%s\"", value);
	}

    public static String wrapElements(String... elements){
    	StringBuilder ret = new StringBuilder();
		for(int x = 0; x < elements.length; ++x)
			ret.append(elements[x] + "\n");
		return ret.toString();
	}

    public static String wrapMembers(String... members){
    	StringBuilder ret = new StringBuilder();
		for(String member : members) 
			ret.append(member + "\n");
		return ret.toString();
	}

    public static String serializeCollection (@SuppressWarnings("rawtypes") Serializable[] objs){
        //todo
        return "";
    }



}

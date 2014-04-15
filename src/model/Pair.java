package model;

/**
 * Created by idinamenzel on 4/15/14.
 */
public class Pair<F, S> {

    F first;
    S second;

    public Pair(){

    }

    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public Pair<F,S> setFirst(F first){
        this.first = first;
        return this;
    }

    public Pair<F,S> setSecond(S second){
        this.second = second;
        return this;
    }

    public F getFirst(){
        return first;
    }

    public S getSecond(){
        return second;
    }

}

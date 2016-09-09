package co.brighterbrain.mvcpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by User on 8/30/2016.
 */
public class Model extends Observable {

    private List<Integer> mList;
    
    Observable o;

    public Model(){
        mList = new ArrayList<Integer>(3);
        mList.add(0, 0);
        mList.add(1, 0);
        mList.add(2, 0);
    }

    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{

        return mList.get(the_index);
    }

    public  int setValueAtIndex(final int the_index)throws IndexOutOfBoundsException{

        mList.set(the_index,mList.get(the_index)+1);
        setChanged();
        notifyObservers();
        return mList.get(the_index);


    }

    public  void setObserver(Observable o) {
        if (o instanceof Observable){
            this.o=o;
        }else{
            throw new RuntimeException("observable");
        }
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        if(o!= null){}
    }


}

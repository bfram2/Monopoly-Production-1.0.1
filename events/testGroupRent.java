package events;
import tile.*;

public class testGroupRent {
public boolean testGroupRent(Properties holder, Properties [] array){
        int i = 0;
        Properties test1 = null; 
        Properties test2 = null; 
        Properties test3 = null;

        int groupNumber = holder.getGroup();
        while(i < array.length){
            while(test1 != null){
                if(array[i].getGroup() == groupNumber){
                    test1 = array[i];
                    }
                    i++;
                }
            }
            while(test2 != null){
                if(array[i].getGroup() == groupNumber){
                    test2 = array[i];
                    }
                    i++;
                }
            if(groupNumber == 1 || groupNumber == 8){
                if(test1 != null && test2 != null) {
                        if(test1.getOwner() == test2.getOwner() || test1.getOwner() == holder.getOwner()) {
                                return true;
                            }
                        }
                    }
                
            while(test3 != null){
                if(array[i].getGroup() == groupNumber){
                    test3 = array [i];
                    if(test1 != null && test2 != null && test3 != null) {
                                if(test1.getOwner() == test2.getOwner()){
                                    if(test2.getOwner() == test3.getOwner()){
                                        if(test1.getOwner() == holder.getOwner()){
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                	i++;
                    }
            return false;
    }
}
package Models;

import java.util.Comparator;

public class SortDateComparator implements Comparator<Match>{
    @Override
    public int compare(Match o1, Match o2) {
        int value;
        value = o1.getDates().getYear() - o2.getDates().getYear();
        if (value == 0)
            value = o1.getDates().getMonth() - o2.getDates().getMonth();
        if (value == 0)
            value = o1.getDates().getDay() - o2.getDates().getDay();

        return value;


    }

}
package Locationbased.Recommendation.System.Neo4j.commons;

import java.util.ArrayList;
import java.util.List;

public class CommonFunction {

    public static List<?> getDifference(List<?> list1, List<?> list2) {
        List<Object> difference = new ArrayList<>();

        for (Object element : list1) {
            if (!list2.contains(element)) {
                difference.add(element);
            }
        }

        return difference;
    }
}

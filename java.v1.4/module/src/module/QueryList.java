package module;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> item) {
        this.items = item;
    }
    public static  <S extends QueryItem>List<S> getMatches(List<S> item, String field, String value) {
        List<S> matches = new ArrayList<>();
        for (var items : item) {
            if (items.matchFieldValue(field, value)) {
                matches.add(items);
            }
        }
        return matches;
    }
    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var element : items) {
            if (element.matchFieldValue(field, value)) {
                matches.add(element);
            }
        }
        return matches;
    }
}

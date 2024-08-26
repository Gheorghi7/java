package pack_3;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> {
	private List<T> items;

	public QueryList(List<T> items) {
		this.items = items;
	}
	
	public static <T extends QueryItem> List<T> getMatchs(List<T> items, String field, String value){
		List<T> matches = new ArrayList<>();
		for(var item: items) {
			if(item.matchFieldValue(field, value)) {
				matches.add(item);
			}
		}
		return matches;
	}
	
	public List<T> getMatchs(String field, String value){
		List<T> matches = new ArrayList<>();
		for(var item: items) {
			if(item.matchFieldValue(field, value)) {
				matches.add(item);
			}
		}
		return matches;
	}
}

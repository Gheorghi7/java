package pack_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MaopViewsMain {
	public static void main(String[] args) {
	Map<String, Contact> contacts = new HashMap<>();
	ContactData.getData("phone").forEach(c->contacts.put(c.getName(), c));
	ContactData.getData("email").forEach(c->contacts.put(c.getName(), c));
	
	Set<String> keysView = contacts.keySet();
	System.out.println(keysView);
	
	Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
	System.out.println(copyOfKeys);
	
	var values = contacts.values();
	values.forEach(System.out::println);
	System.out.println("-----------------------------------------------");
	List<Contact> list = new ArrayList<>(values);
	list.sort(Comparator.comparing(Contact::getName));
	list.forEach(c -> System.out.println(c.getName()+" : "+c));
	System.out.println("-----------------------------------------------");
	
	Contact first = list.get(0);
	contacts.put(first.getName(), first);
	
	var nodeSet = contacts.entrySet();
	for(var node: nodeSet) {
		System.out.println(nodeSet.getClass().getName());
		nodeSet.getClass().getName();
		if(!node.getKey().equals(node.getValue().getName())) {
			System.out.println(node.getClass().getName());
			System.out.println("Key doesn`t match name: "+ node.getKey()+":"+node.getValue());
		}
	}
	
	}
}

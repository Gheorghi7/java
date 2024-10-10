package pack_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
	public static void main(String[] args) {
		List<Contact> phones = ContactData.getData("phone");
		List<Contact> emails = ContactData.getData("email");
		
		
		List<Contact> fullList = new ArrayList<>(phones);
		fullList.addAll(emails);
		fullList.forEach(System.out::println);
		System.out.println("----------------------------------------");
		Map<String, Contact> contacts = new HashMap<>();
		
		for(Contact contact: fullList) {
			contacts.put(contact.getName(), contact);
		}
		
		contacts.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
		System.out.println("----------------------------------------");
		System.out.println(contacts.get("Charlie Brown"));
		
		Contact defaultValue = new Contact("Chuck Brown");
		System.out.println(contacts.getOrDefault("Chuck Brown", defaultValue));
		System.out.println("----------------------------------------");
		contacts.clear();
		
		for( Contact contact: fullList) {
			Contact duplicate = contacts.put(contact.getName(), contact); 
			if(duplicate != null) {
//				System.out.println("Duplicate= "+ duplicate);
//				System.out.println("current= "+contact);
				contacts.put(contact.getName(), contact.mergeContactData(duplicate));
			}
		}
		contacts.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
		System.out.println("----------------------------------------");
		contacts.clear();
		for( Contact contact: fullList) {
			Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
			if(duplicate != null) {
				contacts.put(contact.getName(), contact.mergeContactData(duplicate));
			}
			}
		contacts.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
		System.out.println("----------------------------------------");
		
		contacts.clear();
		
		fullList.forEach(contact -> contacts.merge(contact.getName(), contact, Contact::mergeContactData));
		contacts.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
	
		System.out.println("--------------------------------------------------");
		for(String contactName: new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
			contacts.computeIfAbsent(contactName, k -> new Contact(k)); 
		contacts.forEach((k, v) -> System.out.println("key="+ k + " value="+v));
		}
		System.out.println("--------------------------------------------------");
		for(String contactName1: new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
			contacts.computeIfPresent(contactName1, (k, v) -> {
				v.addEmail("Fun place"); return v;
			}); 
			}
		contacts.forEach((k, v) -> System.out.println("key="+ k + " value="+v));
		
		System.out.println("----------------------------------------------------");
		
		contacts.replaceAll((k, v) -> {
			String newEmail = k.replaceAll(" ", "")+ "@funplace.com";
			v.replaceEmailIfExist("DDuck@funplace.com", newEmail); 
			return v;
			});
		contacts.forEach((k, v) -> System.out.println("key= "+k+" value= "+v));
		System.out.println("----------------------------------------------------");
		Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com"); 
		
		Contact replacedContact = contacts.replace("Daisy Duck", daisy); 
		
		System.out.println("daisy "+daisy );
		System.out.println("Replace Contact "+replacedContact );
		contacts.forEach((k, v) -> System.out.println("key= "+k+" value= "+v));
		System.out.println("----------------------------------------------------");
		
		Contact updateDaisy = replacedContact.mergeContactData(daisy); 
		
		System.out.println("updatedDaisy "+ updateDaisy);
		boolean success = contacts.replace("Daisy Duck", daisy, updateDaisy); 
		if(success) {
			System.out.println("Success");
		}else {
			System.out.printf("Did not mutch on both key: %s and value: %s%n", "Daisy Duck", replacedContact);
		}
		contacts.forEach((k, v) -> System.out.println("key= "+k+" value= "+v));
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
	}



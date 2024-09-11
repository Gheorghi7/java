package pack_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		List<Contact> email = ContactData.getData("email"); 
		List<Contact> phone = ContactData.getData("phone"); 
		printData("Email data: ", email);
		printData("Phone data: ", phone);
		
		Set<Contact> emailContact = new HashSet<>(email);
		Set<Contact> phoneContact = new HashSet<>(phone);
		
		printData("Phone Contact " , phoneContact);
		printData("Email Contact " , emailContact);
		
		int index  = email.indexOf(new Contact("Robin Hood" ));
		Contact robinHood = email.get(index);
		robinHood.addEmail("Sherwood forest");
		robinHood.addEmail("Sherwood forest");
		System.out.println(robinHood);
		
		Set<Contact> unionAB = new HashSet<>(); 
		unionAB.addAll(phoneContact);
		unionAB.addAll(emailContact);
		
		printData("(A \u222A B) Union of emails (A) with phones (B) ", unionAB);
		
		Set<Contact> intersectAB = new HashSet<>(emailContact);
		intersectAB.retainAll(phoneContact);
		printData("(A \u2229 B) Inspect emails (A) and phones (B)", intersectAB);
		
		Set<Contact> intersectBA= new HashSet<>(phoneContact);
		intersectBA.retainAll(emailContact);
		printData("(B \u2229 A) Inspect phones (B) and email (A)", intersectBA);
		
		
		Set<Contact> AMinusB= new HashSet<>(emailContact);
		AMinusB.removeAll(phoneContact);
		printData("(A - B) email (A) - phone (B)", AMinusB);
		
		Set<Contact> BMinusA= new HashSet<>(phoneContact);
		BMinusA.removeAll(emailContact);
		printData("(B - A) phone (B) - email (A)", BMinusA);
	
		Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
		symmetricDiff.addAll(BMinusA);
		printData("Symmetric difference: phone and email", symmetricDiff);
		
		Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
		symmetricDiff2.removeAll(intersectAB);
		printData("Symmetric difference: phone and email", symmetricDiff2);
	}
	
	
	public static void  printData(String header, Collection<Contact> contact ) {
		System.out.println("----------------------------------------");
		System.out.println(header);
		System.out.println("----------------------------------------");
		contact.forEach(System.out::println);
		
	}
	
	
}

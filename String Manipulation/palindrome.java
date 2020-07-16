package stringManipulation;

public class Palindrome {
	
	static boolean palindrome(String s) {
		/*1. rotate string 2. check if string is equal to original string*/
		s = s.replaceAll(" ", "").toUpperCase();
		int mid = s.length()/2;
		String sub1 = s.substring(0, mid);
		String sub2 = "";
		if(s.length()%2 > 0) {
			sub2 = s.substring(mid+1, s.length());
		} else {
			sub2 = s.substring(mid, s.length());
		}
		
		char[] c2 = sub2.toCharArray();
		int l = 0;
		int r = sub2.length() - 1;
		for(l=0; l<r; l++, r--) {
			char temp = c2[r];
			c2[r] = c2[l];
			c2[l] = temp;
		}
		
		sub2 = new String(c2);
		if(sub1.equals(sub2)) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isPalindrome(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("[^a-zA-Z0-9]", " ").toUpperCase();
		
		///check length of string
		///reverse the first half of the substring and check if it is equal to the other half of the string
		int stringLength = s.length();
		int mid = stringLength/2;
		
		String s1 = s.substring(0, mid);
		String s2 = "";
		if(stringLength%2 == 0) {
			s2 = s.substring(mid, stringLength);
		} else {
			s2 = s.substring(mid + 1, stringLength);
		}
		s1 = reverseString(s1);
		
		System.out.println(mid + ": " + s + " - "  + s1 + " - " + s2);
		if(s1.equals(s2)) {
			return true;
		}
		
		return false;
	}
	
	static String reverseString(String s){
		char[] stringChars = s.toCharArray();
		int leftPtr = 0;
		int rightPtr = s.length() - 1;
		for(leftPtr = 0; leftPtr< rightPtr; leftPtr++, rightPtr--) {
			char temp = stringChars[leftPtr];
			stringChars[leftPtr] = stringChars[rightPtr];
			stringChars[rightPtr] = temp;
		}
		
		return new String(stringChars);
	}
	
	static String longestPalindrome(String s) {
		/*Given a string, find the longest substring which is palindrome.*/
		String longestPalindrome = "";
		for(int i=0; i<=s.length(); i++) {
			for(int j=i; j<=s.length(); j++) {
				String sub = s.substring(i, j);
				if(palindrome(sub) && longestPalindrome.length() < sub.length()) {
					longestPalindrome = sub;
				}
			}
		}
		
		return longestPalindrome;
	}
	
	
	public static void main(String args[]) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(longestPalindrome(s));
		
		
		System.out.println(isPalindrome("Live on time, emit no evil"));
	}
	

}

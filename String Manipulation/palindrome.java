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
	}
	

}

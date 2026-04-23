import java.util.*;

public class Main{
	public static void main(String[] args){
		String[] arr = {"Mike", "Alice", "Mary", "Bob", "Michelle", "Eve", "Oscar"};

		//sort by length
		Arrays.sort(arr,Comparator.comparingInt(String::length));
		System.out.println("By length(short to long): "+Arrays.toString(arr));

		//sort by inverse length
		Arrays.sort(arr,Comparator.comparingInt(String::length).reversed());
		System.out.println("By length(long to short): "+Arrays.toString(arr));
		//sort alphabetically
		Arrays.sort(arr);
		System.out.println("Alphabetically: "+Arrays.toString(arr));

		//sort starting with M then the rest
		Arrays.sort(arr,(a,b)->{
			boolean aStartsWithM = a.startsWith("M");
			boolean bStartsWithM = b.startsWith("M");
			if(aStartsWithM && !bStartsWithM)
				return -1;
			if(!aStartsWithM && bStartsWithM)
				return 1;

			return a.compareTo(b);
		});
		System.out.println("Strings starting with M first: "+Arrays.toString(arr));
	}
}

package main.Incubyte.StringCalculator;

public class Calculator {

	public static int add(String inputstr) {
		if(inputstr.equals("")){
			return 0;
		}
		else {
			String deimiter= ",";
			if(inputstr.matches("//(.*)\n(.*)")) {
				deimiter = Character.toString(inputstr.charAt(2));
				inputstr = inputstr.substring(4);
				inputstr = inputstr.replaceAll("\n","");
			}
			String numList[] = inputstr.split(deimiter+"|\n");
			return sum(numList);	
		}	
	}
	
	private static int sum(String[] numList) {
		
		int total = 0;
		String negativeString = "";
		
		for(String num: numList) {
			if(toInt(num)<0) {
				if(negativeString.equals(""))
					negativeString = num;
				else
					negativeString += ("," + num);
			}
			total += toInt(num);	
		}
		if(!negativeString.equals("")) {
			throw new IllegalArgumentException("Negatives Not allowed:" + negativeString);
		}
		return total;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}

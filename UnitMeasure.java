package Measure;

import java.util.Scanner;

public class UnitMeasure {
	
	public static Double ConvertUnit(String unit,Double value)
	
	{
		double ConvertedValue = 0 ;
		if(unit=="m"|| unit == "km" || unit =="cm") {
			if(unit=="m")
				return ConvertedValue = value*100 ;
			if(unit=="km")
				return ConvertedValue = value*1000;
			if(unit=="cm")
				return ConvertedValue = value;
			
		}
		if(unit=="g"|| unit == "cg" || unit =="kg"){
			
			if(unit=="g")
				return ConvertedValue = value*100 ;
			if(unit=="kg")
				return ConvertedValue = value*1000;
			if(unit=="cg")
				return ConvertedValue = value;
			
		}
		if(unit=="C"|| unit == "K" || unit =="F"){
			Double K = 273.0;
			if(unit=="C")
				return ConvertedValue = value + K ;
			if(unit=="F")
				return ConvertedValue = (value-32.0)*5/9 + K;
			if(unit=="K")
				return ConvertedValue = value;
		}
		return ConvertedValue;
	}
//	
//	public static double AddTwoValue()
//	{
//		
//	}
//	
//	public static double SubTwoValue() 
//	{
//	}
//	
		public static void main(){
			try (var sc = new Scanner(System.in)) {
				System.out.println("MENU : 1.Conversion 2.AddingUnits 3.SubtractingUnits 4.CheckingEquality");
				int option = sc.nextInt();
				System.out.println("enter value");
				Double value = sc.nextDouble();
				
				System.out.println("enter unit type");
				String unit = sc.nextLine();
				
				
				switch(option) {
				case 1:{				
						ConvertUnit(unit,value);
				}
//			case 2:{
//				AddTwoValues();
//			}
//			case 3:{
//				SubTwoValues();
//			}
//			case 4:{
//				CheckingEquals();
//			}
				}
			}
			
		}
		
		
}














package stockaccountmanagement.stockmanagement;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockPortFolio
{
	 static String nameOf;
	 static int quantityOf, priceOf, totalValueOfEachStock, finalPortFolioValue;
	  
	/**
	 * @throws IOException
	 * @throws ParseException
	 * Reading data from json file.
	 * Calculating each stock value as well as portfolio value.
	 */
	public void calculateValueOfTotalStock() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\portfolioJSON\\allstocks.json");
		
		Object javaObject = jsonParser.parse(fileReader); //java Object
		JSONObject jsonObject = (JSONObject) javaObject; //converting java object to json object
		System.out.println(jsonObject+"\n");
		
		JSONArray stocksJsonArray = (JSONArray) jsonObject.get("stocks");
		
		for(int i=0; i<stocksJsonArray.size(); i++)
		{
			JSONObject stockJsonArray = (JSONObject) stocksJsonArray.get(i);
			
			nameOf = (String) stockJsonArray.get("name");
			quantityOf = ((Long) stockJsonArray.get("quantity")).intValue();
			priceOf = ((Long) stockJsonArray.get("price")).intValue();
			
			System.out.println("Name Of Stock : "+ nameOf + " \nNumber of shares : " + quantityOf + " \nPrice Per share : " + priceOf +"\n");
			totalValueOfEachStock = quantityOf * priceOf;
			System.out.println("Total value stock is : " + totalValueOfEachStock + "\n");
			finalPortFolioValue += totalValueOfEachStock;
		}
			System.out.println("Total value of portfolio is : " + finalPortFolioValue+" \n");
	}
	
	public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException 
	{
		StockPortFolio stockPortFolioObject = new StockPortFolio();
		stockPortFolioObject.calculateValueOfTotalStock();
	}
}

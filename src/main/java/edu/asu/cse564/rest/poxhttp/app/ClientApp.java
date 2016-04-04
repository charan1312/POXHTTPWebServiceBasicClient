package edu.asu.cse564.rest.poxhttp.app;

import com.sun.jersey.api.client.ClientResponse;

import edu.asu.cse564.rest.poxhttp.service.ClientService;

public class ClientApp {
    public static void main( String[] args ) {
        
        ClientService clientService = new ClientService();
        
        String inputForRetreival = 
                "<SelectedFoodItems xmlns=\"http://cse564.asu.edu/PoxAssignment\">" +
                        "<FoodItemId>306</FoodItemId>" +
                        "<FoodItemId>302</FoodItemId>" +
                        "<FoodItemId>999</FoodItemId>" +
                "</SelectedFoodItems>";
        
        String inputForAdding = 
                "<NewFoodItems xmlns=\"http://cse564.asu.edu/PoxAssignment\">" +
                     "<FoodItem country=\"IN\">" +
                        "<name>Plain Dosa</name>" +
                        "<description>A flat round steamed pan cake made of rice batter.Served with chutney and sambar </description>" +
                        "<category>Breakfast</category>" +
                        "<price>8.00</price>" +
                     "</FoodItem>" +
                "</NewFoodItems>";
        
        ClientResponse outputResponseObject =  clientService.postFoodItemRequest(inputForAdding);
        
        System.out.println("THE RESPONSE FROM THE SERVER IS:\n\n");
        System.out.println(outputResponseObject.getStatus());
        System.out.println(outputResponseObject.getEntity(String.class));
        
        clientService.close();
    }

}

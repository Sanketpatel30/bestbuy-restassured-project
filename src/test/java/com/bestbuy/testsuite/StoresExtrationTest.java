package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtrationTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given().when().get("/stores").then().statusCode(200);
    }

    @Test
    public void test001ExtractTheValueOfLimit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test002ExtractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003ExtractTheNameOf5thStore() {
        String storeName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store: " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004ExtractTheNameOfAllTheStores() {
        List<Integer> allStoreName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test005ExtractTheStoreIdOfAllTheStore() {
        List<Integer> allStoreID = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store id : " + allStoreID);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test006printSizeOfDataList() {
        List<Integer> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test007GetAllTheValueOfTheStoreWhereStoreNameStCloud() {
        List<String> name = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value Of The Store Where Store NameS tCloud: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test008GetTheAddressOfTheStoreWhereStoreNameRochester() {
        String address = response.extract().path("data[8].address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + address);
        System.out.println("------------------End of Test---------------------------");
    }

//    List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.address == 'address'}");
//    System.out.println("------------------StartingTest---------------------------");
//    System.out.println("The Address Of the store where store name Rochester: "+address);
//    System.out.println("------------------End of Test---------------------------");
//}

    @Test
    public void test009GetAllTheServicesOf8thStore() {
        List<Integer> listOfServices = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all services of 08th stores are : " + listOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test010GetStoreservicesOfTheStoreWhereServiceNameWindowsStore() {
        List<?> storeservices = response.extract().path("data.findAll{('Windows Store')}.Storesservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the storesservices of the store service name Windows store: " + storeservices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test011GetAllTheStoreIdOfAllTheStore() {
        List<Integer> listOfIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");
        List<Integer> storeOfIds = response.extract().path("data.findAll.services.findAll.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store Ids are : " + storeOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test012GetIdOfAllTheStore() {
        List<Integer> storesId = response.extract().path("data.services.storeId");
        List<Double> ID = response.extract().path("data.findAll{it.services == 'services'}.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + ID);
        System.out.println("------------------End of Test---------------------------");
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store Ids are : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test013FindTheStoreNamesWhereStateND() {
        ArrayList<HashMap<String, ?>> services = response.extract().path("data.findAll{data.services.get(name)");
        List<HashMap<String, ?>> name = response.extract().path("data[7].findAll{it.state == 'ND'}.name");
       // List<HashMap<String, ?>> name = response.extract().path("data[7].services.name");
        String data = response.extract().path("data[7].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test014FindTheTotalNumberOfServicesForTheStoreWhereStoreNameRochester() {
        List<Integer> services = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test015FindTheCreatedAtForAllServicesWhoseNameWindowsStore() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name='Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("createdAt for all services of Windows Store : " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test016FindTheNameOfAllServiceWhereStoreNameFargo() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("createdAt for all services of Windows Store : " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test017FindTheZipOfAllTheStore() {
        List<String> zipOfAllStore = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" zip of all the store : " + zipOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test018FindTheZipOfStoreNameRoseville() {
        List<String> totalNoOfServices = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of store name: " + totalNoOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

}

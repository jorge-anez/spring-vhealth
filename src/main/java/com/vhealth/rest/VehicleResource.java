package com.vhealth.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.vhealth.dynamodb.model.Vehicle;
import com.vhealth.dynamodb.repositories.ProductInfoRepository;
import com.vhealth.dynamodb.repositories.VehicleRepository;
import com.vhealth.transer.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleResource {
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @PostConstruct
    public void init() {
        System.out.println("Hellosss");
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        //CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Vehicle.class);
        //tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        //amazonDynamoDB.createTable(tableRequest);
        //dynamoDBMapper.batchDelete((List<Vehicle>)vehicleRepository.findAll());

    }

    @RequestMapping("{vehicleId}/findById")
    public ListResponse<Vehicle> listVehicle(@PathVariable String vehicleId) {
        ListResponse<Vehicle> response = new ListResponse();
        //dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        //Vehicle item = new Vehicle();
        //   item.setId("3233");
        //    item.setVin("SHSHSHS");
        //dynamoDBMapper.save(item);
        //List<Vehicle> list = (List<Vehicle>) vehicleRepository.findAll();
        //ProductInfo dave = new ProductInfo();
        //dave.setCost("2323");
        //dave.setId("211233");
        //repository.save(dave);
        List<Vehicle> result= (List<Vehicle>) vehicleRepository.findAll();
        //response.setList(vehicle);
        response.setList(result);
        return response;
    }
}
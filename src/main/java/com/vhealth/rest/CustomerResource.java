package com.vhealth.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.vhealth.dynamodb.model.Customer;
import com.vhealth.dynamodb.model.Vehicle;
import com.vhealth.dynamodb.repositories.CustomerRepository;
import com.vhealth.dynamodb.repositories.ProductInfoRepository;
import com.vhealth.dynamodb.repositories.VehicleRepository;
import com.vhealth.transer.BaseResponse;
import com.vhealth.transer.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerResource {
    private DynamoDBMapper dynamoDBMapper;
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        System.out.println("init Customer!!");
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        /*
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Customer.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
        dynamoDBMapper.batchDelete((List<Customer>)customerRepository.findAll());
        */
    }

    @RequestMapping("listAll")
    public ListResponse<Customer> listVehicle() {
        ListResponse<Customer> response = new ListResponse();
        List<Customer> result= (List<Customer>) customerRepository.findAll();
        response.setList(result);
        return response;
    }

    @RequestMapping("save")
    public BaseResponse saveCustomer(@RequestBody Customer customer) {
        ListResponse<Customer> response = new ListResponse();
        dynamoDBMapper.save(customer);
        return response;
    }
}
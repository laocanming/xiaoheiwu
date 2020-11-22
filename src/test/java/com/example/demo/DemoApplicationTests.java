package com.example.demo;

import com.example.demo.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private CustomerMapper customerMapper;


    @Test
    void test(){
//        User admin = userMapper.findUserByName("admin");
//        System.out.println(!StringUtils.isEmpty(admin));
        // System.out.println(customerMapper.MaxId());
//        List<Statistic> statistic = customerMapper.findStatistic();
//        for (Statistic statistic1 : statistic) {
//            System.out.println(statistic1);
//        }
//        List<Administration> byid = customerMapper.findByid(1);
//        for (Administration administration : byid) {
//            System.out.println(administration);
//        }
//        List<Comment> comment = customerMapper.findComment(1);
//        for (Comment comment1 : comment) {
//            System.out.println(comment1);
//        }
//        List<Administration> administration = customerMapper.findAdministration();
//        System.out.println(customerMapper.findById(1));
    }
//    @Autowired
//    private CustomerMapper customerMapper;
//    @Test
//    void contextLoads() {
//        //按ID查询
//        Customer customerById = customerMapper.findCustomerById(1);
//        System.out.println(customerById);
//        //按ID删除

//        Integer deleteById = customerMapper.DeleteById(156);
//        System.out.println(deleteById);

//        //按name模糊查询
//        List<Customer> customerByName = customerMapper.findCustomerByName("88");
//        System.out.println(customerByName);
//        for (Customer c:customerByName) {
//
//            System.out.println(c);
//        }
//        PageInfo<Customer> customerPageInfo = new PageInfo<>(customerByName);
//        System.out.println(customerPageInfo);
//        //插入一条数据
//        Customer customer=new Customer(99,"weibin","123","123");
//        Integer integer = customerMapper.InsertData(customer);
//        System.out.println(integer);
//        //按id更新一条数据
//        Customer customer1 = new Customer(88, "weibinMax", "123456", "123456");
//        Integer integer1 = customerMapper.updataCustomer(customer1);
//        System.out.println(integer1);
//    }



}

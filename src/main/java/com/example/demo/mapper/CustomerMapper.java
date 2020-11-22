package com.example.demo.mapper;

import com.example.demo.po.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    User findCustomerById(Integer id);


    List<Customer> findCustomerByName(String name);

    List<User> findUser();
    Integer DeleteById(Integer id);
    Integer InsertData(User user);
    Integer updateUser(User user);

    Administration findById(Integer id);
    List<Administration> findAdministration();
    Integer DeleteAdministrationById(Integer id);

    Integer InsertAdministrationData(Administration user);

    Integer Insertt_statisticData(Long id);

    Long MaxId();

    Integer updateAdministration(Administration user);


    List<Comment> findComment(Integer id);

    List<Administration> findByid(Integer id);

    List<Statistic> findStatistic();

    Integer Deletet_statisticById(Integer id);
}

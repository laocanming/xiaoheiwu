package com.example.demo.repository;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.po.Administration;
import com.example.demo.po.Statistic;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AdministrationRepositoryImpl implements AdministrationRepository {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Statistic> listStatistic() {
        return new ArrayList<>(customerMapper.findStatistic());
    }

    @Override
    public PageInfo<Statistic> findAllCustomerByPage(Integer pageNum, Integer count) {
        PageHelper.startPage(pageNum,count);
        List<Statistic> customers=customerMapper.findStatistic();
        PageInfo<Statistic> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }


    @Override
    public List<Administration> getAdministrationByid(Integer id) {
        return customerMapper.findByid(id);
    }

    @Override
    public Administration saveOrUpdateAdministration(Administration user) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        user.setCreated(date.format(formatter));
        if (user.getId()==null){
            Long i=customerMapper.MaxId()+1;
            user.setId(i);
            customerMapper.InsertAdministrationData(user);
            customerMapper.Insertt_statisticData(i);
        }else {
            customerMapper.updateAdministration(user);
        }
        return user;
    }

    @Override
    public void deleteAdministration(Integer id) {
        customerMapper.Deletet_statisticById(id);
        customerMapper.DeleteAdministrationById(id);
    }

    @Override
    public Administration getAdministrationById(Integer id) {
        return customerMapper.findById(id);
    }

    @Override
    public List<Administration> listAdministration() {
        return new ArrayList<>(customerMapper.findAdministration());
    }


}

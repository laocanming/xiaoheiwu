package com.example.demo.repository;

import com.example.demo.po.Administration;
import com.example.demo.po.Statistic;
import com.example.demo.po.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdministrationRepository {
    PageInfo<Statistic> findAllCustomerByPage(Integer pageNum, Integer count);

    List<Statistic> listStatistic();

    List<Administration> getAdministrationByid(Integer id);
    /**
     * 创建或者修改用户
     */
    Administration saveOrUpdateAdministration(Administration user);
    /**
     * 删除用户
     */
    void deleteAdministration(Integer id);
    /**
     * 根据用户id查询用户
     */

    Administration getAdministrationById(Integer id);
    /**
     * 获取用户列表
     */

    List<Administration> listAdministration();



}

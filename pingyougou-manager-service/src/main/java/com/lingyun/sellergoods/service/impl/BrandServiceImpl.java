package com.lingyun.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.mapper.TEmpMapper;
import com.lingyun.pojo.TEmp;
import com.lingyun.pojo.TEmpExample;
import com.lingyun.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout = 60000)
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TEmpMapper tEmpMapper;
    @Override
    public List<TEmp> findAll() {
        return tEmpMapper.selectByExample(null);
    }

    @Override
    public void add(TEmp tEmp) {
        tEmpMapper.insert(tEmp);
    }

    @Override
    public void delete(int id) {
        tEmpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteids(int[] ids) {
        for (int id:ids){
            tEmpMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TEmp findone(int id) {
        return tEmpMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TEmp tEmp) {
        tEmpMapper.updateByPrimaryKey(tEmp);
    }

    @Override
    public PageResult findPage(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TEmp> page = (Page<TEmp>) tEmpMapper.selectByExample(null);
        long totalPage = (int)Math.ceil(page.getTotal()/pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize,totalPage);
    }

    @Override
    public PageResult findPage(TEmp tEmp, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TEmpExample example = new TEmpExample();
        TEmpExample.Criteria exampleCriteria = example.createCriteria();
        if (tEmp != null){
            if (tEmp.getName() != null && tEmp.getName().length()>0){
                exampleCriteria.andNameLike("%" + tEmp.getName() + "%");
            }
            if (tEmp.getNumber() !=null && tEmp.getNumber().length()>0){
                exampleCriteria.andNameEqualTo(tEmp.getNumber());            }
        }
        Page<TEmp> page = (Page<TEmp>) tEmpMapper.selectByExample(example);
        long totalPage = (int) Math.ceil(page.getTotal()/pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize,totalPage);
    }

}

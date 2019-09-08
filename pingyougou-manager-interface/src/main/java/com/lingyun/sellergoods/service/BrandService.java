package com.lingyun.sellergoods.service;


import com.lingyun.pojo.TEmp;
import entity.PageResult;

import java.util.List;

public interface BrandService {

   public List<TEmp> findAll();

   /**
    * 新增品牌信息
    */
   public void add(TEmp tEmp);

   /**
    * 删除品牌信息
    * @param id
    */
   public void delete(int id);

   public void deleteids(int[] ids);

   /**
    *
    *回显品牌信息
    */
   public TEmp findone(int id);


   /**
    * 修改品牌信息
    * @param tEmp
    */
   public void update(TEmp tEmp);


   /**
    * 品牌列表；分页查询
    * @param pageSize
    * @param pageNum
    * @return
    */
   public PageResult findPage(int pageSize,int pageNum);

   /**
    * 条件查询；分页展示
    * @param tEmp
    * @param pagetSeze
    * @param pageNum
    * @return
    */
   public PageResult findPage(TEmp tEmp,int pageSize,int pageNum);

}

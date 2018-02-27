package com.jgsu.service.impl;

import com.jgsu.dao.TbItemMapper;
import com.jgsu.entity.TbItem;
import com.jgsu.entity.TbItemExample;
import com.jgsu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
//        TbItem item =itemMapper.selectByPrimaryKey(itemId);

        //设置查询条件
        TbItemExample tbItemExample=new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);

        List<TbItem> list = itemMapper.selectByExample(tbItemExample);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }
}

package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.XueshengganbuDao;
import com.entity.XueshengganbuEntity;
import com.service.XueshengganbuService;
import com.entity.view.XueshengganbuView;

/**
 * 学生干部 服务实现类
 */
@Service("xueshengganbuService")
@Transactional
public class XueshengganbuServiceImpl extends ServiceImpl<XueshengganbuDao, XueshengganbuEntity> implements XueshengganbuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XueshengganbuView> page =new Query<XueshengganbuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

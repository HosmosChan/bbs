package com.bbs.point.service.impl;

import com.bbs.domain.Point;
import com.bbs.point.service.UserPointService;
import com.bbs.point.mapper.UserPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author chenhuayang
 * @description
 * @date 2019年01月31日
 */
@Service
public class UserPointServiceImpl implements UserPointService {
    @Autowired
    private UserPointMapper userPointMapper;

    @Override
    public void updatePoint(Point point) {
        userPointMapper.updatePoint(point);
        userPointMapper.savePointRecord(point);
    }

    @Override
    public List<Point> getPointRecord(Point point) {
        return userPointMapper.getPointRecord(point);
    }

    @Override
    public Point getPoint(Point point) {
        return userPointMapper.getPoint(point);
    }
}
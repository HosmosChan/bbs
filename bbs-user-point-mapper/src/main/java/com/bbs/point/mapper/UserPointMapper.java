package com.bbs.point.mapper;

import com.bbs.domain.Point;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface UserPointMapper {
    /**
     * 更新用户信息表积分数
     *
     * @param point 积分信息
     */
    void updatePoint(Point point);

    /**
     * 保存积分变更纪录
     *
     * @param point 积分信息
     */
    void savePointRecord(Point point);

    /**
     * 根据相关积分信息获取积分变更纪录
     *
     * @param point 积分信息
     * @return List<Point> 积分变更纪录
     */
    List<Point> getPointRecord(Point point);

    /**
     * 根据相关积分信息获取积分详细信息
     *
     * @param point 积分信息
     * @return Point 积分积分详细信息
     */
    Point getPoint(Point point);
}
package com.bbs.user.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bbs.domain.User;
import com.bbs.domain.UserVo;
import com.bbs.exception.BusinessRunException;
import com.bbs.user.mapper.UserMapper;
import com.bbs.user.service.UserService;
import com.bbs.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;

    /**
     * 保存用户
     *
     * @throws BusinessRunException
     */
    @Transactional(rollbackFor = BusinessRunException.class)
    public Integer saveUser(User user) throws BusinessRunException {
        try {
            user.setCreateBy("admin");
            user.setCreateDate(new Date());
            user.setStatusCode(User.StatusEnum.NORMALSTATUS.getCode());
            user.setPassword(MD5Utils.MD5Encode(user.getPassword(), "UTF-8"));
            return userMapper.saveUser(user);
        } catch (Exception e) {
            logger.info("保存用户异常", e);
            throw new BusinessRunException(e);
        }
    }

    @Override
    public User getUser(UserVo userVo) {
        // TODO Auto-generated method stub
        return userMapper.getUser(userVo);
    }

    @Override
    public List<User> listUser(UserVo userVo) {
        // TODO Auto-generated method stub
        return userMapper.listUser(userVo);
    }
}
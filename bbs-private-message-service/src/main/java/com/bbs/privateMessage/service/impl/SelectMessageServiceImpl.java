package com.bbs.privateMessage.service.impl;

import com.bbs.domain.PrivateMessageVo;
import com.bbs.privateMessage.mapper.SelectMessageMapper;
import com.bbs.privateMessage.mapper.SendMessageMapper;
import com.bbs.privateMessage.service.SelectMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SelectMessageServiceImpl implements SelectMessageService {
    @Autowired
    private SelectMessageMapper selectMessageMapper;
    @Autowired
    private SendMessageMapper sendMessageMapper;

    @Override
    public List<PrivateMessageVo> getMessageList(String recievePersonAccount, Integer messageStatus) {
        Map<String, Object> map = new TreeMap<>();
        map.put("recievePersonAccount", recievePersonAccount);
        sendMessageMapper.updateUser((short) 0, recievePersonAccount);
        String status = null;
        switch (messageStatus) {
            case 0:
                status = "未读";
                break;
            case 1:
                status = "已读";
                break;
            case 2:
                status = "回收站状态";
                break;
            default:
                break;
        }
        map.put("messageStatus", status);
        return selectMessageMapper.getMessageList(map);
    }

    @Override
    public void updateMessage(PrivateMessageVo privateMessageVo) {
        selectMessageMapper.updateMessage(privateMessageVo);
    }

    @Override
    public PrivateMessageVo getMessageByCode(String code) {
        return selectMessageMapper.getMessageByCode(code);
    }
}

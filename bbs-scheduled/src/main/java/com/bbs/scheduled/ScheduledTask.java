package com.bbs.scheduled;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bbs.data.service.DataService;
import com.bbs.exception.BusinessRunException;

@Component
@Configuration
@EnableScheduling
public class ScheduledTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DataService dataserviceImpl;

    //定时函数一      每隔十分钟更新一次各个模块的每日最佳标题
    @Scheduled(cron = "0 0/10 * * * ?")
    public void AutoUpdateMaxPraisePostTitle() throws ParseException, BusinessRunException {
        String time = getnewtime();
        dataserviceImpl.checkBestPost(time);
    }

    //定时函数二      每天凌晨新增各个模块的数据块
    @Scheduled(cron = "0 0 0 * * ?")//每天0点执行该函数
    public void AutoCreateNewData() throws ParseException, BusinessRunException {
        //在sumdata表格中新建一行数据 初始化0
        String time = getnewtime();
        dataserviceImpl.autoCreateNewData(time);
    }

    //定时函数三      每个月的 8号 15号 22号 29号更新一次各个模块的上周最活跃用户
    //
    @Scheduled(cron = "0 0 0 8,15,22,29 * ?")
    public void autoupdateWeekData() throws ParseException, BusinessRunException {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int daytime = c.get(Calendar.DATE);
        dataserviceImpl.checkBestActivityUser(daytime);
    }

    //定时函数四      每个月的 1号更新上一个月的最活跃用户
    //   //如果上一个月只有28天 则需要额外的统计一下上个月的最后一周的数据信息
    @Scheduled(cron = "0 0 0 1 * ?")
    public void autoupdateMonthData() throws ParseException, BusinessRunException {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        int max = dataserviceImpl.getmonthday(year, month);
        if (max < 29) {
            //
            dataserviceImpl.checkLastWeekActivityUser(max);
        }
        //统计上个月的信息
        dataserviceImpl.checkMonthActivityUser(max);
    }

    //定时任务五     //测试
    @Scheduled(initialDelay=1000, fixedRate=6000)   //第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
    public void test() {
        System.err.println(new Date());
    }

    /*
     * 基础函数，返回一个今天的时间String
     * */
    private String getnewtime() throws ParseException {
        // TODO Auto-generated method stub
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH) + 1);
        String day = String.valueOf(c.get(Calendar.DATE));
        if (month.length() < 2) {
            month = "0" + month;
        }
        if (day.length() < 2) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }
}
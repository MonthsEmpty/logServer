package com.kedacom.controller;

import com.kedacom.logServer.RzsjLogClient;
import com.kedacom.model.LogBean;
import com.kedacom.utils.LogXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class LogApiController {


    @GetMapping("/testSuccess")
    public String testSuccess(){
        return "success";
    }

    /**
     *
     * @param logBean
     * {"xtid":"123","xtmc":"sasf","asf":"afa","yhzh":"asda","yhxm":"sdf","yhjh":"sfasd","yhsfzh":"sad","yhdwmc":"sad","yhdwdm":"asfs","zddz":"sfas","czlx":"sfafd","czsj":"sadfas","czjg":"asfas","ywxtrzid":"sdfas"}
     * @return
     */
    @PostMapping("/insertNewLog")
    public String insertNewLog(@RequestBody LogBean logBean) {
        log.info("请求的logBean :" + logBean);
        String result = logBean.valueCheck();
        if (!StringUtils.isEmpty(result)) {
            log.info(result);
            return result;
        } else {
            String logXMl = LogXmlUtil.getLogXml(logBean);
            log.info("logXMl :" + logXMl);
            if (!StringUtils.isEmpty(logXMl)) {
                result = RzsjLogClient.sendRzsjLog("aaaa", logXMl);
            } else {
                result = "logXMl为空";
            }
        }
        log.info("result : " + result);
        return result;
    }

    @RequestMapping("/insertNewLogs")
    public String insertNewLogs(@RequestBody List<LogBean> logBeans) {
        System.out.println(logBeans);
        return logBeans.toString();
    }

}

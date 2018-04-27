package com.kedacom.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Data
@ToString
public class LogBean {
    private String rzid;
    //320505000001
    private String xtid;
    //虎丘分局蜂巢系统
    private String xtmc;
    private String mkid;
    private String mkmc;
    private String yhzh;
    private String yhxm;
    private String yhjh;
    private String yhsfzh;
    private String yhdwmc;
    private String yhdwdm;
    private String zddz;
    private String czlx;
    private String cztj;
    private String czsj;
    private String czjg;
    private String cznr;
    private String sbyy;
    private String ywxtrzid;

    public String valueCheck(){
        String msg = null;
        if(StringUtils.isEmpty(xtid)){
            msg = "xtid不能为空";
        }else if(StringUtils.isEmpty(xtmc)){
            msg = "xtmc不能为空";
        }else if(StringUtils.isEmpty(yhzh)){
            msg = "yhzh不能为空";
        }else if(StringUtils.isEmpty(yhxm)){
            msg = "yhxm不能为空";
        }else if(StringUtils.isEmpty(yhjh)){
            msg = "yhjh不能为空";
        }else if(StringUtils.isEmpty(yhsfzh)){
            msg = "yhsfzh不能为空";
        }else if(StringUtils.isEmpty(yhdwmc)){
            msg = "yhdwmc不能为空";
        }else if(StringUtils.isEmpty(yhdwdm)){
            msg = "yhdwdm不能为空";
        }else if(StringUtils.isEmpty(zddz)){
            msg = "zddz不能为空";
        }else if(StringUtils.isEmpty(czlx)){
            msg = "czlx不能为空";
        }else if(StringUtils.isEmpty(czsj)){
            msg = "czsj不能为空";
        }else if(StringUtils.isEmpty(czjg)){
            msg = "czjg不能为空";
        }else if(StringUtils.isEmpty(ywxtrzid)){
            msg = "ywxtrzid不能为空";
        }
        return msg;
    }
}

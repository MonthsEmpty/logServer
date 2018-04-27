package com.kedacom.utils;

import com.kedacom.model.LogBean;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LogXmlUtil {

    /**
     * logList线程安全，这边的static方法也线程安全.
     *
     * @param logBeans
     * @return
     */
    public static String getLogXml(List<LogBean> logBeans) {
        String logXml = null;
        if (!CollectionUtils.isEmpty(logBeans)) {
            Document doc = DocumentHelper.createDocument();
            Element asptElement = doc.addElement("Aspt");
            Element versionElement = asptElement.addElement("Version");
            versionElement.setText("1.0");//todo
            Element regIDElement = asptElement.addElement("RegID");
            regIDElement.setText("340000100001");//todo
            Element logsElement = asptElement.addElement("Logs");
            for (LogBean logBean : logBeans) {
                Element logElement = logsElement.addElement("Log");
                Class logClass = logBean.getClass();
                Field[] fields = logClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Element element = logElement.addElement(fieldName);
                    try {
                        if("xtid".equals(fieldName)){
                            element.setText("320505000001");//todo
                        }else if("xtmc".equals(fieldName)){
                            element.setText("虎丘分局蜂巢系统");//todo
                        }else{
                            String value = (String) field.get(logBean);
                            element.setText(value == null ? "" : value);
                        }
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage());
                    }
                }
            }
            return asptElement.asXML();
        } else {
            return logXml;
        }
    }

    public static String getLogXml(LogBean logBean) {
        String logXml = null;
        if (logBean != null) {
            List<LogBean> logBeans = new ArrayList<>();
            logBeans.add(logBean);
            return getLogXml(logBeans);
        } else {
            return logXml;
        }
    }

}

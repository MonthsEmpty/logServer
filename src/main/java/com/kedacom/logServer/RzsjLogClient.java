package com.kedacom.logServer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RzsjLogClient {

    public static String sendRzsjLog(String xtid, String logsXml) {
        String result = "";
        try {
            RzsjLogServiceLocator locator = new RzsjLogServiceLocator();
            RzsjLogServicePortType service = locator.getRzsjLogServiceHttpPort();
            result = service.acceptLogs(xtid, logsXml);
            log.info("webservice返回结果 :" + result);
            return result;
        } catch (javax.xml.rpc.ServiceException ex) {
            result = ex.getMessage();
            log.error(ex.getMessage());
        } catch (java.rmi.RemoteException ex) {
            result = ex.getMessage();
            log.error(ex.getMessage());
        }
        return result;
    }
}

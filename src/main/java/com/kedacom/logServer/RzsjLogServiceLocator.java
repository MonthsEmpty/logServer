/**
 * RzsjLogServiceLocator.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.kedacom.logServer;

public class RzsjLogServiceLocator extends org.apache.axis.client.Service implements RzsjLogService {

    public RzsjLogServiceLocator() {
    }


    public RzsjLogServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RzsjLogServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RzsjLogServiceHttpPort
    private String RzsjLogServiceHttpPort_address = "http://10.35.142.136:8180/psb/services/RzsjLogService";

    public String getRzsjLogServiceHttpPortAddress() {
        return RzsjLogServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String RzsjLogServiceHttpPortWSDDServiceName = "RzsjLogServiceHttpPort";

    public String getRzsjLogServiceHttpPortWSDDServiceName() {
        return RzsjLogServiceHttpPortWSDDServiceName;
    }

    public void setRzsjLogServiceHttpPortWSDDServiceName(String name) {
        RzsjLogServiceHttpPortWSDDServiceName = name;
    }

    public RzsjLogServicePortType getRzsjLogServiceHttpPort() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RzsjLogServiceHttpPort_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRzsjLogServiceHttpPort(endpoint);
    }

    public RzsjLogServicePortType getRzsjLogServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            RzsjLogServiceHttpBindingStub _stub = new RzsjLogServiceHttpBindingStub(portAddress, this);
            _stub.setPortName(getRzsjLogServiceHttpPortWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRzsjLogServiceHttpPortEndpointAddress(String address) {
        RzsjLogServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (RzsjLogServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                RzsjLogServiceHttpBindingStub _stub = new RzsjLogServiceHttpBindingStub(new java.net.URL(RzsjLogServiceHttpPort_address), this);
                _stub.setPortName(getRzsjLogServiceHttpPortWSDDServiceName());
                return _stub;
            }
        } catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("RzsjLogServiceHttpPort".equals(inputPortName)) {
            return getRzsjLogServiceHttpPort();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.dimensoft.com", "RzsjLogService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.dimensoft.com", "RzsjLogServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

        if ("RzsjLogServiceHttpPort".equals(portName)) {
            setRzsjLogServiceHttpPortEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

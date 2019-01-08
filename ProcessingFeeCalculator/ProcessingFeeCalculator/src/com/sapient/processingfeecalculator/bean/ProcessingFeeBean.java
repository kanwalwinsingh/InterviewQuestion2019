package com.sapient.processingfeecalculator.bean;

import java.util.Date;

public class ProcessingFeeBean {

	private String extTransId;
	private String clientId;
	private String securityId;
	private String transType;
	private Date transDate;
	private double marketValue;
	private String priorityFlag;
	private double transCharge;
	
	public double getTransCharge() {
		return transCharge;
	}
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}
	public String getExtTransId() {
		return extTransId;
	}
	public void setExtTransId(String extTransId) {
		this.extTransId = extTransId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}	
	
	@Override
	public int hashCode(){
		return this.clientId.hashCode() + this.securityId.hashCode() + this.transDate.hashCode();
	}
	
	
	/*
	 * @Override
	public boolean equals(Object obj){
		if(obj instanceof ProcessingFeeBean){
			
			ProcessingFeeBean objBean = (ProcessingFeeBean)obj;
			if(this.clientId.equalsIgnoreCase(objBean.getClientId()) && this.securityId.equalsIgnoreCase(objBean.getSecurityId()) 
					&& this.transDate.equals(objBean.getTransDate()) && this.transType.equalsIgnoreCase(objBean.getTransType()) ){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}*/
	
	@Override
	public boolean equals(Object obj ) {
		if(obj instanceof ProcessingFeeBean){
			ProcessingFeeBean objBean = (ProcessingFeeBean) obj;
			if(this.clientId.equalsIgnoreCase(objBean.getClientId()) && this.securityId.equalsIgnoreCase(objBean.getSecurityId()) 
					&& this.transDate.equals(objBean.getTransDate())&& this.transType.equalsIgnoreCase(objBean.getTransType())){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	
	}	
	@Override
	public String toString(){
	
		return "[ Client Id : " + this.clientId + ", Ext Trans Id : " + 
		this.extTransId + ", Market Value : " + this.marketValue + ", Priority Flag : " + this.priorityFlag + ", Security Id : " +this.securityId+
		", Trans Charge : " + this.transCharge+", Trans Type : " + this.transType + " ]\n";
		
	}
	
}

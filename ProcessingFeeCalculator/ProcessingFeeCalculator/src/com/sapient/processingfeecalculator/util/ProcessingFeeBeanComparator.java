package com.sapient.processingfeecalculator.util;

import java.util.Comparator;

import com.sapient.processingfeecalculator.bean.ProcessingFeeBean;

public class ProcessingFeeBeanComparator implements Comparator<ProcessingFeeBean> {

	@Override
	public int compare(ProcessingFeeBean bean1, ProcessingFeeBean bean2) {
		if(bean1.getClientId().compareTo(bean2.getClientId()) != 0){
			return bean1.getClientId().compareTo(bean2.getClientId());
		}
		else{
			if(bean1.getTransType().compareTo(bean2.getTransType()) != 0){
				return bean1.getTransType().compareTo(bean2.getTransType());
			}
			else{
				if(bean1.getTransDate().compareTo(bean2.getTransDate()) != 0){
					return bean1.getTransDate().compareTo(bean2.getTransDate());
				}
				else{
					return bean1.getPriorityFlag().compareTo(bean2.getPriorityFlag());
				}
			}
		}
	}

}

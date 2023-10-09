package co.kr.ig.mvc.core.dto;

import java.util.HashMap;

public class InputDTO {
	private String statement;
	private int transDv;
	public String daoDv;
	private HashMap<String, Object> sendDataset;

	public void setDaoDv(String daoDv) {
		this.daoDv = daoDv;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public void setSendDataset(HashMap<String, Object> dataset) {
		this.sendDataset = dataset;
	}

	public void setTransDv(int transDv) {
		this.transDv = transDv;
	}

	public String getDaoDv() {
		return daoDv;
	}

	public String getStatement() {
		return statement;
	}

	public HashMap<String, Object> getSendDataset() {
		return sendDataset;
	}

	public int getTransDv() {
		return transDv;
	}
}

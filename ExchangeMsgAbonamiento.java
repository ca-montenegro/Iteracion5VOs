package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ExchangeMsgAbonamiento 
{
	@JsonProperty(value="routingkey")
	private String routingKey;
	
	@JsonProperty(value="sender")
	private String sender;
	
	@JsonProperty(value="payload")
	private Object payload;
	
	@JsonProperty(value="status")
	private String status;
	
	@JsonProperty(value="msgId")
	private String msgId;
	
	public ExchangeMsgAbonamiento(@JsonProperty(value="routingkey") String queue, @JsonProperty(value="sender") String sender, @JsonProperty(value="payload") Object payload, 
						@JsonProperty(value="status") String status, @JsonProperty(value="msgId") String msgId) 
	{
		this.routingKey = queue;
		this.sender = sender;
		this.payload = payload;
		this.status = status;
		this.msgId = msgId;
	}
	

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String queue) {
		this.routingKey = queue;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getMsgId() {
		return msgId;
	}


	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	

}

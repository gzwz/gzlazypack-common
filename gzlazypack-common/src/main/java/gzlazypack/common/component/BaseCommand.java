package gzlazypack.common.component;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 命令基类
 * 
 * @author yuxx
 * 
 */
@SuppressWarnings("serial")
public abstract class BaseCommand implements Serializable {

	/**
	 * 命令id
	 */
	private String commandId;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 命令处理结束时间
	 */
	private Date finishDate;


	/**
	 * 操作所属的流程id
	 */
	private String sagaId;


	public String toJson() {
		return JSON.toJSONString(this);
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getSagaId() {
		return sagaId;
	}

	public void setSagaId(String sagaId) {
		this.sagaId = sagaId;
	}


}

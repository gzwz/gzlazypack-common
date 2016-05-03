package gzlazypack.common.component;

import gzlazypack.common.component.hibernate.dialect.ColumnDefinitionMysql;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@MappedSuperclass
@SuppressWarnings({ "serial" })
public abstract class BaseSaga extends StringIdBaseEntity implements
		ColumnDefinitionMysql {

	@Transient
	private List<? extends BaseEvent> events;

	/**
	 * 是否结束
	 */
	@Type(type = "yes_no")
	@Column(name = "FINISH")
	private boolean finish;

	/**
	 * 是否成功
	 */
	@Type(type = "yes_no")
	@Column(name = "SUCCESS")
	private boolean success;

	/**
	 * 当前状态
	 */
	@Column(name = "CURRENT_STATUS", length = 11)
	private int currentStatus;

	/**
	 * 检查该saga是否已经完成了
	 */
	public abstract boolean checkFinish();

	/**
	 * 接收事件
	 * @throws BaseException 
	 */
	public abstract void handle(BaseEvent event) throws BaseException;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 结束时间
	 */
	private Date finishDate;

	public List<? extends BaseEvent> getEvents() {
		return events;
	}

	public void setEvents(List<? extends BaseEvent> events) {
		this.events = events;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
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

}

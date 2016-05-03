package gzlazypack.common.component;

import java.io.Serializable;
import java.util.List;

/**
 * 基础查询类 名词解释：query object 简称 qo
 * 
 * @author
 */
public class BaseQO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 别名，在进行关联查询时设置关联对象的别名
	 */
	private String alias;
	/**
	 * 需要筛选出来的实体字段名，可以带“.”进入组件对象的下一级属性。用于非select *查询
	 */
	private String[] projectionProperties;
	// ------------------延迟加载条件---------------
	// ------------------排序条件------------------
	// ------------------属性条件------------------
	/**
	 * 实体ID
	 */
	private T id;
	/**
	 * 实体ID集合，设置后会进行in查询
	 */
	private List<T> ids;
	// ------------------不包含的属性条件-------------
	/**
	 * 不包含的ID集合，设置后会进行not in查询
	 */
	private T[] idNotIn;

	// ------------------状态类条件------------------

	// 分页条件
	private Integer pageNo;

	private Integer pageSize;

	/**
	 * 是否解析QO上的注解，当注解中的条件解析方式不适合自己的查询需要时关闭，进行手工条件组装
	 */
	private Boolean enableQueryAnnotation = true;

	/**
	 * 是否关联查询了集合
	 */
	private Boolean batchResult = false;

	/**
	 * 查询结果类型
	 */
	private Integer ResultType;

	public final static Integer RESULT_TYPE_COUNT = 0;
	public final static Integer RESULT_TYPE_UNIQUE = 1;
	public final static Integer RESULT_TYPE_LIST = 2;
	public final static Integer RESULT_TYPE_PAGINATION = 3;

	private Integer draw;

	public final static Integer ORDER_ASC = 1;
	public final static Integer ORDER_DESC = -1;

	/**
	 * 悲观读锁
	 */
	private boolean readLock;

	/**
	 * 悲观写锁
	 */
	private boolean writeLock;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public T[] getIdNotIn() {
		return idNotIn;
	}

	public void setIdNotIn(T[] idNotIn) {
		this.idNotIn = idNotIn;
	}

	public void setIds(List<T> ids) {
		this.ids = ids;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String[] getProjectionProperties() {
		return projectionProperties;
	}

	public void setProjectionProperties(String[] projectionProperties) {
		this.projectionProperties = projectionProperties;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getIds() {
		return ids;
	}

	public Boolean getEnableQueryAnnotation() {
		return enableQueryAnnotation;
	}

	public void setEnableQueryAnnotation(Boolean enableQueryAnnotation) {
		this.enableQueryAnnotation = enableQueryAnnotation;
	}

	public Boolean getBatchResult() {
		return batchResult;
	}

	public void setBatchResult(Boolean batchResult) {
		this.batchResult = batchResult;
	}

	public Integer getResultType() {
		return ResultType;
	}

	public void setResultType(Integer resultType) {
		ResultType = resultType;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public boolean isReadLock() {
		return readLock;
	}

	public void setReadLock(boolean readLock) {
		this.readLock = readLock;
	}

	public boolean isWriteLock() {
		return writeLock;
	}

	public void setWriteLock(boolean writeLock) {
		this.writeLock = writeLock;
	}

}
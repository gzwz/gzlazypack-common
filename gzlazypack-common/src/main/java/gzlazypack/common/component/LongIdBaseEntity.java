package gzlazypack.common.component;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 领域模型基础类，需要id的聚合根和实体继承此类
 * 
 * @author yuxx
 */
@MappedSuperclass
public abstract class LongIdBaseEntity extends BaseEntity<Long> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "ID", unique = true, length = 64)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

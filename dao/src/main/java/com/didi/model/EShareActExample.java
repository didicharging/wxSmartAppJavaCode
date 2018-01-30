package com.didi.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EShareActExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private Integer limit;

	private Integer offset;

	private String userId;

	private String shareId;

	private Integer actType;

	public EShareActExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andShareIdIsNull() {
			addCriterion("share_id is null");
			return (Criteria) this;
		}

		public Criteria andShareIdIsNotNull() {
			addCriterion("share_id is not null");
			return (Criteria) this;
		}

		public Criteria andShareIdEqualTo(String value) {
			addCriterion("share_id =", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdNotEqualTo(String value) {
			addCriterion("share_id <>", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdGreaterThan(String value) {
			addCriterion("share_id >", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdGreaterThanOrEqualTo(String value) {
			addCriterion("share_id >=", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdLessThan(String value) {
			addCriterion("share_id <", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdLessThanOrEqualTo(String value) {
			addCriterion("share_id <=", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdLike(String value) {
			addCriterion("share_id like", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdNotLike(String value) {
			addCriterion("share_id not like", value, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdIn(List<String> values) {
			addCriterion("share_id in", values, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdNotIn(List<String> values) {
			addCriterion("share_id not in", values, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdBetween(String value1, String value2) {
			addCriterion("share_id between", value1, value2, "shareId");
			return (Criteria) this;
		}

		public Criteria andShareIdNotBetween(String value1, String value2) {
			addCriterion("share_id not between", value1, value2, "shareId");
			return (Criteria) this;
		}

		public Criteria andActTypeIsNull() {
			addCriterion("act_type is null");
			return (Criteria) this;
		}

		public Criteria andActTypeIsNotNull() {
			addCriterion("act_type is not null");
			return (Criteria) this;
		}

		public Criteria andActTypeEqualTo(Integer value) {
			addCriterion("act_type =", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotEqualTo(Integer value) {
			addCriterion("act_type <>", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeGreaterThan(Integer value) {
			addCriterion("act_type >", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("act_type >=", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeLessThan(Integer value) {
			addCriterion("act_type <", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeLessThanOrEqualTo(Integer value) {
			addCriterion("act_type <=", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeIn(List<Integer> values) {
			addCriterion("act_type in", values, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotIn(List<Integer> values) {
			addCriterion("act_type not in", values, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeBetween(Integer value1, Integer value2) {
			addCriterion("act_type between", value1, value2, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("act_type not between", value1, value2, "actType");
			return (Criteria) this;
		}

		public Criteria andActContentIsNull() {
			addCriterion("act_content is null");
			return (Criteria) this;
		}

		public Criteria andActContentIsNotNull() {
			addCriterion("act_content is not null");
			return (Criteria) this;
		}

		public Criteria andActContentEqualTo(String value) {
			addCriterion("act_content =", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentNotEqualTo(String value) {
			addCriterion("act_content <>", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentGreaterThan(String value) {
			addCriterion("act_content >", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentGreaterThanOrEqualTo(String value) {
			addCriterion("act_content >=", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentLessThan(String value) {
			addCriterion("act_content <", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentLessThanOrEqualTo(String value) {
			addCriterion("act_content <=", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentLike(String value) {
			addCriterion("act_content like", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentNotLike(String value) {
			addCriterion("act_content not like", value, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentIn(List<String> values) {
			addCriterion("act_content in", values, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentNotIn(List<String> values) {
			addCriterion("act_content not in", values, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentBetween(String value1, String value2) {
			addCriterion("act_content between", value1, value2, "actContent");
			return (Criteria) this;
		}

		public Criteria andActContentNotBetween(String value1, String value2) {
			addCriterion("act_content not between", value1, value2,
					"actContent");
			return (Criteria) this;
		}

		public Criteria andActDateIsNull() {
			addCriterion("act_date is null");
			return (Criteria) this;
		}

		public Criteria andActDateIsNotNull() {
			addCriterion("act_date is not null");
			return (Criteria) this;
		}

		public Criteria andActDateEqualTo(Date value) {
			addCriterion("act_date =", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateNotEqualTo(Date value) {
			addCriterion("act_date <>", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateGreaterThan(Date value) {
			addCriterion("act_date >", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateGreaterThanOrEqualTo(Date value) {
			addCriterion("act_date >=", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateLessThan(Date value) {
			addCriterion("act_date <", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateLessThanOrEqualTo(Date value) {
			addCriterion("act_date <=", value, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateIn(List<Date> values) {
			addCriterion("act_date in", values, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateNotIn(List<Date> values) {
			addCriterion("act_date not in", values, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateBetween(Date value1, Date value2) {
			addCriterion("act_date between", value1, value2, "actDate");
			return (Criteria) this;
		}

		public Criteria andActDateNotBetween(Date value1, Date value2) {
			addCriterion("act_date not between", value1, value2, "actDate");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public Integer getActType() {
		return actType;
	}

	public void setActType(Integer actType) {
		this.actType = actType;
	}
}
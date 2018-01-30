package com.didi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ENoticeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private Integer limit;

	private Integer offset;

	private String userId;
	
	private Integer isDelete;

	public ENoticeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
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

		public Criteria andPubDateIsNull() {
			addCriterion("pub_date is null");
			return (Criteria) this;
		}

		public Criteria andPubDateIsNotNull() {
			addCriterion("pub_date is not null");
			return (Criteria) this;
		}

		public Criteria andPubDateEqualTo(Date value) {
			addCriterion("pub_date =", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateNotEqualTo(Date value) {
			addCriterion("pub_date <>", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateGreaterThan(Date value) {
			addCriterion("pub_date >", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateGreaterThanOrEqualTo(Date value) {
			addCriterion("pub_date >=", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateLessThan(Date value) {
			addCriterion("pub_date <", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateLessThanOrEqualTo(Date value) {
			addCriterion("pub_date <=", value, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateIn(List<Date> values) {
			addCriterion("pub_date in", values, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateNotIn(List<Date> values) {
			addCriterion("pub_date not in", values, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateBetween(Date value1, Date value2) {
			addCriterion("pub_date between", value1, value2, "pubDate");
			return (Criteria) this;
		}

		public Criteria andPubDateNotBetween(Date value1, Date value2) {
			addCriterion("pub_date not between", value1, value2, "pubDate");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNull() {
			addCriterion("start_date is null");
			return (Criteria) this;
		}

		public Criteria andStartDateIsNotNull() {
			addCriterion("start_date is not null");
			return (Criteria) this;
		}

		public Criteria andStartDateEqualTo(Date value) {
			addCriterion("start_date =", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotEqualTo(Date value) {
			addCriterion("start_date <>", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThan(Date value) {
			addCriterion("start_date >", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
			addCriterion("start_date >=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThan(Date value) {
			addCriterion("start_date <", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateLessThanOrEqualTo(Date value) {
			addCriterion("start_date <=", value, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateIn(List<Date> values) {
			addCriterion("start_date in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotIn(List<Date> values) {
			addCriterion("start_date not in", values, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateBetween(Date value1, Date value2) {
			addCriterion("start_date between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andStartDateNotBetween(Date value1, Date value2) {
			addCriterion("start_date not between", value1, value2, "startDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNull() {
			addCriterion("end_date is null");
			return (Criteria) this;
		}

		public Criteria andEndDateIsNotNull() {
			addCriterion("end_date is not null");
			return (Criteria) this;
		}

		public Criteria andEndDateEqualTo(Date value) {
			addCriterion("end_date =", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotEqualTo(Date value) {
			addCriterion("end_date <>", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThan(Date value) {
			addCriterion("end_date >", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
			addCriterion("end_date >=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThan(Date value) {
			addCriterion("end_date <", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateLessThanOrEqualTo(Date value) {
			addCriterion("end_date <=", value, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateIn(List<Date> values) {
			addCriterion("end_date in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotIn(List<Date> values) {
			addCriterion("end_date not in", values, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateBetween(Date value1, Date value2) {
			addCriterion("end_date between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andEndDateNotBetween(Date value1, Date value2) {
			addCriterion("end_date not between", value1, value2, "endDate");
			return (Criteria) this;
		}

		public Criteria andIsDeleteIsNull() {
			addCriterion("is_delete is null");
			return (Criteria) this;
		}

		public Criteria andIsDeleteIsNotNull() {
			addCriterion("is_delete is not null");
			return (Criteria) this;
		}

		public Criteria andIsDeleteEqualTo(Integer value) {
			addCriterion("is_delete =", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteNotEqualTo(Integer value) {
			addCriterion("is_delete <>", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteGreaterThan(Integer value) {
			addCriterion("is_delete >", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_delete >=", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteLessThan(Integer value) {
			addCriterion("is_delete <", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
			addCriterion("is_delete <=", value, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteIn(List<Integer> values) {
			addCriterion("is_delete in", values, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteNotIn(List<Integer> values) {
			addCriterion("is_delete not in", values, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
			addCriterion("is_delete between", value1, value2, "isDelete");
			return (Criteria) this;
		}

		public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
			addCriterion("is_delete not between", value1, value2, "isDelete");
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
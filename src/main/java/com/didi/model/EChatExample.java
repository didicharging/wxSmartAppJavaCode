package com.didi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EChatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

	private Integer offset;

	private String fromUser;

	private String toUser;

	private Integer isDelete;
	
    public EChatExample() {
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andFromUserIsNull() {
            addCriterion("from_user is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNotNull() {
            addCriterion("from_user is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserEqualTo(String value) {
            addCriterion("from_user =", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotEqualTo(String value) {
            addCriterion("from_user <>", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThan(String value) {
            addCriterion("from_user >", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThanOrEqualTo(String value) {
            addCriterion("from_user >=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThan(String value) {
            addCriterion("from_user <", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThanOrEqualTo(String value) {
            addCriterion("from_user <=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLike(String value) {
            addCriterion("from_user like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotLike(String value) {
            addCriterion("from_user not like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserIn(List<String> values) {
            addCriterion("from_user in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotIn(List<String> values) {
            addCriterion("from_user not in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserBetween(String value1, String value2) {
            addCriterion("from_user between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotBetween(String value1, String value2) {
            addCriterion("from_user not between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andToUserIsNull() {
            addCriterion("to_user is null");
            return (Criteria) this;
        }

        public Criteria andToUserIsNotNull() {
            addCriterion("to_user is not null");
            return (Criteria) this;
        }

        public Criteria andToUserEqualTo(String value) {
            addCriterion("to_user =", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotEqualTo(String value) {
            addCriterion("to_user <>", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThan(String value) {
            addCriterion("to_user >", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThanOrEqualTo(String value) {
            addCriterion("to_user >=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThan(String value) {
            addCriterion("to_user <", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThanOrEqualTo(String value) {
            addCriterion("to_user <=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLike(String value) {
            addCriterion("to_user like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotLike(String value) {
            addCriterion("to_user not like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserIn(List<String> values) {
            addCriterion("to_user in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotIn(List<String> values) {
            addCriterion("to_user not in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserBetween(String value1, String value2) {
            addCriterion("to_user between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotBetween(String value1, String value2) {
            addCriterion("to_user not between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andChatDateIsNull() {
            addCriterion("chat_date is null");
            return (Criteria) this;
        }

        public Criteria andChatDateIsNotNull() {
            addCriterion("chat_date is not null");
            return (Criteria) this;
        }

        public Criteria andChatDateEqualTo(Date value) {
            addCriterion("chat_date =", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateNotEqualTo(Date value) {
            addCriterion("chat_date <>", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateGreaterThan(Date value) {
            addCriterion("chat_date >", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_date >=", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateLessThan(Date value) {
            addCriterion("chat_date <", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateLessThanOrEqualTo(Date value) {
            addCriterion("chat_date <=", value, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateIn(List<Date> values) {
            addCriterion("chat_date in", values, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateNotIn(List<Date> values) {
            addCriterion("chat_date not in", values, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateBetween(Date value1, Date value2) {
            addCriterion("chat_date between", value1, value2, "chatDate");
            return (Criteria) this;
        }

        public Criteria andChatDateNotBetween(Date value1, Date value2) {
            addCriterion("chat_date not between", value1, value2, "chatDate");
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
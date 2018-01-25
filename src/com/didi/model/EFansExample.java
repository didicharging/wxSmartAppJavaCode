package com.didi.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EFansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private Integer limit;

    private Integer offset;
    
    private String fansUserId;

    private String starUserId;

    public EFansExample() {
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

        public Criteria andFansUserIdIsNull() {
            addCriterion("fans_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFansUserIdIsNotNull() {
            addCriterion("fans_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFansUserIdEqualTo(String value) {
            addCriterion("fans_user_id =", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdNotEqualTo(String value) {
            addCriterion("fans_user_id <>", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdGreaterThan(String value) {
            addCriterion("fans_user_id >", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("fans_user_id >=", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdLessThan(String value) {
            addCriterion("fans_user_id <", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdLessThanOrEqualTo(String value) {
            addCriterion("fans_user_id <=", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdLike(String value) {
            addCriterion("fans_user_id like", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdNotLike(String value) {
            addCriterion("fans_user_id not like", value, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdIn(List<String> values) {
            addCriterion("fans_user_id in", values, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdNotIn(List<String> values) {
            addCriterion("fans_user_id not in", values, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdBetween(String value1, String value2) {
            addCriterion("fans_user_id between", value1, value2, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andFansUserIdNotBetween(String value1, String value2) {
            addCriterion("fans_user_id not between", value1, value2, "fansUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdIsNull() {
            addCriterion("star_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStarUserIdIsNotNull() {
            addCriterion("star_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStarUserIdEqualTo(String value) {
            addCriterion("star_user_id =", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdNotEqualTo(String value) {
            addCriterion("star_user_id <>", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdGreaterThan(String value) {
            addCriterion("star_user_id >", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("star_user_id >=", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdLessThan(String value) {
            addCriterion("star_user_id <", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdLessThanOrEqualTo(String value) {
            addCriterion("star_user_id <=", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdLike(String value) {
            addCriterion("star_user_id like", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdNotLike(String value) {
            addCriterion("star_user_id not like", value, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdIn(List<String> values) {
            addCriterion("star_user_id in", values, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdNotIn(List<String> values) {
            addCriterion("star_user_id not in", values, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdBetween(String value1, String value2) {
            addCriterion("star_user_id between", value1, value2, "starUserId");
            return (Criteria) this;
        }

        public Criteria andStarUserIdNotBetween(String value1, String value2) {
            addCriterion("star_user_id not between", value1, value2, "starUserId");
            return (Criteria) this;
        }

        public Criteria andFansDateIsNull() {
            addCriterion("fans_date is null");
            return (Criteria) this;
        }

        public Criteria andFansDateIsNotNull() {
            addCriterion("fans_date is not null");
            return (Criteria) this;
        }

        public Criteria andFansDateEqualTo(Date value) {
            addCriterion("fans_date =", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateNotEqualTo(Date value) {
            addCriterion("fans_date <>", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateGreaterThan(Date value) {
            addCriterion("fans_date >", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fans_date >=", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateLessThan(Date value) {
            addCriterion("fans_date <", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateLessThanOrEqualTo(Date value) {
            addCriterion("fans_date <=", value, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateIn(List<Date> values) {
            addCriterion("fans_date in", values, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateNotIn(List<Date> values) {
            addCriterion("fans_date not in", values, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateBetween(Date value1, Date value2) {
            addCriterion("fans_date between", value1, value2, "fansDate");
            return (Criteria) this;
        }

        public Criteria andFansDateNotBetween(Date value1, Date value2) {
            addCriterion("fans_date not between", value1, value2, "fansDate");
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

	public String getFansUserId() {
		return fansUserId;
	}

	public void setFansUserId(String fansUserId) {
		this.fansUserId = fansUserId;
	}

	public String getStarUserId() {
		return starUserId;
	}

	public void setStarUserId(String starUserId) {
		this.starUserId = starUserId;
	}
}
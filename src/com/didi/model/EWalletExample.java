package com.didi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EWalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private Integer limit;

    private Integer offset;
        
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

	public EWalletExample() {
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andShareAmountIsNull() {
            addCriterion("share_amount is null");
            return (Criteria) this;
        }

        public Criteria andShareAmountIsNotNull() {
            addCriterion("share_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShareAmountEqualTo(BigDecimal value) {
            addCriterion("share_amount =", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountNotEqualTo(BigDecimal value) {
            addCriterion("share_amount <>", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountGreaterThan(BigDecimal value) {
            addCriterion("share_amount >", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_amount >=", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountLessThan(BigDecimal value) {
            addCriterion("share_amount <", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_amount <=", value, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountIn(List<BigDecimal> values) {
            addCriterion("share_amount in", values, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountNotIn(List<BigDecimal> values) {
            addCriterion("share_amount not in", values, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_amount between", value1, value2, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andShareAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_amount not between", value1, value2, "shareAmount");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andDeadtimeIsNull() {
            addCriterion("deadtime is null");
            return (Criteria) this;
        }

        public Criteria andDeadtimeIsNotNull() {
            addCriterion("deadtime is not null");
            return (Criteria) this;
        }

        public Criteria andDeadtimeEqualTo(Date value) {
            addCriterion("deadtime =", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeNotEqualTo(Date value) {
            addCriterion("deadtime <>", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeGreaterThan(Date value) {
            addCriterion("deadtime >", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deadtime >=", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeLessThan(Date value) {
            addCriterion("deadtime <", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeLessThanOrEqualTo(Date value) {
            addCriterion("deadtime <=", value, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeIn(List<Date> values) {
            addCriterion("deadtime in", values, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeNotIn(List<Date> values) {
            addCriterion("deadtime not in", values, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeBetween(Date value1, Date value2) {
            addCriterion("deadtime between", value1, value2, "deadtime");
            return (Criteria) this;
        }

        public Criteria andDeadtimeNotBetween(Date value1, Date value2) {
            addCriterion("deadtime not between", value1, value2, "deadtime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNull() {
            addCriterion("changeTime is null");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNotNull() {
            addCriterion("changeTime is not null");
            return (Criteria) this;
        }

        public Criteria andChangetimeEqualTo(Integer value) {
            addCriterion("changeTime =", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotEqualTo(Integer value) {
            addCriterion("changeTime <>", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThan(Integer value) {
            addCriterion("changeTime >", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("changeTime >=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThan(Integer value) {
            addCriterion("changeTime <", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThanOrEqualTo(Integer value) {
            addCriterion("changeTime <=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIn(List<Integer> values) {
            addCriterion("changeTime in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotIn(List<Integer> values) {
            addCriterion("changeTime not in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeBetween(Integer value1, Integer value2) {
            addCriterion("changeTime between", value1, value2, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("changeTime not between", value1, value2, "changetime");
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
}
package com.didi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EDeviceLogExample {
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

	public EDeviceLogExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(Date value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(Date value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(Date value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(Date value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(Date value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<Date> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<Date> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(Date value1, Date value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(Date value1, Date value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Integer value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Integer value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Integer value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Integer value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Integer value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Integer> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Integer> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Integer value1, Integer value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeIsNull() {
            addCriterion("share_fee is null");
            return (Criteria) this;
        }

        public Criteria andShareFeeIsNotNull() {
            addCriterion("share_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShareFeeEqualTo(Integer value) {
            addCriterion("share_fee =", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeNotEqualTo(Integer value) {
            addCriterion("share_fee <>", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeGreaterThan(Integer value) {
            addCriterion("share_fee >", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_fee >=", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeLessThan(Integer value) {
            addCriterion("share_fee <", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeLessThanOrEqualTo(Integer value) {
            addCriterion("share_fee <=", value, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeIn(List<Integer> values) {
            addCriterion("share_fee in", values, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeNotIn(List<Integer> values) {
            addCriterion("share_fee not in", values, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeBetween(Integer value1, Integer value2) {
            addCriterion("share_fee between", value1, value2, "shareFee");
            return (Criteria) this;
        }

        public Criteria andShareFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("share_fee not between", value1, value2, "shareFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeIsNull() {
            addCriterion("wallet_fee is null");
            return (Criteria) this;
        }

        public Criteria andWalletFeeIsNotNull() {
            addCriterion("wallet_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWalletFeeEqualTo(Integer value) {
            addCriterion("wallet_fee =", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeNotEqualTo(Integer value) {
            addCriterion("wallet_fee <>", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeGreaterThan(Integer value) {
            addCriterion("wallet_fee >", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_fee >=", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeLessThan(Integer value) {
            addCriterion("wallet_fee <", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_fee <=", value, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeIn(List<Integer> values) {
            addCriterion("wallet_fee in", values, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeNotIn(List<Integer> values) {
            addCriterion("wallet_fee not in", values, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeBetween(Integer value1, Integer value2) {
            addCriterion("wallet_fee between", value1, value2, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_fee not between", value1, value2, "walletFee");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdIsNull() {
            addCriterion("wallet_log_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdIsNotNull() {
            addCriterion("wallet_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdEqualTo(String value) {
            addCriterion("wallet_log_id =", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotEqualTo(String value) {
            addCriterion("wallet_log_id <>", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdGreaterThan(String value) {
            addCriterion("wallet_log_id >", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_log_id >=", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdLessThan(String value) {
            addCriterion("wallet_log_id <", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdLessThanOrEqualTo(String value) {
            addCriterion("wallet_log_id <=", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdLike(String value) {
            addCriterion("wallet_log_id like", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotLike(String value) {
            addCriterion("wallet_log_id not like", value, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdIn(List<String> values) {
            addCriterion("wallet_log_id in", values, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotIn(List<String> values) {
            addCriterion("wallet_log_id not in", values, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdBetween(String value1, String value2) {
            addCriterion("wallet_log_id between", value1, value2, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andWalletLogIdNotBetween(String value1, String value2) {
            addCriterion("wallet_log_id not between", value1, value2, "walletLogId");
            return (Criteria) this;
        }

        public Criteria andOprationIsNull() {
            addCriterion("opration is null");
            return (Criteria) this;
        }

        public Criteria andOprationIsNotNull() {
            addCriterion("opration is not null");
            return (Criteria) this;
        }

        public Criteria andOprationEqualTo(Integer value) {
            addCriterion("opration =", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationNotEqualTo(Integer value) {
            addCriterion("opration <>", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationGreaterThan(Integer value) {
            addCriterion("opration >", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationGreaterThanOrEqualTo(Integer value) {
            addCriterion("opration >=", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationLessThan(Integer value) {
            addCriterion("opration <", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationLessThanOrEqualTo(Integer value) {
            addCriterion("opration <=", value, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationIn(List<Integer> values) {
            addCriterion("opration in", values, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationNotIn(List<Integer> values) {
            addCriterion("opration not in", values, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationBetween(Integer value1, Integer value2) {
            addCriterion("opration between", value1, value2, "opration");
            return (Criteria) this;
        }

        public Criteria andOprationNotBetween(Integer value1, Integer value2) {
            addCriterion("opration not between", value1, value2, "opration");
            return (Criteria) this;
        }

        public Criteria andIspayIsNull() {
            addCriterion("ispay is null");
            return (Criteria) this;
        }

        public Criteria andIspayIsNotNull() {
            addCriterion("ispay is not null");
            return (Criteria) this;
        }

        public Criteria andIspayEqualTo(Integer value) {
            addCriterion("ispay =", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotEqualTo(Integer value) {
            addCriterion("ispay <>", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThan(Integer value) {
            addCriterion("ispay >", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispay >=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThan(Integer value) {
            addCriterion("ispay <", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThanOrEqualTo(Integer value) {
            addCriterion("ispay <=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayIn(List<Integer> values) {
            addCriterion("ispay in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotIn(List<Integer> values) {
            addCriterion("ispay not in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayBetween(Integer value1, Integer value2) {
            addCriterion("ispay between", value1, value2, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotBetween(Integer value1, Integer value2) {
            addCriterion("ispay not between", value1, value2, "ispay");
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
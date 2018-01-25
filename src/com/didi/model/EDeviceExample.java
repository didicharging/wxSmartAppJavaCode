package com.didi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EDeviceExample {
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

	public EDeviceExample() {
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

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
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

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andShareMoneyIsNull() {
            addCriterion("share_money is null");
            return (Criteria) this;
        }

        public Criteria andShareMoneyIsNotNull() {
            addCriterion("share_money is not null");
            return (Criteria) this;
        }

        public Criteria andShareMoneyEqualTo(BigDecimal value) {
            addCriterion("share_money =", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyNotEqualTo(BigDecimal value) {
            addCriterion("share_money <>", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyGreaterThan(BigDecimal value) {
            addCriterion("share_money >", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_money >=", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyLessThan(BigDecimal value) {
            addCriterion("share_money <", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_money <=", value, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyIn(List<BigDecimal> values) {
            addCriterion("share_money in", values, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyNotIn(List<BigDecimal> values) {
            addCriterion("share_money not in", values, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_money between", value1, value2, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andShareMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_money not between", value1, value2, "shareMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyIsNull() {
            addCriterion("save_money is null");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyIsNotNull() {
            addCriterion("save_money is not null");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyEqualTo(BigDecimal value) {
            addCriterion("save_money =", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyNotEqualTo(BigDecimal value) {
            addCriterion("save_money <>", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyGreaterThan(BigDecimal value) {
            addCriterion("save_money >", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("save_money >=", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyLessThan(BigDecimal value) {
            addCriterion("save_money <", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("save_money <=", value, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyIn(List<BigDecimal> values) {
            addCriterion("save_money in", values, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyNotIn(List<BigDecimal> values) {
            addCriterion("save_money not in", values, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_money between", value1, value2, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andSaveMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("save_money not between", value1, value2, "saveMoney");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRentalIsNull() {
            addCriterion("rental is null");
            return (Criteria) this;
        }

        public Criteria andRentalIsNotNull() {
            addCriterion("rental is not null");
            return (Criteria) this;
        }

        public Criteria andRentalEqualTo(Integer value) {
            addCriterion("rental =", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotEqualTo(Integer value) {
            addCriterion("rental <>", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThan(Integer value) {
            addCriterion("rental >", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThanOrEqualTo(Integer value) {
            addCriterion("rental >=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThan(Integer value) {
            addCriterion("rental <", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThanOrEqualTo(Integer value) {
            addCriterion("rental <=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalIn(List<Integer> values) {
            addCriterion("rental in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotIn(List<Integer> values) {
            addCriterion("rental not in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalBetween(Integer value1, Integer value2) {
            addCriterion("rental between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotBetween(Integer value1, Integer value2) {
            addCriterion("rental not between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRentalHIsNull() {
            addCriterion("rental_h is null");
            return (Criteria) this;
        }

        public Criteria andRentalHIsNotNull() {
            addCriterion("rental_h is not null");
            return (Criteria) this;
        }

        public Criteria andRentalHEqualTo(Integer value) {
            addCriterion("rental_h =", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHNotEqualTo(Integer value) {
            addCriterion("rental_h <>", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHGreaterThan(Integer value) {
            addCriterion("rental_h >", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHGreaterThanOrEqualTo(Integer value) {
            addCriterion("rental_h >=", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHLessThan(Integer value) {
            addCriterion("rental_h <", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHLessThanOrEqualTo(Integer value) {
            addCriterion("rental_h <=", value, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHIn(List<Integer> values) {
            addCriterion("rental_h in", values, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHNotIn(List<Integer> values) {
            addCriterion("rental_h not in", values, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHBetween(Integer value1, Integer value2) {
            addCriterion("rental_h between", value1, value2, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalHNotBetween(Integer value1, Integer value2) {
            addCriterion("rental_h not between", value1, value2, "rentalH");
            return (Criteria) this;
        }

        public Criteria andRentalMIsNull() {
            addCriterion("rental_m is null");
            return (Criteria) this;
        }

        public Criteria andRentalMIsNotNull() {
            addCriterion("rental_m is not null");
            return (Criteria) this;
        }

        public Criteria andRentalMEqualTo(Integer value) {
            addCriterion("rental_m =", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMNotEqualTo(Integer value) {
            addCriterion("rental_m <>", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMGreaterThan(Integer value) {
            addCriterion("rental_m >", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMGreaterThanOrEqualTo(Integer value) {
            addCriterion("rental_m >=", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMLessThan(Integer value) {
            addCriterion("rental_m <", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMLessThanOrEqualTo(Integer value) {
            addCriterion("rental_m <=", value, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMIn(List<Integer> values) {
            addCriterion("rental_m in", values, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMNotIn(List<Integer> values) {
            addCriterion("rental_m not in", values, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMBetween(Integer value1, Integer value2) {
            addCriterion("rental_m between", value1, value2, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalMNotBetween(Integer value1, Integer value2) {
            addCriterion("rental_m not between", value1, value2, "rentalM");
            return (Criteria) this;
        }

        public Criteria andRentalTypeIsNull() {
            addCriterion("rental_type is null");
            return (Criteria) this;
        }

        public Criteria andRentalTypeIsNotNull() {
            addCriterion("rental_type is not null");
            return (Criteria) this;
        }

        public Criteria andRentalTypeEqualTo(Integer value) {
            addCriterion("rental_type =", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotEqualTo(Integer value) {
            addCriterion("rental_type <>", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeGreaterThan(Integer value) {
            addCriterion("rental_type >", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rental_type >=", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeLessThan(Integer value) {
            addCriterion("rental_type <", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rental_type <=", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeIn(List<Integer> values) {
            addCriterion("rental_type in", values, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotIn(List<Integer> values) {
            addCriterion("rental_type not in", values, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeBetween(Integer value1, Integer value2) {
            addCriterion("rental_type between", value1, value2, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rental_type not between", value1, value2, "rentalType");
            return (Criteria) this;
        }

        public Criteria andChargeDdbIsNull() {
            addCriterion("charge_ddb is null");
            return (Criteria) this;
        }

        public Criteria andChargeDdbIsNotNull() {
            addCriterion("charge_ddb is not null");
            return (Criteria) this;
        }

        public Criteria andChargeDdbEqualTo(Integer value) {
            addCriterion("charge_ddb =", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbNotEqualTo(Integer value) {
            addCriterion("charge_ddb <>", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbGreaterThan(Integer value) {
            addCriterion("charge_ddb >", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_ddb >=", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbLessThan(Integer value) {
            addCriterion("charge_ddb <", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbLessThanOrEqualTo(Integer value) {
            addCriterion("charge_ddb <=", value, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbIn(List<Integer> values) {
            addCriterion("charge_ddb in", values, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbNotIn(List<Integer> values) {
            addCriterion("charge_ddb not in", values, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbBetween(Integer value1, Integer value2) {
            addCriterion("charge_ddb between", value1, value2, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andChargeDdbNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_ddb not between", value1, value2, "chargeDdb");
            return (Criteria) this;
        }

        public Criteria andIsbuyIsNull() {
            addCriterion("isbuy is null");
            return (Criteria) this;
        }

        public Criteria andIsbuyIsNotNull() {
            addCriterion("isbuy is not null");
            return (Criteria) this;
        }

        public Criteria andIsbuyEqualTo(Integer value) {
            addCriterion("isbuy =", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyNotEqualTo(Integer value) {
            addCriterion("isbuy <>", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyGreaterThan(Integer value) {
            addCriterion("isbuy >", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("isbuy >=", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyLessThan(Integer value) {
            addCriterion("isbuy <", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyLessThanOrEqualTo(Integer value) {
            addCriterion("isbuy <=", value, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyIn(List<Integer> values) {
            addCriterion("isbuy in", values, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyNotIn(List<Integer> values) {
            addCriterion("isbuy not in", values, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyBetween(Integer value1, Integer value2) {
            addCriterion("isbuy between", value1, value2, "isbuy");
            return (Criteria) this;
        }

        public Criteria andIsbuyNotBetween(Integer value1, Integer value2) {
            addCriterion("isbuy not between", value1, value2, "isbuy");
            return (Criteria) this;
        }

        public Criteria andKWIsNull() {
            addCriterion("k_w is null");
            return (Criteria) this;
        }

        public Criteria andKWIsNotNull() {
            addCriterion("k_w is not null");
            return (Criteria) this;
        }

        public Criteria andKWEqualTo(Float value) {
            addCriterion("k_w =", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWNotEqualTo(Float value) {
            addCriterion("k_w <>", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWGreaterThan(Float value) {
            addCriterion("k_w >", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWGreaterThanOrEqualTo(Float value) {
            addCriterion("k_w >=", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWLessThan(Float value) {
            addCriterion("k_w <", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWLessThanOrEqualTo(Float value) {
            addCriterion("k_w <=", value, "kW");
            return (Criteria) this;
        }

        public Criteria andKWIn(List<Float> values) {
            addCriterion("k_w in", values, "kW");
            return (Criteria) this;
        }

        public Criteria andKWNotIn(List<Float> values) {
            addCriterion("k_w not in", values, "kW");
            return (Criteria) this;
        }

        public Criteria andKWBetween(Float value1, Float value2) {
            addCriterion("k_w between", value1, value2, "kW");
            return (Criteria) this;
        }

        public Criteria andKWNotBetween(Float value1, Float value2) {
            addCriterion("k_w not between", value1, value2, "kW");
            return (Criteria) this;
        }

        public Criteria andKMIsNull() {
            addCriterion("k_m is null");
            return (Criteria) this;
        }

        public Criteria andKMIsNotNull() {
            addCriterion("k_m is not null");
            return (Criteria) this;
        }

        public Criteria andKMEqualTo(Float value) {
            addCriterion("k_m =", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMNotEqualTo(Float value) {
            addCriterion("k_m <>", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMGreaterThan(Float value) {
            addCriterion("k_m >", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMGreaterThanOrEqualTo(Float value) {
            addCriterion("k_m >=", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMLessThan(Float value) {
            addCriterion("k_m <", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMLessThanOrEqualTo(Float value) {
            addCriterion("k_m <=", value, "kM");
            return (Criteria) this;
        }

        public Criteria andKMIn(List<Float> values) {
            addCriterion("k_m in", values, "kM");
            return (Criteria) this;
        }

        public Criteria andKMNotIn(List<Float> values) {
            addCriterion("k_m not in", values, "kM");
            return (Criteria) this;
        }

        public Criteria andKMBetween(Float value1, Float value2) {
            addCriterion("k_m between", value1, value2, "kM");
            return (Criteria) this;
        }

        public Criteria andKMNotBetween(Float value1, Float value2) {
            addCriterion("k_m not between", value1, value2, "kM");
            return (Criteria) this;
        }

        public Criteria andKDIsNull() {
            addCriterion("k_d is null");
            return (Criteria) this;
        }

        public Criteria andKDIsNotNull() {
            addCriterion("k_d is not null");
            return (Criteria) this;
        }

        public Criteria andKDEqualTo(Float value) {
            addCriterion("k_d =", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDNotEqualTo(Float value) {
            addCriterion("k_d <>", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDGreaterThan(Float value) {
            addCriterion("k_d >", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDGreaterThanOrEqualTo(Float value) {
            addCriterion("k_d >=", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDLessThan(Float value) {
            addCriterion("k_d <", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDLessThanOrEqualTo(Float value) {
            addCriterion("k_d <=", value, "kD");
            return (Criteria) this;
        }

        public Criteria andKDIn(List<Float> values) {
            addCriterion("k_d in", values, "kD");
            return (Criteria) this;
        }

        public Criteria andKDNotIn(List<Float> values) {
            addCriterion("k_d not in", values, "kD");
            return (Criteria) this;
        }

        public Criteria andKDBetween(Float value1, Float value2) {
            addCriterion("k_d between", value1, value2, "kD");
            return (Criteria) this;
        }

        public Criteria andKDNotBetween(Float value1, Float value2) {
            addCriterion("k_d not between", value1, value2, "kD");
            return (Criteria) this;
        }

        public Criteria andChangeDdbIsNull() {
            addCriterion("change_ddb is null");
            return (Criteria) this;
        }

        public Criteria andChangeDdbIsNotNull() {
            addCriterion("change_ddb is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDdbEqualTo(Integer value) {
            addCriterion("change_ddb =", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbNotEqualTo(Integer value) {
            addCriterion("change_ddb <>", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbGreaterThan(Integer value) {
            addCriterion("change_ddb >", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_ddb >=", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbLessThan(Integer value) {
            addCriterion("change_ddb <", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbLessThanOrEqualTo(Integer value) {
            addCriterion("change_ddb <=", value, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbIn(List<Integer> values) {
            addCriterion("change_ddb in", values, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbNotIn(List<Integer> values) {
            addCriterion("change_ddb not in", values, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbBetween(Integer value1, Integer value2) {
            addCriterion("change_ddb between", value1, value2, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andChangeDdbNotBetween(Integer value1, Integer value2) {
            addCriterion("change_ddb not between", value1, value2, "changeDdb");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNull() {
            addCriterion("function is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNotNull() {
            addCriterion("function is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionEqualTo(String value) {
            addCriterion("function =", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotEqualTo(String value) {
            addCriterion("function <>", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThan(String value) {
            addCriterion("function >", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("function >=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThan(String value) {
            addCriterion("function <", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThanOrEqualTo(String value) {
            addCriterion("function <=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLike(String value) {
            addCriterion("function like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotLike(String value) {
            addCriterion("function not like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionIn(List<String> values) {
            addCriterion("function in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotIn(List<String> values) {
            addCriterion("function not in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionBetween(String value1, String value2) {
            addCriterion("function between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotBetween(String value1, String value2) {
            addCriterion("function not between", value1, value2, "function");
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
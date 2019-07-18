package com.doft.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andOrderDetailIdIsNull() {
            addCriterion("ORDER_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIsNotNull() {
            addCriterion("ORDER_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID =", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID <>", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThan(Long value) {
            addCriterion("ORDER_DETAIL_ID >", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID >=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThan(Long value) {
            addCriterion("ORDER_DETAIL_ID <", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID <=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIn(List<Long> values) {
            addCriterion("ORDER_DETAIL_ID in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotIn(List<Long> values) {
            addCriterion("ORDER_DETAIL_ID not in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_DETAIL_ID between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_DETAIL_ID not between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andDishIdIsNull() {
            addCriterion("DISH_ID is null");
            return (Criteria) this;
        }

        public Criteria andDishIdIsNotNull() {
            addCriterion("DISH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDishIdEqualTo(Long value) {
            addCriterion("DISH_ID =", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotEqualTo(Long value) {
            addCriterion("DISH_ID <>", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThan(Long value) {
            addCriterion("DISH_ID >", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DISH_ID >=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThan(Long value) {
            addCriterion("DISH_ID <", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThanOrEqualTo(Long value) {
            addCriterion("DISH_ID <=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdIn(List<Long> values) {
            addCriterion("DISH_ID in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotIn(List<Long> values) {
            addCriterion("DISH_ID not in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdBetween(Long value1, Long value2) {
            addCriterion("DISH_ID between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotBetween(Long value1, Long value2) {
            addCriterion("DISH_ID not between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishNameIsNull() {
            addCriterion("DISH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDishNameIsNotNull() {
            addCriterion("DISH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDishNameEqualTo(String value) {
            addCriterion("DISH_NAME =", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotEqualTo(String value) {
            addCriterion("DISH_NAME <>", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameGreaterThan(String value) {
            addCriterion("DISH_NAME >", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameGreaterThanOrEqualTo(String value) {
            addCriterion("DISH_NAME >=", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLessThan(String value) {
            addCriterion("DISH_NAME <", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLessThanOrEqualTo(String value) {
            addCriterion("DISH_NAME <=", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLike(String value) {
            addCriterion("DISH_NAME like", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotLike(String value) {
            addCriterion("DISH_NAME not like", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameIn(List<String> values) {
            addCriterion("DISH_NAME in", values, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotIn(List<String> values) {
            addCriterion("DISH_NAME not in", values, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameBetween(String value1, String value2) {
            addCriterion("DISH_NAME between", value1, value2, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotBetween(String value1, String value2) {
            addCriterion("DISH_NAME not between", value1, value2, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishCountIsNull() {
            addCriterion("DISH_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDishCountIsNotNull() {
            addCriterion("DISH_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDishCountEqualTo(Integer value) {
            addCriterion("DISH_COUNT =", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountNotEqualTo(Integer value) {
            addCriterion("DISH_COUNT <>", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountGreaterThan(Integer value) {
            addCriterion("DISH_COUNT >", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("DISH_COUNT >=", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountLessThan(Integer value) {
            addCriterion("DISH_COUNT <", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountLessThanOrEqualTo(Integer value) {
            addCriterion("DISH_COUNT <=", value, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountIn(List<Integer> values) {
            addCriterion("DISH_COUNT in", values, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountNotIn(List<Integer> values) {
            addCriterion("DISH_COUNT not in", values, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountBetween(Integer value1, Integer value2) {
            addCriterion("DISH_COUNT between", value1, value2, "dishCount");
            return (Criteria) this;
        }

        public Criteria andDishCountNotBetween(Integer value1, Integer value2) {
            addCriterion("DISH_COUNT not between", value1, value2, "dishCount");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagIsNull() {
            addCriterion("IS_ADDED_DISH_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagIsNotNull() {
            addCriterion("IS_ADDED_DISH_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagEqualTo(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG =", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagNotEqualTo(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG <>", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagGreaterThan(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG >", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG >=", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagLessThan(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG <", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_ADDED_DISH_FLAG <=", value, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagIn(List<Boolean> values) {
            addCriterion("IS_ADDED_DISH_FLAG in", values, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagNotIn(List<Boolean> values) {
            addCriterion("IS_ADDED_DISH_FLAG not in", values, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ADDED_DISH_FLAG between", value1, value2, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andIsAddedDishFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ADDED_DISH_FLAG not between", value1, value2, "isAddedDishFlag");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceIsNull() {
            addCriterion("CURRENT_UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceIsNotNull() {
            addCriterion("CURRENT_UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceEqualTo(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE =", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE <>", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE >", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE >=", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceLessThan(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE <", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CURRENT_UNIT_PRICE <=", value, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceIn(List<BigDecimal> values) {
            addCriterion("CURRENT_UNIT_PRICE in", values, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("CURRENT_UNIT_PRICE not in", values, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_UNIT_PRICE between", value1, value2, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CURRENT_UNIT_PRICE not between", value1, value2, "currentUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("TOTAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("TOTAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_PRICE >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("TOTAL_PRICE <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRICE in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRICE not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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
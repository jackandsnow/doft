package com.doft.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleNumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleNumExample() {
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

        public Criteria andSaleIdIsNull() {
            addCriterion("SALE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSaleIdIsNotNull() {
            addCriterion("SALE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSaleIdEqualTo(Long value) {
            addCriterion("SALE_ID =", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotEqualTo(Long value) {
            addCriterion("SALE_ID <>", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThan(Long value) {
            addCriterion("SALE_ID >", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SALE_ID >=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThan(Long value) {
            addCriterion("SALE_ID <", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThanOrEqualTo(Long value) {
            addCriterion("SALE_ID <=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdIn(List<Long> values) {
            addCriterion("SALE_ID in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotIn(List<Long> values) {
            addCriterion("SALE_ID not in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdBetween(Long value1, Long value2) {
            addCriterion("SALE_ID between", value1, value2, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotBetween(Long value1, Long value2) {
            addCriterion("SALE_ID not between", value1, value2, "saleId");
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

        public Criteria andDaySaleNumberIsNull() {
            addCriterion("DAY_SALE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberIsNotNull() {
            addCriterion("DAY_SALE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberEqualTo(Long value) {
            addCriterion("DAY_SALE_NUMBER =", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberNotEqualTo(Long value) {
            addCriterion("DAY_SALE_NUMBER <>", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberGreaterThan(Long value) {
            addCriterion("DAY_SALE_NUMBER >", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("DAY_SALE_NUMBER >=", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberLessThan(Long value) {
            addCriterion("DAY_SALE_NUMBER <", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberLessThanOrEqualTo(Long value) {
            addCriterion("DAY_SALE_NUMBER <=", value, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberIn(List<Long> values) {
            addCriterion("DAY_SALE_NUMBER in", values, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberNotIn(List<Long> values) {
            addCriterion("DAY_SALE_NUMBER not in", values, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberBetween(Long value1, Long value2) {
            addCriterion("DAY_SALE_NUMBER between", value1, value2, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andDaySaleNumberNotBetween(Long value1, Long value2) {
            addCriterion("DAY_SALE_NUMBER not between", value1, value2, "daySaleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleDateIsNull() {
            addCriterion("SALE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSaleDateIsNotNull() {
            addCriterion("SALE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDateEqualTo(Date value) {
            addCriterion("SALE_DATE =", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotEqualTo(Date value) {
            addCriterion("SALE_DATE <>", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateGreaterThan(Date value) {
            addCriterion("SALE_DATE >", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SALE_DATE >=", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateLessThan(Date value) {
            addCriterion("SALE_DATE <", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateLessThanOrEqualTo(Date value) {
            addCriterion("SALE_DATE <=", value, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateIn(List<Date> values) {
            addCriterion("SALE_DATE in", values, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotIn(List<Date> values) {
            addCriterion("SALE_DATE not in", values, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateBetween(Date value1, Date value2) {
            addCriterion("SALE_DATE between", value1, value2, "saleDate");
            return (Criteria) this;
        }

        public Criteria andSaleDateNotBetween(Date value1, Date value2) {
            addCriterion("SALE_DATE not between", value1, value2, "saleDate");
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
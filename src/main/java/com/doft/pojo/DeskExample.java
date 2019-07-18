package com.doft.pojo;

import java.util.ArrayList;
import java.util.List;

public class DeskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeskExample() {
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

        public Criteria andDeskIdIsNull() {
            addCriterion("DESK_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeskIdIsNotNull() {
            addCriterion("DESK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeskIdEqualTo(Long value) {
            addCriterion("DESK_ID =", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotEqualTo(Long value) {
            addCriterion("DESK_ID <>", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdGreaterThan(Long value) {
            addCriterion("DESK_ID >", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DESK_ID >=", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdLessThan(Long value) {
            addCriterion("DESK_ID <", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdLessThanOrEqualTo(Long value) {
            addCriterion("DESK_ID <=", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdIn(List<Long> values) {
            addCriterion("DESK_ID in", values, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotIn(List<Long> values) {
            addCriterion("DESK_ID not in", values, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdBetween(Long value1, Long value2) {
            addCriterion("DESK_ID between", value1, value2, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotBetween(Long value1, Long value2) {
            addCriterion("DESK_ID not between", value1, value2, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskStatusIsNull() {
            addCriterion("DESK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDeskStatusIsNotNull() {
            addCriterion("DESK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDeskStatusEqualTo(Integer value) {
            addCriterion("DESK_STATUS =", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusNotEqualTo(Integer value) {
            addCriterion("DESK_STATUS <>", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusGreaterThan(Integer value) {
            addCriterion("DESK_STATUS >", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("DESK_STATUS >=", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusLessThan(Integer value) {
            addCriterion("DESK_STATUS <", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("DESK_STATUS <=", value, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusIn(List<Integer> values) {
            addCriterion("DESK_STATUS in", values, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusNotIn(List<Integer> values) {
            addCriterion("DESK_STATUS not in", values, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusBetween(Integer value1, Integer value2) {
            addCriterion("DESK_STATUS between", value1, value2, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andDeskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("DESK_STATUS not between", value1, value2, "deskStatus");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagIsNull() {
            addCriterion("IS_VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagIsNotNull() {
            addCriterion("IS_VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagEqualTo(Boolean value) {
            addCriterion("IS_VALID_FLAG =", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagNotEqualTo(Boolean value) {
            addCriterion("IS_VALID_FLAG <>", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagGreaterThan(Boolean value) {
            addCriterion("IS_VALID_FLAG >", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_VALID_FLAG >=", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagLessThan(Boolean value) {
            addCriterion("IS_VALID_FLAG <", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_VALID_FLAG <=", value, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagIn(List<Boolean> values) {
            addCriterion("IS_VALID_FLAG in", values, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagNotIn(List<Boolean> values) {
            addCriterion("IS_VALID_FLAG not in", values, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_VALID_FLAG between", value1, value2, "isValidFlag");
            return (Criteria) this;
        }

        public Criteria andIsValidFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_VALID_FLAG not between", value1, value2, "isValidFlag");
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
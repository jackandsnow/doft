package com.doft.pojo;

import java.util.ArrayList;
import java.util.List;

public class RolePermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolePermissionExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNull() {
            addCriterion("ROLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("ROLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(String value) {
            addCriterion("ROLE_TYPE =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(String value) {
            addCriterion("ROLE_TYPE <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(String value) {
            addCriterion("ROLE_TYPE >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(String value) {
            addCriterion("ROLE_TYPE <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_TYPE <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLike(String value) {
            addCriterion("ROLE_TYPE like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotLike(String value) {
            addCriterion("ROLE_TYPE not like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<String> values) {
            addCriterion("ROLE_TYPE in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<String> values) {
            addCriterion("ROLE_TYPE not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(String value1, String value2) {
            addCriterion("ROLE_TYPE not between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagIsNull() {
            addCriterion("ORDER_MANAGE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagIsNotNull() {
            addCriterion("ORDER_MANAGE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagEqualTo(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG =", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagNotEqualTo(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG <>", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagGreaterThan(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG >", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG >=", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagLessThan(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG <", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("ORDER_MANAGE_FLAG <=", value, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagIn(List<Boolean> values) {
            addCriterion("ORDER_MANAGE_FLAG in", values, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagNotIn(List<Boolean> values) {
            addCriterion("ORDER_MANAGE_FLAG not in", values, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("ORDER_MANAGE_FLAG between", value1, value2, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andOrderManageFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ORDER_MANAGE_FLAG not between", value1, value2, "orderManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagIsNull() {
            addCriterion("USER_MANAGE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagIsNotNull() {
            addCriterion("USER_MANAGE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagEqualTo(Boolean value) {
            addCriterion("USER_MANAGE_FLAG =", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagNotEqualTo(Boolean value) {
            addCriterion("USER_MANAGE_FLAG <>", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagGreaterThan(Boolean value) {
            addCriterion("USER_MANAGE_FLAG >", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("USER_MANAGE_FLAG >=", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagLessThan(Boolean value) {
            addCriterion("USER_MANAGE_FLAG <", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("USER_MANAGE_FLAG <=", value, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagIn(List<Boolean> values) {
            addCriterion("USER_MANAGE_FLAG in", values, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagNotIn(List<Boolean> values) {
            addCriterion("USER_MANAGE_FLAG not in", values, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("USER_MANAGE_FLAG between", value1, value2, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andUserManageFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("USER_MANAGE_FLAG not between", value1, value2, "userManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagIsNull() {
            addCriterion("INFO_MANAGE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagIsNotNull() {
            addCriterion("INFO_MANAGE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagEqualTo(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG =", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagNotEqualTo(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG <>", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagGreaterThan(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG >", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG >=", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagLessThan(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG <", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("INFO_MANAGE_FLAG <=", value, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagIn(List<Boolean> values) {
            addCriterion("INFO_MANAGE_FLAG in", values, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagNotIn(List<Boolean> values) {
            addCriterion("INFO_MANAGE_FLAG not in", values, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("INFO_MANAGE_FLAG between", value1, value2, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andInfoManageFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("INFO_MANAGE_FLAG not between", value1, value2, "infoManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagIsNull() {
            addCriterion("SYSTEM_MANAGE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagIsNotNull() {
            addCriterion("SYSTEM_MANAGE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagEqualTo(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG =", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagNotEqualTo(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG <>", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagGreaterThan(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG >", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG >=", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagLessThan(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG <", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("SYSTEM_MANAGE_FLAG <=", value, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagIn(List<Boolean> values) {
            addCriterion("SYSTEM_MANAGE_FLAG in", values, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagNotIn(List<Boolean> values) {
            addCriterion("SYSTEM_MANAGE_FLAG not in", values, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("SYSTEM_MANAGE_FLAG between", value1, value2, "systemManageFlag");
            return (Criteria) this;
        }

        public Criteria andSystemManageFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SYSTEM_MANAGE_FLAG not between", value1, value2, "systemManageFlag");
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
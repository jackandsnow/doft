package com.doft.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageEventExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("MESSAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("MESSAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Long value) {
            addCriterion("MESSAGE_ID =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Long value) {
            addCriterion("MESSAGE_ID <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Long value) {
            addCriterion("MESSAGE_ID >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_ID >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Long value) {
            addCriterion("MESSAGE_ID <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_ID <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Long> values) {
            addCriterion("MESSAGE_ID in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Long> values) {
            addCriterion("MESSAGE_ID not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_ID between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_ID not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("MESSAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("MESSAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Integer value) {
            addCriterion("MESSAGE_TYPE =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Integer value) {
            addCriterion("MESSAGE_TYPE <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Integer value) {
            addCriterion("MESSAGE_TYPE >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MESSAGE_TYPE >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Integer value) {
            addCriterion("MESSAGE_TYPE <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("MESSAGE_TYPE <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Integer> values) {
            addCriterion("MESSAGE_TYPE in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Integer> values) {
            addCriterion("MESSAGE_TYPE not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGE_TYPE between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGE_TYPE not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdIsNull() {
            addCriterion("SEND_TO_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdIsNotNull() {
            addCriterion("SEND_TO_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdEqualTo(String value) {
            addCriterion("SEND_TO_USER_ID =", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdNotEqualTo(String value) {
            addCriterion("SEND_TO_USER_ID <>", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdGreaterThan(String value) {
            addCriterion("SEND_TO_USER_ID >", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TO_USER_ID >=", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdLessThan(String value) {
            addCriterion("SEND_TO_USER_ID <", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdLessThanOrEqualTo(String value) {
            addCriterion("SEND_TO_USER_ID <=", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdLike(String value) {
            addCriterion("SEND_TO_USER_ID like", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdNotLike(String value) {
            addCriterion("SEND_TO_USER_ID not like", value, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdIn(List<String> values) {
            addCriterion("SEND_TO_USER_ID in", values, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdNotIn(List<String> values) {
            addCriterion("SEND_TO_USER_ID not in", values, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdBetween(String value1, String value2) {
            addCriterion("SEND_TO_USER_ID between", value1, value2, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendToUserIdNotBetween(String value1, String value2) {
            addCriterion("SEND_TO_USER_ID not between", value1, value2, "sendToUserId");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
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

        public Criteria andIsDeletedFlagIsNull() {
            addCriterion("IS_DELETED_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagIsNotNull() {
            addCriterion("IS_DELETED_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagEqualTo(Boolean value) {
            addCriterion("IS_DELETED_FLAG =", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagNotEqualTo(Boolean value) {
            addCriterion("IS_DELETED_FLAG <>", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagGreaterThan(Boolean value) {
            addCriterion("IS_DELETED_FLAG >", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED_FLAG >=", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagLessThan(Boolean value) {
            addCriterion("IS_DELETED_FLAG <", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED_FLAG <=", value, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagIn(List<Boolean> values) {
            addCriterion("IS_DELETED_FLAG in", values, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagNotIn(List<Boolean> values) {
            addCriterion("IS_DELETED_FLAG not in", values, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED_FLAG between", value1, value2, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andIsDeletedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED_FLAG not between", value1, value2, "isDeletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedByIsNull() {
            addCriterion("DELETED_BY is null");
            return (Criteria) this;
        }

        public Criteria andDeletedByIsNotNull() {
            addCriterion("DELETED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedByEqualTo(String value) {
            addCriterion("DELETED_BY =", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByNotEqualTo(String value) {
            addCriterion("DELETED_BY <>", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByGreaterThan(String value) {
            addCriterion("DELETED_BY >", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByGreaterThanOrEqualTo(String value) {
            addCriterion("DELETED_BY >=", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByLessThan(String value) {
            addCriterion("DELETED_BY <", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByLessThanOrEqualTo(String value) {
            addCriterion("DELETED_BY <=", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByLike(String value) {
            addCriterion("DELETED_BY like", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByNotLike(String value) {
            addCriterion("DELETED_BY not like", value, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByIn(List<String> values) {
            addCriterion("DELETED_BY in", values, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByNotIn(List<String> values) {
            addCriterion("DELETED_BY not in", values, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByBetween(String value1, String value2) {
            addCriterion("DELETED_BY between", value1, value2, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedByNotBetween(String value1, String value2) {
            addCriterion("DELETED_BY not between", value1, value2, "deletedBy");
            return (Criteria) this;
        }

        public Criteria andDeletedDateIsNull() {
            addCriterion("DELETED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDeletedDateIsNotNull() {
            addCriterion("DELETED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedDateEqualTo(Date value) {
            addCriterion("DELETED_DATE =", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateNotEqualTo(Date value) {
            addCriterion("DELETED_DATE <>", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateGreaterThan(Date value) {
            addCriterion("DELETED_DATE >", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DELETED_DATE >=", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateLessThan(Date value) {
            addCriterion("DELETED_DATE <", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateLessThanOrEqualTo(Date value) {
            addCriterion("DELETED_DATE <=", value, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateIn(List<Date> values) {
            addCriterion("DELETED_DATE in", values, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateNotIn(List<Date> values) {
            addCriterion("DELETED_DATE not in", values, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateBetween(Date value1, Date value2) {
            addCriterion("DELETED_DATE between", value1, value2, "deletedDate");
            return (Criteria) this;
        }

        public Criteria andDeletedDateNotBetween(Date value1, Date value2) {
            addCriterion("DELETED_DATE not between", value1, value2, "deletedDate");
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
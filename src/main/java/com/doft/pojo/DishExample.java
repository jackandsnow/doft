package com.doft.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DishExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDishTypeIdIsNull() {
            addCriterion("DISH_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdIsNotNull() {
            addCriterion("DISH_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdEqualTo(Long value) {
            addCriterion("DISH_TYPE_ID =", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdNotEqualTo(Long value) {
            addCriterion("DISH_TYPE_ID <>", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdGreaterThan(Long value) {
            addCriterion("DISH_TYPE_ID >", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DISH_TYPE_ID >=", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdLessThan(Long value) {
            addCriterion("DISH_TYPE_ID <", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("DISH_TYPE_ID <=", value, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdIn(List<Long> values) {
            addCriterion("DISH_TYPE_ID in", values, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdNotIn(List<Long> values) {
            addCriterion("DISH_TYPE_ID not in", values, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdBetween(Long value1, Long value2) {
            addCriterion("DISH_TYPE_ID between", value1, value2, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("DISH_TYPE_ID not between", value1, value2, "dishTypeId");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlIsNull() {
            addCriterion("DISH_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlIsNotNull() {
            addCriterion("DISH_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlEqualTo(String value) {
            addCriterion("DISH_IMG_URL =", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlNotEqualTo(String value) {
            addCriterion("DISH_IMG_URL <>", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlGreaterThan(String value) {
            addCriterion("DISH_IMG_URL >", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("DISH_IMG_URL >=", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlLessThan(String value) {
            addCriterion("DISH_IMG_URL <", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlLessThanOrEqualTo(String value) {
            addCriterion("DISH_IMG_URL <=", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlLike(String value) {
            addCriterion("DISH_IMG_URL like", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlNotLike(String value) {
            addCriterion("DISH_IMG_URL not like", value, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlIn(List<String> values) {
            addCriterion("DISH_IMG_URL in", values, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlNotIn(List<String> values) {
            addCriterion("DISH_IMG_URL not in", values, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlBetween(String value1, String value2) {
            addCriterion("DISH_IMG_URL between", value1, value2, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andDishImgUrlNotBetween(String value1, String value2) {
            addCriterion("DISH_IMG_URL not between", value1, value2, "dishImgUrl");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNull() {
            addCriterion("TOTAL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNotNull() {
            addCriterion("TOTAL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER =", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER <>", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThan(Integer value) {
            addCriterion("TOTAL_NUMBER >", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER >=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThan(Integer value) {
            addCriterion("TOTAL_NUMBER <", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER <=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIn(List<Integer> values) {
            addCriterion("TOTAL_NUMBER in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotIn(List<Integer> values) {
            addCriterion("TOTAL_NUMBER not in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NUMBER between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NUMBER not between", value1, value2, "totalNumber");
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

        public Criteria andIsBargainFlagIsNull() {
            addCriterion("IS_BARGAIN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagIsNotNull() {
            addCriterion("IS_BARGAIN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagEqualTo(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG =", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagNotEqualTo(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG <>", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagGreaterThan(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG >", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG >=", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagLessThan(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG <", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_BARGAIN_FLAG <=", value, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagIn(List<Boolean> values) {
            addCriterion("IS_BARGAIN_FLAG in", values, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagNotIn(List<Boolean> values) {
            addCriterion("IS_BARGAIN_FLAG not in", values, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_BARGAIN_FLAG between", value1, value2, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andIsBargainFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_BARGAIN_FLAG not between", value1, value2, "isBargainFlag");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("CREATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("CREATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATION_DATE =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATION_DATE <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATION_DATE >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATION_DATE >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATION_DATE <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATION_DATE <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATION_DATE in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATION_DATE not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATION_DATE between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATION_DATE not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateIsNull() {
            addCriterion("LAST_UPDATED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateIsNotNull() {
            addCriterion("LAST_UPDATED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE =", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE <>", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE >", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE >=", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateLessThan(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE <", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE <=", value, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE in", values, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE not in", values, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE between", value1, value2, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_UPDATED_DATE not between", value1, value2, "lastUpdatedDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNull() {
            addCriterion("LAST_UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNotNull() {
            addCriterion("LAST_UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY =", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <>", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThan(String value) {
            addCriterion("LAST_UPDATED_BY >", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY >=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThan(String value) {
            addCriterion("LAST_UPDATED_BY <", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLike(String value) {
            addCriterion("LAST_UPDATED_BY like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotLike(String value) {
            addCriterion("LAST_UPDATED_BY not like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY not in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY not between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexIsNull() {
            addCriterion("RECOMMEND_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexIsNotNull() {
            addCriterion("RECOMMEND_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexEqualTo(Float value) {
            addCriterion("RECOMMEND_INDEX =", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexNotEqualTo(Float value) {
            addCriterion("RECOMMEND_INDEX <>", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexGreaterThan(Float value) {
            addCriterion("RECOMMEND_INDEX >", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexGreaterThanOrEqualTo(Float value) {
            addCriterion("RECOMMEND_INDEX >=", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexLessThan(Float value) {
            addCriterion("RECOMMEND_INDEX <", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexLessThanOrEqualTo(Float value) {
            addCriterion("RECOMMEND_INDEX <=", value, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexIn(List<Float> values) {
            addCriterion("RECOMMEND_INDEX in", values, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexNotIn(List<Float> values) {
            addCriterion("RECOMMEND_INDEX not in", values, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexBetween(Float value1, Float value2) {
            addCriterion("RECOMMEND_INDEX between", value1, value2, "recommendIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendIndexNotBetween(Float value1, Float value2) {
            addCriterion("RECOMMEND_INDEX not between", value1, value2, "recommendIndex");
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
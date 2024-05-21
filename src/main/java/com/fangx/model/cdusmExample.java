package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdusmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusmExample() {
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

        public Criteria andUsm001IsNull() {
            addCriterion("USM001 is null");
            return (Criteria) this;
        }

        public Criteria andUsm001IsNotNull() {
            addCriterion("USM001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsm001EqualTo(Integer value) {
            addCriterion("USM001 =", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001NotEqualTo(Integer value) {
            addCriterion("USM001 <>", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001GreaterThan(Integer value) {
            addCriterion("USM001 >", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USM001 >=", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001LessThan(Integer value) {
            addCriterion("USM001 <", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001LessThanOrEqualTo(Integer value) {
            addCriterion("USM001 <=", value, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001In(List<Integer> values) {
            addCriterion("USM001 in", values, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001NotIn(List<Integer> values) {
            addCriterion("USM001 not in", values, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001Between(Integer value1, Integer value2) {
            addCriterion("USM001 between", value1, value2, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm001NotBetween(Integer value1, Integer value2) {
            addCriterion("USM001 not between", value1, value2, "usm001");
            return (Criteria) this;
        }

        public Criteria andUsm002IsNull() {
            addCriterion("USM002 is null");
            return (Criteria) this;
        }

        public Criteria andUsm002IsNotNull() {
            addCriterion("USM002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsm002EqualTo(String value) {
            addCriterion("USM002 =", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002NotEqualTo(String value) {
            addCriterion("USM002 <>", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002GreaterThan(String value) {
            addCriterion("USM002 >", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002GreaterThanOrEqualTo(String value) {
            addCriterion("USM002 >=", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002LessThan(String value) {
            addCriterion("USM002 <", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002LessThanOrEqualTo(String value) {
            addCriterion("USM002 <=", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002Like(String value) {
            addCriterion("USM002 like", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002NotLike(String value) {
            addCriterion("USM002 not like", value, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002In(List<String> values) {
            addCriterion("USM002 in", values, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002NotIn(List<String> values) {
            addCriterion("USM002 not in", values, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002Between(String value1, String value2) {
            addCriterion("USM002 between", value1, value2, "usm002");
            return (Criteria) this;
        }

        public Criteria andUsm002NotBetween(String value1, String value2) {
            addCriterion("USM002 not between", value1, value2, "usm002");
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
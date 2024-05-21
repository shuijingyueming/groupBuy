package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdusaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusaExample() {
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

        public Criteria andUsa001IsNull() {
            addCriterion("USA001 is null");
            return (Criteria) this;
        }

        public Criteria andUsa001IsNotNull() {
            addCriterion("USA001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa001EqualTo(Integer value) {
            addCriterion("USA001 =", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001NotEqualTo(Integer value) {
            addCriterion("USA001 <>", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001GreaterThan(Integer value) {
            addCriterion("USA001 >", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USA001 >=", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001LessThan(Integer value) {
            addCriterion("USA001 <", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001LessThanOrEqualTo(Integer value) {
            addCriterion("USA001 <=", value, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001In(List<Integer> values) {
            addCriterion("USA001 in", values, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001NotIn(List<Integer> values) {
            addCriterion("USA001 not in", values, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001Between(Integer value1, Integer value2) {
            addCriterion("USA001 between", value1, value2, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa001NotBetween(Integer value1, Integer value2) {
            addCriterion("USA001 not between", value1, value2, "usa001");
            return (Criteria) this;
        }

        public Criteria andUsa002IsNull() {
            addCriterion("USA002 is null");
            return (Criteria) this;
        }

        public Criteria andUsa002IsNotNull() {
            addCriterion("USA002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa002EqualTo(String value) {
            addCriterion("USA002 =", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002NotEqualTo(String value) {
            addCriterion("USA002 <>", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002GreaterThan(String value) {
            addCriterion("USA002 >", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002GreaterThanOrEqualTo(String value) {
            addCriterion("USA002 >=", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002LessThan(String value) {
            addCriterion("USA002 <", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002LessThanOrEqualTo(String value) {
            addCriterion("USA002 <=", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002Like(String value) {
            addCriterion("USA002 like", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002NotLike(String value) {
            addCriterion("USA002 not like", value, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002In(List<String> values) {
            addCriterion("USA002 in", values, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002NotIn(List<String> values) {
            addCriterion("USA002 not in", values, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002Between(String value1, String value2) {
            addCriterion("USA002 between", value1, value2, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa002NotBetween(String value1, String value2) {
            addCriterion("USA002 not between", value1, value2, "usa002");
            return (Criteria) this;
        }

        public Criteria andUsa003IsNull() {
            addCriterion("USA003 is null");
            return (Criteria) this;
        }

        public Criteria andUsa003IsNotNull() {
            addCriterion("USA003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa003EqualTo(Integer value) {
            addCriterion("USA003 =", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003NotEqualTo(Integer value) {
            addCriterion("USA003 <>", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003GreaterThan(Integer value) {
            addCriterion("USA003 >", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003GreaterThanOrEqualTo(Integer value) {
            addCriterion("USA003 >=", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003LessThan(Integer value) {
            addCriterion("USA003 <", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003LessThanOrEqualTo(Integer value) {
            addCriterion("USA003 <=", value, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003In(List<Integer> values) {
            addCriterion("USA003 in", values, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003NotIn(List<Integer> values) {
            addCriterion("USA003 not in", values, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003Between(Integer value1, Integer value2) {
            addCriterion("USA003 between", value1, value2, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa003NotBetween(Integer value1, Integer value2) {
            addCriterion("USA003 not between", value1, value2, "usa003");
            return (Criteria) this;
        }

        public Criteria andUsa004IsNull() {
            addCriterion("USA004 is null");
            return (Criteria) this;
        }

        public Criteria andUsa004IsNotNull() {
            addCriterion("USA004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa004EqualTo(String value) {
            addCriterion("USA004 =", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004NotEqualTo(String value) {
            addCriterion("USA004 <>", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004GreaterThan(String value) {
            addCriterion("USA004 >", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004GreaterThanOrEqualTo(String value) {
            addCriterion("USA004 >=", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004LessThan(String value) {
            addCriterion("USA004 <", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004LessThanOrEqualTo(String value) {
            addCriterion("USA004 <=", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004Like(String value) {
            addCriterion("USA004 like", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004NotLike(String value) {
            addCriterion("USA004 not like", value, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004In(List<String> values) {
            addCriterion("USA004 in", values, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004NotIn(List<String> values) {
            addCriterion("USA004 not in", values, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004Between(String value1, String value2) {
            addCriterion("USA004 between", value1, value2, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa004NotBetween(String value1, String value2) {
            addCriterion("USA004 not between", value1, value2, "usa004");
            return (Criteria) this;
        }

        public Criteria andUsa005IsNull() {
            addCriterion("USA005 is null");
            return (Criteria) this;
        }

        public Criteria andUsa005IsNotNull() {
            addCriterion("USA005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa005EqualTo(String value) {
            addCriterion("USA005 =", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005NotEqualTo(String value) {
            addCriterion("USA005 <>", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005GreaterThan(String value) {
            addCriterion("USA005 >", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005GreaterThanOrEqualTo(String value) {
            addCriterion("USA005 >=", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005LessThan(String value) {
            addCriterion("USA005 <", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005LessThanOrEqualTo(String value) {
            addCriterion("USA005 <=", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005Like(String value) {
            addCriterion("USA005 like", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005NotLike(String value) {
            addCriterion("USA005 not like", value, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005In(List<String> values) {
            addCriterion("USA005 in", values, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005NotIn(List<String> values) {
            addCriterion("USA005 not in", values, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005Between(String value1, String value2) {
            addCriterion("USA005 between", value1, value2, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa005NotBetween(String value1, String value2) {
            addCriterion("USA005 not between", value1, value2, "usa005");
            return (Criteria) this;
        }

        public Criteria andUsa006IsNull() {
            addCriterion("USA006 is null");
            return (Criteria) this;
        }

        public Criteria andUsa006IsNotNull() {
            addCriterion("USA006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsa006EqualTo(String value) {
            addCriterion("USA006 =", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006NotEqualTo(String value) {
            addCriterion("USA006 <>", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006GreaterThan(String value) {
            addCriterion("USA006 >", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006GreaterThanOrEqualTo(String value) {
            addCriterion("USA006 >=", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006LessThan(String value) {
            addCriterion("USA006 <", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006LessThanOrEqualTo(String value) {
            addCriterion("USA006 <=", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006Like(String value) {
            addCriterion("USA006 like", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006NotLike(String value) {
            addCriterion("USA006 not like", value, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006In(List<String> values) {
            addCriterion("USA006 in", values, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006NotIn(List<String> values) {
            addCriterion("USA006 not in", values, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006Between(String value1, String value2) {
            addCriterion("USA006 between", value1, value2, "usa006");
            return (Criteria) this;
        }

        public Criteria andUsa006NotBetween(String value1, String value2) {
            addCriterion("USA006 not between", value1, value2, "usa006");
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
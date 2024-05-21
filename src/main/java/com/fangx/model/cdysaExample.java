package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdysaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdysaExample() {
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

        public Criteria andYsa001IsNull() {
            addCriterion("YSA001 is null");
            return (Criteria) this;
        }

        public Criteria andYsa001IsNotNull() {
            addCriterion("YSA001 is not null");
            return (Criteria) this;
        }

        public Criteria andYsa001EqualTo(Integer value) {
            addCriterion("YSA001 =", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001NotEqualTo(Integer value) {
            addCriterion("YSA001 <>", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001GreaterThan(Integer value) {
            addCriterion("YSA001 >", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSA001 >=", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001LessThan(Integer value) {
            addCriterion("YSA001 <", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001LessThanOrEqualTo(Integer value) {
            addCriterion("YSA001 <=", value, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001In(List<Integer> values) {
            addCriterion("YSA001 in", values, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001NotIn(List<Integer> values) {
            addCriterion("YSA001 not in", values, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001Between(Integer value1, Integer value2) {
            addCriterion("YSA001 between", value1, value2, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa001NotBetween(Integer value1, Integer value2) {
            addCriterion("YSA001 not between", value1, value2, "ysa001");
            return (Criteria) this;
        }

        public Criteria andYsa002IsNull() {
            addCriterion("YSA002 is null");
            return (Criteria) this;
        }

        public Criteria andYsa002IsNotNull() {
            addCriterion("YSA002 is not null");
            return (Criteria) this;
        }

        public Criteria andYsa002EqualTo(String value) {
            addCriterion("YSA002 =", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002NotEqualTo(String value) {
            addCriterion("YSA002 <>", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002GreaterThan(String value) {
            addCriterion("YSA002 >", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002GreaterThanOrEqualTo(String value) {
            addCriterion("YSA002 >=", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002LessThan(String value) {
            addCriterion("YSA002 <", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002LessThanOrEqualTo(String value) {
            addCriterion("YSA002 <=", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002Like(String value) {
            addCriterion("YSA002 like", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002NotLike(String value) {
            addCriterion("YSA002 not like", value, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002In(List<String> values) {
            addCriterion("YSA002 in", values, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002NotIn(List<String> values) {
            addCriterion("YSA002 not in", values, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002Between(String value1, String value2) {
            addCriterion("YSA002 between", value1, value2, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa002NotBetween(String value1, String value2) {
            addCriterion("YSA002 not between", value1, value2, "ysa002");
            return (Criteria) this;
        }

        public Criteria andYsa003IsNull() {
            addCriterion("YSA003 is null");
            return (Criteria) this;
        }

        public Criteria andYsa003IsNotNull() {
            addCriterion("YSA003 is not null");
            return (Criteria) this;
        }

        public Criteria andYsa003EqualTo(Integer value) {
            addCriterion("YSA003 =", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003NotEqualTo(Integer value) {
            addCriterion("YSA003 <>", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003GreaterThan(Integer value) {
            addCriterion("YSA003 >", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSA003 >=", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003LessThan(Integer value) {
            addCriterion("YSA003 <", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003LessThanOrEqualTo(Integer value) {
            addCriterion("YSA003 <=", value, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003In(List<Integer> values) {
            addCriterion("YSA003 in", values, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003NotIn(List<Integer> values) {
            addCriterion("YSA003 not in", values, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003Between(Integer value1, Integer value2) {
            addCriterion("YSA003 between", value1, value2, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa003NotBetween(Integer value1, Integer value2) {
            addCriterion("YSA003 not between", value1, value2, "ysa003");
            return (Criteria) this;
        }

        public Criteria andYsa004IsNull() {
            addCriterion("YSA004 is null");
            return (Criteria) this;
        }

        public Criteria andYsa004IsNotNull() {
            addCriterion("YSA004 is not null");
            return (Criteria) this;
        }

        public Criteria andYsa004EqualTo(String value) {
            addCriterion("YSA004 =", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004NotEqualTo(String value) {
            addCriterion("YSA004 <>", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004GreaterThan(String value) {
            addCriterion("YSA004 >", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004GreaterThanOrEqualTo(String value) {
            addCriterion("YSA004 >=", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004LessThan(String value) {
            addCriterion("YSA004 <", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004LessThanOrEqualTo(String value) {
            addCriterion("YSA004 <=", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004Like(String value) {
            addCriterion("YSA004 like", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004NotLike(String value) {
            addCriterion("YSA004 not like", value, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004In(List<String> values) {
            addCriterion("YSA004 in", values, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004NotIn(List<String> values) {
            addCriterion("YSA004 not in", values, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004Between(String value1, String value2) {
            addCriterion("YSA004 between", value1, value2, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa004NotBetween(String value1, String value2) {
            addCriterion("YSA004 not between", value1, value2, "ysa004");
            return (Criteria) this;
        }

        public Criteria andYsa005IsNull() {
            addCriterion("YSA005 is null");
            return (Criteria) this;
        }

        public Criteria andYsa005IsNotNull() {
            addCriterion("YSA005 is not null");
            return (Criteria) this;
        }

        public Criteria andYsa005EqualTo(String value) {
            addCriterion("YSA005 =", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005NotEqualTo(String value) {
            addCriterion("YSA005 <>", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005GreaterThan(String value) {
            addCriterion("YSA005 >", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005GreaterThanOrEqualTo(String value) {
            addCriterion("YSA005 >=", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005LessThan(String value) {
            addCriterion("YSA005 <", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005LessThanOrEqualTo(String value) {
            addCriterion("YSA005 <=", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005Like(String value) {
            addCriterion("YSA005 like", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005NotLike(String value) {
            addCriterion("YSA005 not like", value, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005In(List<String> values) {
            addCriterion("YSA005 in", values, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005NotIn(List<String> values) {
            addCriterion("YSA005 not in", values, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005Between(String value1, String value2) {
            addCriterion("YSA005 between", value1, value2, "ysa005");
            return (Criteria) this;
        }

        public Criteria andYsa005NotBetween(String value1, String value2) {
            addCriterion("YSA005 not between", value1, value2, "ysa005");
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
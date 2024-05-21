package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdyheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyheExample() {
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

        public Criteria andYhe001IsNull() {
            addCriterion("YHE001 is null");
            return (Criteria) this;
        }

        public Criteria andYhe001IsNotNull() {
            addCriterion("YHE001 is not null");
            return (Criteria) this;
        }

        public Criteria andYhe001EqualTo(Integer value) {
            addCriterion("YHE001 =", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001NotEqualTo(Integer value) {
            addCriterion("YHE001 <>", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001GreaterThan(Integer value) {
            addCriterion("YHE001 >", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHE001 >=", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001LessThan(Integer value) {
            addCriterion("YHE001 <", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001LessThanOrEqualTo(Integer value) {
            addCriterion("YHE001 <=", value, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001In(List<Integer> values) {
            addCriterion("YHE001 in", values, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001NotIn(List<Integer> values) {
            addCriterion("YHE001 not in", values, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001Between(Integer value1, Integer value2) {
            addCriterion("YHE001 between", value1, value2, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe001NotBetween(Integer value1, Integer value2) {
            addCriterion("YHE001 not between", value1, value2, "yhe001");
            return (Criteria) this;
        }

        public Criteria andYhe002IsNull() {
            addCriterion("YHE002 is null");
            return (Criteria) this;
        }

        public Criteria andYhe002IsNotNull() {
            addCriterion("YHE002 is not null");
            return (Criteria) this;
        }

        public Criteria andYhe002EqualTo(String value) {
            addCriterion("YHE002 =", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002NotEqualTo(String value) {
            addCriterion("YHE002 <>", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002GreaterThan(String value) {
            addCriterion("YHE002 >", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002GreaterThanOrEqualTo(String value) {
            addCriterion("YHE002 >=", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002LessThan(String value) {
            addCriterion("YHE002 <", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002LessThanOrEqualTo(String value) {
            addCriterion("YHE002 <=", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002Like(String value) {
            addCriterion("YHE002 like", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002NotLike(String value) {
            addCriterion("YHE002 not like", value, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002In(List<String> values) {
            addCriterion("YHE002 in", values, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002NotIn(List<String> values) {
            addCriterion("YHE002 not in", values, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002Between(String value1, String value2) {
            addCriterion("YHE002 between", value1, value2, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe002NotBetween(String value1, String value2) {
            addCriterion("YHE002 not between", value1, value2, "yhe002");
            return (Criteria) this;
        }

        public Criteria andYhe003IsNull() {
            addCriterion("YHE003 is null");
            return (Criteria) this;
        }

        public Criteria andYhe003IsNotNull() {
            addCriterion("YHE003 is not null");
            return (Criteria) this;
        }

        public Criteria andYhe003EqualTo(String value) {
            addCriterion("YHE003 =", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003NotEqualTo(String value) {
            addCriterion("YHE003 <>", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003GreaterThan(String value) {
            addCriterion("YHE003 >", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003GreaterThanOrEqualTo(String value) {
            addCriterion("YHE003 >=", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003LessThan(String value) {
            addCriterion("YHE003 <", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003LessThanOrEqualTo(String value) {
            addCriterion("YHE003 <=", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003Like(String value) {
            addCriterion("YHE003 like", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003NotLike(String value) {
            addCriterion("YHE003 not like", value, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003In(List<String> values) {
            addCriterion("YHE003 in", values, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003NotIn(List<String> values) {
            addCriterion("YHE003 not in", values, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003Between(String value1, String value2) {
            addCriterion("YHE003 between", value1, value2, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe003NotBetween(String value1, String value2) {
            addCriterion("YHE003 not between", value1, value2, "yhe003");
            return (Criteria) this;
        }

        public Criteria andYhe004IsNull() {
            addCriterion("YHE004 is null");
            return (Criteria) this;
        }

        public Criteria andYhe004IsNotNull() {
            addCriterion("YHE004 is not null");
            return (Criteria) this;
        }

        public Criteria andYhe004EqualTo(String value) {
            addCriterion("YHE004 =", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004NotEqualTo(String value) {
            addCriterion("YHE004 <>", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004GreaterThan(String value) {
            addCriterion("YHE004 >", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004GreaterThanOrEqualTo(String value) {
            addCriterion("YHE004 >=", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004LessThan(String value) {
            addCriterion("YHE004 <", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004LessThanOrEqualTo(String value) {
            addCriterion("YHE004 <=", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004Like(String value) {
            addCriterion("YHE004 like", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004NotLike(String value) {
            addCriterion("YHE004 not like", value, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004In(List<String> values) {
            addCriterion("YHE004 in", values, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004NotIn(List<String> values) {
            addCriterion("YHE004 not in", values, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004Between(String value1, String value2) {
            addCriterion("YHE004 between", value1, value2, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe004NotBetween(String value1, String value2) {
            addCriterion("YHE004 not between", value1, value2, "yhe004");
            return (Criteria) this;
        }

        public Criteria andYhe005IsNull() {
            addCriterion("YHE005 is null");
            return (Criteria) this;
        }

        public Criteria andYhe005IsNotNull() {
            addCriterion("YHE005 is not null");
            return (Criteria) this;
        }

        public Criteria andYhe005EqualTo(String value) {
            addCriterion("YHE005 =", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005NotEqualTo(String value) {
            addCriterion("YHE005 <>", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005GreaterThan(String value) {
            addCriterion("YHE005 >", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005GreaterThanOrEqualTo(String value) {
            addCriterion("YHE005 >=", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005LessThan(String value) {
            addCriterion("YHE005 <", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005LessThanOrEqualTo(String value) {
            addCriterion("YHE005 <=", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005Like(String value) {
            addCriterion("YHE005 like", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005NotLike(String value) {
            addCriterion("YHE005 not like", value, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005In(List<String> values) {
            addCriterion("YHE005 in", values, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005NotIn(List<String> values) {
            addCriterion("YHE005 not in", values, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005Between(String value1, String value2) {
            addCriterion("YHE005 between", value1, value2, "yhe005");
            return (Criteria) this;
        }

        public Criteria andYhe005NotBetween(String value1, String value2) {
            addCriterion("YHE005 not between", value1, value2, "yhe005");
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
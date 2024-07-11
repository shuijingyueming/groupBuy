package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdyhbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyhbExample() {
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

        public Criteria andYhb001IsNull() {
            addCriterion("YHB001 is null");
            return (Criteria) this;
        }

        public Criteria andYhb001IsNotNull() {
            addCriterion("YHB001 is not null");
            return (Criteria) this;
        }

        public Criteria andYhb001EqualTo(String value) {
            addCriterion("YHB001 =", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001NotEqualTo(String value) {
            addCriterion("YHB001 <>", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001GreaterThan(String value) {
            addCriterion("YHB001 >", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001GreaterThanOrEqualTo(String value) {
            addCriterion("YHB001 >=", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001LessThan(String value) {
            addCriterion("YHB001 <", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001LessThanOrEqualTo(String value) {
            addCriterion("YHB001 <=", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001Like(String value) {
            addCriterion("YHB001 like", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001NotLike(String value) {
            addCriterion("YHB001 not like", value, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001In(List<String> values) {
            addCriterion("YHB001 in", values, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001NotIn(List<String> values) {
            addCriterion("YHB001 not in", values, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001Between(String value1, String value2) {
            addCriterion("YHB001 between", value1, value2, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb001NotBetween(String value1, String value2) {
            addCriterion("YHB001 not between", value1, value2, "yhb001");
            return (Criteria) this;
        }

        public Criteria andYhb002IsNull() {
            addCriterion("YHB002 is null");
            return (Criteria) this;
        }

        public Criteria andYhb002IsNotNull() {
            addCriterion("YHB002 is not null");
            return (Criteria) this;
        }

        public Criteria andYhb002EqualTo(Integer value) {
            addCriterion("YHB002 =", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002NotEqualTo(Integer value) {
            addCriterion("YHB002 <>", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002GreaterThan(Integer value) {
            addCriterion("YHB002 >", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHB002 >=", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002LessThan(Integer value) {
            addCriterion("YHB002 <", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002LessThanOrEqualTo(Integer value) {
            addCriterion("YHB002 <=", value, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002In(List<Integer> values) {
            addCriterion("YHB002 in", values, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002NotIn(List<Integer> values) {
            addCriterion("YHB002 not in", values, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002Between(Integer value1, Integer value2) {
            addCriterion("YHB002 between", value1, value2, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb002NotBetween(Integer value1, Integer value2) {
            addCriterion("YHB002 not between", value1, value2, "yhb002");
            return (Criteria) this;
        }

        public Criteria andYhb003IsNull() {
            addCriterion("YHB003 is null");
            return (Criteria) this;
        }

        public Criteria andYhb003IsNotNull() {
            addCriterion("YHB003 is not null");
            return (Criteria) this;
        }

        public Criteria andYhb003EqualTo(Integer value) {
            addCriterion("YHB003 =", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003NotEqualTo(Integer value) {
            addCriterion("YHB003 <>", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003GreaterThan(Integer value) {
            addCriterion("YHB003 >", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHB003 >=", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003LessThan(Integer value) {
            addCriterion("YHB003 <", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003LessThanOrEqualTo(Integer value) {
            addCriterion("YHB003 <=", value, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003In(List<Integer> values) {
            addCriterion("YHB003 in", values, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003NotIn(List<Integer> values) {
            addCriterion("YHB003 not in", values, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003Between(Integer value1, Integer value2) {
            addCriterion("YHB003 between", value1, value2, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb003NotBetween(Integer value1, Integer value2) {
            addCriterion("YHB003 not between", value1, value2, "yhb003");
            return (Criteria) this;
        }

        public Criteria andYhb004IsNull() {
            addCriterion("YHB004 is null");
            return (Criteria) this;
        }

        public Criteria andYhb004IsNotNull() {
            addCriterion("YHB004 is not null");
            return (Criteria) this;
        }

        public Criteria andYhb004EqualTo(String value) {
            addCriterion("YHB004 =", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004NotEqualTo(String value) {
            addCriterion("YHB004 <>", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004GreaterThan(String value) {
            addCriterion("YHB004 >", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004GreaterThanOrEqualTo(String value) {
            addCriterion("YHB004 >=", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004LessThan(String value) {
            addCriterion("YHB004 <", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004LessThanOrEqualTo(String value) {
            addCriterion("YHB004 <=", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004Like(String value) {
            addCriterion("YHB004 like", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004NotLike(String value) {
            addCriterion("YHB004 not like", value, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004In(List<String> values) {
            addCriterion("YHB004 in", values, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004NotIn(List<String> values) {
            addCriterion("YHB004 not in", values, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004Between(String value1, String value2) {
            addCriterion("YHB004 between", value1, value2, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb004NotBetween(String value1, String value2) {
            addCriterion("YHB004 not between", value1, value2, "yhb004");
            return (Criteria) this;
        }

        public Criteria andYhb005IsNull() {
            addCriterion("YHB005 is null");
            return (Criteria) this;
        }

        public Criteria andYhb005IsNotNull() {
            addCriterion("YHB005 is not null");
            return (Criteria) this;
        }

        public Criteria andYhb005EqualTo(String value) {
            addCriterion("YHB005 =", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005NotEqualTo(String value) {
            addCriterion("YHB005 <>", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005GreaterThan(String value) {
            addCriterion("YHB005 >", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005GreaterThanOrEqualTo(String value) {
            addCriterion("YHB005 >=", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005LessThan(String value) {
            addCriterion("YHB005 <", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005LessThanOrEqualTo(String value) {
            addCriterion("YHB005 <=", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005Like(String value) {
            addCriterion("YHB005 like", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005NotLike(String value) {
            addCriterion("YHB005 not like", value, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005In(List<String> values) {
            addCriterion("YHB005 in", values, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005NotIn(List<String> values) {
            addCriterion("YHB005 not in", values, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005Between(String value1, String value2) {
            addCriterion("YHB005 between", value1, value2, "yhb005");
            return (Criteria) this;
        }

        public Criteria andYhb005NotBetween(String value1, String value2) {
            addCriterion("YHB005 not between", value1, value2, "yhb005");
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
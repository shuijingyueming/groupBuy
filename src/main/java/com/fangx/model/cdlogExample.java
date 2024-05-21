package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdlogExample() {
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

        public Criteria andLog001IsNull() {
            addCriterion("LOG001 is null");
            return (Criteria) this;
        }

        public Criteria andLog001IsNotNull() {
            addCriterion("LOG001 is not null");
            return (Criteria) this;
        }

        public Criteria andLog001EqualTo(String value) {
            addCriterion("LOG001 =", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001NotEqualTo(String value) {
            addCriterion("LOG001 <>", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001GreaterThan(String value) {
            addCriterion("LOG001 >", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001GreaterThanOrEqualTo(String value) {
            addCriterion("LOG001 >=", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001LessThan(String value) {
            addCriterion("LOG001 <", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001LessThanOrEqualTo(String value) {
            addCriterion("LOG001 <=", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001Like(String value) {
            addCriterion("LOG001 like", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001NotLike(String value) {
            addCriterion("LOG001 not like", value, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001In(List<String> values) {
            addCriterion("LOG001 in", values, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001NotIn(List<String> values) {
            addCriterion("LOG001 not in", values, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001Between(String value1, String value2) {
            addCriterion("LOG001 between", value1, value2, "log001");
            return (Criteria) this;
        }

        public Criteria andLog001NotBetween(String value1, String value2) {
            addCriterion("LOG001 not between", value1, value2, "log001");
            return (Criteria) this;
        }

        public Criteria andLog002IsNull() {
            addCriterion("LOG002 is null");
            return (Criteria) this;
        }

        public Criteria andLog002IsNotNull() {
            addCriterion("LOG002 is not null");
            return (Criteria) this;
        }

        public Criteria andLog002EqualTo(String value) {
            addCriterion("LOG002 =", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002NotEqualTo(String value) {
            addCriterion("LOG002 <>", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002GreaterThan(String value) {
            addCriterion("LOG002 >", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002GreaterThanOrEqualTo(String value) {
            addCriterion("LOG002 >=", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002LessThan(String value) {
            addCriterion("LOG002 <", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002LessThanOrEqualTo(String value) {
            addCriterion("LOG002 <=", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002Like(String value) {
            addCriterion("LOG002 like", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002NotLike(String value) {
            addCriterion("LOG002 not like", value, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002In(List<String> values) {
            addCriterion("LOG002 in", values, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002NotIn(List<String> values) {
            addCriterion("LOG002 not in", values, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002Between(String value1, String value2) {
            addCriterion("LOG002 between", value1, value2, "log002");
            return (Criteria) this;
        }

        public Criteria andLog002NotBetween(String value1, String value2) {
            addCriterion("LOG002 not between", value1, value2, "log002");
            return (Criteria) this;
        }

        public Criteria andLog003IsNull() {
            addCriterion("LOG003 is null");
            return (Criteria) this;
        }

        public Criteria andLog003IsNotNull() {
            addCriterion("LOG003 is not null");
            return (Criteria) this;
        }

        public Criteria andLog003EqualTo(Date value) {
            addCriterion("LOG003 =", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003NotEqualTo(Date value) {
            addCriterion("LOG003 <>", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003GreaterThan(Date value) {
            addCriterion("LOG003 >", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003GreaterThanOrEqualTo(Date value) {
            addCriterion("LOG003 >=", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003LessThan(Date value) {
            addCriterion("LOG003 <", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003LessThanOrEqualTo(Date value) {
            addCriterion("LOG003 <=", value, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003In(List<Date> values) {
            addCriterion("LOG003 in", values, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003NotIn(List<Date> values) {
            addCriterion("LOG003 not in", values, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003Between(Date value1, Date value2) {
            addCriterion("LOG003 between", value1, value2, "log003");
            return (Criteria) this;
        }

        public Criteria andLog003NotBetween(Date value1, Date value2) {
            addCriterion("LOG003 not between", value1, value2, "log003");
            return (Criteria) this;
        }

        public Criteria andLog005IsNull() {
            addCriterion("LOG005 is null");
            return (Criteria) this;
        }

        public Criteria andLog005IsNotNull() {
            addCriterion("LOG005 is not null");
            return (Criteria) this;
        }

        public Criteria andLog005EqualTo(String value) {
            addCriterion("LOG005 =", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005NotEqualTo(String value) {
            addCriterion("LOG005 <>", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005GreaterThan(String value) {
            addCriterion("LOG005 >", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005GreaterThanOrEqualTo(String value) {
            addCriterion("LOG005 >=", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005LessThan(String value) {
            addCriterion("LOG005 <", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005LessThanOrEqualTo(String value) {
            addCriterion("LOG005 <=", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005Like(String value) {
            addCriterion("LOG005 like", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005NotLike(String value) {
            addCriterion("LOG005 not like", value, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005In(List<String> values) {
            addCriterion("LOG005 in", values, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005NotIn(List<String> values) {
            addCriterion("LOG005 not in", values, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005Between(String value1, String value2) {
            addCriterion("LOG005 between", value1, value2, "log005");
            return (Criteria) this;
        }

        public Criteria andLog005NotBetween(String value1, String value2) {
            addCriterion("LOG005 not between", value1, value2, "log005");
            return (Criteria) this;
        }

        public Criteria andLog006IsNull() {
            addCriterion("LOG006 is null");
            return (Criteria) this;
        }

        public Criteria andLog006IsNotNull() {
            addCriterion("LOG006 is not null");
            return (Criteria) this;
        }

        public Criteria andLog006EqualTo(String value) {
            addCriterion("LOG006 =", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006NotEqualTo(String value) {
            addCriterion("LOG006 <>", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006GreaterThan(String value) {
            addCriterion("LOG006 >", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006GreaterThanOrEqualTo(String value) {
            addCriterion("LOG006 >=", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006LessThan(String value) {
            addCriterion("LOG006 <", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006LessThanOrEqualTo(String value) {
            addCriterion("LOG006 <=", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006Like(String value) {
            addCriterion("LOG006 like", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006NotLike(String value) {
            addCriterion("LOG006 not like", value, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006In(List<String> values) {
            addCriterion("LOG006 in", values, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006NotIn(List<String> values) {
            addCriterion("LOG006 not in", values, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006Between(String value1, String value2) {
            addCriterion("LOG006 between", value1, value2, "log006");
            return (Criteria) this;
        }

        public Criteria andLog006NotBetween(String value1, String value2) {
            addCriterion("LOG006 not between", value1, value2, "log006");
            return (Criteria) this;
        }

        public Criteria andLog007IsNull() {
            addCriterion("LOG007 is null");
            return (Criteria) this;
        }

        public Criteria andLog007IsNotNull() {
            addCriterion("LOG007 is not null");
            return (Criteria) this;
        }

        public Criteria andLog007EqualTo(String value) {
            addCriterion("LOG007 =", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007NotEqualTo(String value) {
            addCriterion("LOG007 <>", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007GreaterThan(String value) {
            addCriterion("LOG007 >", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007GreaterThanOrEqualTo(String value) {
            addCriterion("LOG007 >=", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007LessThan(String value) {
            addCriterion("LOG007 <", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007LessThanOrEqualTo(String value) {
            addCriterion("LOG007 <=", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007Like(String value) {
            addCriterion("LOG007 like", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007NotLike(String value) {
            addCriterion("LOG007 not like", value, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007In(List<String> values) {
            addCriterion("LOG007 in", values, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007NotIn(List<String> values) {
            addCriterion("LOG007 not in", values, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007Between(String value1, String value2) {
            addCriterion("LOG007 between", value1, value2, "log007");
            return (Criteria) this;
        }

        public Criteria andLog007NotBetween(String value1, String value2) {
            addCriterion("LOG007 not between", value1, value2, "log007");
            return (Criteria) this;
        }

        public Criteria andLog008IsNull() {
            addCriterion("LOG008 is null");
            return (Criteria) this;
        }

        public Criteria andLog008IsNotNull() {
            addCriterion("LOG008 is not null");
            return (Criteria) this;
        }

        public Criteria andLog008EqualTo(String value) {
            addCriterion("LOG008 =", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008NotEqualTo(String value) {
            addCriterion("LOG008 <>", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008GreaterThan(String value) {
            addCriterion("LOG008 >", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008GreaterThanOrEqualTo(String value) {
            addCriterion("LOG008 >=", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008LessThan(String value) {
            addCriterion("LOG008 <", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008LessThanOrEqualTo(String value) {
            addCriterion("LOG008 <=", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008Like(String value) {
            addCriterion("LOG008 like", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008NotLike(String value) {
            addCriterion("LOG008 not like", value, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008In(List<String> values) {
            addCriterion("LOG008 in", values, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008NotIn(List<String> values) {
            addCriterion("LOG008 not in", values, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008Between(String value1, String value2) {
            addCriterion("LOG008 between", value1, value2, "log008");
            return (Criteria) this;
        }

        public Criteria andLog008NotBetween(String value1, String value2) {
            addCriterion("LOG008 not between", value1, value2, "log008");
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
package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdysbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdysbExample() {
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

        public Criteria andYsb001IsNull() {
            addCriterion("YSB001 is null");
            return (Criteria) this;
        }

        public Criteria andYsb001IsNotNull() {
            addCriterion("YSB001 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb001EqualTo(Integer value) {
            addCriterion("YSB001 =", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001NotEqualTo(Integer value) {
            addCriterion("YSB001 <>", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001GreaterThan(Integer value) {
            addCriterion("YSB001 >", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSB001 >=", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001LessThan(Integer value) {
            addCriterion("YSB001 <", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001LessThanOrEqualTo(Integer value) {
            addCriterion("YSB001 <=", value, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001In(List<Integer> values) {
            addCriterion("YSB001 in", values, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001NotIn(List<Integer> values) {
            addCriterion("YSB001 not in", values, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001Between(Integer value1, Integer value2) {
            addCriterion("YSB001 between", value1, value2, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb001NotBetween(Integer value1, Integer value2) {
            addCriterion("YSB001 not between", value1, value2, "ysb001");
            return (Criteria) this;
        }

        public Criteria andYsb002IsNull() {
            addCriterion("YSB002 is null");
            return (Criteria) this;
        }

        public Criteria andYsb002IsNotNull() {
            addCriterion("YSB002 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb002EqualTo(Integer value) {
            addCriterion("YSB002 =", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002NotEqualTo(Integer value) {
            addCriterion("YSB002 <>", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002GreaterThan(Integer value) {
            addCriterion("YSB002 >", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSB002 >=", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002LessThan(Integer value) {
            addCriterion("YSB002 <", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002LessThanOrEqualTo(Integer value) {
            addCriterion("YSB002 <=", value, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002In(List<Integer> values) {
            addCriterion("YSB002 in", values, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002NotIn(List<Integer> values) {
            addCriterion("YSB002 not in", values, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002Between(Integer value1, Integer value2) {
            addCriterion("YSB002 between", value1, value2, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb002NotBetween(Integer value1, Integer value2) {
            addCriterion("YSB002 not between", value1, value2, "ysb002");
            return (Criteria) this;
        }

        public Criteria andYsb003IsNull() {
            addCriterion("YSB003 is null");
            return (Criteria) this;
        }

        public Criteria andYsb003IsNotNull() {
            addCriterion("YSB003 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb003EqualTo(Date value) {
            addCriterion("YSB003 =", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003NotEqualTo(Date value) {
            addCriterion("YSB003 <>", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003GreaterThan(Date value) {
            addCriterion("YSB003 >", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003GreaterThanOrEqualTo(Date value) {
            addCriterion("YSB003 >=", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003LessThan(Date value) {
            addCriterion("YSB003 <", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003LessThanOrEqualTo(Date value) {
            addCriterion("YSB003 <=", value, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003In(List<Date> values) {
            addCriterion("YSB003 in", values, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003NotIn(List<Date> values) {
            addCriterion("YSB003 not in", values, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003Between(Date value1, Date value2) {
            addCriterion("YSB003 between", value1, value2, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb003NotBetween(Date value1, Date value2) {
            addCriterion("YSB003 not between", value1, value2, "ysb003");
            return (Criteria) this;
        }

        public Criteria andYsb004IsNull() {
            addCriterion("YSB004 is null");
            return (Criteria) this;
        }

        public Criteria andYsb004IsNotNull() {
            addCriterion("YSB004 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb004EqualTo(Date value) {
            addCriterion("YSB004 =", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004NotEqualTo(Date value) {
            addCriterion("YSB004 <>", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004GreaterThan(Date value) {
            addCriterion("YSB004 >", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004GreaterThanOrEqualTo(Date value) {
            addCriterion("YSB004 >=", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004LessThan(Date value) {
            addCriterion("YSB004 <", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004LessThanOrEqualTo(Date value) {
            addCriterion("YSB004 <=", value, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004In(List<Date> values) {
            addCriterion("YSB004 in", values, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004NotIn(List<Date> values) {
            addCriterion("YSB004 not in", values, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004Between(Date value1, Date value2) {
            addCriterion("YSB004 between", value1, value2, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb004NotBetween(Date value1, Date value2) {
            addCriterion("YSB004 not between", value1, value2, "ysb004");
            return (Criteria) this;
        }

        public Criteria andYsb005IsNull() {
            addCriterion("YSB005 is null");
            return (Criteria) this;
        }

        public Criteria andYsb005IsNotNull() {
            addCriterion("YSB005 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb005EqualTo(String value) {
            addCriterion("YSB005 =", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005NotEqualTo(String value) {
            addCriterion("YSB005 <>", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005GreaterThan(String value) {
            addCriterion("YSB005 >", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005GreaterThanOrEqualTo(String value) {
            addCriterion("YSB005 >=", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005LessThan(String value) {
            addCriterion("YSB005 <", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005LessThanOrEqualTo(String value) {
            addCriterion("YSB005 <=", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005Like(String value) {
            addCriterion("YSB005 like", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005NotLike(String value) {
            addCriterion("YSB005 not like", value, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005In(List<String> values) {
            addCriterion("YSB005 in", values, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005NotIn(List<String> values) {
            addCriterion("YSB005 not in", values, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005Between(String value1, String value2) {
            addCriterion("YSB005 between", value1, value2, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb005NotBetween(String value1, String value2) {
            addCriterion("YSB005 not between", value1, value2, "ysb005");
            return (Criteria) this;
        }

        public Criteria andYsb006IsNull() {
            addCriterion("YSB006 is null");
            return (Criteria) this;
        }

        public Criteria andYsb006IsNotNull() {
            addCriterion("YSB006 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb006EqualTo(String value) {
            addCriterion("YSB006 =", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006NotEqualTo(String value) {
            addCriterion("YSB006 <>", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006GreaterThan(String value) {
            addCriterion("YSB006 >", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006GreaterThanOrEqualTo(String value) {
            addCriterion("YSB006 >=", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006LessThan(String value) {
            addCriterion("YSB006 <", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006LessThanOrEqualTo(String value) {
            addCriterion("YSB006 <=", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006Like(String value) {
            addCriterion("YSB006 like", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006NotLike(String value) {
            addCriterion("YSB006 not like", value, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006In(List<String> values) {
            addCriterion("YSB006 in", values, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006NotIn(List<String> values) {
            addCriterion("YSB006 not in", values, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006Between(String value1, String value2) {
            addCriterion("YSB006 between", value1, value2, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb006NotBetween(String value1, String value2) {
            addCriterion("YSB006 not between", value1, value2, "ysb006");
            return (Criteria) this;
        }

        public Criteria andYsb007IsNull() {
            addCriterion("YSB007 is null");
            return (Criteria) this;
        }

        public Criteria andYsb007IsNotNull() {
            addCriterion("YSB007 is not null");
            return (Criteria) this;
        }

        public Criteria andYsb007EqualTo(String value) {
            addCriterion("YSB007 =", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007NotEqualTo(String value) {
            addCriterion("YSB007 <>", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007GreaterThan(String value) {
            addCriterion("YSB007 >", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007GreaterThanOrEqualTo(String value) {
            addCriterion("YSB007 >=", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007LessThan(String value) {
            addCriterion("YSB007 <", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007LessThanOrEqualTo(String value) {
            addCriterion("YSB007 <=", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007Like(String value) {
            addCriterion("YSB007 like", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007NotLike(String value) {
            addCriterion("YSB007 not like", value, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007In(List<String> values) {
            addCriterion("YSB007 in", values, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007NotIn(List<String> values) {
            addCriterion("YSB007 not in", values, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007Between(String value1, String value2) {
            addCriterion("YSB007 between", value1, value2, "ysb007");
            return (Criteria) this;
        }

        public Criteria andYsb007NotBetween(String value1, String value2) {
            addCriterion("YSB007 not between", value1, value2, "ysb007");
            return (Criteria) this;
        }
        public Criteria andSql(String value) {
            addCriterion(value);
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
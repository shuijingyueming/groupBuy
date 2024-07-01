package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdyscExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyscExample() {
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

        public Criteria andYsc001IsNull() {
            addCriterion("YSC001 is null");
            return (Criteria) this;
        }

        public Criteria andYsc001IsNotNull() {
            addCriterion("YSC001 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc001EqualTo(Integer value) {
            addCriterion("YSC001 =", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001NotEqualTo(Integer value) {
            addCriterion("YSC001 <>", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001GreaterThan(Integer value) {
            addCriterion("YSC001 >", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSC001 >=", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001LessThan(Integer value) {
            addCriterion("YSC001 <", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001LessThanOrEqualTo(Integer value) {
            addCriterion("YSC001 <=", value, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001In(List<Integer> values) {
            addCriterion("YSC001 in", values, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001NotIn(List<Integer> values) {
            addCriterion("YSC001 not in", values, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001Between(Integer value1, Integer value2) {
            addCriterion("YSC001 between", value1, value2, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc001NotBetween(Integer value1, Integer value2) {
            addCriterion("YSC001 not between", value1, value2, "ysc001");
            return (Criteria) this;
        }

        public Criteria andYsc002IsNull() {
            addCriterion("YSC002 is null");
            return (Criteria) this;
        }

        public Criteria andYsc002IsNotNull() {
            addCriterion("YSC002 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc002EqualTo(Integer value) {
            addCriterion("YSC002 =", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002NotEqualTo(Integer value) {
            addCriterion("YSC002 <>", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002GreaterThan(Integer value) {
            addCriterion("YSC002 >", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSC002 >=", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002LessThan(Integer value) {
            addCriterion("YSC002 <", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002LessThanOrEqualTo(Integer value) {
            addCriterion("YSC002 <=", value, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002In(List<Integer> values) {
            addCriterion("YSC002 in", values, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002NotIn(List<Integer> values) {
            addCriterion("YSC002 not in", values, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002Between(Integer value1, Integer value2) {
            addCriterion("YSC002 between", value1, value2, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc002NotBetween(Integer value1, Integer value2) {
            addCriterion("YSC002 not between", value1, value2, "ysc002");
            return (Criteria) this;
        }

        public Criteria andYsc003IsNull() {
            addCriterion("YSC003 is null");
            return (Criteria) this;
        }

        public Criteria andYsc003IsNotNull() {
            addCriterion("YSC003 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc003EqualTo(Date value) {
            addCriterion("YSC003 =", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003NotEqualTo(Date value) {
            addCriterion("YSC003 <>", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003GreaterThan(Date value) {
            addCriterion("YSC003 >", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003GreaterThanOrEqualTo(Date value) {
            addCriterion("YSC003 >=", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003LessThan(Date value) {
            addCriterion("YSC003 <", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003LessThanOrEqualTo(Date value) {
            addCriterion("YSC003 <=", value, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003In(List<Date> values) {
            addCriterion("YSC003 in", values, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003NotIn(List<Date> values) {
            addCriterion("YSC003 not in", values, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003Between(Date value1, Date value2) {
            addCriterion("YSC003 between", value1, value2, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc003NotBetween(Date value1, Date value2) {
            addCriterion("YSC003 not between", value1, value2, "ysc003");
            return (Criteria) this;
        }

        public Criteria andYsc004IsNull() {
            addCriterion("YSC004 is null");
            return (Criteria) this;
        }

        public Criteria andYsc004IsNotNull() {
            addCriterion("YSC004 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc004EqualTo(Date value) {
            addCriterion("YSC004 =", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004NotEqualTo(Date value) {
            addCriterion("YSC004 <>", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004GreaterThan(Date value) {
            addCriterion("YSC004 >", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004GreaterThanOrEqualTo(Date value) {
            addCriterion("YSC004 >=", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004LessThan(Date value) {
            addCriterion("YSC004 <", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004LessThanOrEqualTo(Date value) {
            addCriterion("YSC004 <=", value, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004In(List<Date> values) {
            addCriterion("YSC004 in", values, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004NotIn(List<Date> values) {
            addCriterion("YSC004 not in", values, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004Between(Date value1, Date value2) {
            addCriterion("YSC004 between", value1, value2, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc004NotBetween(Date value1, Date value2) {
            addCriterion("YSC004 not between", value1, value2, "ysc004");
            return (Criteria) this;
        }

        public Criteria andYsc005IsNull() {
            addCriterion("YSC005 is null");
            return (Criteria) this;
        }

        public Criteria andYsc005IsNotNull() {
            addCriterion("YSC005 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc005EqualTo(String value) {
            addCriterion("YSC005 =", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005NotEqualTo(String value) {
            addCriterion("YSC005 <>", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005GreaterThan(String value) {
            addCriterion("YSC005 >", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005GreaterThanOrEqualTo(String value) {
            addCriterion("YSC005 >=", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005LessThan(String value) {
            addCriterion("YSC005 <", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005LessThanOrEqualTo(String value) {
            addCriterion("YSC005 <=", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005Like(String value) {
            addCriterion("YSC005 like", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005NotLike(String value) {
            addCriterion("YSC005 not like", value, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005In(List<String> values) {
            addCriterion("YSC005 in", values, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005NotIn(List<String> values) {
            addCriterion("YSC005 not in", values, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005Between(String value1, String value2) {
            addCriterion("YSC005 between", value1, value2, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc005NotBetween(String value1, String value2) {
            addCriterion("YSC005 not between", value1, value2, "ysc005");
            return (Criteria) this;
        }

        public Criteria andYsc006IsNull() {
            addCriterion("YSC006 is null");
            return (Criteria) this;
        }

        public Criteria andYsc006IsNotNull() {
            addCriterion("YSC006 is not null");
            return (Criteria) this;
        }

        public Criteria andYsc006EqualTo(Integer value) {
            addCriterion("YSC006 =", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006NotEqualTo(Integer value) {
            addCriterion("YSC006 <>", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006GreaterThan(Integer value) {
            addCriterion("YSC006 >", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSC006 >=", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006LessThan(Integer value) {
            addCriterion("YSC006 <", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006LessThanOrEqualTo(Integer value) {
            addCriterion("YSC006 <=", value, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006In(List<Integer> values) {
            addCriterion("YSC006 in", values, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006NotIn(List<Integer> values) {
            addCriterion("YSC006 not in", values, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006Between(Integer value1, Integer value2) {
            addCriterion("YSC006 between", value1, value2, "ysc006");
            return (Criteria) this;
        }

        public Criteria andYsc006NotBetween(Integer value1, Integer value2) {
            addCriterion("YSC006 not between", value1, value2, "ysc006");
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
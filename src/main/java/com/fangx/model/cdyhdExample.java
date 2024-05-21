package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdyhdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyhdExample() {
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

        public Criteria andYhd001IsNull() {
            addCriterion("YHD001 is null");
            return (Criteria) this;
        }

        public Criteria andYhd001IsNotNull() {
            addCriterion("YHD001 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd001EqualTo(String value) {
            addCriterion("YHD001 =", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001NotEqualTo(String value) {
            addCriterion("YHD001 <>", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001GreaterThan(String value) {
            addCriterion("YHD001 >", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001GreaterThanOrEqualTo(String value) {
            addCriterion("YHD001 >=", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001LessThan(String value) {
            addCriterion("YHD001 <", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001LessThanOrEqualTo(String value) {
            addCriterion("YHD001 <=", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001Like(String value) {
            addCriterion("YHD001 like", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001NotLike(String value) {
            addCriterion("YHD001 not like", value, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001In(List<String> values) {
            addCriterion("YHD001 in", values, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001NotIn(List<String> values) {
            addCriterion("YHD001 not in", values, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001Between(String value1, String value2) {
            addCriterion("YHD001 between", value1, value2, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd001NotBetween(String value1, String value2) {
            addCriterion("YHD001 not between", value1, value2, "yhd001");
            return (Criteria) this;
        }

        public Criteria andYhd002IsNull() {
            addCriterion("YHD002 is null");
            return (Criteria) this;
        }

        public Criteria andYhd002IsNotNull() {
            addCriterion("YHD002 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd002EqualTo(Integer value) {
            addCriterion("YHD002 =", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002NotEqualTo(Integer value) {
            addCriterion("YHD002 <>", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002GreaterThan(Integer value) {
            addCriterion("YHD002 >", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHD002 >=", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002LessThan(Integer value) {
            addCriterion("YHD002 <", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002LessThanOrEqualTo(Integer value) {
            addCriterion("YHD002 <=", value, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002In(List<Integer> values) {
            addCriterion("YHD002 in", values, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002NotIn(List<Integer> values) {
            addCriterion("YHD002 not in", values, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002Between(Integer value1, Integer value2) {
            addCriterion("YHD002 between", value1, value2, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd002NotBetween(Integer value1, Integer value2) {
            addCriterion("YHD002 not between", value1, value2, "yhd002");
            return (Criteria) this;
        }

        public Criteria andYhd003IsNull() {
            addCriterion("YHD003 is null");
            return (Criteria) this;
        }

        public Criteria andYhd003IsNotNull() {
            addCriterion("YHD003 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd003EqualTo(Integer value) {
            addCriterion("YHD003 =", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003NotEqualTo(Integer value) {
            addCriterion("YHD003 <>", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003GreaterThan(Integer value) {
            addCriterion("YHD003 >", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHD003 >=", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003LessThan(Integer value) {
            addCriterion("YHD003 <", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003LessThanOrEqualTo(Integer value) {
            addCriterion("YHD003 <=", value, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003In(List<Integer> values) {
            addCriterion("YHD003 in", values, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003NotIn(List<Integer> values) {
            addCriterion("YHD003 not in", values, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003Between(Integer value1, Integer value2) {
            addCriterion("YHD003 between", value1, value2, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd003NotBetween(Integer value1, Integer value2) {
            addCriterion("YHD003 not between", value1, value2, "yhd003");
            return (Criteria) this;
        }

        public Criteria andYhd004IsNull() {
            addCriterion("YHD004 is null");
            return (Criteria) this;
        }

        public Criteria andYhd004IsNotNull() {
            addCriterion("YHD004 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd004EqualTo(Float value) {
            addCriterion("YHD004 =", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004NotEqualTo(Float value) {
            addCriterion("YHD004 <>", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004GreaterThan(Float value) {
            addCriterion("YHD004 >", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004GreaterThanOrEqualTo(Float value) {
            addCriterion("YHD004 >=", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004LessThan(Float value) {
            addCriterion("YHD004 <", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004LessThanOrEqualTo(Float value) {
            addCriterion("YHD004 <=", value, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004In(List<Float> values) {
            addCriterion("YHD004 in", values, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004NotIn(List<Float> values) {
            addCriterion("YHD004 not in", values, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004Between(Float value1, Float value2) {
            addCriterion("YHD004 between", value1, value2, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd004NotBetween(Float value1, Float value2) {
            addCriterion("YHD004 not between", value1, value2, "yhd004");
            return (Criteria) this;
        }

        public Criteria andYhd005IsNull() {
            addCriterion("YHD005 is null");
            return (Criteria) this;
        }

        public Criteria andYhd005IsNotNull() {
            addCriterion("YHD005 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd005EqualTo(Date value) {
            addCriterion("YHD005 =", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005NotEqualTo(Date value) {
            addCriterion("YHD005 <>", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005GreaterThan(Date value) {
            addCriterion("YHD005 >", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005GreaterThanOrEqualTo(Date value) {
            addCriterion("YHD005 >=", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005LessThan(Date value) {
            addCriterion("YHD005 <", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005LessThanOrEqualTo(Date value) {
            addCriterion("YHD005 <=", value, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005In(List<Date> values) {
            addCriterion("YHD005 in", values, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005NotIn(List<Date> values) {
            addCriterion("YHD005 not in", values, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005Between(Date value1, Date value2) {
            addCriterion("YHD005 between", value1, value2, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd005NotBetween(Date value1, Date value2) {
            addCriterion("YHD005 not between", value1, value2, "yhd005");
            return (Criteria) this;
        }

        public Criteria andYhd006IsNull() {
            addCriterion("YHD006 is null");
            return (Criteria) this;
        }

        public Criteria andYhd006IsNotNull() {
            addCriterion("YHD006 is not null");
            return (Criteria) this;
        }

        public Criteria andYhd006EqualTo(String value) {
            addCriterion("YHD006 =", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006NotEqualTo(String value) {
            addCriterion("YHD006 <>", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006GreaterThan(String value) {
            addCriterion("YHD006 >", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006GreaterThanOrEqualTo(String value) {
            addCriterion("YHD006 >=", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006LessThan(String value) {
            addCriterion("YHD006 <", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006LessThanOrEqualTo(String value) {
            addCriterion("YHD006 <=", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006Like(String value) {
            addCriterion("YHD006 like", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006NotLike(String value) {
            addCriterion("YHD006 not like", value, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006In(List<String> values) {
            addCriterion("YHD006 in", values, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006NotIn(List<String> values) {
            addCriterion("YHD006 not in", values, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006Between(String value1, String value2) {
            addCriterion("YHD006 between", value1, value2, "yhd006");
            return (Criteria) this;
        }

        public Criteria andYhd006NotBetween(String value1, String value2) {
            addCriterion("YHD006 not between", value1, value2, "yhd006");
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
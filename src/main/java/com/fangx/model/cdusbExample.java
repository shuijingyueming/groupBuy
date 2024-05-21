package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdusbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusbExample() {
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

        public Criteria andUsb001IsNull() {
            addCriterion("USB001 is null");
            return (Criteria) this;
        }

        public Criteria andUsb001IsNotNull() {
            addCriterion("USB001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb001EqualTo(Integer value) {
            addCriterion("USB001 =", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001NotEqualTo(Integer value) {
            addCriterion("USB001 <>", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001GreaterThan(Integer value) {
            addCriterion("USB001 >", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USB001 >=", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001LessThan(Integer value) {
            addCriterion("USB001 <", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001LessThanOrEqualTo(Integer value) {
            addCriterion("USB001 <=", value, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001In(List<Integer> values) {
            addCriterion("USB001 in", values, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001NotIn(List<Integer> values) {
            addCriterion("USB001 not in", values, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001Between(Integer value1, Integer value2) {
            addCriterion("USB001 between", value1, value2, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb001NotBetween(Integer value1, Integer value2) {
            addCriterion("USB001 not between", value1, value2, "usb001");
            return (Criteria) this;
        }

        public Criteria andUsb002IsNull() {
            addCriterion("USB002 is null");
            return (Criteria) this;
        }

        public Criteria andUsb002IsNotNull() {
            addCriterion("USB002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb002EqualTo(String value) {
            addCriterion("USB002 =", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002NotEqualTo(String value) {
            addCriterion("USB002 <>", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002GreaterThan(String value) {
            addCriterion("USB002 >", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002GreaterThanOrEqualTo(String value) {
            addCriterion("USB002 >=", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002LessThan(String value) {
            addCriterion("USB002 <", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002LessThanOrEqualTo(String value) {
            addCriterion("USB002 <=", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002Like(String value) {
            addCriterion("USB002 like", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002NotLike(String value) {
            addCriterion("USB002 not like", value, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002In(List<String> values) {
            addCriterion("USB002 in", values, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002NotIn(List<String> values) {
            addCriterion("USB002 not in", values, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002Between(String value1, String value2) {
            addCriterion("USB002 between", value1, value2, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb002NotBetween(String value1, String value2) {
            addCriterion("USB002 not between", value1, value2, "usb002");
            return (Criteria) this;
        }

        public Criteria andUsb003IsNull() {
            addCriterion("USB003 is null");
            return (Criteria) this;
        }

        public Criteria andUsb003IsNotNull() {
            addCriterion("USB003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb003EqualTo(Integer value) {
            addCriterion("USB003 =", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003NotEqualTo(Integer value) {
            addCriterion("USB003 <>", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003GreaterThan(Integer value) {
            addCriterion("USB003 >", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003GreaterThanOrEqualTo(Integer value) {
            addCriterion("USB003 >=", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003LessThan(Integer value) {
            addCriterion("USB003 <", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003LessThanOrEqualTo(Integer value) {
            addCriterion("USB003 <=", value, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003In(List<Integer> values) {
            addCriterion("USB003 in", values, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003NotIn(List<Integer> values) {
            addCriterion("USB003 not in", values, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003Between(Integer value1, Integer value2) {
            addCriterion("USB003 between", value1, value2, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb003NotBetween(Integer value1, Integer value2) {
            addCriterion("USB003 not between", value1, value2, "usb003");
            return (Criteria) this;
        }

        public Criteria andUsb004IsNull() {
            addCriterion("USB004 is null");
            return (Criteria) this;
        }

        public Criteria andUsb004IsNotNull() {
            addCriterion("USB004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb004EqualTo(Integer value) {
            addCriterion("USB004 =", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004NotEqualTo(Integer value) {
            addCriterion("USB004 <>", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004GreaterThan(Integer value) {
            addCriterion("USB004 >", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004GreaterThanOrEqualTo(Integer value) {
            addCriterion("USB004 >=", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004LessThan(Integer value) {
            addCriterion("USB004 <", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004LessThanOrEqualTo(Integer value) {
            addCriterion("USB004 <=", value, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004In(List<Integer> values) {
            addCriterion("USB004 in", values, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004NotIn(List<Integer> values) {
            addCriterion("USB004 not in", values, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004Between(Integer value1, Integer value2) {
            addCriterion("USB004 between", value1, value2, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb004NotBetween(Integer value1, Integer value2) {
            addCriterion("USB004 not between", value1, value2, "usb004");
            return (Criteria) this;
        }

        public Criteria andUsb005IsNull() {
            addCriterion("USB005 is null");
            return (Criteria) this;
        }

        public Criteria andUsb005IsNotNull() {
            addCriterion("USB005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb005EqualTo(String value) {
            addCriterion("USB005 =", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005NotEqualTo(String value) {
            addCriterion("USB005 <>", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005GreaterThan(String value) {
            addCriterion("USB005 >", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005GreaterThanOrEqualTo(String value) {
            addCriterion("USB005 >=", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005LessThan(String value) {
            addCriterion("USB005 <", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005LessThanOrEqualTo(String value) {
            addCriterion("USB005 <=", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005Like(String value) {
            addCriterion("USB005 like", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005NotLike(String value) {
            addCriterion("USB005 not like", value, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005In(List<String> values) {
            addCriterion("USB005 in", values, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005NotIn(List<String> values) {
            addCriterion("USB005 not in", values, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005Between(String value1, String value2) {
            addCriterion("USB005 between", value1, value2, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb005NotBetween(String value1, String value2) {
            addCriterion("USB005 not between", value1, value2, "usb005");
            return (Criteria) this;
        }

        public Criteria andUsb006IsNull() {
            addCriterion("USB006 is null");
            return (Criteria) this;
        }

        public Criteria andUsb006IsNotNull() {
            addCriterion("USB006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb006EqualTo(Integer value) {
            addCriterion("USB006 =", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006NotEqualTo(Integer value) {
            addCriterion("USB006 <>", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006GreaterThan(Integer value) {
            addCriterion("USB006 >", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006GreaterThanOrEqualTo(Integer value) {
            addCriterion("USB006 >=", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006LessThan(Integer value) {
            addCriterion("USB006 <", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006LessThanOrEqualTo(Integer value) {
            addCriterion("USB006 <=", value, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006In(List<Integer> values) {
            addCriterion("USB006 in", values, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006NotIn(List<Integer> values) {
            addCriterion("USB006 not in", values, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006Between(Integer value1, Integer value2) {
            addCriterion("USB006 between", value1, value2, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb006NotBetween(Integer value1, Integer value2) {
            addCriterion("USB006 not between", value1, value2, "usb006");
            return (Criteria) this;
        }

        public Criteria andUsb007IsNull() {
            addCriterion("USB007 is null");
            return (Criteria) this;
        }

        public Criteria andUsb007IsNotNull() {
            addCriterion("USB007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb007EqualTo(String value) {
            addCriterion("USB007 =", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007NotEqualTo(String value) {
            addCriterion("USB007 <>", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007GreaterThan(String value) {
            addCriterion("USB007 >", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007GreaterThanOrEqualTo(String value) {
            addCriterion("USB007 >=", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007LessThan(String value) {
            addCriterion("USB007 <", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007LessThanOrEqualTo(String value) {
            addCriterion("USB007 <=", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007Like(String value) {
            addCriterion("USB007 like", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007NotLike(String value) {
            addCriterion("USB007 not like", value, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007In(List<String> values) {
            addCriterion("USB007 in", values, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007NotIn(List<String> values) {
            addCriterion("USB007 not in", values, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007Between(String value1, String value2) {
            addCriterion("USB007 between", value1, value2, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb007NotBetween(String value1, String value2) {
            addCriterion("USB007 not between", value1, value2, "usb007");
            return (Criteria) this;
        }

        public Criteria andUsb008IsNull() {
            addCriterion("USB008 is null");
            return (Criteria) this;
        }

        public Criteria andUsb008IsNotNull() {
            addCriterion("USB008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsb008EqualTo(String value) {
            addCriterion("USB008 =", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008NotEqualTo(String value) {
            addCriterion("USB008 <>", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008GreaterThan(String value) {
            addCriterion("USB008 >", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008GreaterThanOrEqualTo(String value) {
            addCriterion("USB008 >=", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008LessThan(String value) {
            addCriterion("USB008 <", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008LessThanOrEqualTo(String value) {
            addCriterion("USB008 <=", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008Like(String value) {
            addCriterion("USB008 like", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008NotLike(String value) {
            addCriterion("USB008 not like", value, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008In(List<String> values) {
            addCriterion("USB008 in", values, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008NotIn(List<String> values) {
            addCriterion("USB008 not in", values, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008Between(String value1, String value2) {
            addCriterion("USB008 between", value1, value2, "usb008");
            return (Criteria) this;
        }

        public Criteria andUsb008NotBetween(String value1, String value2) {
            addCriterion("USB008 not between", value1, value2, "usb008");
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
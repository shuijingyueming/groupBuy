package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdushExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdushExample() {
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

        public Criteria andUsh001IsNull() {
            addCriterion("USH001 is null");
            return (Criteria) this;
        }

        public Criteria andUsh001IsNotNull() {
            addCriterion("USH001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh001EqualTo(String value) {
            addCriterion("USH001 =", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001NotEqualTo(String value) {
            addCriterion("USH001 <>", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001GreaterThan(String value) {
            addCriterion("USH001 >", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001GreaterThanOrEqualTo(String value) {
            addCriterion("USH001 >=", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001LessThan(String value) {
            addCriterion("USH001 <", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001LessThanOrEqualTo(String value) {
            addCriterion("USH001 <=", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001Like(String value) {
            addCriterion("USH001 like", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001NotLike(String value) {
            addCriterion("USH001 not like", value, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001In(List<String> values) {
            addCriterion("USH001 in", values, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001NotIn(List<String> values) {
            addCriterion("USH001 not in", values, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001Between(String value1, String value2) {
            addCriterion("USH001 between", value1, value2, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh001NotBetween(String value1, String value2) {
            addCriterion("USH001 not between", value1, value2, "ush001");
            return (Criteria) this;
        }

        public Criteria andUsh002IsNull() {
            addCriterion("USH002 is null");
            return (Criteria) this;
        }

        public Criteria andUsh002IsNotNull() {
            addCriterion("USH002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh002EqualTo(String value) {
            addCriterion("USH002 =", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002NotEqualTo(String value) {
            addCriterion("USH002 <>", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002GreaterThan(String value) {
            addCriterion("USH002 >", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002GreaterThanOrEqualTo(String value) {
            addCriterion("USH002 >=", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002LessThan(String value) {
            addCriterion("USH002 <", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002LessThanOrEqualTo(String value) {
            addCriterion("USH002 <=", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002Like(String value) {
            addCriterion("USH002 like", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002NotLike(String value) {
            addCriterion("USH002 not like", value, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002In(List<String> values) {
            addCriterion("USH002 in", values, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002NotIn(List<String> values) {
            addCriterion("USH002 not in", values, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002Between(String value1, String value2) {
            addCriterion("USH002 between", value1, value2, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh002NotBetween(String value1, String value2) {
            addCriterion("USH002 not between", value1, value2, "ush002");
            return (Criteria) this;
        }

        public Criteria andUsh003IsNull() {
            addCriterion("USH003 is null");
            return (Criteria) this;
        }

        public Criteria andUsh003IsNotNull() {
            addCriterion("USH003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh003EqualTo(Integer value) {
            addCriterion("USH003 =", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003NotEqualTo(Integer value) {
            addCriterion("USH003 <>", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003GreaterThan(Integer value) {
            addCriterion("USH003 >", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003GreaterThanOrEqualTo(Integer value) {
            addCriterion("USH003 >=", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003LessThan(Integer value) {
            addCriterion("USH003 <", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003LessThanOrEqualTo(Integer value) {
            addCriterion("USH003 <=", value, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003In(List<Integer> values) {
            addCriterion("USH003 in", values, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003NotIn(List<Integer> values) {
            addCriterion("USH003 not in", values, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003Between(Integer value1, Integer value2) {
            addCriterion("USH003 between", value1, value2, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh003NotBetween(Integer value1, Integer value2) {
            addCriterion("USH003 not between", value1, value2, "ush003");
            return (Criteria) this;
        }

        public Criteria andUsh004IsNull() {
            addCriterion("USH004 is null");
            return (Criteria) this;
        }

        public Criteria andUsh004IsNotNull() {
            addCriterion("USH004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh004EqualTo(Integer value) {
            addCriterion("USH004 =", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004NotEqualTo(Integer value) {
            addCriterion("USH004 <>", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004GreaterThan(Integer value) {
            addCriterion("USH004 >", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004GreaterThanOrEqualTo(Integer value) {
            addCriterion("USH004 >=", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004LessThan(Integer value) {
            addCriterion("USH004 <", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004LessThanOrEqualTo(Integer value) {
            addCriterion("USH004 <=", value, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004In(List<Integer> values) {
            addCriterion("USH004 in", values, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004NotIn(List<Integer> values) {
            addCriterion("USH004 not in", values, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004Between(Integer value1, Integer value2) {
            addCriterion("USH004 between", value1, value2, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh004NotBetween(Integer value1, Integer value2) {
            addCriterion("USH004 not between", value1, value2, "ush004");
            return (Criteria) this;
        }

        public Criteria andUsh005IsNull() {
            addCriterion("USH005 is null");
            return (Criteria) this;
        }

        public Criteria andUsh005IsNotNull() {
            addCriterion("USH005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh005EqualTo(Float value) {
            addCriterion("USH005 =", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005NotEqualTo(Float value) {
            addCriterion("USH005 <>", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005GreaterThan(Float value) {
            addCriterion("USH005 >", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005GreaterThanOrEqualTo(Float value) {
            addCriterion("USH005 >=", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005LessThan(Float value) {
            addCriterion("USH005 <", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005LessThanOrEqualTo(Float value) {
            addCriterion("USH005 <=", value, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005In(List<Float> values) {
            addCriterion("USH005 in", values, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005NotIn(List<Float> values) {
            addCriterion("USH005 not in", values, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005Between(Float value1, Float value2) {
            addCriterion("USH005 between", value1, value2, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh005NotBetween(Float value1, Float value2) {
            addCriterion("USH005 not between", value1, value2, "ush005");
            return (Criteria) this;
        }

        public Criteria andUsh006IsNull() {
            addCriterion("USH006 is null");
            return (Criteria) this;
        }

        public Criteria andUsh006IsNotNull() {
            addCriterion("USH006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh006EqualTo(Float value) {
            addCriterion("USH006 =", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006NotEqualTo(Float value) {
            addCriterion("USH006 <>", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006GreaterThan(Float value) {
            addCriterion("USH006 >", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006GreaterThanOrEqualTo(Float value) {
            addCriterion("USH006 >=", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006LessThan(Float value) {
            addCriterion("USH006 <", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006LessThanOrEqualTo(Float value) {
            addCriterion("USH006 <=", value, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006In(List<Float> values) {
            addCriterion("USH006 in", values, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006NotIn(List<Float> values) {
            addCriterion("USH006 not in", values, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006Between(Float value1, Float value2) {
            addCriterion("USH006 between", value1, value2, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh006NotBetween(Float value1, Float value2) {
            addCriterion("USH006 not between", value1, value2, "ush006");
            return (Criteria) this;
        }

        public Criteria andUsh007IsNull() {
            addCriterion("USH007 is null");
            return (Criteria) this;
        }

        public Criteria andUsh007IsNotNull() {
            addCriterion("USH007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh007EqualTo(Integer value) {
            addCriterion("USH007 =", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007NotEqualTo(Integer value) {
            addCriterion("USH007 <>", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007GreaterThan(Integer value) {
            addCriterion("USH007 >", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007GreaterThanOrEqualTo(Integer value) {
            addCriterion("USH007 >=", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007LessThan(Integer value) {
            addCriterion("USH007 <", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007LessThanOrEqualTo(Integer value) {
            addCriterion("USH007 <=", value, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007In(List<Integer> values) {
            addCriterion("USH007 in", values, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007NotIn(List<Integer> values) {
            addCriterion("USH007 not in", values, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007Between(Integer value1, Integer value2) {
            addCriterion("USH007 between", value1, value2, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh007NotBetween(Integer value1, Integer value2) {
            addCriterion("USH007 not between", value1, value2, "ush007");
            return (Criteria) this;
        }

        public Criteria andUsh008IsNull() {
            addCriterion("USH008 is null");
            return (Criteria) this;
        }

        public Criteria andUsh008IsNotNull() {
            addCriterion("USH008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh008EqualTo(String value) {
            addCriterion("USH008 =", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008NotEqualTo(String value) {
            addCriterion("USH008 <>", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008GreaterThan(String value) {
            addCriterion("USH008 >", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008GreaterThanOrEqualTo(String value) {
            addCriterion("USH008 >=", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008LessThan(String value) {
            addCriterion("USH008 <", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008LessThanOrEqualTo(String value) {
            addCriterion("USH008 <=", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008Like(String value) {
            addCriterion("USH008 like", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008NotLike(String value) {
            addCriterion("USH008 not like", value, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008In(List<String> values) {
            addCriterion("USH008 in", values, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008NotIn(List<String> values) {
            addCriterion("USH008 not in", values, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008Between(String value1, String value2) {
            addCriterion("USH008 between", value1, value2, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh008NotBetween(String value1, String value2) {
            addCriterion("USH008 not between", value1, value2, "ush008");
            return (Criteria) this;
        }

        public Criteria andUsh009IsNull() {
            addCriterion("USH009 is null");
            return (Criteria) this;
        }

        public Criteria andUsh009IsNotNull() {
            addCriterion("USH009 is not null");
            return (Criteria) this;
        }

        public Criteria andUsh009EqualTo(String value) {
            addCriterion("USH009 =", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009NotEqualTo(String value) {
            addCriterion("USH009 <>", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009GreaterThan(String value) {
            addCriterion("USH009 >", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009GreaterThanOrEqualTo(String value) {
            addCriterion("USH009 >=", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009LessThan(String value) {
            addCriterion("USH009 <", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009LessThanOrEqualTo(String value) {
            addCriterion("USH009 <=", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009Like(String value) {
            addCriterion("USH009 like", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009NotLike(String value) {
            addCriterion("USH009 not like", value, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009In(List<String> values) {
            addCriterion("USH009 in", values, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009NotIn(List<String> values) {
            addCriterion("USH009 not in", values, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009Between(String value1, String value2) {
            addCriterion("USH009 between", value1, value2, "ush009");
            return (Criteria) this;
        }

        public Criteria andUsh009NotBetween(String value1, String value2) {
            addCriterion("USH009 not between", value1, value2, "ush009");
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
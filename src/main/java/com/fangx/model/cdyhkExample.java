package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdyhkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyhkExample() {
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

        public Criteria andYhk001IsNull() {
            addCriterion("YHK001 is null");
            return (Criteria) this;
        }

        public Criteria andYhk001IsNotNull() {
            addCriterion("YHK001 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk001EqualTo(String value) {
            addCriterion("YHK001 =", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001NotEqualTo(String value) {
            addCriterion("YHK001 <>", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001GreaterThan(String value) {
            addCriterion("YHK001 >", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001GreaterThanOrEqualTo(String value) {
            addCriterion("YHK001 >=", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001LessThan(String value) {
            addCriterion("YHK001 <", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001LessThanOrEqualTo(String value) {
            addCriterion("YHK001 <=", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001Like(String value) {
            addCriterion("YHK001 like", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001NotLike(String value) {
            addCriterion("YHK001 not like", value, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001In(List<String> values) {
            addCriterion("YHK001 in", values, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001NotIn(List<String> values) {
            addCriterion("YHK001 not in", values, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001Between(String value1, String value2) {
            addCriterion("YHK001 between", value1, value2, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk001NotBetween(String value1, String value2) {
            addCriterion("YHK001 not between", value1, value2, "yhk001");
            return (Criteria) this;
        }

        public Criteria andYhk002IsNull() {
            addCriterion("YHK002 is null");
            return (Criteria) this;
        }

        public Criteria andYhk002IsNotNull() {
            addCriterion("YHK002 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk002EqualTo(Integer value) {
            addCriterion("YHK002 =", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002NotEqualTo(Integer value) {
            addCriterion("YHK002 <>", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002GreaterThan(Integer value) {
            addCriterion("YHK002 >", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHK002 >=", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002LessThan(Integer value) {
            addCriterion("YHK002 <", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002LessThanOrEqualTo(Integer value) {
            addCriterion("YHK002 <=", value, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002In(List<Integer> values) {
            addCriterion("YHK002 in", values, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002NotIn(List<Integer> values) {
            addCriterion("YHK002 not in", values, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002Between(Integer value1, Integer value2) {
            addCriterion("YHK002 between", value1, value2, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk002NotBetween(Integer value1, Integer value2) {
            addCriterion("YHK002 not between", value1, value2, "yhk002");
            return (Criteria) this;
        }

        public Criteria andYhk003IsNull() {
            addCriterion("YHK003 is null");
            return (Criteria) this;
        }

        public Criteria andYhk003IsNotNull() {
            addCriterion("YHK003 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk003EqualTo(Date value) {
            addCriterion("YHK003 =", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003NotEqualTo(Date value) {
            addCriterion("YHK003 <>", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003GreaterThan(Date value) {
            addCriterion("YHK003 >", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003GreaterThanOrEqualTo(Date value) {
            addCriterion("YHK003 >=", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003LessThan(Date value) {
            addCriterion("YHK003 <", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003LessThanOrEqualTo(Date value) {
            addCriterion("YHK003 <=", value, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003In(List<Date> values) {
            addCriterion("YHK003 in", values, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003NotIn(List<Date> values) {
            addCriterion("YHK003 not in", values, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003Between(Date value1, Date value2) {
            addCriterion("YHK003 between", value1, value2, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk003NotBetween(Date value1, Date value2) {
            addCriterion("YHK003 not between", value1, value2, "yhk003");
            return (Criteria) this;
        }

        public Criteria andYhk004IsNull() {
            addCriterion("YHK004 is null");
            return (Criteria) this;
        }

        public Criteria andYhk004IsNotNull() {
            addCriterion("YHK004 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk004EqualTo(Float value) {
            addCriterion("YHK004 =", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004NotEqualTo(Float value) {
            addCriterion("YHK004 <>", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004GreaterThan(Float value) {
            addCriterion("YHK004 >", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004GreaterThanOrEqualTo(Float value) {
            addCriterion("YHK004 >=", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004LessThan(Float value) {
            addCriterion("YHK004 <", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004LessThanOrEqualTo(Float value) {
            addCriterion("YHK004 <=", value, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004In(List<Float> values) {
            addCriterion("YHK004 in", values, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004NotIn(List<Float> values) {
            addCriterion("YHK004 not in", values, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004Between(Float value1, Float value2) {
            addCriterion("YHK004 between", value1, value2, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk004NotBetween(Float value1, Float value2) {
            addCriterion("YHK004 not between", value1, value2, "yhk004");
            return (Criteria) this;
        }

        public Criteria andYhk005IsNull() {
            addCriterion("YHK005 is null");
            return (Criteria) this;
        }

        public Criteria andYhk005IsNotNull() {
            addCriterion("YHK005 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk005EqualTo(Float value) {
            addCriterion("YHK005 =", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005NotEqualTo(Float value) {
            addCriterion("YHK005 <>", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005GreaterThan(Float value) {
            addCriterion("YHK005 >", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005GreaterThanOrEqualTo(Float value) {
            addCriterion("YHK005 >=", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005LessThan(Float value) {
            addCriterion("YHK005 <", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005LessThanOrEqualTo(Float value) {
            addCriterion("YHK005 <=", value, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005In(List<Float> values) {
            addCriterion("YHK005 in", values, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005NotIn(List<Float> values) {
            addCriterion("YHK005 not in", values, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005Between(Float value1, Float value2) {
            addCriterion("YHK005 between", value1, value2, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk005NotBetween(Float value1, Float value2) {
            addCriterion("YHK005 not between", value1, value2, "yhk005");
            return (Criteria) this;
        }

        public Criteria andYhk006IsNull() {
            addCriterion("YHK006 is null");
            return (Criteria) this;
        }

        public Criteria andYhk006IsNotNull() {
            addCriterion("YHK006 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk006EqualTo(Float value) {
            addCriterion("YHK006 =", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006NotEqualTo(Float value) {
            addCriterion("YHK006 <>", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006GreaterThan(Float value) {
            addCriterion("YHK006 >", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006GreaterThanOrEqualTo(Float value) {
            addCriterion("YHK006 >=", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006LessThan(Float value) {
            addCriterion("YHK006 <", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006LessThanOrEqualTo(Float value) {
            addCriterion("YHK006 <=", value, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006In(List<Float> values) {
            addCriterion("YHK006 in", values, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006NotIn(List<Float> values) {
            addCriterion("YHK006 not in", values, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006Between(Float value1, Float value2) {
            addCriterion("YHK006 between", value1, value2, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk006NotBetween(Float value1, Float value2) {
            addCriterion("YHK006 not between", value1, value2, "yhk006");
            return (Criteria) this;
        }

        public Criteria andYhk007IsNull() {
            addCriterion("YHK007 is null");
            return (Criteria) this;
        }

        public Criteria andYhk007IsNotNull() {
            addCriterion("YHK007 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk007EqualTo(String value) {
            addCriterion("YHK007 =", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007NotEqualTo(String value) {
            addCriterion("YHK007 <>", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007GreaterThan(String value) {
            addCriterion("YHK007 >", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007GreaterThanOrEqualTo(String value) {
            addCriterion("YHK007 >=", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007LessThan(String value) {
            addCriterion("YHK007 <", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007LessThanOrEqualTo(String value) {
            addCriterion("YHK007 <=", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007Like(String value) {
            addCriterion("YHK007 like", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007NotLike(String value) {
            addCriterion("YHK007 not like", value, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007In(List<String> values) {
            addCriterion("YHK007 in", values, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007NotIn(List<String> values) {
            addCriterion("YHK007 not in", values, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007Between(String value1, String value2) {
            addCriterion("YHK007 between", value1, value2, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk007NotBetween(String value1, String value2) {
            addCriterion("YHK007 not between", value1, value2, "yhk007");
            return (Criteria) this;
        }

        public Criteria andYhk008IsNull() {
            addCriterion("YHK008 is null");
            return (Criteria) this;
        }

        public Criteria andYhk008IsNotNull() {
            addCriterion("YHK008 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk008EqualTo(Integer value) {
            addCriterion("YHK008 =", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008NotEqualTo(Integer value) {
            addCriterion("YHK008 <>", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008GreaterThan(Integer value) {
            addCriterion("YHK008 >", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHK008 >=", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008LessThan(Integer value) {
            addCriterion("YHK008 <", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008LessThanOrEqualTo(Integer value) {
            addCriterion("YHK008 <=", value, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008In(List<Integer> values) {
            addCriterion("YHK008 in", values, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008NotIn(List<Integer> values) {
            addCriterion("YHK008 not in", values, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008Between(Integer value1, Integer value2) {
            addCriterion("YHK008 between", value1, value2, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk008NotBetween(Integer value1, Integer value2) {
            addCriterion("YHK008 not between", value1, value2, "yhk008");
            return (Criteria) this;
        }

        public Criteria andYhk009IsNull() {
            addCriterion("YHK009 is null");
            return (Criteria) this;
        }

        public Criteria andYhk009IsNotNull() {
            addCriterion("YHK009 is not null");
            return (Criteria) this;
        }

        public Criteria andYhk009EqualTo(String value) {
            addCriterion("YHK009 =", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009NotEqualTo(String value) {
            addCriterion("YHK009 <>", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009GreaterThan(String value) {
            addCriterion("YHK009 >", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009GreaterThanOrEqualTo(String value) {
            addCriterion("YHK009 >=", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009LessThan(String value) {
            addCriterion("YHK009 <", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009LessThanOrEqualTo(String value) {
            addCriterion("YHK009 <=", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009Like(String value) {
            addCriterion("YHK009 like", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009NotLike(String value) {
            addCriterion("YHK009 not like", value, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009In(List<String> values) {
            addCriterion("YHK009 in", values, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009NotIn(List<String> values) {
            addCriterion("YHK009 not in", values, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009Between(String value1, String value2) {
            addCriterion("YHK009 between", value1, value2, "yhk009");
            return (Criteria) this;
        }

        public Criteria andYhk009NotBetween(String value1, String value2) {
            addCriterion("YHK009 not between", value1, value2, "yhk009");
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
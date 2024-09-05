package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdusgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusgExample() {
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

        public Criteria andUsg001IsNull() {
            addCriterion("USG001 is null");
            return (Criteria) this;
        }

        public Criteria andUsg001IsNotNull() {
            addCriterion("USG001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg001EqualTo(String value) {
            addCriterion("USG001 =", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001NotEqualTo(String value) {
            addCriterion("USG001 <>", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001GreaterThan(String value) {
            addCriterion("USG001 >", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001GreaterThanOrEqualTo(String value) {
            addCriterion("USG001 >=", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001LessThan(String value) {
            addCriterion("USG001 <", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001LessThanOrEqualTo(String value) {
            addCriterion("USG001 <=", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001Like(String value) {
            addCriterion("USG001 like", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001NotLike(String value) {
            addCriterion("USG001 not like", value, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001In(List<String> values) {
            addCriterion("USG001 in", values, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001NotIn(List<String> values) {
            addCriterion("USG001 not in", values, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001Between(String value1, String value2) {
            addCriterion("USG001 between", value1, value2, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg001NotBetween(String value1, String value2) {
            addCriterion("USG001 not between", value1, value2, "usg001");
            return (Criteria) this;
        }

        public Criteria andUsg002IsNull() {
            addCriterion("USG002 is null");
            return (Criteria) this;
        }

        public Criteria andUsg002IsNotNull() {
            addCriterion("USG002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg002EqualTo(Integer value) {
            addCriterion("USG002 =", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002NotEqualTo(Integer value) {
            addCriterion("USG002 <>", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002GreaterThan(Integer value) {
            addCriterion("USG002 >", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002GreaterThanOrEqualTo(Integer value) {
            addCriterion("USG002 >=", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002LessThan(Integer value) {
            addCriterion("USG002 <", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002LessThanOrEqualTo(Integer value) {
            addCriterion("USG002 <=", value, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002In(List<Integer> values) {
            addCriterion("USG002 in", values, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002NotIn(List<Integer> values) {
            addCriterion("USG002 not in", values, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002Between(Integer value1, Integer value2) {
            addCriterion("USG002 between", value1, value2, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg002NotBetween(Integer value1, Integer value2) {
            addCriterion("USG002 not between", value1, value2, "usg002");
            return (Criteria) this;
        }

        public Criteria andUsg003IsNull() {
            addCriterion("USG003 is null");
            return (Criteria) this;
        }

        public Criteria andUsg003IsNotNull() {
            addCriterion("USG003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg003EqualTo(Integer value) {
            addCriterion("USG003 =", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003NotEqualTo(Integer value) {
            addCriterion("USG003 <>", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003GreaterThan(Integer value) {
            addCriterion("USG003 >", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003GreaterThanOrEqualTo(Integer value) {
            addCriterion("USG003 >=", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003LessThan(Integer value) {
            addCriterion("USG003 <", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003LessThanOrEqualTo(Integer value) {
            addCriterion("USG003 <=", value, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003In(List<Integer> values) {
            addCriterion("USG003 in", values, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003NotIn(List<Integer> values) {
            addCriterion("USG003 not in", values, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003Between(Integer value1, Integer value2) {
            addCriterion("USG003 between", value1, value2, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg003NotBetween(Integer value1, Integer value2) {
            addCriterion("USG003 not between", value1, value2, "usg003");
            return (Criteria) this;
        }

        public Criteria andUsg004IsNull() {
            addCriterion("USG004 is null");
            return (Criteria) this;
        }

        public Criteria andUsg004IsNotNull() {
            addCriterion("USG004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg004EqualTo(Integer value) {
            addCriterion("USG004 =", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004NotEqualTo(Integer value) {
            addCriterion("USG004 <>", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004GreaterThan(Integer value) {
            addCriterion("USG004 >", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004GreaterThanOrEqualTo(Integer value) {
            addCriterion("USG004 >=", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004LessThan(Integer value) {
            addCriterion("USG004 <", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004LessThanOrEqualTo(Integer value) {
            addCriterion("USG004 <=", value, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004In(List<Integer> values) {
            addCriterion("USG004 in", values, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004NotIn(List<Integer> values) {
            addCriterion("USG004 not in", values, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004Between(Integer value1, Integer value2) {
            addCriterion("USG004 between", value1, value2, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg004NotBetween(Integer value1, Integer value2) {
            addCriterion("USG004 not between", value1, value2, "usg004");
            return (Criteria) this;
        }

        public Criteria andUsg005IsNull() {
            addCriterion("USG005 is null");
            return (Criteria) this;
        }

        public Criteria andUsg005IsNotNull() {
            addCriterion("USG005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg005EqualTo(Float value) {
            addCriterion("USG005 =", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005NotEqualTo(Float value) {
            addCriterion("USG005 <>", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005GreaterThan(Float value) {
            addCriterion("USG005 >", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005GreaterThanOrEqualTo(Float value) {
            addCriterion("USG005 >=", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005LessThan(Float value) {
            addCriterion("USG005 <", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005LessThanOrEqualTo(Float value) {
            addCriterion("USG005 <=", value, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005In(List<Float> values) {
            addCriterion("USG005 in", values, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005NotIn(List<Float> values) {
            addCriterion("USG005 not in", values, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005Between(Float value1, Float value2) {
            addCriterion("USG005 between", value1, value2, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg005NotBetween(Float value1, Float value2) {
            addCriterion("USG005 not between", value1, value2, "usg005");
            return (Criteria) this;
        }

        public Criteria andUsg006IsNull() {
            addCriterion("USG006 is null");
            return (Criteria) this;
        }

        public Criteria andUsg006IsNotNull() {
            addCriterion("USG006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg006EqualTo(Float value) {
            addCriterion("USG006 =", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006NotEqualTo(Float value) {
            addCriterion("USG006 <>", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006GreaterThan(Float value) {
            addCriterion("USG006 >", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006GreaterThanOrEqualTo(Float value) {
            addCriterion("USG006 >=", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006LessThan(Float value) {
            addCriterion("USG006 <", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006LessThanOrEqualTo(Float value) {
            addCriterion("USG006 <=", value, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006In(List<Float> values) {
            addCriterion("USG006 in", values, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006NotIn(List<Float> values) {
            addCriterion("USG006 not in", values, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006Between(Float value1, Float value2) {
            addCriterion("USG006 between", value1, value2, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg006NotBetween(Float value1, Float value2) {
            addCriterion("USG006 not between", value1, value2, "usg006");
            return (Criteria) this;
        }

        public Criteria andUsg007IsNull() {
            addCriterion("USG007 is null");
            return (Criteria) this;
        }

        public Criteria andUsg007IsNotNull() {
            addCriterion("USG007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg007EqualTo(Date value) {
            addCriterion("USG007 =", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007NotEqualTo(Date value) {
            addCriterion("USG007 <>", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007GreaterThan(Date value) {
            addCriterion("USG007 >", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007GreaterThanOrEqualTo(Date value) {
            addCriterion("USG007 >=", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007LessThan(Date value) {
            addCriterion("USG007 <", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007LessThanOrEqualTo(Date value) {
            addCriterion("USG007 <=", value, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007In(List<Date> values) {
            addCriterion("USG007 in", values, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007NotIn(List<Date> values) {
            addCriterion("USG007 not in", values, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007Between(Date value1, Date value2) {
            addCriterion("USG007 between", value1, value2, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg007NotBetween(Date value1, Date value2) {
            addCriterion("USG007 not between", value1, value2, "usg007");
            return (Criteria) this;
        }

        public Criteria andUsg008IsNull() {
            addCriterion("USG008 is null");
            return (Criteria) this;
        }

        public Criteria andUsg008IsNotNull() {
            addCriterion("USG008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg008EqualTo(String value) {
            addCriterion("USG008 =", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008NotEqualTo(String value) {
            addCriterion("USG008 <>", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008GreaterThan(String value) {
            addCriterion("USG008 >", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008GreaterThanOrEqualTo(String value) {
            addCriterion("USG008 >=", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008LessThan(String value) {
            addCriterion("USG008 <", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008LessThanOrEqualTo(String value) {
            addCriterion("USG008 <=", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008Like(String value) {
            addCriterion("USG008 like", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008NotLike(String value) {
            addCriterion("USG008 not like", value, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008In(List<String> values) {
            addCriterion("USG008 in", values, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008NotIn(List<String> values) {
            addCriterion("USG008 not in", values, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008Between(String value1, String value2) {
            addCriterion("USG008 between", value1, value2, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg008NotBetween(String value1, String value2) {
            addCriterion("USG008 not between", value1, value2, "usg008");
            return (Criteria) this;
        }

        public Criteria andUsg009IsNull() {
            addCriterion("USG009 is null");
            return (Criteria) this;
        }

        public Criteria andUsg009IsNotNull() {
            addCriterion("USG009 is not null");
            return (Criteria) this;
        }

        public Criteria andUsg009EqualTo(String value) {
            addCriterion("USG009 =", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009NotEqualTo(String value) {
            addCriterion("USG009 <>", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009GreaterThan(String value) {
            addCriterion("USG009 >", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009GreaterThanOrEqualTo(String value) {
            addCriterion("USG009 >=", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009LessThan(String value) {
            addCriterion("USG009 <", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009LessThanOrEqualTo(String value) {
            addCriterion("USG009 <=", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009Like(String value) {
            addCriterion("USG009 like", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009NotLike(String value) {
            addCriterion("USG009 not like", value, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009In(List<String> values) {
            addCriterion("USG009 in", values, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009NotIn(List<String> values) {
            addCriterion("USG009 not in", values, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009Between(String value1, String value2) {
            addCriterion("USG009 between", value1, value2, "usg009");
            return (Criteria) this;
        }

        public Criteria andUsg009NotBetween(String value1, String value2) {
            addCriterion("USG009 not between", value1, value2, "usg009");
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
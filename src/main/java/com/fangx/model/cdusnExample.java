package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdusnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusnExample() {
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

        public Criteria andUsn001IsNull() {
            addCriterion("USN001 is null");
            return (Criteria) this;
        }

        public Criteria andUsn001IsNotNull() {
            addCriterion("USN001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsn001EqualTo(Integer value) {
            addCriterion("USN001 =", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001NotEqualTo(Integer value) {
            addCriterion("USN001 <>", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001GreaterThan(Integer value) {
            addCriterion("USN001 >", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USN001 >=", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001LessThan(Integer value) {
            addCriterion("USN001 <", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001LessThanOrEqualTo(Integer value) {
            addCriterion("USN001 <=", value, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001In(List<Integer> values) {
            addCriterion("USN001 in", values, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001NotIn(List<Integer> values) {
            addCriterion("USN001 not in", values, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001Between(Integer value1, Integer value2) {
            addCriterion("USN001 between", value1, value2, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn001NotBetween(Integer value1, Integer value2) {
            addCriterion("USN001 not between", value1, value2, "usn001");
            return (Criteria) this;
        }

        public Criteria andUsn002IsNull() {
            addCriterion("USN002 is null");
            return (Criteria) this;
        }

        public Criteria andUsn002IsNotNull() {
            addCriterion("USN002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsn002EqualTo(Integer value) {
            addCriterion("USN002 =", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002NotEqualTo(Integer value) {
            addCriterion("USN002 <>", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002GreaterThan(Integer value) {
            addCriterion("USN002 >", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002GreaterThanOrEqualTo(Integer value) {
            addCriterion("USN002 >=", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002LessThan(Integer value) {
            addCriterion("USN002 <", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002LessThanOrEqualTo(Integer value) {
            addCriterion("USN002 <=", value, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002In(List<Integer> values) {
            addCriterion("USN002 in", values, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002NotIn(List<Integer> values) {
            addCriterion("USN002 not in", values, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002Between(Integer value1, Integer value2) {
            addCriterion("USN002 between", value1, value2, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn002NotBetween(Integer value1, Integer value2) {
            addCriterion("USN002 not between", value1, value2, "usn002");
            return (Criteria) this;
        }

        public Criteria andUsn003IsNull() {
            addCriterion("USN003 is null");
            return (Criteria) this;
        }

        public Criteria andUsn003IsNotNull() {
            addCriterion("USN003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsn003EqualTo(String value) {
            addCriterion("USN003 =", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003NotEqualTo(String value) {
            addCriterion("USN003 <>", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003GreaterThan(String value) {
            addCriterion("USN003 >", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003GreaterThanOrEqualTo(String value) {
            addCriterion("USN003 >=", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003LessThan(String value) {
            addCriterion("USN003 <", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003LessThanOrEqualTo(String value) {
            addCriterion("USN003 <=", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003Like(String value) {
            addCriterion("USN003 like", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003NotLike(String value) {
            addCriterion("USN003 not like", value, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003In(List<String> values) {
            addCriterion("USN003 in", values, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003NotIn(List<String> values) {
            addCriterion("USN003 not in", values, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003Between(String value1, String value2) {
            addCriterion("USN003 between", value1, value2, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn003NotBetween(String value1, String value2) {
            addCriterion("USN003 not between", value1, value2, "usn003");
            return (Criteria) this;
        }

        public Criteria andUsn004IsNull() {
            addCriterion("USN004 is null");
            return (Criteria) this;
        }

        public Criteria andUsn004IsNotNull() {
            addCriterion("USN004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsn004EqualTo(String value) {
            addCriterion("USN004 =", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004NotEqualTo(String value) {
            addCriterion("USN004 <>", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004GreaterThan(String value) {
            addCriterion("USN004 >", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004GreaterThanOrEqualTo(String value) {
            addCriterion("USN004 >=", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004LessThan(String value) {
            addCriterion("USN004 <", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004LessThanOrEqualTo(String value) {
            addCriterion("USN004 <=", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004Like(String value) {
            addCriterion("USN004 like", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004NotLike(String value) {
            addCriterion("USN004 not like", value, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004In(List<String> values) {
            addCriterion("USN004 in", values, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004NotIn(List<String> values) {
            addCriterion("USN004 not in", values, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004Between(String value1, String value2) {
            addCriterion("USN004 between", value1, value2, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn004NotBetween(String value1, String value2) {
            addCriterion("USN004 not between", value1, value2, "usn004");
            return (Criteria) this;
        }

        public Criteria andUsn005IsNull() {
            addCriterion("USN005 is null");
            return (Criteria) this;
        }

        public Criteria andUsn005IsNotNull() {
            addCriterion("USN005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsn005EqualTo(String value) {
            addCriterion("USN005 =", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005NotEqualTo(String value) {
            addCriterion("USN005 <>", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005GreaterThan(String value) {
            addCriterion("USN005 >", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005GreaterThanOrEqualTo(String value) {
            addCriterion("USN005 >=", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005LessThan(String value) {
            addCriterion("USN005 <", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005LessThanOrEqualTo(String value) {
            addCriterion("USN005 <=", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005Like(String value) {
            addCriterion("USN005 like", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005NotLike(String value) {
            addCriterion("USN005 not like", value, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005In(List<String> values) {
            addCriterion("USN005 in", values, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005NotIn(List<String> values) {
            addCriterion("USN005 not in", values, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005Between(String value1, String value2) {
            addCriterion("USN005 between", value1, value2, "usn005");
            return (Criteria) this;
        }

        public Criteria andUsn005NotBetween(String value1, String value2) {
            addCriterion("USN005 not between", value1, value2, "usn005");
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
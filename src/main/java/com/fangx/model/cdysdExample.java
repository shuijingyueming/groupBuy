package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdysdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdysdExample() {
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

        public Criteria andYsd001IsNull() {
            addCriterion("YSD001 is null");
            return (Criteria) this;
        }

        public Criteria andYsd001IsNotNull() {
            addCriterion("YSD001 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd001EqualTo(Integer value) {
            addCriterion("YSD001 =", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001NotEqualTo(Integer value) {
            addCriterion("YSD001 <>", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001GreaterThan(Integer value) {
            addCriterion("YSD001 >", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSD001 >=", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001LessThan(Integer value) {
            addCriterion("YSD001 <", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001LessThanOrEqualTo(Integer value) {
            addCriterion("YSD001 <=", value, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001In(List<Integer> values) {
            addCriterion("YSD001 in", values, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001NotIn(List<Integer> values) {
            addCriterion("YSD001 not in", values, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001Between(Integer value1, Integer value2) {
            addCriterion("YSD001 between", value1, value2, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd001NotBetween(Integer value1, Integer value2) {
            addCriterion("YSD001 not between", value1, value2, "ysd001");
            return (Criteria) this;
        }

        public Criteria andYsd002IsNull() {
            addCriterion("YSD002 is null");
            return (Criteria) this;
        }

        public Criteria andYsd002IsNotNull() {
            addCriterion("YSD002 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd002EqualTo(Integer value) {
            addCriterion("YSD002 =", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002NotEqualTo(Integer value) {
            addCriterion("YSD002 <>", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002GreaterThan(Integer value) {
            addCriterion("YSD002 >", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSD002 >=", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002LessThan(Integer value) {
            addCriterion("YSD002 <", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002LessThanOrEqualTo(Integer value) {
            addCriterion("YSD002 <=", value, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002In(List<Integer> values) {
            addCriterion("YSD002 in", values, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002NotIn(List<Integer> values) {
            addCriterion("YSD002 not in", values, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002Between(Integer value1, Integer value2) {
            addCriterion("YSD002 between", value1, value2, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd002NotBetween(Integer value1, Integer value2) {
            addCriterion("YSD002 not between", value1, value2, "ysd002");
            return (Criteria) this;
        }

        public Criteria andYsd003IsNull() {
            addCriterion("YSD003 is null");
            return (Criteria) this;
        }

        public Criteria andYsd003IsNotNull() {
            addCriterion("YSD003 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd003EqualTo(Integer value) {
            addCriterion("YSD003 =", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003NotEqualTo(Integer value) {
            addCriterion("YSD003 <>", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003GreaterThan(Integer value) {
            addCriterion("YSD003 >", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSD003 >=", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003LessThan(Integer value) {
            addCriterion("YSD003 <", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003LessThanOrEqualTo(Integer value) {
            addCriterion("YSD003 <=", value, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003In(List<Integer> values) {
            addCriterion("YSD003 in", values, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003NotIn(List<Integer> values) {
            addCriterion("YSD003 not in", values, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003Between(Integer value1, Integer value2) {
            addCriterion("YSD003 between", value1, value2, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd003NotBetween(Integer value1, Integer value2) {
            addCriterion("YSD003 not between", value1, value2, "ysd003");
            return (Criteria) this;
        }

        public Criteria andYsd004IsNull() {
            addCriterion("YSD004 is null");
            return (Criteria) this;
        }

        public Criteria andYsd004IsNotNull() {
            addCriterion("YSD004 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd004EqualTo(Date value) {
            addCriterion("YSD004 =", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004NotEqualTo(Date value) {
            addCriterion("YSD004 <>", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004GreaterThan(Date value) {
            addCriterion("YSD004 >", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004GreaterThanOrEqualTo(Date value) {
            addCriterion("YSD004 >=", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004LessThan(Date value) {
            addCriterion("YSD004 <", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004LessThanOrEqualTo(Date value) {
            addCriterion("YSD004 <=", value, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004In(List<Date> values) {
            addCriterion("YSD004 in", values, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004NotIn(List<Date> values) {
            addCriterion("YSD004 not in", values, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004Between(Date value1, Date value2) {
            addCriterion("YSD004 between", value1, value2, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd004NotBetween(Date value1, Date value2) {
            addCriterion("YSD004 not between", value1, value2, "ysd004");
            return (Criteria) this;
        }

        public Criteria andYsd005IsNull() {
            addCriterion("YSD005 is null");
            return (Criteria) this;
        }

        public Criteria andYsd005IsNotNull() {
            addCriterion("YSD005 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd005EqualTo(String value) {
            addCriterion("YSD005 =", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005NotEqualTo(String value) {
            addCriterion("YSD005 <>", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005GreaterThan(String value) {
            addCriterion("YSD005 >", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005GreaterThanOrEqualTo(String value) {
            addCriterion("YSD005 >=", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005LessThan(String value) {
            addCriterion("YSD005 <", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005LessThanOrEqualTo(String value) {
            addCriterion("YSD005 <=", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005Like(String value) {
            addCriterion("YSD005 like", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005NotLike(String value) {
            addCriterion("YSD005 not like", value, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005In(List<String> values) {
            addCriterion("YSD005 in", values, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005NotIn(List<String> values) {
            addCriterion("YSD005 not in", values, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005Between(String value1, String value2) {
            addCriterion("YSD005 between", value1, value2, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd005NotBetween(String value1, String value2) {
            addCriterion("YSD005 not between", value1, value2, "ysd005");
            return (Criteria) this;
        }

        public Criteria andYsd006IsNull() {
            addCriterion("YSD006 is null");
            return (Criteria) this;
        }

        public Criteria andYsd006IsNotNull() {
            addCriterion("YSD006 is not null");
            return (Criteria) this;
        }

        public Criteria andYsd006EqualTo(Integer value) {
            addCriterion("YSD006 =", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006NotEqualTo(Integer value) {
            addCriterion("YSD006 <>", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006GreaterThan(Integer value) {
            addCriterion("YSD006 >", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006GreaterThanOrEqualTo(Integer value) {
            addCriterion("YSD006 >=", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006LessThan(Integer value) {
            addCriterion("YSD006 <", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006LessThanOrEqualTo(Integer value) {
            addCriterion("YSD006 <=", value, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006In(List<Integer> values) {
            addCriterion("YSD006 in", values, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006NotIn(List<Integer> values) {
            addCriterion("YSD006 not in", values, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006Between(Integer value1, Integer value2) {
            addCriterion("YSD006 between", value1, value2, "ysd006");
            return (Criteria) this;
        }

        public Criteria andYsd006NotBetween(Integer value1, Integer value2) {
            addCriterion("YSD006 not between", value1, value2, "ysd006");
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
package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdyhaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyhaExample() {
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

        public Criteria andYha001IsNull() {
            addCriterion("YHA001 is null");
            return (Criteria) this;
        }

        public Criteria andYha001IsNotNull() {
            addCriterion("YHA001 is not null");
            return (Criteria) this;
        }

        public Criteria andYha001EqualTo(Integer value) {
            addCriterion("YHA001 =", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001NotEqualTo(Integer value) {
            addCriterion("YHA001 <>", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001GreaterThan(Integer value) {
            addCriterion("YHA001 >", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHA001 >=", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001LessThan(Integer value) {
            addCriterion("YHA001 <", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001LessThanOrEqualTo(Integer value) {
            addCriterion("YHA001 <=", value, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001In(List<Integer> values) {
            addCriterion("YHA001 in", values, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001NotIn(List<Integer> values) {
            addCriterion("YHA001 not in", values, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001Between(Integer value1, Integer value2) {
            addCriterion("YHA001 between", value1, value2, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha001NotBetween(Integer value1, Integer value2) {
            addCriterion("YHA001 not between", value1, value2, "yha001");
            return (Criteria) this;
        }

        public Criteria andYha002IsNull() {
            addCriterion("YHA002 is null");
            return (Criteria) this;
        }

        public Criteria andYha002IsNotNull() {
            addCriterion("YHA002 is not null");
            return (Criteria) this;
        }

        public Criteria andYha002EqualTo(Integer value) {
            addCriterion("YHA002 =", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002NotEqualTo(Integer value) {
            addCriterion("YHA002 <>", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002GreaterThan(Integer value) {
            addCriterion("YHA002 >", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHA002 >=", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002LessThan(Integer value) {
            addCriterion("YHA002 <", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002LessThanOrEqualTo(Integer value) {
            addCriterion("YHA002 <=", value, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002In(List<Integer> values) {
            addCriterion("YHA002 in", values, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002NotIn(List<Integer> values) {
            addCriterion("YHA002 not in", values, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002Between(Integer value1, Integer value2) {
            addCriterion("YHA002 between", value1, value2, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha002NotBetween(Integer value1, Integer value2) {
            addCriterion("YHA002 not between", value1, value2, "yha002");
            return (Criteria) this;
        }

        public Criteria andYha003IsNull() {
            addCriterion("YHA003 is null");
            return (Criteria) this;
        }

        public Criteria andYha003IsNotNull() {
            addCriterion("YHA003 is not null");
            return (Criteria) this;
        }

        public Criteria andYha003EqualTo(Integer value) {
            addCriterion("YHA003 =", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003NotEqualTo(Integer value) {
            addCriterion("YHA003 <>", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003GreaterThan(Integer value) {
            addCriterion("YHA003 >", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHA003 >=", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003LessThan(Integer value) {
            addCriterion("YHA003 <", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003LessThanOrEqualTo(Integer value) {
            addCriterion("YHA003 <=", value, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003In(List<Integer> values) {
            addCriterion("YHA003 in", values, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003NotIn(List<Integer> values) {
            addCriterion("YHA003 not in", values, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003Between(Integer value1, Integer value2) {
            addCriterion("YHA003 between", value1, value2, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha003NotBetween(Integer value1, Integer value2) {
            addCriterion("YHA003 not between", value1, value2, "yha003");
            return (Criteria) this;
        }

        public Criteria andYha004IsNull() {
            addCriterion("YHA004 is null");
            return (Criteria) this;
        }

        public Criteria andYha004IsNotNull() {
            addCriterion("YHA004 is not null");
            return (Criteria) this;
        }

        public Criteria andYha004EqualTo(Integer value) {
            addCriterion("YHA004 =", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004NotEqualTo(Integer value) {
            addCriterion("YHA004 <>", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004GreaterThan(Integer value) {
            addCriterion("YHA004 >", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHA004 >=", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004LessThan(Integer value) {
            addCriterion("YHA004 <", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004LessThanOrEqualTo(Integer value) {
            addCriterion("YHA004 <=", value, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004In(List<Integer> values) {
            addCriterion("YHA004 in", values, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004NotIn(List<Integer> values) {
            addCriterion("YHA004 not in", values, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004Between(Integer value1, Integer value2) {
            addCriterion("YHA004 between", value1, value2, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha004NotBetween(Integer value1, Integer value2) {
            addCriterion("YHA004 not between", value1, value2, "yha004");
            return (Criteria) this;
        }

        public Criteria andYha005IsNull() {
            addCriterion("YHA005 is null");
            return (Criteria) this;
        }

        public Criteria andYha005IsNotNull() {
            addCriterion("YHA005 is not null");
            return (Criteria) this;
        }

        public Criteria andYha005EqualTo(String value) {
            addCriterion("YHA005 =", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005NotEqualTo(String value) {
            addCriterion("YHA005 <>", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005GreaterThan(String value) {
            addCriterion("YHA005 >", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005GreaterThanOrEqualTo(String value) {
            addCriterion("YHA005 >=", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005LessThan(String value) {
            addCriterion("YHA005 <", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005LessThanOrEqualTo(String value) {
            addCriterion("YHA005 <=", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005Like(String value) {
            addCriterion("YHA005 like", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005NotLike(String value) {
            addCriterion("YHA005 not like", value, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005In(List<String> values) {
            addCriterion("YHA005 in", values, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005NotIn(List<String> values) {
            addCriterion("YHA005 not in", values, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005Between(String value1, String value2) {
            addCriterion("YHA005 between", value1, value2, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha005NotBetween(String value1, String value2) {
            addCriterion("YHA005 not between", value1, value2, "yha005");
            return (Criteria) this;
        }

        public Criteria andYha006IsNull() {
            addCriterion("YHA006 is null");
            return (Criteria) this;
        }

        public Criteria andYha006IsNotNull() {
            addCriterion("YHA006 is not null");
            return (Criteria) this;
        }

        public Criteria andYha006EqualTo(Integer value) {
            addCriterion("YHA006 =", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006NotEqualTo(Integer value) {
            addCriterion("YHA006 <>", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006GreaterThan(Integer value) {
            addCriterion("YHA006 >", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHA006 >=", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006LessThan(Integer value) {
            addCriterion("YHA006 <", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006LessThanOrEqualTo(Integer value) {
            addCriterion("YHA006 <=", value, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006In(List<Integer> values) {
            addCriterion("YHA006 in", values, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006NotIn(List<Integer> values) {
            addCriterion("YHA006 not in", values, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006Between(Integer value1, Integer value2) {
            addCriterion("YHA006 between", value1, value2, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha006NotBetween(Integer value1, Integer value2) {
            addCriterion("YHA006 not between", value1, value2, "yha006");
            return (Criteria) this;
        }

        public Criteria andYha007IsNull() {
            addCriterion("YHA007 is null");
            return (Criteria) this;
        }

        public Criteria andYha007IsNotNull() {
            addCriterion("YHA007 is not null");
            return (Criteria) this;
        }

        public Criteria andYha007EqualTo(Float value) {
            addCriterion("YHA007 =", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007NotEqualTo(Float value) {
            addCriterion("YHA007 <>", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007GreaterThan(Float value) {
            addCriterion("YHA007 >", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007GreaterThanOrEqualTo(Float value) {
            addCriterion("YHA007 >=", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007LessThan(Float value) {
            addCriterion("YHA007 <", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007LessThanOrEqualTo(Float value) {
            addCriterion("YHA007 <=", value, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007In(List<Float> values) {
            addCriterion("YHA007 in", values, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007NotIn(List<Float> values) {
            addCriterion("YHA007 not in", values, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007Between(Float value1, Float value2) {
            addCriterion("YHA007 between", value1, value2, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha007NotBetween(Float value1, Float value2) {
            addCriterion("YHA007 not between", value1, value2, "yha007");
            return (Criteria) this;
        }

        public Criteria andYha008IsNull() {
            addCriterion("YHA008 is null");
            return (Criteria) this;
        }

        public Criteria andYha008IsNotNull() {
            addCriterion("YHA008 is not null");
            return (Criteria) this;
        }

        public Criteria andYha008EqualTo(String value) {
            addCriterion("YHA008 =", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008NotEqualTo(String value) {
            addCriterion("YHA008 <>", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008GreaterThan(String value) {
            addCriterion("YHA008 >", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008GreaterThanOrEqualTo(String value) {
            addCriterion("YHA008 >=", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008LessThan(String value) {
            addCriterion("YHA008 <", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008LessThanOrEqualTo(String value) {
            addCriterion("YHA008 <=", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008Like(String value) {
            addCriterion("YHA008 like", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008NotLike(String value) {
            addCriterion("YHA008 not like", value, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008In(List<String> values) {
            addCriterion("YHA008 in", values, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008NotIn(List<String> values) {
            addCriterion("YHA008 not in", values, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008Between(String value1, String value2) {
            addCriterion("YHA008 between", value1, value2, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha008NotBetween(String value1, String value2) {
            addCriterion("YHA008 not between", value1, value2, "yha008");
            return (Criteria) this;
        }

        public Criteria andYha009IsNull() {
            addCriterion("YHA009 is null");
            return (Criteria) this;
        }

        public Criteria andYha009IsNotNull() {
            addCriterion("YHA009 is not null");
            return (Criteria) this;
        }

        public Criteria andYha009EqualTo(String value) {
            addCriterion("YHA009 =", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009NotEqualTo(String value) {
            addCriterion("YHA009 <>", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009GreaterThan(String value) {
            addCriterion("YHA009 >", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009GreaterThanOrEqualTo(String value) {
            addCriterion("YHA009 >=", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009LessThan(String value) {
            addCriterion("YHA009 <", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009LessThanOrEqualTo(String value) {
            addCriterion("YHA009 <=", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009Like(String value) {
            addCriterion("YHA009 like", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009NotLike(String value) {
            addCriterion("YHA009 not like", value, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009In(List<String> values) {
            addCriterion("YHA009 in", values, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009NotIn(List<String> values) {
            addCriterion("YHA009 not in", values, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009Between(String value1, String value2) {
            addCriterion("YHA009 between", value1, value2, "yha009");
            return (Criteria) this;
        }

        public Criteria andYha009NotBetween(String value1, String value2) {
            addCriterion("YHA009 not between", value1, value2, "yha009");
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
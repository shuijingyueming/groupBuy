package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cduseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cduseExample() {
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

        public Criteria andUse001IsNull() {
            addCriterion("USE001 is null");
            return (Criteria) this;
        }

        public Criteria andUse001IsNotNull() {
            addCriterion("USE001 is not null");
            return (Criteria) this;
        }

        public Criteria andUse001EqualTo(Integer value) {
            addCriterion("USE001 =", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001NotEqualTo(Integer value) {
            addCriterion("USE001 <>", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001GreaterThan(Integer value) {
            addCriterion("USE001 >", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USE001 >=", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001LessThan(Integer value) {
            addCriterion("USE001 <", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001LessThanOrEqualTo(Integer value) {
            addCriterion("USE001 <=", value, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001In(List<Integer> values) {
            addCriterion("USE001 in", values, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001NotIn(List<Integer> values) {
            addCriterion("USE001 not in", values, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001Between(Integer value1, Integer value2) {
            addCriterion("USE001 between", value1, value2, "use001");
            return (Criteria) this;
        }

        public Criteria andUse001NotBetween(Integer value1, Integer value2) {
            addCriterion("USE001 not between", value1, value2, "use001");
            return (Criteria) this;
        }

        public Criteria andUse002IsNull() {
            addCriterion("USE002 is null");
            return (Criteria) this;
        }

        public Criteria andUse002IsNotNull() {
            addCriterion("USE002 is not null");
            return (Criteria) this;
        }

        public Criteria andUse002EqualTo(String value) {
            addCriterion("USE002 =", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002NotEqualTo(String value) {
            addCriterion("USE002 <>", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002GreaterThan(String value) {
            addCriterion("USE002 >", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002GreaterThanOrEqualTo(String value) {
            addCriterion("USE002 >=", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002LessThan(String value) {
            addCriterion("USE002 <", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002LessThanOrEqualTo(String value) {
            addCriterion("USE002 <=", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002Like(String value) {
            addCriterion("USE002 like", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002NotLike(String value) {
            addCriterion("USE002 not like", value, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002In(List<String> values) {
            addCriterion("USE002 in", values, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002NotIn(List<String> values) {
            addCriterion("USE002 not in", values, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002Between(String value1, String value2) {
            addCriterion("USE002 between", value1, value2, "use002");
            return (Criteria) this;
        }

        public Criteria andUse002NotBetween(String value1, String value2) {
            addCriterion("USE002 not between", value1, value2, "use002");
            return (Criteria) this;
        }

        public Criteria andUse003IsNull() {
            addCriterion("USE003 is null");
            return (Criteria) this;
        }

        public Criteria andUse003IsNotNull() {
            addCriterion("USE003 is not null");
            return (Criteria) this;
        }

        public Criteria andUse003EqualTo(String value) {
            addCriterion("USE003 =", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003NotEqualTo(String value) {
            addCriterion("USE003 <>", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003GreaterThan(String value) {
            addCriterion("USE003 >", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003GreaterThanOrEqualTo(String value) {
            addCriterion("USE003 >=", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003LessThan(String value) {
            addCriterion("USE003 <", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003LessThanOrEqualTo(String value) {
            addCriterion("USE003 <=", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003Like(String value) {
            addCriterion("USE003 like", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003NotLike(String value) {
            addCriterion("USE003 not like", value, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003In(List<String> values) {
            addCriterion("USE003 in", values, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003NotIn(List<String> values) {
            addCriterion("USE003 not in", values, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003Between(String value1, String value2) {
            addCriterion("USE003 between", value1, value2, "use003");
            return (Criteria) this;
        }

        public Criteria andUse003NotBetween(String value1, String value2) {
            addCriterion("USE003 not between", value1, value2, "use003");
            return (Criteria) this;
        }

        public Criteria andUse004IsNull() {
            addCriterion("USE004 is null");
            return (Criteria) this;
        }

        public Criteria andUse004IsNotNull() {
            addCriterion("USE004 is not null");
            return (Criteria) this;
        }

        public Criteria andUse004EqualTo(String value) {
            addCriterion("USE004 =", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004NotEqualTo(String value) {
            addCriterion("USE004 <>", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004GreaterThan(String value) {
            addCriterion("USE004 >", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004GreaterThanOrEqualTo(String value) {
            addCriterion("USE004 >=", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004LessThan(String value) {
            addCriterion("USE004 <", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004LessThanOrEqualTo(String value) {
            addCriterion("USE004 <=", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004Like(String value) {
            addCriterion("USE004 like", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004NotLike(String value) {
            addCriterion("USE004 not like", value, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004In(List<String> values) {
            addCriterion("USE004 in", values, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004NotIn(List<String> values) {
            addCriterion("USE004 not in", values, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004Between(String value1, String value2) {
            addCriterion("USE004 between", value1, value2, "use004");
            return (Criteria) this;
        }

        public Criteria andUse004NotBetween(String value1, String value2) {
            addCriterion("USE004 not between", value1, value2, "use004");
            return (Criteria) this;
        }

        public Criteria andUse005IsNull() {
            addCriterion("USE005 is null");
            return (Criteria) this;
        }

        public Criteria andUse005IsNotNull() {
            addCriterion("USE005 is not null");
            return (Criteria) this;
        }

        public Criteria andUse005EqualTo(String value) {
            addCriterion("USE005 =", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005NotEqualTo(String value) {
            addCriterion("USE005 <>", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005GreaterThan(String value) {
            addCriterion("USE005 >", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005GreaterThanOrEqualTo(String value) {
            addCriterion("USE005 >=", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005LessThan(String value) {
            addCriterion("USE005 <", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005LessThanOrEqualTo(String value) {
            addCriterion("USE005 <=", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005Like(String value) {
            addCriterion("USE005 like", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005NotLike(String value) {
            addCriterion("USE005 not like", value, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005In(List<String> values) {
            addCriterion("USE005 in", values, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005NotIn(List<String> values) {
            addCriterion("USE005 not in", values, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005Between(String value1, String value2) {
            addCriterion("USE005 between", value1, value2, "use005");
            return (Criteria) this;
        }

        public Criteria andUse005NotBetween(String value1, String value2) {
            addCriterion("USE005 not between", value1, value2, "use005");
            return (Criteria) this;
        }

        public Criteria andUse006IsNull() {
            addCriterion("USE006 is null");
            return (Criteria) this;
        }

        public Criteria andUse006IsNotNull() {
            addCriterion("USE006 is not null");
            return (Criteria) this;
        }

        public Criteria andUse006EqualTo(String value) {
            addCriterion("USE006 =", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006NotEqualTo(String value) {
            addCriterion("USE006 <>", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006GreaterThan(String value) {
            addCriterion("USE006 >", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006GreaterThanOrEqualTo(String value) {
            addCriterion("USE006 >=", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006LessThan(String value) {
            addCriterion("USE006 <", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006LessThanOrEqualTo(String value) {
            addCriterion("USE006 <=", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006Like(String value) {
            addCriterion("USE006 like", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006NotLike(String value) {
            addCriterion("USE006 not like", value, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006In(List<String> values) {
            addCriterion("USE006 in", values, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006NotIn(List<String> values) {
            addCriterion("USE006 not in", values, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006Between(String value1, String value2) {
            addCriterion("USE006 between", value1, value2, "use006");
            return (Criteria) this;
        }

        public Criteria andUse006NotBetween(String value1, String value2) {
            addCriterion("USE006 not between", value1, value2, "use006");
            return (Criteria) this;
        }

        public Criteria andUse007IsNull() {
            addCriterion("USE007 is null");
            return (Criteria) this;
        }

        public Criteria andUse007IsNotNull() {
            addCriterion("USE007 is not null");
            return (Criteria) this;
        }

        public Criteria andUse007EqualTo(String value) {
            addCriterion("USE007 =", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007NotEqualTo(String value) {
            addCriterion("USE007 <>", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007GreaterThan(String value) {
            addCriterion("USE007 >", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007GreaterThanOrEqualTo(String value) {
            addCriterion("USE007 >=", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007LessThan(String value) {
            addCriterion("USE007 <", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007LessThanOrEqualTo(String value) {
            addCriterion("USE007 <=", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007Like(String value) {
            addCriterion("USE007 like", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007NotLike(String value) {
            addCriterion("USE007 not like", value, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007In(List<String> values) {
            addCriterion("USE007 in", values, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007NotIn(List<String> values) {
            addCriterion("USE007 not in", values, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007Between(String value1, String value2) {
            addCriterion("USE007 between", value1, value2, "use007");
            return (Criteria) this;
        }

        public Criteria andUse007NotBetween(String value1, String value2) {
            addCriterion("USE007 not between", value1, value2, "use007");
            return (Criteria) this;
        }

        public Criteria andUse008IsNull() {
            addCriterion("USE008 is null");
            return (Criteria) this;
        }

        public Criteria andUse008IsNotNull() {
            addCriterion("USE008 is not null");
            return (Criteria) this;
        }

        public Criteria andUse008EqualTo(Integer value) {
            addCriterion("USE008 =", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008NotEqualTo(Integer value) {
            addCriterion("USE008 <>", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008GreaterThan(Integer value) {
            addCriterion("USE008 >", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008GreaterThanOrEqualTo(Integer value) {
            addCriterion("USE008 >=", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008LessThan(Integer value) {
            addCriterion("USE008 <", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008LessThanOrEqualTo(Integer value) {
            addCriterion("USE008 <=", value, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008In(List<Integer> values) {
            addCriterion("USE008 in", values, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008NotIn(List<Integer> values) {
            addCriterion("USE008 not in", values, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008Between(Integer value1, Integer value2) {
            addCriterion("USE008 between", value1, value2, "use008");
            return (Criteria) this;
        }

        public Criteria andUse008NotBetween(Integer value1, Integer value2) {
            addCriterion("USE008 not between", value1, value2, "use008");
            return (Criteria) this;
        }

        public Criteria andUse009IsNull() {
            addCriterion("USE009 is null");
            return (Criteria) this;
        }

        public Criteria andUse009IsNotNull() {
            addCriterion("USE009 is not null");
            return (Criteria) this;
        }

        public Criteria andUse009EqualTo(String value) {
            addCriterion("USE009 =", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009NotEqualTo(String value) {
            addCriterion("USE009 <>", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009GreaterThan(String value) {
            addCriterion("USE009 >", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009GreaterThanOrEqualTo(String value) {
            addCriterion("USE009 >=", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009LessThan(String value) {
            addCriterion("USE009 <", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009LessThanOrEqualTo(String value) {
            addCriterion("USE009 <=", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009Like(String value) {
            addCriterion("USE009 like", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009NotLike(String value) {
            addCriterion("USE009 not like", value, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009In(List<String> values) {
            addCriterion("USE009 in", values, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009NotIn(List<String> values) {
            addCriterion("USE009 not in", values, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009Between(String value1, String value2) {
            addCriterion("USE009 between", value1, value2, "use009");
            return (Criteria) this;
        }

        public Criteria andUse009NotBetween(String value1, String value2) {
            addCriterion("USE009 not between", value1, value2, "use009");
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
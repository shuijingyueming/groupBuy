package com.fangx.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class cdxxzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdxxzExample() {
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

        public Criteria andXxz001IsNull() {
            addCriterion("XXZ001 is null");
            return (Criteria) this;
        }

        public Criteria andXxz001IsNotNull() {
            addCriterion("XXZ001 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz001EqualTo(Integer value) {
            addCriterion("XXZ001 =", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001NotEqualTo(Integer value) {
            addCriterion("XXZ001 <>", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001GreaterThan(Integer value) {
            addCriterion("XXZ001 >", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001GreaterThanOrEqualTo(Integer value) {
            addCriterion("XXZ001 >=", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001LessThan(Integer value) {
            addCriterion("XXZ001 <", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001LessThanOrEqualTo(Integer value) {
            addCriterion("XXZ001 <=", value, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001In(List<Integer> values) {
            addCriterion("XXZ001 in", values, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001NotIn(List<Integer> values) {
            addCriterion("XXZ001 not in", values, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001Between(Integer value1, Integer value2) {
            addCriterion("XXZ001 between", value1, value2, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz001NotBetween(Integer value1, Integer value2) {
            addCriterion("XXZ001 not between", value1, value2, "xxz001");
            return (Criteria) this;
        }

        public Criteria andXxz002IsNull() {
            addCriterion("XXZ002 is null");
            return (Criteria) this;
        }

        public Criteria andXxz002IsNotNull() {
            addCriterion("XXZ002 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz002EqualTo(String value) {
            addCriterion("XXZ002 =", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002NotEqualTo(String value) {
            addCriterion("XXZ002 <>", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002GreaterThan(String value) {
            addCriterion("XXZ002 >", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ002 >=", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002LessThan(String value) {
            addCriterion("XXZ002 <", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002LessThanOrEqualTo(String value) {
            addCriterion("XXZ002 <=", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002Like(String value) {
            addCriterion("XXZ002 like", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002NotLike(String value) {
            addCriterion("XXZ002 not like", value, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002In(List<String> values) {
            addCriterion("XXZ002 in", values, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002NotIn(List<String> values) {
            addCriterion("XXZ002 not in", values, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002Between(String value1, String value2) {
            addCriterion("XXZ002 between", value1, value2, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz002NotBetween(String value1, String value2) {
            addCriterion("XXZ002 not between", value1, value2, "xxz002");
            return (Criteria) this;
        }

        public Criteria andXxz003IsNull() {
            addCriterion("XXZ003 is null");
            return (Criteria) this;
        }

        public Criteria andXxz003IsNotNull() {
            addCriterion("XXZ003 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz003EqualTo(String value) {
            addCriterion("XXZ003 =", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003NotEqualTo(String value) {
            addCriterion("XXZ003 <>", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003GreaterThan(String value) {
            addCriterion("XXZ003 >", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ003 >=", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003LessThan(String value) {
            addCriterion("XXZ003 <", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003LessThanOrEqualTo(String value) {
            addCriterion("XXZ003 <=", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003Like(String value) {
            addCriterion("XXZ003 like", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003NotLike(String value) {
            addCriterion("XXZ003 not like", value, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003In(List<String> values) {
            addCriterion("XXZ003 in", values, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003NotIn(List<String> values) {
            addCriterion("XXZ003 not in", values, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003Between(String value1, String value2) {
            addCriterion("XXZ003 between", value1, value2, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz003NotBetween(String value1, String value2) {
            addCriterion("XXZ003 not between", value1, value2, "xxz003");
            return (Criteria) this;
        }

        public Criteria andXxz004IsNull() {
            addCriterion("XXZ004 is null");
            return (Criteria) this;
        }

        public Criteria andXxz004IsNotNull() {
            addCriterion("XXZ004 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz004EqualTo(String value) {
            addCriterion("XXZ004 =", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004NotEqualTo(String value) {
            addCriterion("XXZ004 <>", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004GreaterThan(String value) {
            addCriterion("XXZ004 >", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ004 >=", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004LessThan(String value) {
            addCriterion("XXZ004 <", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004LessThanOrEqualTo(String value) {
            addCriterion("XXZ004 <=", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004Like(String value) {
            addCriterion("XXZ004 like", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004NotLike(String value) {
            addCriterion("XXZ004 not like", value, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004In(List<String> values) {
            addCriterion("XXZ004 in", values, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004NotIn(List<String> values) {
            addCriterion("XXZ004 not in", values, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004Between(String value1, String value2) {
            addCriterion("XXZ004 between", value1, value2, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz004NotBetween(String value1, String value2) {
            addCriterion("XXZ004 not between", value1, value2, "xxz004");
            return (Criteria) this;
        }

        public Criteria andXxz005IsNull() {
            addCriterion("XXZ005 is null");
            return (Criteria) this;
        }

        public Criteria andXxz005IsNotNull() {
            addCriterion("XXZ005 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz005EqualTo(String value) {
            addCriterion("XXZ005 =", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005NotEqualTo(String value) {
            addCriterion("XXZ005 <>", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005GreaterThan(String value) {
            addCriterion("XXZ005 >", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ005 >=", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005LessThan(String value) {
            addCriterion("XXZ005 <", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005LessThanOrEqualTo(String value) {
            addCriterion("XXZ005 <=", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005Like(String value) {
            addCriterion("XXZ005 like", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005NotLike(String value) {
            addCriterion("XXZ005 not like", value, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005In(List<String> values) {
            addCriterion("XXZ005 in", values, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005NotIn(List<String> values) {
            addCriterion("XXZ005 not in", values, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005Between(String value1, String value2) {
            addCriterion("XXZ005 between", value1, value2, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz005NotBetween(String value1, String value2) {
            addCriterion("XXZ005 not between", value1, value2, "xxz005");
            return (Criteria) this;
        }

        public Criteria andXxz006IsNull() {
            addCriterion("XXZ006 is null");
            return (Criteria) this;
        }

        public Criteria andXxz006IsNotNull() {
            addCriterion("XXZ006 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz006EqualTo(String value) {
            addCriterion("XXZ006 =", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006NotEqualTo(String value) {
            addCriterion("XXZ006 <>", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006GreaterThan(String value) {
            addCriterion("XXZ006 >", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ006 >=", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006LessThan(String value) {
            addCriterion("XXZ006 <", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006LessThanOrEqualTo(String value) {
            addCriterion("XXZ006 <=", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006Like(String value) {
            addCriterion("XXZ006 like", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006NotLike(String value) {
            addCriterion("XXZ006 not like", value, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006In(List<String> values) {
            addCriterion("XXZ006 in", values, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006NotIn(List<String> values) {
            addCriterion("XXZ006 not in", values, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006Between(String value1, String value2) {
            addCriterion("XXZ006 between", value1, value2, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz006NotBetween(String value1, String value2) {
            addCriterion("XXZ006 not between", value1, value2, "xxz006");
            return (Criteria) this;
        }

        public Criteria andXxz007IsNull() {
            addCriterion("XXZ007 is null");
            return (Criteria) this;
        }

        public Criteria andXxz007IsNotNull() {
            addCriterion("XXZ007 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz007EqualTo(String value) {
            addCriterion("XXZ007 =", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007NotEqualTo(String value) {
            addCriterion("XXZ007 <>", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007GreaterThan(String value) {
            addCriterion("XXZ007 >", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ007 >=", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007LessThan(String value) {
            addCriterion("XXZ007 <", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007LessThanOrEqualTo(String value) {
            addCriterion("XXZ007 <=", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007Like(String value) {
            addCriterion("XXZ007 like", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007NotLike(String value) {
            addCriterion("XXZ007 not like", value, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007In(List<String> values) {
            addCriterion("XXZ007 in", values, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007NotIn(List<String> values) {
            addCriterion("XXZ007 not in", values, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007Between(String value1, String value2) {
            addCriterion("XXZ007 between", value1, value2, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz007NotBetween(String value1, String value2) {
            addCriterion("XXZ007 not between", value1, value2, "xxz007");
            return (Criteria) this;
        }

        public Criteria andXxz008IsNull() {
            addCriterion("XXZ008 is null");
            return (Criteria) this;
        }

        public Criteria andXxz008IsNotNull() {
            addCriterion("XXZ008 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz008EqualTo(String value) {
            addCriterion("XXZ008 =", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008NotEqualTo(String value) {
            addCriterion("XXZ008 <>", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008GreaterThan(String value) {
            addCriterion("XXZ008 >", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ008 >=", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008LessThan(String value) {
            addCriterion("XXZ008 <", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008LessThanOrEqualTo(String value) {
            addCriterion("XXZ008 <=", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008Like(String value) {
            addCriterion("XXZ008 like", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008NotLike(String value) {
            addCriterion("XXZ008 not like", value, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008In(List<String> values) {
            addCriterion("XXZ008 in", values, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008NotIn(List<String> values) {
            addCriterion("XXZ008 not in", values, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008Between(String value1, String value2) {
            addCriterion("XXZ008 between", value1, value2, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz008NotBetween(String value1, String value2) {
            addCriterion("XXZ008 not between", value1, value2, "xxz008");
            return (Criteria) this;
        }

        public Criteria andXxz009IsNull() {
            addCriterion("XXZ009 is null");
            return (Criteria) this;
        }

        public Criteria andXxz009IsNotNull() {
            addCriterion("XXZ009 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz009EqualTo(String value) {
            addCriterion("XXZ009 =", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009NotEqualTo(String value) {
            addCriterion("XXZ009 <>", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009GreaterThan(String value) {
            addCriterion("XXZ009 >", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ009 >=", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009LessThan(String value) {
            addCriterion("XXZ009 <", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009LessThanOrEqualTo(String value) {
            addCriterion("XXZ009 <=", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009Like(String value) {
            addCriterion("XXZ009 like", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009NotLike(String value) {
            addCriterion("XXZ009 not like", value, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009In(List<String> values) {
            addCriterion("XXZ009 in", values, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009NotIn(List<String> values) {
            addCriterion("XXZ009 not in", values, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009Between(String value1, String value2) {
            addCriterion("XXZ009 between", value1, value2, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz009NotBetween(String value1, String value2) {
            addCriterion("XXZ009 not between", value1, value2, "xxz009");
            return (Criteria) this;
        }

        public Criteria andXxz010IsNull() {
            addCriterion("XXZ010 is null");
            return (Criteria) this;
        }

        public Criteria andXxz010IsNotNull() {
            addCriterion("XXZ010 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz010EqualTo(String value) {
            addCriterion("XXZ010 =", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010NotEqualTo(String value) {
            addCriterion("XXZ010 <>", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010GreaterThan(String value) {
            addCriterion("XXZ010 >", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ010 >=", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010LessThan(String value) {
            addCriterion("XXZ010 <", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010LessThanOrEqualTo(String value) {
            addCriterion("XXZ010 <=", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010Like(String value) {
            addCriterion("XXZ010 like", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010NotLike(String value) {
            addCriterion("XXZ010 not like", value, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010In(List<String> values) {
            addCriterion("XXZ010 in", values, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010NotIn(List<String> values) {
            addCriterion("XXZ010 not in", values, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010Between(String value1, String value2) {
            addCriterion("XXZ010 between", value1, value2, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz010NotBetween(String value1, String value2) {
            addCriterion("XXZ010 not between", value1, value2, "xxz010");
            return (Criteria) this;
        }

        public Criteria andXxz011IsNull() {
            addCriterion("XXZ011 is null");
            return (Criteria) this;
        }

        public Criteria andXxz011IsNotNull() {
            addCriterion("XXZ011 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz011EqualTo(String value) {
            addCriterion("XXZ011 =", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011NotEqualTo(String value) {
            addCriterion("XXZ011 <>", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011GreaterThan(String value) {
            addCriterion("XXZ011 >", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ011 >=", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011LessThan(String value) {
            addCriterion("XXZ011 <", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011LessThanOrEqualTo(String value) {
            addCriterion("XXZ011 <=", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011Like(String value) {
            addCriterion("XXZ011 like", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011NotLike(String value) {
            addCriterion("XXZ011 not like", value, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011In(List<String> values) {
            addCriterion("XXZ011 in", values, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011NotIn(List<String> values) {
            addCriterion("XXZ011 not in", values, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011Between(String value1, String value2) {
            addCriterion("XXZ011 between", value1, value2, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz011NotBetween(String value1, String value2) {
            addCriterion("XXZ011 not between", value1, value2, "xxz011");
            return (Criteria) this;
        }

        public Criteria andXxz012IsNull() {
            addCriterion("XXZ012 is null");
            return (Criteria) this;
        }

        public Criteria andXxz012IsNotNull() {
            addCriterion("XXZ012 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz012EqualTo(String value) {
            addCriterion("XXZ012 =", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012NotEqualTo(String value) {
            addCriterion("XXZ012 <>", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012GreaterThan(String value) {
            addCriterion("XXZ012 >", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ012 >=", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012LessThan(String value) {
            addCriterion("XXZ012 <", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012LessThanOrEqualTo(String value) {
            addCriterion("XXZ012 <=", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012Like(String value) {
            addCriterion("XXZ012 like", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012NotLike(String value) {
            addCriterion("XXZ012 not like", value, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012In(List<String> values) {
            addCriterion("XXZ012 in", values, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012NotIn(List<String> values) {
            addCriterion("XXZ012 not in", values, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012Between(String value1, String value2) {
            addCriterion("XXZ012 between", value1, value2, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz012NotBetween(String value1, String value2) {
            addCriterion("XXZ012 not between", value1, value2, "xxz012");
            return (Criteria) this;
        }

        public Criteria andXxz013IsNull() {
            addCriterion("XXZ013 is null");
            return (Criteria) this;
        }

        public Criteria andXxz013IsNotNull() {
            addCriterion("XXZ013 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz013EqualTo(String value) {
            addCriterion("XXZ013 =", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013NotEqualTo(String value) {
            addCriterion("XXZ013 <>", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013GreaterThan(String value) {
            addCriterion("XXZ013 >", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ013 >=", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013LessThan(String value) {
            addCriterion("XXZ013 <", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013LessThanOrEqualTo(String value) {
            addCriterion("XXZ013 <=", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013Like(String value) {
            addCriterion("XXZ013 like", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013NotLike(String value) {
            addCriterion("XXZ013 not like", value, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013In(List<String> values) {
            addCriterion("XXZ013 in", values, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013NotIn(List<String> values) {
            addCriterion("XXZ013 not in", values, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013Between(String value1, String value2) {
            addCriterion("XXZ013 between", value1, value2, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz013NotBetween(String value1, String value2) {
            addCriterion("XXZ013 not between", value1, value2, "xxz013");
            return (Criteria) this;
        }

        public Criteria andXxz014IsNull() {
            addCriterion("XXZ014 is null");
            return (Criteria) this;
        }

        public Criteria andXxz014IsNotNull() {
            addCriterion("XXZ014 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz014EqualTo(Integer value) {
            addCriterion("XXZ014 =", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014NotEqualTo(Integer value) {
            addCriterion("XXZ014 <>", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014GreaterThan(Integer value) {
            addCriterion("XXZ014 >", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014GreaterThanOrEqualTo(Integer value) {
            addCriterion("XXZ014 >=", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014LessThan(Integer value) {
            addCriterion("XXZ014 <", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014LessThanOrEqualTo(Integer value) {
            addCriterion("XXZ014 <=", value, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014In(List<Integer> values) {
            addCriterion("XXZ014 in", values, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014NotIn(List<Integer> values) {
            addCriterion("XXZ014 not in", values, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014Between(Integer value1, Integer value2) {
            addCriterion("XXZ014 between", value1, value2, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz014NotBetween(Integer value1, Integer value2) {
            addCriterion("XXZ014 not between", value1, value2, "xxz014");
            return (Criteria) this;
        }

        public Criteria andXxz015IsNull() {
            addCriterion("XXZ015 is null");
            return (Criteria) this;
        }

        public Criteria andXxz015IsNotNull() {
            addCriterion("XXZ015 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz015EqualTo(String value) {
            addCriterion("XXZ015 =", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015NotEqualTo(String value) {
            addCriterion("XXZ015 <>", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015GreaterThan(String value) {
            addCriterion("XXZ015 >", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ015 >=", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015LessThan(String value) {
            addCriterion("XXZ015 <", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015LessThanOrEqualTo(String value) {
            addCriterion("XXZ015 <=", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015Like(String value) {
            addCriterion("XXZ015 like", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015NotLike(String value) {
            addCriterion("XXZ015 not like", value, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015In(List<String> values) {
            addCriterion("XXZ015 in", values, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015NotIn(List<String> values) {
            addCriterion("XXZ015 not in", values, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015Between(String value1, String value2) {
            addCriterion("XXZ015 between", value1, value2, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz015NotBetween(String value1, String value2) {
            addCriterion("XXZ015 not between", value1, value2, "xxz015");
            return (Criteria) this;
        }

        public Criteria andXxz016IsNull() {
            addCriterion("XXZ016 is null");
            return (Criteria) this;
        }

        public Criteria andXxz016IsNotNull() {
            addCriterion("XXZ016 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz016EqualTo(String value) {
            addCriterion("XXZ016 =", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016NotEqualTo(String value) {
            addCriterion("XXZ016 <>", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016GreaterThan(String value) {
            addCriterion("XXZ016 >", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ016 >=", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016LessThan(String value) {
            addCriterion("XXZ016 <", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016LessThanOrEqualTo(String value) {
            addCriterion("XXZ016 <=", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016Like(String value) {
            addCriterion("XXZ016 like", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016NotLike(String value) {
            addCriterion("XXZ016 not like", value, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016In(List<String> values) {
            addCriterion("XXZ016 in", values, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016NotIn(List<String> values) {
            addCriterion("XXZ016 not in", values, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016Between(String value1, String value2) {
            addCriterion("XXZ016 between", value1, value2, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz016NotBetween(String value1, String value2) {
            addCriterion("XXZ016 not between", value1, value2, "xxz016");
            return (Criteria) this;
        }

        public Criteria andXxz017IsNull() {
            addCriterion("XXZ017 is null");
            return (Criteria) this;
        }

        public Criteria andXxz017IsNotNull() {
            addCriterion("XXZ017 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz017EqualTo(String value) {
            addCriterion("XXZ017 =", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017NotEqualTo(String value) {
            addCriterion("XXZ017 <>", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017GreaterThan(String value) {
            addCriterion("XXZ017 >", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ017 >=", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017LessThan(String value) {
            addCriterion("XXZ017 <", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017LessThanOrEqualTo(String value) {
            addCriterion("XXZ017 <=", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017Like(String value) {
            addCriterion("XXZ017 like", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017NotLike(String value) {
            addCriterion("XXZ017 not like", value, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017In(List<String> values) {
            addCriterion("XXZ017 in", values, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017NotIn(List<String> values) {
            addCriterion("XXZ017 not in", values, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017Between(String value1, String value2) {
            addCriterion("XXZ017 between", value1, value2, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz017NotBetween(String value1, String value2) {
            addCriterion("XXZ017 not between", value1, value2, "xxz017");
            return (Criteria) this;
        }

        public Criteria andXxz018IsNull() {
            addCriterion("XXZ018 is null");
            return (Criteria) this;
        }

        public Criteria andXxz018IsNotNull() {
            addCriterion("XXZ018 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz018EqualTo(String value) {
            addCriterion("XXZ018 =", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018NotEqualTo(String value) {
            addCriterion("XXZ018 <>", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018GreaterThan(String value) {
            addCriterion("XXZ018 >", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ018 >=", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018LessThan(String value) {
            addCriterion("XXZ018 <", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018LessThanOrEqualTo(String value) {
            addCriterion("XXZ018 <=", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018Like(String value) {
            addCriterion("XXZ018 like", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018NotLike(String value) {
            addCriterion("XXZ018 not like", value, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018In(List<String> values) {
            addCriterion("XXZ018 in", values, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018NotIn(List<String> values) {
            addCriterion("XXZ018 not in", values, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018Between(String value1, String value2) {
            addCriterion("XXZ018 between", value1, value2, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz018NotBetween(String value1, String value2) {
            addCriterion("XXZ018 not between", value1, value2, "xxz018");
            return (Criteria) this;
        }

        public Criteria andXxz019IsNull() {
            addCriterion("XXZ019 is null");
            return (Criteria) this;
        }

        public Criteria andXxz019IsNotNull() {
            addCriterion("XXZ019 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz019EqualTo(Integer value) {
            addCriterion("XXZ019 =", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019NotEqualTo(Integer value) {
            addCriterion("XXZ019 <>", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019GreaterThan(Integer value) {
            addCriterion("XXZ019 >", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019GreaterThanOrEqualTo(Integer value) {
            addCriterion("XXZ019 >=", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019LessThan(Integer value) {
            addCriterion("XXZ019 <", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019LessThanOrEqualTo(Integer value) {
            addCriterion("XXZ019 <=", value, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019In(List<Integer> values) {
            addCriterion("XXZ019 in", values, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019NotIn(List<Integer> values) {
            addCriterion("XXZ019 not in", values, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019Between(Integer value1, Integer value2) {
            addCriterion("XXZ019 between", value1, value2, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz019NotBetween(Integer value1, Integer value2) {
            addCriterion("XXZ019 not between", value1, value2, "xxz019");
            return (Criteria) this;
        }

        public Criteria andXxz020IsNull() {
            addCriterion("XXZ020 is null");
            return (Criteria) this;
        }

        public Criteria andXxz020IsNotNull() {
            addCriterion("XXZ020 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz020EqualTo(String value) {
            addCriterion("XXZ020 =", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020NotEqualTo(String value) {
            addCriterion("XXZ020 <>", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020GreaterThan(String value) {
            addCriterion("XXZ020 >", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ020 >=", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020LessThan(String value) {
            addCriterion("XXZ020 <", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020LessThanOrEqualTo(String value) {
            addCriterion("XXZ020 <=", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020Like(String value) {
            addCriterion("XXZ020 like", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020NotLike(String value) {
            addCriterion("XXZ020 not like", value, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020In(List<String> values) {
            addCriterion("XXZ020 in", values, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020NotIn(List<String> values) {
            addCriterion("XXZ020 not in", values, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020Between(String value1, String value2) {
            addCriterion("XXZ020 between", value1, value2, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz020NotBetween(String value1, String value2) {
            addCriterion("XXZ020 not between", value1, value2, "xxz020");
            return (Criteria) this;
        }

        public Criteria andXxz021IsNull() {
            addCriterion("XXZ021 is null");
            return (Criteria) this;
        }

        public Criteria andXxz021IsNotNull() {
            addCriterion("XXZ021 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz021EqualTo(String value) {
            addCriterion("XXZ021 =", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021NotEqualTo(String value) {
            addCriterion("XXZ021 <>", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021GreaterThan(String value) {
            addCriterion("XXZ021 >", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ021 >=", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021LessThan(String value) {
            addCriterion("XXZ021 <", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021LessThanOrEqualTo(String value) {
            addCriterion("XXZ021 <=", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021Like(String value) {
            addCriterion("XXZ021 like", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021NotLike(String value) {
            addCriterion("XXZ021 not like", value, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021In(List<String> values) {
            addCriterion("XXZ021 in", values, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021NotIn(List<String> values) {
            addCriterion("XXZ021 not in", values, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021Between(String value1, String value2) {
            addCriterion("XXZ021 between", value1, value2, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz021NotBetween(String value1, String value2) {
            addCriterion("XXZ021 not between", value1, value2, "xxz021");
            return (Criteria) this;
        }

        public Criteria andXxz022IsNull() {
            addCriterion("XXZ022 is null");
            return (Criteria) this;
        }

        public Criteria andXxz022IsNotNull() {
            addCriterion("XXZ022 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz022EqualTo(String value) {
            addCriterion("XXZ022 =", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022NotEqualTo(String value) {
            addCriterion("XXZ022 <>", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022GreaterThan(String value) {
            addCriterion("XXZ022 >", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ022 >=", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022LessThan(String value) {
            addCriterion("XXZ022 <", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022LessThanOrEqualTo(String value) {
            addCriterion("XXZ022 <=", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022Like(String value) {
            addCriterion("XXZ022 like", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022NotLike(String value) {
            addCriterion("XXZ022 not like", value, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022In(List<String> values) {
            addCriterion("XXZ022 in", values, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022NotIn(List<String> values) {
            addCriterion("XXZ022 not in", values, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022Between(String value1, String value2) {
            addCriterion("XXZ022 between", value1, value2, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz022NotBetween(String value1, String value2) {
            addCriterion("XXZ022 not between", value1, value2, "xxz022");
            return (Criteria) this;
        }

        public Criteria andXxz025IsNull() {
            addCriterion("XXZ025 is null");
            return (Criteria) this;
        }

        public Criteria andXxz025IsNotNull() {
            addCriterion("XXZ025 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz025EqualTo(BigDecimal value) {
            addCriterion("XXZ025 =", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025NotEqualTo(BigDecimal value) {
            addCriterion("XXZ025 <>", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025GreaterThan(BigDecimal value) {
            addCriterion("XXZ025 >", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XXZ025 >=", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025LessThan(BigDecimal value) {
            addCriterion("XXZ025 <", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025LessThanOrEqualTo(BigDecimal value) {
            addCriterion("XXZ025 <=", value, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025In(List<BigDecimal> values) {
            addCriterion("XXZ025 in", values, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025NotIn(List<BigDecimal> values) {
            addCriterion("XXZ025 not in", values, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("XXZ025 between", value1, value2, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz025NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XXZ025 not between", value1, value2, "xxz025");
            return (Criteria) this;
        }

        public Criteria andXxz026IsNull() {
            addCriterion("XXZ026 is null");
            return (Criteria) this;
        }

        public Criteria andXxz026IsNotNull() {
            addCriterion("XXZ026 is not null");
            return (Criteria) this;
        }

        public Criteria andXxz026EqualTo(String value) {
            addCriterion("XXZ026 =", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026NotEqualTo(String value) {
            addCriterion("XXZ026 <>", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026GreaterThan(String value) {
            addCriterion("XXZ026 >", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026GreaterThanOrEqualTo(String value) {
            addCriterion("XXZ026 >=", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026LessThan(String value) {
            addCriterion("XXZ026 <", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026LessThanOrEqualTo(String value) {
            addCriterion("XXZ026 <=", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026Like(String value) {
            addCriterion("XXZ026 like", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026NotLike(String value) {
            addCriterion("XXZ026 not like", value, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026In(List<String> values) {
            addCriterion("XXZ026 in", values, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026NotIn(List<String> values) {
            addCriterion("XXZ026 not in", values, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026Between(String value1, String value2) {
            addCriterion("XXZ026 between", value1, value2, "xxz026");
            return (Criteria) this;
        }

        public Criteria andXxz026NotBetween(String value1, String value2) {
            addCriterion("XXZ026 not between", value1, value2, "xxz026");
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
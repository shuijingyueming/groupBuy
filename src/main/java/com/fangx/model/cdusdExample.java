package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdusdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusdExample() {
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

        public Criteria andUsd001IsNull() {
            addCriterion("USD001 is null");
            return (Criteria) this;
        }

        public Criteria andUsd001IsNotNull() {
            addCriterion("USD001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd001EqualTo(Integer value) {
            addCriterion("USD001 =", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001NotEqualTo(Integer value) {
            addCriterion("USD001 <>", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001GreaterThan(Integer value) {
            addCriterion("USD001 >", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USD001 >=", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001LessThan(Integer value) {
            addCriterion("USD001 <", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001LessThanOrEqualTo(Integer value) {
            addCriterion("USD001 <=", value, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001In(List<Integer> values) {
            addCriterion("USD001 in", values, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001NotIn(List<Integer> values) {
            addCriterion("USD001 not in", values, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001Between(Integer value1, Integer value2) {
            addCriterion("USD001 between", value1, value2, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd001NotBetween(Integer value1, Integer value2) {
            addCriterion("USD001 not between", value1, value2, "usd001");
            return (Criteria) this;
        }

        public Criteria andUsd002IsNull() {
            addCriterion("USD002 is null");
            return (Criteria) this;
        }

        public Criteria andUsd002IsNotNull() {
            addCriterion("USD002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd002EqualTo(String value) {
            addCriterion("USD002 =", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002NotEqualTo(String value) {
            addCriterion("USD002 <>", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002GreaterThan(String value) {
            addCriterion("USD002 >", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002GreaterThanOrEqualTo(String value) {
            addCriterion("USD002 >=", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002LessThan(String value) {
            addCriterion("USD002 <", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002LessThanOrEqualTo(String value) {
            addCriterion("USD002 <=", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002Like(String value) {
            addCriterion("USD002 like", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002NotLike(String value) {
            addCriterion("USD002 not like", value, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002In(List<String> values) {
            addCriterion("USD002 in", values, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002NotIn(List<String> values) {
            addCriterion("USD002 not in", values, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002Between(String value1, String value2) {
            addCriterion("USD002 between", value1, value2, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd002NotBetween(String value1, String value2) {
            addCriterion("USD002 not between", value1, value2, "usd002");
            return (Criteria) this;
        }

        public Criteria andUsd003IsNull() {
            addCriterion("USD003 is null");
            return (Criteria) this;
        }

        public Criteria andUsd003IsNotNull() {
            addCriterion("USD003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd003EqualTo(String value) {
            addCriterion("USD003 =", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003NotEqualTo(String value) {
            addCriterion("USD003 <>", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003GreaterThan(String value) {
            addCriterion("USD003 >", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003GreaterThanOrEqualTo(String value) {
            addCriterion("USD003 >=", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003LessThan(String value) {
            addCriterion("USD003 <", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003LessThanOrEqualTo(String value) {
            addCriterion("USD003 <=", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003Like(String value) {
            addCriterion("USD003 like", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003NotLike(String value) {
            addCriterion("USD003 not like", value, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003In(List<String> values) {
            addCriterion("USD003 in", values, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003NotIn(List<String> values) {
            addCriterion("USD003 not in", values, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003Between(String value1, String value2) {
            addCriterion("USD003 between", value1, value2, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd003NotBetween(String value1, String value2) {
            addCriterion("USD003 not between", value1, value2, "usd003");
            return (Criteria) this;
        }

        public Criteria andUsd004IsNull() {
            addCriterion("USD004 is null");
            return (Criteria) this;
        }

        public Criteria andUsd004IsNotNull() {
            addCriterion("USD004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd004EqualTo(String value) {
            addCriterion("USD004 =", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004NotEqualTo(String value) {
            addCriterion("USD004 <>", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004GreaterThan(String value) {
            addCriterion("USD004 >", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004GreaterThanOrEqualTo(String value) {
            addCriterion("USD004 >=", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004LessThan(String value) {
            addCriterion("USD004 <", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004LessThanOrEqualTo(String value) {
            addCriterion("USD004 <=", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004Like(String value) {
            addCriterion("USD004 like", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004NotLike(String value) {
            addCriterion("USD004 not like", value, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004In(List<String> values) {
            addCriterion("USD004 in", values, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004NotIn(List<String> values) {
            addCriterion("USD004 not in", values, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004Between(String value1, String value2) {
            addCriterion("USD004 between", value1, value2, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd004NotBetween(String value1, String value2) {
            addCriterion("USD004 not between", value1, value2, "usd004");
            return (Criteria) this;
        }

        public Criteria andUsd005IsNull() {
            addCriterion("USD005 is null");
            return (Criteria) this;
        }

        public Criteria andUsd005IsNotNull() {
            addCriterion("USD005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd005EqualTo(Integer value) {
            addCriterion("USD005 =", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005NotEqualTo(Integer value) {
            addCriterion("USD005 <>", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005GreaterThan(Integer value) {
            addCriterion("USD005 >", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005GreaterThanOrEqualTo(Integer value) {
            addCriterion("USD005 >=", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005LessThan(Integer value) {
            addCriterion("USD005 <", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005LessThanOrEqualTo(Integer value) {
            addCriterion("USD005 <=", value, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005In(List<Integer> values) {
            addCriterion("USD005 in", values, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005NotIn(List<Integer> values) {
            addCriterion("USD005 not in", values, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005Between(Integer value1, Integer value2) {
            addCriterion("USD005 between", value1, value2, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd005NotBetween(Integer value1, Integer value2) {
            addCriterion("USD005 not between", value1, value2, "usd005");
            return (Criteria) this;
        }

        public Criteria andUsd006IsNull() {
            addCriterion("USD006 is null");
            return (Criteria) this;
        }

        public Criteria andUsd006IsNotNull() {
            addCriterion("USD006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd006EqualTo(Float value) {
            addCriterion("USD006 =", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006NotEqualTo(Float value) {
            addCriterion("USD006 <>", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006GreaterThan(Float value) {
            addCriterion("USD006 >", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006GreaterThanOrEqualTo(Float value) {
            addCriterion("USD006 >=", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006LessThan(Float value) {
            addCriterion("USD006 <", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006LessThanOrEqualTo(Float value) {
            addCriterion("USD006 <=", value, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006In(List<Float> values) {
            addCriterion("USD006 in", values, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006NotIn(List<Float> values) {
            addCriterion("USD006 not in", values, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006Between(Float value1, Float value2) {
            addCriterion("USD006 between", value1, value2, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd006NotBetween(Float value1, Float value2) {
            addCriterion("USD006 not between", value1, value2, "usd006");
            return (Criteria) this;
        }

        public Criteria andUsd007IsNull() {
            addCriterion("USD007 is null");
            return (Criteria) this;
        }

        public Criteria andUsd007IsNotNull() {
            addCriterion("USD007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd007EqualTo(Float value) {
            addCriterion("USD007 =", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007NotEqualTo(Float value) {
            addCriterion("USD007 <>", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007GreaterThan(Float value) {
            addCriterion("USD007 >", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007GreaterThanOrEqualTo(Float value) {
            addCriterion("USD007 >=", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007LessThan(Float value) {
            addCriterion("USD007 <", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007LessThanOrEqualTo(Float value) {
            addCriterion("USD007 <=", value, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007In(List<Float> values) {
            addCriterion("USD007 in", values, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007NotIn(List<Float> values) {
            addCriterion("USD007 not in", values, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007Between(Float value1, Float value2) {
            addCriterion("USD007 between", value1, value2, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd007NotBetween(Float value1, Float value2) {
            addCriterion("USD007 not between", value1, value2, "usd007");
            return (Criteria) this;
        }

        public Criteria andUsd008IsNull() {
            addCriterion("USD008 is null");
            return (Criteria) this;
        }

        public Criteria andUsd008IsNotNull() {
            addCriterion("USD008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd008EqualTo(Integer value) {
            addCriterion("USD008 =", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008NotEqualTo(Integer value) {
            addCriterion("USD008 <>", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008GreaterThan(Integer value) {
            addCriterion("USD008 >", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008GreaterThanOrEqualTo(Integer value) {
            addCriterion("USD008 >=", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008LessThan(Integer value) {
            addCriterion("USD008 <", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008LessThanOrEqualTo(Integer value) {
            addCriterion("USD008 <=", value, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008In(List<Integer> values) {
            addCriterion("USD008 in", values, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008NotIn(List<Integer> values) {
            addCriterion("USD008 not in", values, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008Between(Integer value1, Integer value2) {
            addCriterion("USD008 between", value1, value2, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd008NotBetween(Integer value1, Integer value2) {
            addCriterion("USD008 not between", value1, value2, "usd008");
            return (Criteria) this;
        }

        public Criteria andUsd009IsNull() {
            addCriterion("USD009 is null");
            return (Criteria) this;
        }

        public Criteria andUsd009IsNotNull() {
            addCriterion("USD009 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd009EqualTo(Float value) {
            addCriterion("USD009 =", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009NotEqualTo(Float value) {
            addCriterion("USD009 <>", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009GreaterThan(Float value) {
            addCriterion("USD009 >", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009GreaterThanOrEqualTo(Float value) {
            addCriterion("USD009 >=", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009LessThan(Float value) {
            addCriterion("USD009 <", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009LessThanOrEqualTo(Float value) {
            addCriterion("USD009 <=", value, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009In(List<Float> values) {
            addCriterion("USD009 in", values, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009NotIn(List<Float> values) {
            addCriterion("USD009 not in", values, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009Between(Float value1, Float value2) {
            addCriterion("USD009 between", value1, value2, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd009NotBetween(Float value1, Float value2) {
            addCriterion("USD009 not between", value1, value2, "usd009");
            return (Criteria) this;
        }

        public Criteria andUsd010IsNull() {
            addCriterion("USD010 is null");
            return (Criteria) this;
        }

        public Criteria andUsd010IsNotNull() {
            addCriterion("USD010 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd010EqualTo(Date value) {
            addCriterion("USD010 =", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010NotEqualTo(Date value) {
            addCriterion("USD010 <>", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010GreaterThan(Date value) {
            addCriterion("USD010 >", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010GreaterThanOrEqualTo(Date value) {
            addCriterion("USD010 >=", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010LessThan(Date value) {
            addCriterion("USD010 <", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010LessThanOrEqualTo(Date value) {
            addCriterion("USD010 <=", value, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010In(List<Date> values) {
            addCriterion("USD010 in", values, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010NotIn(List<Date> values) {
            addCriterion("USD010 not in", values, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010Between(Date value1, Date value2) {
            addCriterion("USD010 between", value1, value2, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd010NotBetween(Date value1, Date value2) {
            addCriterion("USD010 not between", value1, value2, "usd010");
            return (Criteria) this;
        }

        public Criteria andUsd011IsNull() {
            addCriterion("USD011 is null");
            return (Criteria) this;
        }

        public Criteria andUsd011IsNotNull() {
            addCriterion("USD011 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd011EqualTo(String value) {
            addCriterion("USD011 =", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011NotEqualTo(String value) {
            addCriterion("USD011 <>", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011GreaterThan(String value) {
            addCriterion("USD011 >", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011GreaterThanOrEqualTo(String value) {
            addCriterion("USD011 >=", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011LessThan(String value) {
            addCriterion("USD011 <", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011LessThanOrEqualTo(String value) {
            addCriterion("USD011 <=", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011Like(String value) {
            addCriterion("USD011 like", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011NotLike(String value) {
            addCriterion("USD011 not like", value, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011In(List<String> values) {
            addCriterion("USD011 in", values, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011NotIn(List<String> values) {
            addCriterion("USD011 not in", values, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011Between(String value1, String value2) {
            addCriterion("USD011 between", value1, value2, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd011NotBetween(String value1, String value2) {
            addCriterion("USD011 not between", value1, value2, "usd011");
            return (Criteria) this;
        }

        public Criteria andUsd012IsNull() {
            addCriterion("USD012 is null");
            return (Criteria) this;
        }

        public Criteria andUsd012IsNotNull() {
            addCriterion("USD012 is not null");
            return (Criteria) this;
        }

        public Criteria andUsd012EqualTo(String value) {
            addCriterion("USD012 =", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012NotEqualTo(String value) {
            addCriterion("USD012 <>", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012GreaterThan(String value) {
            addCriterion("USD012 >", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012GreaterThanOrEqualTo(String value) {
            addCriterion("USD012 >=", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012LessThan(String value) {
            addCriterion("USD012 <", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012LessThanOrEqualTo(String value) {
            addCriterion("USD012 <=", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012Like(String value) {
            addCriterion("USD012 like", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012NotLike(String value) {
            addCriterion("USD012 not like", value, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012In(List<String> values) {
            addCriterion("USD012 in", values, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012NotIn(List<String> values) {
            addCriterion("USD012 not in", values, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012Between(String value1, String value2) {
            addCriterion("USD012 between", value1, value2, "usd012");
            return (Criteria) this;
        }

        public Criteria andUsd012NotBetween(String value1, String value2) {
            addCriterion("USD012 not between", value1, value2, "usd012");
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
package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cduscExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cduscExample() {
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

        public Criteria andUsc001IsNull() {
            addCriterion("USC001 is null");
            return (Criteria) this;
        }

        public Criteria andUsc001IsNotNull() {
            addCriterion("USC001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc001EqualTo(Integer value) {
            addCriterion("USC001 =", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001NotEqualTo(Integer value) {
            addCriterion("USC001 <>", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001GreaterThan(Integer value) {
            addCriterion("USC001 >", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USC001 >=", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001LessThan(Integer value) {
            addCriterion("USC001 <", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001LessThanOrEqualTo(Integer value) {
            addCriterion("USC001 <=", value, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001In(List<Integer> values) {
            addCriterion("USC001 in", values, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001NotIn(List<Integer> values) {
            addCriterion("USC001 not in", values, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001Between(Integer value1, Integer value2) {
            addCriterion("USC001 between", value1, value2, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc001NotBetween(Integer value1, Integer value2) {
            addCriterion("USC001 not between", value1, value2, "usc001");
            return (Criteria) this;
        }

        public Criteria andUsc002IsNull() {
            addCriterion("USC002 is null");
            return (Criteria) this;
        }

        public Criteria andUsc002IsNotNull() {
            addCriterion("USC002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc002EqualTo(String value) {
            addCriterion("USC002 =", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002NotEqualTo(String value) {
            addCriterion("USC002 <>", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002GreaterThan(String value) {
            addCriterion("USC002 >", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002GreaterThanOrEqualTo(String value) {
            addCriterion("USC002 >=", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002LessThan(String value) {
            addCriterion("USC002 <", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002LessThanOrEqualTo(String value) {
            addCriterion("USC002 <=", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002Like(String value) {
            addCriterion("USC002 like", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002NotLike(String value) {
            addCriterion("USC002 not like", value, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002In(List<String> values) {
            addCriterion("USC002 in", values, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002NotIn(List<String> values) {
            addCriterion("USC002 not in", values, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002Between(String value1, String value2) {
            addCriterion("USC002 between", value1, value2, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc002NotBetween(String value1, String value2) {
            addCriterion("USC002 not between", value1, value2, "usc002");
            return (Criteria) this;
        }

        public Criteria andUsc003IsNull() {
            addCriterion("USC003 is null");
            return (Criteria) this;
        }

        public Criteria andUsc003IsNotNull() {
            addCriterion("USC003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc003EqualTo(String value) {
            addCriterion("USC003 =", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003NotEqualTo(String value) {
            addCriterion("USC003 <>", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003GreaterThan(String value) {
            addCriterion("USC003 >", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003GreaterThanOrEqualTo(String value) {
            addCriterion("USC003 >=", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003LessThan(String value) {
            addCriterion("USC003 <", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003LessThanOrEqualTo(String value) {
            addCriterion("USC003 <=", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003Like(String value) {
            addCriterion("USC003 like", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003NotLike(String value) {
            addCriterion("USC003 not like", value, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003In(List<String> values) {
            addCriterion("USC003 in", values, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003NotIn(List<String> values) {
            addCriterion("USC003 not in", values, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003Between(String value1, String value2) {
            addCriterion("USC003 between", value1, value2, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc003NotBetween(String value1, String value2) {
            addCriterion("USC003 not between", value1, value2, "usc003");
            return (Criteria) this;
        }

        public Criteria andUsc004IsNull() {
            addCriterion("USC004 is null");
            return (Criteria) this;
        }

        public Criteria andUsc004IsNotNull() {
            addCriterion("USC004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc004EqualTo(String value) {
            addCriterion("USC004 =", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004NotEqualTo(String value) {
            addCriterion("USC004 <>", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004GreaterThan(String value) {
            addCriterion("USC004 >", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004GreaterThanOrEqualTo(String value) {
            addCriterion("USC004 >=", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004LessThan(String value) {
            addCriterion("USC004 <", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004LessThanOrEqualTo(String value) {
            addCriterion("USC004 <=", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004Like(String value) {
            addCriterion("USC004 like", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004NotLike(String value) {
            addCriterion("USC004 not like", value, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004In(List<String> values) {
            addCriterion("USC004 in", values, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004NotIn(List<String> values) {
            addCriterion("USC004 not in", values, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004Between(String value1, String value2) {
            addCriterion("USC004 between", value1, value2, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc004NotBetween(String value1, String value2) {
            addCriterion("USC004 not between", value1, value2, "usc004");
            return (Criteria) this;
        }

        public Criteria andUsc005IsNull() {
            addCriterion("USC005 is null");
            return (Criteria) this;
        }

        public Criteria andUsc005IsNotNull() {
            addCriterion("USC005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc005EqualTo(Integer value) {
            addCriterion("USC005 =", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005NotEqualTo(Integer value) {
            addCriterion("USC005 <>", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005GreaterThan(Integer value) {
            addCriterion("USC005 >", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005GreaterThanOrEqualTo(Integer value) {
            addCriterion("USC005 >=", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005LessThan(Integer value) {
            addCriterion("USC005 <", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005LessThanOrEqualTo(Integer value) {
            addCriterion("USC005 <=", value, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005In(List<Integer> values) {
            addCriterion("USC005 in", values, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005NotIn(List<Integer> values) {
            addCriterion("USC005 not in", values, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005Between(Integer value1, Integer value2) {
            addCriterion("USC005 between", value1, value2, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc005NotBetween(Integer value1, Integer value2) {
            addCriterion("USC005 not between", value1, value2, "usc005");
            return (Criteria) this;
        }

        public Criteria andUsc006IsNull() {
            addCriterion("USC006 is null");
            return (Criteria) this;
        }

        public Criteria andUsc006IsNotNull() {
            addCriterion("USC006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc006EqualTo(String value) {
            addCriterion("USC006 =", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006NotEqualTo(String value) {
            addCriterion("USC006 <>", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006GreaterThan(String value) {
            addCriterion("USC006 >", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006GreaterThanOrEqualTo(String value) {
            addCriterion("USC006 >=", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006LessThan(String value) {
            addCriterion("USC006 <", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006LessThanOrEqualTo(String value) {
            addCriterion("USC006 <=", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006Like(String value) {
            addCriterion("USC006 like", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006NotLike(String value) {
            addCriterion("USC006 not like", value, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006In(List<String> values) {
            addCriterion("USC006 in", values, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006NotIn(List<String> values) {
            addCriterion("USC006 not in", values, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006Between(String value1, String value2) {
            addCriterion("USC006 between", value1, value2, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc006NotBetween(String value1, String value2) {
            addCriterion("USC006 not between", value1, value2, "usc006");
            return (Criteria) this;
        }

        public Criteria andUsc007IsNull() {
            addCriterion("USC007 is null");
            return (Criteria) this;
        }

        public Criteria andUsc007IsNotNull() {
            addCriterion("USC007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc007EqualTo(String value) {
            addCriterion("USC007 =", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007NotEqualTo(String value) {
            addCriterion("USC007 <>", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007GreaterThan(String value) {
            addCriterion("USC007 >", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007GreaterThanOrEqualTo(String value) {
            addCriterion("USC007 >=", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007LessThan(String value) {
            addCriterion("USC007 <", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007LessThanOrEqualTo(String value) {
            addCriterion("USC007 <=", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007Like(String value) {
            addCriterion("USC007 like", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007NotLike(String value) {
            addCriterion("USC007 not like", value, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007In(List<String> values) {
            addCriterion("USC007 in", values, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007NotIn(List<String> values) {
            addCriterion("USC007 not in", values, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007Between(String value1, String value2) {
            addCriterion("USC007 between", value1, value2, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc007NotBetween(String value1, String value2) {
            addCriterion("USC007 not between", value1, value2, "usc007");
            return (Criteria) this;
        }

        public Criteria andUsc008IsNull() {
            addCriterion("USC008 is null");
            return (Criteria) this;
        }

        public Criteria andUsc008IsNotNull() {
            addCriterion("USC008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc008EqualTo(Float value) {
            addCriterion("USC008 =", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008NotEqualTo(Float value) {
            addCriterion("USC008 <>", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008GreaterThan(Float value) {
            addCriterion("USC008 >", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008GreaterThanOrEqualTo(Float value) {
            addCriterion("USC008 >=", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008LessThan(Float value) {
            addCriterion("USC008 <", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008LessThanOrEqualTo(Float value) {
            addCriterion("USC008 <=", value, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008In(List<Float> values) {
            addCriterion("USC008 in", values, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008NotIn(List<Float> values) {
            addCriterion("USC008 not in", values, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008Between(Float value1, Float value2) {
            addCriterion("USC008 between", value1, value2, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc008NotBetween(Float value1, Float value2) {
            addCriterion("USC008 not between", value1, value2, "usc008");
            return (Criteria) this;
        }

        public Criteria andUsc009IsNull() {
            addCriterion("USC009 is null");
            return (Criteria) this;
        }

        public Criteria andUsc009IsNotNull() {
            addCriterion("USC009 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc009EqualTo(Float value) {
            addCriterion("USC009 =", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009NotEqualTo(Float value) {
            addCriterion("USC009 <>", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009GreaterThan(Float value) {
            addCriterion("USC009 >", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009GreaterThanOrEqualTo(Float value) {
            addCriterion("USC009 >=", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009LessThan(Float value) {
            addCriterion("USC009 <", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009LessThanOrEqualTo(Float value) {
            addCriterion("USC009 <=", value, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009In(List<Float> values) {
            addCriterion("USC009 in", values, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009NotIn(List<Float> values) {
            addCriterion("USC009 not in", values, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009Between(Float value1, Float value2) {
            addCriterion("USC009 between", value1, value2, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc009NotBetween(Float value1, Float value2) {
            addCriterion("USC009 not between", value1, value2, "usc009");
            return (Criteria) this;
        }

        public Criteria andUsc010IsNull() {
            addCriterion("USC010 is null");
            return (Criteria) this;
        }

        public Criteria andUsc010IsNotNull() {
            addCriterion("USC010 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc010EqualTo(Float value) {
            addCriterion("USC010 =", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010NotEqualTo(Float value) {
            addCriterion("USC010 <>", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010GreaterThan(Float value) {
            addCriterion("USC010 >", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010GreaterThanOrEqualTo(Float value) {
            addCriterion("USC010 >=", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010LessThan(Float value) {
            addCriterion("USC010 <", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010LessThanOrEqualTo(Float value) {
            addCriterion("USC010 <=", value, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010In(List<Float> values) {
            addCriterion("USC010 in", values, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010NotIn(List<Float> values) {
            addCriterion("USC010 not in", values, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010Between(Float value1, Float value2) {
            addCriterion("USC010 between", value1, value2, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc010NotBetween(Float value1, Float value2) {
            addCriterion("USC010 not between", value1, value2, "usc010");
            return (Criteria) this;
        }

        public Criteria andUsc011IsNull() {
            addCriterion("USC011 is null");
            return (Criteria) this;
        }

        public Criteria andUsc011IsNotNull() {
            addCriterion("USC011 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc011EqualTo(Float value) {
            addCriterion("USC011 =", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011NotEqualTo(Float value) {
            addCriterion("USC011 <>", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011GreaterThan(Float value) {
            addCriterion("USC011 >", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011GreaterThanOrEqualTo(Float value) {
            addCriterion("USC011 >=", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011LessThan(Float value) {
            addCriterion("USC011 <", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011LessThanOrEqualTo(Float value) {
            addCriterion("USC011 <=", value, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011In(List<Float> values) {
            addCriterion("USC011 in", values, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011NotIn(List<Float> values) {
            addCriterion("USC011 not in", values, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011Between(Float value1, Float value2) {
            addCriterion("USC011 between", value1, value2, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc011NotBetween(Float value1, Float value2) {
            addCriterion("USC011 not between", value1, value2, "usc011");
            return (Criteria) this;
        }

        public Criteria andUsc012IsNull() {
            addCriterion("USC012 is null");
            return (Criteria) this;
        }

        public Criteria andUsc012IsNotNull() {
            addCriterion("USC012 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc012EqualTo(Float value) {
            addCriterion("USC012 =", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012NotEqualTo(Float value) {
            addCriterion("USC012 <>", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012GreaterThan(Float value) {
            addCriterion("USC012 >", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012GreaterThanOrEqualTo(Float value) {
            addCriterion("USC012 >=", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012LessThan(Float value) {
            addCriterion("USC012 <", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012LessThanOrEqualTo(Float value) {
            addCriterion("USC012 <=", value, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012In(List<Float> values) {
            addCriterion("USC012 in", values, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012NotIn(List<Float> values) {
            addCriterion("USC012 not in", values, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012Between(Float value1, Float value2) {
            addCriterion("USC012 between", value1, value2, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc012NotBetween(Float value1, Float value2) {
            addCriterion("USC012 not between", value1, value2, "usc012");
            return (Criteria) this;
        }

        public Criteria andUsc013IsNull() {
            addCriterion("USC013 is null");
            return (Criteria) this;
        }

        public Criteria andUsc013IsNotNull() {
            addCriterion("USC013 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc013EqualTo(Integer value) {
            addCriterion("USC013 =", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013NotEqualTo(Integer value) {
            addCriterion("USC013 <>", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013GreaterThan(Integer value) {
            addCriterion("USC013 >", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013GreaterThanOrEqualTo(Integer value) {
            addCriterion("USC013 >=", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013LessThan(Integer value) {
            addCriterion("USC013 <", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013LessThanOrEqualTo(Integer value) {
            addCriterion("USC013 <=", value, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013In(List<Integer> values) {
            addCriterion("USC013 in", values, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013NotIn(List<Integer> values) {
            addCriterion("USC013 not in", values, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013Between(Integer value1, Integer value2) {
            addCriterion("USC013 between", value1, value2, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc013NotBetween(Integer value1, Integer value2) {
            addCriterion("USC013 not between", value1, value2, "usc013");
            return (Criteria) this;
        }

        public Criteria andUsc014IsNull() {
            addCriterion("USC014 is null");
            return (Criteria) this;
        }

        public Criteria andUsc014IsNotNull() {
            addCriterion("USC014 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc014EqualTo(Date value) {
            addCriterion("USC014 =", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014NotEqualTo(Date value) {
            addCriterion("USC014 <>", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014GreaterThan(Date value) {
            addCriterion("USC014 >", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014GreaterThanOrEqualTo(Date value) {
            addCriterion("USC014 >=", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014LessThan(Date value) {
            addCriterion("USC014 <", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014LessThanOrEqualTo(Date value) {
            addCriterion("USC014 <=", value, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014In(List<Date> values) {
            addCriterion("USC014 in", values, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014NotIn(List<Date> values) {
            addCriterion("USC014 not in", values, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014Between(Date value1, Date value2) {
            addCriterion("USC014 between", value1, value2, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc014NotBetween(Date value1, Date value2) {
            addCriterion("USC014 not between", value1, value2, "usc014");
            return (Criteria) this;
        }

        public Criteria andUsc015IsNull() {
            addCriterion("USC015 is null");
            return (Criteria) this;
        }

        public Criteria andUsc015IsNotNull() {
            addCriterion("USC015 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc015EqualTo(String value) {
            addCriterion("USC015 =", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015NotEqualTo(String value) {
            addCriterion("USC015 <>", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015GreaterThan(String value) {
            addCriterion("USC015 >", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015GreaterThanOrEqualTo(String value) {
            addCriterion("USC015 >=", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015LessThan(String value) {
            addCriterion("USC015 <", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015LessThanOrEqualTo(String value) {
            addCriterion("USC015 <=", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015Like(String value) {
            addCriterion("USC015 like", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015NotLike(String value) {
            addCriterion("USC015 not like", value, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015In(List<String> values) {
            addCriterion("USC015 in", values, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015NotIn(List<String> values) {
            addCriterion("USC015 not in", values, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015Between(String value1, String value2) {
            addCriterion("USC015 between", value1, value2, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc015NotBetween(String value1, String value2) {
            addCriterion("USC015 not between", value1, value2, "usc015");
            return (Criteria) this;
        }

        public Criteria andUsc016IsNull() {
            addCriterion("USC016 is null");
            return (Criteria) this;
        }

        public Criteria andUsc016IsNotNull() {
            addCriterion("USC016 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc016EqualTo(String value) {
            addCriterion("USC016 =", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016NotEqualTo(String value) {
            addCriterion("USC016 <>", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016GreaterThan(String value) {
            addCriterion("USC016 >", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016GreaterThanOrEqualTo(String value) {
            addCriterion("USC016 >=", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016LessThan(String value) {
            addCriterion("USC016 <", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016LessThanOrEqualTo(String value) {
            addCriterion("USC016 <=", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016Like(String value) {
            addCriterion("USC016 like", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016NotLike(String value) {
            addCriterion("USC016 not like", value, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016In(List<String> values) {
            addCriterion("USC016 in", values, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016NotIn(List<String> values) {
            addCriterion("USC016 not in", values, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016Between(String value1, String value2) {
            addCriterion("USC016 between", value1, value2, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc016NotBetween(String value1, String value2) {
            addCriterion("USC016 not between", value1, value2, "usc016");
            return (Criteria) this;
        }

        public Criteria andUsc017IsNull() {
            addCriterion("USC017 is null");
            return (Criteria) this;
        }

        public Criteria andUsc017IsNotNull() {
            addCriterion("USC017 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc017EqualTo(String value) {
            addCriterion("USC017 =", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017NotEqualTo(String value) {
            addCriterion("USC017 <>", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017GreaterThan(String value) {
            addCriterion("USC017 >", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017GreaterThanOrEqualTo(String value) {
            addCriterion("USC017 >=", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017LessThan(String value) {
            addCriterion("USC017 <", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017LessThanOrEqualTo(String value) {
            addCriterion("USC017 <=", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017Like(String value) {
            addCriterion("USC017 like", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017NotLike(String value) {
            addCriterion("USC017 not like", value, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017In(List<String> values) {
            addCriterion("USC017 in", values, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017NotIn(List<String> values) {
            addCriterion("USC017 not in", values, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017Between(String value1, String value2) {
            addCriterion("USC017 between", value1, value2, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc017NotBetween(String value1, String value2) {
            addCriterion("USC017 not between", value1, value2, "usc017");
            return (Criteria) this;
        }

        public Criteria andUsc018IsNull() {
            addCriterion("USC018 is null");
            return (Criteria) this;
        }

        public Criteria andUsc018IsNotNull() {
            addCriterion("USC018 is not null");
            return (Criteria) this;
        }

        public Criteria andUsc018EqualTo(String value) {
            addCriterion("USC018 =", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018NotEqualTo(String value) {
            addCriterion("USC018 <>", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018GreaterThan(String value) {
            addCriterion("USC018 >", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018GreaterThanOrEqualTo(String value) {
            addCriterion("USC018 >=", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018LessThan(String value) {
            addCriterion("USC018 <", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018LessThanOrEqualTo(String value) {
            addCriterion("USC018 <=", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018Like(String value) {
            addCriterion("USC018 like", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018NotLike(String value) {
            addCriterion("USC018 not like", value, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018In(List<String> values) {
            addCriterion("USC018 in", values, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018NotIn(List<String> values) {
            addCriterion("USC018 not in", values, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018Between(String value1, String value2) {
            addCriterion("USC018 between", value1, value2, "usc018");
            return (Criteria) this;
        }

        public Criteria andUsc018NotBetween(String value1, String value2) {
            addCriterion("USC018 not between", value1, value2, "usc018");
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
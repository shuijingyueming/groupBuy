package com.fangx.model;

import java.util.ArrayList;
import java.util.List;

public class cdusfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdusfExample() {
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

        public Criteria andUsf001IsNull() {
            addCriterion("USF001 is null");
            return (Criteria) this;
        }

        public Criteria andUsf001IsNotNull() {
            addCriterion("USF001 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf001EqualTo(Integer value) {
            addCriterion("USF001 =", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001NotEqualTo(Integer value) {
            addCriterion("USF001 <>", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001GreaterThan(Integer value) {
            addCriterion("USF001 >", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF001 >=", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001LessThan(Integer value) {
            addCriterion("USF001 <", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001LessThanOrEqualTo(Integer value) {
            addCriterion("USF001 <=", value, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001In(List<Integer> values) {
            addCriterion("USF001 in", values, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001NotIn(List<Integer> values) {
            addCriterion("USF001 not in", values, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001Between(Integer value1, Integer value2) {
            addCriterion("USF001 between", value1, value2, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf001NotBetween(Integer value1, Integer value2) {
            addCriterion("USF001 not between", value1, value2, "usf001");
            return (Criteria) this;
        }

        public Criteria andUsf002IsNull() {
            addCriterion("USF002 is null");
            return (Criteria) this;
        }

        public Criteria andUsf002IsNotNull() {
            addCriterion("USF002 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf002EqualTo(String value) {
            addCriterion("USF002 =", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002NotEqualTo(String value) {
            addCriterion("USF002 <>", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002GreaterThan(String value) {
            addCriterion("USF002 >", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002GreaterThanOrEqualTo(String value) {
            addCriterion("USF002 >=", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002LessThan(String value) {
            addCriterion("USF002 <", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002LessThanOrEqualTo(String value) {
            addCriterion("USF002 <=", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002Like(String value) {
            addCriterion("USF002 like", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002NotLike(String value) {
            addCriterion("USF002 not like", value, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002In(List<String> values) {
            addCriterion("USF002 in", values, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002NotIn(List<String> values) {
            addCriterion("USF002 not in", values, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002Between(String value1, String value2) {
            addCriterion("USF002 between", value1, value2, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf002NotBetween(String value1, String value2) {
            addCriterion("USF002 not between", value1, value2, "usf002");
            return (Criteria) this;
        }

        public Criteria andUsf003IsNull() {
            addCriterion("USF003 is null");
            return (Criteria) this;
        }

        public Criteria andUsf003IsNotNull() {
            addCriterion("USF003 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf003EqualTo(String value) {
            addCriterion("USF003 =", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003NotEqualTo(String value) {
            addCriterion("USF003 <>", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003GreaterThan(String value) {
            addCriterion("USF003 >", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003GreaterThanOrEqualTo(String value) {
            addCriterion("USF003 >=", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003LessThan(String value) {
            addCriterion("USF003 <", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003LessThanOrEqualTo(String value) {
            addCriterion("USF003 <=", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003Like(String value) {
            addCriterion("USF003 like", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003NotLike(String value) {
            addCriterion("USF003 not like", value, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003In(List<String> values) {
            addCriterion("USF003 in", values, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003NotIn(List<String> values) {
            addCriterion("USF003 not in", values, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003Between(String value1, String value2) {
            addCriterion("USF003 between", value1, value2, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf003NotBetween(String value1, String value2) {
            addCriterion("USF003 not between", value1, value2, "usf003");
            return (Criteria) this;
        }

        public Criteria andUsf004IsNull() {
            addCriterion("USF004 is null");
            return (Criteria) this;
        }

        public Criteria andUsf004IsNotNull() {
            addCriterion("USF004 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf004EqualTo(Integer value) {
            addCriterion("USF004 =", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004NotEqualTo(Integer value) {
            addCriterion("USF004 <>", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004GreaterThan(Integer value) {
            addCriterion("USF004 >", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF004 >=", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004LessThan(Integer value) {
            addCriterion("USF004 <", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004LessThanOrEqualTo(Integer value) {
            addCriterion("USF004 <=", value, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004In(List<Integer> values) {
            addCriterion("USF004 in", values, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004NotIn(List<Integer> values) {
            addCriterion("USF004 not in", values, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004Between(Integer value1, Integer value2) {
            addCriterion("USF004 between", value1, value2, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf004NotBetween(Integer value1, Integer value2) {
            addCriterion("USF004 not between", value1, value2, "usf004");
            return (Criteria) this;
        }

        public Criteria andUsf005IsNull() {
            addCriterion("USF005 is null");
            return (Criteria) this;
        }

        public Criteria andUsf005IsNotNull() {
            addCriterion("USF005 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf005EqualTo(Float value) {
            addCriterion("USF005 =", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005NotEqualTo(Float value) {
            addCriterion("USF005 <>", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005GreaterThan(Float value) {
            addCriterion("USF005 >", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005GreaterThanOrEqualTo(Float value) {
            addCriterion("USF005 >=", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005LessThan(Float value) {
            addCriterion("USF005 <", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005LessThanOrEqualTo(Float value) {
            addCriterion("USF005 <=", value, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005In(List<Float> values) {
            addCriterion("USF005 in", values, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005NotIn(List<Float> values) {
            addCriterion("USF005 not in", values, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005Between(Float value1, Float value2) {
            addCriterion("USF005 between", value1, value2, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf005NotBetween(Float value1, Float value2) {
            addCriterion("USF005 not between", value1, value2, "usf005");
            return (Criteria) this;
        }

        public Criteria andUsf006IsNull() {
            addCriterion("USF006 is null");
            return (Criteria) this;
        }

        public Criteria andUsf006IsNotNull() {
            addCriterion("USF006 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf006EqualTo(Float value) {
            addCriterion("USF006 =", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006NotEqualTo(Float value) {
            addCriterion("USF006 <>", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006GreaterThan(Float value) {
            addCriterion("USF006 >", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006GreaterThanOrEqualTo(Float value) {
            addCriterion("USF006 >=", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006LessThan(Float value) {
            addCriterion("USF006 <", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006LessThanOrEqualTo(Float value) {
            addCriterion("USF006 <=", value, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006In(List<Float> values) {
            addCriterion("USF006 in", values, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006NotIn(List<Float> values) {
            addCriterion("USF006 not in", values, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006Between(Float value1, Float value2) {
            addCriterion("USF006 between", value1, value2, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf006NotBetween(Float value1, Float value2) {
            addCriterion("USF006 not between", value1, value2, "usf006");
            return (Criteria) this;
        }

        public Criteria andUsf007IsNull() {
            addCriterion("USF007 is null");
            return (Criteria) this;
        }

        public Criteria andUsf007IsNotNull() {
            addCriterion("USF007 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf007EqualTo(String value) {
            addCriterion("USF007 =", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007NotEqualTo(String value) {
            addCriterion("USF007 <>", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007GreaterThan(String value) {
            addCriterion("USF007 >", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007GreaterThanOrEqualTo(String value) {
            addCriterion("USF007 >=", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007LessThan(String value) {
            addCriterion("USF007 <", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007LessThanOrEqualTo(String value) {
            addCriterion("USF007 <=", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007Like(String value) {
            addCriterion("USF007 like", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007NotLike(String value) {
            addCriterion("USF007 not like", value, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007In(List<String> values) {
            addCriterion("USF007 in", values, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007NotIn(List<String> values) {
            addCriterion("USF007 not in", values, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007Between(String value1, String value2) {
            addCriterion("USF007 between", value1, value2, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf007NotBetween(String value1, String value2) {
            addCriterion("USF007 not between", value1, value2, "usf007");
            return (Criteria) this;
        }

        public Criteria andUsf008IsNull() {
            addCriterion("USF008 is null");
            return (Criteria) this;
        }

        public Criteria andUsf008IsNotNull() {
            addCriterion("USF008 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf008EqualTo(Integer value) {
            addCriterion("USF008 =", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008NotEqualTo(Integer value) {
            addCriterion("USF008 <>", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008GreaterThan(Integer value) {
            addCriterion("USF008 >", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF008 >=", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008LessThan(Integer value) {
            addCriterion("USF008 <", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008LessThanOrEqualTo(Integer value) {
            addCriterion("USF008 <=", value, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008In(List<Integer> values) {
            addCriterion("USF008 in", values, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008NotIn(List<Integer> values) {
            addCriterion("USF008 not in", values, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008Between(Integer value1, Integer value2) {
            addCriterion("USF008 between", value1, value2, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf008NotBetween(Integer value1, Integer value2) {
            addCriterion("USF008 not between", value1, value2, "usf008");
            return (Criteria) this;
        }

        public Criteria andUsf009IsNull() {
            addCriterion("USF009 is null");
            return (Criteria) this;
        }

        public Criteria andUsf009IsNotNull() {
            addCriterion("USF009 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf009EqualTo(Float value) {
            addCriterion("USF009 =", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009NotEqualTo(Float value) {
            addCriterion("USF009 <>", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009GreaterThan(Float value) {
            addCriterion("USF009 >", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009GreaterThanOrEqualTo(Float value) {
            addCriterion("USF009 >=", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009LessThan(Float value) {
            addCriterion("USF009 <", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009LessThanOrEqualTo(Float value) {
            addCriterion("USF009 <=", value, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009In(List<Float> values) {
            addCriterion("USF009 in", values, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009NotIn(List<Float> values) {
            addCriterion("USF009 not in", values, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009Between(Float value1, Float value2) {
            addCriterion("USF009 between", value1, value2, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf009NotBetween(Float value1, Float value2) {
            addCriterion("USF009 not between", value1, value2, "usf009");
            return (Criteria) this;
        }

        public Criteria andUsf010IsNull() {
            addCriterion("USF010 is null");
            return (Criteria) this;
        }

        public Criteria andUsf010IsNotNull() {
            addCriterion("USF010 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf010EqualTo(Integer value) {
            addCriterion("USF010 =", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010NotEqualTo(Integer value) {
            addCriterion("USF010 <>", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010GreaterThan(Integer value) {
            addCriterion("USF010 >", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF010 >=", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010LessThan(Integer value) {
            addCriterion("USF010 <", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010LessThanOrEqualTo(Integer value) {
            addCriterion("USF010 <=", value, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010In(List<Integer> values) {
            addCriterion("USF010 in", values, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010NotIn(List<Integer> values) {
            addCriterion("USF010 not in", values, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010Between(Integer value1, Integer value2) {
            addCriterion("USF010 between", value1, value2, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf010NotBetween(Integer value1, Integer value2) {
            addCriterion("USF010 not between", value1, value2, "usf010");
            return (Criteria) this;
        }

        public Criteria andUsf011IsNull() {
            addCriterion("USF011 is null");
            return (Criteria) this;
        }

        public Criteria andUsf011IsNotNull() {
            addCriterion("USF011 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf011EqualTo(Integer value) {
            addCriterion("USF011 =", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011NotEqualTo(Integer value) {
            addCriterion("USF011 <>", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011GreaterThan(Integer value) {
            addCriterion("USF011 >", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF011 >=", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011LessThan(Integer value) {
            addCriterion("USF011 <", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011LessThanOrEqualTo(Integer value) {
            addCriterion("USF011 <=", value, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011In(List<Integer> values) {
            addCriterion("USF011 in", values, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011NotIn(List<Integer> values) {
            addCriterion("USF011 not in", values, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011Between(Integer value1, Integer value2) {
            addCriterion("USF011 between", value1, value2, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf011NotBetween(Integer value1, Integer value2) {
            addCriterion("USF011 not between", value1, value2, "usf011");
            return (Criteria) this;
        }

        public Criteria andUsf012IsNull() {
            addCriterion("USF012 is null");
            return (Criteria) this;
        }

        public Criteria andUsf012IsNotNull() {
            addCriterion("USF012 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf012EqualTo(Integer value) {
            addCriterion("USF012 =", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012NotEqualTo(Integer value) {
            addCriterion("USF012 <>", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012GreaterThan(Integer value) {
            addCriterion("USF012 >", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF012 >=", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012LessThan(Integer value) {
            addCriterion("USF012 <", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012LessThanOrEqualTo(Integer value) {
            addCriterion("USF012 <=", value, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012In(List<Integer> values) {
            addCriterion("USF012 in", values, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012NotIn(List<Integer> values) {
            addCriterion("USF012 not in", values, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012Between(Integer value1, Integer value2) {
            addCriterion("USF012 between", value1, value2, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf012NotBetween(Integer value1, Integer value2) {
            addCriterion("USF012 not between", value1, value2, "usf012");
            return (Criteria) this;
        }

        public Criteria andUsf013IsNull() {
            addCriterion("USF013 is null");
            return (Criteria) this;
        }

        public Criteria andUsf013IsNotNull() {
            addCriterion("USF013 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf013EqualTo(String value) {
            addCriterion("USF013 =", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013NotEqualTo(String value) {
            addCriterion("USF013 <>", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013GreaterThan(String value) {
            addCriterion("USF013 >", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013GreaterThanOrEqualTo(String value) {
            addCriterion("USF013 >=", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013LessThan(String value) {
            addCriterion("USF013 <", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013LessThanOrEqualTo(String value) {
            addCriterion("USF013 <=", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013Like(String value) {
            addCriterion("USF013 like", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013NotLike(String value) {
            addCriterion("USF013 not like", value, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013In(List<String> values) {
            addCriterion("USF013 in", values, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013NotIn(List<String> values) {
            addCriterion("USF013 not in", values, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013Between(String value1, String value2) {
            addCriterion("USF013 between", value1, value2, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf013NotBetween(String value1, String value2) {
            addCriterion("USF013 not between", value1, value2, "usf013");
            return (Criteria) this;
        }

        public Criteria andUsf014IsNull() {
            addCriterion("USF014 is null");
            return (Criteria) this;
        }

        public Criteria andUsf014IsNotNull() {
            addCriterion("USF014 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf014EqualTo(Integer value) {
            addCriterion("USF014 =", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014NotEqualTo(Integer value) {
            addCriterion("USF014 <>", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014GreaterThan(Integer value) {
            addCriterion("USF014 >", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014GreaterThanOrEqualTo(Integer value) {
            addCriterion("USF014 >=", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014LessThan(Integer value) {
            addCriterion("USF014 <", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014LessThanOrEqualTo(Integer value) {
            addCriterion("USF014 <=", value, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014In(List<Integer> values) {
            addCriterion("USF014 in", values, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014NotIn(List<Integer> values) {
            addCriterion("USF014 not in", values, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014Between(Integer value1, Integer value2) {
            addCriterion("USF014 between", value1, value2, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf014NotBetween(Integer value1, Integer value2) {
            addCriterion("USF014 not between", value1, value2, "usf014");
            return (Criteria) this;
        }

        public Criteria andUsf015IsNull() {
            addCriterion("USF015 is null");
            return (Criteria) this;
        }

        public Criteria andUsf015IsNotNull() {
            addCriterion("USF015 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf015EqualTo(Float value) {
            addCriterion("USF015 =", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015NotEqualTo(Float value) {
            addCriterion("USF015 <>", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015GreaterThan(Float value) {
            addCriterion("USF015 >", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015GreaterThanOrEqualTo(Float value) {
            addCriterion("USF015 >=", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015LessThan(Float value) {
            addCriterion("USF015 <", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015LessThanOrEqualTo(Float value) {
            addCriterion("USF015 <=", value, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015In(List<Float> values) {
            addCriterion("USF015 in", values, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015NotIn(List<Float> values) {
            addCriterion("USF015 not in", values, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015Between(Float value1, Float value2) {
            addCriterion("USF015 between", value1, value2, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf015NotBetween(Float value1, Float value2) {
            addCriterion("USF015 not between", value1, value2, "usf015");
            return (Criteria) this;
        }

        public Criteria andUsf016IsNull() {
            addCriterion("USF016 is null");
            return (Criteria) this;
        }

        public Criteria andUsf016IsNotNull() {
            addCriterion("USF016 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf016EqualTo(String value) {
            addCriterion("USF016 =", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016NotEqualTo(String value) {
            addCriterion("USF016 <>", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016GreaterThan(String value) {
            addCriterion("USF016 >", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016GreaterThanOrEqualTo(String value) {
            addCriterion("USF016 >=", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016LessThan(String value) {
            addCriterion("USF016 <", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016LessThanOrEqualTo(String value) {
            addCriterion("USF016 <=", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016Like(String value) {
            addCriterion("USF016 like", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016NotLike(String value) {
            addCriterion("USF016 not like", value, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016In(List<String> values) {
            addCriterion("USF016 in", values, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016NotIn(List<String> values) {
            addCriterion("USF016 not in", values, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016Between(String value1, String value2) {
            addCriterion("USF016 between", value1, value2, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf016NotBetween(String value1, String value2) {
            addCriterion("USF016 not between", value1, value2, "usf016");
            return (Criteria) this;
        }

        public Criteria andUsf017IsNull() {
            addCriterion("USF017 is null");
            return (Criteria) this;
        }

        public Criteria andUsf017IsNotNull() {
            addCriterion("USF017 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf017EqualTo(String value) {
            addCriterion("USF017 =", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017NotEqualTo(String value) {
            addCriterion("USF017 <>", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017GreaterThan(String value) {
            addCriterion("USF017 >", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017GreaterThanOrEqualTo(String value) {
            addCriterion("USF017 >=", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017LessThan(String value) {
            addCriterion("USF017 <", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017LessThanOrEqualTo(String value) {
            addCriterion("USF017 <=", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017Like(String value) {
            addCriterion("USF017 like", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017NotLike(String value) {
            addCriterion("USF017 not like", value, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017In(List<String> values) {
            addCriterion("USF017 in", values, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017NotIn(List<String> values) {
            addCriterion("USF017 not in", values, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017Between(String value1, String value2) {
            addCriterion("USF017 between", value1, value2, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf017NotBetween(String value1, String value2) {
            addCriterion("USF017 not between", value1, value2, "usf017");
            return (Criteria) this;
        }

        public Criteria andUsf018IsNull() {
            addCriterion("USF018 is null");
            return (Criteria) this;
        }

        public Criteria andUsf018IsNotNull() {
            addCriterion("USF018 is not null");
            return (Criteria) this;
        }

        public Criteria andUsf018EqualTo(String value) {
            addCriterion("USF018 =", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018NotEqualTo(String value) {
            addCriterion("USF018 <>", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018GreaterThan(String value) {
            addCriterion("USF018 >", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018GreaterThanOrEqualTo(String value) {
            addCriterion("USF018 >=", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018LessThan(String value) {
            addCriterion("USF018 <", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018LessThanOrEqualTo(String value) {
            addCriterion("USF018 <=", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018Like(String value) {
            addCriterion("USF018 like", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018NotLike(String value) {
            addCriterion("USF018 not like", value, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018In(List<String> values) {
            addCriterion("USF018 in", values, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018NotIn(List<String> values) {
            addCriterion("USF018 not in", values, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018Between(String value1, String value2) {
            addCriterion("USF018 between", value1, value2, "usf018");
            return (Criteria) this;
        }

        public Criteria andUsf018NotBetween(String value1, String value2) {
            addCriterion("USF018 not between", value1, value2, "usf018");
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
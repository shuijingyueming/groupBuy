package com.fangx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class cdyhcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public cdyhcExample() {
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

        public Criteria andYhc001IsNull() {
            addCriterion("YHC001 is null");
            return (Criteria) this;
        }

        public Criteria andYhc001IsNotNull() {
            addCriterion("YHC001 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc001EqualTo(String value) {
            addCriterion("YHC001 =", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001NotEqualTo(String value) {
            addCriterion("YHC001 <>", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001GreaterThan(String value) {
            addCriterion("YHC001 >", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001GreaterThanOrEqualTo(String value) {
            addCriterion("YHC001 >=", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001LessThan(String value) {
            addCriterion("YHC001 <", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001LessThanOrEqualTo(String value) {
            addCriterion("YHC001 <=", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001Like(String value) {
            addCriterion("YHC001 like", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001NotLike(String value) {
            addCriterion("YHC001 not like", value, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001In(List<String> values) {
            addCriterion("YHC001 in", values, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001NotIn(List<String> values) {
            addCriterion("YHC001 not in", values, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001Between(String value1, String value2) {
            addCriterion("YHC001 between", value1, value2, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc001NotBetween(String value1, String value2) {
            addCriterion("YHC001 not between", value1, value2, "yhc001");
            return (Criteria) this;
        }

        public Criteria andYhc002IsNull() {
            addCriterion("YHC002 is null");
            return (Criteria) this;
        }

        public Criteria andYhc002IsNotNull() {
            addCriterion("YHC002 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc002EqualTo(Integer value) {
            addCriterion("YHC002 =", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002NotEqualTo(Integer value) {
            addCriterion("YHC002 <>", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002GreaterThan(Integer value) {
            addCriterion("YHC002 >", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHC002 >=", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002LessThan(Integer value) {
            addCriterion("YHC002 <", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002LessThanOrEqualTo(Integer value) {
            addCriterion("YHC002 <=", value, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002In(List<Integer> values) {
            addCriterion("YHC002 in", values, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002NotIn(List<Integer> values) {
            addCriterion("YHC002 not in", values, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002Between(Integer value1, Integer value2) {
            addCriterion("YHC002 between", value1, value2, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc002NotBetween(Integer value1, Integer value2) {
            addCriterion("YHC002 not between", value1, value2, "yhc002");
            return (Criteria) this;
        }

        public Criteria andYhc003IsNull() {
            addCriterion("YHC003 is null");
            return (Criteria) this;
        }

        public Criteria andYhc003IsNotNull() {
            addCriterion("YHC003 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc003EqualTo(Integer value) {
            addCriterion("YHC003 =", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003NotEqualTo(Integer value) {
            addCriterion("YHC003 <>", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003GreaterThan(Integer value) {
            addCriterion("YHC003 >", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003GreaterThanOrEqualTo(Integer value) {
            addCriterion("YHC003 >=", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003LessThan(Integer value) {
            addCriterion("YHC003 <", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003LessThanOrEqualTo(Integer value) {
            addCriterion("YHC003 <=", value, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003In(List<Integer> values) {
            addCriterion("YHC003 in", values, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003NotIn(List<Integer> values) {
            addCriterion("YHC003 not in", values, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003Between(Integer value1, Integer value2) {
            addCriterion("YHC003 between", value1, value2, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc003NotBetween(Integer value1, Integer value2) {
            addCriterion("YHC003 not between", value1, value2, "yhc003");
            return (Criteria) this;
        }

        public Criteria andYhc004IsNull() {
            addCriterion("YHC004 is null");
            return (Criteria) this;
        }

        public Criteria andYhc004IsNotNull() {
            addCriterion("YHC004 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc004EqualTo(Date value) {
            addCriterion("YHC004 =", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004NotEqualTo(Date value) {
            addCriterion("YHC004 <>", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004GreaterThan(Date value) {
            addCriterion("YHC004 >", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004GreaterThanOrEqualTo(Date value) {
            addCriterion("YHC004 >=", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004LessThan(Date value) {
            addCriterion("YHC004 <", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004LessThanOrEqualTo(Date value) {
            addCriterion("YHC004 <=", value, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004In(List<Date> values) {
            addCriterion("YHC004 in", values, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004NotIn(List<Date> values) {
            addCriterion("YHC004 not in", values, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004Between(Date value1, Date value2) {
            addCriterion("YHC004 between", value1, value2, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc004NotBetween(Date value1, Date value2) {
            addCriterion("YHC004 not between", value1, value2, "yhc004");
            return (Criteria) this;
        }

        public Criteria andYhc005IsNull() {
            addCriterion("YHC005 is null");
            return (Criteria) this;
        }

        public Criteria andYhc005IsNotNull() {
            addCriterion("YHC005 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc005EqualTo(String value) {
            addCriterion("YHC005 =", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005NotEqualTo(String value) {
            addCriterion("YHC005 <>", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005GreaterThan(String value) {
            addCriterion("YHC005 >", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005GreaterThanOrEqualTo(String value) {
            addCriterion("YHC005 >=", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005LessThan(String value) {
            addCriterion("YHC005 <", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005LessThanOrEqualTo(String value) {
            addCriterion("YHC005 <=", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005Like(String value) {
            addCriterion("YHC005 like", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005NotLike(String value) {
            addCriterion("YHC005 not like", value, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005In(List<String> values) {
            addCriterion("YHC005 in", values, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005NotIn(List<String> values) {
            addCriterion("YHC005 not in", values, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005Between(String value1, String value2) {
            addCriterion("YHC005 between", value1, value2, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc005NotBetween(String value1, String value2) {
            addCriterion("YHC005 not between", value1, value2, "yhc005");
            return (Criteria) this;
        }

        public Criteria andYhc006IsNull() {
            addCriterion("YHC006 is null");
            return (Criteria) this;
        }

        public Criteria andYhc006IsNotNull() {
            addCriterion("YHC006 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc006EqualTo(String value) {
            addCriterion("YHC006 =", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006NotEqualTo(String value) {
            addCriterion("YHC006 <>", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006GreaterThan(String value) {
            addCriterion("YHC006 >", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006GreaterThanOrEqualTo(String value) {
            addCriterion("YHC006 >=", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006LessThan(String value) {
            addCriterion("YHC006 <", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006LessThanOrEqualTo(String value) {
            addCriterion("YHC006 <=", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006Like(String value) {
            addCriterion("YHC006 like", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006NotLike(String value) {
            addCriterion("YHC006 not like", value, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006In(List<String> values) {
            addCriterion("YHC006 in", values, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006NotIn(List<String> values) {
            addCriterion("YHC006 not in", values, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006Between(String value1, String value2) {
            addCriterion("YHC006 between", value1, value2, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc006NotBetween(String value1, String value2) {
            addCriterion("YHC006 not between", value1, value2, "yhc006");
            return (Criteria) this;
        }

        public Criteria andYhc007IsNull() {
            addCriterion("YHC007 is null");
            return (Criteria) this;
        }

        public Criteria andYhc007IsNotNull() {
            addCriterion("YHC007 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc007EqualTo(Float value) {
            addCriterion("YHC007 =", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007NotEqualTo(Float value) {
            addCriterion("YHC007 <>", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007GreaterThan(Float value) {
            addCriterion("YHC007 >", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007GreaterThanOrEqualTo(Float value) {
            addCriterion("YHC007 >=", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007LessThan(Float value) {
            addCriterion("YHC007 <", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007LessThanOrEqualTo(Float value) {
            addCriterion("YHC007 <=", value, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007In(List<Float> values) {
            addCriterion("YHC007 in", values, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007NotIn(List<Float> values) {
            addCriterion("YHC007 not in", values, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007Between(Float value1, Float value2) {
            addCriterion("YHC007 between", value1, value2, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc007NotBetween(Float value1, Float value2) {
            addCriterion("YHC007 not between", value1, value2, "yhc007");
            return (Criteria) this;
        }

        public Criteria andYhc008IsNull() {
            addCriterion("YHC008 is null");
            return (Criteria) this;
        }

        public Criteria andYhc008IsNotNull() {
            addCriterion("YHC008 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc008EqualTo(Date value) {
            addCriterion("YHC008 =", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008NotEqualTo(Date value) {
            addCriterion("YHC008 <>", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008GreaterThan(Date value) {
            addCriterion("YHC008 >", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008GreaterThanOrEqualTo(Date value) {
            addCriterion("YHC008 >=", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008LessThan(Date value) {
            addCriterion("YHC008 <", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008LessThanOrEqualTo(Date value) {
            addCriterion("YHC008 <=", value, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008In(List<Date> values) {
            addCriterion("YHC008 in", values, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008NotIn(List<Date> values) {
            addCriterion("YHC008 not in", values, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008Between(Date value1, Date value2) {
            addCriterion("YHC008 between", value1, value2, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc008NotBetween(Date value1, Date value2) {
            addCriterion("YHC008 not between", value1, value2, "yhc008");
            return (Criteria) this;
        }

        public Criteria andYhc009IsNull() {
            addCriterion("YHC009 is null");
            return (Criteria) this;
        }

        public Criteria andYhc009IsNotNull() {
            addCriterion("YHC009 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc009EqualTo(String value) {
            addCriterion("YHC009 =", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009NotEqualTo(String value) {
            addCriterion("YHC009 <>", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009GreaterThan(String value) {
            addCriterion("YHC009 >", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009GreaterThanOrEqualTo(String value) {
            addCriterion("YHC009 >=", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009LessThan(String value) {
            addCriterion("YHC009 <", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009LessThanOrEqualTo(String value) {
            addCriterion("YHC009 <=", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009Like(String value) {
            addCriterion("YHC009 like", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009NotLike(String value) {
            addCriterion("YHC009 not like", value, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009In(List<String> values) {
            addCriterion("YHC009 in", values, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009NotIn(List<String> values) {
            addCriterion("YHC009 not in", values, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009Between(String value1, String value2) {
            addCriterion("YHC009 between", value1, value2, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc009NotBetween(String value1, String value2) {
            addCriterion("YHC009 not between", value1, value2, "yhc009");
            return (Criteria) this;
        }

        public Criteria andYhc010IsNull() {
            addCriterion("YHC010 is null");
            return (Criteria) this;
        }

        public Criteria andYhc010IsNotNull() {
            addCriterion("YHC010 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc010EqualTo(Float value) {
            addCriterion("YHC010 =", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010NotEqualTo(Float value) {
            addCriterion("YHC010 <>", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010GreaterThan(Float value) {
            addCriterion("YHC010 >", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010GreaterThanOrEqualTo(Float value) {
            addCriterion("YHC010 >=", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010LessThan(Float value) {
            addCriterion("YHC010 <", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010LessThanOrEqualTo(Float value) {
            addCriterion("YHC010 <=", value, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010In(List<Float> values) {
            addCriterion("YHC010 in", values, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010NotIn(List<Float> values) {
            addCriterion("YHC010 not in", values, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010Between(Float value1, Float value2) {
            addCriterion("YHC010 between", value1, value2, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc010NotBetween(Float value1, Float value2) {
            addCriterion("YHC010 not between", value1, value2, "yhc010");
            return (Criteria) this;
        }

        public Criteria andYhc011IsNull() {
            addCriterion("YHC011 is null");
            return (Criteria) this;
        }

        public Criteria andYhc011IsNotNull() {
            addCriterion("YHC011 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc011EqualTo(String value) {
            addCriterion("YHC011 =", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011NotEqualTo(String value) {
            addCriterion("YHC011 <>", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011GreaterThan(String value) {
            addCriterion("YHC011 >", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011GreaterThanOrEqualTo(String value) {
            addCriterion("YHC011 >=", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011LessThan(String value) {
            addCriterion("YHC011 <", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011LessThanOrEqualTo(String value) {
            addCriterion("YHC011 <=", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011Like(String value) {
            addCriterion("YHC011 like", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011NotLike(String value) {
            addCriterion("YHC011 not like", value, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011In(List<String> values) {
            addCriterion("YHC011 in", values, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011NotIn(List<String> values) {
            addCriterion("YHC011 not in", values, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011Between(String value1, String value2) {
            addCriterion("YHC011 between", value1, value2, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc011NotBetween(String value1, String value2) {
            addCriterion("YHC011 not between", value1, value2, "yhc011");
            return (Criteria) this;
        }

        public Criteria andYhc012IsNull() {
            addCriterion("YHC012 is null");
            return (Criteria) this;
        }

        public Criteria andYhc012IsNotNull() {
            addCriterion("YHC012 is not null");
            return (Criteria) this;
        }

        public Criteria andYhc012EqualTo(String value) {
            addCriterion("YHC012 =", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012NotEqualTo(String value) {
            addCriterion("YHC012 <>", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012GreaterThan(String value) {
            addCriterion("YHC012 >", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012GreaterThanOrEqualTo(String value) {
            addCriterion("YHC012 >=", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012LessThan(String value) {
            addCriterion("YHC012 <", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012LessThanOrEqualTo(String value) {
            addCriterion("YHC012 <=", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012Like(String value) {
            addCriterion("YHC012 like", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012NotLike(String value) {
            addCriterion("YHC012 not like", value, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012In(List<String> values) {
            addCriterion("YHC012 in", values, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012NotIn(List<String> values) {
            addCriterion("YHC012 not in", values, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012Between(String value1, String value2) {
            addCriterion("YHC012 between", value1, value2, "yhc012");
            return (Criteria) this;
        }

        public Criteria andYhc012NotBetween(String value1, String value2) {
            addCriterion("YHC012 not between", value1, value2, "yhc012");
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
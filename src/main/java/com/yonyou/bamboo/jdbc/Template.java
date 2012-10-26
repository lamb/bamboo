package com.yonyou.bamboo.jdbc;

import java.beans.PropertyDescriptor;
import javax.sql.DataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class Template extends JdbcTemplate {

    public static final String SPACE = " ";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String INSERT = "insert";
    public static final String VALUES = "values";
    public static final String UNDERLINE = "_";

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public Template() {
        super();
    }

    public Template(DataSource dataSource) {
        super(dataSource);
        initNamedJdbcTemplate();
    }

    public Template(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
        initNamedJdbcTemplate();
    }

    public void initNamedJdbcTemplate() {
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(this);
    }

    public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        return namedJdbcTemplate.update(sql, paramSource, generatedKeyHolder);
    }

    public <T> int insert(T t) {
        StringBuffer top = new StringBuffer();
        StringBuffer bot = new StringBuffer();
        top.append(INSERT).append(SPACE).append(t.getClass().getSimpleName().toLowerCase()).append(SPACE).append(LEFT_BRACKET);
        bot.append(VALUES).append(LEFT_BRACKET);
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(t.getClass());
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(t);
        for (int i = 0; i < pds.length; i++) {
            PropertyDescriptor pd = pds[i];
            if (pd.getWriteMethod() != null && beanWrapper.getPropertyValue(pd.getName()) != null) {
                top.append(underscoreName(pd.getName()));
                bot.append(COLON).append(pd.getName());
                if (i < pds.length - 1) {
                    bot.append(COMMA).append(SPACE);
                    top.append(COMMA).append(SPACE);
                }
            }
        }
        top.append(RIGHT_BRACKET);
        bot.append(RIGHT_BRACKET);
        String sql = top.append(bot).toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.update(sql, new BeanPropertySqlParameterSource(t), keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * Convert a name in camelCase to an underscored name in lower case. Any upper case letters are converted to lower case with a preceding underscore.
     * 
     * @param name
     *            the string containing original name
     * @return the converted name
     */
    private String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            result.append(name.substring(0, 1).toLowerCase());
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                if (s.equals(s.toUpperCase())) {
                    result.append(UNDERLINE);
                    result.append(s.toLowerCase());
                } else {
                    result.append(s);
                }
            }
        }
        return result.toString();
    }
}

package com.yonyou.bamboo.jdbc;

import java.beans.PropertyDescriptor;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

public class Template extends JdbcTemplate {

    private static Logger log = Logger.getLogger(Template.class);
    public static final String SPACE = " ";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String COLON = ":";
    public static final String COMMA = ",";

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

    public <T> int insert(T model) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        StringBuffer top = new StringBuffer();
        StringBuffer bot = new StringBuffer();
        top.append("insert ").append(model.getClass().getSimpleName().toLowerCase()).append(SPACE).append(LEFT_BRACKET);
        bot.append("values(");
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(model.getClass());
        for (int i = 0; i < pds.length; i++) {
            PropertyDescriptor pd = pds[i];
            if (pd.getWriteMethod() != null) {
                bot.append(COLON).append(pd.getName());
                if (i < pds.length - 1) {
                    bot.append(COMMA).append(SPACE);
                }
            }
        }
        top.append(RIGHT_BRACKET);
        bot.append(RIGHT_BRACKET);
        log.debug(top.toString() + bot.toString());
        return 0;
    }
}

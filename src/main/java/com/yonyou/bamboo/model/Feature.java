package com.yonyou.bamboo.model;

import java.util.Date;

public class Feature {

    Integer id;
    Integer versionId;
    Integer moduleId;
    String checkpoInteger;
    String reason;
    Integer type;
    Integer hide;
    Integer alpha;
    Integer alphaBy;
    Date alphaDate;
    Integer betaBy;
    Integer beta;
    Date betaDate;
    Integer uatBy;
    Integer uat;
    Date uatDate;
    String dmlUpgrade;
    String dmlRollback;
    String ddlUpgrade;
    String ddlRollback;
    Integer createBy;
    Date createDate;
    Integer modifyBy;
    Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getCheckpoInteger() {
        return checkpoInteger;
    }

    public void setCheckpoInteger(String checkpoInteger) {
        this.checkpoInteger = checkpoInteger;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAlpha() {
        return alpha;
    }

    public void setAlpha(Integer alpha) {
        this.alpha = alpha;
    }

    public Date getAlphaDate() {
        return alphaDate;
    }

    public void setAlphaDate(Date alphaDate) {
        this.alphaDate = alphaDate;
    }

    public Integer getBeta() {
        return beta;
    }

    public void setBeta(Integer beta) {
        this.beta = beta;
    }

    public Date getBetaDate() {
        return betaDate;
    }

    public void setBetaDate(Date betaDate) {
        this.betaDate = betaDate;
    }

    public Integer getUat() {
        return uat;
    }

    public void setUat(Integer uat) {
        this.uat = uat;
    }

    public Date getUatDate() {
        return uatDate;
    }

    public void setUatDate(Date uatDate) {
        this.uatDate = uatDate;
    }

    public String getDmlUpgrade() {
        return dmlUpgrade;
    }

    public void setDmlUpgrade(String dmlUpgrade) {
        this.dmlUpgrade = dmlUpgrade;
    }

    public String getDmlRollback() {
        return dmlRollback;
    }

    public void setDmlRollback(String dmlRollback) {
        this.dmlRollback = dmlRollback;
    }

    public String getDdlUpgrade() {
        return ddlUpgrade;
    }

    public void setDdlUpgrade(String ddlUpgrade) {
        this.ddlUpgrade = ddlUpgrade;
    }

    public String getDdlRollback() {
        return ddlRollback;
    }

    public void setDdlRollback(String ddlRollback) {
        this.ddlRollback = ddlRollback;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

}

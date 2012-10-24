package com.yonyou.bamboo.model;

import java.util.Date;

public class Feature {

    int id;
    int versionId;
    int moduleId;
    String checkpoint;
    String reason;
    int type;
    int alpha;
    Date alphaDate;
    int beta;
    Date betaDate;
    int uat;
    Date uatDate;
    String dmlUpgrade;
    String dmlRollback;
    String ddlUpgrade;
    String ddlRollback;
    int createBy;
    Date createDate;
    int modifyBy;
    Date modifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public Date getAlphaDate() {
        return alphaDate;
    }

    public void setAlphaDate(Date alphaDate) {
        this.alphaDate = alphaDate;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public Date getBetaDate() {
        return betaDate;
    }

    public void setBetaDate(Date betaDate) {
        this.betaDate = betaDate;
    }

    public int getUat() {
        return uat;
    }

    public void setUat(int uat) {
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

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

}

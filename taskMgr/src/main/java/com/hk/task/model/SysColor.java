package com.hk.task.model;

import javax.persistence.*;

@Table(name = "sys_color")
public class SysColor {
    @Id
    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "color_desc")
    private String colorDesc;

    @Column(name = "color_value")
    private String colorValue;

    /**
     * @return color_id
     */
    public Integer getColorId() {
        return colorId;
    }

    /**
     * @param colorId
     */
    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    /**
     * @return color_desc
     */
    public String getColorDesc() {
        return colorDesc;
    }

    /**
     * @param colorDesc
     */
    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }

    /**
     * @return color_value
     */
    public String getColorValue() {
        return colorValue;
    }

    /**
     * @param colorValue
     */
    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }
}
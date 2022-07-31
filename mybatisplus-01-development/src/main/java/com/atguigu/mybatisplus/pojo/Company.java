package com.atguigu.mybatisplus.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Repository;

@TableName("com")
@Repository
@ApiModel(description = "公司对象")
public class Company {
    @TableId(value = "`Rank`",type= IdType.AUTO)
    private  Integer Rank;

    @ApiModelProperty(name = "公司名称")
    private  String Name;

    private  String Symbol;

    private  Double marketcap;

    private  Double price;

    private  String country;

    @Override
    public String toString() {
        return "Company{" +
                "Rank=" + Rank +
                ", Name='" + Name + '\'' +
                ", Symbol='" + Symbol + '\'' +
                ", marketcap=" + marketcap +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }

    /**
     * 如果设置了有参构造函数，无参构造函数必须显式显示，否则一些框架默认调用无参构造函数则会报错
     */
    public Company() {
    }

    public Company(Integer rank, String name, String symbol, Double marketcap, Double price, String country) {
        this.Rank = rank;
        this.Name = name;
        this.Symbol = symbol;
        this.marketcap = marketcap;
        this.price = price;
        this.country = country;
    }

    public Integer getRank() {
        return Rank;
    }

    public void setRank(Integer rank) {
        Rank = rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public Double getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(Double marketcap) {
        this.marketcap = marketcap;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
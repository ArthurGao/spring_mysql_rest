package com.teletrac.repository;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {
	private int id;
	
	@JsonProperty("exchange_id")
	private String exchangeId;
	private String symbol;
	@JsonProperty("base_asset")
	private String baseAsset;
	@JsonProperty("quote_asset")
	private String quoteAsset;
	@JsonProperty("price_unconverted")
	private BigDecimal priceUnconverted;
	private BigDecimal price;
	@JsonProperty("change_24h")
	private BigDecimal change24h;
	private BigDecimal spread;
	@JsonProperty("volume_24h")
	private BigDecimal volume24h;
	private String status;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("updated_at")
	private Date updatedAt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuoteAsset() {
		return quoteAsset;
	}

	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getBaseAsset() {
		return baseAsset;
	}

	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}

	public BigDecimal getPriceUnconverted() {
		return priceUnconverted;
	}

	public void setPriceUnconverted(BigDecimal priceUnconverted) {
		this.priceUnconverted = priceUnconverted;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getChange24h() {
		return change24h;
	}

	public void setChange24h(BigDecimal change24h) {
		this.change24h = change24h;
	}

	public BigDecimal getSpread() {
		return spread;
	}

	public void setSpread(BigDecimal spread) {
		this.spread = spread;
	}

	public BigDecimal getVolume24h() {
		return volume24h;
	}

	public void setVolume24h(BigDecimal volume24h) {
		this.volume24h = volume24h;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

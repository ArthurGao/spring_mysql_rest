package com.teletrac.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketList {
	private List<Market> markets;

	public MarketList() {
		markets = new ArrayList<Market>();
	}

	public List<Market> getMarkets() {
		List<Market> result = markets.stream().filter(e -> e.getExchangeId().equals("BINANCE"))
				.filter(e -> e.getQuoteAsset().equals("USDT"))
				.sorted((Market m1, Market m2) -> m1.getPrice().compareTo(m2.getPrice())).collect(Collectors.toList());
		for (int i = 0; i < result.size(); i++) {
			result.get(i).setId(i);
		}

		return result;
	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}

}

package com.github.adminfaces.starter.util;



import org.primefaces.model.chart.LineChartModel;

public class ModelStatistic {

	private LineChartModel lineModelVolume;
	private LineChartModel lineModelPrice;
	private String priceTitle;
	private String volumeTitle;
	
	
	public String getPriceTitle() {
		return priceTitle;
	}
	public void setPriceTitle(String priceTitle) {
		this.priceTitle = priceTitle;
	}
	public String getVolumeTitle() {
		return volumeTitle;
	}
	public void setVolumeTitle(String volumeTitle) {
		this.volumeTitle = volumeTitle;
	}
	
	public LineChartModel getLineModelVolume() {
		return lineModelVolume;
	}
	public void setLineModelVolume(LineChartModel lineModelVolume) {
		this.lineModelVolume = lineModelVolume;
	}
	public LineChartModel getLineModelPrice() {
		return lineModelPrice;
	}
	public void setLineModelPrice(LineChartModel lineModelPrice) {
		this.lineModelPrice = lineModelPrice;
	}
	
	
	
	
}

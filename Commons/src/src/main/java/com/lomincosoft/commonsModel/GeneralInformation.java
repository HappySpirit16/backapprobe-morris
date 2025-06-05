package com.lomincosoft.commonsModel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "tableGeneralInformation")
public class GeneralInformation {

		@DynamoDBHashKey
		private int id;
		@DynamoDBAttribute
		private double yearRate;
		@DynamoDBAttribute
		private double montlyRate;
		@DynamoDBAttribute
		private double coverageFGAPercentage;
		@DynamoDBAttribute
		private double coveragePlatformPercentage;
		@DynamoDBAttribute
		private double platform;
		@DynamoDBAttribute
		private double iva;
		@DynamoDBAttribute
		private double periodPlatform;
		@DynamoDBAttribute
		private double maxSimpleDaysPastDue; 
		@DynamoDBAttribute
		private double minUtilizationValue; 
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getYearRate() {
			return yearRate;
		}
		public void setYearRate(double yearRate) {
			this.yearRate = yearRate;
		}
		public double getMontlyRate() {
			return montlyRate;
		}
		public void setMontlyRate(double montlyRate) {
			this.montlyRate = montlyRate;
		}
		public double getCoverageFGAPercentage() {
			return coverageFGAPercentage;
		}
		public void setCoverageFGAPercentage(double coverageFGAPercentage) {
			this.coverageFGAPercentage = coverageFGAPercentage;
		}
		public double getCoveragePlatformPercentage() {
			return coveragePlatformPercentage;
		}
		public void setCoveragePlatformPercentage(double coveragePlatformPercentage) {
			this.coveragePlatformPercentage = coveragePlatformPercentage;
		}
		public double getPlatform() {
			return platform;
		}
		public void setPlatform(double platform) {
			this.platform = platform;
		}
		public double getIva() {
			return iva;
		}
		public void setIva(double iva) {
			this.iva = iva;
		}
		public double getPeriodPlatform() {
			return periodPlatform;
		}
		public void setPeriodPlatform(double periodPlatform) {
			this.periodPlatform = periodPlatform;
		}
		public double getMaxSimpleDaysPastDue() {
			return maxSimpleDaysPastDue;
		}
		public void setMaxSimpleDaysPastDue(double maxSimpleDaysPastDue) {
			this.maxSimpleDaysPastDue = maxSimpleDaysPastDue;
		}
		public double getMinUtilizationValue() {
			return minUtilizationValue;
		}
		public void setMinUtilizationValue(double minUtilizationValue) {
			this.minUtilizationValue = minUtilizationValue;
		}
		public GeneralInformation() {
		}
		public GeneralInformation(int id, double yearRate, double montlyRate, double coverageFGAPercentage,
				double coveragePlatformPercentage, double platform, double iva, double periodPlatform,
				double maxSimpleDaysPastDue, double minUtilizationValue) {
			super();
			this.id = id;
			this.yearRate = yearRate;
			this.montlyRate = montlyRate;
			this.coverageFGAPercentage = coverageFGAPercentage;
			this.coveragePlatformPercentage = coveragePlatformPercentage;
			this.platform = platform;
			this.iva = iva;
			this.periodPlatform = periodPlatform;
			this.maxSimpleDaysPastDue = maxSimpleDaysPastDue;
			this.minUtilizationValue = minUtilizationValue;
		}
		@Override
		public String toString() {
			return "{\"id\":\"" + id + "\", \"yearRate\":\"" + yearRate + "\", \"montlyRate\":\"" + montlyRate
					+ "\", \"coverageFGAPercentage\":\"" + coverageFGAPercentage
					+ "\", \"coveragePlatformPercentage\":\"" + coveragePlatformPercentage + "\", \"platform\":\""
					+ platform + "\", \"iva\":\"" + iva + "\", \"periodPlatform\":\"" + periodPlatform
					+ "\", \"maxSimpleDaysPastDue\":\"" + maxSimpleDaysPastDue + "\", \"minUtilizationValue\":\""
					+ minUtilizationValue + "\"}";
		}

		
}

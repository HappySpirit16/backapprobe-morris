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
		@DynamoDBAttribute
		private double coverageFGAPercentageWALLET;
		@DynamoDBAttribute
		private double coveragePlatformPercentageWALLET;
		@DynamoDBAttribute
		private double platformWALLET;
		@DynamoDBAttribute
		private double installmentFee2Percentage;
		@DynamoDBAttribute
		private double ammountInstallmentFee2;
		@DynamoDBAttribute
		private double tasaxmillon;
		@DynamoDBAttribute
		private double tasaInvalidez;
		@DynamoDBAttribute
		private double tasaxVida;
		@DynamoDBAttribute
		private double ammountInsurance;
		@DynamoDBAttribute
		private double ammountTasaxPeso;
		@DynamoDBAttribute
		private double tasaxPerdida;
		@DynamoDBAttribute
		private double factorSeguro;
		@DynamoDBAttribute
		private double maxAge;
		@DynamoDBAttribute
		private double minAge;
		
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
		public double getCoverageFGAPercentageWALLET() {
			return coverageFGAPercentageWALLET;
		}
		public void setCoverageFGAPercentageWALLET(double coverageFGAPercentageWALLET) {
			this.coverageFGAPercentageWALLET = coverageFGAPercentageWALLET;
		}
		public double getCoveragePlatformPercentageWALLET() {
			return coveragePlatformPercentageWALLET;
		}
		public void setCoveragePlatformPercentageWALLET(double coveragePlatformPercentageWALLET) {
			this.coveragePlatformPercentageWALLET = coveragePlatformPercentageWALLET;
		}
		public double getPlatformWALLET() {
			return platformWALLET;
		}
		public void setPlatformWALLET(double platformWALLET) {
			this.platformWALLET = platformWALLET;
		}
		public GeneralInformation() {
		}

		
		public double getInstallmentFee2Percentage() {
			return installmentFee2Percentage;
		}
		public void setInstallmentFee2Percentage(double installmentFee2Percentage) {
			this.installmentFee2Percentage = installmentFee2Percentage;
		}
		public double getAmmountInstallmentFee2() {
			return ammountInstallmentFee2;
		}
		public void setAmmountInstallmentFee2(double ammountInstallmentFee2) {
			this.ammountInstallmentFee2 = ammountInstallmentFee2;
		}
		
		public double getTasaxmillon() {
			return tasaxmillon;
		}
		public void setTasaxmillon(double tasaxmillon) {
			this.tasaxmillon = tasaxmillon;
		}
		public double getTasaInvalidez() {
			return tasaInvalidez;
		}
		public void setTasaInvalidez(double tasaInvalidez) {
			this.tasaInvalidez = tasaInvalidez;
		}
		public double getTasaxVida() {
			return tasaxVida;
		}
		public void setTasaxVida(double tasaxVida) {
			this.tasaxVida = tasaxVida;
		}
		public double getAmmountTasaxPeso() {
			return ammountTasaxPeso;
		}
		public void setAmmountTasaxPeso(double ammountTasaxPeso) {
			this.ammountTasaxPeso = ammountTasaxPeso;
		}
		public double getAmmountInsurance() {
			return ammountInsurance;
		}
		public void setAmmountInsurance(double ammountInsurance) {
			this.ammountInsurance = ammountInsurance;
		}

		public double getTasaxPerdida() {
			return tasaxPerdida;
		}
		public void setTasaxPerdida(double tasaxPerdida) {
			this.tasaxPerdida = tasaxPerdida;
		}
		public double getFactorSeguro() {
			return factorSeguro;
		}
		public void setFactorSeguro(double factorSeguro) {
			this.factorSeguro = factorSeguro;
		}
		public double getMaxAge() {
			return maxAge;
		}
		public void setMaxAge(double maxAge) {
			this.maxAge = maxAge;
		}
		public double getMinAge() {
			return minAge;
		}
		public void setMinAge(double minAge) {
			this.minAge = minAge;
		}
	
		public GeneralInformation(int id, double yearRate, double montlyRate, double coverageFGAPercentage,
				double coveragePlatformPercentage, double platform, double iva, double periodPlatform,
				double maxSimpleDaysPastDue, double minUtilizationValue, double coverageFGAPercentageWALLET,
				double coveragePlatformPercentageWALLET, double platformWALLET, double installmentFee2Percentage,
				double ammountInstallmentFee2, double tasaxmillon, double tasaInvalidez, double tasaxVida,
				double ammountInsurance, double ammountTasaxPeso, double tasaxPerdida, double factorSeguro,
				double maxAge, double minAge) {
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
			this.coverageFGAPercentageWALLET = coverageFGAPercentageWALLET;
			this.coveragePlatformPercentageWALLET = coveragePlatformPercentageWALLET;
			this.platformWALLET = platformWALLET;
			this.installmentFee2Percentage = installmentFee2Percentage;
			this.ammountInstallmentFee2 = ammountInstallmentFee2;
			this.tasaxmillon = tasaxmillon;
			this.tasaInvalidez = tasaInvalidez;
			this.tasaxVida = tasaxVida;
			this.ammountInsurance = ammountInsurance;
			this.ammountTasaxPeso = ammountTasaxPeso;
			this.tasaxPerdida = tasaxPerdida;
			this.factorSeguro = factorSeguro;
			this.maxAge = maxAge;
			this.minAge = minAge;
		}
		@Override
		public String toString() {
			return "{\"id\":\"" + id + "\", \"yearRate\":\"" + yearRate + "\", \"montlyRate\":\"" + montlyRate
					+ "\", \"coverageFGAPercentage\":\"" + coverageFGAPercentage
					+ "\", \"coveragePlatformPercentage\":\"" + coveragePlatformPercentage + "\", \"platform\":\""
					+ platform + "\", \"iva\":\"" + iva + "\", \"periodPlatform\":\"" + periodPlatform
					+ "\", \"maxSimpleDaysPastDue\":\"" + maxSimpleDaysPastDue + "\", \"minUtilizationValue\":\""
					+ minUtilizationValue + "\", \"coverageFGAPercentageWALLET\":\"" + coverageFGAPercentageWALLET
					+ "\", \"coveragePlatformPercentageWALLET\":\"" + coveragePlatformPercentageWALLET
					+ "\", \"platformWALLET\":\"" + platformWALLET + "\"}";
		}
		
}
